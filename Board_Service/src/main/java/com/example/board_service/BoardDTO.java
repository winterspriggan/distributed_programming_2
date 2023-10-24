package com.example.board_service;

import lombok.Data;

@Data
public class BoardDTO {
    private String id;
    private String author;
    private String title;
    private String content;
    private String answer;
    private String answerer;
    private int isAnswered;
}
