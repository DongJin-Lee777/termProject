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

    public ArrayList<Board> boardListAll() {
        System.out.println(boardMapper.boardListAll());
        return  boardMapper.boardListAll();
    }

    public ArrayList<Board> boardList(String category) {
        System.out.println(boardMapper.boardList(category));
        return boardMapper.boardList(category);
    }
}
