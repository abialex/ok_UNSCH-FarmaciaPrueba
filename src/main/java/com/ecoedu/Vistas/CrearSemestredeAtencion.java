package com.ecoedu.Vistas;



import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Semestre;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class CrearSemestredeAtencion extends javax.swing.JPanel{
    EntityManager jpa;
    CuadroCarritoMedicinas objCuadrito;
    Estudiante objEstudiante;
    Semestre objSemestreF;
    Principal objPrincipal;
    public CrearSemestredeAtencion(EntityManager objJpa,CuadroCarritoMedicinas objCuadroCarritoMedicinas,Principal objPrincipals){
        initComponents();
        this.objPrincipal=objPrincipals;
        this.objCuadrito=objCuadroCarritoMedicinas;
        this.jpa=objJpa;
        List<Semestre> lis=jpa.createQuery("SELECT p from Semestre p where fecha_fin_Real is null").getResultList();  
        if(!lis.isEmpty()){
            jbtnCerrarSemestre.setEnabled(true);
            jlblAdvertencia.setText("Semestre Vigente");
            objSemestreF=lis.get(0);  
            jcbDateInicio.setDatoFecha(objSemestreF.getFecha_Inicio());
            jcbDateFin.setDatoFecha(objSemestreF.getFecha_Fin());
            jbtnGuardar.setText("GUARDAR CAMBIOS");
            if(objSemestreF.isSemestre_periodo()){
                jcbPeriodoSemestre.setSelectedItem("II");
            }
            else{
                jcbPeriodoSemestre.setSelectedItem("I");                
            }
        }
        else{
            jbtnCerrarSemestre.setEnabled(false);
            jlblAdvertencia.setText("");
            objSemestreF=new Semestre();
        }
        principalEjecucion();        
    }
   
  
    public void principalEjecucion(){
        
        desglozarDatos(); 
     }
    
    public void desglozarDatos(){
         
         }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlblSerie = new javax.swing.JLabel();
        jbtnCerrarSemestre = new javax.swing.JButton();
        jlblEscuela = new javax.swing.JLabel();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jlblNombre1 = new javax.swing.JLabel();
        jlblEstCodigo = new javax.swing.JLabel();
        jlblCondicion1 = new javax.swing.JLabel();
        jcbPeriodoSemestre = new javax.swing.JComboBox<>();
        jcbDateFin = new rojeru_san.componentes.RSDateChooser();
        jcbDateInicio = new rojeru_san.componentes.RSDateChooser();
        jbtnSalir = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jlblAdvertencia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(100, 176));
        setPreferredSize(new java.awt.Dimension(700, 350));
        setLayout(new java.awt.BorderLayout());

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setMaximumSize(new java.awt.Dimension(700, 300));
        contenedor.setMinimumSize(new java.awt.Dimension(700, 300));
        contenedor.setName(""); // NOI18N
        contenedor.setPreferredSize(new java.awt.Dimension(700, 300));
        contenedor.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 345));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel6.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 680, 10));

        jlblSerie.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblSerie.setText("SEMESTRE:");
        jlblSerie.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel2.add(jlblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 80, 25));

        jbtnCerrarSemestre.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCerrarSemestre.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCerrarSemestre.setText("FINALIZAR SEMESTRE REAL");
        jbtnCerrarSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarSemestreActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCerrarSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 230, -1));

        jlblEscuela.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblEscuela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEscuela.setText("FECHA FIN:");
        jlblEscuela.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel2.add(jlblEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, 25));

        head.setBackground(new java.awt.Color(0, 153, 102));
        head.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(" Semestre de Atención");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 70));
        head.add(jLabel12);

        jPanel2.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jlblNombre1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblNombre1.setText("FECHA INICIO:");
        jlblNombre1.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel2.add(jlblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 25));

        jlblEstCodigo.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 20)); // NOI18N
        jlblEstCodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEstCodigo.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel2.add(jlblEstCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 150, 25));

        jlblCondicion1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblCondicion1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblCondicion1.setText("2020");
        jlblCondicion1.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel2.add(jlblCondicion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 40, 25));

        jcbPeriodoSemestre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbPeriodoSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I", "II" }));
        jcbPeriodoSemestre.setPreferredSize(new java.awt.Dimension(56, 25));
        jPanel2.add(jcbPeriodoSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 50, -1));

        jcbDateFin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jcbDateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 160, 25));
        jPanel2.add(jcbDateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, 25));

        jbtnSalir.setBackground(new java.awt.Color(0, 0, 0));
        jbtnSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSalir.setText("SALIR");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 160, -1));

        jbtnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardar.setText("GUARDAR");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 160, -1));

        jlblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setText("Semestre vigente");
        jPanel2.add(jlblAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 700, 20));

        contenedor.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(contenedor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarSemestreActionPerformed
        objSemestreF.setFecha_Fin_Real(new Date());
        jpa.getTransaction().begin();
        jpa.persist(objSemestreF);
        objPrincipal.actulizarPeriodoClick();
        JOptionPane.showMessageDialog(jLabel12, "Semestre culminado");
        objCuadrito.setVisible(false);
        jpa.getTransaction().commit();
    }//GEN-LAST:event_jbtnCerrarSemestreActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        objCuadrito.setVisible(false);
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
   
        objSemestreF.setFecha_Fin(jcbDateFin.getDatoFecha());
        objSemestreF.setFecha_Inicio(jcbDateInicio.getDatoFecha());
        if(((String)jcbPeriodoSemestre.getSelectedItem()).equals("I")){
            objSemestreF.setSemestre_periodo(false);
        }
        else{
            objSemestreF.setSemestre_periodo(true);
        }
        jpa.getTransaction().begin();
        jpa.persist(objSemestreF);
        objPrincipal.actulizarPeriodoClick();
        JOptionPane.showMessageDialog(jLabel12, "Guardado con exito");
        objCuadrito.setVisible(false);
        jpa.getTransaction().commit();
    }//GEN-LAST:event_jbtnGuardarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtnCerrarSemestre;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnSalir;
    private rojeru_san.componentes.RSDateChooser jcbDateFin;
    private rojeru_san.componentes.RSDateChooser jcbDateInicio;
    private javax.swing.JComboBox<String> jcbPeriodoSemestre;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblCondicion1;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblEstCodigo;
    private javax.swing.JLabel jlblNombre1;
    private javax.swing.JLabel jlblSerie;
    // End of variables declaration//GEN-END:variables
}
