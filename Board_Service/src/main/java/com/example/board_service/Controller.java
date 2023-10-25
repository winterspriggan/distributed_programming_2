package com.example.board_service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final BoardService boardService;

    @GetMapping("/boards")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping("/board")
    public Board addBoard(@RequestBody BoardDTO boardDTO) {
        return boardService.addBoard(boardDTO);
    }

    @GetMapping("/board/customer_id/{customer_id}")
    public List<Board> getBoardsByCustomerId(@PathVariable String customer_id) {
        return boardService.getBoardByCustomerId(customer_id);
    }

    @GetMapping("/board/id/{id}")
    public Board getBoardById(@PathVariable String id) {
        return boardService.getBoardById(id);
    }

    @PutMapping("/uBoard")
    public boolean updateAnswer(@RequestBody AnswerDTO answerDTO) {
        return boardService.updateAnswer(answerDTO);
    }

    @DeleteMapping("/board/{id}")
    public boolean deleteBoardByID(@PathVariable String id) {
        return boardService.deleteBoardById(id);
    }
}