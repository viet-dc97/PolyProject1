/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class JdbcHelper {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/qlxemay";
    static String user = "root";
    static String password = "12345678";
    static {
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    /**
     * * Xây dựng PreparedStatement * @param sql là câu lệnh SQL chứa có thể
     * chứa tham số. Nó có thể là một lời gọi thủ tục lưu * @param args là danh
     * sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     *
     *
     * @return PreparedStatement tạo được * @throws java.sql.SQLException lỗi
     * sai cú pháp
     */
    
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = null;       
        if(sql.trim().startsWith("{")){
            stmt = conn.prepareCall(sql); //Procedure
        }else{
            stmt = conn.prepareStatement(sql); //SQL
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i+1, args[i]);
        }
        return stmt;
    };
    
    /**
     * * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục
     * lưu thao tác dữ liệu * @param sql là câu lệnh SQL chứa có thể chứa tham
     * số. Nó có thể là một lời gọi thủ tục lưu * @param args là danh sách các
     * giá trị được cung cấp cho các tham số trong câu lệnh sql *
     */
    public static void update(String sql, Object... args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try{
                stmt.executeUpdate();
            }
            finally{
                stmt.getConnection().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }   
    };
    
    /**
     * * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ
     * liệu * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là
     * một lời gọi thủ tục lưu * @param args là danh sách các giá trị được cung
     * cấp cho các tham số trong câu lệnh sql
     */
    public static ResultSet query(String sql, Object... args) throws SQLException{
        PreparedStatement stmt = getStmt(sql, args);
        return stmt.executeQuery();
    };
}
