/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap {
     private String maNcc ;
    private String tenNcc;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNcc, String tenNcc) {
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }
    
}
