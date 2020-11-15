/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class NhaCungCapDAO extends AbstractDAO<NhaCungCap, String>{

    @Override
    public void insert(NhaCungCap entity) {
        String sql = "INSERT INTO nhacc (mancc, tenncc) VALUES (?, ?)";
        JdbcHelper.update(sql, entity.getMaNcc(), entity.getTenNcc());
    }

    @Override
    public void update(NhaCungCap entity) {
        String sql = "UPDATE nhacc SET tenncc=? WHERE mancc=?";
        JdbcHelper.update(sql, entity.getTenNcc(), entity.getMaNcc());
    }

    @Override
    public void delete(String maNcc) {
        String sql = "DELETE FROM nhacc WHERE mancc=?";
        JdbcHelper.update(sql, maNcc); 
    }

    @Override
    public NhaCungCap selectById(String maNcc) {
        String sql = "SELECT * FROM nhacc WHERE mancc=?";
        List<NhaCungCap> list = selectBySql(sql, maNcc);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String sql = "SELECT * FROM nhacc";
        return selectBySql(sql); 
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sqlString, Object... argsObjects) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sqlString, argsObjects);
                while (rs.next()) {
                    NhaCungCap entity = readFromResultSet(rs);
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected NhaCungCap readFromResultSet(ResultSet rs) {
        NhaCungCap entity = new NhaCungCap();
        try {
            entity.setMaNcc(rs.getString("mancc"));
            entity.setTenNcc(rs.getString("tenncc"));

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;
    }
    
}
