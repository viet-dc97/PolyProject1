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
public class PhieuNhap {
    private int maPhieuNhap ;
    private String maNv ;
    private String maNcc ;
    private Date ngayNhap ;
    private double tongTien;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPhieuNhap, String maNv, String maNcc, Date ngayNhap, double tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNv = maNv;
        this.maNcc = maNcc;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
