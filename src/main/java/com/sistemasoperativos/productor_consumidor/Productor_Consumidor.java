/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sistemasoperativos.productor_consumidor;
import com.sistemasoperativos.productor_consumidor.Vista.Vista_Principal;

/**
 *
 * @author julioaguilar
 */
public class Productor_Consumidor {

    public static void main(String[] args){
           Vista_Principal vista=new Vista_Principal();
           vista.setBounds(100,50,840,430);
           vista.setResizable(false);
           vista.setVisible(true);
        
/*        int contador=0;
        while(contador<1000){
            Thread.sleep(5000);
            contador++;
            if (contador==98){
                Procesos.iterar=false;
            }
        }*/
    }
}
