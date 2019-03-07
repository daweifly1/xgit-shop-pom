package com.xgit.bj.shop.web.background.base;

import com.xgit.bj.auth.feign.AuthClient;
import com.xgit.bj.auth.service.VO.sys.SysAccountVO;
import com.xgit.bj.core.rsp.ActionResult;
import com.xgit.bj.shop.framework.consts.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class BasicController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthClient authClient;

    public <T> ActionResult<T> actionResult(ErrorCode code, T value) {
        return new ActionResult(code.getCode(), code
                .getDesc(), value);
    }

    public <T> ActionResult<T> actionResult(T value) {
        ErrorCode code = ErrorCode.Success;
        return actionResult(code, value);
    }

    public <T> ActionResult<T> actionErrorResult(String errorMsg) {
        ErrorCode code = ErrorCode.Failure;
        return new ActionResult(code.getCode(), errorMsg, null);
    }

    public <T> ActionResult<T> actionErrorResult(int code, String errorMsg) {
        return new ActionResult(code, errorMsg, null);
    }

    public ActionResult actionResult(ErrorCode code) {
        return actionResult(code, null);
    }

    public String getUserId() {
        if (null == request) {
            log.error("request is null........................ ");
            return null;
        }
        String userId = request.getHeader("x-user-id");
        return userId;
    }

    public String getRemoteIp(HttpServletRequest request) {
        String userIp = request.getHeader("x-remote-ip");
        return userIp;
    }

    public SysAccountVO getSysAccountVO() {
        String userId = getUserId();
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        try {
            ActionResult<SysAccountVO> r = authClient.querySysAccountVO(userId);
            if (null != r && null != r.getValue()) {
                return r.getValue();
            }
        } catch (Exception e) {
            log.error("getSysAccountVO error.userId:{}", userId, e);
        }
        log.warn("getSysAccountVO warn.userId:{}", userId);
        return null;
    }
}
