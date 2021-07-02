package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamePlatformSystemApplication {

	public static void main(String[] args) {
		System.out.println(new GamePlatformSystemApplication().getGreeting());
		SpringApplication.run(GamePlatformSystemApplication.class, args);
	}

	public String getGreeting() {
		return "hello";
	}

}
