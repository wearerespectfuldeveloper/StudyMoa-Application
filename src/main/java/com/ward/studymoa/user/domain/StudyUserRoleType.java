/**
 * StudyUser.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.domain;

/**
 * 스터디 유저의 이메일 인증 여부 타입
 *
 * @since 2019. 07. 17
 * @version 1.00
 */
public enum StudyUserRoleType {

    ROLE_NON_AUTH_USER("non_auth_user"),
    ROLE_AUTH_USER("auth_user");

    private String roleType;

    private StudyUserRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return this.roleType;
    }
}
