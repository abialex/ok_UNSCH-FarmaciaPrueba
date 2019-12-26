/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.io.Serializable;
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
public class Tarifario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Tarifario;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "precio", nullable = false)
    private float precio;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Tipo_asistencial",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Tipo_Asistencial tipo_asistencial;

    public Tipo_Asistencial getTipo_asistencial() {
        return tipo_asistencial;
    }

    public void setTipo_asistencial(Tipo_Asistencial tipo_asistencial) {
        this.tipo_asistencial = tipo_asistencial;
    }
    
    
    
    public int getId_Tarifario() {
        return id_Tarifario;
    }

    public void setId_Tarifario(int id_Tarifario) {
        this.id_Tarifario = id_Tarifario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
    
}
