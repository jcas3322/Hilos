/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Instrucciones;
import com.sistemasoperativos.productor_consumidor.Pojos.Pedidos;
import com.sistemasoperativos.productor_consumidor.Vista.Vista_Principal;
import java.util.concurrent.Semaphore;

/**
 *
 * @author julioaguilar
 */
public class Hilo_Pendientes_Cocinar extends Thread{
    private Semaphore semaforo;
    private Vista_Principal vista;
    //public boolean iterar=true;
    public Hilo_Pendientes_Cocinar(Semaphore semaforo, Vista_Principal vista){
        this.semaforo=semaforo;
        this.vista=vista;
    }
    @Override
    public void run(){
        while (Buffer_General.iterar){
        try {
            this.semaforo.acquire();
            if(Buffer_General.pendientes_a_cocinar.size()==Buffer_General.maximo_de_pedidos &&
                    Buffer_General.mesa_bufer.size()==0){
                for(Pedidos pedido:Buffer_General.pendientes_a_cocinar){
                    Buffer_General.mesa_bufer.add(pedido);
                    vista.cambiar_estado_cocinero_cocinando();
                    
                    Thread.sleep(1000);
                    //realizar instruccion de animacion
                    System.out.println("Cocinero Cocinando");
                    System.out.println("Cliente "+ pedido.getCliente_id()
                        + " shuko de " + pedido.getTipo_de_shuko());
                }
                Buffer_General.pendientes_a_cocinar.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
        }
    }
}
}
