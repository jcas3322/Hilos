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
import javax.swing.ImageIcon;

/**
 *
 * @author julioaguilar
 */
public class Vista_Principal extends javax.swing.JFrame implements ActionListener{

    private int x,y,fijox,fijoy;
    private int original_x_comida,original_y_comida,x_comida,y_comida;
    private Dibujar dibujar=new Dibujar();
    private String chorizo="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif";
    private String longaniza="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/longaniza.gif";
    private String cocinando="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cocinando.gif";
    private String descansando="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/descansando.gif";
    private String cliente1_pide="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cliente1.gif";
    private String cliente2_pide="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cliente2.gif";
    private String cliente1_come="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/comiendo1.gif";
    private String cliente2_come="/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/comiendo2.gif";
    /**
     * Creates new form Vista_Principal
     */
    
    public void cambiar_estado_cliente1_come(){cliente1.setIcon(new ImageIcon(cliente1_come));}
    public void cambiar_estado_cliente1_pide(){cliente1.setIcon(new ImageIcon(cliente1_pide));}
    public void cambiar_estado_cliente2_come(){cliente2.setIcon(new ImageIcon(cliente2_come));}
    public void cambiar_estado_cliente2_pide(){cliente2.setIcon(new ImageIcon(cliente1_pide));}
    public void cambiar_estado_cocinero_cocinando(){imagen_cocinero.setIcon(new ImageIcon(cocinando));}
    public void cambiar_estado_cocinero_descansando(){imagen_cocinero.setIcon(new ImageIcon(descansando));}
    public void mover_articulo_1(){
        int n=1;
        while (n<50){
            if (n>1 && n < 4){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
                n++;
            }else{
                if (n>46){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(50-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+3);
                }
            }
        }
    }
    public void mover_articulo_2(){
        int n=1;
        while (n<40){
            if (n>1 && n < 3){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
                n++;
            }else{
                if (n>37){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(40-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+2);
                }
            }
        }
    }
    public void mover_articulo_3(){
        int n=1;
        while (n<30){
            if (n>1 && n < 2){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
                n++;
            }else{
                if (n>28){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(30-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+1);
                }
            }
        }
    }
    public void mover_articulo_4(){
        int n=1;
        while (n<20){
            if (n>1 && n < 4){
                articulo1.setLocation(original_x_comida+n, original_y_comida+n);
                n++;
            }else{
                if (n>16){
                    articulo1.setLocation(original_x_comida+n, original_y_comida+(20-n));
                }else{
                    articulo1.setLocation(original_x_comida+n, original_y_comida+3);
                }
            }
        }
    }

    
    public Vista_Principal() {
        initComponents();
        original_x_comida=articulo1.getX();
        original_y_comida=articulo1.getY();
        imagen_cocinero.setIcon(new ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cocinando.gif"));
        fijox=imagen_cocinero.getX();
        fijoy=imagen_cocinero.getY();
        btnDetener.addActionListener(this);
        btnEmpezar.addActionListener(this);
        //articulo1.setVisible(false);
        //articulo2.setVisible(false);
        //articulo3.setVisible(false);
        //articulo4.setVisible(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        btnEmpezar.setText("Empezar");
        jPanel1.add(btnEmpezar);
        btnEmpezar.setBounds(230, 20, 100, 23);

        btnDetener.setText("Detener");
        jPanel1.add(btnDetener);
        btnDetener.setBounds(410, 20, 110, 23);

        imagen_cocinero.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cocinando.gif")); // NOI18N
        jPanel1.add(imagen_cocinero);
        imagen_cocinero.setBounds(150, 200, 100, 100);

        cliente1.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/cliente1.gif")); // NOI18N
        jPanel1.add(cliente1);
        cliente1.setBounds(710, 160, 120, 140);

        cliente2.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/cliente2.gif")); // NOI18N
        jPanel1.add(cliente2);
        cliente2.setBounds(620, 220, 100, 100);

        cliente1_habla.setText("Pedido cliente 1");
        jPanel1.add(cliente1_habla);
        cliente1_habla.setBounds(720, 140, 110, 17);

        cliente2_habla.setText("Pedido cliente 2");
        jPanel1.add(cliente2_habla);
        cliente2_habla.setBounds(620, 200, 120, 17);

        articulo1.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif")); // NOI18N
        jPanel1.add(articulo1);
        articulo1.setBounds(320, 200, 90, 100);

        articulo2.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif")); // NOI18N
        jPanel1.add(articulo2);
        articulo2.setBounds(320, 200, 80, 100);

        articulo3.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/longaniza.gif")); // NOI18N
        jPanel1.add(articulo3);
        articulo3.setBounds(310, 210, 80, 100);

        articulo4.setIcon(new javax.swing.ImageIcon("/Users/julioaguilar/NetBeansProjects/Hilos/src/imagenes/2/chorizo.gif")); // NOI18N
        jPanel1.add(articulo4);
        articulo4.setBounds(320, 200, 90, 100);

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
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnDetener){
            Buffer_General.iterar=false;
        }
        if (e.getSource()==btnEmpezar){
            Buffer_General.iterar=true;
            empezar();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void empezar(){
        Semaphore semaforo=new Semaphore(1);
        //final Procesos proceso=new Procesos(semaforo);
        Hilo_Hacer_Pedidos hilo_pedidos=new Hilo_Hacer_Pedidos(semaforo, this);
        Hilo_Pendientes_Cocinar hilo_cocinar=new Hilo_Pendientes_Cocinar(semaforo);
        Hilo_Entregar_Pedidos hilo_entregar=new Hilo_Entregar_Pedidos(semaforo);
        hilo_pedidos.start();
        hilo_cocinar.start();
        hilo_entregar.start();
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
