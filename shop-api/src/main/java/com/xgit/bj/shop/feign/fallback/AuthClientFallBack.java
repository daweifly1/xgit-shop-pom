package com.xgit.bj.auth.feign.fallback;

import com.xgit.bj.auth.feign.AuthClient;
import com.xgit.bj.core.rsp.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class AuthClientFallBack implements AuthClient {
    @Override
    public ActionResult<List<String>> getAuthCodes(String userId, String selfUserId) {
        log.warn("com.xgit.bj.auth.feign.AuthClient.getAuthCodes 方法熔断，userId：{}，", userId);
        return new ActionResult<>(null);
    }

    @Override
    public ActionResult<Boolean> checkAuthCodes(String userId, String url) {
        log.warn("com.xgit.bj.auth.feign.AuthClient.checkAuthCodes 方法熔断，userId：{}，url：{}", userId, url);
        return new ActionResult<>(false);
    }
}
