/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUL;
import Entity.Hoadonchitiet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import GUI.HoadonchitietJDialog;
import DAO.HoadonchitietDAO;
import Entity.Hoadon;
/**
 *
 * @author ADMIN ASUS
 */
public class SerHoaDonChiTiet {
     HoadonchitietDAO dao=new HoadonchitietDAO();
      public void filltotablehoadonchitiet(int a){
       List<Hoadonchitiet> list = new ArrayList<>();
        DefaultTableModel model=(DefaultTableModel) HoadonchitietJDialog.tblHoaDonChiTiet.getModel();
        model.setRowCount(0);
        try {
          list= dao.selectById1(a);
           for (Hoadonchitiet hd : list) {
                model.addRow(new Object[]{
                    hd.getID_Hoadon(),
                    hd.getID_SanPHam(),
                    hd.getSoluong(),
                    hd.getGia(),
                    hd.getTongGia(),
                    hd.isTrangThai() ?"" : "Hủy",
                        hd.getLyDoHuy()
                    
                });
                 
            }
          
       } catch (Exception e) {
       }
    }
    
}
