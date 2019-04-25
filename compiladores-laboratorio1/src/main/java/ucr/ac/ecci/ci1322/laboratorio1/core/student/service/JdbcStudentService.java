package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcStudentService implements StudentDao {

    Connection conn;
    public JdbcStudentService () throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/LAB1";
        this.conn = DriverManager.getConnection(url,"root","");
        Statement stmt = conn.createStatement();
    }

    public String create (Student s) throws Exception
    {
        // create a Statement from the connection
        Statement statement = conn.createStatement();
        // insert the data
        statement.executeUpdate("INSERT INTO Students (id, firstName, lastName) "
                + "VALUES ('"+s.getId()+"', '"+s.getFirstName()+"', '"+s.getLastName()+"')");
        return s.getId();
    }

   public Student findById(String id) throws Exception
    {
        Student s;

        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT  * FROM Students WHERE id = '"+id+"'");
        String sId = rs.getString("id");
        String sFN = rs.getString("firstName");
        String sLN = rs.getString("lastName");
        s = new Student(sId,sFN,sLN);
        return s;
    }

    public void update(Student entity)
    {

    }

    public void remove(Student entity)
    {

    }

}
