package com.ward.studymoa.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 스터디모아 서비스에 가입한 회원의 이메일 인증 값을 저장하는 엔티티
 *
 * @since 2019. 07. 21
 * @version 1.00
 */
@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class EmailAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 36)
    private String authKey = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_idx", updatable = false, nullable = false)
    private StudyUser studyUser;

    @CreatedDate
    private LocalDateTime createdDate;
}
