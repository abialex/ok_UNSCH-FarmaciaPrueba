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
    public ZObjetoProDiag(Rol objRol, int cantidad) {
        this.objRolesMuchos = objRol;
        this.cantidad = cantidad;
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
