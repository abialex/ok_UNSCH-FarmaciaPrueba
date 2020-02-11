package com.ecoedu.Vistas.Inventario;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.app.EventoPagina;
import com.ecoedu.model.Descarga;
import com.ecoedu.model.Descruce;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Lote_detalle;
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
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Cerrar_Inventario extends javax.swing.JPanel{  
    List<RegistroMensualLotes> Lista_Registro_Mensual;
    List<RegistroMensualInventario> Lista_Mensual_Inventario;
    List<Rol> Lista_Origen;
    Principal objPrincipal;
    Usuario objUsuario;
    EntityManager jpa;
    TextAutoCompleter autoCompleterDescruceMedicamento1;
    TextAutoCompleter autoCompleterDescruceMedicamento2;
    
    boolean estadoCierre=false;
    public Cerrar_Inventario(EntityManager jpa2,Principal OBJPrincipal,Usuario objUser ){
        
        initComponents();   
        this.autoCompleterDescruceMedicamento1=new TextAutoCompleter(jtfDescruzeMedicamento1,new AutoCompleterCallback(){
            @Override
            public void callback(Object o) { /*  */}});
        this.autoCompleterDescruceMedicamento2=new TextAutoCompleter(jtfDescruceMedicamento2,new AutoCompleterCallback(){
            @Override
            public void callback(Object o) { /*  */}});
        
        this.objUsuario=objUser;
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;    
        
    }
    public void ConsultaBD(){   
        Lista_Origen=jpa.createQuery("Select p from Rol p where id_tipo_Roles=10").getResultList();
        Collections.sort(Lista_Origen);
        Lista_Registro_Mensual=jpa.createQuery("SELECT p FROM RegistroMensualLotes p where fecha_cierre_real is null").getResultList();
        Lista_Mensual_Inventario=jpa.createQuery("select p from RegistroMensualInventario p where fecha_cierre_real is null").getResultList();
        if(!Lista_Registro_Mensual.isEmpty()){
             jlblAdvertencia.setText("");
             Collections.sort(Lista_Registro_Mensual);//ordenando A-Z (método como Override)              
             if(Lista_Registro_Mensual.get(0).getFecha_cierra()==null){
                 jlblAdvertencia.setText("Cierre del inventario de "+Herramienta.getNombreMes(Lista_Registro_Mensual.get(0).getFecha_apertura().getMonth()+1));
                 jlblAdverte.setText("Click en el Lote");
                 jbtnCerrarInventario.setEnabled(true);
                 jbtnDescruzar.setVisible(false);
                 llenarTabla(Lista_Registro_Mensual);
                 }
             else{
                 jlblAdvertencia.setText("Inventaríe los medicamentos, correspondientes al mes de "+Herramienta.getNombreMes(Lista_Registro_Mensual.get(0).getFecha_apertura().getMonth()+1));
                 jlblAdverte.setText("click para cerrar algún Medicamento");
                 Collections.sort(Lista_Mensual_Inventario);
                 llenarTablaInventarios(Lista_Mensual_Inventario);
                 }             
             if(Lista_Registro_Mensual.get(0).getFecha_apertura().getMonth()==new Date().getMonth()){
                jbtnCerrarInventario.setText("CERRAR EL INVENTARIO ANTES QUE TERMINE EL MES"); 
             }
             else{
                jbtnCerrarInventario.setText("CERRAR EL INVENTARIO"); 
             }
             jbtnCerrarInventario.setVisible(Lista_Registro_Mensual.get(0).getFecha_cierra()==null);
             jbtnDescruzar.setVisible(Lista_Registro_Mensual.get(0).getFecha_cierra()!=null);
             //jbtnDescruzar.setVisible(!(Lista_Registro_Mensual.get(0).getFecha_cierra()==null));
             }
         else{
             jlblAdvertencia.setText("El Inventario Está Cerrado"); 
             jbtnDescruzar.setVisible(false);
             Lista_Mensual_Inventario=jpa.createQuery("select p from RegistroMensualInventario p where fecha_cierre_real is null").getResultList();
             
             jbtnCerrarInventario.setEnabled(false);
             jlblAdverte.setText("");
             Lista_Registro_Mensual=new ArrayList<>();
             llenarTabla(Lista_Registro_Mensual);
             }
         }
    
    public void principalEjecucion(){
        
        llenarLotesMedicamento2(new ArrayList<Lote_detalle>());
        llenarLotesMedicamento1(new ArrayList<Lote_detalle>());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlblAdvertencia = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        vistaRegistroLotes = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblVentas = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlblAdverte = new javax.swing.JLabel();
        jbtnCerrarInventario = new javax.swing.JButton();
        jbtnDescruzar = new javax.swing.JButton();
        vistaDesCruce = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblDescruceTablaMedicamento2 = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jlblmasdas = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jlblDescruceFF1 = new javax.swing.JLabel();
        jlblDescruceCon1 = new javax.swing.JLabel();
        jlblDescruceFF2 = new javax.swing.JLabel();
        jlblDescruceConc2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jtfDescruceMedicamento2 = new javax.swing.JTextField();
        jtfMotivo = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblDescruceTablaMedicamento1 = new javax.swing.JTable();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jlblDescruceLoteSeleccionado2 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jlblDescruceCant2 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jtfDescruzeMedicamento1 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jlblDescruceLoteSeleccionado1 = new javax.swing.JLabel();
        jlblDescruceCant1 = new javax.swing.JLabel();
        jSpinnerCantidad2 = new javax.swing.JSpinner();
        jSpinnerCantidad1 = new javax.swing.JSpinner();
        jlblDescruceMedicamento1 = new javax.swing.JLabel();
        jlblDescruceMedicamento2 = new javax.swing.JLabel();
        jlblDescruceMotivo = new javax.swing.JLabel();
        jbtnVolver = new javax.swing.JButton();
        jbtnGuardarDescruce = new javax.swing.JButton();
        vistaLoteAcerrar = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblDetalleMedicamento = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jlblFechaVen = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jlblPF = new javax.swing.JLabel();
        jlblFF = new javax.swing.JLabel();
        jlblConc = new javax.swing.JLabel();
        jlblCodigoLote = new javax.swing.JLabel();
        jlblCantInicial = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jlblCantFinal = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jlblFechaAperturada = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnAbrirInventario3 = new javax.swing.JButton();
        vistaMedicamentesVer = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblLotesDelMedicamento = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jlblPFGeneral = new javax.swing.JLabel();
        jlblFFGeneral = new javax.swing.JLabel();
        jlblConcGeneral = new javax.swing.JLabel();
        jlblCantInicialGeneral = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jlblCantFinalGeneral = new javax.swing.JLabel();
        jlblFechaAperturadaGeneral = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbtnAbrirInventario4 = new javax.swing.JButton();
        jbtnGuardarCierreLote1 = new javax.swing.JButton();

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
        jLabel12.setText("CERRAR INVENTARIO MENSUAL");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(255, 255, 255));
        head2.setPreferredSize(new java.awt.Dimension(900, 56));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(890, 50));

        jlblAdvertencia.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jlblAdvertencia.setForeground(new java.awt.Color(153, 0, 0));
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setPreferredSize(new java.awt.Dimension(888, 40));
        jPanel7.add(jlblAdvertencia);

        head2.add(jPanel7);

        body.add(head2, java.awt.BorderLayout.PAGE_START);

        body2.setBackground(new java.awt.Color(255, 255, 255));
        body2.setMaximumSize(new java.awt.Dimension(1990, 650));
        body2.setMinimumSize(new java.awt.Dimension(200, 200));
        body2.setPreferredSize(new java.awt.Dimension(9900, 520));
        body2.setLayout(new java.awt.CardLayout());

        vistaRegistroLotes.setBackground(new java.awt.Color(255, 255, 255));
        vistaRegistroLotes.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 380));
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
        jtblVentas.setFocusCycleRoot(true);
        jtblVentas.setGridColor(new java.awt.Color(0, 0, 0));
        jtblVentas.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblVentas.setRequestFocusEnabled(false);
        jtblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblVentasMouseClicked(evt);
            }
        });
        jtblVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblVentasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblVentas);
        if (jtblVentas.getColumnModel().getColumnCount() > 0) {
            jtblVentas.getColumnModel().getColumn(3).setHeaderValue("Monto");
            jtblVentas.getColumnModel().getColumn(4).setHeaderValue("Monto Total");
            jtblVentas.getColumnModel().getColumn(5).setHeaderValue("Q. F.");
        }

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel14.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel14, java.awt.BorderLayout.LINE_END);

        jLabel18.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel18, java.awt.BorderLayout.LINE_START);

        jlblAdverte.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jlblAdverte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdverte.setText("Click en el Lote a Cerrar");
        jlblAdverte.setPreferredSize(new java.awt.Dimension(800, 40));
        jPanel9.add(jlblAdverte, java.awt.BorderLayout.PAGE_END);

        vistaRegistroLotes.add(jPanel9);

        jbtnCerrarInventario.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCerrarInventario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCerrarInventario.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCerrarInventario.setText("error");
        jbtnCerrarInventario.setPreferredSize(new java.awt.Dimension(400, 25));
        jbtnCerrarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarInventarioActionPerformed(evt);
            }
        });
        vistaRegistroLotes.add(jbtnCerrarInventario);

        jbtnDescruzar.setBackground(new java.awt.Color(255, 0, 0));
        jbtnDescruzar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnDescruzar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnDescruzar.setText("DESCRUZAR");
        jbtnDescruzar.setPreferredSize(new java.awt.Dimension(220, 25));
        jbtnDescruzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDescruzarActionPerformed(evt);
            }
        });
        vistaRegistroLotes.add(jbtnDescruzar);

        body2.add(vistaRegistroLotes, "card2");

        vistaDesCruce.setBackground(new java.awt.Color(255, 255, 255));
        vistaDesCruce.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(900, 395));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblDescruceTablaMedicamento2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblDescruceTablaMedicamento2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDescruceTablaMedicamento2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtblDescruceTablaMedicamento2);

        jPanel12.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 400, 90));

        jLabel49.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel49.setText("Conc:");
        jPanel12.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel54.setText("Lote Seleccionado:");
        jPanel12.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        jlblmasdas.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblmasdas.setText("Conc:");
        jPanel12.add(jlblmasdas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel56.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel56.setText("F.F");
        jPanel12.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel58.setText("Lotes");
        jPanel12.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        jLabel59.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel59.setText(" Medicamento:");
        jPanel12.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        jlblDescruceFF1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceFF1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceFF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jlblDescruceCon1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceCon1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceCon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jlblDescruceFF2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceFF2.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceFF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        jlblDescruceConc2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceConc2.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceConc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, -1));

        jLabel8.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel8.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 900, 10));

        jLabel9.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel9.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 900, 10));

        jLabel62.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel62.setText(" Medicamento:");
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jtfDescruceMedicamento2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDescruceMedicamento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescruceMedicamento2KeyReleased(evt);
            }
        });
        jPanel12.add(jtfDescruceMedicamento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 225, 25));

        jtfMotivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMotivoKeyReleased(evt);
            }
        });
        jPanel12.add(jtfMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 770, 25));

        jtblDescruceTablaMedicamento1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblDescruceTablaMedicamento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDescruceTablaMedicamento1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtblDescruceTablaMedicamento1);

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 400, 90));

        jLabel63.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel63.setText("Lotes");
        jPanel12.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        jLabel64.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel64.setText("F.F:");
        jPanel12.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jlblDescruceLoteSeleccionado2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceLoteSeleccionado2.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceLoteSeleccionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        jLabel66.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel66.setText("Motivo:");
        jPanel12.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jlblDescruceCant2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceCant2.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceCant2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        jLabel68.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel68.setText("Cant:");
        jPanel12.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        jtfDescruzeMedicamento1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDescruzeMedicamento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescruzeMedicamento1KeyReleased(evt);
            }
        });
        jPanel12.add(jtfDescruzeMedicamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 225, 25));

        jLabel69.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel69.setText("Lote Seleccionado:");
        jPanel12.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel70.setText("Cant:");
        jPanel12.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jlblDescruceLoteSeleccionado1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceLoteSeleccionado1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceLoteSeleccionado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jlblDescruceCant1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblDescruceCant1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel12.add(jlblDescruceCant1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jSpinnerCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSpinnerCantidad2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerCantidad2StateChanged(evt);
            }
        });
        jPanel12.add(jSpinnerCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 60, 25));

        jSpinnerCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSpinnerCantidad1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerCantidad1StateChanged(evt);
            }
        });
        jPanel12.add(jSpinnerCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 60, 25));

        jlblDescruceMedicamento1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblDescruceMedicamento1.setForeground(new java.awt.Color(255, 0, 0));
        jlblDescruceMedicamento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblDescruceMedicamento1.setText("*");
        jPanel12.add(jlblDescruceMedicamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 10, 25));

        jlblDescruceMedicamento2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblDescruceMedicamento2.setForeground(new java.awt.Color(255, 0, 0));
        jlblDescruceMedicamento2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblDescruceMedicamento2.setText("*");
        jPanel12.add(jlblDescruceMedicamento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 10, 25));

        jlblDescruceMotivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblDescruceMotivo.setForeground(new java.awt.Color(255, 0, 0));
        jlblDescruceMotivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblDescruceMotivo.setText("*");
        jPanel12.add(jlblDescruceMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, 10, 25));

        vistaDesCruce.add(jPanel12);

        jbtnVolver.setBackground(new java.awt.Color(0, 0, 0));
        jbtnVolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnVolver.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolver.setText(" Volver");
        jbtnVolver.setPreferredSize(new java.awt.Dimension(220, 25));
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });
        vistaDesCruce.add(jbtnVolver);

        jbtnGuardarDescruce.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarDescruce.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnGuardarDescruce.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarDescruce.setText("Guardar Cambio");
        jbtnGuardarDescruce.setPreferredSize(new java.awt.Dimension(220, 25));
        jbtnGuardarDescruce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarDescruceActionPerformed(evt);
            }
        });
        vistaDesCruce.add(jbtnGuardarDescruce);

        body2.add(vistaDesCruce, "card2");

        vistaLoteAcerrar.setBackground(new java.awt.Color(255, 255, 255));
        vistaLoteAcerrar.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(900, 395));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblDetalleMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtblDetalleMedicamento);

        jPanel10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 900, 170));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel37.setText("Cantidad Inicial:");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

        jlblFechaVen.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblFechaVen.setForeground(new java.awt.Color(0, 0, 255));
        jlblFechaVen.setText("error");
        jPanel10.add(jlblFechaVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel39.setText("F.F:");
        jPanel10.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel40.setText("Conc:");
        jPanel10.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel41.setText("Código Lote:");
        jPanel10.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel42.setText("Lista de Transacciones del Mes del P.F ");
        jPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel43.setText("Fecha Aperturada:");
        jPanel10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel44.setText("Nombre Medicamento:");
        jPanel10.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jlblPF.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblPF.setForeground(new java.awt.Color(0, 0, 255));
        jlblPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPF.setText("error");
        jPanel10.add(jlblPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 650, -1));

        jlblFF.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblFF.setForeground(new java.awt.Color(0, 0, 255));
        jlblFF.setText("sd");
        jPanel10.add(jlblFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jlblConc.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblConc.setForeground(new java.awt.Color(0, 0, 255));
        jlblConc.setText("error");
        jPanel10.add(jlblConc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jlblCodigoLote.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblCodigoLote.setForeground(new java.awt.Color(0, 0, 255));
        jlblCodigoLote.setText("error");
        jPanel10.add(jlblCodigoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        jlblCantInicial.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblCantInicial.setForeground(new java.awt.Color(0, 0, 255));
        jlblCantInicial.setText("error");
        jPanel10.add(jlblCantInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel38.setText("Cantidad Final:");
        jPanel10.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jlblCantFinal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblCantFinal.setForeground(new java.awt.Color(0, 0, 255));
        jlblCantFinal.setText("error");
        jPanel10.add(jlblCantFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel45.setText("Fecha Ven:");
        jPanel10.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jlblFechaAperturada.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 22)); // NOI18N
        jlblFechaAperturada.setForeground(new java.awt.Color(0, 0, 255));
        jlblFechaAperturada.setText("error");
        jlblFechaAperturada.setPreferredSize(new java.awt.Dimension(45, 344));
        jPanel10.add(jlblFechaAperturada, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 190, 25));

        jLabel4.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel4.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 900, 10));

        jLabel5.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel5.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 900, 10));

        vistaLoteAcerrar.add(jPanel10);

        jbtnAbrirInventario3.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAbrirInventario3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAbrirInventario3.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAbrirInventario3.setText("Volver");
        jbtnAbrirInventario3.setPreferredSize(new java.awt.Dimension(220, 25));
        jbtnAbrirInventario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAbrirInventario3ActionPerformed(evt);
            }
        });
        vistaLoteAcerrar.add(jbtnAbrirInventario3);

        body2.add(vistaLoteAcerrar, "card2");

        vistaMedicamentesVer.setBackground(new java.awt.Color(255, 255, 255));
        vistaMedicamentesVer.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(900, 395));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblLotesDelMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblLotesDelMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblLotesDelMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtblLotesDelMedicamento);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 900, 170));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel46.setText("Cantidad Inicial:");
        jPanel11.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

        jLabel47.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel47.setText("Forma Farmaceutica:");
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel48.setText("Concentración:");
        jPanel11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel50.setText("Lotes");
        jPanel11.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel51.setText("Fecha Aperturada:");
        jPanel11.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel52.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel52.setText("Nombre Medicamento:");
        jPanel11.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jlblPFGeneral.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblPFGeneral.setForeground(new java.awt.Color(0, 0, 255));
        jlblPFGeneral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPFGeneral.setText("error");
        jPanel11.add(jlblPFGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 650, -1));

        jlblFFGeneral.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblFFGeneral.setForeground(new java.awt.Color(0, 0, 255));
        jlblFFGeneral.setText("error");
        jPanel11.add(jlblFFGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jlblConcGeneral.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblConcGeneral.setForeground(new java.awt.Color(0, 0, 255));
        jlblConcGeneral.setText("error");
        jPanel11.add(jlblConcGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        jlblCantInicialGeneral.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblCantInicialGeneral.setForeground(new java.awt.Color(0, 0, 255));
        jlblCantInicialGeneral.setText("error");
        jPanel11.add(jlblCantInicialGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, -1));

        jLabel53.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel53.setText("Cantidad Final:");
        jPanel11.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jlblCantFinalGeneral.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblCantFinalGeneral.setForeground(new java.awt.Color(0, 0, 255));
        jlblCantFinalGeneral.setText("error");
        jPanel11.add(jlblCantFinalGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, -1, -1));

        jlblFechaAperturadaGeneral.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 22)); // NOI18N
        jlblFechaAperturadaGeneral.setForeground(new java.awt.Color(0, 0, 255));
        jlblFechaAperturadaGeneral.setText("error");
        jlblFechaAperturadaGeneral.setPreferredSize(new java.awt.Dimension(45, 344));
        jPanel11.add(jlblFechaAperturadaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 190, 25));

        jLabel6.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel6.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 900, 10));

        jLabel7.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel7.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 900, 10));

        vistaMedicamentesVer.add(jPanel11);

        jbtnAbrirInventario4.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAbrirInventario4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAbrirInventario4.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAbrirInventario4.setText("Volver");
        jbtnAbrirInventario4.setPreferredSize(new java.awt.Dimension(220, 25));
        jbtnAbrirInventario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAbrirInventario4ActionPerformed(evt);
            }
        });
        vistaMedicamentesVer.add(jbtnAbrirInventario4);

        jbtnGuardarCierreLote1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarCierreLote1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnGuardarCierreLote1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarCierreLote1.setText("Guardar");
        jbtnGuardarCierreLote1.setPreferredSize(new java.awt.Dimension(220, 25));
        jbtnGuardarCierreLote1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarCierreLote1ActionPerformed(evt);
            }
        });
        vistaMedicamentesVer.add(jbtnGuardarCierreLote1);

        body2.add(vistaMedicamentesVer, "card2");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    RegistroMensualLotes objRegistroMensualLotes;
    RegistroMensualInventario objRegistroMensualInventario;
    private void jtblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblVentasMouseClicked
        if(Lista_Registro_Mensual.get(0).getFecha_cierra()!=null){           
            objRegistroMensualInventario=(RegistroMensualInventario)jtblVentas.getValueAt(jtblVentas.getSelectedRow(),1);
            jlblPFGeneral.setText(objRegistroMensualInventario.getInventario().getMedicamento().getNombre());
            jlblFFGeneral.setText(objRegistroMensualInventario.getInventario().getMedicamento().getForma_farmaceutica());
            jlblConcGeneral.setText(objRegistroMensualInventario.getInventario().getMedicamento().getConcentracion());
            jlblCantInicialGeneral.setText(objRegistroMensualInventario.getCantidad_inicial()+"");
            jlblCantFinalGeneral.setText(objRegistroMensualInventario.getInventario().getCantidad()+"");
            jlblFechaAperturadaGeneral.setText(Herramienta.formatoFechaHoraMas1(objRegistroMensualInventario.getFecha_apertura_real()));
            //
            List<RegistroMensualLotes> objListaRegLotes=new ArrayList<>();
            for (RegistroMensualLotes registroMensualLotes : Lista_Registro_Mensual) {
                if(registroMensualLotes.getRegistroMensualInventario()==objRegistroMensualInventario){
                   objListaRegLotes.add(registroMensualLotes); 
                }
            }
            llenarTablaMedicamentosDeLotes(objListaRegLotes);            
            //            
            vistaRegistroLotes.setVisible(false);
            vistaMedicamentesVer.setVisible(true); 
        }
        else{
            objRegistroMensualLotes=(RegistroMensualLotes)jtblVentas.getValueAt(jtblVentas.getSelectedRow(),0);
            jlblPF.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getNombre());
            jlblFF.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getForma_farmaceutica());
            jlblConc.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getConcentracion());
            jlblCantFinal.setText(objRegistroMensualLotes.getLote_detalle().getCantidad()+"");
            jlblCantInicial.setText(objRegistroMensualLotes.getCantidad_inicial()+"");
            jlblCodigoLote.setText(objRegistroMensualLotes.getLote_detalle().getCodigo());
            jlblFechaAperturada.setText(Herramienta.formatoFechaHoraMas1(objRegistroMensualLotes.getFecha_apertura_real()));
            jlblFechaVen.setText(Herramienta.formatoFechaMas1(objRegistroMensualLotes.getLote_detalle().getFecha_vencimiento()));
            List<Detalle_Medicamentos> lista_Medicamentos_del_mes=
            Herramienta.findbyBeetWeen(Detalle_Medicamentos.class,"fecha", objRegistroMensualLotes.getFecha_apertura_real(), new Date(), jpa, objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle());
            List<Descruce> lista_Descruce=jpa.createQuery(
                    "select p from Descruce p where id_Lote_detalle="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()+" or id_Lote_detalle2="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()).getResultList();
            
            List<Descarga> lista_Descarga=jpa
            .createQuery("select p from Descarga p where month(fecha)>="+(objRegistroMensualLotes.getFecha_apertura().getMonth()+1)+"and id_Lote_detalle="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()).getResultList();
        
            llenarTablaDetalleMedicamento(lista_Medicamentos_del_mes,lista_Descruce,lista_Descarga);
            vistaRegistroLotes.setVisible(false);
            vistaLoteAcerrar.setVisible(true);
            }        
    }//GEN-LAST:event_jtblVentasMouseClicked

    private void jbtnAbrirInventario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAbrirInventario3ActionPerformed
        vistaLoteAcerrar.setVisible(false);
        vistaMedicamentesVer.setVisible(Lista_Registro_Mensual.get(0).getFecha_cierra()!=null);
        vistaRegistroLotes.setVisible(Lista_Registro_Mensual.get(0).getFecha_cierra()==null);
    }//GEN-LAST:event_jbtnAbrirInventario3ActionPerformed

    private void jbtnCerrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarInventarioActionPerformed

        int confirmado = JOptionPane.showConfirmDialog(jlblAdvertencia,
                "Si cierra ya no podrá entregar medicamentos hasta que inventaríe todos los medicamentos ¿Está seguro de continuar?");
            if (JOptionPane.OK_OPTION == confirmado){
                jpa.getTransaction().begin();                
                for (RegistroMensualLotes registroMensualLotes : Lista_Registro_Mensual){
                    registroMensualLotes.setFecha_cierra(new Date());
                    jpa.persist(registroMensualLotes);
                    }
                for (RegistroMensualInventario registroMensualInventario : Lista_Mensual_Inventario){
                    registroMensualInventario.setFecha_cierra(new Date());
                    jpa.persist(registroMensualInventario);
                    }
                jpa.flush();
                JOptionPane.showMessageDialog(jPanel7, "se cerró con exito");
                ConsultaBD();
                jpa.getTransaction().commit();                
                }
            
            else{
                System.out.println("vale... no borro nada...");}
        
    }//GEN-LAST:event_jbtnCerrarInventarioActionPerformed

    private void jbtnAbrirInventario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAbrirInventario4ActionPerformed
        vistaMedicamentesVer.setVisible(false);
        vistaRegistroLotes.setVisible(true);
    }//GEN-LAST:event_jbtnAbrirInventario4ActionPerformed

   
    private void jtblLotesDelMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLotesDelMedicamentoMouseClicked

        objRegistroMensualLotes=(RegistroMensualLotes)jtblLotesDelMedicamento.getValueAt(jtblLotesDelMedicamento.getSelectedRow(),0);
        jlblPF.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getNombre());
        jlblFF.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getForma_farmaceutica());
        jlblConc.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getConcentracion());
        jlblCodigoLote.setText(objRegistroMensualLotes.getLote_detalle().getCodigo());
        jlblCantInicial.setText(objRegistroMensualLotes.getCantidad_inicial()+"");
        jlblCantFinal.setText(objRegistroMensualLotes.getLote_detalle().getCantidad()+"");
        jlblFechaAperturada.setText(Herramienta.formatoFechaMas1(objRegistroMensualLotes.getFecha_apertura()));
        jlblFechaVen.setText(Herramienta.formatoFechaMas1(objRegistroMensualLotes.getLote_detalle().getFecha_vencimiento()));
        List<Detalle_Medicamentos> lista_Medicamentos_del_mes=
            Herramienta.findbyBeetWeen(Detalle_Medicamentos.class,"fecha", objRegistroMensualLotes.getFecha_apertura_real(), new Date(), jpa, objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle());
        List<Descruce> lista_Descruce=jpa.createQuery(
                    "select p from Descruce p where month(fecha_registro)="+(objRegistroMensualLotes.getFecha_apertura().getMonth()+1)+"and (id_Lote_detalle="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()+" or id_Lote_detalle2="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()+")").getResultList();
            
        List<Descarga> lista_Descarga=jpa
        .createQuery("select p from Descarga p where month(fecha)>="+(objRegistroMensualLotes.getFecha_apertura().getMonth()+1)+"and id_Lote_detalle="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()).getResultList();
        
        llenarTablaDetalleMedicamento(lista_Medicamentos_del_mes,lista_Descruce,lista_Descarga);
        vistaMedicamentesVer.setVisible(false);
        vistaLoteAcerrar.setVisible(true);

        
    }//GEN-LAST:event_jtblLotesDelMedicamentoMouseClicked

    private void jbtnGuardarCierreLote1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarCierreLote1ActionPerformed
        //maybe
        jpa.getTransaction().begin();
        objRegistroMensualInventario.setCantidad_final(objRegistroMensualInventario.getInventario().getCantidad());
        jpa.createQuery("update RegistroMensualInventario set id_Usuario_cierre= "+objUsuario.getId_Usuario()+" where id_Registro_mensual_inventario= "+objRegistroMensualInventario.getId_Registro_mensual_Inventario()).executeUpdate();
        objRegistroMensualInventario.setFecha_cierre_real(new Date());
        jpa.persist(objRegistroMensualInventario);
        int auxCant=0;
        for (RegistroMensualLotes registroMensualLotes : Lista_Registro_Mensual){
            if(registroMensualLotes.getRegistroMensualInventario()==objRegistroMensualInventario){
                registroMensualLotes.setFecha_cierre_real(new Date());
                jpa.createQuery("update RegistroMensualLotes set id_Usuario_cierre= "+objUsuario.getId_Usuario()+" where id_Registro_mensual_lotes= "+registroMensualLotes.getId_Registro_mensual_lotes()).executeUpdate();
                registroMensualLotes.setCantidad_final(registroMensualLotes.getLote_detalle().getCantidad());
                jpa.persist(registroMensualLotes);
                auxCant=auxCant+registroMensualLotes.getLote_detalle().getCantidad();
                }      
            }//fin for 
        if(objRegistroMensualInventario.getCantidad_final()!=auxCant){
            JOptionPane.showMessageDialog(jPanel7, "no coincide la suma total de los lotes finales con el inventario final");
            jpa.getTransaction().rollback();
            }//fin if
        JOptionPane.showMessageDialog(jPanel7, "Guardado con Exito");
        if(Lista_Mensual_Inventario.size()==1){
            JOptionPane.showMessageDialog(jPanel7, "¿desea imprimir el reporte del mes"+Herramienta.getNombreMes(Lista_Mensual_Inventario.get(0).getFecha_apertura().getMonth()+1)+"?");
            
            int confirmado = JOptionPane.showConfirmDialog(jlblAdvertencia,"¿Desea Imprimir el cierre de inventario?");
            if (JOptionPane.OK_OPTION == confirmado){
                try {                
                    Date Fe=new Date();
                    imprimirInventarioApertura(Fe,Lista_Registro_Mensual.get(0));
                    String url="Carpeta_de_Archivos\\Inventario_Cierre"+(Fe.getYear()+1900)+"_"+Fe.getMonth()+"_"+Fe.getDate()+".pdf";
                    ProcessBuilder p=new ProcessBuilder();
                    p.command("cmd.exe","/c",url);
                    p.start();            
                    } catch (IOException ex) {
                        Logger.getLogger(ServicioFarmacia.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            else{
                System.out.println("vale... no borro nada...");}
        
        }
        ConsultaBD();
        vistaMedicamentesVer.setVisible(false);
        vistaRegistroLotes.setVisible(true);
        jpa.getTransaction().commit();
        
        
        //objRegistroMensualInventario;
    }//GEN-LAST:event_jbtnGuardarCierreLote1ActionPerformed

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed
        vistaDesCruce.setVisible(false);
        vistaRegistroLotes.setVisible(true);
        limpiarDescruce();
        jlblAdvertencia.setText("Inventaríe los medicamentos, correspondientes al mes de "+Herramienta.getNombreMes(Lista_Registro_Mensual.get(0).getFecha_apertura().getMonth()+1));


        
    }//GEN-LAST:event_jbtnVolverActionPerformed

    List<RegistroMensualInventario> Lista_Inventario_Descruce;
    private void jbtnDescruzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDescruzarActionPerformed
        Lista_Inventario_Descruce=jpa.createQuery("select p from RegistroMensualInventario p where Month(fecha_apertura)="+(Lista_Mensual_Inventario.get(0).getFecha_apertura().getMonth()+1) ).getResultList();
        vistaRegistroLotes.setVisible(false);
        vistaDesCruce.setVisible(true);
        jlblAdvertencia.setText("Descruce");
        autoCompleterDescruceMedicamento1.removeAllItems();
        for (RegistroMensualInventario registroMensualInventario : Lista_Inventario_Descruce){
            autoCompleterDescruceMedicamento1.addItem(registroMensualInventario.getInventario());
        }
                
        autoCompleterDescruceMedicamento2.removeAllItems();
        for (RegistroMensualInventario registroMensualInventario : Lista_Inventario_Descruce) {
            autoCompleterDescruceMedicamento2.addItem(registroMensualInventario.getInventario());            
        }
        
        
    }//GEN-LAST:event_jbtnDescruzarActionPerformed

    private void jbtnGuardarDescruceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarDescruceActionPerformed
        if(jlblDescruceMedicamento1.getText().isEmpty()&&jlblDescruceMedicamento2.getText().isEmpty()
                && jlblDescruceMotivo.getText().isEmpty()){
        Descruce objDescruce=new Descruce();
        objDescruce.setCantidad((int)jSpinnerCantidad1.getValue());
        objDescruce.setLote_detalle(objLote_Detalle1);
        objDescruce.setCantidad2((int)jSpinnerCantidad2.getValue());
        objDescruce.setLote_detalle2(objLote_Detalle2);
        objLote_Detalle1.setCantidad(objLote_Detalle1.getCantidad()+((int)jSpinnerCantidad1.getValue()));
        objLote_Detalle1.getInventario().setCantidad(objLote_Detalle1.getInventario().getCantidad()+((int)jSpinnerCantidad1.getValue()));
        
        objLote_Detalle2.setCantidad(objLote_Detalle2.getCantidad()+((int)jSpinnerCantidad2.getValue()));
        objLote_Detalle2.getInventario().setCantidad(objLote_Detalle2.getInventario().getCantidad()+((int)jSpinnerCantidad2.getValue()));
 
        objDescruce.setFecha_registro(new Date());
        objDescruce.setMotivo(jtfMotivo.getText());
        objDescruce.setUsuario(objUsuario);
        objDescruce.setMes_Descruce(Lista_Mensual_Inventario.get(0).getFecha_apertura().getMonth()+1);
        jpa.getTransaction().begin();        
        jpa.persist(objDescruce);
        limpiarDescruce();
        jpa.flush();
        ConsultaBD();
        principalEjecucion();
        JOptionPane.showMessageDialog(jPanel7, "Guardado con exito");
        jpa.getTransaction().commit();}
        else{
            JOptionPane.showMessageDialog(jPanel7, "Llene los espacios con *");
        }
        
    }//GEN-LAST:event_jbtnGuardarDescruceActionPerformed

    public void limpiarDescruce(){
        jtfDescruzeMedicamento1.setText("");
        jlblDescruceMedicamento1.setText("*");
        jtfDescruceMedicamento2.setText("");
        jlblDescruceMedicamento2.setText("*");
        jlblDescruceCant1.setText("");
        jlblDescruceCant2.setText("");
        jlblDescruceCon1.setText("");
        jlblDescruceConc2.setText("");
        jlblDescruceFF1.setText("");
        jlblDescruceFF2.setText("");
        jlblDescruceLoteSeleccionado1.setText("");
        jlblDescruceLoteSeleccionado2.setText("");
        llenarLotesMedicamento1(new ArrayList<Lote_detalle>());
        llenarLotesMedicamento2(new ArrayList<Lote_detalle>());
        
        
    }
    private void jtfDescruzeMedicamento1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescruzeMedicamento1KeyReleased

        
        for (RegistroMensualInventario registroMensualInventario : Lista_Inventario_Descruce){
            if(registroMensualInventario.getInventario().getMedicamento().getNombre().equals(jtfDescruzeMedicamento1.getText())){
                List<Lote_detalle> lista_Lotes=jpa.createQuery("select p from Lote_detalle p where id_Inventario="+
                registroMensualInventario.getInventario().getId_Inventario()).getResultList();
                jlblDescruceFF1.setText(registroMensualInventario.getInventario().getMedicamento().getForma_farmaceutica());
                jlblDescruceCon1.setText(registroMensualInventario.getInventario().getMedicamento().getConcentracion());
                llenarLotesMedicamento1(lista_Lotes);
                jlblDescruceMedicamento1.setText("");
                break;
                }
            jlblDescruceFF1.setText("");
            jlblDescruceCon1.setText("");
            jlblDescruceMedicamento1.setText("*");
            llenarLotesMedicamento1(new ArrayList<Lote_detalle>());
            }      
    }//GEN-LAST:event_jtfDescruzeMedicamento1KeyReleased

    Lote_detalle objLote_Detalle1;
    Lote_detalle objLote_Detalle2;
    
        
    private void jtblDescruceTablaMedicamento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDescruceTablaMedicamento1MouseClicked
        //maybe
        objLote_Detalle1=(Lote_detalle)jtblDescruceTablaMedicamento1.getValueAt(jtblDescruceTablaMedicamento1.getSelectedRow(),0);
        jlblDescruceLoteSeleccionado1.setText(objLote_Detalle1.getCodigo());
        jlblDescruceCant1.setText(objLote_Detalle1.getCantidad()+"");  
        jlblDescruceCant2.setText(objLote_Detalle2.getCantidad()+"");
        jSpinnerCantidad1.setValue(0);
        jSpinnerCantidad2.setValue(0);
        
    }//GEN-LAST:event_jtblDescruceTablaMedicamento1MouseClicked

    private void jtfDescruceMedicamento2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescruceMedicamento2KeyReleased
        for (RegistroMensualInventario registroMensualInventario : Lista_Inventario_Descruce){
            if(registroMensualInventario.getInventario().getMedicamento().getNombre().equals(jtfDescruceMedicamento2.getText())){
                List<Lote_detalle> lista_Lotes=jpa.createQuery("select p from Lote_detalle p where id_Inventario="+
                registroMensualInventario.getInventario().getId_Inventario()).getResultList();
                jlblDescruceFF2.setText(registroMensualInventario.getInventario().getMedicamento().getForma_farmaceutica());
                jlblDescruceConc2.setText(registroMensualInventario.getInventario().getMedicamento().getConcentracion());
                llenarLotesMedicamento2(lista_Lotes);
                jlblDescruceMedicamento2.setText("");
                break;
                }
            jlblDescruceMedicamento2.setText("*");
            jlblDescruceFF2.setText("");
            jlblDescruceConc2.setText("");
            llenarLotesMedicamento2(new ArrayList<Lote_detalle>());
            } 
    }//GEN-LAST:event_jtfDescruceMedicamento2KeyReleased

    private void jtblDescruceTablaMedicamento2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDescruceTablaMedicamento2MouseClicked
        objLote_Detalle2=(Lote_detalle)jtblDescruceTablaMedicamento2.getValueAt(jtblDescruceTablaMedicamento2.getSelectedRow(),0);
        jlblDescruceLoteSeleccionado2.setText(objLote_Detalle2.getCodigo());
        jlblDescruceCant2.setText(objLote_Detalle2.getCantidad()+"");
        jlblDescruceCant1.setText(objLote_Detalle1.getCantidad()+"");
        
        jSpinnerCantidad1.setValue(0);
        jSpinnerCantidad2.setValue(0);
        
        
    }//GEN-LAST:event_jtblDescruceTablaMedicamento2MouseClicked

       SpinnerNumberModel modeloSpinner1 = new SpinnerNumberModel();
       SpinnerNumberModel modeloSpinner2 = new SpinnerNumberModel();
        //modeloSpinner
        //modeloSpinner.setMinimum(0);
        //spnValor.setModel(modeloSpinner);
    private void jSpinnerCantidad1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerCantidad1StateChanged
        modeloSpinner2.setMinimum(-objLote_Detalle2.getCantidad());
        modeloSpinner2.setMaximum(objLote_Detalle1.getCantidad());
        jSpinnerCantidad2.setModel(modeloSpinner2);
        jSpinnerCantidad2.setValue(-(int)jSpinnerCantidad1.getValue());
        jlblDescruceCant2.setText((objLote_Detalle2.getCantidad()+(int)jSpinnerCantidad2.getValue())+"");
        ((JSpinner.DefaultEditor)jSpinnerCantidad1.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)jSpinnerCantidad2.getEditor()).getTextField().setEditable(false);
        
        
        

    }//GEN-LAST:event_jSpinnerCantidad1StateChanged

    private void jSpinnerCantidad2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerCantidad2StateChanged

        modeloSpinner1.setMinimum(-objLote_Detalle1.getCantidad());
        modeloSpinner1.setMaximum(objLote_Detalle2.getCantidad());
        jSpinnerCantidad1.setModel(modeloSpinner1);
        jSpinnerCantidad1.setValue(-(int)jSpinnerCantidad2.getValue());
        jlblDescruceCant1.setText((objLote_Detalle1.getCantidad()+(int)jSpinnerCantidad1.getValue())+"");
        ((JSpinner.DefaultEditor)jSpinnerCantidad1.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)jSpinnerCantidad2.getEditor()).getTextField().setEditable(false);
    }//GEN-LAST:event_jSpinnerCantidad2StateChanged

    private void jtfMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMotivoKeyReleased
        if(jtfMotivo.getText().length()>0){
            jlblDescruceMotivo.setText("");
        }
        else{
            jlblDescruceMotivo.setText("*");
        }
    }//GEN-LAST:event_jtfMotivoKeyReleased

    private void jtblVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblVentasKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(Lista_Registro_Mensual.get(0).getFecha_cierra()!=null){           
            objRegistroMensualInventario=(RegistroMensualInventario)jtblVentas.getValueAt(jtblVentas.getSelectedRow(),1);
            jlblPFGeneral.setText(objRegistroMensualInventario.getInventario().getMedicamento().getNombre());
            jlblFFGeneral.setText(objRegistroMensualInventario.getInventario().getMedicamento().getForma_farmaceutica());
            jlblConcGeneral.setText(objRegistroMensualInventario.getInventario().getMedicamento().getConcentracion());
            jlblCantInicialGeneral.setText(objRegistroMensualInventario.getCantidad_inicial()+"");
            jlblCantFinalGeneral.setText(objRegistroMensualInventario.getInventario().getCantidad()+"");
            jlblFechaAperturadaGeneral.setText(Herramienta.formatoFechaHoraMas1(objRegistroMensualInventario.getFecha_apertura_real()));
            //
            List<RegistroMensualLotes> objListaRegLotes=new ArrayList<>();
            for (RegistroMensualLotes registroMensualLotes : Lista_Registro_Mensual) {
                if(registroMensualLotes.getRegistroMensualInventario()==objRegistroMensualInventario){
                   objListaRegLotes.add(registroMensualLotes); 
                }
            }
            llenarTablaMedicamentosDeLotes(objListaRegLotes);            
            //            
            vistaRegistroLotes.setVisible(false);
            vistaMedicamentesVer.setVisible(true); 
        }
        else{
            objRegistroMensualLotes=(RegistroMensualLotes)jtblVentas.getValueAt(jtblVentas.getSelectedRow(),0);
            jlblPF.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getNombre());
            jlblFF.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getForma_farmaceutica());
            jlblConc.setText(objRegistroMensualLotes.getLote_detalle().getInventario().getMedicamento().getConcentracion());
            jlblCantFinal.setText(objRegistroMensualLotes.getLote_detalle().getCantidad()+"");
            jlblCantInicial.setText(objRegistroMensualLotes.getCantidad_inicial()+"");
            jlblCodigoLote.setText(objRegistroMensualLotes.getLote_detalle().getCodigo());
            jlblFechaAperturada.setText(Herramienta.formatoFechaHoraMas1(objRegistroMensualLotes.getFecha_apertura_real()));
            jlblFechaVen.setText(Herramienta.formatoFechaMas1(objRegistroMensualLotes.getLote_detalle().getFecha_vencimiento()));
            List<Detalle_Medicamentos> lista_Medicamentos_del_mes=
            Herramienta.findbyBeetWeen(Detalle_Medicamentos.class,"fecha", objRegistroMensualLotes.getFecha_apertura_real(), new Date(), jpa, objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle());
            List<Descruce> lista_Descruce=jpa.createQuery(
                    "select p from Descruce p where id_Lote_detalle="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()+" or id_Lote_detalle2="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()).getResultList();
            
            List<Descarga> lista_Descarga=jpa
            .createQuery("select p from Descarga p where month(fecha)>="+(objRegistroMensualLotes.getFecha_apertura().getMonth()+1)+"and id_Lote_detalle="+objRegistroMensualLotes.getLote_detalle().getId_Lote_detalle()).getResultList();
        
            llenarTablaDetalleMedicamento(lista_Medicamentos_del_mes,lista_Descruce,lista_Descarga);
            vistaRegistroLotes.setVisible(false);
            vistaLoteAcerrar.setVisible(true);
            }            
        }
    }//GEN-LAST:event_jtblVentasKeyPressed

    //
    public void llenarLotesMedicamento2(List<Lote_detalle> Lista_lote){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Código","Cantidad"};
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
             for (Lote_detalle objLote : Lista_lote){
                 fila_actividad[0]=objLote;
                 fila_actividad[1]=objLote.getCantidad();
                 //fila_actividad[3]=objRegistro.getLote_detalle().getPrecio_Venta_Redondeado();  
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblDescruceTablaMedicamento2.setModel(modelo); 
            jtblDescruceTablaMedicamento2.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblDescruceTablaMedicamento2.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblDescruceTablaMedicamento2.getColumnModel().getColumn(1).setCellRenderer(tcr);
            
            jtblDescruceTablaMedicamento2.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblDescruceTablaMedicamento2.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblDescruceTablaMedicamento2.getTableHeader().setBackground(Color.BLUE);
            jtblDescruceTablaMedicamento2.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblDescruceTablaMedicamento2.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtblDescruceTablaMedicamento2.getColumnModel().getColumn(1).setPreferredWidth(50);
            ((DefaultTableCellRenderer)jtblDescruceTablaMedicamento2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64      
    }
    public void llenarLotesMedicamento1(List<Lote_detalle> Lista_lote){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Código","Cantidad"};
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
             for (Lote_detalle objLote : Lista_lote){
                 fila_actividad[0]=objLote;
                 fila_actividad[1]=objLote.getCantidad();
                 //fila_actividad[3]=objRegistro.getLote_detalle().getPrecio_Venta_Redondeado();  
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblDescruceTablaMedicamento1.setModel(modelo); 
            jtblDescruceTablaMedicamento1.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblDescruceTablaMedicamento1.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblDescruceTablaMedicamento1.getColumnModel().getColumn(1).setCellRenderer(tcr);
            
            jtblDescruceTablaMedicamento1.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblDescruceTablaMedicamento1.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblDescruceTablaMedicamento1.getTableHeader().setBackground(Color.BLUE);
            jtblDescruceTablaMedicamento1.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblDescruceTablaMedicamento1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtblDescruceTablaMedicamento1.getColumnModel().getColumn(1).setPreferredWidth(50);
            ((DefaultTableCellRenderer)jtblDescruceTablaMedicamento1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64      
    }
    //
    public void imprimirInventarioApertura(Date Fe,RegistroMensualLotes obj) throws MalformedURLException, IOException{
        
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        PdfWriter writer=null;
        try {
             writer=new PdfWriter
                ("Carpeta_de_Archivos\\Inventario_Cierre"+(Fe.getYear()+1900)+"_"+Fe.getMonth()+"_"+Fe.getDate()+".pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");
        }  
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());     
        EventoPagina evento = new EventoPagina(document);
        // Indicamos que el manejador se encargara del evento END_PAGE
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
        document.setMargins(75, 36, 75, 36);    
        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Paragraph paragIma=new Paragraph("     ").add(unsch).add("                                    CIERRE DE INVENTARIO PARA EL MES DE "+Herramienta.getNombreMes((Fe.getMonth()+1)) ).setFontSize(16).setFont(bold);  
        document.add(paragIma); 
        int HeadTamaño=9;
        int Tamaño=7;
        //Paragraph parag2=new Paragraph("Servicio Farmacia                                                                                                                                                                 "+Herramienta.formatoFechaHoraMas1(new Date()));         
        //document.add(parag2);
        System.out.println(obj.getFecha_apertura().getMonth()+"-------------------------");
        List<RegistroMensualLotes> listaRegistroMensualImprimir=
                jpa.createQuery("select p from RegistroMensualLotes p where Month(fecha_apertura)="+((obj.getFecha_apertura().getMonth())+1)).getResultList();
        System.out.println(listaRegistroMensualImprimir.size()+"asdasd");
        for (Rol Origen : Lista_Origen){
        boolean auxAgregar=false;
        Table table = new Table(new float[]{19,7,6,11,11,8,11,11,11,11,11});
        table.setWidthPercent(100);                 
        document.add(new Paragraph(" "));    
        table.addHeaderCell(new Cell().add(new Paragraph("Producto Farmacéutico").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        table.addHeaderCell(new Cell().add(new Paragraph("Conc.").setFont(bold)).setFontSize(HeadTamaño).setTextAlignment(TextAlignment.CENTER));         
        table.addHeaderCell(new Cell().add(new Paragraph("F.F").setFont(bold)).setFontSize(HeadTamaño).setTextAlignment(TextAlignment.CENTER));        
        table.addHeaderCell(new Cell().add(new Paragraph("Lab.").setFont(bold)).setFontSize(HeadTamaño).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Lote").setFont(bold)).setFontSize(HeadTamaño).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("P.A").setFont(bold)).setFontSize(HeadTamaño).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Fecha Venc.").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("FACTURA").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Proveedor").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Stock Inicial").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Stock Final").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER)); 
                
//table.addHeaderCell(new Cell().add(new Paragraph("STOCK FINAL").setFont(bold)).setTextAlignment(TextAlignment.CENTER));              
        Collections.sort(listaRegistroMensualImprimir);//ordenando A-Z (método como Override)
        for (RegistroMensualLotes Lote_RegistroCierre : listaRegistroMensualImprimir){
            if(Lote_RegistroCierre.getLote_detalle().getInventario().getMedicamento().getRolorigen()==Origen){
                auxAgregar=true;
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getInventario().getMedicamento().getNombre()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.LEFT));//P.F
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getInventario().getMedicamento().getConcentracion()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//Conc
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getInventario().getMedicamento().getForma_farmaceutica()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//FF
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getRolFabricante().getNombre_rol()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//labo
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getCodigo()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//lote
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getPrecio_Venta_Redondeado()+"").setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//P.A
            if(Lote_RegistroCierre.getLote_detalle().getFecha_vencimiento().getTime()-(new Date()).getTime()>=0){
                if((Lote_RegistroCierre.getLote_detalle().getFecha_vencimiento().getTime()-(new Date()).getTime())/86400000 <=6*30){
                    table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_RegistroCierre.getLote_detalle().getFecha_vencimiento())).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.YELLOW));
                    }
                else{
                    table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_RegistroCierre.getLote_detalle().getFecha_vencimiento())).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.WHITE));
                    }
            }
            else{
                table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_RegistroCierre.getLote_detalle().getFecha_vencimiento())).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.RED));
                }
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getFactura().getCodigo_factura()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getFactura().getRolProveedor().getNombre_rol()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            table.addCell(new Paragraph(Lote_RegistroCierre.getCantidad_inicial()+"").setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            table.addCell(new Paragraph(Lote_RegistroCierre.getLote_detalle().getCantidad()+"").setFont(font).setFontSize(Tamaño).setTextAlignment(TextAlignment.CENTER));//stock final
            
//table.addCell(new Paragraph(Integer.toString(Lote_RegistroCierre.getLote_detalle().getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
    
        }}
        if(auxAgregar){
            Paragraph asd=new Paragraph(Origen.getNombre_rol()).setTextAlignment(TextAlignment.CENTER).setFont(bold).setFontSize(14);
            document.add(asd);
            document.add(table);}
        
    }
        
        Paragraph parag3=new Paragraph("Descruces").setTextAlignment(TextAlignment.CENTER).setFont(bold).setFontSize(14);        
        Table tableDescruce = new Table(new float[]{10,7,8,7,8,20,10});
        tableDescruce.setWidthPercent(100);
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Fecha Descruce").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Lote 1").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Cantidad 1").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Lote 2").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Cantidad 2").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Motivo").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Usuario").setFontSize(HeadTamaño).setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        
        List<Descruce> Lista_Descruce=jpa.createQuery("select p from Descruce p where mes>="+(listaRegistroMensualImprimir.get(0).getFecha_apertura().getMonth()+1) ).getResultList();
        for (Descruce descruce : Lista_Descruce) {
            tableDescruce.addCell(new Paragraph(Herramienta.formatoFechaHoraMas1(descruce.getFecha_registro())).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescruce.addCell(new Paragraph(descruce.getLote_detalle().getCodigo()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescruce.addCell(new Paragraph(descruce.getCantidad()+"").setFont(font).setFontSize(Tamaño).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescruce.addCell(new Paragraph(descruce.getLote_detalle2().getCodigo()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescruce.addCell(new Paragraph(descruce.getCantidad2()+"").setFont(font).setFontSize(Tamaño).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescruce.addCell(new Paragraph(descruce.getMotivo()).setFont(font).setFontSize(Tamaño).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescruce.addCell(new Paragraph(descruce.getUsuario().getPersona().getInfoPersona()).setFontSize(Tamaño).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
        }        
        if(!Lista_Descruce.isEmpty()){
            document.add(parag3);document.add(tableDescruce);
            }
        
        Paragraph parag4=new Paragraph("DESCARGA").setTextAlignment(TextAlignment.CENTER).setFont(bold).setFontSize(14);        
        Table tableDescarga = new Table(new float[]{10,7,8,7,8,20});
        int HeadTam=11;
        int Tam=9;
                
                
        tableDescarga.setWidthPercent(100);
        tableDescarga.addHeaderCell(new Cell().add(new Paragraph("Fecha Descarga").setFontSize(HeadTam).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        tableDescarga.addHeaderCell(new Cell().add(new Paragraph("Tipo").setFontSize(HeadTam).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        tableDescarga.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFontSize(HeadTam).setFont(bold)).setTextAlignment(TextAlignment.CENTER));         
        tableDescarga.addHeaderCell(new Cell().add(new Paragraph("Código Lote").setFontSize(HeadTam).setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        //tableDescruce.addHeaderCell(new Cell().add(new Paragraph("Motivo").setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        tableDescarga.addHeaderCell(new Cell().add(new Paragraph("Usuario").setFontSize(HeadTam).setFont(bold)).setTextAlignment(TextAlignment.CENTER));
        tableDescarga.addHeaderCell(new Cell().add(new Paragraph("Documento").setFontSize(HeadTam).setFont(bold)).setTextAlignment(TextAlignment.CENTER));

        
        List<Descarga> Lista_Descarga=jpa.createQuery("select p from Descarga p where month(fecha)>="+(listaRegistroMensualImprimir.get(0).getFecha_apertura().getMonth()+1)).getResultList();
        for (Descarga descarga : Lista_Descarga){
            tableDescarga.addCell(new Paragraph(Herramienta.formatoFechaHoraMas1(descarga.getFecha())).setFontSize(Tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescarga.addCell(new Paragraph(descarga.getRolTipo().getNombre_rol()).setFontSize(Tam).setFont(font).setTextAlignment(TextAlignment.CENTER));//stock final
            tableDescarga.addCell(new Paragraph(descarga.getCantidad()+"").setFontSize(Tam).setFont(font).setTextAlignment(TextAlignment.CENTER));
            tableDescarga.addCell(new Paragraph(descarga.getLote_detalle().getCodigo()).setFontSize(Tam).setFont(font).setTextAlignment(TextAlignment.CENTER));
            //tableDescruce.addCell(new Paragraph(descarga.getMotivo()).setFont(font).setTextAlignment(TextAlignment.CENTER));            
            tableDescarga.addCell(new Paragraph(descarga.getUsuario().getPersona().getInfoPersona()).setFontSize(Tam).setFont(font).setTextAlignment(TextAlignment.CENTER)); 
            tableDescarga.addCell(new Paragraph(descarga.getCodigo_documento()).setFontSize(Tam).setFont(font).setTextAlignment(TextAlignment.CENTER));
        }
        if(!Lista_Descarga.isEmpty()){
            document.add(parag4);
            document.add(tableDescarga);
            document.add(new AreaBreak());
            }
        
        
        document.close();  
        
    }
    public void llenarTablaInventarios(List<RegistroMensualInventario> lista_Registro_Inventario){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmacéutico","Cant. Inic.","Cant. Fin"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (RegistroMensualInventario objRegistro : lista_Registro_Inventario){
                 fila_actividad[0]=objRegistro.getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=objRegistro;
                 fila_actividad[2]=objRegistro.getInventario().getCantidad();
                 //fila_actividad[3]=objRegistro.getLote_detalle().getPrecio_Venta_Redondeado();  
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
            
            jtblVentas.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblVentas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblVentas.getTableHeader().setBackground(Color.BLUE);
            jtblVentas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblVentas.getColumnModel().getColumn(0).setPreferredWidth(400);
            jtblVentas.getColumnModel().getColumn(1).setPreferredWidth(10);
            jtblVentas.getColumnModel().getColumn(2).setPreferredWidth(10);              
            ((DefaultTableCellRenderer)jtblVentas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64      
    } 
    
    public void llenarTabla(List<RegistroMensualLotes> lista_Registros){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Código","Producto Farmacéutico","Cant. Inic.","Cant. Fin","User Apertura.","F.V"};
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
             for (RegistroMensualLotes objRegistro : lista_Registros){
                 fila_actividad[0]=objRegistro;
                 fila_actividad[1]=objRegistro.getLote_detalle().getInventario().getMedicamento().getNombre();
                 fila_actividad[2]=objRegistro.getCantidad_inicial();
                 //fila_actividad[3]=objRegistro.getLote_detalle().getPrecio_Venta_Redondeado();  
                 fila_actividad[4]=objRegistro.getUsuario_apertura().getPersona().getInfoPersona();   
                 fila_actividad[3]=objRegistro.getLote_detalle().getCantidad();   
                 fila_actividad[5]=Herramienta.formatoFechaMas1(objRegistro.getLote_detalle().getFecha_vencimiento());  
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
            
            jtblVentas.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblVentas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblVentas.getTableHeader().setBackground(Color.BLUE);
            jtblVentas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblVentas.getColumnModel().getColumn(0).setPreferredWidth(154);
            jtblVentas.getColumnModel().getColumn(1).setPreferredWidth(210);
            jtblVentas.getColumnModel().getColumn(2).setPreferredWidth(90);
            jtblVentas.getColumnModel().getColumn(3).setPreferredWidth(90);
            jtblVentas.getColumnModel().getColumn(4).setPreferredWidth(200);
            jtblVentas.getColumnModel().getColumn(5).setPreferredWidth(140);              
            ((DefaultTableCellRenderer)jtblVentas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64      
    }   
    
    
    //
    public void llenarTablaMedicamentosDeLotes(List<RegistroMensualLotes> lista_Lotes_Registro){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Codigo Lote","Cant. Inic.","Cant. Fin","Fecha Vencimiento"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (RegistroMensualLotes objRegistro : lista_Lotes_Registro){
                 fila_actividad[0]=objRegistro;
                 fila_actividad[1]=objRegistro.getCantidad_inicial();
                 fila_actividad[2]=objRegistro.getLote_detalle().getCantidad();
                 fila_actividad[3]=Herramienta.formatoFechaMas1(objRegistro.getLote_detalle().getFecha_vencimiento());
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblLotesDelMedicamento.setModel(modelo); 
            jtblLotesDelMedicamento.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblLotesDelMedicamento.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblLotesDelMedicamento.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblLotesDelMedicamento.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblLotesDelMedicamento.getColumnModel().getColumn(3).setCellRenderer(tcr);            
            
            
            jtblLotesDelMedicamento.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblLotesDelMedicamento.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblLotesDelMedicamento.getTableHeader().setBackground(Color.BLUE);
            jtblLotesDelMedicamento.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblLotesDelMedicamento.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtblLotesDelMedicamento.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtblLotesDelMedicamento.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtblLotesDelMedicamento.getColumnModel().getColumn(3).setPreferredWidth(50);
            
            ((DefaultTableCellRenderer)jtblLotesDelMedicamento.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64      
    }
    //+
    public void llenarTablaDetalleMedicamento(List<Detalle_Medicamentos> lista_Registros,List<Descruce> lista_descruce,List<Descarga> lista_Descarga){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Estudiante","Cantidad","Precio Total","Fecha Entrega","Q.F"};
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
             for (Detalle_Medicamentos objMedicamento : lista_Registros){
                 fila_actividad[0]=objMedicamento.getReceta().getControl_Paciente().getEstudiante().getPersona().getInfoPersona();
                 fila_actividad[1]=objMedicamento.getCantidad();
                 fila_actividad[2]=objMedicamento.getPrecio_Total();
                 //fila_actividad[3]=objRegistro.getLote_detalle().getPrecio_Venta_Redondeado();  
                 fila_actividad[3]=Herramienta.formatoFechaHoraMas1(objMedicamento.getFecha());   
                 fila_actividad[4]=objMedicamento.getUsuario().getPersona().getInfoPersona();
                 //fila_actividad[5]=Herramienta.formatoFecha(objRegistro.getLote_detalle().getFecha_vencimiento());  
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
             for (Descruce objDescruce : lista_descruce){
                 fila_actividad[0]="--DESCRUCE--";
                 if(objDescruce.getLote_detalle()!=objRegistroMensualLotes.getLote_detalle()){
                     if(objDescruce.getCantidad2()>0){fila_actividad[1]="+"+objDescruce.getCantidad2();}
                     else{fila_actividad[1]=objDescruce.getCantidad2();}
                     
                     fila_actividad[2]="destin. lote :"+objDescruce.getLote_detalle().getCodigo();                 
                 }
                 else{
                     fila_actividad[2]="destin. lote :"+objDescruce.getLote_detalle2().getCodigo();
                     if(objDescruce.getCantidad()>0){fila_actividad[1]="+"+objDescruce.getCantidad();}
                     {fila_actividad[1]=objDescruce.getCantidad();}
                     
                 }
                 //fila_actividad[3]=objRegistro.getLote_detalle().getPrecio_Venta_Redondeado();  
                 fila_actividad[3]=Herramienta.formatoFechaHoraMas1(objDescruce.getFecha_registro());   
                 fila_actividad[4]=objDescruce.getUsuario().getPersona().getInfoPersona();
                 //fila_actividad[5]=Herramienta.formatoFecha(objRegistro.getLote_detalle().getFecha_vencimiento());  
                 modelo.addRow(fila_actividad);//agregando filas                 
             }
             for (Descarga descarga : lista_Descarga){
                 fila_actividad[0]="--DESCARGO--";
                 fila_actividad[1]=descarga.getCantidad();
                 fila_actividad[2]="--"+descarga.getRolTipo().getNombre_rol()+"--";
                 fila_actividad[3]=Herramienta.formatoFechaHoraMas1(descarga.getFecha());
                 fila_actividad[4]=descarga.getUsuario().getPersona().getInfoPersona();
                 modelo.addRow(fila_actividad);//agregando filas
                 }
                          
            jtblDetalleMedicamento.setModel(modelo); 
            jtblDetalleMedicamento.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblDetalleMedicamento.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblDetalleMedicamento.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblDetalleMedicamento.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblDetalleMedicamento.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtblDetalleMedicamento.getColumnModel().getColumn(4).setCellRenderer(tcr);
            
            jtblDetalleMedicamento.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblDetalleMedicamento.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblDetalleMedicamento.getTableHeader().setBackground(Color.BLUE);
            jtblDetalleMedicamento.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblDetalleMedicamento.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtblDetalleMedicamento.getColumnModel().getColumn(1).setPreferredWidth(40);
            jtblDetalleMedicamento.getColumnModel().getColumn(2).setPreferredWidth(130);
            jtblDetalleMedicamento.getColumnModel().getColumn(3).setPreferredWidth(120);
            jtblDetalleMedicamento.getColumnModel().getColumn(4).setPreferredWidth(170);
            ((DefaultTableCellRenderer)jtblDetalleMedicamento.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64      
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinnerCantidad1;
    private javax.swing.JSpinner jSpinnerCantidad2;
    private javax.swing.JButton jbtnAbrirInventario3;
    private javax.swing.JButton jbtnAbrirInventario4;
    private javax.swing.JButton jbtnCerrarInventario;
    private javax.swing.JButton jbtnDescruzar;
    private javax.swing.JButton jbtnGuardarCierreLote1;
    private javax.swing.JButton jbtnGuardarDescruce;
    private javax.swing.JButton jbtnVolver;
    private javax.swing.JLabel jlblAdverte;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblCantFinal;
    private javax.swing.JLabel jlblCantFinalGeneral;
    private javax.swing.JLabel jlblCantInicial;
    private javax.swing.JLabel jlblCantInicialGeneral;
    private javax.swing.JLabel jlblCodigoLote;
    private javax.swing.JLabel jlblConc;
    private javax.swing.JLabel jlblConcGeneral;
    private javax.swing.JLabel jlblDescruceCant1;
    private javax.swing.JLabel jlblDescruceCant2;
    private javax.swing.JLabel jlblDescruceCon1;
    private javax.swing.JLabel jlblDescruceConc2;
    private javax.swing.JLabel jlblDescruceFF1;
    private javax.swing.JLabel jlblDescruceFF2;
    private javax.swing.JLabel jlblDescruceLoteSeleccionado1;
    private javax.swing.JLabel jlblDescruceLoteSeleccionado2;
    private javax.swing.JLabel jlblDescruceMedicamento1;
    private javax.swing.JLabel jlblDescruceMedicamento2;
    private javax.swing.JLabel jlblDescruceMotivo;
    private javax.swing.JLabel jlblFF;
    private javax.swing.JLabel jlblFFGeneral;
    private javax.swing.JLabel jlblFechaAperturada;
    private javax.swing.JLabel jlblFechaAperturadaGeneral;
    private javax.swing.JLabel jlblFechaVen;
    private javax.swing.JLabel jlblPF;
    private javax.swing.JLabel jlblPFGeneral;
    private javax.swing.JLabel jlblmasdas;
    private javax.swing.JTable jtblDescruceTablaMedicamento1;
    private javax.swing.JTable jtblDescruceTablaMedicamento2;
    private javax.swing.JTable jtblDetalleMedicamento;
    private javax.swing.JTable jtblLotesDelMedicamento;
    private javax.swing.JTable jtblVentas;
    private javax.swing.JTextField jtfDescruceMedicamento2;
    private javax.swing.JTextField jtfDescruzeMedicamento1;
    private javax.swing.JTextField jtfMotivo;
    private javax.swing.JPanel vistaDesCruce;
    private javax.swing.JPanel vistaLoteAcerrar;
    private javax.swing.JPanel vistaMedicamentesVer;
    private javax.swing.JPanel vistaRegistroLotes;
    // End of variables declaration//GEN-END:variables

}
