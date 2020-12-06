package com.termproject.dongjin.mapper;

import com.termproject.dongjin.domain.Users;
import com.termproject.dongjin.service.Criteria;

import java.util.ArrayList;

public interface UserMapper {
    void join(Users users); // 회원가입

    Users login(Users users); // 로그인

    void editUser(Users users); // 회원정보 수정

    String findPw(Users users); // 비밀번호 찾기

    ArrayList<Users>  userAuthList(Criteria criteria, int rowStart, int rowEnd); // 권한별 정렬 전체 유저 목록

    int userAllCnt(); // 전체 유저  수

    void editAuth(Users users); // 권한 변경
}
