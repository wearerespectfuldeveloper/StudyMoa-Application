/**
 * StudyGroupInvite.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.group.domain;


import com.ward.studymoa.common.audit.BaseEntity;
import com.ward.studymoa.user.domain.StudyUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹 초대 신청에 대한 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyGroupInvite extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "group_idx", nullable = false, updatable = false)
    private StudyGroup studyGroup;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false, updatable = false)
    private StudyUser studyUser;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(20)", nullable = false)
    private NotificationStatusType notificationStatusType = NotificationStatusType.WATING;
}
