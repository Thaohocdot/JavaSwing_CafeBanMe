/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LoaiSP;
import Entity.SanPham;
import java.util.List;

/**
 *
 * @author top1z
 */
public interface interfaceLoaiSP {
    abstract public void insert(LoaiSP lsp);
    abstract public void update(LoaiSP lsp);
    abstract public void delete(String id);
    abstract public List<LoaiSP> selectll();
    abstract public LoaiSP selectID(String id);
    abstract public List<LoaiSP> selectBysql(String sql, Object...agrs);
}
