/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

/**
 *
 * @author yrma
 */
@Entity
public class Diagnostico{
    @Id
    @Column(unique = true, length = 5, nullable = false)
    private String id_DiagnosticoCodigo;
    
    @Column(name = "descripcion_Diagnostico",nullable = false)
    private String descripcion_Diagnostico;

    public String getId_DiagnosticoCodigo(){
        return id_DiagnosticoCodigo;
    }

    public void setId_DiagnosticoCodigo(String id_DiagnosticoCodigo) {
        this.id_DiagnosticoCodigo = id_DiagnosticoCodigo;
    }

    public String getDescripcion_Diagnostico() {
        return descripcion_Diagnostico;
    }

    public void setDescripcion_Diagnostico(String descripcion_Diagnostico) {
        this.descripcion_Diagnostico = descripcion_Diagnostico;
    }
}
