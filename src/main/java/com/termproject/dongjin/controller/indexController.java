package com.termproject.dongjin.controller;

import com.termproject.dongjin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String noticeList(Model model, @RequestParam(defaultValue = "1") String category, Criteria criteria, @RequestParam(defaultValue = "1") int page) {
        Pagination pagination = new Pagination(boardService.boardListCnt(category), page, 10);
        criteria.setBno(Integer.parseInt(category));
        criteria.setPage(pagination.getPage());
        criteria.setPerPageNum(pagination.getPageSize());

        System.out.println("boardList : " + boardService.boardList(category, criteria, criteria.getRowStart(), criteria.getRowEnd()));
        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardService.boardList(category, criteria, criteria.getRowStart(), criteria.getRowEnd()));
        model.addAttribute("category", category);
        model.addAttribute("boardName", boardService.className(category));
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

    @GetMapping("/userManager")
    public String userAdmin(Model model, Criteria bcriteria, Criteria ccriteria, Criteria acriteria, @RequestParam(defaultValue = "1") int bpage,
                              @RequestParam(defaultValue = "1") int cpage, @RequestParam(defaultValue = "1") int apage) {
        Pagination bpagination = new Pagination(boardService.boardAllListCnt(), bpage, 5);
        bcriteria.setPage(bpagination.getPage());
        bcriteria.setPerPageNum(bpagination.getPageSize());
        model.addAttribute("bpagination", bpagination);
        model.addAttribute("boardList", boardService.boardListAllPage(bcriteria, bcriteria.getRowStart(), bcriteria.getRowEnd()));

        Pagination cpagination = new Pagination(commService.commAllListCnt(), cpage, 5);
        ccriteria.setPage(cpagination.getPage());
        ccriteria.setPerPageNum(cpagination.getPageSize());
        model.addAttribute("cpagination", cpagination);
        model.addAttribute("commList", commService.commAllList(ccriteria, ccriteria.getRowStart(), ccriteria.getRowEnd()));

        Pagination apagination = new Pagination(userService.userAllCnt(), apage, 5);
        acriteria.setPage(cpagination.getPage());
        acriteria.setPerPageNum(apagination.getPageSize());
        model.addAttribute("apagination", apagination);
        model.addAttribute("userList", userService.userAuthList(ccriteria, ccriteria.getRowStart(), ccriteria.getRowEnd()));

        System.out.println("userManager boardListAllPage" +boardService.boardListAllPage(bcriteria, bcriteria.getRowStart(), bcriteria.getRowEnd()));
        System.out.println("userManager commAllList" + commService.commAllList(ccriteria, ccriteria.getRowStart(), ccriteria.getRowEnd()));
        System.out.println("userManager userAuthList" + userService.userAuthList(ccriteria, ccriteria.getRowStart(), ccriteria.getRowEnd()));

        System.out.println("boardTime : " + boardService.boardTime());
        System.out.println("commTime : " + commService.commTime());
        model.addAttribute("BoardData", boardService.boardTime());
        model.addAttribute("CommData", commService.commTime());
        return "userManager";
    }

    @GetMapping("/userLog")
    public String userLog(Model model, Criteria bcriteria, Criteria ccriteria, @RequestParam(defaultValue = "1") int bpage,
                          @RequestParam(defaultValue = "1") int cpage, @RequestParam(defaultValue = "1") String id) {
        Pagination bpagination = new Pagination(boardService.boardUserListCnt(id), bpage, 5);
        bcriteria.setPage(bpagination.getPage());
        bcriteria.setPerPageNum(bpagination.getPageSize());
        model.addAttribute("bpagination", bpagination);
        model.addAttribute("boardList", boardService.boardUserList(id, bcriteria, bcriteria.getRowStart(), bcriteria.getRowEnd()));

        Pagination cpagination = new Pagination(commService.commUserListCnt(id), cpage, 5);
        ccriteria.setPage(cpagination.getPage());
        ccriteria.setPerPageNum(cpagination.getPageSize());
        model.addAttribute("cpagination", cpagination);
        model.addAttribute("commList", commService.commUserList(id, ccriteria, ccriteria.getRowStart(), ccriteria.getRowEnd()));

        System.out.println("userLog boardUserList" + boardService.boardUserList(id, bcriteria, bcriteria.getRowStart(), bcriteria.getRowEnd()));
        System.out.println("userLog commUserList" + commService.commUserList(id, ccriteria, ccriteria.getRowStart(), ccriteria.getRowEnd()));

        return "userLog";
    }
}
