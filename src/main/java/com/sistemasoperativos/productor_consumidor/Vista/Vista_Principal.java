/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Vista;

import com.sistemasoperativos.productor_consumidor.Instrucciones.Hilo_Entregar_Pedidos;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Hilo_Hacer_Pedidos;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Hilo_Pendientes_Cocinar;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Buffer_General;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Dibujar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author julioaguilar
 */
public class Vista_Principal extends javax.swing.JFrame implements ActionListener{

    private int x,y,fijox,fijoy,cliente1x,cliente2x,cliente1y,cliente2y;
    private int original_x_comida,original_y_comida,x_comida,y_comida;
    private String chorizo="/imagenes/2/chorizo.gif";///Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif";
    private String longaniza="/imagenes/2/longaniza.gif";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/longaniza.gif";
    private String cocinando="/imagenes/2/cocinando.gif";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cocinando.gif";
    private String descansando="/imagenes/descansando.png";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/descansando.png";
    private String cliente1_pide="/imagenes/cliente1.gif";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/cliente1.gif";
    private String cliente2_pide="/imagenes/2/cliente2.gif";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cliente2.gif";
    private String cliente1_come="/imagenes/2/comiendo1.gif";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/comiendo1.gif";
    private String cliente2_come="/imagenes/2/comiendo2.gif";//"/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/comiendo2.gif";
    private Semaphore semaforo=new Semaphore(1);
    private Hilo_Hacer_Pedidos hilo_pedidos=new Hilo_Hacer_Pedidos(semaforo, this);
    private Hilo_Pendientes_Cocinar hilo_cocinar=new Hilo_Pendientes_Cocinar(semaforo,this);
    private Hilo_Entregar_Pedidos hilo_entregar=new Hilo_Entregar_Pedidos(semaforo,this);

    /**
     * Creates new form Vista_Principal
     */
    public void imagen1(int i){
        if (i==1)articulo1.setIcon(new ImageIcon(getClass().getResource(chorizo)));
        if (i==2)articulo1.setIcon(new ImageIcon(getClass().getResource(longaniza)));
    }
    public void imagen2(int i){
        if (i==1)articulo2.setIcon(new ImageIcon(getClass().getResource(chorizo)));
        if (i==2)articulo2.setIcon(new ImageIcon(getClass().getResource(longaniza)));
    }
    public void imagen3(int i){
        if (i==1)articulo3.setIcon(new ImageIcon(getClass().getResource(chorizo)));
        if (i==2)articulo3.setIcon(new ImageIcon(getClass().getResource(longaniza)));
    }
    public void imagen4(int i){
        if (i==1)articulo4.setIcon(new ImageIcon(getClass().getResource(chorizo)));
        if (i==2)articulo4.setIcon(new ImageIcon(getClass().getResource(longaniza)));
    }
    public void mover_cliente1(){
        cliente1.setLocation(cliente1x-250, cliente1y);
    }
    public void mover_cliente2(){
        cliente2.setLocation(cliente2x-250, cliente2y-20);
    }
    public void regresar_cliente1(){
        cliente1.setLocation(cliente1x, cliente1y);
        cliente1.setIcon(new ImageIcon(getClass().getResource(cliente1_pide)));
    }
    public void regresar_cliente2(){
        cliente2.setLocation(cliente2x, cliente2y);
        cliente2.setIcon(new ImageIcon(getClass().getResource(cliente2_pide)));
    }
    public void cambiar_estado_cliente1_come(){cliente1.setIcon(new ImageIcon(getClass().getResource(cliente1_come)));}
    public void cambiar_estado_cliente1_pide(String pedido) throws InterruptedException{cliente1.setIcon(new ImageIcon(getClass().getResource(cliente1_pide)));
        cliente1_habla.setText("Dame de " + pedido +" porfa");
        Thread.sleep(2000);
        cliente1_habla.setText(".");
    }
    public void cambiar_estado_cliente2_come(){cliente2.setIcon(new ImageIcon(getClass().getResource(cliente2_come)));}
    public void cambiar_estado_cliente2_pide(String pedido) throws InterruptedException{cliente2.setIcon(new ImageIcon(getClass().getResource(cliente2_pide)));
        cliente2_habla.setText("Dame de " + pedido + " porfa");
        Thread.sleep(2000);
        cliente2_habla.setText(".");
    }
    public void cambiar_estado_cocinero_cocinando(){imagen_cocinero.setIcon(new ImageIcon(getClass().getResource(cocinando)));}
    public void cambiar_estado_cocinero_descansando(){imagen_cocinero.setIcon(new ImageIcon(getClass().getResource(descansando)));}
    public void mover_articulo_1() throws InterruptedException{
        int n=1;
        while (n<170){
            articulo1.setLocation(original_x_comida+n, original_y_comida);
            /*
            if (n>1 && n < 4){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
            }else{
                if (n>46){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(50-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+3);
                }
            }*/
            n++;
            Thread.sleep(30);
        }
    }
    public void mover_articulo_2() throws InterruptedException{
        int n=1;
        while (n<110){
/*            if (n>1 && n < 3){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
            }else{
                if (n>37){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(40-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+2);
                }
            }*/
            articulo2.setLocation(original_x_comida+n, original_y_comida);

            n++;
            Thread.sleep(30);
        }
    }
    public void mover_articulo_3() throws InterruptedException{
        int n=1;
        while (n<53){
            /*
            if (n>1 && n < 2){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
            }else{
                if (n>28){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(30-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+1);
                }
            }*/
            articulo3.setLocation(original_x_comida+n, original_y_comida);
            n++;
            Thread.sleep(30);
        }
    }
    public void mover_articulo_4() throws InterruptedException{
        int n=1;
        while (n<1){
            /*
            if (n>1 && n < 4){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
            }else{
                if (n>16){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(20-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+3);
                }
            }*/
            articulo4.setLocation(original_x_comida+n, original_y_comida);
            n++;
            Thread.sleep(30);
        }
    }
    public void articulo1_visible(){
        articulo1.setVisible(true);        
    }
    public void articulo2_visible(){
        articulo2.setVisible(true);        
    }
    public void articulo3_visible(){
        articulo3.setVisible(true);        
    }
    public void articulo4_visible(){
        articulo4.setVisible(true);        
    }
    public void articulo1_no_visible(){
        articulo1.setVisible(false);        
    }
    public void articulo2_no_visible(){
        articulo2.setVisible(false);        
    }
    public void articulo3_no_visible(){
        articulo3.setVisible(false);        
    }
    public void articulo4_no_visible(){
        articulo4.setVisible(false);        
    }

    public void cocinero_responde() throws InterruptedException{
        Thread.sleep(2000);
        mensaje_cocinero.setText("Ok chino, ¿algo mas?");
        Thread.sleep(3000);
        mensaje_cocinero.setText("");
    }
    
    public Vista_Principal() {
        initComponents();
        //System.out.println("Prueba de URL: " + getClass().getResource(""));
        original_x_comida=articulo1.getX();
        original_y_comida=articulo1.getY()+5;
        cliente1x=cliente1.getX();
        cliente1y=cliente1.getY();
        cliente2x=cliente2.getX();
        cliente2y=cliente2.getY();
        //imagen_cocinero.setIcon(new ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cocinando.gif"));
        fijox=imagen_cocinero.getX();
        fijoy=imagen_cocinero.getY();
        btnDetener.addActionListener(this);
        btnEmpezar.addActionListener(this);
        articulo1.setVisible(false);
        articulo2.setVisible(false);
        articulo3.setVisible(false);
        articulo4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Dibujar();
        btnEmpezar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();
        imagen_cocinero = new javax.swing.JLabel();
        cliente1 = new javax.swing.JLabel();
        cliente2 = new javax.swing.JLabel();
        cliente1_habla = new javax.swing.JLabel();
        cliente2_habla = new javax.swing.JLabel();
        articulo1 = new javax.swing.JLabel();
        articulo2 = new javax.swing.JLabel();
        articulo3 = new javax.swing.JLabel();
        articulo4 = new javax.swing.JLabel();
        mensaje_cocinero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        btnEmpezar.setText("Empezar");
        jPanel1.add(btnEmpezar);
        btnEmpezar.setBounds(230, 20, 100, 23);

        btnDetener.setText("Detener");
        jPanel1.add(btnDetener);
        btnDetener.setBounds(410, 20, 110, 23);

        imagen_cocinero.setIcon(new javax.swing.ImageIcon(getClass().getResource(descansando)));
        jPanel1.add(imagen_cocinero);
        imagen_cocinero.setBounds(150, 220, 80, 160);

        cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cliente1_pide)));
        jPanel1.add(cliente1);
        cliente1.setBounds(710, 210, 120, 140);

        cliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cliente2_pide)));
        jPanel1.add(cliente2);
        cliente2.setBounds(610, 260, 100, 100);

        cliente1_habla.setForeground(new java.awt.Color(255, 255, 255));
        cliente1_habla.setText(".");
        jPanel1.add(cliente1_habla);
        cliente1_habla.setBounds(670, 190, 160, 17);

        cliente2_habla.setForeground(new java.awt.Color(255, 255, 255));
        cliente2_habla.setText(".");
        jPanel1.add(cliente2_habla);
        cliente2_habla.setBounds(550, 230, 170, 17);

        articulo1.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif")); // NOI18N
        jPanel1.add(articulo1);
        articulo1.setBounds(320, 170, 90, 100);

        articulo2.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif")); // NOI18N
        jPanel1.add(articulo2);
        articulo2.setBounds(320, 170, 80, 100);

        articulo3.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/longaniza.gif")); // NOI18N
        jPanel1.add(articulo3);
        articulo3.setBounds(310, 170, 80, 100);

        articulo4.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif")); // NOI18N
        jPanel1.add(articulo4);
        articulo4.setBounds(290, 170, 90, 100);

        mensaje_cocinero.setForeground(new java.awt.Color(255, 255, 255));
        mensaje_cocinero.setText(".");
        jPanel1.add(mensaje_cocinero);
        mensaje_cocinero.setBounds(170, 190, 160, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 840, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel articulo1;
    private javax.swing.JLabel articulo2;
    private javax.swing.JLabel articulo3;
    private javax.swing.JLabel articulo4;
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JLabel cliente1;
    private javax.swing.JLabel cliente1_habla;
    private javax.swing.JLabel cliente2;
    private javax.swing.JLabel cliente2_habla;
    private javax.swing.JLabel imagen_cocinero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mensaje_cocinero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnDetener){
            try {
                Buffer_General.iterar=false;
                Thread.sleep(3000);
                btnEmpezar.setEnabled(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(Vista_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==btnEmpezar){
            Buffer_General.iterar=true;
            empezar();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void empezar(){
        hilo_pedidos.start();
        hilo_cocinar.start();
        hilo_entregar.start();
        btnEmpezar.setEnabled(false);
    }
    
    public void mover_cocinero_iz(){
        x=fijox;
        y=fijoy;
        imagen_cocinero.setLocation(x+2, y);
    }
    public void mover_cocinero_der(){
        x=fijox;
        y=fijoy;
        imagen_cocinero.setLocation(x-2, y);
    }
}
