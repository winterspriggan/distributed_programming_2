package com.example.board_service;

import com.example.board_service.DAO.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardDAO boardDAO = new BoardDAO();

    @Override
    public List<Board> getAllBoards() {
        return boardDAO.findAllBoards();
    }

    @Override
    public Board addBoard(BoardDTO boardDTO) {
        Board board = new Board(boardDTO);
        if(boardDAO.addBoard(board)) return board;
        return null;
    }

    @Override
    public boolean deleteBoardById(String id) {
        return boardDAO.deleteBoardByColumn("id", id);
    }

    @Override
    public List<Board> getBoardByCustomerId(String id) {
        return boardDAO.getBoardsByAttribute(id, "author");
    }

    @Override
    public Board getBoardById(String id) { return boardDAO.getBoardsByAttribute(id, "id").get(0); }


    @Override
    public boolean updateAnswer(AnswerDTO answerDTO) {
        return boardDAO.updateBoard(answerDTO);
    }
}
