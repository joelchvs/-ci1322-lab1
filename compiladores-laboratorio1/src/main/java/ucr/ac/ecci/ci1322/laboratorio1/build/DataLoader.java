package ucr.ac.ecci.ci1322.laboratorio1.build;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImp;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.net.URI;

public class DataLoader {
    BookService bookService;
    StudentService studentService;

    public DataLoader () throws  Exception
    {
        bookService= new BookServiceImpl();
        studentService= new StudentServiceImp();
    }




    void loadBooks (HSSFSheet sheet) throws Exception
    {
        int i=1;
        while(!(sheet.getRow(i).getCell(0).toString().equals("")))
        {
            Book b;
            String code=sheet.getRow(i).getCell(0).toString();
            String title=sheet.getRow(i).getCell(1).toString();
            String author=sheet.getRow(i).getCell(2).toString();
            String borrowerId=sheet.getRow(i).getCell(3).toString();
            b= new Book(code, title, author, borrowerId);
            bookService.create(b);

            i++;
        }

    }

    void loadStudents (HSSFSheet sheet) throws Exception
    {
        int i=1;
        while(!(sheet.getRow(i).getCell(0).toString().equals("")))
        {
            Student s;
            String id=sheet.getRow(i).getCell(0).toString();
            String fn=sheet.getRow(i).getCell(1).toString();
            String ln=sheet.getRow(i).getCell(2).toString();

            s= new Student(id, fn, ln);
            studentService.create(s);

            i++;
        }

    }


    void loadCalc()throws Exception
        {
            FileInputStream fileIn = null;
            try {

                fileIn = new FileInputStream("C:/Users/Joel Chaves/Documents/ci1322-lab1/ ci1322-lab1/compiladores-laboratorio1/src/main/resources/BDD.xls");
                POIFSFileSystem fs = new POIFSFileSystem(fileIn);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet1 = wb.getSheetAt(0);
                HSSFSheet sheet2 = wb.getSheetAt(1);
                loadStudents(sheet2);
                loadBooks(sheet1);

            }finally {
                if (fileIn != null)
                    fileIn.close();
            }


        }

        public static void main(String[] args) throws Exception
        {
            DataLoader dl = new DataLoader();
            dl.loadCalc();
            String code;
            System.out.println("Input the book code:");
            Scanner scanner = new Scanner(System.in);
            code =scanner.nextLine();
            dl.bookService.findById(code);



        }
}

