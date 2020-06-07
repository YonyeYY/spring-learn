package org.airyny.spring.learn.mybatis.pub.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author xiang.yongye
 * @title: ExceptionResponse
 * @description: TODO
 * @date 2020/3/13  15:27
 */
public class ExceptionResponse {
    public static final String FILED_FAILED = "failed";
    private Boolean failed;
    private String code;
    private String message;
    private String type;
    private String exception;
    private String[] trace;
    private String[] throwable;

    public ExceptionResponse() {
        this.failed = true;
    }







    public ExceptionResponse(String code, String message, String type) {
        this(true, code, message, type);
    }

    public ExceptionResponse(boolean failed, String code, String message, String type) {
        this.failed = failed;
        this.code = code;
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return this.message;
    }

    public ExceptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public ExceptionResponse setType(String type) {
        this.type = type;
        return this;
    }

    public boolean getFailed() {
        return this.failed;
    }

    public ExceptionResponse setFailed(boolean failed) {
        this.failed = failed;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public ExceptionResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getException() {
        return this.exception;
    }

    public ExceptionResponse setException(String exception) {
        this.exception = exception;
        return this;
    }

    public String[] getTrace() {
        return this.trace;
    }

    @JsonIgnore
    public ExceptionResponse setTrace(StackTraceElement[] trace) {
        this.trace = ArrayUtils.toStringArray(trace);
        return this;
    }

    public String[] getThrowable() {
        return this.throwable;
    }

    public ExceptionResponse setThrowable(String message, StackTraceElement[] trace) {
        this.throwable = (String[])ArrayUtils.insert(0, ArrayUtils.toStringArray(trace), new String[]{message});
        return this;
    }
}
