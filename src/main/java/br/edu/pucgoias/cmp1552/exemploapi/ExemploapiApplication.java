package br.edu.pucgoias.cmp1552.exemploapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ExemploapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExemploapiApplication.class, args);

	}

}
