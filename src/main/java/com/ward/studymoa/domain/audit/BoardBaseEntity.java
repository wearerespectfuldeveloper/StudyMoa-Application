package com.ward.studymoa.domain.audit;


import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BoardBaseEntity extends BaseEntity {

    @CreatedBy
    @Column(nullable = false, length = 20)
    protected String createdBy;

    public abstract void setCreatedBy();
}
