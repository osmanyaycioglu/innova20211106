package com.training.spring.order.models;


public class Message {

    private String dest;
    private String str;

    public String getDest() {
        return this.dest;
    }

    public void setDest(final String destParam) {
        this.dest = destParam;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(final String strParam) {
        this.str = strParam;
    }

    @Override
    public String toString() {
        return "Message [dest=" + this.dest + ", str=" + this.str + "]";
    }


}
