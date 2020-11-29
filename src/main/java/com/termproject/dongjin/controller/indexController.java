package com.termproject.dongjin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String board() {
        return "Board";
    }

    @GetMapping("/editboard")
    public String editboard() {
        return "editBoard";
    }
}
