/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yrma
 */
@Entity
public class Condicion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Condicion;
    
    
    @Column(name="nombre_condicion",length = 13,nullable = false)
    private String nombre_condicion;
    
    @Column(name="abre_nombre",length = 2,nullable = false)
    private String abre_nombre;

    public int getId_Condicion() {
        return id_Condicion;
    }

    public void setId_Condicion(int id_Condicion) {
        this.id_Condicion = id_Condicion;
    }

    public String getNombre_condicion() {
        return nombre_condicion;
    }

    public void setNombre_condicion(String nombre_condicion) {
        this.nombre_condicion = nombre_condicion;
    }

    public String getAbre_nombre() {
        return abre_nombre;
    }

    public void setAbre_nombre(String abre_nombre) {
        this.abre_nombre = abre_nombre;
    }
    
    
    
    
}
