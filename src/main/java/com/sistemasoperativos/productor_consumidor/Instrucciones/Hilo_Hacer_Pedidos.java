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
public class Hilo_Hacer_Pedidos extends Thread{
    private Semaphore semaforo;
    //public boolean iterar=true;
    
    public Hilo_Hacer_Pedidos(Semaphore semaforo){
        this.semaforo=semaforo;
    }
    @Override
    public void run(){
        while(Procesos.iterar){
        try {
            this.semaforo.acquire();
            if(Procesos.pendientes_a_cocinar.size()< Procesos.maximo_de_pedidos &&
                    Procesos.mesa_bufer.size()==0){
                Pedidos pedido =new Pedidos();
                int cliente= (int)Math.floor(Math.random()*2+1);
                int shuko= (int)Math.floor(Math.random()*2+1);
                pedido.setCliente_id(cliente);
                pedido.setTipo_de_shuko(shuko);
                Procesos.pendientes_a_cocinar.add(pedido);
                Thread.sleep(1000);
                System.out.println("Ordenando");
                System.out.println("Cliente " + cliente + " quiere " + shuko);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.semaforo.release();
        }
    }
}
}