/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.views.controls;

import com.kkp.myapp.helper.AppHelper;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author titan
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel() {
        this.loadImage("/com/kkp/myapp/assets/bg.jpg");
    }
    
    private void loadImage(String filename) {
        try {
            URL path = AppHelper.loadResource(filename);
            image = ImageIO.read(path);
        } catch (IOException ex) {
            // handle exception...
        } catch (Exception ex) {
            // handle exception...
        }
    }
    
    public void setImage(String path) {
        this.loadImage(path);
        this.invalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
