/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas.vista_base;
import com.ecoedu.Vistas.Estudiante.Estudiante_vista;
import com.ecoedu.Vistas.Consultas.Consultas;
import com.ecoedu.Vistas.Inventario.Detalle_Inventario;
import com.ecoedu.Vistas.Inventario.LlenarInventario;
import com.ecoedu.Vistas.Inventario.Ver_inventario;
import com.ecoedu.Vistas.Medicamento.OperacionesMedicamento;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.model.Usuario;
import java.awt.Color;
import javax.persistence.EntityManager;


/**
 *
 * @author yrma
 */
public class Principal extends javax.swing.JFrame {
    
   
   EntityManager jpa;
   private Usuario user;
   private ServicioFarmacia objServicioFarmacia;
   private Estudiante_vista objAgregarMedi=new Estudiante_vista();
   private Consultas objBusquedaVentas;
   private Detalle_Inventario objDetalle_Inventario;
   private LlenarInventario objLlenarInventario;
   private Ver_inventario objVer_inventario;
   private OperacionesMedicamento objOperacionesMedicamento;
   
   
   private Color colorMoved=new Color(4,20,25);
   private Color colorExitSub=new Color(73,20,100);
   private Color colorExit=new Color(73,25,119);
    public Principal(EntityManager OBJjpa,Usuario OBJuser){
        initComponents();
        this.jpa=OBJjpa;
        this.user=OBJuser;
        this.objOperacionesMedicamento=new OperacionesMedicamento(OBJjpa, this);
        this.objServicioFarmacia=new ServicioFarmacia(jpa,this,user);
        this.objBusquedaVentas=new Consultas(jpa);
        this.objLlenarInventario=new LlenarInventario(jpa, this);
        this.objDetalle_Inventario=new Detalle_Inventario(jpa,this);
        this.objVer_inventario=new Ver_inventario(OBJjpa, this);
        this.setLocationRelativeTo(null);
        jlblUsuario.setText(user.getPersona().getInfoPersona());
        bodyContenedor.add(objBusquedaVentas);  
        bodyContenedor.validate();
        bodyContenedor.add(objServicioFarmacia);   
        bodyContenedor.validate();
        bodyContenedor.add(objAgregarMedi);
        bodyContenedor.validate();
        bodyContenedor.add(objDetalle_Inventario);
        bodyContenedor.validate();
        bodyContenedor.add(objLlenarInventario);
        bodyContenedor.validate();
        bodyContenedor.add(objVer_inventario);
        bodyContenedor.validate();
        bodyContenedor.add(objOperacionesMedicamento);
        bodyContenedor.validate();
        
     
        bodyContenedor.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        jtfsub_Consultas.setVisible(false);    
        jtfsub_Medicina.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
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
        jleftServicioFarmacia = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jleftInventario = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblInventarioFlecha = new javax.swing.JLabel();
        jtfsub_inventario = new javax.swing.JPanel();
        jleftInventario_verInventario = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jleftInventario_llenarInventario = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jleftInventario_detalleInventario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jleftMedicamento = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlblConsultasFlecha1 = new javax.swing.JLabel();
        jtfsub_Medicina = new javax.swing.JPanel();
        jleftMedicina_CrearModificarMedicamento = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jleftConsultas_MedicamentoUsado = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jleftEstudiante = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblEstudianteFlecha1 = new javax.swing.JLabel();
        jtfsub_Estudiante = new javax.swing.JPanel();
        jleftEstudiante_CrearModificarEstudiante = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jleftEstudiante_InformacionEstudiante = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jleftConsultas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblConsultasFlecha = new javax.swing.JLabel();
        jtfsub_Consultas = new javax.swing.JPanel();
        jleftConsultas_Entregadeldia = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jleftConsultas_ReportedelMes = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jleftUsuario = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblConsultasFlecha2 = new javax.swing.JLabel();
        jtfsub_Usuario = new javax.swing.JPanel();
        jleftUsuario_CrearModificarUser = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jleftUsuario_AdministrarRol = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jlefProveedorYfabrecante = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jlblConsultasFlecha3 = new javax.swing.JLabel();
        jtfsub_ProveedorYfabricante = new javax.swing.JPanel();
        jleftUsuario_CrearModificarUser1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jleftUsuario_AdministrarRol1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
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

        jleftServicioFarmacia.setBackground(new java.awt.Color(73, 20, 119));
        jleftServicioFarmacia.setPreferredSize(new java.awt.Dimension(300, 33));
        jleftServicioFarmacia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftServicioFarmaciaMouseMoved(evt);
            }
        });
        jleftServicioFarmacia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftServicioFarmaciaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftServicioFarmaciaMouseExited(evt);
            }
        });
        jleftServicioFarmacia.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(153, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Servicio Farmacia");
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftServicioFarmacia.add(jLabel6, java.awt.BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/009-drug.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftServicioFarmacia.add(jLabel2, java.awt.BorderLayout.LINE_START);

        left.add(jleftServicioFarmacia);

        jleftInventario.setBackground(new java.awt.Color(73, 20, 119));
        jleftInventario.setPreferredSize(new java.awt.Dimension(300, 32));
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

        jleftInventario_verInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_verInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_verInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_verInventarioMouseMoved(evt);
            }
        });
        jleftInventario_verInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_verInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_verInventarioMouseExited(evt);
            }
        });
        jleftInventario_verInventario.setLayout(new java.awt.BorderLayout());

        jLabel22.setBackground(new java.awt.Color(153, 0, 153));
        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Ver ");
        jLabel22.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_verInventario.add(jLabel22, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_verInventario);

        jleftInventario_llenarInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_llenarInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_llenarInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseMoved(evt);
            }
        });
        jleftInventario_llenarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseClicked(evt);
            }
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
        jleftInventario_detalleInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_detalleInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseMoved(evt);
            }
        });
        jleftInventario_detalleInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseClicked(evt);
            }
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

        jleftMedicamento.setBackground(new java.awt.Color(73, 20, 119));
        jleftMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicamentoMouseExited(evt);
            }
        });
        jleftMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel15.setBackground(new java.awt.Color(153, 0, 153));
        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Medicamento");
        jLabel15.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftMedicamento.add(jLabel15, java.awt.BorderLayout.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-medicine.png"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftMedicamento.add(jLabel8, java.awt.BorderLayout.LINE_START);

        jlblConsultasFlecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblConsultasFlecha1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha1.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftMedicamento.add(jlblConsultasFlecha1, java.awt.BorderLayout.LINE_END);

        left.add(jleftMedicamento);

        jtfsub_Medicina.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Medicina.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftMedicina_CrearModificarMedicamento.setBackground(new java.awt.Color(73, 20, 100));
        jleftMedicina_CrearModificarMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicina_CrearModificarMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearModificarMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicina_CrearModificarMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearModificarMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearModificarMedicamentoMouseExited(evt);
            }
        });
        jleftMedicina_CrearModificarMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel20.setBackground(new java.awt.Color(153, 0, 153));
        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Crear/Modificar Medicamento");
        jLabel20.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftMedicina_CrearModificarMedicamento.add(jLabel20, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftMedicina_CrearModificarMedicamento);

        jleftConsultas_MedicamentoUsado.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_MedicamentoUsado.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_MedicamentoUsado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_MedicamentoUsadoMouseMoved(evt);
            }
        });
        jleftConsultas_MedicamentoUsado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_MedicamentoUsadoMouseExited(evt);
            }
        });
        jleftConsultas_MedicamentoUsado.setLayout(new java.awt.BorderLayout());

        jLabel21.setBackground(new java.awt.Color(153, 0, 153));
        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Medicamento Mas Usado");
        jLabel21.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_MedicamentoUsado.add(jLabel21, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftConsultas_MedicamentoUsado);

        left.add(jtfsub_Medicina);

        jleftEstudiante.setBackground(new java.awt.Color(73, 20, 119));
        jleftEstudiante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudianteMouseMoved(evt);
            }
        });
        jleftEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEstudianteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudianteMouseExited(evt);
            }
        });
        jleftEstudiante.setLayout(new java.awt.BorderLayout());

        jLabel12.setBackground(new java.awt.Color(153, 0, 153));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Estudiante");
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftEstudiante.add(jLabel12, java.awt.BorderLayout.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/004-student.png"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftEstudiante.add(jLabel7, java.awt.BorderLayout.LINE_START);

        jlblEstudianteFlecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblEstudianteFlecha1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblEstudianteFlecha1.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftEstudiante.add(jlblEstudianteFlecha1, java.awt.BorderLayout.LINE_END);

        left.add(jleftEstudiante);

        jtfsub_Estudiante.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Estudiante.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftEstudiante_CrearModificarEstudiante.setBackground(new java.awt.Color(73, 20, 100));
        jleftEstudiante_CrearModificarEstudiante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante_CrearModificarEstudiante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseMoved(evt);
            }
        });
        jleftEstudiante_CrearModificarEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseExited(evt);
            }
        });
        jleftEstudiante_CrearModificarEstudiante.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(153, 0, 153));
        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Datos Estudiante");
        jLabel18.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEstudiante_CrearModificarEstudiante.add(jLabel18, java.awt.BorderLayout.CENTER);

        jtfsub_Estudiante.add(jleftEstudiante_CrearModificarEstudiante);

        jleftEstudiante_InformacionEstudiante.setBackground(new java.awt.Color(73, 20, 100));
        jleftEstudiante_InformacionEstudiante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante_InformacionEstudiante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudiante_InformacionEstudianteMouseMoved(evt);
            }
        });
        jleftEstudiante_InformacionEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudiante_InformacionEstudianteMouseExited(evt);
            }
        });
        jleftEstudiante_InformacionEstudiante.setLayout(new java.awt.BorderLayout());

        jLabel19.setBackground(new java.awt.Color(153, 0, 153));
        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Información de Estudiante");
        jLabel19.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEstudiante_InformacionEstudiante.add(jLabel19, java.awt.BorderLayout.CENTER);

        jtfsub_Estudiante.add(jleftEstudiante_InformacionEstudiante);

        left.add(jtfsub_Estudiante);

        jleftConsultas.setBackground(new java.awt.Color(73, 20, 119));
        jleftConsultas.setPreferredSize(new java.awt.Dimension(300, 32));
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
        jtfsub_Consultas.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftConsultas_Entregadeldia.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Entregadeldia.setPreferredSize(new java.awt.Dimension(300, 32));
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
        jleftConsultas_ReportedelMes.setPreferredSize(new java.awt.Dimension(300, 32));
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

        jleftUsuario.setBackground(new java.awt.Color(73, 20, 119));
        jleftUsuario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuarioMouseMoved(evt);
            }
        });
        jleftUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftUsuarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuarioMouseExited(evt);
            }
        });
        jleftUsuario.setLayout(new java.awt.BorderLayout());

        jLabel23.setBackground(new java.awt.Color(153, 0, 153));
        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Usuario");
        jLabel23.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftUsuario.add(jLabel23, java.awt.BorderLayout.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jefe.png"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftUsuario.add(jLabel9, java.awt.BorderLayout.LINE_START);

        jlblConsultasFlecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblConsultasFlecha2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha2.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftUsuario.add(jlblConsultasFlecha2, java.awt.BorderLayout.LINE_END);

        left.add(jleftUsuario);

        jtfsub_Usuario.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Usuario.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftUsuario_CrearModificarUser.setBackground(new java.awt.Color(73, 20, 100));
        jleftUsuario_CrearModificarUser.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario_CrearModificarUser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUserMouseMoved(evt);
            }
        });
        jleftUsuario_CrearModificarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUserMouseExited(evt);
            }
        });
        jleftUsuario_CrearModificarUser.setLayout(new java.awt.BorderLayout());

        jLabel24.setBackground(new java.awt.Color(153, 0, 153));
        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Crear Usuario");
        jLabel24.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftUsuario_CrearModificarUser.add(jLabel24, java.awt.BorderLayout.CENTER);

        jtfsub_Usuario.add(jleftUsuario_CrearModificarUser);

        jleftUsuario_AdministrarRol.setBackground(new java.awt.Color(73, 20, 100));
        jleftUsuario_AdministrarRol.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario_AdministrarRol.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRolMouseMoved(evt);
            }
        });
        jleftUsuario_AdministrarRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRolMouseExited(evt);
            }
        });
        jleftUsuario_AdministrarRol.setLayout(new java.awt.BorderLayout());

        jLabel25.setBackground(new java.awt.Color(153, 0, 153));
        jLabel25.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Modificar Usuario");
        jLabel25.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftUsuario_AdministrarRol.add(jLabel25, java.awt.BorderLayout.CENTER);

        jtfsub_Usuario.add(jleftUsuario_AdministrarRol);

        left.add(jtfsub_Usuario);

        jlefProveedorYfabrecante.setBackground(new java.awt.Color(73, 20, 119));
        jlefProveedorYfabrecante.setPreferredSize(new java.awt.Dimension(300, 32));
        jlefProveedorYfabrecante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlefProveedorYfabrecanteMouseMoved(evt);
            }
        });
        jlefProveedorYfabrecante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlefProveedorYfabrecanteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlefProveedorYfabrecanteMouseExited(evt);
            }
        });
        jlefProveedorYfabrecante.setLayout(new java.awt.BorderLayout());

        jLabel26.setBackground(new java.awt.Color(153, 0, 153));
        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Proveedor y Fabricante");
        jLabel26.setPreferredSize(new java.awt.Dimension(200, 50));
        jlefProveedorYfabrecante.add(jLabel26, java.awt.BorderLayout.CENTER);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jefe.png"))); // NOI18N
        jLabel27.setPreferredSize(new java.awt.Dimension(100, 14));
        jlefProveedorYfabrecante.add(jLabel27, java.awt.BorderLayout.LINE_START);

        jlblConsultasFlecha3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblConsultasFlecha3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha3.setPreferredSize(new java.awt.Dimension(50, 32));
        jlefProveedorYfabrecante.add(jlblConsultasFlecha3, java.awt.BorderLayout.LINE_END);

        left.add(jlefProveedorYfabrecante);

        jtfsub_ProveedorYfabricante.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_ProveedorYfabricante.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftUsuario_CrearModificarUser1.setBackground(new java.awt.Color(73, 20, 100));
        jleftUsuario_CrearModificarUser1.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario_CrearModificarUser1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUser1MouseMoved(evt);
            }
        });
        jleftUsuario_CrearModificarUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUser1MouseExited(evt);
            }
        });
        jleftUsuario_CrearModificarUser1.setLayout(new java.awt.BorderLayout());

        jLabel28.setBackground(new java.awt.Color(153, 0, 153));
        jLabel28.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Crear/Modicar Proveedor");
        jLabel28.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftUsuario_CrearModificarUser1.add(jLabel28, java.awt.BorderLayout.CENTER);

        jtfsub_ProveedorYfabricante.add(jleftUsuario_CrearModificarUser1);

        jleftUsuario_AdministrarRol1.setBackground(new java.awt.Color(73, 20, 100));
        jleftUsuario_AdministrarRol1.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario_AdministrarRol1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRol1MouseMoved(evt);
            }
        });
        jleftUsuario_AdministrarRol1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRol1MouseExited(evt);
            }
        });
        jleftUsuario_AdministrarRol1.setLayout(new java.awt.BorderLayout());

        jLabel29.setBackground(new java.awt.Color(153, 0, 153));
        jLabel29.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Crear/Modicar Fabricante");
        jLabel29.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftUsuario_AdministrarRol1.add(jLabel29, java.awt.BorderLayout.CENTER);

        jtfsub_ProveedorYfabricante.add(jleftUsuario_AdministrarRol1);

        left.add(jtfsub_ProveedorYfabricante);

        contenedorPrincipal.add(left, java.awt.BorderLayout.LINE_START);

        bodyContenedor.setBackground(new java.awt.Color(255, 0, 255));
        bodyContenedor.setPreferredSize(new java.awt.Dimension(0, 0));
        bodyContenedor.setLayout(new java.awt.BorderLayout());
        contenedorPrincipal.add(bodyContenedor, java.awt.BorderLayout.CENTER);

        getContentPane().add(contenedorPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jleftServicioFarmaciaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseMoved
        jleftServicioFarmacia.setBackground(colorMoved);
        
    }//GEN-LAST:event_jleftServicioFarmaciaMouseMoved

    private void jleftServicioFarmaciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseExited
        jleftServicioFarmacia.setBackground(colorExit);
        

    }//GEN-LAST:event_jleftServicioFarmaciaMouseExited

    private void jleftInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseMoved
        jleftInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventarioMouseMoved

    private void jleftInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseExited
        jleftInventario.setBackground(colorExit);
    }//GEN-LAST:event_jleftInventarioMouseExited

    private void jleftEstudianteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseMoved
        jleftEstudiante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudianteMouseMoved

    private void jleftEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseExited
        jleftEstudiante.setBackground(colorExit);
    }//GEN-LAST:event_jleftEstudianteMouseExited

    private void jleftInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseClicked
       
      
      if(jtfsub_inventario.isShowing()){
      jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_inventario.setVisible(false);
      }
      else{
          jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_inventario.setVisible(true);

      }
       
        
    }//GEN-LAST:event_jleftInventarioMouseClicked

    private void jleftServicioFarmaciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseClicked
        bodyContenedor.setVisible(true);
        
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objAgregarMedi.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(true);       
        objOperacionesMedicamento.setVisible(false);
       
        
                
    }//GEN-LAST:event_jleftServicioFarmaciaMouseClicked

    private void jleftEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseClicked
        
        if(jtfsub_Estudiante.isShowing()){
            jtfsub_Estudiante.setVisible(false);
        }  
        else{
            jtfsub_Estudiante.setVisible(true);
        }
        
    }//GEN-LAST:event_jleftEstudianteMouseClicked

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
        jleftConsultas.setBackground(colorExit);
    }//GEN-LAST:event_jleftConsultasMouseExited

    private void jleftConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseClicked
        bodyContenedor.setVisible(true);
        
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objAgregarMedi.setVisible(false);        
        objBusquedaVentas.setVisible(true);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(true); 
        objOperacionesMedicamento.setVisible(false);
        
        if(jtfsub_Consultas.isShowing()){
      jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_Consultas.setVisible(false);
      }
      else{
          jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_Consultas.setVisible(true);}
    }//GEN-LAST:event_jleftConsultasMouseClicked

    private void jleftConsultasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseMoved
        jleftConsultas.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultasMouseMoved

    private void jleftInventario_llenarInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseMoved
        jleftInventario_llenarInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseMoved

    private void jleftInventario_llenarInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseExited
        jleftInventario_llenarInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseExited

    private void jleftInventario_detalleInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseMoved
        jleftInventario_detalleInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseMoved

    private void jleftInventario_detalleInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseExited
        jleftInventario_detalleInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseExited

    private void jleftConsultas_EntregadeldiaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseMoved
        jleftConsultas_Entregadeldia.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseMoved

    private void jleftConsultas_EntregadeldiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseExited
        jleftConsultas_Entregadeldia.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseExited

    private void jleftConsultas_ReportedelMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseMoved
        jleftConsultas_ReportedelMes.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseMoved

    private void jleftConsultas_ReportedelMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseExited
        jleftConsultas_ReportedelMes.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseExited

    private void jleftMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseMoved
        jleftMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicamentoMouseMoved

    private void jleftMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseClicked
 
        if(jtfsub_Medicina.isShowing()){
            jtfsub_Medicina.setVisible(false);
            }        
        else{
            jtfsub_Medicina.setVisible(true);
        }
    }//GEN-LAST:event_jleftMedicamentoMouseClicked

    private void jleftMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseExited
        jleftMedicamento.setBackground(colorExit);
    }//GEN-LAST:event_jleftMedicamentoMouseExited

    private void jleftInventario_llenarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseClicked
      bodyContenedor.setVisible(true);             
      objVer_inventario.setVisible(false);
      objDetalle_Inventario.setVisible(false);
      objAgregarMedi.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false);
      objOperacionesMedicamento.setVisible(false);
      objLlenarInventario.ConsultaBD();
      objLlenarInventario.principalEjecucion();
      objLlenarInventario.setVisible(true);
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseClicked

    private void jleftInventario_detalleInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseClicked
      bodyContenedor.setVisible(true); 
            
      objVer_inventario.setVisible(false);
      objLlenarInventario.setVisible(false);
      objDetalle_Inventario.setVisible(true);
      objAgregarMedi.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false);
      objOperacionesMedicamento.setVisible(false);
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseClicked

    private void jleftEstudiante_CrearModificarEstudianteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseMoved
        jleftEstudiante_CrearModificarEstudiante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseMoved

    private void jleftEstudiante_CrearModificarEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseExited
        jleftEstudiante_CrearModificarEstudiante.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseExited

    private void jleftEstudiante_InformacionEstudianteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_InformacionEstudianteMouseMoved
        jleftEstudiante_InformacionEstudiante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudiante_InformacionEstudianteMouseMoved

    private void jleftEstudiante_InformacionEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_InformacionEstudianteMouseExited
        jleftEstudiante_InformacionEstudiante.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftEstudiante_InformacionEstudianteMouseExited

    private void jleftMedicina_CrearModificarMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearModificarMedicamentoMouseMoved
        jleftMedicina_CrearModificarMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicina_CrearModificarMedicamentoMouseMoved

    private void jleftMedicina_CrearModificarMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearModificarMedicamentoMouseExited
        jleftMedicina_CrearModificarMedicamento.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftMedicina_CrearModificarMedicamentoMouseExited

    private void jleftConsultas_MedicamentoUsadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_MedicamentoUsadoMouseMoved
        jleftConsultas_MedicamentoUsado.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_MedicamentoUsadoMouseMoved

    private void jleftConsultas_MedicamentoUsadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_MedicamentoUsadoMouseExited
        jleftConsultas_MedicamentoUsado.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_MedicamentoUsadoMouseExited

    private void jleftInventario_verInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_verInventarioMouseMoved
        jleftInventario_verInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_verInventarioMouseMoved

    private void jleftInventario_verInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_verInventarioMouseClicked
        bodyContenedor.setVisible(true);
        
        objDetalle_Inventario.setVisible(false);
        objAgregarMedi.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false); 
        objOperacionesMedicamento.setVisible(false);
        objVer_inventario.ConsultaBD();
        objVer_inventario.principalEjecucion();
        objVer_inventario.setVisible(true);
    }//GEN-LAST:event_jleftInventario_verInventarioMouseClicked

    private void jleftInventario_verInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_verInventarioMouseExited

        jleftInventario_verInventario.setBackground(colorExitSub);        
    }//GEN-LAST:event_jleftInventario_verInventarioMouseExited

    private void jleftUsuarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuarioMouseMoved
        jleftUsuario.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftUsuarioMouseMoved

    private void jleftUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuarioMouseClicked
        
        if(jtfsub_Usuario.isShowing()){
            jtfsub_Usuario.setVisible(false);
        }
        else{
            jtfsub_Usuario.setVisible(true);
        }
    }//GEN-LAST:event_jleftUsuarioMouseClicked

    private void jleftUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuarioMouseExited
        jleftUsuario.setBackground(colorExit);
        
    }//GEN-LAST:event_jleftUsuarioMouseExited

    private void jleftUsuario_CrearModificarUserMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUserMouseMoved
        jleftUsuario_CrearModificarUser.setBackground(colorMoved);
    }//GEN-LAST:event_jleftUsuario_CrearModificarUserMouseMoved

    private void jleftUsuario_CrearModificarUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUserMouseExited
        jleftUsuario_CrearModificarUser.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftUsuario_CrearModificarUserMouseExited

    private void jleftUsuario_AdministrarRolMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRolMouseMoved
        jleftUsuario_AdministrarRol.setBackground(colorMoved);
    }//GEN-LAST:event_jleftUsuario_AdministrarRolMouseMoved

    private void jleftUsuario_AdministrarRolMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRolMouseExited
        jleftUsuario_AdministrarRol.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftUsuario_AdministrarRolMouseExited

    private void jlefProveedorYfabrecanteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlefProveedorYfabrecanteMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jlefProveedorYfabrecanteMouseMoved

    private void jlefProveedorYfabrecanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlefProveedorYfabrecanteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlefProveedorYfabrecanteMouseClicked

    private void jlefProveedorYfabrecanteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlefProveedorYfabrecanteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jlefProveedorYfabrecanteMouseExited

    private void jleftUsuario_CrearModificarUser1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUser1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jleftUsuario_CrearModificarUser1MouseMoved

    private void jleftUsuario_CrearModificarUser1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUser1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jleftUsuario_CrearModificarUser1MouseExited

    private void jleftUsuario_AdministrarRol1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRol1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jleftUsuario_AdministrarRol1MouseMoved

    private void jleftUsuario_AdministrarRol1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRol1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jleftUsuario_AdministrarRol1MouseExited

    private void jleftMedicina_CrearModificarMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearModificarMedicamentoMouseClicked
        bodyContenedor.setVisible(true);        
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objAgregarMedi.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objOperacionesMedicamento.setVisible(true);
    }//GEN-LAST:event_jleftMedicina_CrearModificarMedicamentoMouseClicked

    public Usuario getUsuario(){
        return user;
    } 
    

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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlblConsultasFlecha;
    private javax.swing.JLabel jlblConsultasFlecha1;
    private javax.swing.JLabel jlblConsultasFlecha2;
    private javax.swing.JLabel jlblConsultasFlecha3;
    private javax.swing.JLabel jlblEstudianteFlecha1;
    private javax.swing.JLabel jlblInventarioFlecha;
    private javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblNavegacion;
    private javax.swing.JLabel jlblSalir;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPanel jlefProveedorYfabrecante;
    private javax.swing.JPanel jleftConsultas;
    private javax.swing.JPanel jleftConsultas_Entregadeldia;
    private javax.swing.JPanel jleftConsultas_MedicamentoUsado;
    private javax.swing.JPanel jleftConsultas_ReportedelMes;
    private javax.swing.JPanel jleftEstudiante;
    private javax.swing.JPanel jleftEstudiante_CrearModificarEstudiante;
    private javax.swing.JPanel jleftEstudiante_InformacionEstudiante;
    private javax.swing.JPanel jleftInventario;
    private javax.swing.JPanel jleftInventario_detalleInventario;
    private javax.swing.JPanel jleftInventario_llenarInventario;
    private javax.swing.JPanel jleftInventario_verInventario;
    private javax.swing.JPanel jleftMedicamento;
    private javax.swing.JPanel jleftMedicina_CrearModificarMedicamento;
    private javax.swing.JPanel jleftServicioFarmacia;
    private javax.swing.JPanel jleftUsuario;
    private javax.swing.JPanel jleftUsuario_AdministrarRol;
    private javax.swing.JPanel jleftUsuario_AdministrarRol1;
    private javax.swing.JPanel jleftUsuario_CrearModificarUser;
    private javax.swing.JPanel jleftUsuario_CrearModificarUser1;
    private javax.swing.JPanel jtfsub_Consultas;
    private javax.swing.JPanel jtfsub_Estudiante;
    private javax.swing.JPanel jtfsub_Medicina;
    private javax.swing.JPanel jtfsub_ProveedorYfabricante;
    private javax.swing.JPanel jtfsub_Usuario;
    private javax.swing.JPanel jtfsub_inventario;
    private javax.swing.JPanel left;
    // End of variables declaration//GEN-END:variables
}
