/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import com.ecoedu.app.Herramienta;
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
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Persona;
    
    @Column(name="nombres",length = 50,nullable = false)
    private String nombres;
    
    @Column(name="apellido_Paterno",length = 50,nullable = false)
    private String  apellido_Paterno;
    
    @Column(name="apellido_Materno",length = 50,nullable = false)
    private String  apellido_Materno;
    
    @Column(name="dni",length = 8,unique = true,nullable = false)
    private String  dni;
    
    @Column(name="fecha_nacimiento",nullable = false)
    private Date  fecha_nacimiento;
    
    
    @JoinColumn(insertable = true,updatable =true,name="id_Sexo",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Sexo sexo;   

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    
    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

   

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getInfoPersona(){
        return Herramienta.Mayusculas(apellido_Paterno+" "+apellido_Materno+", "+nombres);
    }
    
    
    
    
    
}
