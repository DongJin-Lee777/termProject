package com.termproject.dongjin.mapper;

import com.termproject.dongjin.domain.Comm;
import com.termproject.dongjin.domain.Time;
import com.termproject.dongjin.service.Criteria;

import java.util.ArrayList;

public interface CommMapper {
    // 댓글 리스트
    ArrayList<Comm> commList(int bno);

    // 댓글 전체 리스트 페이지네이션
    ArrayList<Comm> commAllList(Criteria criteria, int rowStart, int rowEnd);

    // 해당 유저 댓글 리스트 페이지네이션
    ArrayList<Comm> commUserList(String id, Criteria criteria, int rowStart, int rowEnd);

    // 댓글 전체 개수
    int commAllListCnt();

    // 해당 유저 댓글 개수
    int commUserListCnt(String id);

    // 댓글 작성
    void writeComm(Comm comm);

    // 댓글 수정
    void editComm(Comm comm);

    // 댓글 삭제
    void deleteComm(int cno);

    // 시간별 댓글 업로드 수
    ArrayList<Time> commTime();

    // 댓글 좋아요 증가
    void commUp(int cno);

    // 댓글 재미있어요 증가
    void commFun(int cno);

    // 댓글 똥 증가
    void commDown(int cno);
}
