package com.haier.exception;

import com.haier.enums.StatusCodeEnum;
import com.haier.response.Result;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理
 * @Author: luqiwei
 * @Date: 2018/5/18 9:59
 */
@Slf4j
@ControllerAdvice
public class HryExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result getHryException(Exception e){
        if(e instanceof HryException){
            HryException hryException=(HryException) e;
            return ResultUtil.error(hryException.getCode(),hryException.getMessage());
        }
        log.error("【系统异常】",e);
        return ResultUtil.error(9999,e.toString());
    }
}
