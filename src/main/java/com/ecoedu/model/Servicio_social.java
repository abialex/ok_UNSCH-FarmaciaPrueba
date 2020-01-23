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
public class Servicio_social implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Detalle_servicio_social;//cambiar xd
    
    
    
    @JoinColumn(insertable = true,updatable = false,name="id_Control_paciente",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Control_paciente control_Paciente;
    
    @Column(name="fecha",nullable = false)
    private Date  fecha;

    @Column(name="monto",nullable = false)
    private float  monto;
    
    public Control_paciente getControl_Paciente() {
        return control_Paciente;
    }

    public void setControl_Paciente(Control_paciente control_Paciente) {
        this.control_Paciente = control_Paciente;
    } 

    public int getId_Detalle_servicio_social() {
        return id_Detalle_servicio_social;
    }

    public void setId_Detalle_servicio_social(int id_Detalle_servicio_social) {
        this.id_Detalle_servicio_social = id_Detalle_servicio_social;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    @Override
    public String toString(){
        return monto+"";
    }

   
    
    

   

    

   

 
    
}
