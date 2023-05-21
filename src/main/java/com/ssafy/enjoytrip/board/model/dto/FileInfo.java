package com.ssafy.enjoytrip.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class FileInfo {
    private int FileInfoId;

    @NotNull(message = "boardID는 꼭 존재하여야 합니다.")
    private int boardId;

    private String uploadFileName;
    private String storeFileName;
    private String filePath;

    public FileInfo() {
    }


    public FileInfo(String uploadFileName, String storeFileName, String filePath) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
        this.filePath = filePath;
    }
}
