package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itsjava.dao.StudentDao;
import ru.itsjava.domain.Student;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJdbcFoundationsApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsApplication.class, args);


        StudentDao studentDao = context.getBean(StudentDao.class);
        System.out.println("studentDao.count() = " + studentDao.count());

        Student student = new Student("San", 33);
        studentDao.insert(student);

        System.out.println("studentDao.count() = " + studentDao.count());


        Student updateStudent = new Student("Ivanov2", 100);
        updateStudent.setId(1L);
        studentDao.update(updateStudent);

        System.out.println("studentDao.findById(1L) = " + studentDao.findById(1L));


        studentDao.delete(updateStudent);
        System.out.println("studentDao.count() = " + studentDao.count());
        Console.main(args);
    }
}
