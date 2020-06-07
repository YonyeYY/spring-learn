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
 * @title: FieldUtil
 * @description: TODO
 * @date 2020/3/13  15:27
 */
public class FieldUtil {

    public static void main(String[] args)throws Exception{
        Target target = new Target();

        Temp temp = new Temp();
        temp.setLineNo("1");
//        temp.setC1("name");
//        temp.setC2(new Date());
//        temp.setC3("123");
//        temp.setC4("123.123123123");

        Class clazz=target.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for (Field field :fields){
            System.out.println(field.getName());
        }


        System.out.println("========");


        ResultVO resultVO = getFields(temp,target);
        String message = resultVO.getMessage();
        if (!"".equals(message)){
            message += "LineNo:"+temp.getLineNo();
            resultVO.setMessage(message);
        }

        resultVO.getData();



//        target = (Target)invokeMethod(target, "name", false);
//        System.out.println(target.toString());
//        for (Field field : fields) {
//
//
//
//            try {
//                invokeMethod(target, field.getName(), false,field.getType(),"123");
//                System.out.println(target.toString());
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }

    }

    /**
     *
     * @param source 临时表对象
     * @param target 业务接口表对象
     * @return
     * @throws NotFoundException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static ResultVO getFields(Object source, Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,ParseException{
        ResultVO resultVO = new ResultVO();
        String massage = "";
        Class clazz=target.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for (Field field : fields) {
            IFaceProperty iFaceProperty = field.getAnnotation(IFaceProperty.class);
            if(null !=iFaceProperty){
                String tempField = iFaceProperty.desc();
                boolean requiredFlag = iFaceProperty.required();
                Object fieldValue = invokeMethod(source, tempField, true,field.getType(),null);
                if (requiredFlag){
                    if (null == fieldValue){
                        massage += field.getName() + "：为空；";
                    }
                }
                invokeMethod(target, field.getName(), false,field.getType(),fieldValue);

                resultVO.setData(target);
            }
        }
        resultVO.setMessage(massage);
        return resultVO;
    }

    /**
     *
     * @param target
     * @param fieldname
     * @param action [true 执行get方法，false 执行set 方法]
     * @param args
     * @return
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static Object invokeMethod(Object target, String fieldname, boolean action,
                                       Class<?> typeClass,Object value) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException, ParseException {
        Class targetClass = target.getClass();

        Method method = null;
        Object object = null;
        if (action){
            method = targetClass.getMethod(toGetter(fieldname));
            object = method.invoke(target);
        }else {
            if (null != value){
                method = targetClass.getMethod(toSetter(fieldname),typeClass);

                Object data = transitionData(value,typeClass);

                object = method.invoke(target,data);
            }
        }
        return object;
    }

    /**
     * 类型转换
     * @param value
     * @param typeClass
     * @return
     * @throws ParseException
     */
    private static Object transitionData(Object value,Class<?> typeClass) throws ParseException{
        Object object = null;
        Class<?> clazz = value.getClass();
        if (clazz == typeClass){
            object = value;
        }else {
            if (typeClass == String.class){
                object = value.toString();
            }
            else if (typeClass == Date.class){
                SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format3.parse(value.toString());
                object = date;
            }
            else if (typeClass == BigDecimal.class){
                object = new BigDecimal(value.toString());
            }
            else if (typeClass == Long.class){
                object = new Long(value.toString());
            }
        }

        return object;
    }

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
        return  fieldname;
    }

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
        return  fieldname;
    }


}
