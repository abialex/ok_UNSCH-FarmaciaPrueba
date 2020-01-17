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
public class RegistroMensualInventario implements Serializable,Comparable<RegistroMensualInventario>{

    public RegistroMensualInventario() {
    }

    public RegistroMensualInventario(int cantidad_inicial, Date fecha_apertura, Date fecha_apertura_real, Usuario usuario_apertura, Inventario inventario) {
        this.cantidad_inicial = cantidad_inicial;
        this.fecha_apertura = fecha_apertura;
        this.fecha_apertura_real = fecha_apertura_real;
        this.usuario_apertura = usuario_apertura;
        this.inventario = inventario;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Registro_mensual_Inventario;
    
    @Column(name = "cantidad_inicial",nullable = false)
    private int cantidad_inicial;
    
    @Column(name = "fecha_apertura",nullable = false)
    private Date fecha_apertura;
    
    @Column(name = "fecha_apertura_real",nullable = false)
    private  Date fecha_apertura_real;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Usuario_apertura",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario_apertura;
    
    @Column(name = "cantidad_final",nullable = true)
    private int cantidad_final;
    
    @Column(name = "fecha_cierre",nullable = true)
    private Date fecha_cierra;
    
    @Column(name = "fecha_cierre_real",nullable = true)
    private  Date fecha_cierre_real;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Usuario_cierre",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario_cierre;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Inventario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Inventario inventario;

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }   

    public int getId_Registro_mensual_Inventario() {
        return id_Registro_mensual_Inventario;
    }

    public void setId_Registro_mensual_Inventario(int id_Registro_mensual_Inventario) {
        this.id_Registro_mensual_Inventario = id_Registro_mensual_Inventario;
    }

    public int getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(int cantidad_inicial) {
        this.cantidad_inicial = cantidad_inicial;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Date getFecha_apertura_real() {
        return fecha_apertura_real;
    }

    public void setFecha_apertura_real(Date fecha_apertura_real) {
        this.fecha_apertura_real = fecha_apertura_real;
    }

    public Usuario getUsuario_apertura() {
        return usuario_apertura;
    }

    public void setUsuario_apertura(Usuario usuario_apertura) {
        this.usuario_apertura = usuario_apertura;
    }

    public int getCantidad_final() {
        return cantidad_final;
    }

    public void setCantidad_final(int cantidad_final) {
        this.cantidad_final = cantidad_final;
    }

    public Date getFecha_cierra() {
        return fecha_cierra;
    }

    public void setFecha_cierra(Date fecha_cierra) {
        this.fecha_cierra = fecha_cierra;
    }

    public Date getFecha_cierre_real() {
        return fecha_cierre_real;
    }

    public void setFecha_cierre_real(Date fecha_cierre_real) {
        this.fecha_cierre_real = fecha_cierre_real;
    }

    public Usuario getUsuario_cierre() {
        return usuario_cierre;
    }

    public void setUsuario_cierre(Usuario usuario_cierre) {
        this.usuario_cierre = usuario_cierre;
    }
    
    @Override
    public String toString(){
        return cantidad_inicial+"";
    }

    @Override
    public int compareTo(RegistroMensualInventario o) {
        return this.getInventario().getMedicamento().getNombre().compareTo(o.getInventario().getMedicamento().getNombre());
    }

  
    
    
    
    
    
}
