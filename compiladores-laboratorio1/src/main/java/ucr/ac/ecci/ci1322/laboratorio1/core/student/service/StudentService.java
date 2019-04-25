package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public interface StudentService {
    Student findById(String id) throws Exception;
    String create(Student entity) throws  Exception;
    void update(Student entity);
    void remove(Student entity);
}

