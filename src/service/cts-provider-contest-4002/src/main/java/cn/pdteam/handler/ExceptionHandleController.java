package cn.pdteam.handler;

import cn.pdteam.exception.IllegalParticipationAuthorityException;
import cn.pdteam.pojo.CommonResult;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult globalExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return new CommonResult(500, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return new CommonResult(400, e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult illegalArgumentExceptionHandler(IllegalArgumentException e) {
        e.printStackTrace();
        return new CommonResult(400, e.getMessage());
    }

    @ExceptionHandler(IllegalParticipationAuthorityException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public CommonResult illegalParticipationAuthorityExceptionHandler(IllegalParticipationAuthorityException e) {
        e.printStackTrace();
        return new CommonResult(403, e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult duplicateKeyExceptionHandler(DuplicateKeyException e) {
        String message = e.getMessage();
        if (e.getMessage().contains("ix_contest_user")) {
            message = "该用户已报名比赛，不可重复报名";
        }
        return new CommonResult(400, message);
    }
}
