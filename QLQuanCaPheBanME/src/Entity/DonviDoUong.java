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
public class DonviDoUong {

    private String ID_DonviSP;
    private String TenDonvi;
    private int Kichthuoc;
    public DonviDoUong(){
        
    }

    public DonviDoUong(String ID_DonviSP, String TenDonvi, int Kichthuoc) {
        this.ID_DonviSP = ID_DonviSP;
        this.TenDonvi = TenDonvi;
        this.Kichthuoc = Kichthuoc;
    }

    public String getID_DonviSP() {
        return ID_DonviSP;
    }

    public void setID_DonviSP(String ID_DonviSP) {
        this.ID_DonviSP = ID_DonviSP;
    }

    public String getTenDonvi() {
        return TenDonvi;
    }

    public void setTenDonvi(String TenDonvi) {
        this.TenDonvi = TenDonvi;
    }

    public int getKichthuoc() {
        return Kichthuoc;
    }

    public void setKichthuoc(int Kichthuoc) {
        this.Kichthuoc = Kichthuoc;
    }

    @Override
    public String toString() {
        return   TenDonvi;
    }
    
    
}
