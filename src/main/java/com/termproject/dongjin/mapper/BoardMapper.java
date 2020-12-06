package com.termproject.dongjin.mapper;

import com.termproject.dongjin.domain.Board;
import com.termproject.dongjin.domain.Time;
import com.termproject.dongjin.service.Criteria;

import java.util.ArrayList;

public interface BoardMapper {
    // 모든 게시판 리스트 호출
    ArrayList<Board> boardListAll();

    // 모든 게시판 리스트 호출 (페이지네이션)
    ArrayList<Board> boardListAllPage(Criteria criteria,int rowStart, int rowEnd);

    // 게시판 리스트 호출 - 카테고리
    ArrayList<Board> boardList(String category, Criteria criteria,int rowStart, int rowEnd);

    // 게시판 리스트 호출 - 아이디
    ArrayList<Board> boardUserList(String id, Criteria criteria,int rowStart, int rowEnd);

    // 게시판 개수
    int boardListCnt(String category);

    // 전체게시판 개수
    int boardAllListCnt();

    // 해당 유저 게시판 개수
    int boardUserListCnt(String id);

    // 게시물 조회
    Board board(int bno);

    // 게시판 코드
    String classCode(String email);

    // 게시판 이름
    String className(String category);

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

    // 시간별 게시판 업로드 수
    ArrayList<Time> boardTime();
}
