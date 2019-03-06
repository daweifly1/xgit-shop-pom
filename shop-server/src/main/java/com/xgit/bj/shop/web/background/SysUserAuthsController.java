package com.xgit.bj.shop.web.background;

import com.xgit.bj.core.rsp.ActionResult;
import com.xgit.bj.shop.generic.facade.sys.UserAuthFacade;
import com.xgit.bj.shop.web.background.base.BasicController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SysAuths Controller 实现类
 */
@Slf4j
@RestController
@RequestMapping("/sysUserAuths")
public class SysUserAuthsController extends BasicController {
    @Autowired
    private UserAuthFacade userAuthFacade;

    @RequestMapping(value = {"/checkAuthCodes"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public ActionResult<Boolean> checkAuthCodes(@RequestParam(value = "userId", required = true) String userId, @RequestParam(value = "url", required = false) String url) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(url)) {
            return new ActionResult<>(false);
        }
        return actionResult(userAuthFacade.checkAuthCodes(userId, url));
    }


}
