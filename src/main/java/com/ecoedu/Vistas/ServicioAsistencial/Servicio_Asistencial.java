package com.ecoedu.Vistas.ServicioAsistencial;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Detalle_Servicio_Social;
import com.ecoedu.model.Servicio_social;
import com.ecoedu.model.Receta;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Tarifario;
import com.ecoedu.model.Usuario;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.dom4j.DocumentException;


public class Servicio_Asistencial extends javax.swing.JPanel {
    private Principal objPrincipal;
    private float Monto_totalControlEstudiante;
    private float saldo_totalControlEstudiante;
    private Control_paciente objControl_paciente_Final;
    private List<Servicio_social> Lista_Detalle_servicio_social;
    private Usuario objUsuario;
    private EntityManager jpa;   
    private List<Detalle_Servicio_Social> lista_DetalleServicioSocial=new ArrayList<>();
    private List<Rol> lista_tipo_asistencial; 
    private List<Detalle_Medicamentos> Lista_carrito_medicamentos=new ArrayList<>();//
    TextAutoCompleter autoCompleterServicio;
    private List<Tarifario> Lista_tarifa;
    //datos q se desglozan de la BD               
    private List<Control_paciente> Lista_control_paciente;//
      
    public Servicio_Asistencial(EntityManager jpa2,Principal OBJPrincipal,Usuario OBJUsuario){
        initComponents();
        this.autoCompleterServicio=new TextAutoCompleter(jtfDescripcion, new AutoCompleterCallback(){
            @Override
            public void callback(Object o){
                actualizarPrecio();}});        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;
        this.objUsuario=OBJUsuario;        
    }
     public void ConsultaBD(){
         Lista_control_paciente=jpa.createQuery("SELECT p FROM Control_paciente p where iSactivo=1").getResultList();
         lista_tipo_asistencial=jpa.createQuery("SELECT p FROM Tipo_Asistencial p ").getResultList();  
         Lista_tarifa=jpa.createQuery("SELECT p FROM Tarifario p ").getResultList();
         
         
     }
    
     public void principalEjecucion(){ 
         jlblFecha.setText(Herramienta.formatoFecha(new Date()));
         
         for (Tarifario tarifario : Lista_tarifa) {
             autoCompleterServicio.addItem(tarifario.getDescripcion());
         }
         jbtnImprimirServicios.setEnabled(false);     
         jbtnCrearServicio.setEnabled(false);
         //llenar_Tabla_de_Recetas(Lista_Detalle_servicio_social);
         
           
     }  
     public float getPrecio_delControlEstudiante(){
         return Monto_totalControlEstudiante;
     }
     public void addPrecio_delControlEstudiante(float a){
         Monto_totalControlEstudiante=Monto_totalControlEstudiante+a;
         saldo_totalControlEstudiante=saldo_totalControlEstudiante-a;
     }
     public void getListaCarritos(Detalle_Medicamentos objDetalleMedicamento){
         JOptionPane.showMessageDialog(jlblNombres, "corre");
         Lista_carrito_medicamentos.add(objDetalleMedicamento);
                  
     } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlblNombres = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblEscuela = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblSerie = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfLookCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpoListaCrearServicio = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jtfDescripcion = new javax.swing.JTextField();
        jlblPrecio = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jbtnAgregar = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jlblMontoTotal1 = new javax.swing.JLabel();
        jbtnImprimir1 = new javax.swing.JButton();
        jbtnCrearReceta1 = new javax.swing.JButton();
        cuerpoListaServicios = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas4 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlblAdvertencia = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jlblMontoTotal = new javax.swing.JLabel();
        jbtnImprimirServicios = new javax.swing.JButton();
        jbtnCrearServicio = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setMaximumSize(new java.awt.Dimension(990, 650));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(153, 255, 102));
        head.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Servicios Asistenciales");
        jLabel12.setPreferredSize(new java.awt.Dimension(351, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(890, 100));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setEnabled(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(880, 40));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APELLIDOS Y NOMBRES :");
        jLabel3.setPreferredSize(new java.awt.Dimension(225, 30));
        jPanel5.add(jLabel3);

        jlblNombres.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblNombres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblNombres.setPreferredSize(new java.awt.Dimension(640, 30));
        jPanel5.add(jlblNombres);

        jPanel7.add(jPanel5);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel7.setText("ESCUELA :");
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel7.add(jLabel7);

        jlblEscuela.setBackground(new java.awt.Color(0, 0, 0));
        jlblEscuela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblEscuela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEscuela.setToolTipText("");
        jlblEscuela.setPreferredSize(new java.awt.Dimension(320, 30));
        jPanel7.add(jlblEscuela);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel5.setText("Serie :");
        jLabel5.setPreferredSize(new java.awt.Dimension(58, 30));
        jPanel7.add(jLabel5);

        jlblSerie.setBackground(new java.awt.Color(0, 0, 0));
        jlblSerie.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSerie.setPreferredSize(new java.awt.Dimension(39, 30));
        jPanel7.add(jlblSerie);

        jLabel15.setPreferredSize(new java.awt.Dimension(135, 30));
        jPanel7.add(jLabel15);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel8.setText("Código:");
        jLabel8.setPreferredSize(new java.awt.Dimension(68, 30));
        jPanel7.add(jLabel8);

        jtfLookCodigo.setBackground(new java.awt.Color(240, 200, 20));
        jtfLookCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtfLookCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLookCodigo.setPreferredSize(new java.awt.Dimension(85, 30));
        jtfLookCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfLookCodigo);

        jLabel6.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel7.add(jLabel6);

        head2.add(jPanel7);

        body.add(head2, java.awt.BorderLayout.PAGE_START);

        body2.setBackground(new java.awt.Color(255, 255, 255));
        body2.setMaximumSize(new java.awt.Dimension(1990, 650));
        body2.setMinimumSize(new java.awt.Dimension(200, 200));
        body2.setPreferredSize(new java.awt.Dimension(9900, 520));
        body2.setLayout(new java.awt.CardLayout());

        cuerpoListaCrearServicio.setBackground(new java.awt.Color(255, 255, 255));
        cuerpoListaCrearServicio.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(900, 320));
        jPanel12.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jPanel12HierarchyChanged(evt);
            }
        });
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(" SERVICIOS ASISTENCIALES DEL ESTUDIANTE (rugro s/110)");
        jLabel16.setPreferredSize(new java.awt.Dimension(178, 30));
        jPanel12.add(jLabel16, java.awt.BorderLayout.PAGE_START);

        jLabel17.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel12.add(jLabel17, java.awt.BorderLayout.LINE_END);

        jLabel19.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel12.add(jLabel19, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(jtfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 620, 30));

        jlblPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jlblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 40, -1));

        jlblFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblFecha.setText("2019/06/04");
        jPanel1.add(jlblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jbtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar.setText("AGREGAR");
        jbtnAgregar.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 140, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Fecha Registro:");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtblRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Descripción", "Costo"
            }
        ));
        jScrollPane2.setViewportView(jtblRecetas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 880, 180));

        jPanel12.add(jPanel1, java.awt.BorderLayout.CENTER);

        cuerpoListaCrearServicio.add(jPanel12);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Monto Total :");
        jLabel20.setPreferredSize(new java.awt.Dimension(130, 26));
        jPanel14.add(jLabel20);

        jlblMontoTotal1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblMontoTotal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblMontoTotal1.setText("S/0.00");
        jlblMontoTotal1.setPreferredSize(new java.awt.Dimension(280, 29));
        jPanel14.add(jlblMontoTotal1);

        jbtnImprimir1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnImprimir1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnImprimir1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnImprimir1.setText("IMPRIMIR");
        jbtnImprimir1.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimir1ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnImprimir1);

        jbtnCrearReceta1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCrearReceta1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrearReceta1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCrearReceta1.setText("GUARDAR");
        jbtnCrearReceta1.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnCrearReceta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearReceta1ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnCrearReceta1);

        cuerpoListaCrearServicio.add(jPanel14);

        body2.add(cuerpoListaCrearServicio, "card2");

        cuerpoListaServicios.setBackground(new java.awt.Color(255, 255, 255));
        cuerpoListaServicios.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 250));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jtblRecetas4.setBorder(new javax.swing.border.MatteBorder(null));
        jtblRecetas4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Fecha", "Total Costo", "Procedencia", "Diagnostico"
            }
        ));
        jtblRecetas4.setGridColor(new java.awt.Color(0, 0, 0));
        jtblRecetas4.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblRecetas4.setPreferredSize(new java.awt.Dimension(200, 260));
        jtblRecetas4.setRequestFocusEnabled(false);
        jtblRecetas4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRecetas4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRecetas4);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(" SERVICIOS ASISTENCIALES DEL ESTUDIANTE");
        jLabel11.setPreferredSize(new java.awt.Dimension(178, 30));
        jPanel9.add(jLabel11, java.awt.BorderLayout.PAGE_START);

        jLabel14.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel14, java.awt.BorderLayout.LINE_END);

        jLabel18.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel18, java.awt.BorderLayout.LINE_START);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click en la tabla para ver Detalles de la Receta");
        jPanel9.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        cuerpoListaServicios.add(jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(900, 70));

        jlblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAdvertencia.setForeground(new java.awt.Color(255, 0, 0));
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setMaximumSize(new java.awt.Dimension(500, 0));
        jlblAdvertencia.setMinimumSize(new java.awt.Dimension(100, 0));
        jlblAdvertencia.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel11.add(jlblAdvertencia);

        cuerpoListaServicios.add(jPanel11);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Monto Total :");
        jLabel13.setPreferredSize(new java.awt.Dimension(130, 26));
        jPanel10.add(jLabel13);

        jlblMontoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblMontoTotal.setPreferredSize(new java.awt.Dimension(280, 29));
        jPanel10.add(jlblMontoTotal);

        jbtnImprimirServicios.setBackground(new java.awt.Color(0, 0, 0));
        jbtnImprimirServicios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnImprimirServicios.setForeground(new java.awt.Color(255, 255, 255));
        jbtnImprimirServicios.setText("IMPRIMIR");
        jbtnImprimirServicios.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnImprimirServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirServiciosActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnImprimirServicios);

        jbtnCrearServicio.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCrearServicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrearServicio.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCrearServicio.setText("AÑADIR SERVICIO");
        jbtnCrearServicio.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnCrearServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearServicioActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnCrearServicio);

        cuerpoListaServicios.add(jPanel10);

        body2.add(cuerpoListaServicios, "card2");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
   
    
    public void llenarControlAlumno(){//usando acceso BD   
        for (int i = 0; i < Lista_control_paciente.size(); i++){
            if (Lista_control_paciente.get(i).getEstudiante().getCodigo().equals(jtfLookCodigo.getText())){                
                objControl_paciente_Final=Lista_control_paciente.get(i);
                Monto_totalControlEstudiante=objControl_paciente_Final.getMonto_Total();
                saldo_totalControlEstudiante=90-objControl_paciente_Final.getMonto_Total();
                jlblNombres.setText(Lista_control_paciente.get(i).getEstudiante().getPersona().getInfoPersona());
                jlblSerie.setText(Lista_control_paciente.get(i).getEstudiante().getSerie());
                jlblEscuela.setText(Lista_control_paciente.get(i).getEstudiante().getRolescuela().getNombre_rol());
                jlblMontoTotal.setText("S/"+Herramienta.dosDecimales(Lista_control_paciente.get(i).getMonto_Total()));              
                Lista_Detalle_servicio_social=Herramienta.findbyWhere(Servicio_social.class,"id_Control_paciente",objControl_paciente_Final.getId_Control_paciente(), jpa);
                jbtnCrearServicio.setEnabled(true);
                jbtnImprimirServicios.setEnabled(true);
                if(Lista_Detalle_servicio_social.isEmpty()){
                jlblAdvertencia.setText("NO CONTIENE NI UN SERVICIO");
                jbtnImprimirServicios.setEnabled(false);
                }               
                break;
            }
            jbtnCrearServicio.setEnabled(false);
            jbtnImprimirServicios.setEnabled(false);
            jlblAdvertencia.setText("");
        }
        
       //new ArrayList<>()(Lista_Detalle_servicio_social);        
    }
    private void jbtnCrearServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearServicioActionPerformed
        Lista_Detalle_servicio_social=jpa.createQuery("SELECT p FROM Detalle_servicio_social p").getResultList();
        cuerpoListaServicios.setVisible(false);  
        jtfLookCodigo.setEditable(false);
    }//GEN-LAST:event_jbtnCrearServicioActionPerformed

    private void jtblRecetas4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRecetas4MouseClicked
        Receta objReceta=(Receta)jtblRecetas4.getValueAt(jtblRecetas4.getSelectedRow(),0);
        for (int i = 0; i < Lista_Detalle_servicio_social.size(); i++){
          /*  if(Lista_Detalle_servicio_social.get(i)==objReceta){ 
                cuerpoListaServicios.setVisible(false);
                jtfLookCodigo.setEditable(false);
                break;
            } */       
        }
    }//GEN-LAST:event_jtblRecetas4MouseClicked

    private void jtfLookCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            llenarControlAlumno();            
        }
    }//GEN-LAST:event_jtfLookCodigoKeyPressed

    public void Limpiarcuerp2CrearRecetas(){
        cuerpoListaServicios.setVisible(true);
    }
    private void jtfLookCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyTyped
        if (jtfLookCodigo.getText().length()>=8){             
         evt.consume(); 
         }
        
        
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jtfLookCodigoKeyTyped

    private void jtfLookCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyReleased
        if(jtfLookCodigo.getText().length()>=8){
                llenarControlAlumno();
            }
        else{
            limpiarVista1();
        }
    }//GEN-LAST:event_jtfLookCodigoKeyReleased

    private void jbtnImprimirServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirServiciosActionPerformed
 
        try {
            imprimirEstudiante();
            String url="Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
            }
        catch (IOException ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(jLabel12,"El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");        
        } 
        catch (DocumentException ex) {
            JOptionPane.showMessageDialog(jLabel12,ex.toString());

        }
    }//GEN-LAST:event_jbtnImprimirServiciosActionPerformed

    private void jbtnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnImprimir1ActionPerformed

    private void jbtnCrearReceta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearReceta1ActionPerformed
       Servicio_social objServicioSocial=new Servicio_social();
        objServicioSocial.setControl_Paciente(objControl_paciente_Final);
        objServicioSocial.setFecha(new Date());
        objServicioSocial.setMonto(0);
        objServicioSocial.setUsuario(objUsuario);
    }//GEN-LAST:event_jbtnCrearReceta1ActionPerformed

    private void jPanel12HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanel12HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12HierarchyChanged

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        Detalle_Servicio_Social objDetalle_Servicio_Social=new Detalle_Servicio_Social();        
        objDetalle_Servicio_Social.setPrecio_Total(Float.parseFloat(jlblPrecio.getText()));
        for (Tarifario tarifario : Lista_tarifa) {
            if(tarifario.getDescripcion().equals(jtfDescripcion.getText())){
                objDetalle_Servicio_Social.setTarifario(tarifario);
                break;
            }            
        }
        objDetalle_Servicio_Social.setServicio_social(new Servicio_social());
        objDetalle_Servicio_Social.setUsuario(objUsuario);
        lista_DetalleServicioSocial.add(objDetalle_Servicio_Social);
        llenar_Tabla_de_Recetas(lista_DetalleServicioSocial);
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    public void actualizarPrecio(){
        for (Tarifario tarifario : Lista_tarifa){
            if(tarifario.getDescripcion().equals(jtfDescripcion.getText())){
                jlblPrecio.setText(Float.toString(tarifario.getPrecio()));
                break;
            }            
        }
    }
    private void jtfDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescripcionKeyTyped
        actualizarPrecio();
    }//GEN-LAST:event_jtfDescripcionKeyTyped
    public void imprimirEstudiante() throws FileNotFoundException, DocumentException, IOException{
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTamaño=9;
        int fontHeadTamaño=11;
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");
        } 
        
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4);        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{8,15,5,4,18});
        table.setWidthPercent(100);
        
        Paragraph paragIma=new Paragraph("").add(unsch);  
        document.add(paragIma);
        
        Paragraph paraTitle=new Paragraph("CONTROL ECONÓMICO DE ATENCIONES").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER);
        document.add(paraTitle);
        Paragraph parag=new Paragraph(new Text("APELLIDOS Y NOMBRES: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getPersona().getInfoPersona()).setTextAlignment(TextAlignment.LEFT);
        document.add(parag);      
        Paragraph paraEscCodSerie=new Paragraph(new Text("ESCUELA: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getRolescuela().getNombre_rol())
                .add(new Text("         SERIE: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getSerie()).setTextAlignment(TextAlignment.LEFT)
                .add(new Text("         CÓDIGO: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getCodigo());
        document.add(paraEscCodSerie);
        Paragraph parag2=new Paragraph("ATENCIONES-SERVICIO DE FARMACIA").setFont(bold).setTextAlignment(TextAlignment.CENTER);         
        document.add(parag2);
        document.add(new Paragraph(" "));    
        table.addHeaderCell(new Cell().add(new Paragraph("Fecha").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell().add(new Paragraph("Producto Farmacéutico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));        
        table.addHeaderCell(new Cell().add(new Paragraph("Monto").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Químico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
                 
      //Collections.sort(Lista_Detalle_servicio_social);//ordenando A-Z (método como Override)
        for(Servicio_social detalle_servicio_social : Lista_Detalle_servicio_social){
           // table.addCell(new Paragraph(Herramienta.formatoFecha(Detalle_Medicamento.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            //table.addCell(new Paragraph(Detalle_Medicamento.getId_Medicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            //table.addCell(new Paragraph(Integer.toString(Detalle_Medicamento.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            //table.addCell(new Paragraph(Float.toString(Detalle_Medicamento.getPrecio_Total())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            //table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            
        }
        document.add(table);        
        document.close();       
    }
    public void limpiarVista1(){
         jlblNombres.setText("");
         jlblEscuela.setText("");
         jlblSerie.setText("");
         Lista_Detalle_servicio_social.clear();
         llenarControlAlumno();
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel cuerpoListaCrearServicio;
    private javax.swing.JPanel cuerpoListaServicios;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCrearReceta1;
    private javax.swing.JButton jbtnCrearServicio;
    private javax.swing.JButton jbtnImprimir1;
    private javax.swing.JButton jbtnImprimirServicios;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblMontoTotal;
    private javax.swing.JLabel jlblMontoTotal1;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JTable jtblRecetas;
    private javax.swing.JTable jtblRecetas4;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfLookCodigo;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Recetas(List<Detalle_Servicio_Social> lista_de_detalleServicioSocial){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Tipo","Descripción","Precio","Asistenta"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = lista_de_detalleServicioSocial.size()-1; i>=0 ; i--){
                 fila_actividad[0]=lista_de_detalleServicioSocial.get(i).getTarifario().getRolTipo_asistencial().getNombre_rol();
                 fila_actividad[1]=lista_de_detalleServicioSocial.get(i).getTarifario().getDescripcion();           
                 fila_actividad[2]=lista_de_detalleServicioSocial.get(i).getTarifario().getPrecio();  
                 fila_actividad[3]=lista_de_detalleServicioSocial.get(i).getUsuario().getPersona().getInfoPersona();   
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblRecetas.setModel(modelo); 
            jtblRecetas.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblRecetas.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(3).setCellRenderer(tcr);

            jtblRecetas.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtblRecetas.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtblRecetas.getColumnModel().getColumn(3).setPreferredWidth(130);
           
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
}
