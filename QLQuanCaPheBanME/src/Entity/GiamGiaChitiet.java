/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author top1z
 */
public class GiamGiaChitiet {

    private int idgiamgia;
    private String idsp;
    private int phantramgiam;

    public GiamGiaChitiet() {
    }

    public GiamGiaChitiet(int idgiamgia, String idsp, int phantramgiam) {
        this.idgiamgia = idgiamgia;
        this.idsp = idsp;
        this.phantramgiam = phantramgiam;
    }

    public int getidgiamgia() {
        return idgiamgia;
    }

    public void setidgiamgia(int idgiamgia) {
        this.idgiamgia = idgiamgia;
    }

    public String getidSP() {
        return idsp;
    }

    public void setidSp(String tensp) {
        this.idsp = tensp;
    }

    public int getPhantramgiam() {
        return phantramgiam;
    }

    public void setPhantramgiam(int phantramgiam) {
        this.phantramgiam = phantramgiam;
    }

    @Override
    public String toString() {
        return  phantramgiam +"%";
    }

}
