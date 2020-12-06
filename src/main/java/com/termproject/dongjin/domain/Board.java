package com.termproject.dongjin.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Board {
    private int bno;
    private String title;
    private String bcontent;
    private String bwriter;
    private Date regDate;
    private int visit;
    private int up;
    private String category_cd;

    private int cnt;
    private int ronum;
}
