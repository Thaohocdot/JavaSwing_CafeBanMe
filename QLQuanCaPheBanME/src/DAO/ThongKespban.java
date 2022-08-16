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
public class ThongKespban {
    private String Tensp;
    private int soluong;

    public ThongKespban() {
    }

    public ThongKespban(String Tensp, int soluong) {
        this.Tensp = Tensp;
        this.soluong = soluong;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
