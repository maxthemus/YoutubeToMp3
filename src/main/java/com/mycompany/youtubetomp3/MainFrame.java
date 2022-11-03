/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author max
 */
public class MainFrame extends JFrame {
    //Fields
    private TopPannel top;
    private BottomPannel bottom;
    private MiddlePannel middle;
    
    private ArrayList<Song> songs;
    
    
    //Constructor
    public MainFrame() {
        super("Youtube to Mp3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(700, 700));
    
        this.songs = new ArrayList<>();
        
        this.middle = new MiddlePannel(this.songs);
        this.top = new TopPannel(this, this.middle);
        this.bottom = new BottomPannel(this.middle);
        
        this.getContentPane().add(BorderLayout.NORTH, this.top);
        this.getContentPane().add(BorderLayout.CENTER, this.middle);
        this.getContentPane().add(BorderLayout.SOUTH, this.bottom);
        
    }
    
    
    //Methods
    public void output() {
        Outputer.writeOutput(songs);
    }
}
