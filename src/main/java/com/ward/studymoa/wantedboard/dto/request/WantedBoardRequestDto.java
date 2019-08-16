/**
 * WantedBoardRequestDto.class
 * <p>
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.wantedboard.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 스터디 구해요의 게시판 모델 DTO
 *
 * @version 1.00
 * @since 2019. 08. 12
 */
@Getter
@NoArgsConstructor
public class WantedBoardRequestDto {

    private Long idx;
    private String wantedTitle;
    private String wantedDesc;
    private Long studyUserIdx;
}
