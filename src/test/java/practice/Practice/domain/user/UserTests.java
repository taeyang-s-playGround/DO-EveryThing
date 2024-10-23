package practice.Practice.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import practice.Practice.domain.user.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {

	private User user;

	@BeforeEach
	void setUp() {
		user = User.builder()
			.id(1L)
			.email("test")
			.username("test")
			.password("test")
			.accountId("test")
			.profileImageUrl("test")
			.imgList(null)
			.build();
	}

	@Nested
	class UpdateUserInfoTests {

		@Test
		void whenUserIdIsOne() {
			// User 객체의 id가 1일 때 테스트
			assertEquals(1L, user.getId(), "userId가 1이어야 합니다.");
			user.updateInfo("test1", "test1", "test1");
			System.out.println("email = " + user.getEmail());
		}

		@Test
		void whenEmailIsTest() {
			// User 객체의 이메일이 test인지 확인하는 테스트
			assertEquals("test", user.getEmail(), "이메일이 'test'여야 합니다.");
			user.updateInfo("test2", "test2", "test2");
			System.out.println("email = " + user.getEmail());
		}
	}
}
