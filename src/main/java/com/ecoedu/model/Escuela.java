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
public class Escuela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Escuela;
    
    @Column(name="nombre",length = 100,nullable = false)
    private String nombre;

    public int getId_Escuela() {
        return id_Escuela;
    }

    public void setId_Escuela(int id_Escuela) {
        this.id_Escuela = id_Escuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
