package com.ecoedu.Vistas.Consultas;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Diagnostico;
import com.ecoedu.model.Receta;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Semestre;
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
import java.util.ArrayList;
import java.util.Collections;
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

public class Reporte_Diagnostico extends javax.swing.JPanel {
    private Principal objPrincipal;
    private EntityManager jpa;   
    private List<Semestre> list_semestre;
    //datos q se desglozan de la BD               
    private List<Receta> Lista_Recetas=new ArrayList<>();//    
    public Reporte_Diagnostico(EntityManager jpa2,Principal OBJPrincipal ){
        initComponents();        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;      
      
    }
     public void ConsultaBD(){
         list_semestre=jpa.createQuery("select p from Semestre p").getResultList();
                  
     }    
     public void principalEjecucion(){ 
         jcbSemestre.removeAllItems();
         for (Semestre semestre : list_semestre){
             jcbSemestre.addItem(semestre);
             if(semestre.getFecha_Fin_Real()==null){
                 jcbSemestre.setSelectedItem(semestre);
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
        jcbYearDesde = new rojeru_san.componentes.RSDateChooser();
        jcbYearHasta = new rojeru_san.componentes.RSDateChooser();
        jcbTipoBusqueda = new javax.swing.JComboBox<>();
        jcbSemestre = new javax.swing.JComboBox<>();
        jlblSerie = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jbtnVer = new javax.swing.JButton();
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
        jLabel12.setText("Reportes por Diagnostico/Procedencia");
        jLabel12.setPreferredSize(new java.awt.Dimension(400, 70));
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

        jcbYearDesde.setPlaceholder("Fecha Inicio");
        jcbYearDesde.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel5.add(jcbYearDesde);

        jcbYearHasta.setPlaceholder("Fecha Fin");
        jcbYearHasta.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel5.add(jcbYearHasta);

        jcbTipoBusqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POR DIAGNÓSTICO", "POR PROCEDENCIA" }));
        jcbTipoBusqueda.setPreferredSize(new java.awt.Dimension(170, 30));
        jPanel5.add(jcbTipoBusqueda);

        jcbSemestre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbSemestre.setPreferredSize(new java.awt.Dimension(170, 30));
        jPanel5.add(jcbSemestre);

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

            },
            new String [] {
                "N.N", "N.N", "N.N"
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

        jbtnVer.setBackground(new java.awt.Color(0, 0, 0));
        jbtnVer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnVer.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVer.setText("VER");
        jbtnVer.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVerActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnVer);

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

    private void jbtnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVerActionPerformed
        try {
            if(Herramienta.fechaMenor(jcbYearDesde.getDatoFecha(), jcbYearHasta.getDatoFecha())){
                if("POR DIAGNÓSTICO".equals((String)jcbTipoBusqueda.getSelectedItem())){
                    imprimir(1);    
                    }
                else{
                    imprimirProcedencia(1);
                    }
                }
            else{
                JOptionPane.showMessageDialog(jPanel5, "La fecha (Desde) no debe ser mayor que (Hasta)");
            }
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(Reporte_Diagnostico.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jbtnVerActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
       String url="";
        if("POR DIAGNÓSTICO".equals((String)jcbTipoBusqueda.getSelectedItem())){
           url="Carpeta_de_Archivos\\Reporte_Diagnostico.pdf";
           }
       else{
           url="Carpeta_de_Archivos\\Reporte_Procedencia.pdf";           
       }
        
        ProcessBuilder p=new ProcessBuilder();
        p.command("cmd.exe","/c",url);
        try {
            p.start();
            }
        catch (IOException ex){
            Logger.getLogger(Reporte_Diagnostico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnImprimirActionPerformed
  
     public List<Diagnostico> desglozarRecetatoDiagnostico(List<Receta> allrecetas){
         List<Diagnostico> listaAuxDiagnostico=new ArrayList<>();
         for (int i = 0; i < allrecetas.size(); i++){
            boolean auxInventario=true;
            for (int j = 0; j < listaAuxDiagnostico.size(); j++){
                if(listaAuxDiagnostico.get(j)==allrecetas.get(i).getDiagnosito()){
                    auxInventario=false;		
                    break;
                    }
                }
            if(auxInventario){               
                listaAuxDiagnostico.add(allrecetas.get(i).getDiagnosito());
                }
            } 
         return listaAuxDiagnostico;
         }
     public List<Rol> desglozarRecetatoProcedencia(List<Receta> allrecetas){
         List<Rol> listaAuxProcedencia=new ArrayList<>();
         for (int i = 0; i < allrecetas.size(); i++){
            boolean auxInventario=true;
            for (int j = 0; j < listaAuxProcedencia.size(); j++){
                if(listaAuxProcedencia.get(j)==allrecetas.get(i).getRolProcedencia()){
                    auxInventario=false;		
                    break;
                    }
                }
            if(auxInventario){               
                listaAuxProcedencia.add(allrecetas.get(i).getRolProcedencia());
                }
            } 
         return listaAuxProcedencia;
         }
    public void imprimir(int a) throws FileNotFoundException, DocumentException, IOException{
        List<Receta> All_Recetass=Herramienta.findbyBeetWeen(Receta.class, "fecha_creada", jcbYearDesde.getDatoFecha(),jcbYearHasta.getDatoFecha(), jpa);
        List<Diagnostico> Lista_Diagnostico=desglozarRecetatoDiagnostico(All_Recetass);
        List<ZObjetoProDiag> Lista_zObjetoProdiag=new ArrayList<>();
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Código Diagnostico","Descripción ","Cantidad"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false,};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()]; 
        if(!All_Recetass.isEmpty() && a==1){
            jbtnImprimir.setEnabled(true);
            String ol="images\\unsch.png";
            Image unsch=new Image(ImageDataFactory.create(ol));            
            int fontTamaño=9;
            int fontHeadTamaño=11;
            PdfWriter writer=null;
            try {
                writer=new PdfWriter("Carpeta_de_Archivos\\Reporte_Diagnostico.pdf"); 
                }
            catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(jPanel5, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");
                jbtnImprimir.setVisible(false);
                }
            PdfDocument pdf = new PdfDocument(writer);
            Document document=new Document(pdf,PageSize.A4);
            PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
            Table table = new Table(new float[]{5,20,5});
            table.setWidthPercent(100); 
            Paragraph paragIma=new Paragraph("").add(unsch).add(
                new Text("                         REPORTE DE DIAGNÓSTICOS").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER));  
            document.add(paragIma);   
            Paragraph paraEscCodSerie=new Paragraph(new Text("DESDE: ").setFont(bold)).add(Herramienta.formatoFecha(jcbYearDesde.getDatoFecha()))
                .add(new Text(" HASTA: ").setFont(bold)).add(Herramienta.formatoFecha(jcbYearHasta.getDatoFecha()));
            document.add(paraEscCodSerie);
            document.add(new Paragraph(" "));
            table.addHeaderCell(new Cell().add(new Paragraph("Código Diagnóstico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
            table.addHeaderCell(new Cell().add(new Paragraph("Descripción").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
            table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));   
            for(Diagnostico diagnostico : Lista_Diagnostico){
                int cant=0;
                for(Receta allreceta : All_Recetass){
                    if(diagnostico==allreceta.getDiagnosito()){
                        cant++;          
                        }
                    }//fin for allreceta
                Lista_zObjetoProdiag.add(new ZObjetoProDiag(diagnostico,cant));
            }//fin for receta
            Collections.sort(Lista_zObjetoProdiag);
            for(int i=Lista_zObjetoProdiag.size()-1;0<=i;i--){
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getObjDiagnostico().getId_DiagnosticoCodigo()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));//codigo
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getObjDiagnostico().getDescripcion_Diagnostico()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));//inforpersona
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getCantidad()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));//Serie
                fila_actividad[0]=Lista_zObjetoProdiag.get(i).getObjDiagnostico().getId_DiagnosticoCodigo();       
                fila_actividad[1]=Lista_zObjetoProdiag.get(i).getObjDiagnostico().getDescripcion_Diagnostico();  
                fila_actividad[2]=Lista_zObjetoProdiag.get(i).getCantidad();   
                modelo.addRow(fila_actividad);
            }            
            llenar_Tabla_de_Recetas(modelo); 
            if(modelo.getRowCount()==0){
                JOptionPane.showMessageDialog(jPanel5, "No se encontró Procedentes/Diagnostico en el Rango de la Fecha");
                jbtnImprimir.setEnabled(false);
                }
            document.add(table);  
            document.close();   
            }//fin if vacío
        else{
            jbtnImprimir.setEnabled(false);
            llenar_Tabla_de_Recetas(modelo);    
            JOptionPane.showMessageDialog(jPanel5, "no se encontró recetas en este rango de Fecha");                     
        }
    }
    public void imprimirProcedencia(int a) throws FileNotFoundException, DocumentException, IOException{
        List<Receta> All_Recetass=Herramienta.findbyBeetWeen(Receta.class, "fecha_creada", jcbYearDesde.getDatoFecha(),jcbYearHasta.getDatoFecha(), jpa);
        List<Rol> Lista_Procedencia=desglozarRecetatoProcedencia(All_Recetass);
        List<ZObjetoProDiag> Lista_zObjetoProdiag=new ArrayList<>();
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Procedencia ","Cantidad",""}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false,};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()]; 
        if(!All_Recetass.isEmpty() && a==1){
            jbtnImprimir.setEnabled(true);
            String ol="images\\unsch.png";
            Image unsch=new Image(ImageDataFactory.create(ol));            
            int fontTamaño=9;
            int fontHeadTamaño=11;
            PdfWriter writer=null;
            try {
                writer=new PdfWriter("Carpeta_de_Archivos\\Reporte_Procedencia.pdf"); 
                }
            catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(jPanel5, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso procedencia");
                jbtnImprimir.setEnabled(false);
                }
            PdfDocument pdf = new PdfDocument(writer);
            Document document=new Document(pdf,PageSize.A4);
            PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
            Table table = new Table(new float[]{10,10});
            table.setWidthPercent(100); 
            Paragraph paragIma=new Paragraph("").add(unsch).add(
                new Text("                         REPORTE DE PROCEDENCIAS").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER));  
            document.add(paragIma);   
            Paragraph paraEscCodSerie=new Paragraph(new Text("DESDE: ").setFont(bold)).add(Herramienta.formatoFecha(jcbYearDesde.getDatoFecha()))
                .add(new Text(" HASTA: ").setFont(bold)).add(Herramienta.formatoFecha(jcbYearHasta.getDatoFecha()));
            document.add(paraEscCodSerie);            
            document.add(new Paragraph(" "));
            table.addHeaderCell(new Cell().add(new Paragraph("Procedencia").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
            table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));  
            
            for(Rol procedencia : Lista_Procedencia){
                int cant=0;
                for(Receta allreceta : All_Recetass){
                    if(procedencia==allreceta.getRolProcedencia()){
                        cant++;          
                        }
                    }//fin for allreceta
                Lista_zObjetoProdiag.add(new ZObjetoProDiag(procedencia,cant));
                }//fin for receta
            Collections.sort(Lista_zObjetoProdiag);
            for(int i=Lista_zObjetoProdiag.size()-1;0<=i;i--){
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getObjRolesMuchos().getNombre_rol()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));//codigo
                table.addCell(new Paragraph(Lista_zObjetoProdiag.get(i).getCantidad()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));//inforpersona
                fila_actividad[0]=Lista_zObjetoProdiag.get(i).getObjRolesMuchos().getNombre_rol();       
                fila_actividad[1]=Lista_zObjetoProdiag.get(i).getCantidad();   
                modelo.addRow(fila_actividad);
            }            
            llenar_Tabla_de_Recetas(modelo); 
            if(modelo.getRowCount()==0){
                JOptionPane.showMessageDialog(jPanel5, "No se encontró Procedentes/Diagnostico en el Rango de la Fecha");
                jbtnImprimir.setEnabled(false);
                }
            document.add(table);  
            document.close();   
            }//fin if vacío
        else{
            jbtnImprimir.setEnabled(false);
            llenar_Tabla_de_Recetas(modelo);    
            JOptionPane.showMessageDialog(jPanel5, "no se encontró recetas en este rango de Fecha");                     
        }
    }
    /*
    public void imprimirEstudiante() throws FileNotFoundException, DocumentException, IOException{
        String ol="C:\\Users\\yrma\\eclipse-workspace\\com.ecodap.pruebaBotica\\src\\main\\resources\\images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTamaño=9;
        int fontHeadTamaño=11;
        PdfWriter writer=new PdfWriter("control.pdf");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JButton jbtnVer;
    private javax.swing.JComboBox<Semestre> jcbSemestre;
    private javax.swing.JComboBox<String> jcbTipoBusqueda;
    private rojeru_san.componentes.RSDateChooser jcbYearDesde;
    private rojeru_san.componentes.RSDateChooser jcbYearHasta;
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
            jtblRecetas.getColumnModel().getColumn(2).setCellRenderer(tcr);
            
            jtblRecetas.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 16));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(90);//queda
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(220);
            jtblRecetas.getColumnModel().getColumn(2).setPreferredWidth(50);//queda
            
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
    
    

}
