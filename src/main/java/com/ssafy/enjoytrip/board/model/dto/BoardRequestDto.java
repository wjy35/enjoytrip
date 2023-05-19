package com.ssafy.enjoytrip.board.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class BoardRequestDto {
    private int boardId;
    @NotBlank(message = "제목을 입력해주세요.")
    private String subject;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    private String userId;
    private BoardType boardType;

    //첨부 파일
    private UploadFile attachFile;
    // 첨부이미지
    private List<UploadFile> imageFiles;

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Board toEntity() {
        return Board.builder()
                .boardId(boardId)
                .subject(subject)
                .content(content)
                .boardType(boardType)
                .userId(userId)
                .build();
    }
}
