package com.termproject.dongjin.mapper;

import com.termproject.dongjin.domain.Board;

import java.util.ArrayList;

public interface BoardMapper {

    // 모든 게시판 리스트 호출
    ArrayList<Board> boardListAll();

    // 게시판 리스트 호출
    ArrayList<Board> boardList(String category);
}
