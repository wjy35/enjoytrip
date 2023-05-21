package com.ssafy.enjoytrip.board.service;

import com.ssafy.enjoytrip.board.model.dto.FileInfo;

import java.util.List;


public interface FileService {
    int insertFile (int boardId, List<FileInfo> imageFiles);
}
