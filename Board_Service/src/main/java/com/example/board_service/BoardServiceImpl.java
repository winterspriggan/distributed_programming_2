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
    public boolean deleteBoard(String id) {
        return boardDAO.deleteBoard(id);
    }

    @Override
    public List<Board> getBoardByCustomerId(String id) {
        return boardDAO.getBoardsByCustomerId(id);
    }

//    @Override
//    public List<Board> getContractByProductId(String id) {
//        return boardDAO.getContractsByProductId(id);
//    }

    @Override
    public boolean updateBoard(BoardDTO boardDTO) {
        Board board = new Board(boardDTO);
        return boardDAO.updateBoard(board);
    }


}
