/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Instrucciones;
import com.sistemasoperativos.productor_consumidor.Pojos.Pedidos;
import java.util.concurrent.Semaphore;

/**
 *
 * @author julioaguilar
 */
public class Hilo_Pendientes_Cocinar extends Thread{
    private Semaphore semaforo;
    //public boolean iterar=true;
    public Hilo_Pendientes_Cocinar(Semaphore semaforo){
        this.semaforo=semaforo;
    }
    @Override
    public void run(){
        while (Procesos.iterar){
        try {
            this.semaforo.acquire();
            if(Procesos.pendientes_a_cocinar.size()==Procesos.maximo_de_pedidos &&
                    Procesos.mesa_bufer.size()==0){
                for(Pedidos pedido:Procesos.pendientes_a_cocinar){
                    Procesos.mesa_bufer.add(pedido);
                    Thread.sleep(1000);
                    //realizar instruccion de animacion
                    System.out.println("Cocinero Cocinando");
                    System.out.println("Cliente "+ pedido.getCliente_id()
                        + " shuko de " + pedido.getTipo_de_shuko());
                }
                Procesos.pendientes_a_cocinar.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
        }
    }
}
}
