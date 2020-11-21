/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.NhanVien;
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
public class NhanVienDAO extends AbstractDAO<NhanVien, String>{

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO nhanvien (manv, hoten, matkhau, vaitro, sodt, email) VALUES (?, ?,?,?,?,?)";
        JdbcHelper.update(sql, entity.getMaNv(), entity.getHoTen(),
                entity.getMatKhau(), entity.getVaiTro(),
                entity.getSoDt(), entity.getEmail());
    }

    @Override
    public void update(NhanVien entity) {
       String sql = "UPDATE nhanvien set hoten = ?, matkhau= ?, vaitro=? ,sodt=? , email=? where manv = ?"; 
       JdbcHelper.update(sql, entity.getHoTen(), entity.getMatKhau(),
               entity.getVaiTro(), entity.getSoDt(),
               entity.getEmail(), entity.getMaNv());
    }

    @Override
    public void delete(String maNv) {
        String sql = "DELETE FROM nhanvien where manv = ?";
        JdbcHelper.update(sql, maNv);
    }

    @Override
    public NhanVien selectById(String maNv) {
        String sql = "SELECT * FROM nhanvien where maNv = ?";
        List<NhanVien> list = selectBySql(sql, maNv);
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM nhanvien";
        return selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sqlString, Object... argsObjects) {
        List<NhanVien> list = new ArrayList<>();
        
        try {
            ResultSet rs = null;
            rs = utils.JdbcHelper.query(sqlString, argsObjects);
            while (rs.next()) {
                NhanVien entity = readFromResultSet(rs);
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    protected NhanVien readFromResultSet(ResultSet rs) {
        NhanVien entity = new NhanVien();
        try {           
            entity.setMaNv(rs.getString(1));
            entity.setHoTen(rs.getString(2));
            entity.setMatKhau(rs.getString(3));
            entity.setVaiTro(rs.getBoolean(4));
            entity.setSoDt(rs.getString(5));
            entity.setEmail(rs.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
        public List<NhanVien> SelectByKeyword(String keyword) {
        String sql = "SELECT * FROM nhanvien WHERE hoten LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
    
}
