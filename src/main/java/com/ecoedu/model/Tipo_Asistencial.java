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

/**
 *
 * @author yrma
 */
@Entity
public class Tipo_Asistencial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Tipo_asistencial;
    
    @Column(name = "nombre_asistencial",length = 20,nullable = false)
    private String Nombre_Asistencil;
    
    @Column(name = "abre_asistencial",length = 2,nullable = false)
    private String abre_Asistencil;

    public String getNombre_Asistencil() {
        return Nombre_Asistencil;
    }

    public void setNombre_Asistencil(String Nombre_Asistencil) {
        this.Nombre_Asistencil = Nombre_Asistencil;
    }

    public String getAbre_Asistencil() {
        return abre_Asistencil;
    }

    public void setAbre_Asistencil(String abre_Asistencil) {
        this.abre_Asistencil = abre_Asistencil;
    }
    
    @Override
    public String toString(){
        return this.Nombre_Asistencil;
        
    }
    
    

    public int getId() {
        return id_Tipo_asistencial;
    }

    public void setId(int id) {
        this.id_Tipo_asistencial = id;
    }

        
}
