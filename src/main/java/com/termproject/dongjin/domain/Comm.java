package com.termproject.dongjin.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Comm {
    private int cno;
    private String ccontent;
    private String cwriter;
    private Date regTime;  // db에 timestamp를 date로 바꿔줘야함
    private int up;
    private int fun;
    private int down;
}
