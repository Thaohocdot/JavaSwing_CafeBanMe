/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.BanChitiet;
import java.util.List;

/**
 *
 * @author HP
 */
public interface InterfaceBanchitiet {
    abstract public void insert(BanChitiet Entity);

    abstract public void update(int idban,int idHoadon);

    abstract public void delete(int id);

    abstract public BanChitiet selectById(int idban,int idHoadon);
    
    abstract public List<BanChitiet> selectByIdHD(int idHoadon);
    
    abstract public List<BanChitiet> selectByIdBan(int idban);
    
    abstract public List<BanChitiet> selectAll();
    

    abstract public List<BanChitiet> selectBySql(String sql, Object... args);
}
