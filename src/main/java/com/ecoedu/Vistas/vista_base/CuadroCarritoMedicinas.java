/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas.vista_base;

import com.ecoedu.Vistas.CrearSemestredeAtencion;
import com.ecoedu.Vistas.Inventario.Descargo;
import com.ecoedu.Vistas.Lista_De_Vencimientos;
import com.ecoedu.Vistas.ServicioAsistencial.Servicio_Asistencial;
import com.ecoedu.Vistas.ServicioFarmacia.ActualizarControlDelAlumno;
import com.ecoedu.Vistas.ServicioFarmacia.Cantidad_Medicinas;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Semestre;
import javax.persistence.EntityManager;
/**
 *
 * @author yrma
 */
public class CuadroCarritoMedicinas extends javax.swing.JFrame {
    Cantidad_Medicinas objCantMedicinas;
    ActualizarControlDelAlumno objActualizarControlDelAlumno;
    Lista_De_Vencimientos objLista_De_Vencimientos;
    CrearSemestredeAtencion objSemestreAtencion;
    EntityManager jpa;    
    
    public CuadroCarritoMedicinas(EntityManager objJPA,ServicioFarmacia objServicioFarmacia,int limite_seguro){
        initComponents();
        this.objCantMedicinas=new Cantidad_Medicinas(objJPA, this, objServicioFarmacia,limite_seguro);
        contenedor.add(objCantMedicinas);     
        this.setLocationRelativeTo(null);
    }
    public CuadroCarritoMedicinas(EntityManager objJPA,boolean algo,Principal objPrincipal){
        initComponents();
        this.objSemestreAtencion=new CrearSemestredeAtencion(objJPA,this,objPrincipal);
        contenedor.add(objSemestreAtencion);     
        this.setLocationRelativeTo(null);
    }
    public CuadroCarritoMedicinas(EntityManager objJPA,Estudiante objEstudiante,ServicioFarmacia objServicioFarmacia,Semestre objSemestres){
        initComponents();
        this.objActualizarControlDelAlumno=new ActualizarControlDelAlumno(objJPA,objEstudiante,this,objServicioFarmacia,objSemestres);
        contenedor.add(objActualizarControlDelAlumno);
        this.setLocationRelativeTo(null);
    }
    public CuadroCarritoMedicinas(EntityManager objJPA,Estudiante objEstudiante,Servicio_Asistencial objServicio_Asistencial,Semestre objSemestres){
        initComponents();
        this.objActualizarControlDelAlumno=new ActualizarControlDelAlumno(objJPA,objEstudiante,this,objServicio_Asistencial, objSemestres);
        contenedor.add(objActualizarControlDelAlumno);
        this.setLocationRelativeTo(null);
    }
    public CuadroCarritoMedicinas(EntityManager objJPA,Descargo objDescargo){
        initComponents();
        this.objCantMedicinas=new Cantidad_Medicinas(objJPA,this,objDescargo);
        contenedor.add(objCantMedicinas);
        this.setLocationRelativeTo(null);
    }
    public CuadroCarritoMedicinas(EntityManager objJPA){
        initComponents();
        this.objLista_De_Vencimientos=new Lista_De_Vencimientos(objJPA,this);        
        contenedor.add(objLista_De_Vencimientos);
        //contenedor.validate();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 300));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 350));
        setResizable(false);

        contenedor.setBackground(new java.awt.Color(0, 255, 204));
        contenedor.setMaximumSize(new java.awt.Dimension(700, 300));
        contenedor.setMinimumSize(new java.awt.Dimension(700, 300));
        contenedor.setName(""); // NOI18N
        contenedor.setPreferredSize(new java.awt.Dimension(700, 300));
        contenedor.setLayout(new java.awt.BorderLayout());
        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    // End of variables declaration//GEN-END:variables
}
