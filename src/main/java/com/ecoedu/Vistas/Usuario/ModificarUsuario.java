package com.ecoedu.Vistas.Usuario;




import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Usuario;
import java.awt.Color;
import javax.persistence.PersistenceException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;





/*
1-agregar registrar un medicamento nuevo,cantidad,precio;
2-agregar cantidad a un medicamento ya existente;
3-Modificar precio Unitario de un Medicamento ya existente;
*/
public class ModificarUsuario extends javax.swing.JPanel {   
    Usuario objUsuario;
    Usuario objUsuarioLogueado;
    EntityManager jpa;
    Principal objPrincipal;
    List<Rol> Lista_Rol;
    List<Usuario> Lista_Usuario;
    int auxiliar=0;
    public ModificarUsuario(EntityManager objJPA,Principal OBJPrincipal,Usuario obj) {
        initComponents();
        this.objUsuarioLogueado=obj;
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;
           
    }
     public class Proceso extends Thread{
        public Proceso( ){
        
        }
        @Override
        public void run(){                 
            try {                
                    Thread.sleep(10000);
                jlblMensaje.setText("");
                } 
            catch (InterruptedException e) {
                System.out.println(e.toString());
                }
        }        
    }
    public void ConsultaBD(){       
            
        Lista_Rol=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles="+objUsuarioLogueado.getRol().getTipo_Roles().getId_tipo_Roles()).getResultList();  
        auxiliar=objUsuarioLogueado.getRol().getTipo_Roles().getId_tipo_Roles();
        Query query2=jpa.createQuery("SELECT p FROM Usuario p");
        Lista_Usuario=query2.getResultList(); 
      
    }   
    public void principalEjecucion(){  
        jtfApellidoMaterno.setText("");
        jtfApellidoPaterno.setText("");
        jtfDNI.setText("");
        jtfNombres.setText("");
        jbtnGuardarCambio.setEnabled(false);
        jcbRol.removeAllItems();
        for (Rol objRol : Lista_Rol){
            jcbRol.addItem(objRol);
        } 
        llenar_tabla_Medicamento(Lista_Usuario);
    }
    
    public void llenar_tabla_Medicamento(List<Usuario> listUsuario){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
                String [] lista={"Rol","Química(o) Farmacéutica(o)","nickname"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i <listUsuario.size(); i++){
                 if(listUsuario.get(i).getRol().getTipo_Roles().getId_tipo_Roles()==auxiliar){
                     fila_actividad[0]=listUsuario.get(i).getRol().getNombre_rol();
                     fila_actividad[1]=listUsuario.get(i);             
                     fila_actividad[2]=listUsuario.get(i).getNickname();
                     modelo.addRow(fila_actividad);//agregando filas
                     }
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
            jtblMedicamento.getColumnModel().getColumn(1).setPreferredWidth(200);
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
        jtfApellidoPaterno = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jbtnGuardarCambio = new javax.swing.JButton();
        jcbRol = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jtfNombres = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtfApellidoMaterno = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblMedicamento = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jlblAsteriscoDNI = new javax.swing.JLabel();
        jlblAsteriscoNombres = new javax.swing.JLabel();
        jlblAsteriscoApellidoPaterno = new javax.swing.JLabel();
        jlblAsteriscoApellidoMaterno = new javax.swing.JLabel();
        jlblMensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(900, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(100, 100, 0));
        head.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("MODIFICAR USUARIO");
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

        jtfApellidoPaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfApellidoPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoPaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoPaternoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 500, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apellido Paterno:");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 130, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nombres:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 70, -1));

        jLabel28.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel28.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 900, 10));

        jbtnGuardarCambio.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarCambio.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarCambio.setText("GUARDAR CAMBIOS");
        jbtnGuardarCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarCambioActionPerformed(evt);
            }
        });
        jPanel7.add(jbtnGuardarCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, -1, -1));

        jcbRol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbRol.setToolTipText("");
        jPanel7.add(jcbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 170, 25));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("DNI:");
        jLabel20.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 90, 25));

        jtfNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombresKeyTyped(evt);
            }
        });
        jPanel7.add(jtfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 500, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Apellido Materno:");
        jLabel21.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 130, 25));

        jtfDNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDNIKeyTyped(evt);
            }
        });
        jPanel7.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 160, 25));

        jLabel29.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel29.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 900, 10));

        jLabel30.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel30.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 900, 10));

        jLabel31.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel31.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 900, 10));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Rol:");
        jLabel22.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 90, 25));

        jtfApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfApellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoMaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoMaternoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 500, 25));

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

        jLabel32.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel10.add(jLabel32, java.awt.BorderLayout.LINE_START);

        jLabel33.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel10.add(jLabel33, java.awt.BorderLayout.LINE_END);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Lista de Usuario");
        jLabel34.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel11.add(jLabel34);

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Doble click para Modificar");
        jLabel7.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel12.add(jLabel7);

        jPanel10.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 170));

        jlblAsteriscoDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoDNI.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoDNI.setText("*");
        jPanel7.add(jlblAsteriscoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 10, 25));

        jlblAsteriscoNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoNombres.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoNombres.setText("*");
        jPanel7.add(jlblAsteriscoNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 10, 25));

        jlblAsteriscoApellidoPaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidoPaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidoPaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidoPaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 10, 25));

        jlblAsteriscoApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidoMaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidoMaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidoMaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 10, 25));

        jlblMensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        jlblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jlblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 900, 20));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfApellidoPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoPaternoKeyReleased

        if(!jtfApellidoPaterno.getText().isEmpty()){
            jlblAsteriscoApellidoPaterno.setText("");
        }
        else{
            jlblAsteriscoApellidoPaterno.setText("*");            
        }        
    }//GEN-LAST:event_jtfApellidoPaternoKeyReleased

    private void jbtnGuardarCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarCambioActionPerformed
                
        GuardarModificacion();
    }//GEN-LAST:event_jbtnGuardarCambioActionPerformed
    public void GuardarModificacion(){
        if(jlblAsteriscoApellidoMaterno.getText().isEmpty() && jlblAsteriscoApellidoPaterno.getText().isEmpty()
                && jlblAsteriscoDNI.getText().isEmpty() && jlblAsteriscoNombres.getText().isEmpty()){
        Persona objPersona=objUsuario.getPersona();  
        objUsuario.setRol((Rol)jcbRol.getSelectedItem());
        objPersona.setApellido_Materno(jtfApellidoMaterno.getText());
        objPersona.setApellido_Paterno(jtfApellidoPaterno.getText());
        objPersona.setDni(jtfDNI.getText());
        objPersona.setNombres(jtfNombres.getText()); 
        try{
            jpa.getTransaction().begin();
            jpa.persist(objPersona);  
            jpa.persist(objUsuario);
            jpa.createNativeQuery("update Usuario set id_Rol="+((Rol)jcbRol.getSelectedItem()).getId_Rol()+" where id_Usuario="+objUsuario.getId_Usuario()).executeUpdate();
            jpa.flush();
            objPrincipal.actualizar_Usuario(objUsuario);
            jlblMensaje.setText("se cambió con exito");
            new Proceso().start();
            jpa.getTransaction().commit();  
            limpiar();
            ConsultaBD();
            llenar_tabla_Medicamento(Lista_Usuario);  
        }
        catch(PersistenceException e){
            jlblMensaje.setText("el DNI ya está en uso");
            new Proceso().start();
            jpa.getTransaction().rollback();
            ConsultaBD();//volviendo a cargar los datos manejados por el JPA;
            principalEjecucion();
            }
        }
        else{
            JOptionPane.showMessageDialog(jtfNombres, "llene los espacio con *");            
        }
              
    }
    public void limpiar(){
        jtfApellidoMaterno.setText("");
        jtfApellidoPaterno.setText("");
        jtfDNI.setText("");
        jtfNombres.setText("");
        jlblAsteriscoApellidoMaterno.setText("*");
        jlblAsteriscoApellidoPaterno.setText("*");
        jlblAsteriscoDNI.setText("*");
        jlblAsteriscoNombres.setText("*");
    }
    private void jtfNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresKeyReleased
        if(!jtfNombres.getText().isEmpty()){
            jlblAsteriscoNombres.setText("");
        }
        else{
            jlblAsteriscoNombres.setText("*");
        }
    }//GEN-LAST:event_jtfNombresKeyReleased

    private void jtfDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyReleased
        if(jtfDNI.getText().length()>=8){
            jlblAsteriscoDNI.setText("");
        }
        else{
            jlblAsteriscoDNI.setText("*");            
        }
    }//GEN-LAST:event_jtfDNIKeyReleased

    private void jtfApellidoMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoMaternoKeyReleased
        if(!jtfApellidoMaterno.getText().isEmpty()){
            jlblAsteriscoApellidoMaterno.setText("");
        }
        else{
            jlblAsteriscoApellidoMaterno.setText("*");            
        }
    }//GEN-LAST:event_jtfApellidoMaternoKeyReleased

    private void jtblMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblMedicamentoMouseClicked
        objUsuario=(Usuario)jtblMedicamento.getValueAt(jtblMedicamento.getSelectedRow(),1);
        jtfNombres.setText(objUsuario.getPersona().getNombres());
        jtfApellidoPaterno.setText(objUsuario.getPersona().getApellido_Paterno());
        jtfApellidoMaterno.setText(objUsuario.getPersona().getApellido_Materno());
        jtfDNI.setText(objUsuario.getPersona().getDni());
        jbtnGuardarCambio.setEnabled(true);
        jcbRol.setSelectedItem(objUsuario.getRol());
        jlblAsteriscoApellidoMaterno.setText("");
        jlblAsteriscoApellidoPaterno.setText("");
        jlblAsteriscoDNI.setText("");
        jlblAsteriscoNombres.setText("");    
    }//GEN-LAST:event_jtblMedicamentoMouseClicked

    private void jtfDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyTyped
        if (jtfDNI.getText().length()>=8){             
         evt.consume(); 
         }     
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
        if(' '==validar){
            evt.consume();
            }
    }//GEN-LAST:event_jtfDNIKeyTyped

    private void jtfApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoMaternoKeyTyped
        if (jtfApellidoMaterno.getText().length()>=20){             
         evt.consume(); 
         }     
        char validar=evt.getKeyChar();
        if(!Character.isLetter(validar)){
            evt.consume();
            }
        if(!Character.isLowerCase(validar)){
            evt.setKeyChar(Character.toLowerCase(validar));
        }
    }//GEN-LAST:event_jtfApellidoMaternoKeyTyped

    private void jtfApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoPaternoKeyTyped
        if (jtfApellidoPaterno.getText().length()>=20){             
         evt.consume(); 
         }     
        char validar=evt.getKeyChar();
        if(!Character.isLetter(validar)){
            evt.consume();
            }
        if(!Character.isLowerCase(validar)){
            evt.setKeyChar(Character.toLowerCase(validar));
        }
        
    }//GEN-LAST:event_jtfApellidoPaternoKeyTyped

    private void jtfNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isLetter(validar)){
            evt.consume();
            }
        if(!Character.isLowerCase(validar)){
            evt.setKeyChar(Character.toLowerCase(validar));
        }
    }//GEN-LAST:event_jtfNombresKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyCard;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnGuardarCambio;
    private javax.swing.JComboBox<Rol> jcbRol;
    private javax.swing.JLabel jlblAsteriscoApellidoMaterno;
    private javax.swing.JLabel jlblAsteriscoApellidoPaterno;
    private javax.swing.JLabel jlblAsteriscoDNI;
    private javax.swing.JLabel jlblAsteriscoNombres;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JTable jtblMedicamento;
    private javax.swing.JTextField jtfApellidoMaterno;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfNombres;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
