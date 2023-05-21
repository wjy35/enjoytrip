package com.ssafy.enjoytrip.board.model.mapper;

import com.github.pagehelper.Page;
import com.ssafy.enjoytrip.board.model.dto.Board;
import com.ssafy.enjoytrip.board.model.dto.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    // ToDo 게시판 CRUD
    Optional<Board> selectBoard(int boardId);
    int insertBoard(Board board);
    int updateBoard(Board board);
    int deleteBoard(int boardId);
    int updateHit(int boardId);
    Page<Board> selectAll();
    int insertFile(int boardId, List<FileInfo> imageFiles);
}
