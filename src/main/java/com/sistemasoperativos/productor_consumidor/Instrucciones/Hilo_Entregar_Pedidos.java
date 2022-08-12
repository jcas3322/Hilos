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
public class Hilo_Entregar_Pedidos extends Thread{
    private Semaphore semaforo;
    private Vista_Principal vista;
    //public boolean iterar=true;
    public Hilo_Entregar_Pedidos(Semaphore semaforo, Vista_Principal vista){
        this.semaforo=semaforo;
        this.vista=vista;
    }
    @Override
    public void run(){
        while(Buffer_General.iterar){
        try {
            this.semaforo.acquire();
            if (Buffer_General.mesa_bufer.size()==Buffer_General.maximo_de_pedidos &&
                    Buffer_General.pendientes_a_cocinar.size()==0){
                int z=1;
                for(Pedidos pedido:Buffer_General.mesa_bufer){
                    //realizar instruccion
                    vista.cambiar_estado_cocinero_descansando();
                    vista.cambiar_estado_cliente1_come();
                    vista.cambiar_estado_cliente2_come();
                    vista.mover_cliente1();
                    vista.mover_cliente2();
                    Thread.sleep(4000);
                    if(z==1) vista.articulo1_no_visible();
                    if(z==2) vista.articulo2_no_visible();
                    if (z==3) vista.articulo3_no_visible();
                    if (z==4) vista.articulo4_no_visible();
                    z++;
                    System.out.println("Entregando Pedido");
                    System.out.println("Cliente " + pedido.getCliente_id()
                            + " shuko de " +pedido.getTipo_de_shuko());
                }
                Thread.sleep(2000);
                vista.regresar_cliente1();
                vista.regresar_cliente2();
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