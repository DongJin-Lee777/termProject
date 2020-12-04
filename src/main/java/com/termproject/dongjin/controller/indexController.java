package com.termproject.dongjin.controller;

import com.termproject.dongjin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {
    @Autowired
    UserService userService;
    @Autowired
    BoardService boardService;
    @Autowired
    CommService commService;

    // 초기 화면 timeline
    @GetMapping("/")
    public String index(Model model) {
        System.out.println("boardListAll : " + boardService.boardListAll());
        model.addAttribute("boardList", boardService.boardListAll());
        return "index";
    }

    // 게시판 목록
    @GetMapping("/boardList")
    public String noticeList(Model model, @RequestParam(defaultValue = "0") String category, Criteria criteria, @RequestParam(defaultValue = "1") int page) {
        Pagination pagination = new Pagination(boardService.boardListCnt(category), page, 10);
        criteria.setBno(Integer.parseInt(category));
        criteria.setPage(pagination.getPage());
        criteria.setPerPageNum(pagination.getPageSize());
        System.out.println(criteria.toString());
        System.out.println("boardList : " + boardService.boardList(category, criteria));
        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardService.boardList(category, criteria));
        return "BoardList";
    }

    // 게시물 조회
    @GetMapping("/board/{bno}")
    public String getBoard(Model model, @PathVariable int bno) {
        System.out.println("board : " + boardService.board(bno));
        System.out.println("commList : " + commService.commList(bno));
        model.addAttribute("board", boardService.board(bno));
        model.addAttribute("comm", commService.commList(bno));
        boardService.visit(bno);
        return "Board";
    }

    // 글작성 이동
    @GetMapping("/writeBoard")
    public String write() {
        return "writeBoard";
    }

    // 게시물 수정 이동
    @GetMapping("/editBoard/{bno}")
    public String editBoard(Model model, @PathVariable int bno) {
        System.out.println("editBoard : " + boardService.board(bno));
        model.addAttribute("board", boardService.board(bno));
        return "editBoard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
