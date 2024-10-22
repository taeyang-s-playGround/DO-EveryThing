package practice.Practice.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.Practice.domain.user.domain.User;
import practice.Practice.domain.user.exception.UserNotFoundException;
import practice.Practice.domain.user.presentation.dto.request.UpdateInfoRequest;
import practice.Practice.domain.user.service.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class UpdateInfoService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateInfoRequest request) {
        User user = userFacade.getCurrentUser();

        System.out.println("fesdffdsfnkldddddddddddddddddddddddddddddddddgggggggg");
        /*if (user.getId() == 1L) {
            throw UserNotFoundException.EXCEPTION;
        }*/

        user.updateInfo(request.getEmail(), request.getUserName(), request.getAccountId());
    }
}
