/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasefondo;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author Sony
 */
public class Fondo implements Border {

    BufferedImage cargarImagen;

    public Fondo(String r) {
        try {
            URL ruta = new URL(getClass().getResource(r).toString());
            cargarImagen = ImageIO.read(ruta);
        } catch (Exception e) {
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(cargarImagen, 0, 0, width, height, null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

} 
