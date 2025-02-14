package practice.Practice.domain.user.presentation;

import practice.Practice.domain.user.presentation.dto.request.SendEmailRequest;
import practice.Practice.domain.user.presentation.dto.request.UpdateInfoRequest;
import practice.Practice.domain.user.presentation.dto.response.MyPageResponse;
import practice.Practice.domain.user.service.CreateImgListService;
import practice.Practice.domain.user.service.EmailService;
import practice.Practice.domain.user.service.ProfileUploadService;
import practice.Practice.domain.user.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practice.Practice.domain.user.service.UpdateInfoService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final MyPageService userService;
    private final EmailService sendEmailService;
    private final ProfileUploadService profileUploadService;
    private final CreateImgListService createImgListService;
    private final UpdateInfoService updateInfoService;

    @GetMapping("/myPage")
    public MyPageResponse myPage() {
        return userService.myPage();
    }

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid SendEmailRequest request) {
        try {
            sendEmailService.sendEmail(request);
            return ResponseEntity.ok("임시 비밀번호가 이메일로 발송되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/profile")
    public void upload(@RequestPart(required = false, value = "image") MultipartFile profileImage) throws IOException {
        profileUploadService.profileUpload(profileImage);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/images")
    public void imageUpload(@RequestPart(value = "images", required = false) List<MultipartFile> multipartFiles) {
        createImgListService.imgListUpload(multipartFiles);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    public void updateInfo(@RequestBody @Valid UpdateInfoRequest request) {
        updateInfoService.execute(request);
    }
}
