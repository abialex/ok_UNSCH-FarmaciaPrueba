package com.ecoedu.Vistas.ProveedorFabricante;




import com.ecoedu.Vistas.soloMayusculas;
import com.ecoedu.Vistas.vista_base.Principal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Tipo_Roles;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;




/*Modficacion
1-agregar registrar un medicamento nuevo,cantidad,precio;
2-agregar cantidad a un medicamento ya existente;
3-Modificar precio Unitario de un Medicamento ya existente;
*/
public class ProveedorLaboratorio extends javax.swing.JPanel{   
    List<Rol> Lista_LabProv;
    EntityManager jpa;
    Principal objPrincipal;
    List<Tipo_Roles> Lista_Roles;
    
    Rol objFaPro;
    
    
    public ProveedorLaboratorio(EntityManager objJPA,Principal OBJPrincipal) {
        initComponents();
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;
           
    }
    public void ConsultaBD(){
        Query query1=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=3 or id_tipo_Roles=2");
        Lista_LabProv=query1.getResultList();    
        Lista_Roles=jpa.createQuery("SELECT p FROM Tipo_Roles p ").getResultList();
    }   
    public void principalEjecucion(){  
        jRbModificar.setSelected(false);
        jrbCrear.setSelected(true);
        jtfFabricanteProveedorCambio.setEnabled(false);
        jcbPROFaCambio.setEnabled(false);
        jbtnCambios.setEnabled(false);
        llenar_tabla_Medicamento(Lista_LabProv);
        jtfFabricanteProveedorCambio.setDocument(new soloMayusculas());
        jtfFabricanteGuardar.setDocument(new soloMayusculas());
        jbtnCambios.setEnabled(false);        
        
    }

    public void llenar_tabla_Medicamento(List<Rol> listLABPRO){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
                String [] lista={"Nombre","Tipo"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i=listLABPRO.size()-1;i>=0;i--){
                 fila_actividad[0]=listLABPRO.get(i);
                 fila_actividad[1]=listLABPRO.get(i).getTipo_Roles().getNombre_rol();           
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
            jbtlProFa.setModel(modelo); 
            jbtlProFa.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jbtlProFa.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jbtlProFa.getColumnModel().getColumn(1).setCellRenderer(tcr);

   
            jbtlProFa.setFont(new java.awt.Font("Tahoma", 0, 15));
            jbtlProFa.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jbtlProFa.getTableHeader().setBackground(Color.BLUE);
            jbtlProFa.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jbtlProFa.getColumnModel().getColumn(0).setPreferredWidth(100);
            jbtlProFa.getColumnModel().getColumn(1).setPreferredWidth(150); 
            ((DefaultTableCellRenderer)jbtlProFa.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bodyCard = new javax.swing.JPanel();
        vistaLlenar = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jtfFabricanteProveedorCambio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jbtnCambios = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jbtlProFa = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcbPROFaCambio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jtfFabricanteGuardar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcbPROFa1 = new javax.swing.JComboBox<>();
        jbtnCambios1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jrbCrear = new javax.swing.JRadioButton();
        jRbModificar = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(900, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(153, 255, 204));
        head.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CREAR O MODIFICAR PROVEEDOR/LABORATORIO");
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

        jtfFabricanteProveedorCambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFabricanteProveedorCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfFabricanteProveedorCambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfFabricanteProveedorCambioKeyReleased(evt);
            }
        });
        jPanel7.add(jtfFabricanteProveedorCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 290, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tipo:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 60, -1));

        jLabel28.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel28.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 900, 10));

        jbtnCambios.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCambios.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambios.setText("GUARDAR CAMBIOS");
        jbtnCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCambiosActionPerformed(evt);
            }
        });
        jbtnCambios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCambiosKeyPressed(evt);
            }
        });
        jPanel7.add(jbtnCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 180, -1));

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 200));

        jbtlProFa.setBorder(new javax.swing.border.MatteBorder(null));
        jbtlProFa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Producto Farmaceutico"
            }
        ));
        jbtlProFa.setFocusable(false);
        jbtlProFa.setGridColor(new java.awt.Color(0, 0, 0));
        jbtlProFa.setMaximumSize(new java.awt.Dimension(2147483647, 32312310));
        jbtlProFa.setMinimumSize(new java.awt.Dimension(500, 100));
        jbtlProFa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtlProFaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jbtlProFa);

        jPanel10.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jLabel29.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel10.add(jLabel29, java.awt.BorderLayout.LINE_START);

        jLabel30.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel10.add(jLabel30, java.awt.BorderLayout.LINE_END);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Lista Proveedor / Laboratorio");
        jLabel33.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel11.add(jLabel33);

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

        jcbPROFaCambio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laboratorio", "Proveedor" }));
        jPanel7.add(jcbPROFaCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 150, 25));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Nombre: ");
        jLabel8.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 70, -1));

        jtfFabricanteGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFabricanteGuardar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfFabricanteGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfFabricanteGuardarKeyReleased(evt);
            }
        });
        jPanel7.add(jtfFabricanteGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 290, 25));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Nombre: ");
        jLabel9.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 70, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Tipo:");
        jLabel10.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 60, -1));

        jcbPROFa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laboratorio", "Proveedor" }));
        jPanel7.add(jcbPROFa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 150, 25));

        jbtnCambios1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCambios1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCambios1.setText("CREAR");
        jbtnCambios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCambios1ActionPerformed(evt);
            }
        });
        jbtnCambios1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCambios1KeyPressed(evt);
            }
        });
        jPanel7.add(jbtnCambios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 180, -1));

        jLabel32.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Lista Proveedor / Fabricante");
        jLabel32.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 280));

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Crear Proveedor o Laboratorio");
        jLabel31.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 230, -1));

        buttonGroup1.add(jrbCrear);
        jrbCrear.setFocusable(false);
        jrbCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbCrearMouseClicked(evt);
            }
        });
        jPanel7.add(jrbCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        buttonGroup1.add(jRbModificar);
        jRbModificar.setFocusable(false);
        jRbModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRbModificarMouseClicked(evt);
            }
        });
        jPanel7.add(jRbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfFabricanteProveedorCambioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFabricanteProveedorCambioKeyReleased
       
        
    }//GEN-LAST:event_jtfFabricanteProveedorCambioKeyReleased

    private void jbtnCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCambiosActionPerformed
        modificarProveedorOLaboratorio();
    }//GEN-LAST:event_jbtnCambiosActionPerformed

    public void modificarProveedorOLaboratorio(){
        if(!jtfFabricanteProveedorCambio.getText().isEmpty()){
            jpa.getTransaction().begin();
        if(((String)jcbPROFaCambio.getSelectedItem()).equals("Laboratorio")){
            objFaPro.setNombre_rol(jtfFabricanteProveedorCambio.getText());
            jpa.persist(objFaPro);
            jpa.createNativeQuery("update Rol set id_tipo_Roles=3"+" where id_Rol="+objFaPro.getId_Rol()).executeUpdate();
        }
        else{
            objFaPro.setNombre_rol(jtfFabricanteProveedorCambio.getText());
            jpa.persist(objFaPro);
            jpa.createNativeQuery("update Rol set id_tipo_Roles=2"+" where id_Rol="+objFaPro.getId_Rol()).executeUpdate();
            }
        jpa.getTransaction().commit();
        ConsultaBD();
        jtfFabricanteProveedorCambio.setText("");
        llenar_tabla_Medicamento(Lista_LabProv);
            
        }
        else{
            JOptionPane.showMessageDialog(jPanel7, "ingrese un nombre");
        }
        
    }
    private void jbtlProFaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtlProFaMouseClicked

        
        objFaPro=(Rol)jbtlProFa.getValueAt(jbtlProFa.getSelectedRow(),0);
        jtfFabricanteProveedorCambio.setText(objFaPro.getNombre_rol());
        jcbPROFaCambio.setSelectedItem(objFaPro.getTipo_Roles().getNombre_rol());
        jRbModificar.setSelected(true);
        jrbCrear.setSelected(false);
        jtfFabricanteProveedorCambio.setEnabled(true);
        jcbPROFaCambio.setEnabled(true);
        jbtnCambios.setEnabled(true);  
        
        jtfFabricanteGuardar.setEnabled(false);
        jcbPROFa1.setEnabled(false);
        jbtnCambios1.setEnabled(false);
        
    
    }//GEN-LAST:event_jbtlProFaMouseClicked

    private void jtfFabricanteGuardarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFabricanteGuardarKeyReleased
        jbtnCambios.setEnabled(false);
        jbtnCambios1.setEnabled(true);
    }//GEN-LAST:event_jtfFabricanteGuardarKeyReleased

    public void guardarProveedorOLab(){
        if(!jtfFabricanteGuardar.getText().isEmpty()){
         Rol objFaprovi=new Rol();
        objFaprovi.setAbre_rol("");
        jpa.getTransaction().begin();
        
        if(((String)jcbPROFa1.getSelectedItem()).equals("Proveedor")){
            objFaprovi.setNombre_rol(jtfFabricanteGuardar.getText());
            for (Tipo_Roles roles : Lista_Roles){
                if (roles.getId_tipo_Roles()==2){
                    objFaprovi.setTipo_Roles(roles);
                    }
                }
            }
        else{
            objFaprovi.setNombre_rol(jtfFabricanteGuardar.getText());
            for (Tipo_Roles roles : Lista_Roles){
                if (roles.getId_tipo_Roles()==3){
                    objFaprovi.setTipo_Roles(roles);
                    }
                }
            }  
        jpa.persist(objFaprovi);
        jpa.getTransaction().commit();
        ConsultaBD();
        jtfFabricanteGuardar.setText("");
        llenar_tabla_Medicamento(Lista_LabProv);}
        else{
            JOptionPane.showMessageDialog(jPanel7, "ingrese un nombre");
        }
        
    }
    private void jbtnCambios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCambios1ActionPerformed
        guardarProveedorOLab();
        
    }//GEN-LAST:event_jbtnCambios1ActionPerformed

    private void jrbCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbCrearMouseClicked
       jRbModificar.setSelected(false);
        jrbCrear.setSelected(true);
        if(jrbCrear.isSelected()){
            jtfFabricanteProveedorCambio.setEnabled(false);
            jcbPROFaCambio.setEnabled(false);
            jbtnCambios.setEnabled(false);
            jtfFabricanteGuardar.setEnabled(true);
            jcbPROFa1.setEnabled(true);
            jbtnCambios1.setEnabled(true);
        }
        
    }//GEN-LAST:event_jrbCrearMouseClicked

    private void jRbModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRbModificarMouseClicked
        jRbModificar.setSelected(true);
        jrbCrear.setSelected(false);
        if(jRbModificar.isSelected()){
            jtfFabricanteProveedorCambio.setEnabled(true);
            jcbPROFaCambio.setEnabled(true);
            jbtnCambios.setEnabled(true);     
            jtfFabricanteGuardar.setEnabled(false);
            jcbPROFa1.setEnabled(false);
            jbtnCambios1.setEnabled(false);
            }        
    }//GEN-LAST:event_jRbModificarMouseClicked

    private void jbtnCambios1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCambios1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            guardarProveedorOLab();
        }
    }//GEN-LAST:event_jbtnCambios1KeyPressed

    private void jbtnCambiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCambiosKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            modificarProveedorOLaboratorio();
        }
    }//GEN-LAST:event_jbtnCambiosKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyCard;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRbModificar;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jbtlProFa;
    private javax.swing.JButton jbtnCambios;
    private javax.swing.JButton jbtnCambios1;
    private javax.swing.JComboBox<String> jcbPROFa1;
    private javax.swing.JComboBox<String> jcbPROFaCambio;
    private javax.swing.JRadioButton jrbCrear;
    private javax.swing.JTextField jtfFabricanteGuardar;
    private javax.swing.JTextField jtfFabricanteProveedorCambio;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
