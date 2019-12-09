package com.ecoedu.Vistas.Medicamento;



import com.ecoedu.Vistas.soloMayusculas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Inventario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.ecoedu.model.Medicamento;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;




/*
1-agregar registrar un medicamento nuevo,cantidad,precio;
2-agregar cantidad a un medicamento ya existente;
3-Modificar precio Unitario de un Medicamento ya existente;
*/
public class ModificarMedicamento extends javax.swing.JPanel{   
    List<Medicamento> Lista_Medicamento;
    EntityManager jpa;
    Principal objPrincipal;
    Medicamento objMedicamento;

    
    public ModificarMedicamento(EntityManager objJPA,Principal OBJPrincipal) {
        initComponents();
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;        
        ConsultaBD();
        principalEjecucion(); 
           
    }
    public void ConsultaBD(){
        Query query1=jpa.createQuery("SELECT p FROM Medicamento p");
        Lista_Medicamento=query1.getResultList();      
    }   
    public void principalEjecucion(){  
        llenar_tabla_Medicamento(Lista_Medicamento);
        jtfProductoFarmaceutico.setDocument(new soloMayusculas());
        jtfFormaFarmaceutica.setDocument(new soloMayusculas());
        jtfConcentracion.setDocument(new soloMayusculas());
    }

    public void llenar_tabla_Medicamento(List<Medicamento> listaMedicamento){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
                String [] lista={"Producto Farmaceutico","Concentraciòn","Forma Farmaceutica"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = listaMedicamento.size()-1; 0 <= i; i--){
                 fila_actividad[0]=listaMedicamento.get(i);
                 fila_actividad[1]=listaMedicamento.get(i).getConcentracion();             
                 fila_actividad[2]=listaMedicamento.get(i).getForma_farmaceutica();             
                 modelo.addRow(fila_actividad);//agregando filas
                 }        
            jtblMedicamento.setModel(modelo); 
            jtblMedicamento.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblMedicamento.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblMedicamento.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblMedicamento.getColumnModel().getColumn(2).setCellRenderer(tcr);
   
            jtblMedicamento.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblMedicamento.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblMedicamento.getTableHeader().setBackground(Color.BLUE);
            jtblMedicamento.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblMedicamento.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtblMedicamento.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblMedicamento.getColumnModel().getColumn(2).setPreferredWidth(100);    
            ((DefaultTableCellRenderer)jtblMedicamento.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bodyCard = new javax.swing.JPanel();
        vistaLlenar = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jtfProductoFarmaceutico = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtfConcentracion = new javax.swing.JTextField();
        jbtnModificar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblMedicamento = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtfFormaFarmaceutica = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(900, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(204, 102, 0));
        head.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("MODIFICAR MEDICAMENTOS");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        bodyCard.setLayout(new java.awt.CardLayout());

        vistaLlenar.setBackground(new java.awt.Color(255, 255, 255));
        vistaLlenar.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfProductoFarmaceutico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfProductoFarmaceutico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfProductoFarmaceutico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfProductoFarmaceuticoKeyReleased(evt);
            }
        });
        jPanel7.add(jtfProductoFarmaceutico, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 640, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Forma Farmaceutica");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 140, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Producto Farmaceutico:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 160, -1));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Concentración");
        jLabel23.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 100, 25));

        jLabel25.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel25.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 900, 10));

        jLabel28.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel28.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 900, 10));

        jtfConcentracion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfConcentracion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfConcentracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 140, 25));

        jbtnModificar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnModificar.setText("GUARDAR MODIFICACIÓN");
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });
        jPanel7.add(jbtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, -1, -1));

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 200));

        jtblMedicamento.setBorder(new javax.swing.border.MatteBorder(null));
        jtblMedicamento.setModel(new javax.swing.table.DefaultTableModel(
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
                "Fecha", "Producto Farmaceutico", "Cantidad", "Monto"
            }
        ));
        jtblMedicamento.setGridColor(new java.awt.Color(0, 0, 0));
        jtblMedicamento.setMaximumSize(new java.awt.Dimension(2147483647, 32312310));
        jtblMedicamento.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtblMedicamento);

        jPanel10.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jLabel29.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel10.add(jLabel29, java.awt.BorderLayout.LINE_START);

        jLabel30.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel10.add(jLabel30, java.awt.BorderLayout.LINE_END);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Lista de Medicamento Actual");
        jLabel31.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel11.add(jLabel31);

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Doble click para Modificar");
        jLabel7.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel12.add(jLabel7);

        jPanel10.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 200));

        jtfFormaFarmaceutica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFormaFarmaceutica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfFormaFarmaceutica, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 120, 25));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfProductoFarmaceuticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfProductoFarmaceuticoKeyReleased
       
        
    }//GEN-LAST:event_jtfProductoFarmaceuticoKeyReleased

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jtblMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblMedicamentoMouseClicked
        objMedicamento=(Medicamento)jtblMedicamento.getValueAt(jtblMedicamento.getSelectedRow(),0);
        jtfProductoFarmaceutico.setText(objMedicamento.getNombre());
        jtfFormaFarmaceutica.setText(objMedicamento.getForma_farmaceutica());
        jtfConcentracion.setText(objMedicamento.getConcentracion());
    }//GEN-LAST:event_jtblMedicamentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyCard;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JTable jtblMedicamento;
    private javax.swing.JTextField jtfConcentracion;
    private javax.swing.JTextField jtfFormaFarmaceutica;
    private javax.swing.JTextField jtfProductoFarmaceutico;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
