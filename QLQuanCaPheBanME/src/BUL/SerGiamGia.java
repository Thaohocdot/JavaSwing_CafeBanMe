/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUL;

import DAO.DaoGiamGia;
import Entity.giamGia;

/**
 *
 * @author Admin
 */
public class SerGiamGia {
    DaoGiamGia dao = new DaoGiamGia();
    
    public void insert(giamGia gg){
        dao.insert(gg);
    }
    public void update(giamGia gg){
        dao.update(gg);
    }
    public void delete(giamGia gg){
//        dao.delete(gg.getId_GiamGia());
    }
}
