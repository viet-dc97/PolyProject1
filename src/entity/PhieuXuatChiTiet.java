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
public class PhieuXuatChiTiet {

    private String maPhieuXuat;
    private String maXe;
    private int soLuong;
    private double giaXuat;

    public PhieuXuatChiTiet() {
    }

    public PhieuXuatChiTiet(String maPhieuXuat, String maXe, int soLuong, double giaXuat) {
        this.maPhieuXuat = maPhieuXuat;
        this.maXe = maXe;
        this.soLuong = soLuong;
        this.giaXuat = giaXuat;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
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

    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }

}
