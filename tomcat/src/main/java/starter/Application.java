package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "test")
@EnableAutoConfiguration
@EntityScan(basePackages = "test")
@EnableJpaRepositories(basePackages = "test")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
