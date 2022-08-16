/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DonviDoUong;
import java.util.List;
import JDBCHelper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author top1z
 */
public class DonVIUDDao implements interfaceDonViDUong {

    String insert = "insert DonViSanPham(ID_DonviSP,TenDonvi,Kichthuoc)values (?,?,?)";

    String selectAll = "select * from DonViSanPham";

    String select_id = "select * from DonViSanPham where ID_DonviSP=?";

    String update_sql = "update DonViSanPham set TENDONVI =? , KICHTHUOC=? WHERE ID_DONVISP = ?";
    String delete = "delete DonViSanPham where ID_DonviSP=? ";
    @Override
    public void insert(DonviDoUong dv) {
        jdbcHelper.update(insert, dv.getID_DonviSP(), dv.getTenDonvi(), dv.getKichthuoc());
    }

    @Override
    public void update(DonviDoUong dv) {
        jdbcHelper.update(update_sql, dv.getTenDonvi(),dv.getKichthuoc(),dv.getID_DonviSP());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(delete, id);
    }

    @Override
    public List<DonviDoUong> seleall() {
        return selectBysql(selectAll);
    }

    @Override
    public DonviDoUong selectID(String id) {
        return selectBysql(select_id, id).get(0);
    }

    @Override
    public List<DonviDoUong> selectBysql(String sql, Object... agrs) {
        List<DonviDoUong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, agrs);
            while (rs.next()) {
                DonviDoUong dv = new DonviDoUong();
                dv.setID_DonviSP(rs.getString(1));
                dv.setTenDonvi(rs.getString(2));
                dv.setKichthuoc(rs.getInt(3));
                list.add(dv);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String selectIDbyName(String id) {
        String sql = "select * from DonViSanPham where TenDonvi = ?";
        return selectBysql(sql, id).get(0).getID_DonviSP();
    }
    
    public DonviDoUong selectid_DVDU(String id){
        List<DonviDoUong> list = this.selectBysql(select_id, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(1);
    }
    public String selectNameByID(String id){
        return selectBysql(select_id,  id).get(0).getTenDonvi();
    }
      /// tự tăng mã
    public int selectMaLOAISP() {
        String sql = "select max(cast(substring(ID_DonviSP,3,LEN(ID_DonviSP))as int)) from  DonViSanPham";
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
