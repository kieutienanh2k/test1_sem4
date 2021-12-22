package com.example.test1.model;

public class BaseResponse<T> {
    public int status = 1;
    public String message = "Success";
    public T data;
}
