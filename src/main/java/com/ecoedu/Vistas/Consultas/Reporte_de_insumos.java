package com.ecoedu.Vistas.Consultas;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.app.EventoPagina;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Detalle_llenado;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Inventario;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.Receta;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Semestre;
import com.ecoedu.model.ZObjetoProDiag;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
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

public class Reporte_de_insumos extends javax.swing.JPanel {
    private Principal objPrincipal;
    private EntityManager jpa;   
    private List<Rol> list_RolOrigen;
    private List<Lote_detalle> lista_lote;
    //datos q se desglozan de la BD               
    public Reporte_de_insumos(EntityManager jpa2,Principal OBJPrincipal ){
        initComponents();        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;             
    }
     public void ConsultaBD(){
         //Lista_control_paciente=jpa.createQuery("SELECT p FROM Control_paciente p where iSactivo=1").getResultList();
         list_RolOrigen=jpa.createQuery("select p from Rol p where id_tipo_Roles=10").getResultList();      
         lista_lote=jpa.createQuery("select p from Lote_detalle p").getResultList();
         Collections.sort(list_RolOrigen);
         llenarTabla(new ArrayList<Lote_detalle>());

         
     }    
     public void principalEjecucion() {    
         jcbSemestre.removeAllItems();
         for (Rol semestre : list_RolOrigen){
             jcbSemestre.addItem(semestre);
             }
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
        jLabel2 = new javax.swing.JLabel();
        jcbSemestre = new javax.swing.JComboBox<>();
        jlblSerie = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblVentas = new javax.swing.JTable();
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
        jLabel12.setText("Reporte por Escuelas Cantidad de Alumnos Atendidos en Botica");
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("INSUMO PARA :");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel5.add(jLabel2);

        jcbSemestre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbSemestre.setPreferredSize(new java.awt.Dimension(200, 30));
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

        jtblVentas.setBorder(new javax.swing.border.MatteBorder(null));
        jtblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblVentas.setGridColor(new java.awt.Color(0, 0, 0));
        jtblVentas.setMinimumSize(new java.awt.Dimension(1000, 1000));
        jtblVentas.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jtblVentas);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

    public void llenarTabla(List<Lote_detalle> listadetalleMedicamento){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmacéutico.","Conc.","F.F","Fecha Venc.","Cantidad"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false, false, false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i < listadetalleMedicamento.size(); i++){                 
                 fila_actividad[0]=listadetalleMedicamento.get(i).getInventario().getMedicamento().getNombre(); 
                 fila_actividad[2]=listadetalleMedicamento.get(i).getInventario().getMedicamento().getForma_farmaceutica();
                 fila_actividad[1]=listadetalleMedicamento.get(i).getInventario().getMedicamento().getConcentracion();             
                 fila_actividad[3]=Herramienta.formatoFechaMas1(listadetalleMedicamento.get(i).getFecha_vencimiento());  
                 fila_actividad[4]=listadetalleMedicamento.get(i).getCantidad();   
                 //fila_actividad[5]=Herramienta.formatoFecha(listadetalleMedicamento.get(i).getLote_detalle().getFecha_vencimiento());   
                 //fila_actividad[6]=listadetalleMedicamento.get(i).getPrecio_Unitario();
                 //fila_actividad[7]=listadetalleMedicamento.get(i).getPrecio_Total();
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
   
            
            jtblVentas.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblVentas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblVentas.getTableHeader().setBackground(Color.BLUE);
            jtblVentas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblVentas.getColumnModel().getColumn(0).setPreferredWidth(260);
            jtblVentas.getColumnModel().getColumn(1).setPreferredWidth(75);
            jtblVentas.getColumnModel().getColumn(2).setPreferredWidth(75);
            jtblVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
            jtblVentas.getColumnModel().getColumn(3).setPreferredWidth(40);
           ((DefaultTableCellRenderer)jtblVentas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);       
    }   
    public void imprimir(List<Lote_detalle> lista_lotesss) throws FileNotFoundException, DocumentException, IOException{
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        PdfWriter writer=new PdfWriter("Carpeta_de_Archivos\\Reporte_Insumos.pdf");           
     
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());
        EventoPagina evento = new EventoPagina(document);
        // Indicamos que el manejador se encargara del evento END_PAGE
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
        document.setMargins(75, 36, 75, 36);  
        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);   
        int tam=7;
        int tamHead=9;
        Table table = new Table(new float[]{18,10,8,10,4});
        table.setWidthPercent(100);
        //Paragraph parag=new Paragraph("KARDEX DIARIO MEDICAMENTOS").setFontSize(16).setFont(bold);
        Paragraph paragIma=new Paragraph("     ").add(unsch).add("                                                              Lista de "+((Rol)jcbSemestre.getSelectedItem()).getNombre_rol()).setFontSize(16).setFont(bold);  
        document.add(paragIma);            
        document.add(new Paragraph(" "));    
        table.addHeaderCell(new Cell().add(new Paragraph("Producto Farmacéutico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(tamHead));         
        table.addHeaderCell(new Cell().add(new Paragraph("Conc.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(tamHead));         
        table.addHeaderCell(new Cell().add(new Paragraph("F.F").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(tamHead));        
        table.addHeaderCell(new Cell().add(new Paragraph("Fecha Venc.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(tamHead)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Stock").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(tamHead)); 
        Collections.sort(lista_lotesss);//ordenando A-Z (método como Override)
        for (Lote_detalle Lote_detalle : lista_lotesss){
            if(!Lote_detalle.isIsVencido()){
            table.addCell(new Paragraph(Lote_detalle.getInventario().getMedicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.LEFT).setFontSize(tam));//P.F
            table.addCell(new Paragraph(Lote_detalle.getInventario().getMedicamento().getConcentracion()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(tam));//Conc
            table.addCell(new Paragraph(Lote_detalle.getInventario().getMedicamento().getForma_farmaceutica()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(tam));//FF
            if(Lote_detalle.getFecha_vencimiento().getTime()-(new Date()).getTime()>=0){
                if((Lote_detalle.getFecha_vencimiento().getTime()-(new Date()).getTime())/86400000 <=6*30){
                    System.out.println("volar");
                    table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_detalle.getFecha_vencimiento())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(tam).setBackgroundColor(com.itextpdf.kernel.color.Color.YELLOW));
                    }
                else{
                    table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_detalle.getFecha_vencimiento())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(tam).setBackgroundColor(com.itextpdf.kernel.color.Color.WHITE));
                    }
            }
            else{
                table.addCell(new Paragraph(Herramienta.formatoFecha(Lote_detalle.getFecha_vencimiento())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(tam).setBackgroundColor(com.itextpdf.kernel.color.Color.RED));
                }
            table.addCell(new Paragraph(Integer.toString(Lote_detalle.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(tam));//stock final
            }
        }     
        document.add(table);  
        document.close();              
    }
    
    private void jbtnCrearRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearRecetaActionPerformed
        List<Lote_detalle> lista=new ArrayList<>();
        for (Lote_detalle lote_detalle : lista_lote){
            if(lote_detalle.getInventario().getMedicamento().getRolorigen()==((Rol)jcbSemestre.getSelectedItem())){
                lista.add(lote_detalle);
            }            
        }
        if(!lista.isEmpty()){
            jbtnImprimir.setEnabled(true);
        }else{
            jbtnImprimir.setEnabled(false);
        }
        try {
            imprimir(lista);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Reporte_de_insumos.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTabla(lista);
            
       
    }//GEN-LAST:event_jbtnCrearRecetaActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
        String url="Carpeta_de_Archivos\\Reporte_Insumos.pdf";
        ProcessBuilder p=new ProcessBuilder();
        p.command("cmd.exe","/c",url);
        try {
            p.start();
            }
        catch (IOException ex){
            Logger.getLogger(Reporte_Diagnostico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnImprimirActionPerformed
  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel cuerpo1ListaRecetas;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCrearReceta;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JComboBox<Rol> jcbSemestre;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JTable jtblVentas;
    // End of variables declaration//GEN-END:variables

    
    

}
