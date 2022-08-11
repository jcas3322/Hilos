/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Instrucciones;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author julioaguilar
 */
public class Dibujos {
    private String fondo_jpanel;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image estado_fondo;
    private Image estado_entregando;
    
    public Dibujos(){
        x=40;
        y=60;
        fondo_jpanel="fondo.jpeg";
        try{
            ImageIcon img_fondo=new ImageIcon(fondo_jpanel);
            estado_fondo=img_fondo.getImage();
        }catch(Exception e){
            System.out.println("ERROR:... "+e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public void ejex(int z){dx=z;}
    public void ejey(int z){dy=z;}
    public void mover(){
        x+=dx;
        y+=dy;
    }
    
    public int tenerX(){return x;}
    public int tenerY(){return y;}
    public Image tenerImagenCocinando(){return estado_fondo;}
}
