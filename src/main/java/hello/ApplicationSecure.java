package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationSecure {

    public static void main(String[] args) throws Throwable {
//        SpringApplication.run(hello.Application.class, args);
        SpringApplication.run(ApplicationSecure.class, args);
    }

}
