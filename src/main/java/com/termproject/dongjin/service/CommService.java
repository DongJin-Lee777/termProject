package com.termproject.dongjin.service;

import com.termproject.dongjin.domain.Comm;
import com.termproject.dongjin.domain.Time;
import com.termproject.dongjin.mapper.CommMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommService {
    @Autowired(required = false)
    CommMapper commMapper;

    // 댓글 리스트
    public ArrayList<Comm> commList(int bno) {
        return commMapper.commList(bno);
    }

    // 댓글 전체 리스트 페이지네이션
    public ArrayList<Comm> commAllList(Criteria criteria, int rowStart, int rowEnd) {
        return commMapper.commAllList(criteria, rowStart, rowEnd);
    };

    // 해당 유저 댓글 리스트 페이지네이션
    public ArrayList<Comm> commUserList(String id, Criteria criteria, int rowStart, int rowEnd) {
        return commMapper.commUserList(id, criteria, rowStart, rowEnd);
    };


    // 댓글 전체 개수
    public int commAllListCnt() {
        return commMapper.commAllListCnt();
    }

    // 해당 유저 댓글 개수
    public int commUserListCnt(String id) {
        return commMapper.commUserListCnt(id);
    }

    // 댓글 작성
    public void writeComm(Comm comm){
        commMapper.writeComm(comm);
    }

    // 댓글 수정
    public void editComm(Comm comm){
        commMapper.editComm(comm);
    }

    // 댓글 삭제
    public void deleteComm(int cno) {
        commMapper.deleteComm(cno);
    }

    // 시간별 게시판 업로드 수
    public ArrayList<Time> commTime() {
        return commMapper.commTime();
    }

    // 댓글 좋아요 증가
    public void commUp(int cno) {
        commMapper.commUp(cno);
    }

    // 댓글 재미있어요 증가
    public void commFun(int cno) {
        commMapper.commFun(cno);
    }

    // 댓글 똥 증가
    public void commDown(int cno) {
        commMapper.commDown(cno);
    }
}
