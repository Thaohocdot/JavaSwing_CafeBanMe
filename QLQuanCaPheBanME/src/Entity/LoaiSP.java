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
public class LoaiSP {
    private String ID_LoaiSP ;
    private String TenLoai ;
    public LoaiSP(){
        
        
    }

    public LoaiSP(String ID_LoaiSP, String TenLoai) {
        this.ID_LoaiSP = ID_LoaiSP;
        this.TenLoai = TenLoai;
    }

    public String getID_LoaiSP() {
        return ID_LoaiSP;
    }

    public void setID_LoaiSP(String ID_LoaiSP) {
        this.ID_LoaiSP = ID_LoaiSP;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    @Override
    public String toString() {
        return  TenLoai ;
    }
    
}
