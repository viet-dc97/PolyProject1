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
public class PhieuNhapChiTiet {
    private int maPhieuNhap;
    private String maXe ;
    private int soLuong;
    private double giaNhap;

    public PhieuNhapChiTiet() {
    }

    public PhieuNhapChiTiet(int maPhieuNhap, String maXe, int soLuong, double giaNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.maXe = maXe;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }
    
}
