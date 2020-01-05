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
public class Estudiante{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Estudiante;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Persona",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Persona persona;
    
    @Column(name="fecha_nacimiento",nullable = true)
    private Date  fecha_nacimiento;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Rolescuela",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol Rolescuela;
    
    @Column(name="codigo",unique = true,length = 8,nullable = false)
    private String codigo;
    
    @Column(name="serie",length = 3,nullable = false)
    private String serie;
    
    @JoinColumn(insertable = true,updatable = false,name="id_RolCondicion",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol RolCondicion;
    
    @JoinColumn(insertable = true,updatable = false,name="id_RolSexo",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol RolSexo;

    public Rol getRolescuela() {
        return Rolescuela;
    }

    public void setRolescuela(Rol Rolescuela) {
        this.Rolescuela = Rolescuela;
    }

    public Rol getRolSexo() {
        return RolSexo;
    }

    public void setRolSexo(Rol RolSexo) {
        this.RolSexo = RolSexo;
    }

    public Rol getRolCondicion() {
        return RolCondicion;
    }

    public void setRolCondicion(Rol RolCondicion) {
        this.RolCondicion = RolCondicion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public Rol getEscuela() {
        return Rolescuela;
    }

    public void setEscuela(Rol rolescuela) {
        this.Rolescuela = rolescuela;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    
}
