package com.example.board_service.DAO;


import com.example.board_service.Board;
import com.example.board_service.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO {

    public BoardDAO() {
        super();
        databaseName = "insurance_system";
        tableName = "board";
    }

    public boolean addBoard(Board board) {
        String sql = "insert into " + tableName + " values(\'" + board.getId() + "\', \'" + board.getAuthor() + "\', \'" + board.getTitle() + "\', \'" + board.getContent() + "\', \'"
                + board.getAnswer() + "\', \'" + board.getAnswerer() + "\', " + board.getIsAnswered() + ");";
        return executeUpdate(sql);
    }


    public List<Board> findAllBoards() {
        String sql = "select * from " + tableName + ";";
        if (!executeQuery(sql)) return null;
        if(!next()) return null;
        List<Board> boards = new ArrayList<>();
        do {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.getId() = getString("id");
            boardDTO.getAuthor() = getString("author");
            boardDTO.getTitle() = getString("title");
            boardDTO.getContent() = getString("content");
            boardDTO.getAnswer() = getString("answer");
            boardDTO.getAnswerer() = getString("answerer");
            boardDTO.getIsAnswered() = getInt("is_answered");
            boards.add(new Board(boardDTO));
        } while(next());
        return boards;
    }

    public boolean updateBoard(Board board) {
        String sql = "update " + tableName + " set answer=\'" + board.answer + "\', answerer=\'" + board.answerer + "\', is_answered=" + board.isAnswered +
                " where id=\'" + board.id + "\';";
        return executeUpdate(sql);
    }
}
