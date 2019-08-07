/**
 * StudyUserRepository.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.repository;

import com.ward.studymoa.user.domain.StudyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * StudyUser 엔티티의 Repository
 *
 * @since 2019. 07. 21
 * @version 1.00
 */
public interface StudyUserRepository extends JpaRepository<StudyUser, Long> {

    Optional<StudyUser> findByUserId(String userId);
    Boolean existsByUserId(String id);
    Boolean existsByEmail(String email);
}
