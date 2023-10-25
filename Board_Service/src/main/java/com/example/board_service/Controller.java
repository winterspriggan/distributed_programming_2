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
    public List<Board> getContractByCustomerId(@PathVariable String customer_id) {
        return boardService.getBoardByCustomerId(customer_id);
    }

//    @GetMapping("/contract/product_id/{product_id}")
//    public List<Board> getContractByProductId(@PathVariable String product_id) {
//        return boardService.getContractByProductId(product_id);
//    }

    @DeleteMapping("/board/{id}")
    public boolean deleteBoard(@PathVariable String id) {
        return boardService.deleteBoard(id);
    }

//    @PostMapping("/uBoard")
//    public boolean updatePremium(@RequestBody BoardDTO boardDTO) {
//        return boardService.updatePremium(boardDTO);
//    }
}
