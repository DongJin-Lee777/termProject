package com.termproject.dongjin.service;

import com.termproject.dongjin.domain.Board;
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

    // 각 게시판 리스트
    public ArrayList<Board> boardList(String category, Criteria criteria) {
        System.out.println(criteria.toString());
        return boardMapper.boardList(category, criteria);
    }

    // 게시판 개수
    public int boardListCnt(String category) {
      return boardMapper.boardListCnt(category);
    };

    // 반 게시판 이름
    public String classCode(String email) {
        return boardMapper.classCode(email);
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
}
