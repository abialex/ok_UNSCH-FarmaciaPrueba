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
public class Detalle_Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Detalle_control_paciente;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Medicamento",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Medicamento id_Medicamento;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Lote_detalle",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Lote_detalle lote_detalle;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Receta",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Receta receta;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Usuario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
   
    @Column(name="precio_Total",nullable = true)
    private float  precio_Total;
    
    @Column(name="cantidad",nullable = false)
    private int  cantidad;
    
    @Column(name="precio_Unitario",nullable = false)
    private float  precio_Unitario;
    
    @Column(name="fecha",nullable = false)
    private Date  fecha;

    public Lote_detalle getLote_detalle() {
        return lote_detalle;
    }

    public void setLote_detalle(Lote_detalle lote_detalle) {
        this.lote_detalle = lote_detalle;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public int getId_Detalle_control_paciente() {
        return id_Detalle_control_paciente;
    }

    public void setId_Detalle_control_paciente(int id_Detalle_control_paciente) {
        this.id_Detalle_control_paciente = id_Detalle_control_paciente;
    }

    public Medicamento getId_Medicamento() {
        return id_Medicamento;
    }

    public void setId_Medicamento(Medicamento id_Medicamento) {
        this.id_Medicamento = id_Medicamento;
    }

    public float getPrecio_Total() {
        return precio_Total;
    }

    public void setPrecio_Total(float precio_Total) {
        this.precio_Total = precio_Total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(float precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
