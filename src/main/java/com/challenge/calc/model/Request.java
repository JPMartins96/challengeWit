package com.challenge.calc.model;

import java.math.BigDecimal;

public class Request {

    private BigDecimal a;

    private BigDecimal b;

    public Request(String a, String b) {
        this.a = new BigDecimal(a);
        this.b = new BigDecimal(b);
    }

    public BigDecimal getA() {
        return a;
    }

    public BigDecimal getB() {
        return b;
    }
}
