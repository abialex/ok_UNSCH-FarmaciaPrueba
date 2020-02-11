/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tipo_Roles implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_Roles;
    
    @Column(name = "nombre_rol",nullable = false,length = 30)
    private String nombre_rol;

    public int getId_tipo_Roles() {
        return id_tipo_Roles;
    }

    public void setId_tipo_Roles(int id_tipo_Roles) {
        this.id_tipo_Roles = id_tipo_Roles;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
    
}
