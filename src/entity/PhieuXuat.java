/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class PhieuXuat {

    private int maPhieuXuat;
    private String maNv;
    private String maKh;
    private Date ngayXuat;
    private double tongTien;

    public PhieuXuat() {
    }

    public PhieuXuat(int maPhieuXuat, String maNv, String maKh, Date ngayXuat, double tongTien) {
        this.maPhieuXuat = maPhieuXuat;
        this.maNv = maNv;
        this.maKh = maKh;
        this.ngayXuat = ngayXuat;
        this.tongTien = tongTien;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
