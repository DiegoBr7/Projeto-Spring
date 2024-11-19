package br.com.aluno.Aluno;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.aluno.Aluno.Repository" )
@EntityScan(basePackages = "br.com.aluno.Aluno.Model")
public class AlunoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AlunoApplication.class, args);
	}

}
