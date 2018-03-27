package com.xud.modulea.entity;

import java.util.List;

public class RestResultDTO<T> extends BaseDTO {

    public String msg;

    public List<T> result;

    public int retCode;

    public void setResult(List<T> result) {
        this.result = result;
    }

    public List<T> getResult() {
        return result;
    }

    public int getRetCode() {

        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
