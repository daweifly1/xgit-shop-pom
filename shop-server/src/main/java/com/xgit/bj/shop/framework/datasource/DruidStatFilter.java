package com.xgit.bj.auth.user.infra.datasource;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = {"/*"}, initParams = {@javax.servlet.annotation.WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")})
public class DruidStatFilter
        extends WebStatFilter {
}
