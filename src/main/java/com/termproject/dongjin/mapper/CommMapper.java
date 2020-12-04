package com.termproject.dongjin.mapper;

import com.termproject.dongjin.domain.Comm;

import java.util.ArrayList;

public interface CommMapper {
    // 댓글 리스트
    ArrayList<Comm> commList(int bno);

    // 댓글 작성
    void writeComm(Comm comm);

    // 댓글 수정
    void editComm(Comm comm);

    // 댓글 삭제
    void deleteComm(int cno);
}
