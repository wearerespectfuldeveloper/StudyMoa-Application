/**
 * JpaAuditConfig.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Entity의 작성일, 수정일 등 정보를 Auditing 하기 위한 설정 클래스
 *
 * @since 2019. 06. 22
 * @version 1.00
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
