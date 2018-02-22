package com.lazyman.pickupweb.course;

/**
 * Author chenxiaoqi on 2018/2/18.
 */
public class Result {

    public static final Result SUCCESS = new Result("0");

    private String code;

    private String message;

    public Result(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
