package com.ecoedu.Vistas.ServicioAsistencial;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.Receta;
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
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.dom4j.DocumentException;


public class ServicioAsistencial extends javax.swing.JPanel {
    private Principal objPrincipal;
    private float Monto_totalControlEstudiante;
    private float saldo_totalControlEstudiante;
    private Control_paciente objControl_paciente_Final;
    private Usuario objUsuario;
    private EntityManager jpa;     
    private List<Lote_detalle> Lista_lote_detalle;
    private List<Detalle_Medicamentos> Lista_carrito_medicamentos=new ArrayList<>();//
    //datos q se desglozan de la BD               
    private List<Control_paciente> Lista_control_paciente;//
    private List<Receta> Lista_Recetas=new ArrayList<>();//
      
    public ServicioAsistencial(EntityManager jpa2,Principal OBJPrincipal,Usuario OBJUsuario){
        initComponents();        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;
        this.objUsuario=OBJUsuario;        
    }
     public void ConsultaBD(){
         Query query1=jpa.createQuery("SELECT p FROM Control_paciente p where iSactivo=1");
         Lista_control_paciente=query1.getResultList();               
          
     }
    
     public void principalEjecucion(){ 
         jbtnImprimir.setEnabled(false);     
         jbtnCrearReceta.setEnabled(false);
         llenar_Tabla_de_Recetas(Lista_Recetas);
         
           
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
         for (Lote_detalle lote_detalle : Lista_lote_detalle){
             if(lote_detalle==objDetalleMedicamento.getLote_detalle()){
                 lote_detalle.setCantidad(lote_detalle.getCantidad()-objDetalleMedicamento.getCantidad());
                 lote_detalle.getInventario().setCantidad(lote_detalle.getInventario().getCantidad()-objDetalleMedicamento.getCantidad());
                 break;
                 }
                          
         }          
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
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlblAdvertencia = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jlblMontoTotal = new javax.swing.JLabel();
        jbtnImprimir = new javax.swing.JButton();
        jbtnCrearReceta = new javax.swing.JButton();

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
        jtfLookCodigo.setText("2715050");
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

        cuerpo1ListaRecetas.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo1ListaRecetas.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 150));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jtblRecetas.setBorder(new javax.swing.border.MatteBorder(null));
        jtblRecetas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblRecetas.setGridColor(new java.awt.Color(0, 0, 0));
        jtblRecetas.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblRecetas.setPreferredSize(new java.awt.Dimension(200, 260));
        jtblRecetas.setRequestFocusEnabled(false);
        jtblRecetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRecetasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRecetas);

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

        cuerpo1ListaRecetas.add(jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(900, 170));

        jlblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAdvertencia.setForeground(new java.awt.Color(255, 0, 0));
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setMaximumSize(new java.awt.Dimension(500, 0));
        jlblAdvertencia.setMinimumSize(new java.awt.Dimension(100, 0));
        jlblAdvertencia.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel11.add(jlblAdvertencia);

        cuerpo1ListaRecetas.add(jPanel11);

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

        jbtnImprimir.setBackground(new java.awt.Color(0, 0, 0));
        jbtnImprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        jbtnImprimir.setText("IMPRIMIR");
        jbtnImprimir.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnImprimir);

        jbtnCrearReceta.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCrearReceta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrearReceta.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCrearReceta.setText("CREAR RECETA");
        jbtnCrearReceta.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnCrearReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearRecetaActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnCrearReceta);

        cuerpo1ListaRecetas.add(jPanel10);

        body2.add(cuerpo1ListaRecetas, "card2");

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
                jlblEscuela.setText(Lista_control_paciente.get(i).getEstudiante().getEscuela().getNombre());
                jlblMontoTotal.setText("S/"+Herramienta.dosDecimales(Lista_control_paciente.get(i).getMonto_Total()));              
                Lista_Recetas=Herramienta.findbyWhere(Receta.class,"id_Control_paciente",objControl_paciente_Final.getId_Control_paciente(), jpa);
                jbtnCrearReceta.setEnabled(true);
                jbtnImprimir.setEnabled(true);
                if(Lista_Recetas.isEmpty()){
                jlblAdvertencia.setText("NO CONTIENE NI UNA RECETA");
                jbtnImprimir.setEnabled(false);
                }               
                break;
            }
            jbtnCrearReceta.setEnabled(false);
            jbtnImprimir.setEnabled(false);
            jlblAdvertencia.setText("");
        }
       llenar_Tabla_de_Recetas(Lista_Recetas);        
    }
    private void jbtnCrearRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearRecetaActionPerformed
        Query query1=jpa.createQuery("SELECT p FROM Lote_detalle p");
        Lista_lote_detalle=query1.getResultList();
        cuerpo1ListaRecetas.setVisible(false);  
        jtfLookCodigo.setEditable(false);
    }//GEN-LAST:event_jbtnCrearRecetaActionPerformed

    private void jtblRecetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRecetasMouseClicked
        Receta objReceta=(Receta)jtblRecetas.getValueAt(jtblRecetas.getSelectedRow(),0);
        for (int i = 0; i < Lista_Recetas.size(); i++){
            if(Lista_Recetas.get(i)==objReceta){ 
                cuerpo1ListaRecetas.setVisible(false);
                jtfLookCodigo.setEditable(false);
                break;
            }        
        }
    }//GEN-LAST:event_jtblRecetasMouseClicked

    private void jtfLookCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            llenarControlAlumno();            
        }
    }//GEN-LAST:event_jtfLookCodigoKeyPressed

    public void Limpiarcuerp2CrearRecetas(){
        cuerpo1ListaRecetas.setVisible(true);
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

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
 
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
    }//GEN-LAST:event_jbtnImprimirActionPerformed
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
        Paragraph paraEscCodSerie=new Paragraph(new Text("ESCUELA: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getEscuela().getNombre())
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
                 
      Collections.sort(Lista_Recetas);//ordenando A-Z (método como Override)
        for(Receta receta : Lista_Recetas){
            List<Detalle_Medicamentos> listMedi=Herramienta.findbyWhere(Detalle_Medicamentos.class,"id_Receta", receta.getId_Receta(), jpa);
            Collections.sort(listMedi);//ordenando A-Z (método como Override)
            Paragraph p = new Paragraph("Receta N°").setFont(bold).setFontSize(10)
                    .add(new Text(""+receta.getId_Receta()).setFont(bold).setFontSize(10))
                    .add(new Text("   Procedencia: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getProcedencia().getNombre()).setFont(font).setFontSize(10))
                    .add(new Text("   Diagnóstico: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getDiagnosito().getId_DiagnosticoCodigo()).setFontSize(10));
            
            table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño)
                    .add(Herramienta.formatoFecha(receta.getFecha_creada())).setFont(bold) );
            
            table.addCell(new Cell(1, 4).add(p).setTextAlignment(TextAlignment.LEFT));
            for (Detalle_Medicamentos Detalle_Medicamento : listMedi) {           
            table.addCell(new Paragraph(Herramienta.formatoFecha(Detalle_Medicamento.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Detalle_Medicamento.getId_Medicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Integer.toString(Detalle_Medicamento.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Float.toString(Detalle_Medicamento.getPrecio_Total())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            }
        }
        document.add(table);        
        document.close();       
    }
    public void limpiarVista1(){
         jlblNombres.setText("");
         jlblEscuela.setText("");
         jlblSerie.setText("");
         Lista_Recetas.clear();
         llenarControlAlumno();
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel cuerpo1ListaRecetas;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCrearReceta;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblMontoTotal;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JTable jtblRecetas;
    private javax.swing.JTextField jtfLookCodigo;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Recetas(List<Receta> lista_de_recetas){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Fecha","Total costo","Procedencia","Diagnostico"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false, false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = lista_de_recetas.size()-1; i>=0 ; i--){
                 fila_actividad[0]=lista_de_recetas.get(i);             
                 fila_actividad[1]=lista_de_recetas.get(i).getTotal_costo_medicinas();  
                 fila_actividad[2]=lista_de_recetas.get(i).getProcedencia().getNombre();   
                 fila_actividad[3]=lista_de_recetas.get(i).getDiagnosito().getId_DiagnosticoCodigo();  
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
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(250);
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblRecetas.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtblRecetas.getColumnModel().getColumn(3).setPreferredWidth(150);     
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
    
    

}
