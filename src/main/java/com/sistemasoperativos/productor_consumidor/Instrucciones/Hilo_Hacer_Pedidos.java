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
public class Hilo_Hacer_Pedidos extends Thread{
    private Semaphore semaforo;
    private Vista_Principal vista;
    //public boolean iterar=true;
    
    public Hilo_Hacer_Pedidos(Semaphore semaforo, Vista_Principal vista){
        this.semaforo=semaforo;
        this.vista=vista;
    }
    @Override
    public void run(){
        while(Buffer_General.iterar){
        try {
            this.semaforo.acquire();
            if(Buffer_General.pendientes_a_cocinar.size()< Buffer_General.maximo_de_pedidos &&
                    Buffer_General.mesa_bufer.size()==0){
                Pedidos pedido =new Pedidos();
                int cliente= (int)Math.floor(Math.random()*2+1);
                int shuko= (int)Math.floor(Math.random()*2+1);
                pedido.setCliente_id(cliente);
                pedido.setTipo_de_shuko(shuko);
                Buffer_General.pendientes_a_cocinar.add(pedido);
                Thread.sleep(5000);
                System.out.println("Ordenando");
                System.out.println("Cliente " + cliente + " quiere " + shuko);
                int n=0;
                while(n<25){
                    vista.mover_cocinero_der();
                    Thread.sleep(150);
                    vista.mover_cocinero_iz();
                    Thread.sleep(150);
                    n++;
                }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.semaforo.release();
        }
    }
}
}