package com.ecoedu.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medicamento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Medicamento;  
    
    @Column(name="nombre",unique = true,length = 100,nullable = false)
    private String  nombre;
        
    @Column(name="forma_farmaceutica",nullable = false)
    private String forma_farmaceutica;
    
    @Column(name="concentracion",nullable = false)
    private String concentracion;

    @JoinColumn(insertable = true,updatable = false,name="id_RolOrigen",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol Rolorigen;
    
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

    public Rol getRolorigen() {
        return Rolorigen;
    }

    public void setRolorigen(Rol Rolorigen) {
        this.Rolorigen = Rolorigen;
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
    @Override
    public String toString(){
        return this.nombre;
    }

    
}
