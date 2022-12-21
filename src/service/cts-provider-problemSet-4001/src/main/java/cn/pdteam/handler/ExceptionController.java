package cn.pdteam.handler;

import cn.pdteam.pojo.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult globalExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return new CommonResult(500, exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult illegalArgumentExceptionHandler(IllegalArgumentException e) {
        e.printStackTrace();
        return new CommonResult(400, e.getMessage());
    }
}
