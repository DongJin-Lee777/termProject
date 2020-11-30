package com.termproject.dongjin.domain;

import lombok.Data;

@Data
public class Users {
    private String id;
    private String pwd;
    private String email;
    private String gender;
    private String auth;
    private String Class;
}
