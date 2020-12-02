package com.termproject.dongjin.controller;

import com.termproject.dongjin.service.BoardService;
import com.termproject.dongjin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {
    @Autowired
    UserService userService;
    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("boardList", boardService.boardListAll());
        return "index";
    }

    @GetMapping("/boardList")
    public String noticeList(Model model, @RequestParam(defaultValue = "1") String category) {
        System.out.println("boardList 요청");
        model.addAttribute("boardList", boardService.boardList(category));
        return "BoardList";
    }

    @GetMapping("/board")
    public String getBoard() {
        return "Board";
    }

    @PostMapping("/board")
    public String postBoard() {
        return "Board";
    }

    @GetMapping("/editBoard")
    public String editBoard() {
        return "editBoard";
    }
}
