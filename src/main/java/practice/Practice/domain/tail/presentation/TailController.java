package practice.Practice.domain.tail.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.Practice.domain.tail.presentation.dto.CreateTailRequest;
import practice.Practice.domain.tail.service.CreateTailService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tails")
public class TailController {

    private final CreateTailService createTailService;

    @PostMapping
    public void createTail(@RequestBody @Valid CreateTailRequest request) {
        createTailService.execute(request);
    }
}
