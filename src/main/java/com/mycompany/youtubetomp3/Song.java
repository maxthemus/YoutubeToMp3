/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

/**
 *
 * @author max
 */
public class Song {
    //Fields
    private String name;
    private String artist;
    
    
    //Constructors
    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }
    
    
    //Methods
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
    
    @Override
    public String toString() {
        return this.name + " by " + this.artist;
    }
}
