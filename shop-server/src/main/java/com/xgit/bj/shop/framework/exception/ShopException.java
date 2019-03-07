package com.xgit.bj.shop.framework.exception;

import com.xgit.bj.shop.framework.consts.ErrorCode;

public class ShopException extends RuntimeException {
    private static final long serialVersionUID = 2368925481129834020L;
    private int code;
    private Object value;

    public ShopException(String message) {
        super(message);
    }

    public ShopException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ShopException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }

    public ShopException(ErrorCode errorCode, Object value) {
        this(errorCode);
        this.value = value;
    }

    public ShopException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getDesc(), cause);
        this.code = errorCode.getCode();
    }

    public ShopException(ErrorCode errorCode, Object value, Throwable cause) {
        super(errorCode.getDesc(), cause);
        this.code = errorCode.getCode();
        this.value = value;
    }

    public int getCode() {
        return this.code;
    }

    public Object getValue() {
        return this.value;
    }
}
