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
public class Procedencia{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Procedencia; 
    
    @Column(name="nombre",length = 20,nullable = false)
    private String  nombre;

    public int getId_Procedencia() {
        return id_Procedencia;
    }
    
    public void setId_Procedencia(int id_Procedencia) {
        this.id_Procedencia = id_Procedencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
