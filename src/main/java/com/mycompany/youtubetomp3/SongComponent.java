/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author max
 */
public class SongComponent extends JPanel {
    //Fields
    private Song song;
    private JLabel name;
    private JLabel artist;
    private JButton removeButton;
    
    
    //Constructors
    public SongComponent(ActionListener listener, Song song) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        
        this.song = song;

        this.name = new JLabel(this.song.getName());
        this.artist = new JLabel(this.song.getArtist());
        this.removeButton = new JButton("X");
        
        this.removeButton.addActionListener(listener);
        
        int height = 10;
        int width = 20;
        this.name.setBorder(new EmptyBorder(height, width, height, height));
        this.artist.setBorder(new EmptyBorder(height,width,height,width));
        this.removeButton.setBorder(new EmptyBorder(height, width, height, width));
        
        
        this.add(name);
        this.add(artist);
        this.add(removeButton);
    }
    

    //Methods
    public Song getSong() {
        return this.song;
    }
    
    public JButton getButton() {
        return this.removeButton;
    }
    
}
