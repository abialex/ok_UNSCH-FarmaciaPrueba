/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.io.Serializable;
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
public class Descruce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Descruce;
    
    @Column(name = "motivo",nullable = false,length = 200)
    private String motivo;
    
    @Column(name = "cantidad",nullable = false)
    private int cantidad;
    
    @Column(name = "cantidad2",nullable = false)
    private int cantidad2;
    
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    
    @Column(name = "mes",nullable = true)
    private int mes_Descruce;

    public int getMes_Descruce() {
        return mes_Descruce;
    }

    public void setMes_Descruce(int mes_Descruce) {
        this.mes_Descruce = mes_Descruce;
    }
    
    @JoinColumn(insertable = true,updatable = false,name="id_Usuario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Lote_detalle",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Lote_detalle lote_detalle;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Lote_detalle2",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Lote_detalle lote_detalle2;

    public int getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(int cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public Lote_detalle getLote_detalle2() {
        return lote_detalle2;
    }

    public void setLote_detalle2(Lote_detalle lote_detalle2) {
        this.lote_detalle2 = lote_detalle2;
    }
    
    public int getId_Descruce() {
        return id_Descruce;
    }

    public void setId_Descruce(int id_Descruce) {
        this.id_Descruce = id_Descruce;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Lote_detalle getLote_detalle() {
        return lote_detalle;
    }

    public void setLote_detalle(Lote_detalle lote_detalle) {
        this.lote_detalle = lote_detalle;
    }
    
    
    
    
}
