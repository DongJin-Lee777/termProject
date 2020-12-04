package com.termproject.dongjin.service;

import com.termproject.dongjin.domain.Comm;
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
}
