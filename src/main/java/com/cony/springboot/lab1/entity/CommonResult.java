package com.cony.springboot.lab1.entity;


import org.springframework.http.HttpStatus;

/**
 * 这个类主要用于数据的输出，并且将状态码和提示的信息以及获取的信息进行了封装
 * 屌！！！
 * @param <T>
 */

public class CommonResult<T> {
    private HttpStatus code;
    private T data;

    public CommonResult() {
    }

    public CommonResult(HttpStatus code, T data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }

    public CommonResult(HttpStatus code){
        this(code,null);
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
