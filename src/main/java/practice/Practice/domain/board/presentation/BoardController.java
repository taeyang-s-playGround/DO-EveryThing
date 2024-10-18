package practice.Practice.domain.board.presentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.Practice.domain.board.presentation.dto.CreateBoardRequest;
import practice.Practice.domain.board.service.CreateBoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final CreateBoardService createBoardService;

    @PostMapping
    public void createBoard(@RequestBody @Valid CreateBoardRequest request) {
        createBoardService.execute(request);
    }
}
