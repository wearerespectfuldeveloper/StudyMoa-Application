package com.ward.studymoa.common.state;

public enum SocialType {
    GOOGLE("google"),
    NAVER("naver");

    private String name;

    private SocialType(String name) {
        this.name = name;
    }

    public String getSocialType() {
        return this.name;
    }

    public boolean isEquals(String authority) {
        return this.getSocialType().equals(authority);
    }
}
