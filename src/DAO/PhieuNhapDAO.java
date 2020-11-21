/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.PhieuNhap;
import entity.PhieuNhapChiTiet;
import entity.Xe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Administrator
 */
public class PhieuNhapDAO extends AbstractDAO<PhieuNhap, String>{

    @Override
    public void insert(PhieuNhap entity) {
        String sql = "INSERT INTO `phieunhap`(`maphieunhap`, `manv`, `mancc`, `ngaynhap`, `tongtien`) VALUES (?,?,?,?,?)";
        JdbcHelper.update(sql, entity.getMaPhieuNhap(),entity.getMaNv(),entity.getMaNcc(),entity.getNgayNhap(),entity.getTongTien());
    }

    @Override
    public void update(PhieuNhap entity) {
        String sql = "UPDATE `phieunhap` SET `manv`= ?,`mancc`= ?,`ngaynhap`= ?,`tongtien`= ? WHERE `maphieunhap` = ?";
        JdbcHelper.update(sql, entity.getMaNv(),entity.getMaNv(),entity.getMaNcc(),entity.getNgayNhap(),entity.getTongTien(),entity.getMaPhieuNhap());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM `phieunhap` WHERE `maphieunhap` = ?";
        JdbcHelper.update(sql, id);
    }

    @Override
    public PhieuNhap selectById(String id) {
        String sql = "select * from phieunhap where maphieunhap = ?";
        List<PhieuNhap> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<PhieuNhap> selectAll() {
        String sql = "select * from phieunhap";
        return selectBySql(sql);
    }

    @Override
    protected List<PhieuNhap> selectBySql(String sqlString, Object... argsObjects) {
        List<PhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sqlString, argsObjects);
                while (rs.next()) {                    
                    PhieuNhap entity = readFromResultSet(rs);
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
    protected PhieuNhap readFromResultSet(ResultSet rs) {
        PhieuNhap entity = new PhieuNhap();
        try {
            entity.setMaPhieuNhap(rs.getInt("maphieunhap"));
            entity.setMaNv(rs.getString("manv"));
            entity.setMaNcc(rs.getString("mancc"));
            entity.setNgayNhap(rs.getDate("ngaynhap"));
            entity.setTongTien(rs.getDouble("tongtien"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }
    
    public void updateSoLuong(PhieuNhap entity){
        String sql = "update phieunhap set tongtien = tongtien + ?";
        JdbcHelper.update(sql, entity.getTongTien());
    }
}
