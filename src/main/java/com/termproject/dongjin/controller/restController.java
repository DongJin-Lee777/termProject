package com.termproject.dongjin.controller;

import com.termproject.dongjin.domain.Board;
import com.termproject.dongjin.domain.Comm;
import com.termproject.dongjin.domain.Email;
import com.termproject.dongjin.domain.Users;
import com.termproject.dongjin.service.BoardService;
import com.termproject.dongjin.service.CommService;
import com.termproject.dongjin.service.EmailService;
import com.termproject.dongjin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class restController {
    @Autowired
    UserService userService;
    @Autowired
    BoardService boardService;
    @Autowired
    CommService commService;
    @Autowired
    EmailService emailService;

    // 회원가입
    @PostMapping("/rest/join")
    public void join(Users users) {
        System.out.println(users.toString());
        userService.join(users);
    }

    // 로그인
    @PostMapping("/rest/login")
    public Users login(Users users, HttpSession httpSession, Model model) {
        System.out.println("login : " + users.toString());
        System.out.println("login return : " + userService.login(users));
        httpSession.setAttribute("user", userService.login(users));
        httpSession.setAttribute("classCode", boardService.classCode(users.getEmail()));
        return userService.login(users);
    }

    // 비밀번호 찾기
    @PostMapping("/rest/findPw")
    public String findPw(Users user) {
        System.out.println("findPw : " + user.toString());
        System.out.println("findPw : " + userService.findPw(user));
        return userService.findPw(user);
    }

    // 로그아웃
    @PutMapping("/rest/logout")
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }

    // 회원정보 수정
    @PostMapping("/rest/editUser")
    public void editUser(Users user, HttpSession httpSession) {
        System.out.println(user.toString());
        userService.editUser(user);
        httpSession.invalidate();
    }

    @PostMapping("/rest/editAuth")
    public void editAuth(Users users) {
        System.out.println(users.toString());
        userService.editAuth(users);
    }
    // 글작성
    @PutMapping("/rest/writeBoard")
    public void write(Board board) {
        System.out.println("writeBoard : " + board.toString());
        boardService.writeBoard(board);
    }

    // 게시물 수정
    @PutMapping("/rest/editBoard")
    public void edit(Board board) {
        boardService.editBoard(board);
    }

    // 게시물 삭제
    @DeleteMapping("/rest/deleteBoard")
    public void deleteBoard(@RequestParam(defaultValue = "1") int bno) {
        boardService.deleteBoard(bno);
    }

    // 댓글 등록
    @PutMapping("/rest/writeComm")
    public void writeComm(Comm comm) {
        commService.writeComm(comm);
    }

    // 댓글 수정
    @PutMapping("/rest/editComm")
    public void editComm(Comm comm) {
        commService.editComm(comm);
    }

    // 댓글 삭제
    @DeleteMapping("/rest/deleteComm")
    public void deleteComm(@RequestParam(defaultValue = "1") int cno) {
        commService.deleteComm(cno);
    }

    // 게시물 좋아요 증가
    @PutMapping("/rest/up")
    public void up(@RequestParam(defaultValue = "1") int bno) {
        boardService.up(bno);
    }

    // 게시물 좋아요 하락
    @PutMapping("/rest/down")
    public void down(@RequestParam(defaultValue = "1") int bno) {
        boardService.down(bno);
    }

    // 댓글 좋아요 증가
    @PutMapping("/rest/commUp")
    public void commUp(@RequestParam(defaultValue = "1") int cno) {
        commService.commUp(cno);
    }

    // 댓글 재미있어요 증가
    @PutMapping("/rest/commFun")
    public void commFun(@RequestParam(defaultValue = "1") int cno) {
        commService.commFun(cno);
    }

    // 댓글 똥 증가
    @PutMapping("/rest/commDown")
    public void commDown(@RequestParam(defaultValue = "1") int cno) {
        commService.commDown(cno);
    }

    // 메일 전송
    @PostMapping("/rest/email")
    public void sendMail(Email email) throws Exception { // 이메일시 무조건 exception처리
        emailService.sendSimpleMessage(email.getUserEmail());
    }

    // 인증 코드
    @PostMapping("/rest/confirm")
    public int confirm(Email email) {
        if (EmailService.ePw.equals(email.getConfirm())) {
            return EmailService.CONFIRM;
        } else {
            return EmailService.REJECT;
        }
    }
}
