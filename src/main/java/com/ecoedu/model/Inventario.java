/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author yrma
 */
@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Inventario;
    
    @JoinColumn(insertable = true,updatable = false,unique = true,name="id_Medicamento",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Medicamento Medicamento;
    
    @Column(name="cantidad",nullable = false)
    private int  cantidad;

    public int getId_Inventario() {
        return id_Inventario;
    }

    public void setId_Inventario(int id_Inventario) {
        this.id_Inventario = id_Inventario;
    }

    public Medicamento getMedicamento() {
        return Medicamento;
    }

    public void setMedicamento(Medicamento id_Medicamento) {
        this.Medicamento = id_Medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Inventario agregarCantidad(int cant){
        this.cantidad=cantidad+cant;
        return this;
    }
    public Inventario quitarCantidad(int cant){
        this.cantidad=cantidad-cant;
        return this;
    }
    
    @Override
    public String toString(){
        return Medicamento.getNombre();
    }
            
    
    
    
}
