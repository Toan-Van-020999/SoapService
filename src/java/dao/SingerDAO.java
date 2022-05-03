/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.JDBCConnection.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Album;
import model.Music;
import model.Singer;

/**
 *
 * @author Admin
 */
public class SingerDAO extends JDBCConnection{

    public SingerDAO() {
        super();
    }
    
    public Singer getSingerById(int id){
        Singer singer = null;
        String sql = "SELECT * FROM singer WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                singer = new Singer(rs.getInt("id"),rs.getString("name"),rs.getString("image"),rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return singer;
    } 
    
    public ArrayList<Singer> getAllSinger(){
        Singer singer = null;
        ArrayList<Singer> listSinger = new ArrayList<>();
        String sql = "SELECT * FROM singer";
        try {
            AlbumDAO albumDAO = new AlbumDAO();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                singer = new Singer(rs.getInt("id"),rs.getString("name"),rs.getString("image"),rs.getInt("age"));
                listSinger.add(singer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinger;
    } 

    
}
