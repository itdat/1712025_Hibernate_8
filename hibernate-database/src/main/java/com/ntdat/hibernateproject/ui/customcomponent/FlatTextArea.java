/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntdat.hibernateproject.ui.customcomponent;

/**
 *
 * @author ntdat
 */
import java.awt.BasicStroke;  
import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Insets;  
import java.awt.Paint;  
import java.awt.RenderingHints;  
import java.awt.font.TextLayout;  
import java.awt.geom.Rectangle2D;  
import java.awt.geom.RoundRectangle2D;  
import javax.swing.JTextArea;
import javax.swing.JTextField;  
import javax.swing.border.EmptyBorder;  
  
public class FlatTextArea extends JTextArea {

    private int radius;

    public FlatTextArea() {
        super(10, 20);
        setOpaque(false);
        setBorder(null);
        setRadius(10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, getRadius(), getRadius());
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#ADADAD"));
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, getRadius(), getRadius());
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public int getRadius() {
        return radius;
    }

//    @Override
//    public Insets getInsets() {
//        int value = getRadius() / 10;
//        return new Insets(value, value, value, value);
//    }

}