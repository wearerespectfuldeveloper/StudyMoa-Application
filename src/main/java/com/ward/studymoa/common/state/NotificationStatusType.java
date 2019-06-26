/**
 * NotificationStatusType.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.common.state;

/**
 * 스터디 그룹 참여, 초대 신청에 대한 상태 정보 Enum
 *
 * @author Chul Yun
 * @since 2019. 06. 23
 * @version 1.00
 */
public enum NotificationStatusType {

    WATING("wating"),
    ACCEPT_CHK("accept_chk"),
    ACCEPT_UNCHK("accept_unchk"),
    REJECT_CHK("reject_chk"),
    REJECT_UNCHK("reject_unchk");

    private String statusType;

    private NotificationStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusType() {
        return statusType;
    }
}
