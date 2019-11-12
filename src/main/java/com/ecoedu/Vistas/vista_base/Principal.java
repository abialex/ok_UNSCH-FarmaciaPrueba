/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas.vista_base;
import com.ecoedu.Vistas.Estudiante.Estudiante_vista;
import com.ecoedu.Vistas.Consultas.Consultas;
import com.ecoedu.Vistas.Inventario.InventarioOper;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.model.Usuario;
import javax.persistence.EntityManager;


/**
 *
 * @author yrma
 */
public class Principal extends javax.swing.JFrame {

   EntityManager jpa;
   Usuario user;
   ServicioFarmacia objServicioFarmacia;
   Estudiante_vista objAgregarMedi=new Estudiante_vista();
   Consultas objBusquedaVentas;
   InventarioOper objInventarioOper;
    public Principal(EntityManager OBJjpa,Usuario OBJuser){
        initComponents();
        this.jpa=OBJjpa;
        this.user=OBJuser;
        this.objServicioFarmacia=new ServicioFarmacia(jpa,this,user);
        this.objBusquedaVentas=new Consultas(jpa);
        this.objInventarioOper=new InventarioOper(jpa,this);
        this.setLocationRelativeTo(null);
        jlblUsuario.setText(user.getPersona().getInfoPersona());
        bodyContenedor.add(objBusquedaVentas);  
        bodyContenedor.validate();
        bodyContenedor.add(objServicioFarmacia);   
        bodyContenedor.validate();
        bodyContenedor.add(objAgregarMedi);
        bodyContenedor.validate();
        bodyContenedor.add(objInventarioOper);
        bodyContenedor.validate();
        bodyContenedor.setVisible(false);    
        jtfsub_inventario.setVisible(false);
        jtfsub_Consultas.setVisible(false);
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jlblUsuario = new javax.swing.JLabel();
        jlblNavegacion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlblSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        jleftEntregaMedicinas = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jleftInventario = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblInventarioFlecha = new javax.swing.JLabel();
        jtfsub_inventario = new javax.swing.JPanel();
        jleftInventario_llenarInventario = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jleftInventario_detalleInventario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jleftConsultas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblConsultasFlecha = new javax.swing.JLabel();
        jtfsub_Consultas = new javax.swing.JPanel();
        jleftConsultas_Entregadeldia = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jleftConsultas_ReportedelMes = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jleftAgregarMedi = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bodyContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setUndecorated(true);
        setResizable(false);

        contenedorPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedorPrincipal.setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(240, 0, 0));
        head.setPreferredSize(new java.awt.Dimension(694, 80));
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(57, 23, 71));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(57, 23, 71));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FARMACIA-UNSCH");
        jLabel4.setPreferredSize(new java.awt.Dimension(196, 50));
        jPanel3.add(jLabel4, java.awt.BorderLayout.CENTER);

        head.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jPanel4.setBackground(new java.awt.Color(236, 230, 230));
        jPanel4.setPreferredSize(new java.awt.Dimension(669, 1000));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel5.setText("Química(o) Farmacéutica(o):");
        jLabel5.setMaximumSize(new java.awt.Dimension(990, 14));
        jLabel5.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, -1, -1));

        jlblUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblUsuario.setPreferredSize(new java.awt.Dimension(640, 50));
        jPanel4.add(jlblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 5, 520, -1));

        jlblNavegacion.setText("Navegacion");
        jlblNavegacion.setPreferredSize(new java.awt.Dimension(900, 19));
        jPanel4.add(jlblNavegacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new java.awt.BorderLayout());

        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0002-salida.png"))); // NOI18N
        jPanel1.add(jlblSalir, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 7, 32, 32));

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new java.awt.BorderLayout());

        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0001-minimizar.png"))); // NOI18N
        jPanel2.add(jlblMinimizar, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 7, 32, 32));

        head.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 900, 80));

        contenedorPrincipal.add(head, java.awt.BorderLayout.PAGE_START);

        left.setBackground(new java.awt.Color(73, 25, 119));
        left.setPreferredSize(new java.awt.Dimension(300, 485));

        jleftEntregaMedicinas.setBackground(new java.awt.Color(73, 20, 119));
        jleftEntregaMedicinas.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEntregaMedicinas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEntregaMedicinasMouseMoved(evt);
            }
        });
        jleftEntregaMedicinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEntregaMedicinasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEntregaMedicinasMouseExited(evt);
            }
        });
        jleftEntregaMedicinas.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(153, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Servicio Farmacia");
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftEntregaMedicinas.add(jLabel6, java.awt.BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-medicine.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftEntregaMedicinas.add(jLabel2, java.awt.BorderLayout.LINE_START);

        left.add(jleftEntregaMedicinas);

        jleftInventario.setBackground(new java.awt.Color(73, 20, 119));
        jleftInventario.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventarioMouseMoved(evt);
            }
        });
        jleftInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventarioMouseExited(evt);
            }
        });
        jleftInventario.setLayout(new java.awt.BorderLayout());

        jLabel10.setBackground(new java.awt.Color(153, 0, 153));
        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Inventario");
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 50));
        jleftInventario.add(jLabel10, java.awt.BorderLayout.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-inventory.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftInventario.add(jLabel1, java.awt.BorderLayout.LINE_START);

        jlblInventarioFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblInventarioFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblInventarioFlecha.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftInventario.add(jlblInventarioFlecha, java.awt.BorderLayout.LINE_END);

        left.add(jleftInventario);

        jtfsub_inventario.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_inventario.setPreferredSize(new java.awt.Dimension(300, 120));

        jleftInventario_llenarInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_llenarInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseMoved(evt);
            }
        });
        jleftInventario_llenarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseExited(evt);
            }
        });
        jleftInventario_llenarInventario.setLayout(new java.awt.BorderLayout());

        jLabel13.setBackground(new java.awt.Color(153, 0, 153));
        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Llenar Inventario");
        jLabel13.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_llenarInventario.add(jLabel13, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_llenarInventario);

        jleftInventario_detalleInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_detalleInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseMoved(evt);
            }
        });
        jleftInventario_detalleInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseExited(evt);
            }
        });
        jleftInventario_detalleInventario.setLayout(new java.awt.BorderLayout());

        jLabel14.setBackground(new java.awt.Color(153, 0, 153));
        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Detalle de Inventario");
        jLabel14.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_detalleInventario.add(jLabel14, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_detalleInventario);

        left.add(jtfsub_inventario);

        jleftConsultas.setBackground(new java.awt.Color(73, 20, 119));
        jleftConsultas.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultasMouseMoved(evt);
            }
        });
        jleftConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultasMouseExited(evt);
            }
        });
        jleftConsultas.setLayout(new java.awt.BorderLayout());

        jLabel11.setBackground(new java.awt.Color(153, 0, 153));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Consultas ");
        jLabel11.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftConsultas.add(jLabel11, java.awt.BorderLayout.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/003-pros-and-cons.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftConsultas.add(jLabel3, java.awt.BorderLayout.LINE_START);

        jlblConsultasFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblConsultasFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftConsultas.add(jlblConsultasFlecha, java.awt.BorderLayout.LINE_END);

        left.add(jleftConsultas);

        jtfsub_Consultas.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Consultas.setPreferredSize(new java.awt.Dimension(300, 120));

        jleftConsultas_Entregadeldia.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Entregadeldia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseMoved(evt);
            }
        });
        jleftConsultas_Entregadeldia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseExited(evt);
            }
        });
        jleftConsultas_Entregadeldia.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(153, 0, 153));
        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Entrega del Día");
        jLabel16.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_Entregadeldia.add(jLabel16, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_Entregadeldia);

        jleftConsultas_ReportedelMes.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_ReportedelMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseMoved(evt);
            }
        });
        jleftConsultas_ReportedelMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseExited(evt);
            }
        });
        jleftConsultas_ReportedelMes.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(153, 0, 153));
        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Reporte del Mes");
        jLabel17.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_ReportedelMes.add(jLabel17, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_ReportedelMes);

        left.add(jtfsub_Consultas);

        jleftAgregarMedi.setBackground(new java.awt.Color(73, 20, 119));
        jleftAgregarMedi.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftAgregarMedi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftAgregarMediMouseMoved(evt);
            }
        });
        jleftAgregarMedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftAgregarMediMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftAgregarMediMouseExited(evt);
            }
        });
        jleftAgregarMedi.setLayout(new java.awt.BorderLayout());

        jLabel12.setBackground(new java.awt.Color(153, 0, 153));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Estudiante");
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftAgregarMedi.add(jLabel12, java.awt.BorderLayout.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/004-student.png"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftAgregarMedi.add(jLabel7, java.awt.BorderLayout.LINE_START);

        left.add(jleftAgregarMedi);

        contenedorPrincipal.add(left, java.awt.BorderLayout.LINE_START);

        bodyContenedor.setBackground(new java.awt.Color(255, 0, 255));
        bodyContenedor.setPreferredSize(new java.awt.Dimension(0, 0));
        bodyContenedor.setLayout(new java.awt.BorderLayout());
        contenedorPrincipal.add(bodyContenedor, java.awt.BorderLayout.CENTER);

        getContentPane().add(contenedorPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jleftEntregaMedicinasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEntregaMedicinasMouseMoved
        jleftEntregaMedicinas.setBackground((new java.awt.Color(4,20,25)));
        
    }//GEN-LAST:event_jleftEntregaMedicinasMouseMoved

    private void jleftEntregaMedicinasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEntregaMedicinasMouseExited
        jleftEntregaMedicinas.setBackground((new java.awt.Color(73,25,119)));
        

    }//GEN-LAST:event_jleftEntregaMedicinasMouseExited

    private void jleftInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseMoved
        jleftInventario.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftInventarioMouseMoved

    private void jleftInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseExited
        jleftInventario.setBackground((new java.awt.Color(73,25,119)));
    }//GEN-LAST:event_jleftInventarioMouseExited

    private void jleftAgregarMediMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftAgregarMediMouseMoved
        jleftAgregarMedi.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftAgregarMediMouseMoved

    private void jleftAgregarMediMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftAgregarMediMouseExited
        jleftAgregarMedi.setBackground((new java.awt.Color(73,25,119)));
    }//GEN-LAST:event_jleftAgregarMediMouseExited

    private void jleftInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseClicked
      bodyContenedor.setVisible(true);  
      
      objInventarioOper.setVisible(true);
      objAgregarMedi.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false); 
      
      if(jtfsub_inventario.isShowing()){
      jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_inventario.setVisible(false);
      }
      else{
          jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_inventario.setVisible(true);
          

      }
       
        
    }//GEN-LAST:event_jleftInventarioMouseClicked

    private void jleftEntregaMedicinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEntregaMedicinasMouseClicked
        bodyContenedor.setVisible(true);
        
        objInventarioOper.setVisible(false);
        objAgregarMedi.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objServicioFarmacia.setVisible(true);       
       
        
                
    }//GEN-LAST:event_jleftEntregaMedicinasMouseClicked

    private void jleftAgregarMediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftAgregarMediMouseClicked
        bodyContenedor.setVisible(true);
        
        objInventarioOper.setVisible(false);
        objAgregarMedi.setVisible(true);        
        objBusquedaVentas.setVisible(false);
        objServicioFarmacia.setVisible(false);
        
    }//GEN-LAST:event_jleftAgregarMediMouseClicked

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0002-Salida-1.png")));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0002-salida.png")));
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0001-minimizar-1.png")));

    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0001-minimizar.png")));

    }//GEN-LAST:event_jPanel2MouseExited

    private void jleftConsultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseExited
        jleftConsultas.setBackground((new java.awt.Color(73,25,119)));
    }//GEN-LAST:event_jleftConsultasMouseExited

    private void jleftConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseClicked
        bodyContenedor.setVisible(true);

        objInventarioOper.setVisible(false);
        objAgregarMedi.setVisible(false);
        objBusquedaVentas.setVisible(true);
        objServicioFarmacia.setVisible(false);
        
        if(jtfsub_Consultas.isShowing()){
      jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_Consultas.setVisible(false);
      }
      else{
          jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_Consultas.setVisible(true);}
    }//GEN-LAST:event_jleftConsultasMouseClicked

    private void jleftConsultasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseMoved
        jleftConsultas.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftConsultasMouseMoved

    private void jleftInventario_llenarInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseMoved
        jleftInventario_llenarInventario.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseMoved

    private void jleftInventario_llenarInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseExited
        jleftInventario_llenarInventario.setBackground((new java.awt.Color(73,20,100)));
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseExited

    private void jleftInventario_detalleInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseMoved
        jleftInventario_detalleInventario.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseMoved

    private void jleftInventario_detalleInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseExited
        jleftInventario_detalleInventario.setBackground((new java.awt.Color(73,20,100)));
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseExited

    private void jleftConsultas_EntregadeldiaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseMoved
        jleftConsultas_Entregadeldia.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseMoved

    private void jleftConsultas_EntregadeldiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseExited
        jleftConsultas_Entregadeldia.setBackground((new java.awt.Color(73,20,100)));
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseExited

    private void jleftConsultas_ReportedelMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseMoved
        jleftConsultas_ReportedelMes.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseMoved

    private void jleftConsultas_ReportedelMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseExited
        jleftConsultas_ReportedelMes.setBackground((new java.awt.Color(73,20,100)));
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseExited

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyContenedor;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlblConsultasFlecha;
    private javax.swing.JLabel jlblInventarioFlecha;
    private javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblNavegacion;
    private javax.swing.JLabel jlblSalir;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPanel jleftAgregarMedi;
    private javax.swing.JPanel jleftConsultas;
    private javax.swing.JPanel jleftConsultas_Entregadeldia;
    private javax.swing.JPanel jleftConsultas_ReportedelMes;
    private javax.swing.JPanel jleftEntregaMedicinas;
    private javax.swing.JPanel jleftInventario;
    private javax.swing.JPanel jleftInventario_detalleInventario;
    private javax.swing.JPanel jleftInventario_llenarInventario;
    private javax.swing.JPanel jtfsub_Consultas;
    private javax.swing.JPanel jtfsub_inventario;
    private javax.swing.JPanel left;
    // End of variables declaration//GEN-END:variables
}
