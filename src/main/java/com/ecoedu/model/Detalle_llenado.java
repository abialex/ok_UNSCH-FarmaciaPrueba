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
public class Detalle_llenado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Detalle_llenado;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Usuario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Medicamento",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Medicamento medicamento;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Lote_detalle",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Lote_detalle lote_detalle;
    
    @Column(name="precio_Unitario",nullable = false)
    private int  precio_unitario;
    
    @Column(name="fecha_de_registro",nullable = false)
    private Date fecha_de_registro;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public int getId_Detalle_llenado() {
        return id_Detalle_llenado;
    }

    public Date getFecha_de_registro() {
        return fecha_de_registro;
    }

    public void setFecha_de_registro(Date fecha_de_registro) {
        this.fecha_de_registro = fecha_de_registro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public void setId_Detalle_llenado(int id_Detalle_llenado) {
        this.id_Detalle_llenado = id_Detalle_llenado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Lote_detalle getLote_detalle() {
        return lote_detalle;
    }

    public void setLote_detalle(Lote_detalle lote_detalle) {
        this.lote_detalle = lote_detalle;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
     
     
    
    
    
    
}
