package com.ecoedu.Vistas.ServicioFarmacia;


import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Inventario;
import com.ecoedu.model.Lote_detalle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class Cantidad_Medicinas extends javax.swing.JPanel{
    EntityManager jpa;
    CuadroCarritoMedicinas objCuadroCarritoMedicinas;
    List<Inventario> list_Inventario=new ArrayList<>();
    List<Lote_detalle> list_Lote_detalle;
    Detalle_Medicamentos objDetalle_Medicamento_Final=new Detalle_Medicamentos();
    ServicioFarmacia objServicioFarmacia;
    public Cantidad_Medicinas(EntityManager objJpa,CuadroCarritoMedicinas objCuadroCarritoMedicinas,ServicioFarmacia OBJServicioFarmacia){
        initComponents();
        this.jpa=objJpa;
        this.objServicioFarmacia=OBJServicioFarmacia;
        this.objCuadroCarritoMedicinas=objCuadroCarritoMedicinas;  
        principalEjecucion();        
    }       
  
    public void principalEjecucion(){
        list_Lote_detalle=objServicioFarmacia.getListaInventario();
        desglozarDatos(); 
        llenar_Tabla_de_medicamentos_parecidos(getMedicamentosParecidos(""));
        
     }
    
    public void desglozarDatos(){
         //lista_Inventario
         for (int i = 1; i < list_Lote_detalle.size(); i++){
            boolean auxInventario=true;
            for (int j = 0; j < list_Inventario.size(); j++){
                if(list_Inventario.get(j)==list_Lote_detalle.get(i).getInventario()){
                    auxInventario=false;		
                    break;
                    }
                }
            if(auxInventario){
                list_Inventario.add(list_Lote_detalle.get(i).getInventario());
                }
            }
         }
     public List<Inventario> getMedicamentosParecidos(String palabra){
        List<Inventario> listaInventario=new ArrayList<>();
        for (int n = 0; n < list_Inventario.size(); n++) {
            boolean aux=true;
            for (int i = 0; i<palabra.length(); i++) {               
                if(palabra.charAt(i)!=list_Inventario.get(n).getId_Medicamento().getNombre().charAt(i)){
                    aux=false;
                    break;                   
                }            
            }
            if(aux){
                listaInventario.add(list_Inventario.get(n));
            }
        }
        return listaInventario;        
    }
     public void llenar_Tabla_de_medicamentos_parecidos(List<Inventario> listaInventario){
         DefaultTableModel modelo;
         Object[] fila_actividad;
         //.....................................TABLA......................................
         String [] lista={"Código","Medicamento","Cantidad"}; 
         modelo=new DefaultTableModel(null,lista){
             boolean[] canEdit = new boolean [] {false, false, false};
             @Override
             public boolean isCellEditable(int rowIndex, int columnIndex){
                 return canEdit [columnIndex];
                     }
             };
         //.....................................TABLA...........Fin......................
         fila_actividad=new Object[modelo.getColumnCount()];  
         for (int i = 0; i < listaInventario.size(); i++){
             fila_actividad[0]=listaInventario.get(i).getId_Inventario();
             fila_actividad[1]=listaInventario.get(i).getId_Medicamento().getNombre();             
             fila_actividad[2]=listaInventario.get(i).getCantidad();     
             modelo.addRow(fila_actividad);//agregando filas
             }
         jtlblInventario.setModel(modelo);
         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
         tcr.setHorizontalAlignment(SwingConstants.CENTER);
         jtlblInventario.getColumnModel().getColumn(0).setCellRenderer(tcr);
         jtlblInventario.getColumnModel().getColumn(1).setCellRenderer(tcr);
         jtlblInventario.getColumnModel().getColumn(2).setCellRenderer(tcr);     
         
         jtlblInventario.setFont(new java.awt.Font("Tahoma", 0, 15));
         jtlblInventario.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
         jtlblInventario.getTableHeader().setBackground(Color.BLUE);
         jtlblInventario.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
         jtlblInventario.getColumnModel().getColumn(0).setPreferredWidth(119);
         jtlblInventario.getColumnModel().getColumn(1).setPreferredWidth(273);
         jtlblInventario.getColumnModel().getColumn(2).setPreferredWidth(75);
         ((DefaultTableCellRenderer)jtlblInventario.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jtfMedicamento = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtlblInventario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblProductoFarmaceutico = new javax.swing.JLabel();
        jlblPrecioUnitario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jlblFechaVencimiento = new javax.swing.JLabel();
        jlblPrecioTotal2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlblPrecioTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlblLoteNombre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(100, 176));
        setPreferredSize(new java.awt.Dimension(700, 300));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setMaximumSize(new java.awt.Dimension(700, 300));
        contenedor.setMinimumSize(new java.awt.Dimension(700, 300));
        contenedor.setName(""); // NOI18N
        contenedor.setPreferredSize(new java.awt.Dimension(700, 300));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(700, 149));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel37.setText("Nombre Medicamento :");
        jPanel23.add(jLabel37);

        jtfMedicamento.setPreferredSize(new java.awt.Dimension(150, 30));
        jtfMedicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMedicamentoKeyReleased(evt);
            }
        });
        jPanel23.add(jtfMedicamento);

        jPanel22.add(jPanel23, java.awt.BorderLayout.PAGE_START);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel22.add(jLabel38, java.awt.BorderLayout.LINE_START);

        jLabel39.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel22.add(jLabel39, java.awt.BorderLayout.LINE_END);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(452, 250));

        jtlblInventario.setBorder(new javax.swing.border.MatteBorder(null));
        jtlblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Producto Farmacèutico", "Cantidad Disponible", "Precio Unitario"
            }
        ));
        jtlblInventario.setGridColor(new java.awt.Color(0, 0, 0));
        jtlblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtlblInventarioMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtlblInventario);

        jPanel22.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        contenedor.add(jPanel22);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 149));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Producto Farmaceutico:");
        jLabel1.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        jlblProductoFarmaceutico.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jlblProductoFarmaceutico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblProductoFarmaceutico.setPreferredSize(new java.awt.Dimension(320, 20));
        jPanel1.add(jlblProductoFarmaceutico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 440, -1));

        jlblPrecioUnitario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblPrecioUnitario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPrecioUnitario.setPreferredSize(new java.awt.Dimension(320, 20));
        jPanel1.add(jlblPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Cantidad:");
        jLabel5.setPreferredSize(new java.awt.Dimension(130, 20));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, -1));

        jtfCantidad.setPreferredSize(new java.awt.Dimension(100, 25));
        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyReleased(evt);
            }
        });
        jPanel1.add(jtfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Precio Total:");
        jLabel7.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 90, -1));

        jlblFechaVencimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblFechaVencimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblFechaVencimiento.setPreferredSize(new java.awt.Dimension(105, 20));
        jPanel1.add(jlblFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 140, -1));

        jlblPrecioTotal2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblPrecioTotal2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblPrecioTotal2.setText("S/");
        jlblPrecioTotal2.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel1.add(jlblPrecioTotal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 20, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jLabel4.setText("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel4.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 680, 10));

        jLabel6.setText("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel6.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 680, 10));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Precio Unitario:");
        jLabel8.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, -1));

        jlblPrecioTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblPrecioTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblPrecioTotal.setText("0.00");
        jlblPrecioTotal.setPreferredSize(new java.awt.Dimension(105, 20));
        jPanel1.add(jlblPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 60, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Lote:");
        jLabel9.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 40, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Fecha Ven.");
        jLabel10.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 80, -1));

        jlblLoteNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblLoteNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblLoteNombre.setPreferredSize(new java.awt.Dimension(105, 20));
        jPanel1.add(jlblLoteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 130, -1));

        contenedor.add(jPanel1);

        add(contenedor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        if(!jtfCantidad.getText().equals("")){
           jlblPrecioTotal.setText(Herramienta.dosDecimales(Float.parseFloat(jlblPrecioUnitario.getText())*Float.parseFloat(jtfCantidad.getText())));
        }
        else{
           jlblPrecioTotal.setText(Herramienta.dosDecimales(0));
        }
    }//GEN-LAST:event_jtfCantidadKeyReleased

    private void jtlblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtlblInventarioMouseClicked
        int valor =Integer.parseInt(jtlblInventario.getValueAt(jtlblInventario.getSelectedRow(),0).toString());
        List<Lote_detalle> auxlista_Lote_detalle=new ArrayList<>();
        for (int i = 0; i <list_Lote_detalle.size(); i++){
            if(valor==list_Lote_detalle.get(i).getInventario().getId_Inventario()){
                auxlista_Lote_detalle.add(list_Lote_detalle.get(i));
            }//if fin            
        }//for fin
        for (int i = 0; i < list_Inventario.size(); i++){
            if(valor==list_Inventario.get(i).getId_Inventario()){
                objDetalle_Medicamento_Final.setId_Medicamento(list_Inventario.get(i).getId_Medicamento());
                break;
            }
        }//reutilizando el medicamento que ya me dio para luego guardarlo
        Lote_detalle objLoteDetalle=fechaVencimientoCercano(auxlista_Lote_detalle);
        jlblFechaVencimiento.setText(Herramienta.formatoFecha(objLoteDetalle.getFecha_vencimiento()));
        jlblLoteNombre.setText(objLoteDetalle.getCodigo());        
        jlblProductoFarmaceutico.setText(jtlblInventario.getValueAt(jtlblInventario.getSelectedRow(),1).toString());
        jlblPrecioUnitario.setText(Float.toString(objLoteDetalle.getPrecio_Venta_Redondeado()));
        //
        objDetalle_Medicamento_Final.setLote_detalle(objLoteDetalle);
        objDetalle_Medicamento_Final.setFecha(new Date());        
        objDetalle_Medicamento_Final.setPrecio_Unitario(Float.parseFloat(jlblPrecioUnitario.getText()));
        /*
        id_Medicamento
        id_Lote_Detalle
        fecha
        ( va "cantidad" en botton guardar)
        ( va "precio total" en botton guardar)
        (no va "id_receta")
        (na va "id usuario")
        precio_unitario
        */
    }//GEN-LAST:event_jtlblInventarioMouseClicked

    private void jtfMedicamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMedicamentoKeyReleased
        llenar_Tabla_de_medicamentos_parecidos(getMedicamentosParecidos(jtfMedicamento.getText())); 
    }//GEN-LAST:event_jtfMedicamentoKeyReleased
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!jtfCantidad.getText().equals("")){
        objDetalle_Medicamento_Final.setCantidad(Integer.parseInt(jtfCantidad.getText()));
        objDetalle_Medicamento_Final.setPrecio_Total(Float.parseFloat(jlblPrecioTotal.getText()));        
        objServicioFarmacia.getListaCarritos(objDetalle_Medicamento_Final);  
        objCuadroCarritoMedicinas.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        objCuadroCarritoMedicinas.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public Lote_detalle fechaVencimientoCercano(List<Lote_detalle> listaLoteDetalle){
        
        Date hoy = new Date();
        Lote_detalle LDprimero=listaLoteDetalle.get(0);
        for(int i = 1; i < listaLoteDetalle.size(); i++){
            if(LDprimero.getFecha_vencimiento().getTime()>listaLoteDetalle.get(i).getFecha_vencimiento().getTime()){
                LDprimero=listaLoteDetalle.get(i);
            }                        
        }
        return LDprimero;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlblFechaVencimiento;
    private javax.swing.JLabel jlblLoteNombre;
    private javax.swing.JLabel jlblPrecioTotal;
    private javax.swing.JLabel jlblPrecioTotal2;
    private javax.swing.JLabel jlblPrecioUnitario;
    private javax.swing.JLabel jlblProductoFarmaceutico;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfMedicamento;
    private javax.swing.JTable jtlblInventario;
    // End of variables declaration//GEN-END:variables
}
