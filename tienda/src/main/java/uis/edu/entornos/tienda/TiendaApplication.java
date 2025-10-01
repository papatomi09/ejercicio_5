package uis.edu.entornos.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "uis.edu.entornos")
@EnableJpaRepositories(basePackages = "uis.edu.entornos.repositorio")
@EntityScan(basePackages = "uis.edu.entornos.modelo")
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

}
