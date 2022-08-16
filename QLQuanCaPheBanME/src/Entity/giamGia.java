/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class giamGia {

    int id_GiamGia;
    String tenSK;
    String idnhanvien;
    Date ngayBD;
    Date ngayKT;
  

    public giamGia() {
    }

    public giamGia(int id_GiamGia, String tenSK, String idnhanvien, Date ngayBD, Date ngayKT) {
        this.id_GiamGia = id_GiamGia;
        this.tenSK = tenSK;
        this.idnhanvien = idnhanvien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;

    }

    public int getId_GiamGia() {
        return id_GiamGia;
    }

    public void setId_GiamGia(int id_GiamGia) {
        this.id_GiamGia = id_GiamGia;
    }

    public String getTenSK() {
        return tenSK;
    }

    public void setTenSK(String tenSK) {
        this.tenSK = tenSK;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

//    public int getGiamGia() {
//        return giamGia;
//    }
//
//    public void setGiamGia(int giamGia) {
//        this.giamGia = giamGia;
//    }

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

}
