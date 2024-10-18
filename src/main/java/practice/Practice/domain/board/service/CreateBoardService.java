package practice.Practice.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.Practice.domain.board.domain.Board;
import practice.Practice.domain.board.domain.repository.BoardRepository;
import practice.Practice.domain.board.presentation.dto.CreateBoardRequest;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateBoardService {

    private final BoardRepository boardRepository;

    public void execute(CreateBoardRequest request) {
        boardRepository.save(Board.builder()
            .title(request.getTitle())
            .content(request.getContent())
            .build());
    }
}
