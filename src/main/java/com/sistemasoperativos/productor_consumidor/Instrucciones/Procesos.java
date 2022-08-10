/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Instrucciones;

import com.sistemasoperativos.productor_consumidor.Pojos.Pedidos;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *En esta clase se implementaran los diferentes procesos de cada hilo
 * @author julioaguilar
 */
public class Procesos {
    //el siguiente arreglo hace referencia al bufer
    //con un maximo de 5 pedidos en la mesa
    public static List<Pedidos> mesa_bufer=new ArrayList<>();
    public static List<Pedidos> pendientes_a_cocinar=new ArrayList<>();
    //se establece el maximo de pedidos que caben en la mesa
    public static final int maximo_de_pedidos=5; 
    public static boolean iterar=true;
    //variable que recibe el semaforo enviado desde el main
    private Semaphore semaforo;
    //verificacion de si cocinero puedo o no cocinar
    private boolean cocinar=false;//no cocinara hasta que sea true
    
    public Procesos(Semaphore semaforo){
        this.semaforo=semaforo;
    }
    
    public void cocinero_cocinar(){
        try {
            this.semaforo.acquire();
            if(pendientes_a_cocinar.size()==maximo_de_pedidos &&
                    mesa_bufer.size()==0){
                for(Pedidos pedido:pendientes_a_cocinar){
                    mesa_bufer.add(pedido);
                    Thread.sleep(6000);
                    //realizar instruccion de animacion
                    System.out.println("Cocinero Cocinando");
                    System.out.println("Cliente "+ pedido.getCliente_id()
                        + " shuko de " + pedido.getTipo_de_shuko());
                }
                pendientes_a_cocinar.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
        }
    }
    
    public void entregar_pedido(){
        try {
            this.semaforo.acquire();
            if (mesa_bufer.size()==maximo_de_pedidos &&
                    pendientes_a_cocinar.size()==0){
                for(Pedidos pedido:mesa_bufer){
                    Thread.sleep(6000);
                    //realizar instruccion
                    System.out.println("Entregando Pedido");
                    System.out.println("Cliente " + pedido.getCliente_id()
                            + " shuko de " +pedido.getTipo_de_shuko());
                }
                mesa_bufer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.semaforo.release();
        }
        
    }
    
    public void hacer_pedido(){
        try {
            this.semaforo.acquire();
            if(pendientes_a_cocinar.size()< maximo_de_pedidos &&
                    mesa_bufer.size()==0){
                Pedidos pedido =new Pedidos();
                int cliente= (int)Math.floor(Math.random()*2+1);
                int shuko= (int)Math.floor(Math.random()*2+1);
                pedido.setCliente_id(cliente);
                pedido.setTipo_de_shuko(shuko);
                pendientes_a_cocinar.add(pedido);
                Thread.sleep(6000);
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