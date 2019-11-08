package com.swalikh.kernel.exception;

import lombok.Data;

/**
 * Copyright @2018 nlelpct.
 * @author: 黄磊
 * date:  19-11-8  上午10:44
 * use to： 全局异常实体类
 * modify：
 */
@Data
public class GlobalException extends RuntimeException {

    private CodeMsg codeMsg;

    private Result result;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public GlobalException(Result result) {
        super();
        this.result = result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}