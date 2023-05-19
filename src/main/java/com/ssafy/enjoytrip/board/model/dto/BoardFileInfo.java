package com.ssafy.enjoytrip.board.model.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BoardFileInfo {
    private int boardFileId;
    @NotNull (message = "boardID는 꼭 존재하여야 합니다.")
    private int boardId;
    private String fileName;
    private String filePath;
}
