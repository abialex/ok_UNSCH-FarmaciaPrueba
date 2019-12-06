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
public class Sexo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Sexo;
    
    @Column(name = "nombre_sexo",nullable = false,length = 10)
    private String nombre_sexo;

    @Column(name = "abre_sexo",nullable = false,length = 2)
    private String abre_sexo;

    public String getAbre_sexo() {
        return abre_sexo;
    }

    public void setAbre_sexo(String abre_sexo) {
        this.abre_sexo = abre_sexo;
    }    
    
    public int getIdSexo() {
        return id_Sexo;
    }

    public void setIdSexo(int idSexo) {
        this.id_Sexo = idSexo;
    }

    public String getNombre_sexo() {
        return nombre_sexo;
    }

    public void setNombre_sexo(String nombre_sexo) {
        this.nombre_sexo = nombre_sexo;
    }

    @Override
    public String toString() {
        return nombre_sexo;
    }
    
    
    
}
