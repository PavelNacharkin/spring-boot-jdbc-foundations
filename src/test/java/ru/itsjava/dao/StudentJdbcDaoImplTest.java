package ru.itsjava.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Faculty;
import ru.itsjava.domain.Student;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(StudentDaoImpl.class)
public class StudentJdbcDaoImplTest {
    private static final String DEFAULT_NAME = "Ivanov2";
    private static final int DEFAULT_AGE = 100;
    private static final long FIRST_ID = 1L;
    private static final long NEW_ID = 3L;

    private static final Faculty DEFAULT_FACULTY = new Faculty(1L, "Android Development");
    @Autowired
    private StudentDao studentDao;


    @Test
    public void shouldHaveCorrectCount() {
        int actualStudentsCount = studentDao.count();

        assertEquals(2, actualStudentsCount);
    }

    @Test
    public void shouldHaveCorrectInsert() {
        Student expectedStudent = new Student(DEFAULT_NAME, DEFAULT_AGE, DEFAULT_FACULTY);
        long idFromDB = studentDao.insert(expectedStudent);
        System.out.println(idFromDB);
        Student actual = studentDao.findById(idFromDB);

        assertAll(() -> assertEquals(actual.getFio(), expectedStudent.getFio()),
                () -> assertEquals(actual.getAge(), expectedStudent.getAge()));
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        Student expectedStudent = new Student(FIRST_ID, DEFAULT_NAME, DEFAULT_AGE, DEFAULT_FACULTY);
        studentDao.update(expectedStudent);
        Student actual = studentDao.findById(FIRST_ID);

        assertEquals(actual, expectedStudent);
    }


    @Test
    public void shouldHaveCorrectDelete() {
        Student deleteStudent = studentDao.findById(FIRST_ID);
        studentDao.delete(deleteStudent);

        assertEquals(studentDao.count(), 1);
    }
}
