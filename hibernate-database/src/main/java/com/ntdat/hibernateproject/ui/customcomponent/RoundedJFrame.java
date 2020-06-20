/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntdat.hibernateproject.ui.customcomponent;

import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author ntdat
 */
public class RoundedJFrame extends JFrame {
    public RoundedJFrame() {
        setLayout(null);
        setUndecorated(true);
        setSize(1280,768);
        setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0,0, 1280,768, 20,20));
    }
}
