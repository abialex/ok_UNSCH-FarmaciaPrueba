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
    
    private Procedencia objProcedencia;
    private Diagnostico objDiagnostico;
    private String cantidad;

    public ZObjetoProDiag(Procedencia objProcedencia, String cantidad) {
        this.objProcedencia = objProcedencia;
        this.cantidad = cantidad;
    }
    public ZObjetoProDiag(Diagnostico objDiagnostico, String cantidad) {
        this.objDiagnostico = objDiagnostico;
        this.cantidad = cantidad;
    }
    public Procedencia getObjProcedencia() {
        return objProcedencia;
    }

    public Diagnostico getObjDiagnostico() {
        return objDiagnostico;
    }

    public void setObjDiagnostico(Diagnostico objDiagnostico) {
        this.objDiagnostico = objDiagnostico;
    }
    

    public void setObjProcedencia(Procedencia objProcedencia) {
        this.objProcedencia = objProcedencia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(ZObjetoProDiag o) {
        return this.getCantidad().compareTo(o.getCantidad());
    }
    
    
    
    
}
