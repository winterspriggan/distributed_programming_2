package com.example.board_service;

import java.util.List;

public interface BoardService {

    List<Board> getAllBoards();

    Board addBoard(BoardDTO boardDTO);

    boolean deleteBoard(String id);

    List<Board> getBoardByCustomerId(String id);
//    List<Contract> getContractByProductId(String id);

    boolean updateBoard(BoardDTO boardDTO);


}
