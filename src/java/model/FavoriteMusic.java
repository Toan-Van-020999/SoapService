/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class FavoriteMusic implements Serializable{
    private int id;
    private User user;
    private Singer singer;

    public FavoriteMusic(int id, User user, Singer singer) {
        this.id = id;
        this.user = user;
        this.singer = singer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
    
    
}
