package com.termproject.dongjin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/notice")
    public String noticeList() {
        return "BoardList";
    }

    @GetMapping("/class")
    public String classList() {
        return "BoardList";
    }

    @GetMapping("/questions")
    public String questionsList() {
        return "BoardList";
    }

    @GetMapping("/codeReview")
    public String codeReviewList() {
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
