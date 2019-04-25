package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public class StudentServiceImp {
    private StudentDao studentDao;

    Student findById(String id)
    {
        return studentDao.findById(id);
    }
    String create(Student entity)
    {
        return studentDao.create(entity);
    }
    void update(Student entity)
    {
        studentDao.update(entity);
    }
    void remove(Student entity)
    {
        studentDao.remove(entity);
    }
}
