package com.ecoedu.Vistas;



import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.model.Lote_detalle;
import java.awt.Color;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class Lista_De_Vencimientos extends javax.swing.JPanel{
    EntityManager jpa;
    List<Lote_detalle> lotes_por_vencer;
    List<Lote_detalle> lotes_por_vencidos;
    CuadroCarritoMedicinas objCuadroCarrtio;
    public Lista_De_Vencimientos(EntityManager objJpa,CuadroCarritoMedicinas obj){
        initComponents();
        this.jpa=objJpa;      
        this.objCuadroCarrtio=obj;
        ConsultaBD();
        principalEjecucion();        
    }
    public void principalEjecucion(){      
        llenar_tabla_LoteDetalle(lotes_por_vencer);
        jlblPorvencer.setText("POR VENCER: "+lotes_por_vencer.size());
        llenar_tabla_LoteDetalleVencidos(lotes_por_vencidos);
        jlblVencidos.setText("VENCIDOS: "+lotes_por_vencidos.size());
        desglozarDatos(); 
     }
    public void ConsultaBD(){
        lotes_por_vencidos=jpa.createQuery("select p from Lote_detalle p where  DATEDIFF(day,  GETDATE(),fecha_vencimiento)<=0 and isVencido=0").getResultList();
        lotes_por_vencer=jpa.createQuery("select p from Lote_detalle p where  DATEDIFF(day,  GETDATE(),fecha_vencimiento)<60 and DATEDIFF(day,  GETDATE(),fecha_vencimiento)>0").getResultList();

    }
    
    public void desglozarDatos(){
         
         }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnAgregar = new javax.swing.JButton();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jbtlVencidos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblPorVencer = new javax.swing.JTable();
        jlblVencidos = new javax.swing.JLabel();
        jlblPorvencer = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(100, 176));
        setPreferredSize(new java.awt.Dimension(700, 350));
        setLayout(new java.awt.BorderLayout());

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setMaximumSize(new java.awt.Dimension(700, 300));
        contenedor.setMinimumSize(new java.awt.Dimension(700, 300));
        contenedor.setName(""); // NOI18N
        contenedor.setPreferredSize(new java.awt.Dimension(700, 300));
        contenedor.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 345));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar.setText("OK");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 316, 210, -1));

        head.setBackground(new java.awt.Color(204, 0, 0));
        head.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("LISTA DE MEDICAMENTOS VENCIDOS Y POR VENCER");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 30));
        head.add(jLabel12);

        jPanel2.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 40));

        jbtlVencidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jbtlVencidos);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 660, 100));

        jtblPorVencer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtblPorVencer);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 660, 100));

        jlblVencidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblVencidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblVencidos.setText("VENCIDOS:");
        jPanel2.add(jlblVencidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 180, 700, 25));

        jlblPorvencer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblPorvencer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPorvencer.setText("POR VENCER:");
        jPanel2.add(jlblPorvencer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 700, 25));

        contenedor.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(contenedor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
       objCuadroCarrtio.setVisible(false);
       
    }//GEN-LAST:event_jbtnAgregarActionPerformed
    public void llenar_tabla_LoteDetalle(List<Lote_detalle> listaLote){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cantidad","Fecha Venc."}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false,false,false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i < listaLote.size(); i++){
                 fila_actividad[0]=listaLote.get(i).getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=listaLote.get(i);
                 fila_actividad[2]=listaLote.get(i).getCantidad();             
                 fila_actividad[3]=Herramienta.formatoFechaMas1(listaLote.get(i).getFecha_vencimiento());
                             
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
             
             
            jtblPorVencer.setModel(modelo); 
            jtblPorVencer.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblPorVencer.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblPorVencer.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblPorVencer.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblPorVencer.getColumnModel().getColumn(3).setCellRenderer(tcr);
           
            jtblPorVencer.setFont(new java.awt.Font("Tahoma", 0, 12));
            jtblPorVencer.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15));
            jtblPorVencer.getTableHeader().setBackground(Color.BLUE);
            jtblPorVencer.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblPorVencer.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtblPorVencer.getColumnModel().getColumn(1).setPreferredWidth(115);
            jtblPorVencer.getColumnModel().getColumn(2).setPreferredWidth(85);    
            jtblPorVencer.getColumnModel().getColumn(3).setPreferredWidth(60);
           
            ((DefaultTableCellRenderer)jtblPorVencer.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    public void llenar_tabla_LoteDetalleVencidos(List<Lote_detalle> listaLote){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cantidad","Fecha Venc."}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false,false,false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i < listaLote.size(); i++){
                 fila_actividad[0]=listaLote.get(i).getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=listaLote.get(i);
                 fila_actividad[2]=listaLote.get(i).getCantidad();             
                 fila_actividad[3]=Herramienta.formatoFechaMas1(listaLote.get(i).getFecha_vencimiento());
                             
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
             
             
            jbtlVencidos.setModel(modelo); 
            jbtlVencidos.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jbtlVencidos.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jbtlVencidos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jbtlVencidos.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jbtlVencidos.getColumnModel().getColumn(3).setCellRenderer(tcr);
           
            jbtlVencidos.setFont(new java.awt.Font("Tahoma", 0, 12));
            jbtlVencidos.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15));
            jbtlVencidos.getTableHeader().setBackground(Color.BLUE);
            jbtlVencidos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jbtlVencidos.getColumnModel().getColumn(0).setPreferredWidth(200);
            jbtlVencidos.getColumnModel().getColumn(1).setPreferredWidth(115);
            jbtlVencidos.getColumnModel().getColumn(2).setPreferredWidth(85);    
            jbtlVencidos.getColumnModel().getColumn(3).setPreferredWidth(60);
           
            ((DefaultTableCellRenderer)jbtlVencidos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jbtlVencidos;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JLabel jlblPorvencer;
    private javax.swing.JLabel jlblVencidos;
    private javax.swing.JTable jtblPorVencer;
    // End of variables declaration//GEN-END:variables
}
