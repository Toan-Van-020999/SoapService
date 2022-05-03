/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.AlbumDAO;
import dao.LoginDAO;
import dao.MusicDAO;
import dao.SingerDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Album;
import model.Music;
import model.Singer;
import model.User;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "MusicService")
public class MusicService {
    @WebMethod(operationName = "getAllMusic")
    public ArrayList<Music> getAllMusic() {
        MusicDAO mdao = new MusicDAO();
        ArrayList<Music> listMs = mdao.getAllMusic();
        return listMs;
    }
    
    @WebMethod(operationName = "getAllAlbum")
    public ArrayList<Album> getAllAlbum() {
        AlbumDAO albumDAO = new AlbumDAO();
        ArrayList<Album> listAl = albumDAO.getAllAlbum();
        return listAl;
    }
    
    @WebMethod(operationName = "getAllSinger")
    public ArrayList<Singer> getAllSinger() {
        SingerDAO singerDAO = new SingerDAO();
        ArrayList<Singer> listSG = singerDAO.getAllSinger();
        return listSG;
    }
    
    
    @WebMethod(operationName = "getMusicById")  
    public Music getMusicById(@WebParam(name = "id") int id) {
        MusicDAO mdao = new MusicDAO();
        Music music = mdao.getMusicById(id);
        return music;
    }
    
    @WebMethod(operationName = "checkLogin")
    public User checkLogin(@WebParam(name = "user") User user) {
        LoginDAO ldao = new LoginDAO();
        return ldao.checkLogin(user);
    }
}
