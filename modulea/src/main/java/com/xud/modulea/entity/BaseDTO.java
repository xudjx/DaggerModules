package com.xud.modulea.entity;

import com.google.gson.Gson;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = -8237390826157320192L;

    public String toString()
    {
        return new Gson().toJson(this);
    }
}
