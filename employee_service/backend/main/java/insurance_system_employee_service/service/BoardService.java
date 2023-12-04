package insurance_system_employee_service.service;


import insurance_system_employee_service.dto.BoardDTO;
import insurance_system_employee_service.jpa.board.BoardEntity;
import insurance_system_employee_service.jpa.board.BoardRepository;
import insurance_system_employee_service.service.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public List<BoardDTO> getAllBoards() {
        List<BoardDTO> boards = new ArrayList<>();
        List<BoardEntity> boardEntities = boardRepository.findAll();
        for(BoardEntity board : boardEntities) {
            boards.add(new BoardDTO(
                    board.getId()
                    , board.getAuthor()
                    , board.getTitle()
                    , board.getContent()
                    , board.getAnswer()
                    , board.getAnswerer()
                    , board.getIs_answered()
            ));
        }
        return boards;
    }

    public BoardVO createAnswer(BoardVO vo) {
        BoardEntity temp = boardRepository.getBoardByID(vo.getId());
        BoardEntity board = BoardEntity.builder()
                .id(temp.getId())
                .author(temp.getAuthor())
                .title(temp.getTitle())
                .content(temp.getContent())
                .answer(vo.getAnswer())
                .answerer(vo.getAnswerer())
                .is_answered(vo.getIs_answered())
                .build();
        boardRepository.save(board);
        return vo;
    }
}
