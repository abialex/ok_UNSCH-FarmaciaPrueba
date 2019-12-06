/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

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
public class Estudiante{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Estudiante;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Persona",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Persona persona;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Escuela",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Escuela escuela;
    
    @Column(name="codigo",unique = true,length = 8,nullable = false)
    private String codigo;
    
    @Column(name="serie",length = 3,nullable = false)
    private String serie;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Condicion",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Condicion condicion;

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
    
        

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    
    
    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    
}
