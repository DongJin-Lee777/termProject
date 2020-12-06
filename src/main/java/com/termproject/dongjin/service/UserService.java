package com.termproject.dongjin.service;

import com.termproject.dongjin.domain.Users;
import com.termproject.dongjin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    // 회원가입
    public void join(Users users) {
        System.out.println("user service : " + users.toString());
        userMapper.join(users);
    }

    // 로그인
    public Users login(Users users) {
        return userMapper.login(users);
    }

    // 회원정보 수정
    public void editUser(Users users) {
        userMapper.editUser(users);
    }

    // 비밀번호 찾기
    public String findPw(Users users) { return userMapper.findPw(users); }

    // 권한별 정렬 전체 유저 목록
    public ArrayList<Users> userAuthList(Criteria criteria,int rowStart, int rowEnd) {
      return userMapper.userAuthList(criteria, rowStart, rowEnd);
    };

    // 전체 유저 수
    public int userAllCnt() {
        return userMapper.userAllCnt();
    }

    // 권한 변경
    public void editAuth(Users users) {
        userMapper.editAuth(users);
    };
}
