package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcStudentService {

    Connection conn;
    public JdbcStudentService () throws Exception
    {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/LAB1";
        this.conn = DriverManager.getConnection(url,"root","");
        Statement stmt = conn.createStatement();
    }

    void create (String id, String fn, String ln) throws Exception
    {
        // create a Statement from the connection
        Statement statement = conn.createStatement();
        // insert the data
        statement.executeUpdate("INSERT INTO Students (id, firstName, lastName) "
                + "VALUES ('"+id+"', '"+fn+"', '"+ln+"')");
    }

    void findById(String id) throws Exception
    {
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT  firstName FROM Students WHERE id = '"+id+"'");
        while ( rs.next() ) {
            String firstName = rs.getString("firstName");
            System.out.println(firstName);
        }
    }

}
