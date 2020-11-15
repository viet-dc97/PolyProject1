/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.HangXe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class HangXeDAO extends AbstractDAO<HangXe, String>{

    @Override
    public void insert(HangXe entity) {
        String sql = "INSERT INTO hangxe (mahang, tenhang) VALUES (?, ?)";
        JdbcHelper.update(sql, entity.getMaHang(), entity.getTenHang());
    }

    @Override
    public void update(HangXe entity) {
        String sql = "UPDATE hangxe SET tenhang=? WHERE mahang=?";
        JdbcHelper.update(sql, entity.getTenHang(), entity.getMaHang());
    }

    @Override
    public void delete(String maHang) {
        String sql = "DELETE FROM hangxe WHERE mahang=?";
        JdbcHelper.update(sql, maHang);
    }

    @Override
    public HangXe selectById(String maHang) {
        String sql = "SELECT * FROM hangxe WHERE mahang=?";
        List<HangXe> list = selectBySql(sql, maHang);
        return list.size() > 0 ? list.get(0) : null;    
    }

    @Override
    public List<HangXe> selectAll() {
        String sql = "SELECT * FROM hangxe";
        return selectBySql(sql);
    }

    @Override
    protected List<HangXe> selectBySql(String sqlString, Object... argsObjects) {
        List<HangXe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sqlString, argsObjects);
                while (rs.next()) {
                    HangXe entity = readFromResultSet(rs);
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
    protected HangXe readFromResultSet(ResultSet rs) {
        HangXe entity = new HangXe();
        try {
            entity.setMaHang(rs.getString("mahang"));
            entity.setTenHang(rs.getString("tenhang"));

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;    
    }
    
}
