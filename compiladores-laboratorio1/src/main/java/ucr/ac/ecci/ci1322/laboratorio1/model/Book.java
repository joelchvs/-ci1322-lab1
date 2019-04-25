package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Book {
    private String code;
    private String title;
    private String author;
    private String borrowerId;

    public Book(String code, String title, String author, String borrowerId) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.borrowerId=borrowerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }
}