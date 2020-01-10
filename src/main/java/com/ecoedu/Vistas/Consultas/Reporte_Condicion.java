package com.ecoedu.Vistas.Consultas;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
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

public class Reporte_Condicion extends javax.swing.JPanel {
    private Principal objPrincipal;
    private EntityManager jpa;   
    private List<Control_paciente> Lista_ControlPaciente=new ArrayList<>();//
    //datos q se desglozan de la BD               
    private List<Receta> Lista_Recetas=new ArrayList<>();//    
    public Reporte_Condicion(EntityManager jpa2,Principal OBJPrincipal ){
        initComponents();        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;             
    }
     public void ConsultaBD(){
         Lista_ControlPaciente=jpa.createQuery("select p from Control_paciente p where iSactivo=1").getResultList();
         
     }    
     public void principalEjecucion() throws DocumentException, IOException{                   
            jbtnImprimir.setEnabled(false);
            jlblMensaje.setText("Cantidad de Condiciones en lo que va del Año "+(new Date().getYear()+1900) );
            imprimirProcedencia();
            }
     @SuppressWarnings("unchecked")     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlblMensaje = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
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
        jLabel12.setText("Reporte de Condición");
        jLabel12.setPreferredSize(new java.awt.Dimension(400, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(890, 100));

        jLabel6.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel7.add(jLabel6);

        jlblMensaje.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensaje.setText("Reporte de Condición");
        jlblMensaje.setPreferredSize(new java.awt.Dimension(700, 70));
        jPanel7.add(jlblMensaje);

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
                "Código", "Fecha", "Total Costo", "Procedencia", "Diagnostico"
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

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed

        String url="Carpeta_de_Archivos\\Reporte_Condicion.pdf";
        ProcessBuilder p=new ProcessBuilder();
        p.command("cmd.exe","/c",url);
        try {
            p.start();
            }
        catch (IOException ex){
            Logger.getLogger(Reporte_Condicion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnImprimirActionPerformed
  
     public List<Rol> desglozarControlPacientetoCondicion(List<Control_paciente> lista_control){
         List<Rol> listaAuxCondicion=new ArrayList<>();
        for (Control_paciente lista_controll : lista_control){
             boolean auxInventario=true;
             for (Rol listaAuxCondicion1: listaAuxCondicion){
                 if(listaAuxCondicion1==lista_controll.getEstudiante().getRolCondicion()){
                    auxInventario=false;		
                    break;
                    }
             }
            if(auxInventario){               
                listaAuxCondicion.add(lista_controll.getEstudiante().getRolCondicion());
                }
        } 
         return listaAuxCondicion;
         }
     
    
    public void imprimirProcedencia() throws FileNotFoundException, DocumentException, IOException{
        List<Rol> listaCondiciones=desglozarControlPacientetoCondicion(Lista_ControlPaciente);
        List<ZObjetoProDiag> Lista_zObjetoProdiag=new ArrayList<>();
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Condición ","Cantidad"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()]; 
        if(!Lista_ControlPaciente.isEmpty()){
            jbtnImprimir.setEnabled(true);
            String ol="images\\unsch.png";
            Image unsch=new Image(ImageDataFactory.create(ol));            
            int fontTamaño=9;
            int fontHeadTamaño=11;
            PdfWriter writer=null;
            try {
                writer=new PdfWriter("Carpeta_de_Archivos\\Reporte_Condicion.pdf"); 
                }
            catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(jPanel7, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso procedencia");
                jbtnImprimir.setEnabled(false);
                }
            PdfDocument pdf = new PdfDocument(writer);
            Document document=new Document(pdf,PageSize.A4);
            PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 
            Table table = new Table(new float[]{10,10});
            table.setWidthPercent(100); 
            Paragraph paragIma=new Paragraph("").add(unsch).add(
                new Text("                  REPORTE DE CONDICIONES DEL AÑO "+(new Date().getYear()+1900)).setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER));  
            document.add(paragIma);   
            Paragraph paraEscCodSerie=new Paragraph(new Text("reporte hasta la fecha de : ").setFont(bold))
                    .add(new Text(Herramienta.formatoFechaHora(new Date())).setFont(bold));
            document.add(paraEscCodSerie);            
            document.add(new Paragraph(" "));
            table.addHeaderCell(new Cell().add(new Paragraph("Condicion").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
            table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));  
            //Control_paciente control_paciente : Lista_ControlPaciente
            for(Rol objCondicion : listaCondiciones){
                int cant=0;
                for(Control_paciente control_paciente : Lista_ControlPaciente){
                    if(control_paciente.getEstudiante().getRolCondicion()==objCondicion){
                        cant++;          
                        }
                    }//fin for allreceta
                Lista_zObjetoProdiag.add(new ZObjetoProDiag(objCondicion,cant));
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
                JOptionPane.showMessageDialog(jPanel7, "No se encontró Procedentes/Diagnostico en el Rango de la Fecha");
                jbtnImprimir.setEnabled(false);
                }
            document.add(table);  
            document.close();   
            }//fin if vacío
        else{
            jbtnImprimir.setEnabled(false);
            llenar_Tabla_de_Recetas(modelo);    
            JOptionPane.showMessageDialog(jPanel7, "no se encontró recetas en este rango de Fecha");                     
        }
    }
    public void limpiarVista1(){
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JTable jtblRecetas;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Recetas(DefaultTableModel modelo){        
            jtblRecetas.setModel(modelo); 
            jtblRecetas.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblRecetas.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(1).setCellRenderer(tcr);
            
            jtblRecetas.setFont(new java.awt.Font("Tahoma", 0, 13));
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 16));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(100);//queda
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(100);
            
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
    
    

}
