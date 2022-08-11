package controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;



//基于注解来处理异常信息

//将该类标记为异常处理的组件
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NullPointerException.class)
    public String handlerNullPointException(Throwable exception, HttpServletRequest request){
        request.setAttribute("exceptionMessage",exception.getMessage());
        return "error";
    }
}
