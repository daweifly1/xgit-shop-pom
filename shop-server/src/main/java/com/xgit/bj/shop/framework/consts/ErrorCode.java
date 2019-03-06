package com.xgit.bj.shop.framework.consts;

public enum ErrorCode implements com.xgit.bj.core.ErrorCode {
    Success(0, "操作成功"),
    Failure(1, "操作失败"),
    NeedLogin(2, "用户没有登录"),
    UnExceptedError(3, "未知的错误发生"),
    IllegalArument(4, "参数错误"),
    SQLIntegrityConstraintViolation(5, "系统数据库操作异常"),
    FailedToUpdateRecord(6, "更新记录失败"),
    FailedToInsertRecord(7, "新增记录失败");

    private String desc;
    private int code;

    private ErrorCode(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getCode() {
        return this.code;
    }
}
