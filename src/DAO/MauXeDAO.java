/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.MauXe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class MauXeDAO extends AbstractDAO<MauXe, String>{

    @Override
    public void insert(MauXe entity) {
        String sql = "INSERT INTO mauxe (mamau, tenmau) VALUES (?, ?)";
        JdbcHelper.update(sql, entity.getMaMau(), entity.getTenMau());
    }

    @Override
    public void update(MauXe entity) {
        String sql = "UPDATE mauxe SET tenmau=? WHERE maumau=?";
        JdbcHelper.update(sql, entity.getTenMau(), entity.getMaMau());
    }

    @Override
    public void delete(String maMau) {
        String sql = "DELETE FROM mauxe WHERE mamau=?";
        JdbcHelper.update(sql, maMau);
    }

    @Override
    public MauXe selectById(String maMau) {
        String sql = "SELECT * FROM hangxe WHERE mahang=?";
        List<MauXe> list = selectBySql(sql, maMau);
        return list.size() > 0 ? list.get(0) : null;  
    }

    @Override
    public List<MauXe> selectAll() {
        String sql = "SELECT * FROM mauxe";
        return selectBySql(sql);
    }

    @Override
    protected List<MauXe> selectBySql(String sqlString, Object... argsObjects) {
        List<MauXe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sqlString, argsObjects);
                while (rs.next()) {
                    MauXe entity = readFromResultSet(rs);
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
    protected MauXe readFromResultSet(ResultSet rs) {
        MauXe entity = new MauXe();
        try {
            entity.setMaMau(rs.getString(1));
            entity.setTenMau(rs.getString(2));

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;
    }
    
}
