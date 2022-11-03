/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author max
 */
public class BottomPannel extends JPanel implements ActionListener {
    //Fields
    private JLabel name;
    private JTextField nameField;
    
    private JLabel artist;
    private JTextField artistField;
    
    private JButton addButton;
    
    private MiddlePannel middle;
    
    
    //Constructors
    public BottomPannel(MiddlePannel middle) {
        super();
        
        this.middle = middle;
        
        this.name = new JLabel("Name");
        this.nameField = new JTextField(15);
        
        this.artist = new JLabel("Artist");
        this.artistField = new JTextField(15);
        
        this.addButton = new JButton("Add");
        
        //Adding listener
        this.addButton.addActionListener(this);
        
        //Adding all componenets
        this.add(this.name);
        this.add(this.nameField);
        this.add(this.artist);
        this.add(this.artistField);
        this.add(this.addButton);
    }
    
    
    //Methods
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.addButton) {
            String name = this.nameField.getText();
            String artist = this.artistField.getText();
            
            Song song = new Song(name, artist);
            
            //Song can then be added to an arrayList
            this.middle.addSong(song);
        }
    }
    
}
