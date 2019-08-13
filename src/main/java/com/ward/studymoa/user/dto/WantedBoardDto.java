/**
 * WantedBoardDto.class
 *
 * Copyright (c) 2019 WARD.
 */
package com.ward.studymoa.user.dto;

import lombok.Data;

/**
 * 스터디 구해요의 게시판 모델 DTO
 *
 * @since 2019. 08. 12
 * @version 1.00
 */
@Data
public class WantedBoardDto {

    private Long idx;
    private String wantedTitle;
    private String wantedDesc;
}
