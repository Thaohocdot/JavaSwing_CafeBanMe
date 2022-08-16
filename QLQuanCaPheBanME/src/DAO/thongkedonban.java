/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;

/**
 *
 * @author ADMIN ASUS
 */
public class thongkedonban {
    private Date NgayDangKy;
      private int soluong;

    public thongkedonban() {
    }

    public thongkedonban(Date NgayDangKy, int soluong) {
        this.NgayDangKy = NgayDangKy;
        this.soluong = soluong;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
      
}
