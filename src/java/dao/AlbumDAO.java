package dao;

import static dao.JDBCConnection.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Album;
import model.Singer;

/**
 *
 * @author Admin
 */
public class AlbumDAO extends JDBCConnection{

    public AlbumDAO() {
        super();
    }
    
    public Album getAlbumById(int id){
        Album album = null;
        String sql = "SELECT * FROM album WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idd = rs.getInt("id");
                String title = rs.getString("title");
                String img = rs.getString("image");
                album = new Album(idd,title,img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return album;
    } 
    
    public ArrayList<Album> getAllAlbum(){
        Album album = null;
        ArrayList<Album> listAlbum = new ArrayList<>();
        String sql = "SELECT * FROM album";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                album = new Album(rs.getInt("id"),rs.getString("title"),rs.getString("image"));
                listAlbum.add(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAlbum;
        
    }
}
