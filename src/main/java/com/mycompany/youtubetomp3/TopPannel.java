/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author max
 */
public class TopPannel extends JPanel implements ActionListener{
    //Fields
    private JButton clearButton;
    private JButton downloadButton;
    
    private MiddlePannel middle;
    private MainFrame main;
    
    //Constructor
    public TopPannel(MainFrame main, MiddlePannel middle) {
        super();
        
        this.main = main;
        this.middle = middle;
        
        
        this.clearButton = new JButton("Clear");
        this.downloadButton = new JButton("Download");
        
        this.clearButton.addActionListener(this);
        this.downloadButton.addActionListener(this);
        
        this.add(this.clearButton);
        this.add(this.downloadButton);
    }
    
    
    //Methods
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.clearButton) {
            this.middle.clearSongs();
        }
        if(ae.getSource() == this.downloadButton) {
            this.main.output();
            
            //RUN BASH SCRIPT FOR DOWNLOAD
            if(System.getProperty("os.name").toLowerCase().startsWith("linux")) {
                //RUN BASH SCRIPT
                try {
                    Process downloader = Runtime.getRuntime().exec("./youtubeToMp3.sh");
                    downloader.waitFor(); // waits for download to finsh before continueing
                    System.out.println("FINISHED DOWNLOAD");
                    this.middle.clearSongs();
                } catch(Exception e) {
                    System.out.println(e);
                    System.out.println("FAILED TO DOWNLOAD!");
                    System.exit(0);
                }
                
            } else if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
                //RUN POWER SHELL SCRIPT
            }
            
        }
    }
}
