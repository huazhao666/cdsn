package com.huazhao.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-08
 * Time : 10:38
 */
//自定义异常，保存错误码和错误信息；
@Getter
@Setter
public class AppException extends RuntimeException{

    private String code;
    private String message;

    public AppException( String code,String message) {
        //super(message);
        this.code = code;
        this.message = message;
    }

    public AppException( String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
