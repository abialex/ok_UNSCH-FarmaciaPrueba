package com.ecoedu.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Medicamento;  
    
    @Column(name="nombre",length = 100,nullable = false)
    private String  nombre;
    
    
    @Column(name="forma_farmaceutica",nullable = true)
    private String forma_farmaceutica;
    
    @Column(name="concentracion",nullable = true)
    private String concentracion;

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }
    
    

    public String getForma_farmaceutica() {
        return forma_farmaceutica;
    }

    public void setForma_farmaceutica(String forma_farmaceutica) {
        this.forma_farmaceutica = forma_farmaceutica;
    }
    
    

    public int getId_Medicamento() {
        return id_Medicamento;
    }
    
    public void setId_Medicamento(int id_Medicamento) {
        this.id_Medicamento = id_Medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
