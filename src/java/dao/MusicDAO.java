/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import model.Album;
import model.Music;
import model.Singer;

/**
 *
 * @author Admin
 */
public class MusicDAO extends JDBCConnection{

    public MusicDAO() {
        super(); 
    }
    
    public Music getMusicById(int id) {
        Music music = null;
        String sql = "SELECT * FROM song WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            AlbumDAO albumDAO = new AlbumDAO();
            SingerDAO singerDAO = new SingerDAO();
            while (rs.next()){
                int idSinger = rs.getInt("idSinger");
                int idAlbum = rs.getInt("idAlbum");
                Album album = albumDAO.getAlbumById(idAlbum);
                Singer singer = singerDAO.getSingerById(idSinger);
                music = new Music(rs.getInt("id"),rs.getString("title"),rs.getString("link"),rs.getString("image"),album,singer);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return music;
    }   
    
    
    public ArrayList<Music> getAllMusic() {
        ArrayList<Music> listMs = new ArrayList<>();
        Music music = null;
        String sql = "SELECT * FROM song";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            AlbumDAO albumDAO = new AlbumDAO();
                SingerDAO singerDAO = new SingerDAO();
            while (rs.next()){
                int idSinger = rs.getInt("idSinger");
                int idAlbum = rs.getInt("idAlbum");
                Album album = albumDAO.getAlbumById(idAlbum);
                Singer singer = singerDAO.getSingerById(idSinger);
                music = new Music(rs.getInt("id"),rs.getString("title"),rs.getString("link"),rs.getString("image"),album,singer);  
                listMs.add(music);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMs;
    }
}
