package com.ssafy.enjoytrip.board.service;

import com.ssafy.enjoytrip.board.model.dto.FileInfo;
import com.ssafy.enjoytrip.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final BoardMapper boardMapper;
    @Override
    public int insertFile(int boardId, List<FileInfo> imageFiles) {
        imageFiles.forEach(fileInfo -> fileInfo.setBoardId(boardId));
        return boardMapper.insertFile(boardId, imageFiles);
    }

    @Override
    public List<FileInfo> selectFile(int boardId) {
        return boardMapper.selectFile(boardId);
    }

}
