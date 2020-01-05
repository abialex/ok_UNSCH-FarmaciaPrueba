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
public class Rol implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Rol;
    
    @Column(name = "nombre_rol",nullable = false,length = 30)
    private String nombre_rol;
    
    @Column(name = "abre_rol",nullable = true,length = 2)
    private String abre_rol;

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }
    
    @JoinColumn(insertable = true,updatable = false,name="id_tipo_Roles",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Tipo_Roles tipo_Roles;

    public Tipo_Roles getTipo_Roles() {
        return tipo_Roles;
    }

    public void setTipo_Roles(Tipo_Roles tipo_Roles) {
        this.tipo_Roles = tipo_Roles;
    }

    public String getAbre_rol() {
        return abre_rol;
    }

    public void setAbre_rol(String abre_rol) {
        this.abre_rol = abre_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    @Override
    public String toString(){
        return nombre_rol;
    }
    
    
    
}
