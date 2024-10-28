package practice.Practice.domain.tail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.Practice.domain.tail.domain.Tail;
import practice.Practice.domain.tail.domain.repository.TailRepository;
import practice.Practice.domain.tail.presentation.dto.CreateTailRequest;
import practice.Practice.domain.user.domain.User;
import practice.Practice.domain.user.service.facade.UserFacade;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateTailService {

    private final TailRepository tailRepository;
    private final UserFacade userFacade;

    public void execute(CreateTailRequest request) {
        User currentUser = userFacade.getCurrentUser();

        tailRepository.save(Tail.builder()
            .user(currentUser)
            .tailName(request.getTailName())
            .length(request.getLength())
            .build());
    }
}
