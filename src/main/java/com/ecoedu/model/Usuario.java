/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import java.io.Serializable;
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
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Usuario;
    
    @Column(name="nickname",unique = true,length = 20,nullable = false)
    private String nickname;
    
    @Column(name="contrase�a",length = 40,nullable = false)
    private String contrase�a;
    
    @Column(name="iScambio",nullable = true)
    private boolean cambio;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Rol",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol rol;
    
    @JoinColumn(insertable = true,updatable = false,name="id_Persona",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Persona persona;

    public boolean isCambio() {
        return cambio;
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }

    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    @Override
    public String toString(){
        return persona.getInfoPersona();
    }
    
    
       
    
    
    
        
    
    

    
}
