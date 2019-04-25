package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public class StudentServiceImp implements StudentService{
    StudentDao studentDao;

    public StudentServiceImp () throws Exception
    {
        studentDao= new JdbcStudentService();
    }

    public Student findById(String id) throws Exception
    {
        return studentDao.findById(id);
    }

    public String create(Student entity) throws Exception
    {
        return studentDao.create(entity);
    }
    public void update(Student entity)
    {
        studentDao.update(entity);
    }
    public void remove(Student entity)
    {
        studentDao.remove(entity);
    }
}
