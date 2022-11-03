/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youtubetomp3;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author max
 */
public class Outputer {
    //Fields
    
    //Constructors
    
    //Methods
    public static void writeOutput(ArrayList<Song> songs) {
        try {
            File output = new File("./temp/names.txt");
        
            FileWriter writer = new FileWriter(output);
            for(int i = 0; i < songs.size(); i++) {
                writer.write(songs.get(i).toString()+"\n");
            }
            
            writer.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
