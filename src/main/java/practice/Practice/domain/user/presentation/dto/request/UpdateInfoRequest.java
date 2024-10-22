package practice.Practice.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UpdateInfoRequest {

    private String accountId;

    private String userName;

    private String email;
}
