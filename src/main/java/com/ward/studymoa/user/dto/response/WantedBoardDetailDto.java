/**
 * WantedBoardDetailDto.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 스터디 구해요 게시물 조회 결과 응답 객체
 *
 * @version 1.0.0
 * @since 2019. 08. 15
 */
@Data
@NoArgsConstructor
public class WantedBoardDetailDto {

    private Long idx;
    private String wantedTitle;
    private String wantedDesc;
    private String createdBy;
    private String createdDate;
}
