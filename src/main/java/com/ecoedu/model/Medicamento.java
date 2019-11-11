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
    
    
    @Column(name="precio_Unitario",nullable = false)
    private float  precio_Unitario;
    
    

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

    public float getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(int precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }
    
    
        
    
    
}
