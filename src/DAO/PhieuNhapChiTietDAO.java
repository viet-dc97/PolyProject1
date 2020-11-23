/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.PhieuNhapChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Administrator
 */
public class PhieuNhapChiTietDAO extends AbstractDAO<PhieuNhapChiTiet, String>{

    @Override
    public void insert(PhieuNhapChiTiet entity) {
        String sql = "INSERT INTO `phieunhapchitiet`(`maphieunhap`, `maxe`, `soluong`, `gianhap`) VALUES (?,?,?,?)";
        JdbcHelper.update(sql, entity.getMaPhieuNhap(),entity.getMaXe(),entity.getSoLuong(),entity.getGiaNhap());
    }

    @Override
    public void update(PhieuNhapChiTiet entity) {
        String sql = "UPDATE `phieunhapchitiet` SET `maxe`= ?,`soluong`= ?,`gianhap`= ? WHERE `maphieunhap`= ?";
        JdbcHelper.update(sql, entity.getMaXe(),entity.getSoLuong(),entity.getGiaNhap(),entity.getMaPhieuNhap());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM `phieunhapchitiet` WHERE `maphieunhap`= ?";
        JdbcHelper.update(sql, id);
    }

    @Override
    public PhieuNhapChiTiet selectById(String id) {
        String sql = "select * from phieunhapchitiet where maphieunhap = ?";
        List<PhieuNhapChiTiet> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<PhieuNhapChiTiet> selectAll() {
        String sql = "select * from phieunhapchitiet";
        return selectBySql(sql);
    }

    @Override
    protected List<PhieuNhapChiTiet> selectBySql(String sqlString, Object... argsObjects) {
        List<PhieuNhapChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sqlString, argsObjects);
                while (rs.next()) {                    
                    PhieuNhapChiTiet entity = readFromResultSet(rs);
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    protected PhieuNhapChiTiet readFromResultSet(ResultSet rs) {
        PhieuNhapChiTiet entity = new PhieuNhapChiTiet();
        try {
            entity.setMaPhieuNhap(rs.getInt("maphieunhap"));
            entity.setMaXe(rs.getString("maxe"));
            entity.setSoLuong(rs.getInt("soluong"));
            entity.setGiaNhap(rs.getDouble("gianhap"));
        } catch (Exception e) {
        }
        return entity;
    }
    
    public void updateSoLuong(PhieuNhapChiTiet entity){
        String sql = "update phieunhap set tongtien = tongtien + ?";
        JdbcHelper.update(sql, entity.getSoLuong());
    }
    
    
    
}
