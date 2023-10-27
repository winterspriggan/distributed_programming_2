package com.example.board_service.DAO;


import com.example.board_service.AnswerDTO;
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
        String sql = "insert into " + tableName + " values(\'" + board.getId() + "\', \'" + board.getAuthor() + "\', \'" + board.getTitle() + "\', \'" + board.getContent() + "\', "
                +" null, null , 0 );";
        return executeUpdate(sql);
    }

    public boolean deleteBoardByColumn(String column, String key) {
        String sql = "delete from "+ tableName + " where "+ column +" = \'" + key+"\';";
        return executeUpdate(sql);
    }

    public List<Board> getBoardsByAttribute(String id, String column) {
        String sql = "select * from "+ tableName+" where " +  column + " = \'" +id+"\';";
        return findboards(sql);
    }

    public List<Board> findAllBoards() {
        String sql = "select * from " + tableName + ";";
        return findboards(sql);
    }

    public List<Board> findboards(String sql) {
        if (!executeQuery(sql)) return null;
        if(!next()) return null;
        List<Board> boards = new ArrayList<>();
        do {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(getString("id"));
            boardDTO.setAuthor(getString("author"));
            boardDTO.setTitle(getString("title"));
            boardDTO.setContent(getString("content"));
            boardDTO.setAnswer(getString("answer"));
            boardDTO.setAnswerer(getString("answerer"));
            boardDTO.setIsAnswered(getInt("is_answered"));
            boards.add(new Board(boardDTO));
        } while(next());
        return boards;
    }




    public boolean updateBoard(AnswerDTO answerDTO) {
        String sql = "update " + tableName + " set answer=\'" + answerDTO.getAnswer() + "\', answerer=\'" + answerDTO.getAnswerer() + "\', is_answered = " +answerDTO.getIsAnswerd()+
                " where id = \'" + answerDTO.getId() + "\';";
        return executeUpdate(sql);
    }
}
