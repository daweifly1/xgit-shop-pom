package com.xgit.bj.shop.framework.aop;


import com.xgit.bj.common.util.fastjson.FastJsonUtil;
import com.xgit.bj.core.rsp.ActionResult;
import com.xgit.bj.shop.framework.exception.ShopException;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Springboot自定义异常处理
 */
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Object invoke(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        if (e instanceof ClientAbortException) {
            log.warn("ClientAbortException url: {}, msg: {}", request.getRequestURI(), e.getMessage());
            // 浏览器已经关闭
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("发生错误，请联系开发解决");
            return null;
        }
        this.exceptionLog(e, request);
        if (e instanceof ShopException) {
            ActionResult view = new ActionResult(((ShopException) e).getCode(), e.getMessage());
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(FastJsonUtil.toJSONString(view));
            return null;
        }

//        // ajax请求
//        View view = View.wrapError("发生错误，请联系开发解决");
//        view.put("errorMsg", fullStackTrace);
        ActionResult view = new ActionResult(ErrorCode.Failure, e.getMessage());
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(FastJsonUtil.toJSONString(view));
        return null;
    }

    /**
     * 异常日志
     */
    private void exceptionLog(Exception e, HttpServletRequest request) {
        String parameters = FastJsonUtil.toJSONString(request.getParameterMap());
        String uri = request.getRequestURI();
        // 异常堆栈信息
        // 异常堆栈信息
//        String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
        log.error("element-ms系统异常,uri:{},parameters:{}", uri, parameters, e);
    }

}
