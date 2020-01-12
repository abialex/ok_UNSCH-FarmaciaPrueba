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
    
    @JoinColumn(insertable = true,updatable = false,name="id_RolOperacion",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol RolOperacion;
    
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Usuario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Lote_detalle",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Lote_detalle lote_detalle;

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

    public Rol getRolOperacion() {
        return RolOperacion;
    }

    public void setRolOperacion(Rol RolOperacion) {
        this.RolOperacion = RolOperacion;
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
