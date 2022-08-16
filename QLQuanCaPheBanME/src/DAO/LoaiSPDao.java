/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LoaiSP;
import Entity.SanPham;
import java.util.List;
import JDBCHelper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author top1z
 */
public class LoaiSPDao implements interfaceLoaiSP {

    String insert = "insert LoaiSanPham(ID_LoaiSP,Tenloai) values (?,?)";
    String selectALL = "select * from LoaiSanPham";
    String sqlby_id = "select * from LoaiSanPham where ID_LoaiSP=?";
    String update_sql = "update LoaiSanPham set TenLoai = ? where ID_LoaiSP=?";
    String delete_sql = "delete LoaiSanPham where ID_LoaiSP=? ";

    @Override
    public void insert(LoaiSP lsp) {
        jdbcHelper.update(insert, lsp.getID_LoaiSP(), lsp.getTenLoai());
    }

    @Override
    public void update(LoaiSP lsp) {
        jdbcHelper.update(update_sql, lsp.getTenLoai(), lsp.getID_LoaiSP());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(delete_sql, id);
    }

    @Override
    public List<LoaiSP> selectll() {
        return selectBysql(selectALL);
    }

    @Override
    public LoaiSP selectID(String id) {
        return selectBysql(sqlby_id, id).get(0);
    }

    @Override
    public List<LoaiSP> selectBysql(String sql, Object... agrs) {
        List<LoaiSP> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, agrs);
            while (rs.next()) {
                LoaiSP lsp = new LoaiSP();
                lsp.setID_LoaiSP(rs.getString(1));
                lsp.setTenLoai(rs.getString(2));
                list.add(lsp);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ;lấy duw lieju thong qua ten
    public String selectIdByName(String name) {
        String sql = "select * from LoaiSanPham where TenLoai=?";
        return selectBysql(sql, name).get(0).getID_LoaiSP();
    }

    // lấy tên sản phẩm thong qua id
    public String selectNameByID(String id) {
        return selectBysql(sqlby_id, id).get(0).getTenLoai();
    }
////

    public LoaiSP selectid_LSP(String id) {
        List<LoaiSP> list = this.selectBysql(sqlby_id, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /// tự tăng mã
    public int selectMaLOAISP() {
        String sql = "select max(cast(substring(ID_LoaiSP,4,LEN(ID_LoaiSP))as int)) from  LoaiSanPham";
        try {

            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }

}
