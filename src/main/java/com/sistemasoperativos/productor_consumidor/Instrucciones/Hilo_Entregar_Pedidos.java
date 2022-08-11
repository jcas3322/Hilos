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
public class Hilo_Entregar_Pedidos extends Thread{
    private Semaphore semaforo;
    //public boolean iterar=true;
    public Hilo_Entregar_Pedidos(Semaphore semaforo){
        this.semaforo=semaforo;
    }
    @Override
    public void run(){
        while(Buffer_General.iterar){
        try {
            this.semaforo.acquire();
            if (Buffer_General.mesa_bufer.size()==Buffer_General.maximo_de_pedidos &&
                    Buffer_General.pendientes_a_cocinar.size()==0){
                for(Pedidos pedido:Buffer_General.mesa_bufer){
                    Thread.sleep(1000);
                    //realizar instruccion
                    System.out.println("Entregando Pedido");
                    System.out.println("Cliente " + pedido.getCliente_id()
                            + " shuko de " +pedido.getTipo_de_shuko());
                }
                Buffer_General.mesa_bufer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.semaforo.release();
        }
        
    }
    
}
}