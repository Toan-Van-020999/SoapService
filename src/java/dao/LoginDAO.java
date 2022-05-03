/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author Admin
 */
public class LoginDAO extends JDBCConnection{

    public LoginDAO() {
        super();
    }
    
    public User checkLogin(User user){
        User us = null;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                us = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }    
    
    
}
