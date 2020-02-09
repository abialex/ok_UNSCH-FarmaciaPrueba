package com.ecoedu.Vistas.ServicioAsistencial;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Servicio_Social;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.RegistroMensualLotes;
import com.ecoedu.model.Semestre;
import com.ecoedu.model.Servicio_social;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private List<Servicio_social> Lista_servicio_social=new ArrayList<>();
    private Usuario objUsuario;
    private EntityManager jpa;   
    private List<Detalle_Servicio_Social> lista_DetalleServicioSocial=new ArrayList<>();
    private List<Detalle_Servicio_Social> Lista_carrito_Servicio=new ArrayList<>();//
    private Semestre objSemestre;
    TextAutoCompleter autoCompleterServicio;
    private int limite_seguro;
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
         
         Lista_tarifa=jpa.createQuery("SELECT p FROM Tarifario p").getResultList();
         List<Semestre> lis=jpa.createQuery("SELECT p from Semestre p where fecha_fin_Real is null").getResultList();  
         if(!lis.isEmpty()){
             objSemestre=lis.get(0);
             Lista_control_paciente=jpa.createQuery("SELECT p FROM Control_paciente p where iSactivo=1 and id_Semestre="+objSemestre.getId_Semestre()).getResultList();
         }
     }    
     public void principalEjecucion(){ 
         llenar_Tabla_de_Detalle_Asistenciales(new ArrayList<Detalle_Servicio_Social>());
         jlblFecha.setText(Herramienta.formatoFecha(new Date()));        
         jbtnImprimirServicios.setEnabled(false);     
         jbtnCrearServicio.setEnabled(false);
         autoCompleterServicio.removeAllItems();
         for (Tarifario tarifario : Lista_tarifa) {
             autoCompleterServicio.addItem(tarifario);
         }
         //llenar_Tabla_de_Recetas(Lista_servicio_social);
         
           
     }  
     public float getPrecio_delControlEstudiante(){
         return Monto_totalControlEstudiante;
     }
     public void addPrecio_delControlEstudiante(float a){
         Monto_totalControlEstudiante=Monto_totalControlEstudiante+a;
         saldo_totalControlEstudiante=saldo_totalControlEstudiante-a;
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
        cuerpoListaServicios = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblServicios = new javax.swing.JTable();
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
        jlblTipo = new javax.swing.JLabel();
        jlblAsteriscoServicioRegistrar = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblTarifas = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jlblMontoTotalAsistencial = new javax.swing.JLabel();
        jbtnVolver = new javax.swing.JButton();
        jbtnCrearReceta1 = new javax.swing.JButton();
        cuerpoVisualisarDetalleServicio = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblFechaVer = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblDetalleServicioSocial = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jbtnCrearReceta2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jbtnVolver1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setMaximumSize(new java.awt.Dimension(990, 650));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(0, 0, 204));
        head.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Servicios Social");
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

        jLabel15.setPreferredSize(new java.awt.Dimension(75, 30));
        jPanel7.add(jLabel15);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel8.setText("Código o Dni:");
        jLabel8.setPreferredSize(new java.awt.Dimension(128, 30));
        jPanel7.add(jLabel8);

        jtfLookCodigo.setBackground(new java.awt.Color(0, 0, 204));
        jtfLookCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtfLookCodigo.setForeground(new java.awt.Color(255, 255, 255));
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

        cuerpoListaServicios.setBackground(new java.awt.Color(255, 255, 255));
        cuerpoListaServicios.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 250));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jtblServicios.setBorder(new javax.swing.border.MatteBorder(null));
        jtblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Fecha", "Total Costo", "Procedencia", "Diagnostico"
            }
        ));
        jtblServicios.setGridColor(new java.awt.Color(0, 0, 0));
        jtblServicios.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblServicios.setPreferredSize(new java.awt.Dimension(200, 260));
        jtblServicios.setRequestFocusEnabled(false);
        jtblServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblServicios);

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
        jLabel1.setText("SELECCIONE PARA VER DETALLES DE UN SERVICIO");
        jPanel9.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        cuerpoListaServicios.add(jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(900, 75));

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

        cuerpoListaCrearServicio.setBackground(new java.awt.Color(255, 255, 255));
        cuerpoListaCrearServicio.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(900, 330));
        jPanel12.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jPanel12HierarchyChanged(evt);
            }
        });
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(" SERVICIO SOCIAL DEL ESTUDIANTE (rugro s/110)");
        jLabel16.setPreferredSize(new java.awt.Dimension(178, 30));
        jPanel12.add(jLabel16, java.awt.BorderLayout.PAGE_START);

        jLabel17.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel12.add(jLabel17, java.awt.BorderLayout.LINE_END);

        jLabel19.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel12.add(jLabel19, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfDescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(jtfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 30));

        jlblPrecio.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jlblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 70, 25));

        jlblFecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jlblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 120, 25));

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
        jPanel1.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 180, 30));

        jlblTipo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jlblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 170, 25));

        jlblAsteriscoServicioRegistrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblAsteriscoServicioRegistrar.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoServicioRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoServicioRegistrar.setText("*");
        jPanel1.add(jlblAsteriscoServicioRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 15, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel37.setText("Precio:");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, 25));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel38.setText("Tipo:");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 25));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel39.setText("Fecha Registro:");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 25));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jtblTarifas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblTarifas.setDoubleBuffered(true);
        jtblTarifas.setPreferredSize(new java.awt.Dimension(225, 141));
        jtblTarifas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTarifasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblTarifas);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 170));

        jPanel12.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        cuerpoListaCrearServicio.add(jPanel12);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Total:");
        jLabel21.setPreferredSize(new java.awt.Dimension(130, 26));
        jPanel14.add(jLabel21);

        jlblMontoTotalAsistencial.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblMontoTotalAsistencial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblMontoTotalAsistencial.setText("S/0.00");
        jlblMontoTotalAsistencial.setPreferredSize(new java.awt.Dimension(280, 29));
        jPanel14.add(jlblMontoTotalAsistencial);

        jbtnVolver.setBackground(new java.awt.Color(0, 0, 0));
        jbtnVolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnVolver.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolver.setText("VOLVER");
        jbtnVolver.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnVolver);

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

        cuerpoVisualisarDetalleServicio.setBackground(new java.awt.Color(255, 255, 255));
        cuerpoVisualisarDetalleServicio.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(900, 331));
        jPanel13.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jPanel13HierarchyChanged(evt);
            }
        });
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Detalle de Servicio Social");
        jLabel20.setPreferredSize(new java.awt.Dimension(178, 30));
        jPanel13.add(jLabel20, java.awt.BorderLayout.PAGE_START);

        jLabel22.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel13.add(jLabel22, java.awt.BorderLayout.LINE_END);

        jLabel23.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel13.add(jLabel23, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 300));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblFechaVer.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel2.add(jlblFechaVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 220, 25));

        jtblDetalleServicioSocial.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblDetalleServicioSocial.setMinimumSize(new java.awt.Dimension(0, 0));
        jtblDetalleServicioSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDetalleServicioSocialMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtblDetalleServicioSocial);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 900, 180));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel42.setText("Fecha Registro:");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 25));

        jPanel13.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        cuerpoVisualisarDetalleServicio.add(jPanel13);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(900, 40));

        jbtnCrearReceta2.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCrearReceta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrearReceta2.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCrearReceta2.setText("IMPRIMIR");
        jbtnCrearReceta2.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnCrearReceta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearReceta2ActionPerformed(evt);
            }
        });
        jPanel15.add(jbtnCrearReceta2);

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setPreferredSize(new java.awt.Dimension(455, 26));
        jPanel15.add(jLabel24);

        jbtnVolver1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnVolver1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnVolver1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolver1.setText("VOLVER");
        jbtnVolver1.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolver1ActionPerformed(evt);
            }
        });
        jPanel15.add(jbtnVolver1);

        cuerpoVisualisarDetalleServicio.add(jPanel15);

        body2.add(cuerpoVisualisarDetalleServicio, "card2");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
   
    
    public void llenarControlAlumno(){//usando acceso BD  
        boolean aux=true;
        for (int i = 0; i < Lista_control_paciente.size(); i++){
            if (Lista_control_paciente.get(i).getEstudiante().getCodigo().equals(jtfLookCodigo.getText())
                 || Lista_control_paciente.get(i).getEstudiante().getPersona().getDni().equals(jtfLookCodigo.getText())){  
                aux=false;
                objControl_paciente_Final=Lista_control_paciente.get(i);
                limite_seguro=objControl_paciente_Final.getLimite_control();  
                Monto_totalControlEstudiante=objControl_paciente_Final.getMonto_Total();                
                saldo_totalControlEstudiante=limite_seguro-objControl_paciente_Final.getMonto_Total();                
                jlblNombres.setText(Lista_control_paciente.get(i).getEstudiante().getPersona().getInfoPersona());
                jlblSerie.setText(Lista_control_paciente.get(i).getEstudiante().getSerie());
                jlblEscuela.setText(Lista_control_paciente.get(i).getEstudiante().getRolescuela().getNombre_rol());
                jlblMontoTotal.setText("S/"+Herramienta.dosDecimales(Lista_control_paciente.get(i).getMonto_Total()));              
                Lista_servicio_social=Herramienta.findbyWhere(Servicio_social.class,"id_Control_paciente",objControl_paciente_Final.getId_Control_paciente(), jpa);
                jbtnCrearServicio.setEnabled(true);
                jbtnImprimirServicios.setEnabled(true);
                if(Lista_servicio_social.isEmpty()){
                    jlblAdvertencia.setText("NO CONTIENE NI UN SERVICIO");
                    jbtnImprimirServicios.setEnabled(false);
                    }
                else{
                    jlblAdvertencia.setText("");
                }
                break;
                }
            jbtnCrearServicio.setEnabled(false);
            jbtnImprimirServicios.setEnabled(false);
            jlblAdvertencia.setText("");
            }
        if(aux){
            List<Estudiante> Lista_Estudiante=jpa.createQuery("SELECT p FROM Estudiante p where codigo='"+jtfLookCodigo.getText()+"'").getResultList();
            if(Lista_Estudiante.isEmpty()){
                jlblAdvertencia.setText("NO SE ENCONTRÓ ALUMNO CON EL CÓDIGO: "+jtfLookCodigo.getText());
                limpiarVista1();
                }
            else{
                if(objSemestre!=null){
                CuadroCarritoMedicinas objCuadroCarrito=new CuadroCarritoMedicinas(jpa, Lista_Estudiante.get(0), this,objSemestre);
                objCuadroCarrito.setVisible(true);
                objPrincipal.setEnabled(false);}
                }
            }
        llenar_Tabla_de_Asistenciales(Lista_servicio_social);
        }
    
    public Principal getPrincipal(){
        return objPrincipal;
    }
    private void jbtnCrearServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearServicioActionPerformed
        cuerpoListaServicios.setVisible(false);  
        cuerpoListaCrearServicio.setVisible(true);
        jtfLookCodigo.setEditable(false);
    }//GEN-LAST:event_jbtnCrearServicioActionPerformed

    private void jtblServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblServiciosMouseClicked
        Servicio_social objServicio_Social=(Servicio_social)jtblServicios.getValueAt(jtblServicios.getSelectedRow(),1);
        lista_DetalleServicioSocial=Herramienta.findbyWhere(Detalle_Servicio_Social.class, "id_Servicio_social", objServicio_Social.getId_Detalle_servicio_social(), jpa);
        llenar_Tabla_de_DetalleAsistencialesMirar(lista_DetalleServicioSocial);
        jlblFechaVer.setText(Herramienta.formatoFechaHoraMas1(objServicio_Social.getFecha()));
        cuerpoListaServicios.setVisible(false);
        cuerpoVisualisarDetalleServicio.setVisible(true);
    }//GEN-LAST:event_jtblServiciosMouseClicked

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
            //imprimirEstudiante();
            String url="Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
            }
        catch (IOException ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(jLabel12,"El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");        
        } 
        
    }//GEN-LAST:event_jbtnImprimirServiciosActionPerformed

    private void jbtnCrearReceta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearReceta1ActionPerformed
       Servicio_social objServicioSocial=new Servicio_social();
        objServicioSocial.setControl_Paciente(objControl_paciente_Final);//control
        objServicioSocial.setFecha(new Date());//fecha
        objServicioSocial.setMonto(sumarPrecios());//monto
        
        jpa.getTransaction().begin();        
        jpa.persist(objServicioSocial);
        jpa.refresh(objServicioSocial);
        jpa.persist(objControl_paciente_Final.agregarPrecioTotal(sumarPrecios()));
        for (Detalle_Servicio_Social objDetalleServicio : Lista_carrito_Servicio){
            objDetalleServicio.setServicio_social(objServicioSocial);
            jpa.persist(objDetalleServicio);
        }
        ConsultaBD();
        principalEjecucion();
        llenarControlAlumno();
        jlblMontoTotalAsistencial.setText("S/0.00");
        
        cuerpoListaCrearServicio.setVisible(false);
        cuerpoListaServicios.setVisible(true);
        int confirmado = JOptionPane.showConfirmDialog(jlblNombres,"¿Desea Imprimir?");
            if (JOptionPane.OK_OPTION == confirmado){
                try {                
                    imprimirEstudiante(Lista_carrito_Servicio);
                    String url="Carpeta_de_Archivos\\esquela"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf";
                    ProcessBuilder p=new ProcessBuilder();
                    p.command("cmd.exe","/c",url);
                    p.start();            
                    } catch (IOException ex) {
                        Logger.getLogger(ServicioFarmacia.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
               Logger.getLogger(Servicio_Asistencial.class.getName()).log(Level.SEVERE, null, ex);
           }
                }
            else{
                System.out.println("vale... no borro nada...");}
                Lista_carrito_Servicio.clear();
        jpa.getTransaction().commit();
    }//GEN-LAST:event_jbtnCrearReceta1ActionPerformed

    private void jPanel12HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanel12HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12HierarchyChanged

    private float sumarPrecios(){
        float a=0;
        for (Detalle_Servicio_Social detalle_Servicio_Social : Lista_carrito_Servicio){
            a=a+detalle_Servicio_Social.getPrecio_Total();
        }
        return a;
    }
    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
       if(jlblAsteriscoServicioRegistrar.getText().isEmpty()){
        Tarifario objTarifa=(Tarifario)autoCompleterServicio.getItemSelected();
        Detalle_Servicio_Social objDetalleServicioSocial=new Detalle_Servicio_Social();
        objDetalleServicioSocial.setUsuario(objUsuario);
        objDetalleServicioSocial.setTarifario(objTarifa);
        objDetalleServicioSocial.setPrecio_Total(objTarifa.getPrecio());
        Lista_carrito_Servicio.add(objDetalleServicioSocial);
        llenar_Tabla_de_Detalle_Asistenciales(Lista_carrito_Servicio);
        jlblMontoTotalAsistencial.setText("S/"+sumarPrecios()+"0");
        jtfDescripcion.setText("");
        jlblAsteriscoServicioRegistrar.setText("*");
        jlblTipo.setText("");
        jlblPrecio.setText("");
       }
       else{
           JOptionPane.showMessageDialog(jlblNombres, "INGRESE UN SERVICIO VÁLIDO");
       }
        

    }//GEN-LAST:event_jbtnAgregarActionPerformed

    public void actualizarPrecio(){
        /*for (Tarifario tarifario : Lista_tarifa){
            if(tarifario.getDescripcion().equals(jtfDescripcion.getText())){
                jlblPrecio.setText(Float.toString(tarifario.getPrecio()));
                break;
            }            
        }*/
    }
    private void jtfDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescripcionKeyTyped
        actualizarPrecio();
    }//GEN-LAST:event_jtfDescripcionKeyTyped

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed
        cuerpoListaCrearServicio.setVisible(false);
        cuerpoListaServicios.setVisible(true);
        jtfLookCodigo.setEditable(true);
    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jtfDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescripcionKeyReleased
        for (Tarifario tarifario : Lista_tarifa){
            if(tarifario.getDescripcion().equals(jtfDescripcion.getText())){
                jlblTipo.setText(tarifario.getRolTipo_asistencial().getNombre_rol());
                jlblPrecio.setText("S/"+tarifario.getPrecio());
                jlblAsteriscoServicioRegistrar.setText("");
                break;
            }
            jlblAsteriscoServicioRegistrar.setText("*");
            
        }
    }//GEN-LAST:event_jtfDescripcionKeyReleased

    private void jPanel13HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanel13HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13HierarchyChanged

    private void jbtnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolver1ActionPerformed
        cuerpoVisualisarDetalleServicio.setVisible(false);
        cuerpoListaServicios.setVisible(true);
    }//GEN-LAST:event_jbtnVolver1ActionPerformed

    private void jbtnCrearReceta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearReceta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCrearReceta2ActionPerformed

    private void jtblDetalleServicioSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDetalleServicioSocialMouseClicked
        
        
    }//GEN-LAST:event_jtblDetalleServicioSocialMouseClicked

    private void jtblTarifasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblTarifasMouseClicked

        Detalle_Servicio_Social objTarifa =(Detalle_Servicio_Social)jtblTarifas.getValueAt(jtblTarifas.getSelectedRow(),1);
        Lista_carrito_Servicio.remove(objTarifa);
        jlblMontoTotalAsistencial.setText("S/"+sumarPrecios()+"0");
        llenar_Tabla_de_Detalle_Asistenciales(Lista_carrito_Servicio);
    }//GEN-LAST:event_jtblTarifasMouseClicked
    public void imprimirEstudiante(List<Detalle_Servicio_Social> Lista_ServiciosDetalles) throws FileNotFoundException, DocumentException, IOException{
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTamaño=9;
        int fontHeadTamaño=11;
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\esquela"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");
        } 
        
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4);        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{2,5,20,5});
        table.setWidthPercent(100);
        
        Paragraph paragIma=new Paragraph("").add(unsch);  
        
        
        Paragraph paraTitle=new Paragraph("ESQUELA DE GARANTÍA            OSEA").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER);
        
        Paragraph parag=new Paragraph(new Text("APELLIDOS Y NOMBRES: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getPersona().getInfoPersona()).setTextAlignment(TextAlignment.LEFT).
                add(new Text("       CÓDIGO: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getCodigo());
        
        
        Paragraph paraEscCodSerie=new Paragraph(new Text("Serie: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getSerie())
                .add(new Text("      E.P: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getRolescuela().getNombre_rol()).setTextAlignment(TextAlignment.LEFT)
                .add(new Text("      Procedencia del servicio: ").setFont(bold)).add(".............................")
                ;
        
        Paragraph parag2=new Paragraph("Atención solicitada:").setFont(font).setTextAlignment(TextAlignment.LEFT);         
           
        table.addHeaderCell(new Cell().add(new Paragraph("N°").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell().add(new Paragraph("CÓDIGO").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell().add(new Paragraph("DETALLE").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));        
        table.addHeaderCell(new Cell().add(new Paragraph("IMPORTE S/").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
                 
      //Collections.sort(Lista_servicio_social);//ordenando A-Z (método como Override)
      int i=1;
        for(Detalle_Servicio_Social detalle_servicio_social : Lista_ServiciosDetalles){
           table.addCell(new Paragraph(i+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(detalle_servicio_social.getTarifario().getCodigo()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(detalle_servicio_social.getTarifario().getDescripcion()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(detalle_servicio_social.getPrecio_Total()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            //table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            i++;
        }
        
        Paragraph fecha=new Paragraph("Ayacucho "+Herramienta.formatoFechaMas1(new Date())).setFont(bold).setTextAlignment(TextAlignment.LEFT);         
        document.add(paragIma);
        document.add(paraTitle);
        document.add(parag); 
        document.add(paraEscCodSerie);
        document.add(parag2);
        document.add(new Paragraph(" ")); 
        document.add(table); 
        document.add(new Paragraph(""));
        document.add(fecha);
        
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        
        document.add(paragIma);
        document.add(paraTitle);
        document.add(parag); 
        document.add(paraEscCodSerie);
        document.add(parag2);
        document.add(new Paragraph(" ")); 
        document.add(table); 
        document.add(new Paragraph(""));
        document.add(fecha);
        document.close();       
    }
    public void limpiarVista1(){
         jlblNombres.setText("");
         jlblEscuela.setText("");
         jlblSerie.setText("");
         jlblMontoTotal.setText("");
         Lista_servicio_social.clear();
         llenar_Tabla_de_Asistenciales(Lista_servicio_social);

     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel cuerpoListaCrearServicio;
    private javax.swing.JPanel cuerpoListaServicios;
    private javax.swing.JPanel cuerpoVisualisarDetalleServicio;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCrearReceta1;
    private javax.swing.JButton jbtnCrearReceta2;
    private javax.swing.JButton jbtnCrearServicio;
    private javax.swing.JButton jbtnImprimirServicios;
    private javax.swing.JButton jbtnVolver;
    private javax.swing.JButton jbtnVolver1;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblAsteriscoServicioRegistrar;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblFechaVer;
    private javax.swing.JLabel jlblMontoTotal;
    private javax.swing.JLabel jlblMontoTotalAsistencial;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JLabel jlblTipo;
    private javax.swing.JTable jtblDetalleServicioSocial;
    private javax.swing.JTable jtblServicios;
    private javax.swing.JTable jtblTarifas;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfLookCodigo;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Detalle_Asistenciales(List<Detalle_Servicio_Social> lista_de_detalleServicioSocial){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Tipo","Descripción","Precio"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = lista_de_detalleServicioSocial.size()-1; i>=0 ; i--){
                 fila_actividad[0]=lista_de_detalleServicioSocial.get(i).getTarifario().getRolTipo_asistencial().getNombre_rol();
                 fila_actividad[1]=lista_de_detalleServicioSocial.get(i);           
                 fila_actividad[2]=lista_de_detalleServicioSocial.get(i).getTarifario().getPrecio();  
                 //fila_actividad[3]=lista_de_detalleServicioSocial.get(i).getUsuario().getPersona().getInfoPersona();   
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblTarifas.setModel(modelo); 
            jtblTarifas.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblTarifas.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblTarifas.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblTarifas.getColumnModel().getColumn(2).setCellRenderer(tcr);

            jtblTarifas.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblTarifas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblTarifas.getTableHeader().setBackground(Color.BLUE);
            jtblTarifas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblTarifas.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtblTarifas.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtblTarifas.getColumnModel().getColumn(2).setPreferredWidth(30);
           
            ((DefaultTableCellRenderer)jtblTarifas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }
public void llenar_Tabla_de_DetalleAsistencialesMirar(List<Detalle_Servicio_Social> lista_de_detalleServicioSocial){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Tipo","Descripción","Precio","Asistenta"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false,false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = lista_de_detalleServicioSocial.size()-1; i>=0 ; i--){
                 fila_actividad[0]=lista_de_detalleServicioSocial.get(i).getTarifario().getRolTipo_asistencial().getNombre_rol();
                 fila_actividad[1]=lista_de_detalleServicioSocial.get(i);           
                 fila_actividad[2]=lista_de_detalleServicioSocial.get(i).getTarifario().getPrecio();  
                 fila_actividad[3]=lista_de_detalleServicioSocial.get(i).getUsuario().getPersona().getInfoPersona();   
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblDetalleServicioSocial.setModel(modelo); 
            jtblDetalleServicioSocial.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblDetalleServicioSocial.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblDetalleServicioSocial.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblDetalleServicioSocial.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblDetalleServicioSocial.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtblDetalleServicioSocial.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblDetalleServicioSocial.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblDetalleServicioSocial.getTableHeader().setBackground(Color.BLUE);
            jtblDetalleServicioSocial.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblDetalleServicioSocial.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtblDetalleServicioSocial.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtblDetalleServicioSocial.getColumnModel().getColumn(2).setPreferredWidth(5);
            jtblDetalleServicioSocial.getColumnModel().getColumn(3).setPreferredWidth(25);
           
            ((DefaultTableCellRenderer)jtblDetalleServicioSocial.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }
public void llenar_Tabla_de_Asistenciales(List<Servicio_social> lista_de_Servicio_Social){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Fecha","Precio Total"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (Servicio_social objServicio_Social : lista_de_Servicio_Social) {
                 fila_actividad[0]=Herramienta.formatoFechaHoraMas1(objServicio_Social.getFecha());
                 fila_actividad[1]=objServicio_Social;
                 //fila_actividad[2]=objServicio_Social.getUsuario().getPersona().getInfoPersona();
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblServicios.setModel(modelo); 
            jtblServicios.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblServicios.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblServicios.getColumnModel().getColumn(1).setCellRenderer(tcr);
            //jtblServicios.getColumnModel().getColumn(2).setCellRenderer(tcr);

            jtblServicios.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblServicios.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblServicios.getTableHeader().setBackground(Color.BLUE);
            jtblServicios.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblServicios.getColumnModel().getColumn(0).setPreferredWidth(75);
            jtblServicios.getColumnModel().getColumn(1).setPreferredWidth(100);
            //jtblServicios.getColumnModel().getColumn(2).setPreferredWidth(100);           
            ((DefaultTableCellRenderer)jtblServicios.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }
   
}
