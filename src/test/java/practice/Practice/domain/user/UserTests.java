package practice.Practice.domain.user;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import practice.Practice.domain.user.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {

	private User user;

	@BeforeAll // 모든 테스트 전에 실행
	static void BeforeAll() {
		System.out.println("@BeforeAll");
	}

	@AfterAll // 모든 테스트가 끝나고 실행
	static void afterAll() {
		System.out.println("@AfterAll");
	}

	@BeforeEach //테스트 실행 전에 pointTotal과 같은 공통 데이터를 설정하는 데 사용
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

	@Nested //테스트 케이스를 계층적으로 관리하기 위해 사용된다. (폴더별로 계층을 나누면 되서 많이 안 쓸 것 같다.)
	class UpdateUserInfoTests {

		@Test //Test인걸 명시해줌.  메서드의 리턴 타입은 무조건 void
		void whenUserIdIsOne() {
			// User 객체의 id가 1일 때 테스트입니다
			assertEquals(1L, user.getId(), "userId가 1이어야 합니다.");
			user.updateInfo("test1", "test1", "test1");
			System.out.println("email = " + user.getEmail());
		}

		@Test
		void whenEmailIsTest() {
			// User 객체의 이메일이 test인지 확인하는 테스트입니다
			assertEquals("test", user.getEmail(), "이메일이 'test'여야 합니다.");
			user.updateInfo("test2", "test2", "test2");
			System.out.println("email = " + user.getEmail());
		}
	}
}
