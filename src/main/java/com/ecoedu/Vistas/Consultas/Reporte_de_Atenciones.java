package com.ecoedu.Vistas.Consultas;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Receta;
import com.ecoedu.model.Rol;
import com.ecoedu.model.ZObjetoProDiag;
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
import org.dom4j.DocumentException;

public class Reporte_de_Atenciones extends javax.swing.JPanel {
    private Principal objPrincipal;
    private EntityManager jpa;   
    private List<Control_paciente> Lista_control_paciente;
    //datos q se desglozan de la BD               
    private List<Receta> Lista_Recetas=new ArrayList<>();//    
    public Reporte_de_Atenciones(EntityManager jpa2,Principal OBJPrincipal ){
        initComponents();        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;             
    }
     public void ConsultaBD(){
         //Lista_control_paciente=jpa.createQuery("SELECT p FROM Control_paciente p where iSactivo=1").getResultList();
         
     }    
     public void principalEjecucion() throws DocumentException, IOException{    
            
            Rol objEscuela1=new Rol();
            objEscuela1.setId_Rol(450);
            imprimir(objEscuela1);
            jbtnImprimir.setEnabled(false);
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jlblSerie = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jbtnCrearReceta = new javax.swing.JButton();
        jbtnImprimir = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setMaximumSize(new java.awt.Dimension(990, 650));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(100, 100, 0));
        head.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Reporte de atenciones");
        jLabel12.setPreferredSize(new java.awt.Dimension(600, 70));
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TURNO TARDE", "TURNO MA�ANA" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel5.add(jComboBox1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel5.add(jComboBox2);

        jPanel7.add(jPanel5);

        jlblSerie.setBackground(new java.awt.Color(0, 0, 0));
        jlblSerie.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSerie.setPreferredSize(new java.awt.Dimension(39, 30));
        jPanel7.add(jlblSerie);

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
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 305));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 1000));

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
                "C�digo", "Fecha", "Total Costo", "Procedencia", "Diagnostico"
            }
        ));
        jtblRecetas.setGridColor(new java.awt.Color(0, 0, 0));
        jtblRecetas.setMinimumSize(new java.awt.Dimension(1000, 1000));
        jtblRecetas.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jtblRecetas);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click en la tabla para ver Detalles de la Receta");
        jPanel9.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        cuerpo1ListaRecetas.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(900, 40));

        jbtnCrearReceta.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCrearReceta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrearReceta.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCrearReceta.setText("VER");
        jbtnCrearReceta.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnCrearReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearRecetaActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnCrearReceta);

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

        cuerpo1ListaRecetas.add(jPanel10);

        body2.add(cuerpo1ListaRecetas, "card2");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void imprimirEscuelitas() throws MalformedURLException, IOException{
        
        List<ZObjetoProDiag> Lista_zObjetoProdiag=new ArrayList<>();
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Condici�n ","Cantidad"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()]; 
             //Lista_control_paciente=Herramienta.findbyBeetWeen(Control_paciente.class, "fecha_registro", jcbYearDesde.getDatoFecha(), jcbYearHasta.getDatoFecha(), jpa);
            
        if(!Lista_control_paciente.isEmpty()){
            List<Rol> listaCondiciones=desglozarControlPacientetoEscuelas(Lista_control_paciente);
            jbtnImprimir.setEnabled(true);
            String ol="images\\unsch.png";
            Image unsch=new Image(ImageDataFactory.create(ol));            
            int fontTama�o=9;
            int fontHeadTama�o=11;
            PdfWriter writer=null;
            try {
                writer=new PdfWriter("Carpeta_de_Archivos\\Reporte_Escuela_Botica.pdf"); 
                }
            catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(jPanel7, "El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso procedencia");
                jbtnImprimir.setEnabled(false);
                }
            
            PdfDocument pdf = new PdfDocument(writer);
            Document document=new Document(pdf,PageSize.A4);
            PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
            Table table = new Table(new float[]{10,10});
            table.setWidthPercent(100); 
            Paragraph paragIma=new Paragraph("").add(unsch).add(
                new Text("REPORTE DE ESCUELAS ATENDIDOS EN SERVICIO:BOTICA DEL A�O "+(new Date().getYear()+1900)).setFontSize(13).setFont(bold).setTextAlignment(TextAlignment.CENTER));  
            document.add(paragIma);   
            //Paragraph paraEscCodSerie=new Paragraph(new Text("DESDE: ").setFont(bold)).add(Herramienta.formatoFecha(jcbYearDesde.getDatoFecha()))
            //    .add(new Text("     HASTA: ").setFont(bold)).add(Herramienta.formatoFecha(jcbYearHasta.getDatoFecha()));
            
            //document.add(paraEscCodSerie);           
            document.add(new Paragraph(" "));
            table.addHeaderCell(new Cell().add(new Paragraph("Escuela").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
            table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));  
            //Control_paciente control_paciente : Lista_ControlPaciente
            for(Rol objCondicion : listaCondiciones){
                int cant=0;
                for(Control_paciente control_paciente : Lista_control_paciente){
                    if(control_paciente.getEstudiante().getEscuela()==objCondicion){
                        cant++;          
                        }
                    }//fin for allreceta
                Lista_zObjetoProdiag.add(new ZObjetoProDiag(objCondicion,cant));
                }//fin for receta
            Collections.sort(Lista_zObjetoProdiag);
            for(int i=Lista_zObjetoProdiag.size()-1;0<=i;i--){
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getObjRolesMuchos().getNombre_rol()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));//codigo
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getCantidad()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));//inforpersona
                fila_actividad[0]=Lista_zObjetoProdiag.get(i).getObjRolesMuchos().getNombre_rol();       
                fila_actividad[1]=Lista_zObjetoProdiag.get(i).getCantidad();   
                modelo.addRow(fila_actividad);
            }            
            llenar_Tabla_de_Recetas(modelo); 
            if(modelo.getRowCount()==0){
                JOptionPane.showMessageDialog(jPanel7, "No se encontr� estudiante en el Rango de la Fecha");
                jbtnImprimir.setEnabled(false);
                }
            document.add(table);  
            document.close();   
            }//fin if vac�o
        else{
            jbtnImprimir.setEnabled(false);
            llenar_Tabla_de_Recetas(modelo);    
            JOptionPane.showMessageDialog(jPanel7, "no se encontr� recetas en este rango de Fecha");                     
        }
    }
    private void jbtnCrearRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearRecetaActionPerformed
       // try {
            //if(Herramienta.fechaMenor(jcbYearDesde.getDatoFecha(),jcbYearHasta.getDatoFecha())){
           //     imprimirEscuelitas();
           //     }
           // else{
            //    JOptionPane.showMessageDialog(jPanel5, "La fecha (Desde) no debe ser mayor que (Hasta)");
           // }
        //} catch (IOException ex) {
         //   Logger.getLogger(Reporte_Diagnostico.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }//GEN-LAST:event_jbtnCrearRecetaActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
        String url="Carpeta_de_Archivos\\Reporte_Escuela_Botica.pdf";
        ProcessBuilder p=new ProcessBuilder();
        p.command("cmd.exe","/c",url);
        try {
            p.start();
            }
        catch (IOException ex){
            Logger.getLogger(Reporte_Diagnostico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnImprimirActionPerformed
  
    public void imprimir(Rol objEscuela) throws FileNotFoundException, DocumentException, IOException{
        List<Rol> ListaEscuelas=jpa.createQuery("select p from Rol p where id_tipo_Roles=1").getResultList();
        DefaultTableModel modelo;        
        Object[] fila_actividad;
        //.....................................TABLA......................................
             String [] lista={"Escuela","ME","OB","OD","OTROS","N","C","R","M","F"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false,false,false,false,false,false,false,false,false,false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];         
            //jbtnImprimir.setEnabled(true);
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));      
        int fontTama�o=8;
        int fontHeadTama�o=10;
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\Reporte_Escuela_Botica.pdf");            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jPanel5, "El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso");
        }                
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{7,22});
        table.setWidthPercent(100);      
        Paragraph paragIma=new Paragraph("").add(unsch).add(
                new Text("                                            Reporte de estudiantes atendidos en la escuela").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER));  
        document.add(paragIma);
        
        document.add(new Paragraph(" "));    
        table.addHeaderCell(new Cell().add(new Paragraph("C�digo").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("Apellidos y Nombres").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
 
      llenar_Tabla_de_Recetas(modelo);//FALTA VALIDAR QUE PASA SI NO HAY NADA EN UN RANGO DE FECHA 
      if(modelo.getRowCount()==0){
          JOptionPane.showMessageDialog(jPanel5, "No se encontr� Estudiante en el Rango de la Fecha");
          jbtnImprimir.setEnabled(false);
      }
      document.add(table);        
      document.close();              
    }
    public List<Rol> desglozarControlPacientetoEscuelas(List<Control_paciente> lista_control){
         List<Rol> listaAuxEscuelas=new ArrayList<>();
        for (Control_paciente lista_controll : lista_control){
             boolean auxEscuela=true;
             for (Rol listaAuxCondicion1: listaAuxEscuelas){
                 if(listaAuxCondicion1==lista_controll.getEstudiante().getEscuela()){
                    auxEscuela=false;		
                    break;
                    }
             }
            if(auxEscuela){               
                listaAuxEscuelas.add(lista_controll.getEstudiante().getEscuela());
                }
        } 
         return listaAuxEscuelas;
         }
    
    
    
    
    /*
    public void imprimirEstudiante() throws FileNotFoundException, DocumentException, IOException{
        String ol="C:\\Users\\yrma\\eclipse-workspace\\com.ecodap.pruebaBotica\\src\\main\\resources\\images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTama�o=9;
        int fontHeadTama�o=11;
        PdfWriter writer=new PdfWriter("control.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4);        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{8,15,5,4,18});
        table.setWidthPercent(100);
        
        Paragraph paragIma=new Paragraph("").add(unsch);  
        document.add(paragIma);
        
        Paragraph paraTitle=new Paragraph("CONTROL ECON�MICO DE ATENCIONES").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER);
        document.add(paraTitle);
        Paragraph parag=new Paragraph(new Text("APELLIDOS Y NOMBRES: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getPersona().getInfoPersona()).setTextAlignment(TextAlignment.LEFT);
        document.add(parag);      
        Paragraph paraEscCodSerie=new Paragraph(new Text("ESCUELA: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getEscuela().getNombre())
                .add(new Text("         SERIE: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getSerie()).setTextAlignment(TextAlignment.LEFT)
                .add(new Text("         C�DIGO: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getCodigo());
        document.add(paraEscCodSerie);
        Paragraph parag2=new Paragraph("ATENCIONES-SERVICIO DE FARMACIA").setFont(bold).setTextAlignment(TextAlignment.CENTER);         
        document.add(parag2);
        document.add(new Paragraph(" "));    
        table.addHeaderCell(new Cell().add(new Paragraph("Fecha").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("Producto Farmac�utico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));        
        table.addHeaderCell(new Cell().add(new Paragraph("Monto").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Qu�mico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o)); 
                 
      Collections.sort(Lista_Recetas);//ordenando A-Z (m�todo como Override)
        for(Receta receta : Lista_Recetas){
            List<Detalle_Medicamentos> listMedi=Herramienta.findbyWhere(Detalle_Medicamentos.class,"id_Receta", receta.getId_Receta(), jpa);
            Collections.sort(listMedi);//ordenando A-Z (m�todo como Override)
            Paragraph p = new Paragraph("Receta N�").setFont(bold).setFontSize(10)
                    .add(new Text(""+receta.getId_Receta()).setFont(bold).setFontSize(10))
                    .add(new Text("   Procedencia: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getProcedencia().getNombre()).setFont(font).setFontSize(10))
                    .add(new Text("   Diagn�stico: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getDiagnosito().getId_DiagnosticoCodigo()).setFontSize(10));
            
            table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o)
                    .add(Herramienta.formatoFecha(receta.getFecha_creada())).setFont(bold) );
            
            table.addCell(new Cell(1, 4).add(p).setTextAlignment(TextAlignment.LEFT));
            for (Detalle_Medicamentos Detalle_Medicamento : listMedi) {           
            table.addCell(new Paragraph(Herramienta.formatoFecha(Detalle_Medicamento.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Detalle_Medicamento.getId_Medicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Integer.toString(Detalle_Medicamento.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Float.toString(Detalle_Medicamento.getPrecio_Total())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            }
        }
        document.add(table);        
        document.close();              
    }*/
    public void limpiarVista1(){
         jlblSerie.setText("");
         Lista_Recetas.clear();
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel cuerpo1ListaRecetas;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCrearReceta;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JTable jtblRecetas;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Recetas(DefaultTableModel modelo){        
            jtblRecetas.setModel(modelo); 
            jtblRecetas.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblRecetas.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(1).setCellRenderer(tcr);
      
            jtblRecetas.setFont(new java.awt.Font("Tahoma", 0, 14));
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(150);//queda
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(50);//queda
 
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
    
    

}
