/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.util.Date;
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
public class Lote_detalle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Lote_detalle;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Inventario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Inventario inventario;
    
     @Column(name="fecha_vencimiento",nullable = false)
    private Date  fecha_vencimiento;
    
    @Column(name="cantidad",nullable = false)
    private int  cantidad;
    
    @Column(name="codigo",length = 40,nullable = false)
    private String  codigo;

    public int getId_Lote_detalle() {
        return id_Lote_detalle;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    public void setId_Lote_detalle(int id_Lote_detalle) {
        this.id_Lote_detalle = id_Lote_detalle;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
