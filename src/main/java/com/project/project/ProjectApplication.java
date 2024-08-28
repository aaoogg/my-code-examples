package com.project.project;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.project.repository")
public class ProjectApplication {

    public static void main(String[] args) {
	try {
	    SpringApplication.run(ProjectApplication.class, args);
	    System.out.println("Servidor iniciado");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Bean
    public String testarConexao(@Autowired DataSource dataSource) {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	String query = "SELECT 1";
	try {
	    Integer resultado = jdbcTemplate.queryForObject(query, Integer.class);
	    System.out.println("Conexão com o banco de dados estabelecida com sucesso");
	    return "Conexão com o banco de dados estabelecida com sucesso";
	} catch (Exception e) {
	    System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	    return "Erro ao conectar ao banco de dados: " + e.getMessage();
	}
    }
}
