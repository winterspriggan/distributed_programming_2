package com.example.board_service;

import java.util.List;

public interface BoardService {

    List<Board> getAllBoards();

    Board addBoard(BoardDTO boardDTO);

    boolean deleteBoardById(String id);

    List<Board> getBoardByCustomerId(String id);

    Board getBoardById(String id);
//    List<Contract> getContractByProductId(String id);

    boolean updateAnswer(AnswerDTO answerDTO);


}
