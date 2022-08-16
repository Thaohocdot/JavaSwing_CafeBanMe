/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUL;
import DAO.SanPhamDao;
import Entity.SanPham;
import javax.swing.JTextField;
/**
 *
 * @author top1z
 */
public class SerSanPham {
   SanPhamDao dao = new SanPhamDao();
   public  void insert (SanPham sp){
        dao.insert(sp);
   }
    public  void update (SanPham sp){
        dao.update(sp);
   }
     public  void delete (SanPham sp){
        dao.delete(sp.getId_sp());
   }
  
}
