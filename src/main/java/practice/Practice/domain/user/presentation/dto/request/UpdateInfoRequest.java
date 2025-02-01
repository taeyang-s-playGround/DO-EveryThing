package practice.Practice.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateInfoRequest {

    @NotNull(message = "아이디을 입력하세요")
    private String accountId;

    @NotNull(message = "유저 이름을 입력하세요")
    private String userName;

    @NotNull(message = "이메일을 입력하세요")
    private String email;
}
