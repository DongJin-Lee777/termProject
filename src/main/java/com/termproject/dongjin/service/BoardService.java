package com.termproject.dongjin.service;

import com.termproject.dongjin.domain.Board;
import com.termproject.dongjin.domain.Time;
import com.termproject.dongjin.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired(required = false)
    BoardMapper boardMapper;

    // 타임라인
    public ArrayList<Board> boardListAll() {
        return boardMapper.boardListAll();
    }

    public ArrayList<Board> boardListAllPage(Criteria criteria,int rowStart, int rowEnd) {
        return boardMapper.boardListAllPage(criteria,rowStart,rowEnd);
    };

    // 각 게시판 리스트 - 카테고리
    public ArrayList<Board> boardList(String category, Criteria criteria,int rowStart, int rowEnd) {
        return boardMapper.boardList(category, criteria,rowStart,rowEnd);
    }

    // 게시판 리스트 - 아이디
    public ArrayList<Board> boardUserList(String id, Criteria criteria,int rowStart, int rowEnd) {
        return boardMapper.boardUserList(id, criteria, rowStart, rowEnd);
    };

    // 게시판 개수
    public int boardListCnt(String category) {
      return boardMapper.boardListCnt(category);
    };

    // 해당 유저 게시판 개수
    public  int boardUserListCnt(String id) {
        return boardMapper.boardUserListCnt(id);
    }

    // 전체게시판 개수
    public int boardAllListCnt() {
        return boardMapper.boardAllListCnt();
    };

    // 게시판 코드
    public String classCode(String email) {
        return boardMapper.classCode(email);
    }

    // 게시판 이름
    public String className(String category) {
        return boardMapper.className(category);
    }

    // 게시물 조회
    public Board board(int bno) {
        return boardMapper.board(bno);
    }

    // 게시물 작성
    public void writeBoard(Board board) {
        boardMapper.writeBoard(board);
    }

    // 게시물 수정
    public void editBoard(Board board) {
        boardMapper.editBoard(board);
    }

    // 게시물 삭제
    public void deleteBoard(int bno) {
        boardMapper.deleteBoard(bno);
    }

    // 조회수 증가
    public void visit(int bno) {
        boardMapper.visit(bno);
    }

    // 좋아요 증가
    public void up(int bno) {
        boardMapper.up(bno);
    }

    // 좋아요 하락
    public void down(int bno) {
        boardMapper.down(bno);
    }

    // 시간별 게시판 업로드 수
    public ArrayList<Time> boardTime() {
        return boardMapper.boardTime();
    };
}
