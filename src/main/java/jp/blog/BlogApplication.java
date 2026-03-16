package jp.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BlogApplication {
	public static void main(String[] args) {
		log.info("Projeto rodando na porta ");
		SpringApplication.run(BlogApplication.class, args);
	}

}
