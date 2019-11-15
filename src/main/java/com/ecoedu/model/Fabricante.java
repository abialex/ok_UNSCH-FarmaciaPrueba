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
public class Fabricante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Fabricante;
    
    @Column(name = "nombre",nullable = false)
    private String nombre;

    public int getId_Fabricante() {
        return id_Fabricante;
    }

    public void setId_Fabricante(int id_Fabricante) {
        this.id_Fabricante = id_Fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
