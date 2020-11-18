/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.PhieuXuatChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class PhieuXuatChiTietDAO extends AbstractDAO<PhieuXuatChiTiet, String>{

    @Override
    public void insert(PhieuXuatChiTiet entity) {
        String sql = "INSERT INTO phieuxuatchitiet (maphieuxuat, maxe, soluong, giaban) VALUES (?,?,?,?)";
        JdbcHelper.update(sql, entity.getMaPhieuXuat(), entity.getMaXe(),
                entity.getSoLuong(), entity.getGiaXuat());
    }

    @Override
    public void update(PhieuXuatChiTiet entity) {
        String sql = "UPDATE phieuxuatchitiet set soluong = ?, giaban= ? where maphieuxuat = ? and maxe = ?"; 
       JdbcHelper.update(sql, entity.getSoLuong(), entity.getGiaXuat(),
               entity.getMaPhieuXuat(), entity.getMaXe());
    }

    @Override
    public void delete(String maPhieuXuat) {
        String sql = "DELETE FROM phieuxuatchitiet where maphieuxuat = ?";
        JdbcHelper.update(sql, maPhieuXuat);
    }

    @Override
    public PhieuXuatChiTiet selectById(String maPhieuXuat) {
        String sql = "SELECT * FROM phieuxuatchitiet where maphieuxuat = ?";
        List<PhieuXuatChiTiet> list = selectBySql(sql, maPhieuXuat);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<PhieuXuatChiTiet> selectAll() {
        String sql = "SELECT * FROM phieuxuatchitiet";
        return selectBySql(sql);
    }

    @Override
    protected List<PhieuXuatChiTiet> selectBySql(String sqlString, Object... argsObjects) {
        List<PhieuXuatChiTiet> list = new ArrayList<>();
        
        try {
            ResultSet rs = null;
            rs = utils.JdbcHelper.query(sqlString, argsObjects);
            while (rs.next()) {
                PhieuXuatChiTiet entity = readFromResultSet(rs);
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    protected PhieuXuatChiTiet readFromResultSet(ResultSet rs) {
        PhieuXuatChiTiet entity = new PhieuXuatChiTiet();
        try {           
            entity.setMaPhieuXuat(rs.getString(1));
            entity.setMaXe(rs.getString(2));
            entity.setSoLuong(rs.getInt(3));
            entity.setGiaXuat(rs.getDouble(4));
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
}
