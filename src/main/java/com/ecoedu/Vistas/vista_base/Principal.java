/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas.vista_base;
import com.ecoedu.Vistas.Consultas.Entrega_del_dia;
import com.ecoedu.Vistas.Consultas.Reporte_Condicion;
import com.ecoedu.Vistas.Consultas.Reporte_Diagnostico;
import com.ecoedu.Vistas.Estudiante.Crear_Estudiante;
import com.ecoedu.Vistas.Estudiante.Modificar_Estudiante;
import com.ecoedu.Vistas.Consultas.Reporte_Por_Escuela;
import com.ecoedu.Vistas.Inventario.Abrir_Inventario;
import com.ecoedu.Vistas.Inventario.Detalle_Inventario;
import com.ecoedu.Vistas.Inventario.LlenarInventario;
import com.ecoedu.Vistas.Inventario.Ver_inventario;
import com.ecoedu.Vistas.Medicamento.CrearMedicamento;
import com.ecoedu.Vistas.Medicamento.ModificarMedicamento;
import com.ecoedu.Vistas.ProveedorFabricante.ProveedorLaboratorio;
import com.ecoedu.Vistas.ServicioAsistencial.Servicio_Asistencial;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.Vistas.Usuario.CrearUsuario;
import com.ecoedu.Vistas.Usuario.ModificarUsuario;
import com.ecoedu.model.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.dom4j.DocumentException;


/**
 *
 * @author yrma
 */
public class Principal extends javax.swing.JFrame {
    
   
   EntityManager jpa;
   private Usuario user;
   private ServicioFarmacia objServicioFarmacia;
   private Entrega_del_dia objBusquedaVentas;
   private Detalle_Inventario objDetalle_Inventario;
   private LlenarInventario objLlenarInventario;
   private Ver_inventario objVer_inventario;
   private CrearMedicamento objCrearMedicamento;
   private CrearUsuario objCrearUsuario;
   private ModificarUsuario objModificarUsuario;
   private Crear_Estudiante objCrear_Estudiante;
   private Entrega_del_dia objEntragEntrega_del_dia;
   private Modificar_Estudiante objModificar_Estudiante;
   private Reporte_Por_Escuela objReporte_Por_Escuela;
   private Reporte_Diagnostico objReporte_Diagnostico;
   private ProveedorLaboratorio objProveedorLaboratorio;
   private ModificarMedicamento objModificarMedicamento;
   private Reporte_Condicion objReporte_Condicion;
   private Servicio_Asistencial objServicio_Asistencial;
   private Abrir_Inventario objAbrir_Inventario;
   
   
   private Color colorMoved=new Color(4,20,25);
   private Color colorExitSub=new Color(73,20,100);
   private Color colorExit=new Color(73,25,119);
   public Principal(EntityManager OBJjpa,Usuario OBJuser){
       initComponents();
       File objFile=new File("Carpeta_de_Archivos");
        if (!objFile.exists()){
            if (objFile.mkdirs()) {
                JOptionPane.showMessageDialog(jLabel12, "Parece que borraron la Carpeta, Volviendo a Crear, Pero no se Recuperará los Archivos");
            } else {
                JOptionPane.showMessageDialog(jLabel12, "Error al crear Directorio");
            }
        }
        
        
       this.jpa=OBJjpa;
       this.user=OBJuser;
       this.objServicio_Asistencial=new Servicio_Asistencial(jpa, this, OBJuser);
       this.objProveedorLaboratorio=new ProveedorLaboratorio(OBJjpa, this);
       this.objReporte_Diagnostico=new Reporte_Diagnostico(OBJjpa, this);
       this.objEntragEntrega_del_dia=new Entrega_del_dia(OBJjpa);
       this.objCrearMedicamento=new CrearMedicamento(OBJjpa, this);
       this.objServicioFarmacia=new ServicioFarmacia(OBJjpa,this,user);
       this.objBusquedaVentas=new Entrega_del_dia(OBJjpa);
       this.objLlenarInventario=new LlenarInventario(OBJjpa, this);
       this.objDetalle_Inventario=new Detalle_Inventario(OBJjpa,this);
       this.objVer_inventario=new Ver_inventario(OBJjpa, this);
       this.objCrearUsuario=new CrearUsuario(OBJjpa, this);
       this.objModificarUsuario=new ModificarUsuario(OBJjpa, this);
       this.objCrear_Estudiante=new Crear_Estudiante(OBJjpa, this);
       this.objModificar_Estudiante=new Modificar_Estudiante(OBJjpa, this);
       this.objReporte_Por_Escuela=new Reporte_Por_Escuela(OBJjpa, this);
       this.objModificarMedicamento=new ModificarMedicamento(OBJjpa, this);
       this.objReporte_Condicion=new Reporte_Condicion(jpa, this);
       this.objAbrir_Inventario=new Abrir_Inventario(jpa, this, OBJuser);
       this.setLocationRelativeTo(null);
       jlblUsuario.setText(user.getPersona().getInfoPersona());
       bodyContenedor.add(objBusquedaVentas);//1  
       bodyContenedor.validate();
       bodyContenedor.add(objServicioFarmacia);//2  
       bodyContenedor.validate();
       bodyContenedor.add(objCrear_Estudiante);//3
       bodyContenedor.validate();
       bodyContenedor.add(objDetalle_Inventario);//4
       bodyContenedor.validate();
       bodyContenedor.add(objLlenarInventario);//5
       bodyContenedor.validate();
       bodyContenedor.add(objVer_inventario);//6
       bodyContenedor.validate();
       bodyContenedor.add(objCrearMedicamento);//7
       bodyContenedor.validate();
       bodyContenedor.add(objCrearUsuario);//8
       bodyContenedor.validate();
       bodyContenedor.add(objModificarUsuario);//9
       bodyContenedor.validate();
       bodyContenedor.add(objEntragEntrega_del_dia);//10
       bodyContenedor.validate();
       bodyContenedor.add(objModificar_Estudiante);//11
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Por_Escuela);//12
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Diagnostico);//13
       bodyContenedor.validate();
       bodyContenedor.add(objProveedorLaboratorio);//14
       bodyContenedor.validate();
       bodyContenedor.add(objModificarMedicamento);//15
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Condicion);//16
       bodyContenedor.validate();
       bodyContenedor.add(objServicio_Asistencial);//17
       bodyContenedor.validate();
       bodyContenedor.add(objAbrir_Inventario);
       bodyContenedor.validate();
       
       
       setIconImage(new ImageIcon(getClass().getResource("/images/014-pharmacy.png")).getImage());
       if(!OBJuser.getRol().getNombre_rol().equals("ADMINISTRADOR")){
           jleftMedicamento.setVisible(false);
           jleftEstudiante.setVisible(false);
           jleftConsultas.setVisible(false);
           jleftUsuario.setVisible(false);
           jleftProveedorYfabricante.setVisible(false);
           jleftInventario_llenarInventario.setVisible(false);
           jleftInventario_detalleInventario.setVisible(false);   
           jtfsub_inventario.setPreferredSize(new Dimension(300, 41)); 
           
           }
       if(OBJuser.getRol().getNombre_rol().equals("ASISTENCIAL")){
           setIconImage(new ImageIcon(getClass().getResource("/images/informacion.png")).getImage());
           jlblRolcito.setText("Trabajadora Social:");
           jleftServicioFarmacia.setVisible(false);
           jleftMedicamento.setVisible(false);
           jleftEstudiante.setVisible(false);
           jleftConsultas.setVisible(false);
           jleftUsuario.setVisible(false);
           jleftInventario.setVisible(false);
           jleftProveedorYfabricante.setVisible(false);
           jleftInventario_llenarInventario.setVisible(false);
           jleftInventario_detalleInventario.setVisible(false);   
       }
       else{
           jleftServicioAsistencial.setVisible(false);
       }
       bodyContenedor.setVisible(false);
       jtfsub_Usuario.setVisible(false);
       jtfsub_inventario.setVisible(false);
       jtfsub_Consultas.setVisible(false);    
       jtfsub_Medicina.setVisible(false);
       jtfsub_Estudiante.setVisible(false);
       }
   @SuppressWarnings("unchecked")
   public void actualizar_Usuario(Usuario objUser){
       if(user==objUser){
           jlblUsuario.setText(objUser.getPersona().getInfoPersona());
           }
       }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlblRolcito = new javax.swing.JLabel();
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
        jleftInventario_AbrirInventario = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jleftInventario_CerrarInventario = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jleftInventario_detalleInventario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jleftMedicamento = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlblConsultasFlecha1 = new javax.swing.JLabel();
        jtfsub_Medicina = new javax.swing.JPanel();
        jleftMedicina_CrearMedicamento = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jleftMedicina_ModificarMedicamento = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jleftConsultas_MedicamentoUsado = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jleftEstudiante = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblEstudianteFlecha1 = new javax.swing.JLabel();
        jtfsub_Estudiante = new javax.swing.JPanel();
        jleftEstudiante_CrearModificarEstudiante = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jleftEstudiante_Modificar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jleftConsultas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblConsultasFlecha = new javax.swing.JLabel();
        jtfsub_Consultas = new javax.swing.JPanel();
        jleftConsultas_Entregadeldia = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jleftConsultas_ReportePorEscuela = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jleftConsultas_ReportedelMes = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jleftConsultas_Reporte_Condicion = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jleftUsuario = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblConsultasFlecha2 = new javax.swing.JLabel();
        jtfsub_Usuario = new javax.swing.JPanel();
        jleftUsuario_CrearModificarUser = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jleftUsuario_AdministrarRol = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jleftProveedorYfabricante = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jleftServicioAsistencial = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
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

        jlblRolcito.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblRolcito.setText("Química(o) Farmacéutica(o):");
        jlblRolcito.setMaximumSize(new java.awt.Dimension(990, 14));
        jlblRolcito.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel4.add(jlblRolcito, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, -1, -1));

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
        jlblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSalirMouseClicked(evt);
            }
        });
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
        jlblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizarMouseClicked(evt);
            }
        });
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
        jtfsub_inventario.setPreferredSize(new java.awt.Dimension(300, 200));

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

        jleftInventario_AbrirInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_AbrirInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_AbrirInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_AbrirInventarioMouseMoved(evt);
            }
        });
        jleftInventario_AbrirInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_AbrirInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_AbrirInventarioMouseExited(evt);
            }
        });
        jleftInventario_AbrirInventario.setLayout(new java.awt.BorderLayout());

        jLabel33.setBackground(new java.awt.Color(153, 0, 153));
        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Abrir Inventario");
        jLabel33.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_AbrirInventario.add(jLabel33, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_AbrirInventario);

        jleftInventario_CerrarInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_CerrarInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_CerrarInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_CerrarInventarioMouseMoved(evt);
            }
        });
        jleftInventario_CerrarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_CerrarInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_CerrarInventarioMouseExited(evt);
            }
        });
        jleftInventario_CerrarInventario.setLayout(new java.awt.BorderLayout());

        jLabel34.setBackground(new java.awt.Color(153, 0, 153));
        jLabel34.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Cerrar Inventario");
        jLabel34.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_CerrarInventario.add(jLabel34, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_CerrarInventario);

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
        jtfsub_Medicina.setPreferredSize(new java.awt.Dimension(300, 120));
        jtfsub_Medicina.setRequestFocusEnabled(false);

        jleftMedicina_CrearMedicamento.setBackground(new java.awt.Color(73, 20, 100));
        jleftMedicina_CrearMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicina_CrearMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicina_CrearMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearMedicamentoMouseExited(evt);
            }
        });
        jleftMedicina_CrearMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel20.setBackground(new java.awt.Color(153, 0, 153));
        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Crear Medicamento");
        jLabel20.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftMedicina_CrearMedicamento.add(jLabel20, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftMedicina_CrearMedicamento);

        jleftMedicina_ModificarMedicamento.setBackground(new java.awt.Color(73, 20, 100));
        jleftMedicina_ModificarMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicina_ModificarMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicina_ModificarMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicina_ModificarMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicina_ModificarMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicina_ModificarMedicamentoMouseExited(evt);
            }
        });
        jleftMedicina_ModificarMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel28.setBackground(new java.awt.Color(153, 0, 153));
        jLabel28.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Modificar Medicamento");
        jLabel28.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftMedicina_ModificarMedicamento.add(jLabel28, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftMedicina_ModificarMedicamento);

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseExited(evt);
            }
        });
        jleftEstudiante_CrearModificarEstudiante.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(153, 0, 153));
        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Crear Estudiante");
        jLabel18.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEstudiante_CrearModificarEstudiante.add(jLabel18, java.awt.BorderLayout.CENTER);

        jtfsub_Estudiante.add(jleftEstudiante_CrearModificarEstudiante);

        jleftEstudiante_Modificar.setBackground(new java.awt.Color(73, 20, 100));
        jleftEstudiante_Modificar.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante_Modificar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudiante_ModificarMouseMoved(evt);
            }
        });
        jleftEstudiante_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEstudiante_ModificarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudiante_ModificarMouseExited(evt);
            }
        });
        jleftEstudiante_Modificar.setLayout(new java.awt.BorderLayout());

        jLabel19.setBackground(new java.awt.Color(153, 0, 153));
        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Modificar Estudiante");
        jLabel19.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEstudiante_Modificar.add(jLabel19, java.awt.BorderLayout.CENTER);

        jtfsub_Estudiante.add(jleftEstudiante_Modificar);

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
        jtfsub_Consultas.setPreferredSize(new java.awt.Dimension(300, 160));

        jleftConsultas_Entregadeldia.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Entregadeldia.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_Entregadeldia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseMoved(evt);
            }
        });
        jleftConsultas_Entregadeldia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseClicked(evt);
            }
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

        jleftConsultas_ReportePorEscuela.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_ReportePorEscuela.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_ReportePorEscuela.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaMouseMoved(evt);
            }
        });
        jleftConsultas_ReportePorEscuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaMouseExited(evt);
            }
        });
        jleftConsultas_ReportePorEscuela.setLayout(new java.awt.BorderLayout());

        jLabel30.setBackground(new java.awt.Color(153, 0, 153));
        jLabel30.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Reporte por Escuela");
        jLabel30.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_ReportePorEscuela.add(jLabel30, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_ReportePorEscuela);

        jleftConsultas_ReportedelMes.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_ReportedelMes.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_ReportedelMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseMoved(evt);
            }
        });
        jleftConsultas_ReportedelMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseExited(evt);
            }
        });
        jleftConsultas_ReportedelMes.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(153, 0, 153));
        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Reportes_Diagnostico/Procedencia");
        jLabel17.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_ReportedelMes.add(jLabel17, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_ReportedelMes);

        jleftConsultas_Reporte_Condicion.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Reporte_Condicion.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_Reporte_Condicion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_CondicionMouseMoved(evt);
            }
        });
        jleftConsultas_Reporte_Condicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_CondicionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_CondicionMouseExited(evt);
            }
        });
        jleftConsultas_Reporte_Condicion.setLayout(new java.awt.BorderLayout());

        jLabel31.setBackground(new java.awt.Color(153, 0, 153));
        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Reporte por Condicion");
        jLabel31.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_Reporte_Condicion.add(jLabel31, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_Reporte_Condicion);

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUserMouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRolMouseClicked(evt);
            }
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

        jleftProveedorYfabricante.setBackground(new java.awt.Color(73, 20, 119));
        jleftProveedorYfabricante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftProveedorYfabricante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftProveedorYfabricanteMouseMoved(evt);
            }
        });
        jleftProveedorYfabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftProveedorYfabricanteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftProveedorYfabricanteMouseExited(evt);
            }
        });
        jleftProveedorYfabricante.setLayout(new java.awt.BorderLayout());

        jLabel26.setBackground(new java.awt.Color(153, 0, 153));
        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Proveedor y Laboratorio");
        jLabel26.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftProveedorYfabricante.add(jLabel26, java.awt.BorderLayout.CENTER);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jefe.png"))); // NOI18N
        jLabel27.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftProveedorYfabricante.add(jLabel27, java.awt.BorderLayout.LINE_START);

        left.add(jleftProveedorYfabricante);

        jleftServicioAsistencial.setBackground(new java.awt.Color(73, 20, 119));
        jleftServicioAsistencial.setPreferredSize(new java.awt.Dimension(300, 33));
        jleftServicioAsistencial.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftServicioAsistencialMouseMoved(evt);
            }
        });
        jleftServicioAsistencial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftServicioAsistencialMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftServicioAsistencialMouseExited(evt);
            }
        });
        jleftServicioAsistencial.setLayout(new java.awt.BorderLayout());

        jLabel29.setBackground(new java.awt.Color(153, 0, 153));
        jLabel29.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Servicio Asistencial (110)");
        jLabel29.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftServicioAsistencial.add(jLabel29, java.awt.BorderLayout.CENTER);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/009-drug.png"))); // NOI18N
        jLabel32.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftServicioAsistencial.add(jLabel32, java.awt.BorderLayout.LINE_START);

        left.add(jleftServicioAsistencial);

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
      jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
    
       
        
    }//GEN-LAST:event_jleftInventarioMouseClicked

    private void jleftServicioFarmaciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseClicked
        bodyContenedor.setVisible(true);
        
        objVer_inventario.setVisible(false);//1
        objDetalle_Inventario.setVisible(false);//2
        objCrear_Estudiante.setVisible(false);//3   
        objBusquedaVentas.setVisible(false);//4
        objLlenarInventario.setVisible(false);//5
        objCrearUsuario.setVisible(false);//6
        objModificarUsuario.setVisible(false);//7           
        objCrearMedicamento.setVisible(false);//8        
        objEntragEntrega_del_dia.setVisible(false);//10
        objModificar_Estudiante.setVisible(false);//11
        objReporte_Por_Escuela.setVisible(false);//12
        objReporte_Diagnostico.setVisible(false);//13 
        objProveedorLaboratorio.setVisible(false);//14
        objModificarMedicamento.setVisible(false);//15
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Condicion.setVisible(false);//16
         objServicioFarmacia.ConsultaBD();
        objServicioFarmacia.principalEjecucion();
        objServicioFarmacia.setVisible(true);//9 
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblConsultasFlecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblConsultasFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        
                
    }//GEN-LAST:event_jleftServicioFarmaciaMouseClicked

    private void jleftEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseClicked
        
        if(jtfsub_Estudiante.isShowing()){
            jtfsub_Estudiante.setVisible(false);
            jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        }  
        else{
            jtfsub_Estudiante.setVisible(true);
          jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));

        }
        jtfsub_Consultas.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblConsultasFlecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblConsultasFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
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
        
        if(jtfsub_Consultas.isShowing()){
      jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_Consultas.setVisible(false);
      }
      else{
          jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_Consultas.setVisible(true);}
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        
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
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
    }//GEN-LAST:event_jleftMedicamentoMouseClicked

    private void jleftMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseExited
        jleftMedicamento.setBackground(colorExit);
    }//GEN-LAST:event_jleftMedicamentoMouseExited

    private void jleftInventario_llenarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseClicked
      bodyContenedor.setVisible(true);   
      objModificarMedicamento.setVisible(false);//15
      objProveedorLaboratorio.setVisible(false);//14
      objVer_inventario.setVisible(false);
      objDetalle_Inventario.setVisible(false);
      objCrear_Estudiante.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false);
      objCrearMedicamento.setVisible(false);
      objCrearUsuario.setVisible(false);
      objModificarUsuario.setVisible(false);
      objEntragEntrega_del_dia.setVisible(false);
      objModificar_Estudiante.setVisible(false);
      objReporte_Por_Escuela.setVisible(false);
      objReporte_Diagnostico.setVisible(false);
      objServicio_Asistencial.setVisible(false);//17
      objReporte_Condicion.setVisible(false);//16
      objAbrir_Inventario.setVisible(false);//18
      objLlenarInventario.ConsultaBD();
      //objLlenarInventario.principalEjecucion();(acondicionado con apertura/cierre inventario
      objLlenarInventario.setVisible(true);
      
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseClicked

    private void jleftInventario_detalleInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseClicked
      bodyContenedor.setVisible(true);
      
      objReporte_Condicion.setVisible(false);//16
      objModificarMedicamento.setVisible(false);//15
      objProveedorLaboratorio.setVisible(false);//14
      objVer_inventario.setVisible(false);
      objLlenarInventario.setVisible(false);
      objCrearUsuario.setVisible(false);
      objServicio_Asistencial.setVisible(false);//17
      objAbrir_Inventario.setVisible(false);//18
      objDetalle_Inventario.setVisible(true);
      objCrear_Estudiante.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false);
      objCrearMedicamento.setVisible(false);
      objModificarUsuario.setVisible(false);
      objEntragEntrega_del_dia.setVisible(false);
      objModificar_Estudiante.setVisible(false);
      objReporte_Por_Escuela.setVisible(false);      
      objReporte_Diagnostico.setVisible(false);
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseClicked

    private void jleftEstudiante_CrearModificarEstudianteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseMoved
        jleftEstudiante_CrearModificarEstudiante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseMoved

    private void jleftEstudiante_CrearModificarEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseExited
        jleftEstudiante_CrearModificarEstudiante.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseExited

    private void jleftEstudiante_ModificarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_ModificarMouseMoved
        jleftEstudiante_Modificar.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudiante_ModificarMouseMoved

    private void jleftEstudiante_ModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_ModificarMouseExited
        jleftEstudiante_Modificar.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftEstudiante_ModificarMouseExited

    private void jleftMedicina_CrearMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearMedicamentoMouseMoved
        jleftMedicina_CrearMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicina_CrearMedicamentoMouseMoved

    private void jleftMedicina_CrearMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearMedicamentoMouseExited
        jleftMedicina_CrearMedicamento.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftMedicina_CrearMedicamentoMouseExited

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
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14        
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false); 
        objCrearMedicamento.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
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
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_inventario.setVisible(false);
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

    private void jleftProveedorYfabricanteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftProveedorYfabricanteMouseMoved
        jleftProveedorYfabricante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftProveedorYfabricanteMouseMoved

    private void jleftProveedorYfabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftProveedorYfabricanteMouseClicked
        bodyContenedor.setVisible(true);

        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objVer_inventario.setVisible(false);//1
        objDetalle_Inventario.setVisible(false);//2
        objCrear_Estudiante.setVisible(false);//3   
        objBusquedaVentas.setVisible(false);//4
        objLlenarInventario.setVisible(false);//5
        objCrearUsuario.setVisible(false);//6
        objModificarUsuario.setVisible(false);//7           
        objCrearMedicamento.setVisible(false);//8        
        objEntragEntrega_del_dia.setVisible(false);//10
        objModificar_Estudiante.setVisible(false);//11
        objReporte_Por_Escuela.setVisible(false);//12
        objReporte_Diagnostico.setVisible(false);//13 
        objServicioFarmacia.setVisible(false);//9
        objProveedorLaboratorio.setVisible(true);//14
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objProveedorLaboratorio.ConsultaBD();
        objProveedorLaboratorio.principalEjecucion();
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        
    }//GEN-LAST:event_jleftProveedorYfabricanteMouseClicked

    private void jleftProveedorYfabricanteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftProveedorYfabricanteMouseExited
        jleftProveedorYfabricante.setBackground(colorExit);
    }//GEN-LAST:event_jleftProveedorYfabricanteMouseExited

    private void jleftMedicina_CrearMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearMedicamentoMouseClicked
        bodyContenedor.setVisible(true);  
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCrearMedicamento.setVisible(true);
        objCrearMedicamento.ConsultaBD();
        objCrearMedicamento.principalEjecucion();
        
        
    }//GEN-LAST:event_jleftMedicina_CrearMedicamentoMouseClicked

    private void jleftUsuario_CrearModificarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUserMouseClicked
        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);       
        objCrearMedicamento.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCrearUsuario.ConsultaBD();
        objCrearUsuario.principalEjecucion();
        objCrearUsuario.setVisible(true);
        
    }//GEN-LAST:event_jleftUsuario_CrearModificarUserMouseClicked

    private void jleftUsuario_AdministrarRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRolMouseClicked
        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objServicioFarmacia.setVisible(false);       
        objCrearMedicamento.setVisible(false);
        objModificarUsuario.setVisible(true);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objModificarUsuario.ConsultaBD();
        objModificarUsuario.principalEjecucion();
        
        
    }//GEN-LAST:event_jleftUsuario_AdministrarRolMouseClicked

    private void jleftEstudiante_CrearModificarEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseClicked
        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);             
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objServicioFarmacia.setVisible(false);       
        objCrearMedicamento.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCrear_Estudiante.setVisible(true); 
        objCrear_Estudiante.ConsultaBD();
        objCrear_Estudiante.principalEjecucion();
        
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseClicked

    private void jleftConsultas_EntregadeldiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseClicked
        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objModificar_Estudiante.setVisible(false);
        objEntragEntrega_del_dia.ConsultaBD();
        objEntragEntrega_del_dia.principalEjecucion();
        objEntragEntrega_del_dia.setVisible(true);
       
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseClicked

    private void jleftEstudiante_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_ModificarMouseClicked
        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objEntragEntrega_del_dia.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objModificar_Estudiante.ConsultaBD();
        objModificar_Estudiante.principalEjecucion();
        objModificar_Estudiante.setVisible(true);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
    }//GEN-LAST:event_jleftEstudiante_ModificarMouseClicked

    private void jleftConsultas_ReportePorEscuelaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaMouseMoved
        jleftConsultas_ReportePorEscuela.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaMouseMoved

    private void jleftConsultas_ReportePorEscuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaMouseClicked
        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Por_Escuela.ConsultaBD();
       try {
           objReporte_Por_Escuela.principalEjecucion();
       } catch (DocumentException | IOException ex) {
           Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       }
       objReporte_Diagnostico.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(true);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaMouseClicked

    private void jleftConsultas_ReportePorEscuelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaMouseExited
       
        jleftConsultas_ReportePorEscuela.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaMouseExited

    private void jleftConsultas_ReportedelMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseClicked

        bodyContenedor.setVisible(true);
        
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(true);
        
 
//Poner por acumulado, Diagnostico y con rango de fechas();
        
        
        
        
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseClicked

    private void jlblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jlblMinimizarMouseClicked

    private void jlblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jlblSalirMouseClicked

    private void jleftMedicina_ModificarMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_ModificarMedicamentoMouseMoved
        jleftMedicina_ModificarMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicina_ModificarMedicamentoMouseMoved

    private void jleftMedicina_ModificarMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_ModificarMedicamentoMouseClicked
        bodyContenedor.setVisible(true);  
        
        objReporte_Condicion.setVisible(false);//16
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objModificarMedicamento.setVisible(true);//15
        
        objModificarMedicamento.ConsultaBD();
        objModificarMedicamento.principalEjecucion();
    }//GEN-LAST:event_jleftMedicina_ModificarMedicamentoMouseClicked

    private void jleftMedicina_ModificarMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_ModificarMedicamentoMouseExited
        jleftMedicina_ModificarMedicamento.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftMedicina_ModificarMedicamentoMouseExited

    private void jleftConsultas_Reporte_CondicionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_CondicionMouseMoved
        jleftConsultas_Reporte_Condicion.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_Reporte_CondicionMouseMoved

    private void jleftConsultas_Reporte_CondicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_CondicionMouseClicked
       try {
           bodyContenedor.setVisible(true);           
           objProveedorLaboratorio.setVisible(false);//14
           objVer_inventario.setVisible(false);
           objDetalle_Inventario.setVisible(false);
           objCrear_Estudiante.setVisible(false);
           objBusquedaVentas.setVisible(false);
           objLlenarInventario.setVisible(false);
           objServicioFarmacia.setVisible(false);
           objCrearUsuario.setVisible(false);
           objModificarUsuario.setVisible(false);
           objEntragEntrega_del_dia.setVisible(false);
           objModificar_Estudiante.setVisible(false);
           objReporte_Por_Escuela.setVisible(false);
           objReporte_Diagnostico.setVisible(false);
           objCrearMedicamento.setVisible(false);
           objServicio_Asistencial.setVisible(false);//17
           objAbrir_Inventario.setVisible(false);//18
           objModificarMedicamento.setVisible(false);//15
           objReporte_Condicion.ConsultaBD();
           objReporte_Condicion.principalEjecucion();
           objReporte_Condicion.setVisible(true);//16
       } catch (DocumentException | IOException ex) {
           Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jleftConsultas_Reporte_CondicionMouseClicked

    private void jleftConsultas_Reporte_CondicionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_CondicionMouseExited
        jleftConsultas_Reporte_Condicion.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_Reporte_CondicionMouseExited

    private void jleftServicioAsistencialMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioAsistencialMouseMoved
        jleftServicioAsistencial.setBackground(colorMoved);
    }//GEN-LAST:event_jleftServicioAsistencialMouseMoved

    private void jleftServicioAsistencialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioAsistencialMouseClicked
       
        bodyContenedor.setVisible(true);           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16
        objAbrir_Inventario.setVisible(false);//18
        objServicio_Asistencial.ConsultaBD();
        objServicio_Asistencial.principalEjecucion();
        objServicio_Asistencial.setVisible(true);//17           
    }//GEN-LAST:event_jleftServicioAsistencialMouseClicked

    private void jleftServicioAsistencialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioAsistencialMouseExited
        jleftServicioAsistencial.setBackground(colorExit);
    }//GEN-LAST:event_jleftServicioAsistencialMouseExited

    private void jleftInventario_AbrirInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_AbrirInventarioMouseMoved
        jleftInventario_AbrirInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_AbrirInventarioMouseMoved

    private void jleftInventario_AbrirInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_AbrirInventarioMouseClicked
        bodyContenedor.setVisible(true);           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.ConsultaBD();
        objAbrir_Inventario.principalEjecucion();
        objAbrir_Inventario.setVisible(true);//18 
    }//GEN-LAST:event_jleftInventario_AbrirInventarioMouseClicked

    private void jleftInventario_AbrirInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_AbrirInventarioMouseExited
        jleftInventario_AbrirInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_AbrirInventarioMouseExited

    private void jleftInventario_CerrarInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_CerrarInventarioMouseMoved
        jleftInventario_CerrarInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_CerrarInventarioMouseMoved

    private void jleftInventario_CerrarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_CerrarInventarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jleftInventario_CerrarInventarioMouseClicked

    private void jleftInventario_CerrarInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_CerrarInventarioMouseExited
         jleftInventario_CerrarInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_CerrarInventarioMouseExited

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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jlblEstudianteFlecha1;
    private javax.swing.JLabel jlblInventarioFlecha;
    private javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblNavegacion;
    private javax.swing.JLabel jlblRolcito;
    private javax.swing.JLabel jlblSalir;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPanel jleftConsultas;
    private javax.swing.JPanel jleftConsultas_Entregadeldia;
    private javax.swing.JPanel jleftConsultas_MedicamentoUsado;
    private javax.swing.JPanel jleftConsultas_ReportePorEscuela;
    private javax.swing.JPanel jleftConsultas_Reporte_Condicion;
    private javax.swing.JPanel jleftConsultas_ReportedelMes;
    private javax.swing.JPanel jleftEstudiante;
    private javax.swing.JPanel jleftEstudiante_CrearModificarEstudiante;
    private javax.swing.JPanel jleftEstudiante_Modificar;
    private javax.swing.JPanel jleftInventario;
    private javax.swing.JPanel jleftInventario_AbrirInventario;
    private javax.swing.JPanel jleftInventario_CerrarInventario;
    private javax.swing.JPanel jleftInventario_detalleInventario;
    private javax.swing.JPanel jleftInventario_llenarInventario;
    private javax.swing.JPanel jleftInventario_verInventario;
    private javax.swing.JPanel jleftMedicamento;
    private javax.swing.JPanel jleftMedicina_CrearMedicamento;
    private javax.swing.JPanel jleftMedicina_ModificarMedicamento;
    private javax.swing.JPanel jleftProveedorYfabricante;
    private javax.swing.JPanel jleftServicioAsistencial;
    private javax.swing.JPanel jleftServicioFarmacia;
    private javax.swing.JPanel jleftUsuario;
    private javax.swing.JPanel jleftUsuario_AdministrarRol;
    private javax.swing.JPanel jleftUsuario_CrearModificarUser;
    private javax.swing.JPanel jtfsub_Consultas;
    private javax.swing.JPanel jtfsub_Estudiante;
    private javax.swing.JPanel jtfsub_Medicina;
    private javax.swing.JPanel jtfsub_Usuario;
    private javax.swing.JPanel jtfsub_inventario;
    private javax.swing.JPanel left;
    // End of variables declaration//GEN-END:variables
}
