package com.example.board_service;

import lombok.Data;

@Data
public class AnswerDTO {
    private String id;
    private String answer;
    private String answerer;
    private int isAnswerd;
}
