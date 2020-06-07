package org.airyny.spring.learn.mybatis.pub.util;

import javassist.NotFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author xiang.yongye
 * @title: FieldPojoUtils
 * @description: TODO
 * @date 2020/3/13  13:26
 */

public class FieldPojoUtils {

    public static final String ACTION_GET = "get";
    public static final String ACTION_SET = "set";

    private FieldPojoUtils() {
    }

    public  static void main(String[] args)throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException{
        Target target = new Target();

        Temp temp = new Temp();
        temp.setLineNo("1");
        temp.setC1("name");
        Object fieldValue = invokeMethod(temp, "", ACTION_GET, String.class, null);

//        temp.setC2(new Date());
//        temp.setC3("123");
//        temp.setC4("123.123123123");

        Class clazz=target.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for (Field field :fields){
            System.out.println(field.getName());
        }


        System.out.println("========");


        ResultVO resultVO = getImportFields(temp,target);
        String message = resultVO.getMessage();
        if (!"".equals(message)){
            message += "LineNo:"+temp.getLineNo();
            resultVO.setMessage(message);
        }

        resultVO.getData();

    }



    /**
     * source 对象的值 转换到 target 对象
     *
     * @param source 资源对象
     * @param target 目标对象
     * @return
     * @throws NotFoundException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static ResultVO getImportFields(Object source, Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {
        ResultVO resultVO = ResultVOUtil.success();
        Object fieldValue = null;
        Class clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            IFaceProperty iFaceProperty = field.getAnnotation(IFaceProperty.class);
            if (null != iFaceProperty) {
                String tempField = iFaceProperty.desc();
                //从资源对象获取指定的属性值
                fieldValue = invokeMethod(source, tempField, ACTION_GET, field.getType(), null);
                if (null != fieldValue) {
                    invokeMethod(target, field.getName(), ACTION_SET, field.getType(), fieldValue);
                }
            }
        }
        resultVO.setData(target);
        return resultVO;
    }

    /**
     *校验必输字段在资源对象是否有值
     * @param source 资源对象
     * @param target 目标对象
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public static ResultVO fieldsValidate(Object source, Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {
        ResultVO resultVO = ResultVOUtil.success();
        String massage = "";
        Object fieldValue = null;
        Class clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            IFaceProperty iFaceProperty = field.getAnnotation(IFaceProperty.class);
            //ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);

            if (null != iFaceProperty) {
                String tempField = iFaceProperty.desc();
                fieldValue = invokeMethod(source, tempField, ACTION_GET, field.getType(), null);
                if (iFaceProperty.required() && null == fieldValue) {
                    resultVO.setFailed(true);
                    massage += field.getName() + "：requried；";
                }
            }
//            if (null != apiModelProperty && apiModelProperty.required() && null == fieldValue){
//                massage += field.getName() + "：database.requried；";
//                resultVO.setFailed(true);
//            }
        }
        resultVO.setMessage(massage);
        return resultVO;
    }


    /**
     * 反射调用get/set 方法
     *
     * @param target
     * @param fieldname
     * @param action    [true 执行get方法，false 执行set 方法]
     * @param value     方法参数
     * @return
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static Object invokeMethod(Object target, String fieldname, String action,
                                       Class<?> typeClass, Object value) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException, ParseException {
        Class targetClass = target.getClass();

        Method method = null;
        Object object = null;
        if (ACTION_GET.equals(action)) {
            method = targetClass.getMethod(toGetter(fieldname));
            object = method.invoke(target);
        } else {
            if (null != value) {
                method = targetClass.getMethod(toSetter(fieldname), typeClass);

                Object data = transitionData(value, typeClass);

                object = method.invoke(target, data);
            }
        }
        return object;
    }

    /**
     * 类型转换
     *
     * @param value     需要转换的值
     * @param typeClass 需要转换成的目标类型
     * @return
     * @throws ParseException
     */
    private static Object transitionData(Object value, Class<?> typeClass) throws ParseException {
        Object object = null;
        Class<?> clazz = value.getClass();
        if (clazz == typeClass) {
            object = value;
        } else {
            if (clazz == Long.class) {
                value = value.toString();
            }
            if (clazz == BigDecimal.class) {
                value = value.toString();
            }
            if (value.getClass() == String.class) {
                if (typeClass == String.class) {
                    object = value.toString();
                } else if (typeClass == Date.class) {
                    SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = format3.parse(value.toString());
                    object = date;
                } else if (typeClass == BigDecimal.class) {
                    object = new BigDecimal(value.toString());
                } else if (typeClass == Long.class) {
                    object = new Long(value.toString());
                }
            }else{
                //log.error("field.pojo.transition.data.error");
            }


        }
        return object;
    }


    /**
     * 获取get 方法名
     *
     * @param fieldname
     * @return
     */
    private static String toGetter(String fieldname) {

        if (fieldname == null || fieldname.length() == 0) {
            return null;
        }

        /* If the second char is upper, make 'get' + field name as getter name. For example, eBlog -> geteBlog */
        if (fieldname.length() > 2) {
            String second = fieldname.substring(1, 2);
            if (second.equals(second.toUpperCase())) {
                return new StringBuffer("get").append(fieldname).toString();
            }
        }

        /* Common situation */
        fieldname = new StringBuffer("get").append(fieldname.substring(0, 1).toUpperCase())
                .append(fieldname.substring(1)).toString();
        System.out.println(fieldname);
        return fieldname;
    }


    /**
     * 获取set 方法名
     *
     * @param fieldname
     * @return
     */
    private static String toSetter(String fieldname) {

        if (fieldname == null || fieldname.length() == 0) {
            return null;
        }

        /* If the second char is upper, make 'get' + field name as getter name. For example, eBlog -> geteBlog */
        if (fieldname.length() > 2) {
            String second = fieldname.substring(1, 2);
            if (second.equals(second.toUpperCase())) {
                return new StringBuffer("set").append(fieldname).toString();
            }
        }

        /* Common situation */
        fieldname = new StringBuffer("set").append(fieldname.substring(0, 1).toUpperCase())
                .append(fieldname.substring(1)).toString();
        System.out.println(fieldname);
        return fieldname;
    }

}
