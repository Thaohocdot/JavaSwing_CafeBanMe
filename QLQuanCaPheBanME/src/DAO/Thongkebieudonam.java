/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ADMIN ASUS
 */
public class Thongkebieudonam {
    private Integer thang,soluong;

    public Thongkebieudonam() {
    }

    public Thongkebieudonam(Integer thang, Integer soluong) {
        this.thang = thang;
        this.soluong = soluong;
    }

    public Integer getThang() {
        return thang;
    }

    public void setThang(Integer thang) {
        this.thang = thang;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }
    
      
    
}
