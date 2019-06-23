/**
 * BoardBaseEntity.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.domain.audit;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * 작성자를 기록하기 위한 Audit BoardBase Entity
 *
 * @author Chul Yun
 * @since 2019. 06. 22
 * @version 1.00
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BoardBaseEntity extends BaseEntity {

    @CreatedBy
    @Column(nullable = false, length = 20, updatable = false)
    protected String createdBy;

    public abstract void setCreatedBy();
}
