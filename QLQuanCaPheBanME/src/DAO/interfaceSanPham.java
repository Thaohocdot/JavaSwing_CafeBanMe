/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.SanPham;
import java.util.List;

/**
 *
 * @author top1z
 */
public interface interfaceSanPham  {

    abstract public void insert(SanPham sp);

    abstract public void update(SanPham sp);

    abstract public void delete(String id);

    abstract public List<SanPham> selectAll();

    abstract public SanPham selectID(String id);

    abstract public List<SanPham> selectBysql(String sql, Object... agrs);
}
