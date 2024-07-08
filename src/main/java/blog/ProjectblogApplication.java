package blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ProjectblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectblogApplication.class, args);
	}

}
