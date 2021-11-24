package erisu.cloud.rokishi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:mysql.properties")
@SpringBootApplication
public class RokishiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RokishiApplication.class, args);
    }

}
