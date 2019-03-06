package com.xgit.bj.auth.feign;

import com.xgit.bj.auth.feign.fallback.AuthClientFallBack;
import com.xgit.bj.core.rsp.ActionResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${auth.feign.name:fast-auth-server-cdw}", fallback = AuthClientFallBack.class)
public interface AuthClient {

    @RequestMapping(
            value = {"/scepter/getAuthCodes"},
            method = {RequestMethod.GET}
    )
    ActionResult<List<String>> getAuthCodes(@RequestParam(value = "userId", required = false) String userId, @RequestHeader("x-user-id") String selfUserId);

    @RequestMapping(
            value = {"/sysUserAuths/checkAuthCodes"},
            method = {RequestMethod.GET}
    )
    ActionResult<Boolean> checkAuthCodes(@RequestParam(value = "userId", required = false) String userId, @RequestParam(value = "url", required = false) String url);

}
