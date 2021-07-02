package Application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class GamePlatformSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test void appHasAGreeting() {
		GamePlatformSystemApplication classUnderTest = new GamePlatformSystemApplication();
		assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
	}

}
