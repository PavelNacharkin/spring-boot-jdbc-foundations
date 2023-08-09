package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.itsjava.services.AppService;


import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJdbcFoundationsApplication {

    public static void main(String[] args) throws SQLException {


        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsApplication.class, args);
        context.getBean(AppService.class).start();

    }
}
