/**
 * Copyright Hand China Co.,Ltd.
 */
package org.airyny.spring.learn.mybatis.pub.util;

/**
 * 响应对象工具类
 * <p>
 * Created by xiaofeng.he on 2020/02/19
 *
 * @author xiaofeng.he
 */
public class ResultVOUtil {

    /**
     * 私有化构造方法，不允许工具类实例化
     */
    private ResultVOUtil() {
        throw new AssertionError();
    }

    public static <T extends Object> ResultVO<T> success (T t) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setData(t);
        resultVO.setFailed(Boolean.FALSE);

        return resultVO;
    }

    public static <T extends Object> ResultVO<T> success () {
        return success(null);
    }


    public static <T extends Object> ResultVO<T> error (String msg) {
        return error(null, msg, null);
    }

    public static <T extends Object> ResultVO<T> error (String code, String msg) {
        return error(code, msg, null);
    }

    public static <T extends Object> ResultVO<T> error (String code, String msg,  T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setFailed(Boolean.TRUE);
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        resultVO.setData(data);

        return resultVO;
    }
}
