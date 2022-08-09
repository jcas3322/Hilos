/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemasoperativos.productor_consumidor.Pojos;

/**
 *En esta clase almacenaremos los pedidos de los clientes
 * @author julioaguilar
 */
public class Pedidos {

    /**
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the tipo_de_shuko
     */
    public int getTipo_de_shuko() {
        return tipo_de_shuko;
    }

    /**
     * @param tipo_de_shuko the tipo_de_shuko to set
     */
    public void setTipo_de_shuko(int tipo_de_shuko) {
        this.tipo_de_shuko = tipo_de_shuko;
    }
    private int cliente_id;//si 1 entonces cliente 1
    private int tipo_de_shuko;//si 1 es de chorizo, 2 de longaniza
}
