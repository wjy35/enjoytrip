package com.ssafy.enjoytrip.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    @NotBlank(message = "게시글 입력이 비어있습니다.")
    private int boardId;
    @NotBlank(message = "유저 입력이 비어있습니다.")
    private String userId;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .boardId(boardId)
                .userId(userId)
                .content(content)
                .build();
    }

}
