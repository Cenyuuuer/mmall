package com.mmall.common;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {//T代表响应里边要封装的数据对象
    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }
    //如果传参数data为string，也会调用这个方法
    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }
    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getState(){
        return this.status;
    }

    public T getData(){
        return this.data;
    }

    public String getMsg(){
        return this.msg;
    }
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>((ResponseCode.SUCCESS.getCode()));
    }
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>((ResponseCode.SUCCESS.getCode()),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>((ResponseCode.SUCCESS.getCode()),data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

}
