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
public class Lote_detalle implements Comparable<Lote_detalle>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Lote_detalle;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Inventario",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Inventario inventario;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Fabricante",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Fabricante fabricante;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Factura",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Factura factura;
    
    @Column(name = "Precio_Venta_Redondeado",nullable = false)
    private float precio_Venta_Redondeado;
    
    @Column(name="fecha_vencimiento",nullable = false)
    private Date  fecha_vencimiento;
    
    @Column(name="cantidad",nullable = false)
    private int  cantidad;
    
    @Column(name="codigo",length = 40,nullable = false)
    private String  codigo;

    public float getPrecio_Venta_Redondeado() {
        return precio_Venta_Redondeado;
    }

    public void setPrecio_Venta_Redondeado(float precio_Venta_Redondeado) {
        this.precio_Venta_Redondeado = precio_Venta_Redondeado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }   
    
    public int getId_Lote_detalle() {
        return id_Lote_detalle;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
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
    public Lote_detalle quitarCantidad(int cant){
        this.cantidad=cantidad-cant;
        return this;
    }

    @Override
    public int compareTo(Lote_detalle o) {
        return this.getInventario().getMedicamento().getNombre().compareTo(o.getInventario().getMedicamento().getNombre());
    }
    


    }
