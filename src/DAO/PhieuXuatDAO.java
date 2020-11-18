/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.PhieuXuat;
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
public class PhieuXuatDAO extends AbstractDAO<PhieuXuat, String>{

    @Override
    public void insert(PhieuXuat entity) {
        String sql = "INSERT INTO phieuxuat (maphieuxuat,manv, makh, ngayxuat, tongtien) VALUES (?,?,?,?)";
        JdbcHelper.update(sql,entity.getMaPhieuXuat(), entity.getMaNv(), entity.getMaKh(),
                entity.getNgayXuat(), entity.getTongTien());
    }

    @Override
    public void update(PhieuXuat entity) {
        String sql = "UPDATE phieuxuat set manv = ?, makh= ?, ngayxuat=? ,tongtien=? where maphieuxuat = ?"; 
       JdbcHelper.update(sql, entity.getMaNv(), entity.getMaKh(),
                entity.getNgayXuat(), entity.getTongTien(),entity.getMaPhieuXuat());
    }

    @Override
    public void delete(String maPhieuXuat) {
        String sql = "DELETE FROM phieuxuat where maphieuxuat = ?";
        JdbcHelper.update(sql, maPhieuXuat);
    }

    @Override
    public PhieuXuat selectById(String maPhieuXuat) {
        String sql = "SELECT * FROM phieuxuat where maphieuxuat = ?";
        List<PhieuXuat> list = selectBySql(sql, maPhieuXuat);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<PhieuXuat> selectAll() {
        String sql = "SELECT * FROM phieuxuat";
        return selectBySql(sql);
    }

    @Override
    protected List<PhieuXuat> selectBySql(String sqlString, Object... argsObjects) {
        List<PhieuXuat> list = new ArrayList<>();
        
        try {
            ResultSet rs = null;
            rs = utils.JdbcHelper.query(sqlString, argsObjects);
            while (rs.next()) {
                PhieuXuat entity = readFromResultSet(rs);
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    protected PhieuXuat readFromResultSet(ResultSet rs) {
        PhieuXuat entity = new PhieuXuat();
        try {           
            entity.setMaPhieuXuat(rs.getString(1));
            entity.setMaNv(rs.getString(2));
            entity.setMaKh(rs.getString(3));
            entity.setNgayXuat(rs.getDate(4));
            entity.setTongTien(rs.getDouble(5));
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    
}
