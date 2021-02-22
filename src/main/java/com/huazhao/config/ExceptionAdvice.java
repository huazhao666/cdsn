package com.huazhao.config;

import com.huazhao.exception.AppException;
import com.huazhao.model.JSONResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;



/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-08
 * Time : 10:10
 */

/**
 * @ControllerAdvice 方法里面要用写@ResponseBody
 * @RestControllerAdvice 方法里面不用写@ResponseBody
 */
//这个是用来处理异常；
@ControllerAdvice
@Slf4j //使用lombok日志注解，可以直接使用log属性，完日志打印
public class ExceptionAdvice {
    @ExceptionHandler(AppException.class)
    @ResponseBody //这个必须要有，不然访问不到；那个有问题的url;因为没有RestController
    public Object handle(AppException e) {//方法参数即为捕获到的异常
        JSONResponse js = new JSONResponse();
        //自定义异常报错错误码和错误消息；
        js.setSuccess(false);//默认是false，
        js.setCode(e.getCode()); // 这里的异常是自定义异常处理；
        js.setMessage(e.getMessage());
        //log.debug(transfer(e));//打印日志程序员自己看
        log.debug("自定义异常",e);//更加跨界
        return js;
    }
    //这个是非自定义异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle2(Exception e) {//方法参数即为捕获到的异常
        JSONResponse js = new JSONResponse();
        //非自定义异常(英文信息，不能给用户看)，指定一个错误码，和错误消息(未知错误，请联系管理员)
        js.setSuccess(false);//默认是false，
        js.setCode("ERROR"); //
        js.setMessage("未知错误，请联系管理员");
        //log.debug(transfer(e));//
        //log.debug("未知错误",e);
        log.error("未知错误",e);
        return js;
    }
    //idea上打印日志；
    public String transfer(Exception e){
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw,true);
        e.printStackTrace(writer);//打印堆栈异常到PW;
        return sw.toString();
    }
}
