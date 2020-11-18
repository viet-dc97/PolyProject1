/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Xe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author PC
 */
public class XeDAO extends AbstractDAO< Xe , String>{

    String sql_Insert = "Insert into Xe(maxe ,tenxe ,mamau,mahang,soluong,gianhap,giaban,hinh) values (?,?,?,?,?,?,?,?)";
    String sql_Update = "Update Xe Set tenxe =? , mamau =?, mahang =?,soluong=?,gianhap=?,giaban=?,hinh=? where maxe=?";
    String sql_Delete = "Delete from Xe where maxe =?";
    String sql_selectAll = "Select * from Xe";
    String sql_selectByID= "select * from Xe where maxe =?";
    @Override
    public void insert(Xe entity) {
        JdbcHelper.update(sql_Insert, entity.getMaXe(),entity.getTenXe(),entity.getMaMau(),entity.getMaHang(),entity.getSoLuong(),entity.getGiaNhap()
        ,entity.getGiaBan(),entity.getHinh());
    }

    @Override
    public void update(Xe entity) {
        JdbcHelper.update(sql_Update, entity.getTenXe(),entity.getMaMau(),entity.getMaHang(),entity.getSoLuong(),entity.getGiaNhap()
        ,entity.getGiaBan(),entity.getHinh(),entity.getMaXe());
    }

    @Override
    public void delete(String maXe) {
        JdbcHelper.update(sql_Delete, maXe);
    }

    @Override
    public Xe selectById(String maXe) {
        List<Xe> list = this.selectBySql(sql_selectByID, maXe);
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public List<Xe> selectAll() {
        return this.selectBySql(sql_selectAll);
    }

    @Override
    protected List <Xe> selectBySql(String sqlString, Object... argsObjects) {
        List <Xe> list =  new ArrayList<>();
        
        try{
            ResultSet rs =null;
            try{
                rs = JdbcHelper.query(sqlString, argsObjects);
                while(rs.next()){
                    Xe entity = readFromResultSet(rs);
                    list.add(entity);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    protected Xe readFromResultSet(ResultSet rs) {
        Xe entity = new  Xe();
        try{
            entity.setMaXe(rs.getString("maxe"));
            entity.setTenXe(rs.getString("tenxe"));
            entity.setMaMau(rs.getString("mamau"));
            entity.setMaHang(rs.getString("mahang"));
            entity.setSoLuong(rs.getInt("soluong"));
            entity.setGiaNhap(rs.getDouble("gianhap"));
            entity.setGiaBan(rs.getDouble("giaban"));
            entity.setHinh(rs.getString("hinh"));
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return entity;
        
    }
    
    public List<Xe> selectByHangxe(String mahang){
        String sql = "select * from xe where mahang = ?";
        return this.selectBySql(sql, mahang);
    }
    
}
