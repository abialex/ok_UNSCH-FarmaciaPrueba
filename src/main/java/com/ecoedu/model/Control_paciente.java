/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.io.Serializable;
import java.util.Date;
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
public class Control_paciente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Control_paciente;
    
    @JoinColumn(insertable = true,updatable = false,name="id_estudiante",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Estudiante estudiante;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Semestre",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Semestre semestre;
    
    @Column(name="monto_Total",nullable = false)
    private float  monto_Total;
    
    @Column(name="limite_control",nullable = true)
    private int limite_control;

    @Column(name="iSactivo",nullable = false)
    private boolean  iSactivo;
    
    @Column(name="fecha_registro",nullable = true)
    private Date  fecha_registro;

    public Date getFecha_registro() {
        return fecha_registro;
    }

    
    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }   
        
    public boolean isiSactivo(){
        return iSactivo;
    }

    public void setiSactivo(boolean iSactivo) {
        this.iSactivo = iSactivo;
    }

    public int getLimite_control() {
        return limite_control;
    }

    public void setLimite_control(int limite_control) {
        this.limite_control = limite_control;
    }
    
    
    
    public int getId_Control_paciente() {
        return id_Control_paciente;
    }

    public void setId_Control_paciente(int id_Receta) {
        this.id_Control_paciente = id_Receta;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public float getMonto_Total() {
        return monto_Total;
    }

    public void setMonto_Total(float monto_Total) {
        this.monto_Total = monto_Total;
    }
    public Control_paciente agregarPrecioTotal(float precio_total){
        this.monto_Total=monto_Total+precio_total;
        return this;
    }
    
    
    
    
    
    
     
     
    
}
