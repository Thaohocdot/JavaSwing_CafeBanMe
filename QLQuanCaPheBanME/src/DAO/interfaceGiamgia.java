/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.giamGia;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface interfaceGiamgia {
    abstract public void insert(giamGia Entity);

    abstract public void update(giamGia Entity);

    abstract public void delete(String id);
    
    abstract public giamGia selectById(String id);
    
    abstract public giamGia selectByIdSK(String SK);
    
    abstract public List<giamGia> selectAll();

    abstract public List<giamGia> selectBySql(String sql, Object... args);
}
