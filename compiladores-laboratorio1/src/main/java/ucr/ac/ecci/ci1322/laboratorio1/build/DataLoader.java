package ucr.ac.ecci.ci1322.laboratorio1.build;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.net.URI;

public class DataLoader {
    private BookServiceImpl bookServiceImpl;
    private StudentServiceImp studentServiceImp;


    void loadBooks (HSSFSheet hssfSheet)
    {

    }

    void loadStudents (HSSFSheet hssfSheet)
        {

        }

    void writeWorkbook()throws Exception
        {
            FileInputStream fileIn = null;
            FileOutputStream fileOut = null;

            try
            {

                fileIn= new FileInputStream("C:/Users/Joel Chaves/Documents/ci1322-lab1/ ci1322-lab1/compiladores-laboratorio1/src/main/resources/BDD.xls");
                POIFSFileSystem fs = new POIFSFileSystem(fileIn);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                HSSFRow row = sheet.getRow(2);
                if (row == null)
                    row = sheet.createRow(2);
                HSSFCell cell = row.getCell(3);
                if (cell == null)
                    cell = row.createCell(3);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("a test");

                // Write the output to a file
                fileOut = new FileOutputStream("workbookout.xls");
                wb.write(fileOut);




            } finally {
                if (fileOut != null)
                    fileOut.close();
                if (fileIn != null)
                    fileIn.close();
            }

        }

        public static void main(String[] args) throws Exception
        {
            DataLoader dl= new DataLoader();
            dl.writeWorkbook();
        }
}

