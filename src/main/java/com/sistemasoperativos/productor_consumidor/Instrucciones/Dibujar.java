/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Instrucciones;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Dimension;

/**
 *
 * @author julioaguilar
 */
public class Dibujar extends JPanel{
    
    @Override
    public void paint(Graphics grafica){
        Dimension tamano=getSize();
        ImageIcon icon=new ImageIcon("fondo.jpeg");
        
        grafica.drawImage(icon.getImage(), 0, 0, tamano.width,tamano.height,null);
        setOpaque(false);
        super.paintChildren(grafica);
    }
    
}
