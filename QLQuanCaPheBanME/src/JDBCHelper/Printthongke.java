/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCHelper;

import DAO.BanChitietDAO;
import DAO.HoaDonDAO;
import Entity.Hoadon;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN ASUS
 */
public class Printthongke {
    HoaDonDAO hddao = new HoaDonDAO();
    BanChitietDAO bctdao = new BanChitietDAO();
    public void xuatpdf_ngay(DefaultTableModel model,DefaultTableModel model1){
       
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            File newFile = new File("D:\\Edrawsoft\\baocaongay.pdf");
            PdfWriter.getInstance(document, new FileOutputStream(newFile.getAbsoluteFile().getPath()));
            document.open();
            Font f = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f.setSize(16);
            Font f2 = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f2.setSize(12);
            Font f3 = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f3.setSize(10);
           
             Font f4 = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f4.setSize(14);
            f4.setColor(BaseColor.RED);
            //f.setStyle(Font.NORMAL);
            Paragraph title1 = new Paragraph("Coffe Ban Mê",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title1);
             Paragraph title2 = new Paragraph("80-Nguyễn Đình Hoàn - Cầu Giấy - Hà Nội",f3);
            
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title2);
             Paragraph title3 = new Paragraph("0964303432",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title3);
          
            
             Paragraph title4 = new Paragraph("THỐNG KÊ SẢN PHẨM,DOANH THU VÀ ĐƠN HỦY THEO NGÀY",f4);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title4.setAlignment(Element.ALIGN_CENTER);
            title4.setSpacingBefore(15);
            document.add(title4);
            PdfPTable a = new PdfPTable(2);
            a.setSpacingBefore(35);
            
          
            
            PdfPTable t = new PdfPTable(3);
            t.setSpacingBefore(15);
            t.setSpacingAfter(35);
            
            PdfPCell c1 = new PdfPCell(new Phrase("Tên Sp", f2));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Số lượng bán", f2));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Tổng tiền", f2));
            t.addCell(c3);
            
             PdfPTable t1 = new PdfPTable(3);
            t1.setSpacingBefore(15);
            t1.setSpacingAfter(35);
            
            PdfPCell c11 = new PdfPCell(new Phrase("Mã NV", f2));
            t1.addCell(c11);
            PdfPCell c22 = new PdfPCell(new Phrase("Số lượng Đơn Hủy", f2));
            t1.addCell(c22);
            PdfPCell c33 = new PdfPCell(new Phrase("Số lượng Sản Phẩm Hủy", f2));
            t1.addCell(c33);
           
           
            
            for (int i = 0; i < model.getRowCount(); i++) {
                
                    PdfPCell c5 = new PdfPCell(new Phrase(model.getValueAt(i, 0).toString(), f2));
                    t.addCell(c5);
                    t.addCell(model.getValueAt(i, 1).toString());
                   t.addCell(model.getValueAt(i, 2).toString());
                
            }
              for (int i = 0; i < model1.getRowCount(); i++) {
               
                    PdfPCell c5 = new PdfPCell(new Phrase(model1.getValueAt(i, 0).toString(), f2));
                    t1.addCell(c5);
                    t1.addCell(model1.getValueAt(i, 1).toString());
                   t1.addCell(model1.getValueAt(i, 2).toString());
                   
                
            }
            document.add(a);
            Paragraph title111 = new Paragraph("Doanh Thu Theo Sản Phẩm: ",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title111.setSpacingBefore(35);
            document.add(title111);
            document.add(t);
            Paragraph title222 = new Paragraph("Đơn Hủy Và Sản Phẩm Hủy: ",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title222.setSpacingBefore(15);
            document.add(title222);
             document.add(t1);
//            PdfPTable b = new PdfPTable(2);
//            PdfPCell b1 = new PdfPCell(new Phrase("Tổng tiền: ", f2));
//            b.addCell(b1).setBorder(0);
//            PdfPCell b2 = new PdfPCell(new Phrase(""+hd.getThanhTien(), f2));
//            b.addCell(b2).setBorder(0);
//            PdfPCell b3 = new PdfPCell(new Phrase("Tiền khách trả: ", f2));
//            b.addCell(b3).setBorder(0);
//            PdfPCell b4 = new PdfPCell(new Phrase(""+tienkh, f2));
//            b.addCell(b4).setBorder(0);
//            PdfPCell b5 = new PdfPCell(new Phrase("Tiền thối: ", f2));
//            b.addCell(b5).setBorder(0);
//            PdfPCell b6 = new PdfPCell(new Phrase(""+tienthoi, f2));
//            b.addCell(b6).setBorder(0);
//            document.add(b);
//            t.addCell("1.1");
//            t.addCell("1.2");
//            t.addCell("1.3");
            
            document.close();
            System.out.println("Write file succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xuatpdf_thang(DefaultTableModel model,DefaultTableModel model1){
       
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            File newFile = new File("D:\\Edrawsoft\\baocaongay.pdf");
            PdfWriter.getInstance(document, new FileOutputStream(newFile.getAbsoluteFile().getPath()));
            document.open();
            Font f = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f.setSize(16);
            Font f2 = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f2.setSize(12);
            Font f3 = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f3.setSize(10);
           
             Font f4 = new Font(BaseFont.createFont("C:\\Users\\HP\\Downloads\\system\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f4.setSize(14);
            f4.setColor(BaseColor.RED);
            //f.setStyle(Font.NORMAL);
            Paragraph title1 = new Paragraph("Coffe Ban Mê",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title1);
             Paragraph title2 = new Paragraph("80-Nguyễn Đình Hoàn - Cầu Giấy - Hà Nội",f3);
            
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title2);
             Paragraph title3 = new Paragraph("0964303432",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title3);
          
            
             Paragraph title4 = new Paragraph("THỐNG KÊ SẢN PHẨM,DOANH THU VÀ ĐƠN HỦY THEO THÁNG",f4);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title4.setAlignment(Element.ALIGN_CENTER);
            title4.setSpacingBefore(15);
            document.add(title4);
            PdfPTable a = new PdfPTable(2);
            a.setSpacingBefore(35);
            
          
            
            PdfPTable t = new PdfPTable(3);
            t.setSpacingBefore(15);
            t.setSpacingAfter(35);
            
            PdfPCell c1 = new PdfPCell(new Phrase("Tên Sp", f2));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Số lượng bán", f2));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Tổng tiền", f2));
            t.addCell(c3);
            
             PdfPTable t1 = new PdfPTable(3);
            t1.setSpacingBefore(15);
            t1.setSpacingAfter(35);
            
            PdfPCell c11 = new PdfPCell(new Phrase("Mã NV", f2));
            t1.addCell(c11);
            PdfPCell c22 = new PdfPCell(new Phrase("Số lượng Đơn Hủy", f2));
            t1.addCell(c22);
            PdfPCell c33 = new PdfPCell(new Phrase("Số lượng Sản Phẩm Hủy", f2));
            t1.addCell(c33);
           
           
            
            for (int i = 0; i < model.getRowCount(); i++) {
                
                    PdfPCell c5 = new PdfPCell(new Phrase(model.getValueAt(i, 0).toString(), f2));
                    t.addCell(c5);
                    t.addCell(model.getValueAt(i, 1).toString());
                   t.addCell(model.getValueAt(i, 2).toString());
                
            }
              for (int i = 0; i < model1.getRowCount(); i++) {
               
                    PdfPCell c5 = new PdfPCell(new Phrase(model1.getValueAt(i, 0).toString(), f2));
                    t1.addCell(c5);
                    t1.addCell(model1.getValueAt(i, 1).toString());
                   t1.addCell(model1.getValueAt(i, 2).toString());
                   
                
            }
            document.add(a);
            Paragraph title111 = new Paragraph("Doanh Thu Theo Sản Phẩm: ",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title111.setSpacingBefore(35);
            document.add(title111);
            document.add(t);
            Paragraph title222 = new Paragraph("Đơn Hủy Và Sản Phẩm Hủy: ",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title222.setSpacingBefore(15);
            document.add(title222);
             document.add(t1);
//            PdfPTable b = new PdfPTable(2);
//            PdfPCell b1 = new PdfPCell(new Phrase("Tổng tiền: ", f2));
//            b.addCell(b1).setBorder(0);
//            PdfPCell b2 = new PdfPCell(new Phrase(""+hd.getThanhTien(), f2));
//            b.addCell(b2).setBorder(0);
//            PdfPCell b3 = new PdfPCell(new Phrase("Tiền khách trả: ", f2));
//            b.addCell(b3).setBorder(0);
//            PdfPCell b4 = new PdfPCell(new Phrase(""+tienkh, f2));
//            b.addCell(b4).setBorder(0);
//            PdfPCell b5 = new PdfPCell(new Phrase("Tiền thối: ", f2));
//            b.addCell(b5).setBorder(0);
//            PdfPCell b6 = new PdfPCell(new Phrase(""+tienthoi, f2));
//            b.addCell(b6).setBorder(0);
//            document.add(b);
//            t.addCell("1.1");
//            t.addCell("1.2");
//            t.addCell("1.3");
            
            document.close();
            System.out.println("Write file succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xuatpdf_nam(DefaultTableModel model,DefaultTableModel model1){
       
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            File newFile = new File("C:\\Users\\ADMIN ASUS\\Desktop\\baocaongay.pdf");
            PdfWriter.getInstance(document, new FileOutputStream(newFile.getAbsoluteFile().getPath()));
            document.open();
            Font f = new Font(BaseFont.createFont("C:\\Users\\ADMIN ASUS\\Downloads\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f.setSize(16);
            Font f2 = new Font(BaseFont.createFont("C:\\Users\\ADMIN ASUS\\Downloads\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f2.setSize(12);
            Font f3 = new Font(BaseFont.createFont("C:\\Users\\ADMIN ASUS\\Downloads\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f3.setSize(10);
           
             Font f4 = new Font(BaseFont.createFont("C:\\Users\\ADMIN ASUS\\Downloads\\VietFontsWeb1_ttf\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            f4.setSize(14);
            f4.setColor(BaseColor.RED);
            //f.setStyle(Font.NORMAL);
            Paragraph title1 = new Paragraph("Coffe Ban Mê",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title1);
             Paragraph title2 = new Paragraph("80-Nguyễn Đình Hoàn - Cầu Giấy - Hà Nội",f3);
            
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title2);
             Paragraph title3 = new Paragraph("0964303432",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            title1.setAlignment(Element.ALIGN_LEFT);
            document.add(title3);
          
            
             Paragraph title4 = new Paragraph("THỐNG KÊ SẢN PHẨM,DOANH THU VÀ ĐƠN HỦY THEO NĂM",f4);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title4.setAlignment(Element.ALIGN_CENTER);
            title4.setSpacingBefore(15);
            document.add(title4);
            PdfPTable a = new PdfPTable(2);
            a.setSpacingBefore(35);
            
          
            
            PdfPTable t = new PdfPTable(3);
            t.setSpacingBefore(15);
            t.setSpacingAfter(35);
            
            PdfPCell c1 = new PdfPCell(new Phrase("Tên Sp", f2));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Số lượng bán", f2));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Tổng tiền", f2));
            t.addCell(c3);
            
             PdfPTable t1 = new PdfPTable(3);
            t1.setSpacingBefore(15);
            t1.setSpacingAfter(35);
            
            PdfPCell c11 = new PdfPCell(new Phrase("Mã NV", f2));
            t1.addCell(c11);
            PdfPCell c22 = new PdfPCell(new Phrase("Số lượng Đơn Hủy", f2));
            t1.addCell(c22);
            PdfPCell c33 = new PdfPCell(new Phrase("Số lượng Sản Phẩm Hủy", f2));
            t1.addCell(c33);
           
           
            
            for (int i = 0; i < model.getRowCount(); i++) {
                
                    PdfPCell c5 = new PdfPCell(new Phrase(model.getValueAt(i, 0).toString(), f2));
                    t.addCell(c5);
                    t.addCell(model.getValueAt(i, 1).toString());
                   t.addCell(model.getValueAt(i, 2).toString());
                
            }
              for (int i = 0; i < model1.getRowCount(); i++) {
               
                    PdfPCell c5 = new PdfPCell(new Phrase(model1.getValueAt(i, 0).toString(), f2));
                    t1.addCell(c5);
                    t1.addCell(model1.getValueAt(i, 1).toString());
                   t1.addCell(model1.getValueAt(i, 2).toString());
                   
                
            }
            document.add(a);
            Paragraph title111 = new Paragraph("Doanh Thu Theo Sản Phẩm: ",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title111.setSpacingBefore(35);
            document.add(title111);
            document.add(t);
            Paragraph title222 = new Paragraph("Đơn Hủy Và Sản Phẩm Hủy: ",f3);
            //Chapter chapter1 = new Chapter(title1, 1);
            
            title222.setSpacingBefore(15);
            document.add(title222);
             document.add(t1);
//            PdfPTable b = new PdfPTable(2);
//            PdfPCell b1 = new PdfPCell(new Phrase("Tổng tiền: ", f2));
//            b.addCell(b1).setBorder(0);
//            PdfPCell b2 = new PdfPCell(new Phrase(""+hd.getThanhTien(), f2));
//            b.addCell(b2).setBorder(0);
//            PdfPCell b3 = new PdfPCell(new Phrase("Tiền khách trả: ", f2));
//            b.addCell(b3).setBorder(0);
//            PdfPCell b4 = new PdfPCell(new Phrase(""+tienkh, f2));
//            b.addCell(b4).setBorder(0);
//            PdfPCell b5 = new PdfPCell(new Phrase("Tiền thối: ", f2));
//            b.addCell(b5).setBorder(0);
//            PdfPCell b6 = new PdfPCell(new Phrase(""+tienthoi, f2));
//            b.addCell(b6).setBorder(0);
//            document.add(b);
//            t.addCell("1.1");
//            t.addCell("1.2");
//            t.addCell("1.3");
            
            document.close();
            System.out.println("Write file succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
