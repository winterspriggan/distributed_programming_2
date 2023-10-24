package com.example.board_service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    public Board(BoardDTO boardDTO) {
        this.id = boardDTO.getId();
        this.author = boardDTO.getAuthor();
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.answer = boardDTO.getAnswer();
        this.answerer = boardDTO.getAnswerer();
        this.isAnswered = boardDTO.getIsAnswered();
    }

    private String id;
    private String author;
    private String title;
    private String content;
    private String answer;
    private String answerer;
    private int isAnswered;

//    public static void printHeader() {
//        System.out.println("[문의 리스트]");
//        System.out.printf("%-50s%-20s%-40s%-15s\n", "ID", "Author", "Title", "Answer Status");
//    }
//
//    public void print() {
//        System.out.printf("%-50s%-20s%-40s%-15s\n", id, author, title, isAnswered == 1 ? "Answered" : "Unanswered");
//    }

//    public void printDetails() {
//        System.out.println("[문의 상세 내용]");
//        System.out.printf("%-15s: %s\n", "ID", id);
//        System.out.printf("%-15s: %s\n", "Author", author);
//        System.out.printf("%-15s: %s\n", "Title", title);
//        System.out.printf("%-15s: %s\n", "Content", content);
//        if (isAnswered == 1) {
//            System.out.printf("%-15s: %s\n", "Answer", answer);
//            System.out.printf("%-15s: %s\n", "Answerer", answerer);
//        } else System.out.println("이 문의에는 아직 답변이 없습니다.");
//    }

}
