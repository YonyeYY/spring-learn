/**
 * Copyright Hand China Co.,Ltd.
 */
package org.airyny.spring.learn.mybatis.pub.util;

/**
 * 基础响应对象
 * <p>
 * Created by xiaofeng.he on 2020/02/19
 *
 * @author xiaofeng.he
 */

public class ResultVO<T>  extends ExceptionResponse {

    /** 具体内容 */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
