package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcBookService {

    Connection conn;
    public JdbcBookService () throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/LAB1";
        this.conn = DriverManager.getConnection(url,"root","");
        Statement stmt = conn.createStatement();

    }

    void create (String code, String title, String author, String borrowerId) throws Exception
    {
        // create a Statement from the connection
        Statement statement = conn.createStatement();
        // insert the data
        statement.executeUpdate("INSERT INTO Books (code, title, author, borrowerId) "
                + "VALUES ('"+code+"', '"+title+"', '"+author+"', '"+borrowerId+"')");
    }

    void findById(String id) throws Exception
    {
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT title FROM Books WHERE code = '"+id+"'");
        while ( rs.next() ) {
            String bookTitle = rs.getString("title");
            System.out.println(bookTitle);
        }
    }

}
