/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sistemasoperativos.productor_consumidor;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Hilo_Entregar_Pedidos;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Hilo_Hacer_Pedidos;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Hilo_Pendientes_Cocinar;
import com.sistemasoperativos.productor_consumidor.Instrucciones.Procesos;
import com.sistemasoperativos.productor_consumidor.Vista.Vista_Principal;
import java.util.concurrent.Semaphore;

/**
 *
 * @author julioaguilar
 */
public class Productor_Consumidor {

    public static void main(String[] args) throws InterruptedException{
           Vista_Principal vista=new Vista_Principal();
           vista.setBounds(200,50,200,50);
           vista.setVisible(true);
        Semaphore semaforo=new Semaphore(1);
        //final Procesos proceso=new Procesos(semaforo);
        Hilo_Hacer_Pedidos hilo_pedidos=new Hilo_Hacer_Pedidos(semaforo);
        Hilo_Pendientes_Cocinar hilo_cocinar=new Hilo_Pendientes_Cocinar(semaforo);
        Hilo_Entregar_Pedidos hilo_entregar=new Hilo_Entregar_Pedidos(semaforo);
        hilo_pedidos.start();
        hilo_cocinar.start();
        hilo_entregar.start();
        
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
