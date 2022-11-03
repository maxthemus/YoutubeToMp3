/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author max
 */
public class MiddlePannel extends JPanel implements ActionListener {
    //Fields
    private ArrayList<Song> songs;
    private ArrayList<SongComponent> songComponents;
    
    //Constructors
    public MiddlePannel(ArrayList<Song> songs) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.songComponents = new ArrayList<>();
        
        
        this.songs = songs;
    }

    
    //Methods
    public void addSong(Song song) {
        this.songs.add(song);

        SongComponent tempComp = new SongComponent(this, song);
        this.songComponents.add(tempComp);
        this.add(tempComp);
    
        this.revalidate();
        this.repaint();
    }
    
    public void removeSong(int index) {
        this.songs.remove(index);
        SongComponent removeComp = this.songComponents.remove(index);
        this.remove(removeComp);
        
        this.revalidate();
        this.repaint();
    }
    
    public void clearSongs() {
        for(int i = this.songComponents.size(); i > 0; i--) {
            this.removeSong(i-1);
        }
        
        this.revalidate();
        this.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i = 0; i < this.songComponents.size(); i++) {
            if(ae.getSource() == this.songComponents.get(i).getButton()) {
                this.removeSong(i);
            }
        }
    }
}
