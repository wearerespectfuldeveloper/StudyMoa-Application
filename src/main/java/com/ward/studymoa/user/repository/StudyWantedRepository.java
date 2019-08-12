/**
 * StudyWantedRepository.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.repository;

import com.ward.studymoa.user.domain.StudyWanted;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StudyWanted 엔티티의 Repository
 *
 * @since 2019. 08. 12
 * @version 1.00
 */
public interface StudyWantedRepository extends JpaRepository<StudyWanted, Long> {
}
