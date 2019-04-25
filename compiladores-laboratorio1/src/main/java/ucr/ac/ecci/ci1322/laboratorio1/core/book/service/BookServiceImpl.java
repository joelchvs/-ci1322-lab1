package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

public class BookServiceImpl {

    private BookDao bookDao;

    Book findById(String id)
    {
        return bookDao.findById(id);

    }

    String create(Book entity)
    {
        return bookDao.create(entity);
    }

    void update(Book entity)
    {
        bookDao.update(entity);
    }

    void remove(Book entity)
    {
        bookDao.remove(entity);
    }

}
