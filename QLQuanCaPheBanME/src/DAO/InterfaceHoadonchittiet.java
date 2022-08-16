/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Hoadonchitiet;
import java.util.List;

/**
 *
 * @author HP
 */
public interface InterfaceHoadonchittiet {
    abstract public void insert(Hoadonchitiet Entity);

    abstract public void update_TT(Hoadonchitiet Entity);
    
    abstract public void update_SL(Hoadonchitiet Entity);
    
    abstract public void update_LD(Hoadonchitiet Entity);

    abstract public void delete(Hoadonchitiet Entity);

    abstract public Hoadonchitiet selectById(int idHD, String idMaSP);
    
    abstract public List<Hoadonchitiet> selectByIdHD_TT1(int idHD, String idSP);
    
    abstract public List<Hoadonchitiet> selectByIdHD_TT0(int idHD, String idSP);
    
    abstract public List<Hoadonchitiet> selectAll();
    
    abstract public int selectCountdonHuy(int idhd);

    abstract public List<Hoadonchitiet> selectBySql(String sql, Object... args);
    
    abstract public int selectCount(String sql, Object... args);
}
