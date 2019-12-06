/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

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
public class Receta implements Comparable<Receta>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Diagnostico;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Control_paciente",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Control_paciente control_Paciente;    
        
    @JoinColumn(insertable = true,updatable = false,name="id_procedencia",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Procedencia  procedencia;
    
    @JoinColumn(insertable = true,updatable = false,name="id_DiagnosticoCodigo",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Diagnostico  diagnostico;
        
    @Column(name="fecha_creada",nullable = false)
    private Date  fecha_creada;
    
    @Column(name="total_costo_medicinas",nullable = false)
    private float  total_costo_medicinas;   
    
    

    public Diagnostico getDiagnosito(){
        return diagnostico;
    }
    public void setDiagnostico(Diagnostico diag){
        this.diagnostico=diag;
    }
    
    public Control_paciente getControl_Paciente() {
        return control_Paciente;
    }

    public void setControl_Paciente(Control_paciente control_Paciente) {
        this.control_Paciente = control_Paciente;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }  

    public float getTotal_costo_medicinas() {
        return total_costo_medicinas;
    }

    public void setTotal_costo_medicinas(float total_costo_medicinas) {
        this.total_costo_medicinas = total_costo_medicinas;
    }     

    public int getId_Receta() {
        return id_Diagnostico;
    }

    public void setId_Receta(int id_Diagnostico) {
        this.id_Diagnostico = id_Diagnostico;
    }

    public Date getFecha_creada() {
        return fecha_creada;
    }

    public void setFecha_creada(Date fecha_creada) {
        this.fecha_creada = fecha_creada;
    }
    @Override
    public String toString(){
        return fecha_creada.toString();
    }

    @Override
    public int compareTo(Receta o) {
        return this.getFecha_creada().compareTo(o.getFecha_creada());
    }
    
    
    
}
