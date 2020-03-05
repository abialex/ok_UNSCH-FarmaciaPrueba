package com.ecoedu.Vistas.Inventario;




import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.app.EventoPagina;
import com.ecoedu.model.Detalle_llenado;
import com.ecoedu.model.Inventario;
import com.ecoedu.model.RegistroMensualInventario;
import com.ecoedu.model.RegistroMensualLotes;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Usuario;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class Abrir_Inventario extends javax.swing.JPanel {  
    List<Detalle_llenado> Lista_lote_detalle=new ArrayList<Detalle_llenado>();
    List<Inventario> Lista_Inventario;
    Principal objPrincipal;
    List<Rol> Lista_Origen;
    List<Detalle_llenado> lista_aux;
    boolean SWITCHBD=false;
    boolean SWITCHimpresion=false;
    //MensajeCarga objMensaje;
    
    Usuario objUsuario;
    EntityManager jpa;
    List<RegistroMensualLotes> lista_registro;
    
    public Abrir_Inventario(EntityManager jpa2,Principal OBJPrincipal,Usuario objUser ){
        initComponents();   
        this.objUsuario=objUser;
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;             
    }
    public class Proceso extends Thread{
        @Override
        public void run(){ 
            aperturar();
            }
        }
    public void ConsultaBD(){    
        Lista_Origen=jpa.createQuery("Select p from Rol p where id_tipo_Roles=10").getResultList();
        Collections.sort(Lista_Origen);        
        lista_registro=jpa.createQuery("SELECT p FROM RegistroMensualLotes p where fecha_cierre_real is null").getResultList();
        lista_aux=jpa.createQuery("SELECT p FROM Detalle_llenado p").getResultList();
        if(lista_registro.isEmpty()){
             jlblAdvertencia.setText("");            
             Lista_Inventario=jpa.createQuery("select p from Inventario p where cantidad !=0").getResultList();
             
             Lista_lote_detalle.clear();
             for (Detalle_llenado detalle_llenado : lista_aux) {
                 if(!detalle_llenado.getLote_detalle().isIsVencido()){
                 Lista_lote_detalle.add(detalle_llenado);}
             }
             Collections.sort(Lista_lote_detalle);//ordenando A-Z (m�todo como Override)            
            
             if(jpa.createQuery("Select p from RegistroMensualLotes p where month(fecha_apertura)="+(new Date().getMonth()+1)).getResultList().isEmpty()){
                 jbtnAbrirInventario.setVisible(true);
                 jbtnImprimir.setVisible(false);
                 llenarTabla(Lista_lote_detalle);                 
             }
             else{
                 jlblAdvertencia.setText("YA ABRI� PARA ESTE MES");
                 jbtnAbrirInventario.setVisible(false);
                 llenarTabla(new ArrayList<Detalle_llenado>());
                 jbtnImprimir.setVisible(false);
                 }
             }
         else{
             if(lista_registro.get(0).getFecha_cierra()==null){
                 jlblAdvertencia.setText("El Inventario de "+Herramienta.getNombreMes(lista_registro.get(0).getFecha_apertura().getMonth()+1)+" Est� Abierto");
                 jbtnAbrirInventario.setVisible(false);
                 
                 }
             else{
                 jlblAdvertencia.setText("Inventar�e los lotes para Abrir Inventario del Mes de "+Herramienta.getNombreMes(lista_registro.get(0).getFecha_apertura().getMonth()+2));
                 
                 }
             jbtnImprimir.setVisible(true);
             jbtnImprimir.setText("Imprimir Apertura de "+Herramienta.getNombreMes(lista_registro.get(0).getFecha_apertura().getMonth()+1));
             jbtnAbrirInventario.setVisible(false);
             llenarTabla(new ArrayList<Detalle_llenado>());
             }
         }
    
    public void principalEjecucion(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        confirmarProceso = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblHead = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlblMensaje = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlblMensaje1 = new javax.swing.JLabel();
        jlblMensaje2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        carga = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlblHead1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jlblMensaje3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        confirmarImpresion = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jlblHead3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jlblMensaje5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jlblMensaje6 = new javax.swing.JLabel();
        jlblMensaje7 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbtnImprimirApertura = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jbtnCancelarImpresion = new javax.swing.JButton();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlblAdvertencia = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblVentas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtnAbrirInventario = new javax.swing.JButton();
        jbtnImprimir = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(350, 250));
        jDialog1.setModal(true);
        jDialog1.setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 251, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(100, 176));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel1.setLayout(new java.awt.CardLayout());

        confirmarProceso.setBackground(new java.awt.Color(255, 255, 255));
        confirmarProceso.setMaximumSize(new java.awt.Dimension(700, 300));
        confirmarProceso.setMinimumSize(new java.awt.Dimension(700, 300));
        confirmarProceso.setName(""); // NOI18N
        confirmarProceso.setPreferredSize(new java.awt.Dimension(700, 300));
        confirmarProceso.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 193, 151));
        jPanel2.setForeground(new java.awt.Color(0, 193, 151));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 40));

        jlblHead.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblHead.setForeground(new java.awt.Color(153, 0, 51));
        jlblHead.setText("AVISO");
        jPanel2.add(jlblHead);

        confirmarProceso.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlblMensaje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblMensaje.setText("...");
        jPanel3.add(jlblMensaje);

        confirmarProceso.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jlblMensaje1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblMensaje1.setText("Si abre ya no podr� llenar lotes");
        jPanel4.add(jlblMensaje1);

        jlblMensaje2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblMensaje2.setText("�Segura(o) de abrir el inventario? ");
        jPanel4.add(jlblMensaje2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(290, 80));
        jPanel4.add(jLabel5);

        jbtnAceptar.setBackground(new java.awt.Color(0, 0, 255));
        jbtnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAceptar.setText("ACEPTAR");
        jbtnAceptar.setPreferredSize(new java.awt.Dimension(100, 30));
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnAceptar);

        jLabel6.setPreferredSize(new java.awt.Dimension(50, 14));
        jPanel4.add(jLabel6);

        jbtnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnCancelar);

        confirmarProceso.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(confirmarProceso, "card2");

        carga.setBackground(new java.awt.Color(255, 255, 255));
        carga.setMaximumSize(new java.awt.Dimension(700, 300));
        carga.setMinimumSize(new java.awt.Dimension(700, 300));
        carga.setName(""); // NOI18N
        carga.setPreferredSize(new java.awt.Dimension(700, 300));
        carga.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 193, 151));
        jPanel5.setForeground(new java.awt.Color(0, 193, 151));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 40));

        jlblHead1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblHead1.setText("Espere porfavor...");
        jPanel5.add(jlblHead1);

        carga.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jlblMensaje3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblMensaje3.setText("aperturando inventario");
        jPanel6.add(jlblMensaje3);

        carga.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cargando2.gif"))); // NOI18N
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 5, 320, 160));

        carga.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(carga, "card3");

        confirmarImpresion.setBackground(new java.awt.Color(255, 255, 255));
        confirmarImpresion.setMaximumSize(new java.awt.Dimension(700, 300));
        confirmarImpresion.setMinimumSize(new java.awt.Dimension(700, 300));
        confirmarImpresion.setName(""); // NOI18N
        confirmarImpresion.setPreferredSize(new java.awt.Dimension(700, 300));
        confirmarImpresion.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(0, 193, 151));
        jPanel13.setForeground(new java.awt.Color(0, 193, 151));
        jPanel13.setPreferredSize(new java.awt.Dimension(100, 40));

        jlblHead3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblHead3.setText("Escoga una opci�n");
        jPanel13.add(jlblHead3);

        confirmarImpresion.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jlblMensaje5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblMensaje5.setText("...");
        jPanel14.add(jlblMensaje5);

        confirmarImpresion.add(jPanel14, java.awt.BorderLayout.PAGE_END);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jlblMensaje6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblMensaje6.setText("�Desea Imprimir la apartura de Inventario?");
        jPanel15.add(jlblMensaje6);

        jlblMensaje7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblMensaje7.setForeground(new java.awt.Color(255, 255, 255));
        jlblMensaje7.setText("�Segura(o) de abrir el inventario? ");
        jPanel15.add(jlblMensaje7);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(290, 80));
        jPanel15.add(jLabel7);

        jbtnImprimirApertura.setBackground(new java.awt.Color(0, 0, 255));
        jbtnImprimirApertura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnImprimirApertura.setText("ACEPTAR");
        jbtnImprimirApertura.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel15.add(jbtnImprimirApertura);

        jLabel8.setPreferredSize(new java.awt.Dimension(50, 14));
        jPanel15.add(jLabel8);

        jbtnCancelarImpresion.setBackground(new java.awt.Color(255, 0, 0));
        jbtnCancelarImpresion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancelarImpresion.setText("CANCELAR");
        jbtnCancelarImpresion.setPreferredSize(new java.awt.Dimension(100, 30));
        jbtnCancelarImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarImpresionActionPerformed(evt);
            }
        });
        jPanel15.add(jbtnCancelarImpresion);

        confirmarImpresion.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel1.add(confirmarImpresion, "card2");

        jDialog1.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(990, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(207, 48, 72));
        head.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ABRIR INVENTARIO MENSUAL");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(890, 50));

        jlblAdvertencia.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jlblAdvertencia.setForeground(new java.awt.Color(0, 0, 255));
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel7.add(jlblAdvertencia);

        head2.add(jPanel7);

        body.add(head2, java.awt.BorderLayout.PAGE_START);

        body2.setBackground(new java.awt.Color(255, 255, 255));
        body2.setMaximumSize(new java.awt.Dimension(1990, 650));
        body2.setMinimumSize(new java.awt.Dimension(200, 200));
        body2.setPreferredSize(new java.awt.Dimension(9900, 520));
        body2.setLayout(new java.awt.BorderLayout());

        cuerpo1.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo1.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 330));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jtblVentas.setBorder(new javax.swing.border.MatteBorder(null));
        jtblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Producto Farmaceutico", "Cantidad", "Monto", "Monto Total", "Q. F."
            }
        ));
        jtblVentas.setGridColor(new java.awt.Color(0, 0, 0));
        jtblVentas.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblVentas.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jtblVentas);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 14));
        jPanel9.add(jLabel11, java.awt.BorderLayout.PAGE_END);

        jLabel14.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel14, java.awt.BorderLayout.LINE_END);

        jLabel18.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel18, java.awt.BorderLayout.LINE_START);

        jLabel2.setText("jLabel2");
        jPanel9.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        cuerpo1.add(jPanel9);

        jbtnAbrirInventario.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAbrirInventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnAbrirInventario.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAbrirInventario.setText("ABRIR INVENTARIO MENSUAL");
        jbtnAbrirInventario.setPreferredSize(new java.awt.Dimension(265, 25));
        jbtnAbrirInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAbrirInventarioActionPerformed(evt);
            }
        });
        cuerpo1.add(jbtnAbrirInventario);

        jbtnImprimir.setBackground(new java.awt.Color(0, 0, 0));
        jbtnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        jbtnImprimir.setText("Imprimir");
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });
        cuerpo1.add(jbtnImprimir);

        body2.add(cuerpo1, java.awt.BorderLayout.CENTER);

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAbrirInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAbrirInventarioActionPerformed
     
        jDialog1.setSize(350,250);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
        confirmarProceso.setVisible(true);
        confirmarProceso.setVisible(false);
        carga.setVisible(false);
        
        
        
    }//GEN-LAST:event_jbtnAbrirInventarioActionPerformed

    public void aperturar(){
        if(SWITCHBD){
        Date fechaApertu=new Date();
        Date fechaApertuReal=new Date();
        fechaApertu.setDate(1);
        fechaApertu.setHours(0);
        fechaApertu.setMinutes(0);
        fechaApertu.setSeconds(0);        
        jpa.getTransaction().begin();        
        int auxComprobante=0;
        for (Inventario inventario : Lista_Inventario){   
            RegistroMensualInventario objRegistro=new RegistroMensualInventario(inventario.getCantidad(), fechaApertu, fechaApertuReal, objUsuario, inventario);
            jpa.persist(objRegistro);
            jpa.refresh(objRegistro);
            for (Detalle_llenado lote_detalle : Lista_lote_detalle){
                if(lote_detalle.getLote_detalle().getInventario()==inventario){
                jpa.persist(new RegistroMensualLotes(lote_detalle.getLote_detalle().getCantidad(),fechaApertu, fechaApertuReal, objUsuario, lote_detalle.getLote_detalle(),objRegistro));
                auxComprobante=auxComprobante+lote_detalle.getLote_detalle().getCantidad();
                }//fin if
            }//fin for  
            if(auxComprobante!=inventario.getCantidad()){
                
                jpa.getTransaction().rollback();
                JOptionPane.showMessageDialog(cuerpo1,inventario.getMedicamento().getNombre()+" "+inventario.getId_Inventario()+" real: "+auxComprobante+" sistema: "+inventario.getCantidad() + " no coincide la suma de lostes iniciales con el inventario inicial");
            }
            auxComprobante=0;            
        }//fin for2   
        jpa.flush();
        ConsultaBD();
        principalEjecucion();
        jDialog1.dispose();
        //objMensaje.setVisible(false);
        //JOptionPane.showMessageDialog(jlblAdvertencia, "Apertur� con exito el mes de "+Herramienta.getNombreMes(fechaApertuReal.getMonth()+1));
        //int confirmado = JOptionPane.showConfirmDialog(jlblAdvertencia,"�Desea Imprimir la Apertura del Inventario?");
            
            jpa.getTransaction().commit();
        } 
        else{
           System.out.println("olgas");
        }
    }
    public void imprimir(){
        try {
            Date Fe=new Date();
            imprimirInventarioApertura(Fe);
            String url="Carpeta_de_Archivos\\Inventario_Apertura"+(Fe.getYear()+1900)+"_"+Fe.getMonth()+"_"+Fe.getDate()+".pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
            } catch (IOException ex) {
                Logger.getLogger(ServicioFarmacia.class.getName()).log(Level.SEVERE, null, ex);
                }
             
    }
    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        SWITCHBD=true;
        confirmarProceso.setVisible(false);
        confirmarImpresion.setVisible(false);
        carga.setVisible(true);
        new Proceso().start();
        
        
        
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        jDialog1.dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnCancelarImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarImpresionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCancelarImpresionActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
        /*Lista_lote_detalle.clear();
        for (RegistroMensualLotes registroMensualLotes : lista_registro){
            for (Detalle_llenado detalle : lista_aux) {
                if(detalle.getLote_detalle()==registroMensualLotes.getLote_detalle()){
                    //solo para que salga en el stock inicial
                    Detalle_llenado ols=new Detalle_llenado();
                    ols.set(detalle.getCantidad());
                    //detalle.getLote_detalle().setCantidad(registroMensualLotes.getCantidad_inicial());
                    Lista_lote_detalle.add(ols);
                    
                    break;       
                    }
                }
            } */      
        imprimir();
       
    }//GEN-LAST:event_jbtnImprimirActionPerformed
    public void imprimirInventarioApertura(Date Fe) throws MalformedURLException, IOException{
        
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        PdfWriter writer=null;
        try {
             writer=new PdfWriter
                ("Carpeta_de_Archivos\\Inventario_Apertura"+(Fe.getYear()+1900)+"_"+Fe.getMonth()+"_"+Fe.getDate()+".pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso");
        }  
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());       
        EventoPagina evento = new EventoPagina(document);
        // Indicamos que el manejador se encargara del evento END_PAGE
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
        document.setMargins(75, 36, 75, 36);    
        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);  
        Paragraph paragIma=new Paragraph("     ").add(unsch).add("                                    APERTURA DE INVENTARIO PARA EL MES DE "+Herramienta.getNombreMes((Fe.getMonth()+1)) ).setFontSize(16).setFont(bold);  
        document.add(paragIma);  
        //Paragraph parag2=new Paragraph("Servicio Farmacia                                                                                                                                                                "+Herramienta.formatoFechaHoraMas1(new Date()));         
        //document.add(parag2);
        int tam=7;
        int tamFond=9;
        
        for (Rol Origen : Lista_Origen){
            boolean auxAgregar=false;
            Table table = new Table(new float[]{19,7,7,11,11,7,11,11,11,11});
            table.setWidthPercent(100);       
            document.add(new Paragraph(""));    
            table.addHeaderCell(new Cell().add(new Paragraph("Producto Farmac�utico").setFontSize(tamFond).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
            table.addHeaderCell(new Cell().add(new Paragraph("Conc.").setFont(bold)).setFontSize(tamFond).setTextAlignment(TextAlignment.CENTER));         
            table.addHeaderCell(new Cell().add(new Paragraph("F.F").setFont(bold)).setFontSize(tamFond).setTextAlignment(TextAlignment.CENTER));        
            table.addHeaderCell(new Cell().add(new Paragraph("Lab.").setFont(bold)).setFontSize(tamFond).setTextAlignment(TextAlignment.CENTER)); 
            table.addHeaderCell(new Cell().add(new Paragraph("Lote").setFont(bold)).setFontSize(tamFond).setTextAlignment(TextAlignment.CENTER)); 
            table.addHeaderCell(new Cell().add(new Paragraph("P.A").setFont(bold)).setFontSize(tamFond).setTextAlignment(TextAlignment.CENTER)); 
            table.addHeaderCell(new Cell().add(new Paragraph("Fecha Venc.").setFontSize(tamFond).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
            table.addHeaderCell(new Cell().add(new Paragraph("FACTURA").setFontSize(tamFond).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
            table.addHeaderCell(new Cell().add(new Paragraph("Proveedor").setFontSize(tamFond).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
            table.addHeaderCell(new Cell().add(new Paragraph("Stock Inicial").setFontSize(tamFond).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 

      Collections.sort(lista_registro);//ordenando A-Z (m�todo como Override)
        for (RegistroMensualLotes Lote_detalle : lista_registro){
            if(Lote_detalle.getLote_detalle().getInventario().getMedicamento().getRolorigen()==Origen){
                
                auxAgregar=true;                            
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getInventario().getMedicamento().getNombre()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.LEFT));//P.F
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getInventario().getMedicamento().getConcentracion()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//Conc
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getInventario().getMedicamento().getForma_farmaceutica()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//FF
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getRolFabricante().getNombre_rol()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//labo
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getCodigo()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//lote
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getPrecio_Venta_Redondeado()+"").setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//P.A
            if(Lote_detalle.getLote_detalle().getFecha_vencimiento().getTime()-(new Date()).getTime()>=0){
                if((Lote_detalle.getLote_detalle().getFecha_vencimiento().getTime()-(new Date()).getTime())/86400000 <=6*30){
                    
                    table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_detalle.getLote_detalle().getFecha_vencimiento())).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.YELLOW));
                    }
                else{
                    table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_detalle.getLote_detalle().getFecha_vencimiento())).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.WHITE));
                    }
            }
            else{
                table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_detalle.getLote_detalle().getFecha_vencimiento())).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.RED));
                }
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getFactura().getCodigo_factura()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            table.addCell(new Paragraph(Lote_detalle.getLote_detalle().getFactura().getRolProveedor().getNombre_rol()).setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            table.addCell(new Paragraph(Lote_detalle.getCantidad_inicial()+"").setFontSize(tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final


            }
        }
        if(auxAgregar){document.add(new Paragraph(Origen.getNombre_rol()).setTextAlignment(TextAlignment.CENTER).setFont(bold).setFontSize(14));document.add(table);
        document.add(new AreaBreak());}
        }        
        //Lista_lote_detalle.clear();
        document.close(); 
    }
    public void llenarTabla(List<Detalle_llenado> lista_lote_detalle){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"C�digo","Producto Farmac�utico","Cant","P.V.R","C�digo Factura","Laboratorio","F.V"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false, false, false,false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
            
             
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (Detalle_llenado objLote : lista_lote_detalle){
                 fila_actividad[0]=objLote.getLote_detalle().getCodigo();
                 fila_actividad[1]=objLote.getLote_detalle().getInventario().getMedicamento().getNombre();
                 fila_actividad[2]=objLote.getLote_detalle().getCantidad();
                 fila_actividad[3]=objLote.getLote_detalle().getPrecio_Venta_Redondeado();  
                 fila_actividad[4]=objLote.getLote_detalle().getFactura().getCodigo_factura();   
                 fila_actividad[5]=objLote.getLote_detalle().getRolFabricante().getNombre_rol();   
                 fila_actividad[6]=Herramienta.formatoFecha(objLote.getLote_detalle().getFecha_vencimiento());  
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblVentas.setModel(modelo); 
            jtblVentas.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblVentas.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblVentas.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblVentas.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblVentas.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtblVentas.getColumnModel().getColumn(4).setCellRenderer(tcr);
            jtblVentas.getColumnModel().getColumn(5).setCellRenderer(tcr);
            jtblVentas.getColumnModel().getColumn(6).setCellRenderer(tcr);
            
            jtblVentas.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblVentas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblVentas.getTableHeader().setBackground(Color.BLUE);
            jtblVentas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblVentas.getColumnModel().getColumn(0).setPreferredWidth(154);
            jtblVentas.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtblVentas.getColumnModel().getColumn(2).setPreferredWidth(75);
            jtblVentas.getColumnModel().getColumn(3).setPreferredWidth(125);
            jtblVentas.getColumnModel().getColumn(4).setPreferredWidth(130);
            jtblVentas.getColumnModel().getColumn(5).setPreferredWidth(180);
            jtblVentas.getColumnModel().getColumn(6).setPreferredWidth(120);
            
            ((DefaultTableCellRenderer)jtblVentas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64
            

    
           
    }   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel carga;
    private javax.swing.JPanel confirmarImpresion;
    private javax.swing.JPanel confirmarProceso;
    private javax.swing.JPanel cuerpo1;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAbrirInventario;
    private javax.swing.JButton jbtnAceptar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCancelarImpresion;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JButton jbtnImprimirApertura;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblHead;
    private javax.swing.JLabel jlblHead1;
    private javax.swing.JLabel jlblHead3;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JLabel jlblMensaje1;
    private javax.swing.JLabel jlblMensaje2;
    private javax.swing.JLabel jlblMensaje3;
    private javax.swing.JLabel jlblMensaje5;
    private javax.swing.JLabel jlblMensaje6;
    private javax.swing.JLabel jlblMensaje7;
    private javax.swing.JTable jtblVentas;
    // End of variables declaration//GEN-END:variables

}
