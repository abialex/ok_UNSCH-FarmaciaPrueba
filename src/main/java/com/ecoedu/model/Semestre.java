/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.io.Serializable;
import java.util.Date;
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
public class Semestre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Semestre;
    
    @Column(name = "fecha_inicio",nullable = false)
    private Date fecha_Inicio;
    
    @Column(name = "fecha_fin",nullable = false)
    private Date fecha_Fin;
    
    @Column(name = "fecha_fin_Real",nullable = true)
    private Date fecha_Fin_Real;
    
    
    @Column(name = "semestre_periodo",nullable = false)
    private boolean semestre_periodo;
    
   

    public int getId_Semestre() {
        return id_Semestre;
    }

    public void setId_Semestre(int id_Semestre) {
        this.id_Semestre = id_Semestre;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(Date fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    public Date getFecha_Fin_Real() {
        return fecha_Fin_Real;
    }

    public void setFecha_Fin_Real(Date fecha_Fin_Real) {
        this.fecha_Fin_Real = fecha_Fin_Real;
    }

    public boolean isSemestre_periodo() {
        return semestre_periodo;
    }

    public void setSemestre_periodo(boolean semestre_periodo) {
        this.semestre_periodo = semestre_periodo;
    }
    
    @Override
    public String toString(){
        if(this.isSemestre_periodo()){
            return (fecha_Inicio.getYear()+1900)+"-II";
        }   
        else{
            return (fecha_Inicio.getYear()+1900)+"-I";
        }
    }

    
    
    
    
    
}
