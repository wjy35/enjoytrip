package com.ssafy.enjoytrip.board.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class BoardRequestDto {
    @NotBlank(message = "제목을 입력해주세요.")
    private String subject;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    private String userId;
    private BoardType boardType;

    public Board toEntity() {
        return Board.builder()
                .subject(subject)
                .content(content)
                .userId(userId)
                .boardType(boardType)
                .build();
    }
}
