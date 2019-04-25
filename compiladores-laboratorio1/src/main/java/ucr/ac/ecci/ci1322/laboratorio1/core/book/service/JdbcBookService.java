package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcBookService implements BookDao {

    Connection conn;
    public JdbcBookService () throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/LAB1";
        this.conn = DriverManager.getConnection(url,"root","root");
        Statement stmt = conn.createStatement();

    }

    public String create (Book b) throws Exception
    {
        // create a Statement from the connection
        Statement statement = conn.createStatement();
        // insert the data
        statement.executeUpdate("INSERT INTO Books (code, title, author, borrowerId) "
                + "VALUES ('"+b.getCode()+"', '"+b.getTitle()+"', '"+b.getAuthor()+"', '"+b.getBorrowerId()+"')");
        return b.getCode();
    }

    public Book findById(String id) throws Exception
    {
        Book b;

            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Books WHERE code = '" + id + "'");

            String bookId = rs.getString("code");
            String bookTitle = rs.getString("title");
            String bookAuthor = rs.getString("author");
            String bookBorrower = rs.getString("borrowerId");
            b = new Book(bookId, bookTitle, bookAuthor, bookBorrower);

        return b;
    }

    public void update(Book entity)
    {


    }
    public void remove(Book entity)
    {


    }
}
