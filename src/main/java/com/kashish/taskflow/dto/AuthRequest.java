package com.kashish.taskflow.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthRequest {
    private String email;
    private String password;
}