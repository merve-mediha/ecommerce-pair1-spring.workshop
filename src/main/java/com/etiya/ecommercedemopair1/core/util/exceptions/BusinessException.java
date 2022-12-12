package com.etiya.ecommercedemopair1.core.util.exceptions;

//iş kuralları valid olmadığında fırlatılcak hata class ı
public class BusinessException extends RuntimeException{
    public  BusinessException(String message){
        super(message);
    }



}
