/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Hoadonchitiet;
import JDBCHelper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class HoadonchitietDAO implements InterfaceHoadonchittiet{
    String INSERT_SQL = "INSERT dbo.HoaDonChiTiet VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL_TrangThai = "UPDATE dbo.HoaDonChiTiet SET TTthanhtoan = ?  WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String UPDATE_SQL_IDHoaDon = "UPDATE dbo.HoaDonChiTiet SET ID_HoaDon = ?  WHERE ID_HoaDon = ? AND ID_SanPham = ? ";
    String UPDATE_SQL_soluong = "UPDATE dbo.HoaDonChiTiet SET Soluong = ?, TongGia = ?, ghichu = ?, Gia = ? WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    //String UPDATE_SQL_TrangThaiTT = "UPDATE dbo.HoaDon SET TTThanhtoan = ? WHERE ID_Hoadon = ?";
    String DELETE_SQL = "DELETE FROM dbo.HoaDonChiTiet WHERE ID_Hoadon = ? AND ID_SanPham = ?";
    String SELECT_ALL_SQL = "SELECT * FROM dbo.HoaDon";
    String SELECT_ALL_BY_ID_HD = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n" +
        "WHERE dbo.HoaDonChiTiet.TTThanhtoan = 1 AND HoaDon.ID_Hoadon = ? ";
    String SELECT_ALL_BY_ID_Ban = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n" +
"        JOIN dbo.BanChiTiet ON BanChiTiet.ID_Hoadon = HoaDon.ID_Hoadon JOIN dbo.Ban ON Ban.ID_Ban = BanChiTiet.ID_Ban \n" +
"        WHERE HoaDon.TTThanhtoan = 0 \n" +
"       AND dbo.HoaDonChiTiet.TTthanhtoan = 1  AND dbo.HoaDon.Trangthai = 1 AND dbo.Ban.Hoatdong = 0 AND dbo.Ban.ID_Ban = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM dbo.HoaDonChiTiet WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String SELECT_BY_ID_MaHD_TT1 = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n" +
        "WHERE dbo.HoaDonChiTiet.TTThanhtoan = 1 AND HoaDon.ID_Hoadon = ? AND ID_SanPham = ?";
    String SELECT_BY_ID_MaHD_TT0 = "SELECT * FROM dbo.HoaDonChiTiet JOIN dbo.HoaDon ON HoaDon.ID_Hoadon = HoaDonChiTiet.ID_HoaDon \n" +
        "WHERE dbo.HoaDonChiTiet.TTThanhtoan = 0 AND HoaDon.ID_Hoadon = ? AND ID_SanPham = ?";
    String UPDATE_LY_DO_HUY = "UPDATE dbo.HoaDonChiTiet SET Lydohuy = ? WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String UPDATE_Ghi_chu = "UPDATE dbo.HoaDonChiTiet SET ghichu = ? WHERE ID_HoaDon = ? AND ID_SanPham = ?";
    String selcecCountSPhuy = "SELECT COUNT(*) AS Soluongdonhuy FROM dbo.HoaDonChiTiet WHERE TTthanhtoan = 0 AND ID_HoaDon = ?";
     String SELECT_BY_ID_SQL_thao = "SELECT * FROM dbo.HoaDonChiTiet WHERE ID_HoaDon = ?";
    @Override
    public void insert(Hoadonchitiet Entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, Entity.getID_Hoadon(),Entity.getID_SanPHam(),Entity.getSoluong(),Entity.getGia(),Entity.getTongGia(),Entity.isTrangThai(),Entity.getLyDoHuy(),Entity.getGhiChu());
    }
   

    @Override
    public void delete(Hoadonchitiet Entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL_TrangThai, Entity.isTrangThai(),Entity.getID_Hoadon(),Entity.getID_SanPHam());
    }

    @Override
    public Hoadonchitiet selectById(int id, String MaSP) {
        List<Hoadonchitiet> list = this.selectBySql(SELECT_BY_ID_SQL, id, MaSP);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Hoadonchitiet> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<Hoadonchitiet> selectBySql(String sql, Object... args) {
        List<Hoadonchitiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Hoadonchitiet Entity = new Hoadonchitiet();
                Entity.setID_Hoadon(rs.getInt("ID_HoaDon"));
                Entity.setID_SanPHam(rs.getString("ID_SanPham"));
                Entity.setSoluong(rs.getInt("Soluong"));
                Entity.setGia(rs.getInt("Gia"));
                Entity.setTongGia(rs.getInt("TongGia"));
                Entity.setTrangThai(rs.getBoolean("TTthanhToan"));
                Entity.setLyDoHuy(rs.getString("Lydohuy"));
                Entity.setGhiChu(rs.getString("ghichu"));
                list.add(Entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Hoadonchitiet> selectByIDBan(int idBan){
        return selectBySql(SELECT_ALL_BY_ID_Ban, idBan);
    }

    @Override
    public List<Hoadonchitiet> selectByIdHD_TT1(int idHD, String idSP) {
        return selectBySql(SELECT_BY_ID_MaHD_TT1, idHD, idSP);
    }

    @Override
    public List<Hoadonchitiet> selectByIdHD_TT0(int idHD, String idSP) {
        return selectBySql(SELECT_BY_ID_MaHD_TT0, idHD, idSP);
    }

    @Override
    public void update_TT(Hoadonchitiet Entity) {
       JDBCHelper.jdbcHelper.update(UPDATE_SQL_TrangThai, Entity.isTrangThai(), Entity.getID_Hoadon(), Entity.getID_SanPHam());
    }

    @Override
    public void update_SL(Hoadonchitiet Entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL_soluong, Entity.getSoluong(), Entity.getTongGia(), Entity.getGhiChu(), Entity.getGia(), Entity.getID_Hoadon(), Entity.getID_SanPHam());
    }

    @Override
    public void update_LD(Hoadonchitiet Entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_LY_DO_HUY, Entity.getLyDoHuy(),Entity.getID_Hoadon(), Entity.getID_SanPHam());
    }
    
    public void update_ghichu(Hoadonchitiet Entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_Ghi_chu, Entity.getGhiChu(),Entity.getID_Hoadon(), Entity.getID_SanPHam());
    }
    
    @Override
    public int selectCount(String sql,  Object... args) {
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            int sl = 0;
            while (rs.next()) {
                sl = rs.getInt("Soluongdonhuy");
            }
            rs.getStatement().getConnection().close();
            return sl;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int selectCountdonHuy(int idhd) {
        return selectCount(selcecCountSPhuy, idhd);
    }
    public List<Hoadonchitiet> selectById1(int id) {
       return this.selectBySql(SELECT_BY_ID_SQL_thao, id);  
    }
    
    public List<Hoadonchitiet> selectByIdHD(int id) {
       return this.selectBySql(SELECT_ALL_BY_ID_HD, id);  
    }
    
    public void updateIDHOADON(int macu, int mamoi, String iSP){
        JDBCHelper.jdbcHelper.update(UPDATE_SQL_IDHoaDon, mamoi, macu, iSP);
    }
    
    public void deletehoadonct(int mahd, String masp){
    JDBCHelper.jdbcHelper.update(DELETE_SQL, mahd, masp);
    }
}
