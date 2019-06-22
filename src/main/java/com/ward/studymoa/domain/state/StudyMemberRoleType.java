/**
 * StudyMemberRoleType.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain.state;

/**
 * 스터디 그룹 멤버의 역할 정의 Enum
 *
 * @author Chul Yun
 * @since 2019. 06. 23
 * @version 1.00
 */
public enum StudyMemberRoleType {
    OWNER("owner"),
    MANAGER("manager"),
    MEMBER("member");

    private String roleType;

    private StudyMemberRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
