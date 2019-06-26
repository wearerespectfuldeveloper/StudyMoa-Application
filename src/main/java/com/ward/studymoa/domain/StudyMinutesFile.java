/**
 * StudyMinutesFile.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain;

import com.ward.studymoa.common.audit.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 스터디 그룹의 스터디 진행 기록 첨부파일 Entity
 *
 * @since 2019. 06. 23
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
public class StudyMinutesFile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "minutes_idx", updatable = false, nullable = false)
    private StudyMinutes studyMinutes;

    @Column(length = 50, nullable = false)
    private String url;
}
