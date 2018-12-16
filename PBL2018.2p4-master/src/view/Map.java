/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Ultron
 */
public class Map extends JFrame{
    Map(){
        super.setTitle("Mapa da Bahia");
        super.setSize(700, 700);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("map.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(img, 100, 100, 500, 500, rootPane);      
    }
    
}

