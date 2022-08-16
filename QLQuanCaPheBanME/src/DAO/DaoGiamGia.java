/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import Entity.giamGia;
import java.util.List;
import JDBCHelper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DaoGiamGia implements interfaceGiamgia {

    String INSERY_SQL = "insert  dbo.GiamGia values(?,?,?,?)";
    String UPDATE_SQL = "update GiamGia set Tensukien=? where Id_GiamGia=?";
    String DELETE_SQL = "delete from GiamGia where ID_Giamgia =?";
    String Select_SQL_SK = "select * from GiamGia where Tensukien=?";
    String SelectALL = "select * from GiamGia";
    String SELECT_BY_ID_SQL = "select * from GiamGia where Id_GiamGia = ?";

    public List<giamGia> selectAll;

    @Override
    public void insert(giamGia Entity) {
        jdbcHelper.update(INSERY_SQL, Entity.getTenSK(), Entity.getIdnhanvien(), Entity.getNgayBD(), Entity.getNgayKT());
    }

    @Override
    public void update(giamGia Entity) {
        jdbcHelper.update(UPDATE_SQL, Entity.getTenSK(), Entity.getId_GiamGia());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<giamGia> selectAll() {
        return this.selectBySql(SelectALL);
    }

    @Override
    public List<giamGia> selectBySql(String sql, Object... args) {
        List<giamGia> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                giamGia e = new giamGia();
                e.setId_GiamGia(rs.getInt("Id_GiamGia"));
                e.setTenSK(rs.getString("Tensukien"));
                e.setIdnhanvien(rs.getString("ID_Nhanvien"));
                e.setNgayBD(rs.getDate("Ngaybd"));
                e.setNgayKT(rs.getDate("ngaykt"));
//                e.setGiamGia(rs.getInt("Giam"));
                list.add(e);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public giamGia selectById(String id) {
        List<giamGia> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<giamGia> selectALLL() {
        return selectBySql(SelectALL);

    }

    public void updateDateFinsh(giamGia e) {
        String sql = "update GiamGia set  NGAYKT = ? WHERE Id_GiamGia=?";
        jdbcHelper.update(sql, e.getNgayKT(), e.getId_GiamGia());
    }

    // 
    public giamGia selectKhoangNgay(String idsp) {
        String sql = "select   * from giamgiachitiet join GiamGia on "
                + "Giamgiachitiet.Id_GiamGia = GiamGia.Id_GiamGia\n"
                + "where id_sanpham = ?  order by ngaykt desc";
        List<giamGia> list = selectBySql(sql, idsp);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    // lấy ra id của giảm giá
    public giamGia selectByIdss(int id) {
        String SELECT_BY_ID_SQL = "select * from GiamGia where Id_GiamGia = ?";
        List<giamGia> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        System.out.println(list.get(0).getId_GiamGia());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public giamGia selectByIdSK(String SK) {
        List<giamGia> list = this.selectBySql(Select_SQL_SK, SK);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    // hiển thị những sản phẩm giảm giá còn hạn sử dụng
    

}
