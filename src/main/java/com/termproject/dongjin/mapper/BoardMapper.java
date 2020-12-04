package com.termproject.dongjin.mapper;

import com.termproject.dongjin.domain.Board;
import com.termproject.dongjin.service.Criteria;

import java.util.ArrayList;

public interface BoardMapper {
    // 모든 게시판 리스트 호출
    ArrayList<Board> boardListAll();

    // 게시판 리스트 호출
    ArrayList<Board> boardList(String category, Criteria criteria);

    // 게시판 개수
    int boardListCnt(String category);

    // 게시물 조회
    Board board(int bno);

    // 반 게시판 이름
    String classCode(String email);

    // 게시물 작성
    void writeBoard(Board board);

    // 게시물 수정
    void editBoard(Board board);

    // 게시물 삭제
    void deleteBoard(int bno);

    // 조회수 증가
    void visit(int bno);

    // 좋아요 증가
    void up(int bno);

    // 좋아요 하락
    void down(int bno);
}
