DROP TABLE IF EXISTS students, faculties;

CREATE TABLE students(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fio VARCHAR2(256),
    age INT,
    faculties_id BIGINT
);

CREATE TABLE faculties(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR2(256)
);
ALTER TABLE students add FOREIGN KEY (faculties_id) REFERENCES faculties(id);
