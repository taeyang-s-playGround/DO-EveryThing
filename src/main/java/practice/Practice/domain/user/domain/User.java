package practice.Practice.domain.user.domain;

import practice.Practice.infra.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String username;

    @Column(length = 2000, nullable = false)
    private String password;

    @Column(length = 20, unique = true, nullable = false)
    private String accountId;

    private String profileImageUrl;

    @Convert(converter = StringListConverter.class)
    private List<String> imgList = new ArrayList<>();

    public void profileUpload(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void imageListUpload(List<String> profileImageUrl) {
        this.imgList = profileImageUrl;
    }

    public void updateInfo(String email, String username, String accountId) {
        this.email = email;
        this.username = username;
        this.accountId = accountId;
    }
}
