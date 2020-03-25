/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.model;

/**
 *
 * @author yrma
 */
public class ZObjetoProDiag implements Comparable<ZObjetoProDiag>{
    
    private Diagnostico objDiagnostico;
    private Rol objRolesMuchos;
    private int cantidad;
    private Estudiante objEstudiante;
    private String mes_Name;
    private int mes_ind;

    public ZObjetoProDiag(Rol objRol, int cantidad) {
        this.objRolesMuchos = objRol;
        this.cantidad = cantidad;
    }
    public ZObjetoProDiag(String mes_Name, int mes_ind) {
        this.mes_Name = mes_Name;
        this.mes_ind = mes_ind;
    }
    public ZObjetoProDiag(Estudiante objEstudiante, int cantidad) {
        this.objEstudiante = objEstudiante;
        this.cantidad = cantidad;
    }
        
    public ZObjetoProDiag(Diagnostico objDiagnostico, int cantidad) {
        this.objDiagnostico = objDiagnostico;
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Rol getObjRolesMuchos() {
        return objRolesMuchos;
    }

    public void setObjRolesMuchos(Rol objRolesMuchos) {
        this.objRolesMuchos = objRolesMuchos;
    }

    public Diagnostico getObjDiagnostico() {
        return objDiagnostico;
    }

    public void setObjDiagnostico(Diagnostico objDiagnostico) {
        this.objDiagnostico = objDiagnostico;
    }

    public Estudiante getObjEstudiante() {
        return objEstudiante;
    }

    public void setObjEstudiante(Estudiante objEstudiante) {
        this.objEstudiante = objEstudiante;
    }
    
    public String getMes_Name() {
        return mes_Name;
    }

    public void setMes_Name(String mes_Name) {
        this.mes_Name = mes_Name;
    }

    public int getMes_ind() {
        return mes_ind;
    }

    public void setMes_ind(int mes_ind) {
        this.mes_ind = mes_ind;
    }
    
    @Override
    public String toString(){
        return mes_Name;
    }

    @Override
    public int compareTo(ZObjetoProDiag o) {
         if (cantidad < o.getCantidad()) {
             return -1;
             }
         if (cantidad > o.getCantidad()) {
             return 1;
             }
         return 0;
    }
    
    
    
    
}
