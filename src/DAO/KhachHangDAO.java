/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO extends AbstractDAO<KhachHang, String> {

    @Override
    public void insert(KhachHang entity) {
        String sql = "INSERT INTO khachhang (makh, hoten, gioitinh,"
                + " diachi, sodt)"
                + " VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.update(sql, entity.getMaKh(),
                entity.getHoTen(), entity.getGioiTinh(),
                entity.getDiaChi(), entity.getSoDt());
    }

    @Override
    public void update(KhachHang entity) {
        String sql = "UPDATE khachhang SET hoten=?, gioitinh=?,"
                + " diachi=?, sodt=?"
                + " WHERE makh=?";
        JdbcHelper.update(sql, entity.getHoTen(),
                entity.getGioiTinh(), entity.getDiaChi(),
                entity.getSoDt(), entity.getMaKh());
    }

    @Override
    public void delete(String maKh) {
        String sql = "DELETE FROM khachhang WHERE makh=?";
        JdbcHelper.update(sql, maKh);
    }

    @Override
    public KhachHang selectById(String maKh) {
        String sql = "SELECT * FROM khachhang WHERE makh=?";
        List<KhachHang> list = selectBySql(sql, maKh);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM khachhang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sqlString, Object... argsObjects) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sqlString, argsObjects);
                while (rs.next()) {
                    KhachHang entity = readFromResultSet(rs);
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    protected KhachHang readFromResultSet(ResultSet rs) {
        KhachHang entity = new KhachHang();
        try {
            entity.setMaKh(rs.getString("makh"));
            entity.setHoTen(rs.getString("hoten"));
            entity.setGioiTinh(rs.getBoolean("gioitinh"));
            entity.setDiaChi(rs.getString("diachi"));
            entity.setSoDt(rs.getString("sodt"));

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;   
    }

}
