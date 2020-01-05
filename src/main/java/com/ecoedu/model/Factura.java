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

@Entity
public class Factura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Factura;
    
    @Column(name = "codigo_factura",nullable = false)
    private String codigo_factura;
    
    @JoinColumn(insertable = true,updatable = false,name="id_RolProveedor",nullable = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private Rol RolProveedor;

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public int getId_Factura() {
        return id_Factura;
    }

    public void setId_Factura(int id_Factura) {
        this.id_Factura = id_Factura;
    }

    public Rol getRolProveedor() {
        return RolProveedor;
    }

    public void setRolProveedor(Rol RolProveedor) {
        this.RolProveedor = RolProveedor;
    }

    
    
    
    
    
}
