/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.GiamGiaChitiet;
import Entity.LoaiSP;
import java.util.List;

/**
 *
 * @author top1z
 */
public interface InterfaceGiamgiaCT {
    abstract public void insert(GiamGiaChitiet sale);
    abstract public void update(int phantramGiam,String idsanpham);
    abstract public void delete(String id);
    abstract public List<GiamGiaChitiet> selectll();
    abstract public GiamGiaChitiet selectID(int id, String idsanpham);
    abstract public List<GiamGiaChitiet> selectBysql(String sql, Object...agrs);
}
