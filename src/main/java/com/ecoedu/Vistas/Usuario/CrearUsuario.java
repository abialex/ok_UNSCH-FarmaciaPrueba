package com.ecoedu.Vistas.Usuario;




import com.ecoedu.Vistas.vista_base.Principal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.ecoedu.model.Persona;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Usuario;
import java.awt.event.KeyEvent;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;




/*
1-agregar registrar un medicamento nuevo,cantidad,precio;
2-agregar cantidad a un medicamento ya existente;
3-Modificar precio Unitario de un Medicamento ya existente;
*/
public class CrearUsuario extends javax.swing.JPanel {   
    EntityManager jpa;
    Principal objPrincipal;
    List<Rol> Lista_Rol;
    public CrearUsuario(EntityManager objJPA,Principal OBJPrincipal) {
        initComponents();
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;
         
           
    }
    public class Proceso extends Thread{
        Usuario objUsuario;
        boolean hola;
        public Proceso(Usuario objUsuario,boolean ola){
            this.hola=ola;
            this.objUsuario = objUsuario;
        }
        public Proceso(boolean ola){
            this.hola=ola;
        }
        @Override
        public void run(){                 
            try {     
                
                for (int i = 0; i < 11; i++) {
                    if(hola){
                    jlblMensaje.setText("El nickname es: "+objUsuario.getNickname()+" y su contraseña es su DNI "+i);} 
                    Thread.sleep(1000);
                }
                jlblMensaje.setText("");
                } 
            catch (InterruptedException e) {
                System.out.println(e.toString());
                }
        }        
    }
    public void ConsultaBD(){
        Query query1=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=7");
        Lista_Rol=query1.getResultList();       
    }   
    public void principalEjecucion(){  
        jcbRol.removeAllItems();
        for (Rol objRol : Lista_Rol){
            jcbRol.addItem(objRol);
        }
        
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
        jButton3 = new javax.swing.JButton();
        jcbRol = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jtfNombres = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtfApellidoMaterno = new javax.swing.JTextField();
        jlblAsteriscoDNI = new javax.swing.JLabel();
        jlblAsteriscoNombres = new javax.swing.JLabel();
        jlblAsteriscoApellidosPaterno = new javax.swing.JLabel();
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
        jLabel12.setText("CREAR USUARIO");
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
        jPanel7.add(jtfApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 500, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apellido Paterno:");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 130, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nombres:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 70, -1));

        jLabel28.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel28.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 900, 10));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar Usuario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        jcbRol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbRol.setToolTipText("");
        jPanel7.add(jcbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 150, 25));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("DNI:");
        jLabel20.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 140, 25));

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
        jPanel7.add(jtfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 500, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Apellido Materno:");
        jLabel21.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 130, 25));

        jtfDni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDniKeyTyped(evt);
            }
        });
        jPanel7.add(jtfDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 160, 25));

        jLabel29.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel29.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 10));

        jLabel30.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel30.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 900, 10));

        jLabel31.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel31.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 900, 10));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Rol:");
        jLabel22.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 90, 25));

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
        jPanel7.add(jtfApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 500, 25));

        jlblAsteriscoDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoDNI.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoDNI.setText("*");
        jPanel7.add(jlblAsteriscoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 10, 25));

        jlblAsteriscoNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoNombres.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoNombres.setText("*");
        jPanel7.add(jlblAsteriscoNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 10, 25));

        jlblAsteriscoApellidosPaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidosPaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidosPaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidosPaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidosPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 10, 25));

        jlblAsteriscoApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidoMaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidoMaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidoMaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 10, 25));

        jlblMensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        jlblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jlblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 500, 20));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfApellidoPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoPaternoKeyReleased

        if(!jtfApellidoPaterno.getText().isEmpty()){
            jlblAsteriscoApellidosPaterno.setText("");
        }
        else{
            jlblAsteriscoApellidosPaterno.setText("*");            
        }        
    }//GEN-LAST:event_jtfApellidoPaternoKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        GuardarUsuario();        
    }//GEN-LAST:event_jButton3ActionPerformed

    public void GuardarUsuario(){
        if(jlblAsteriscoApellidoMaterno.getText().isEmpty() && jlblAsteriscoApellidosPaterno.getText().isEmpty()
                && jlblAsteriscoDNI.getText().isEmpty() && jlblAsteriscoNombres.getText().isEmpty()){
            Persona objPersona=new Persona();
            objPersona.setNombres(jtfNombres.getText());
            objPersona.setApellido_Paterno(jtfApellidoPaterno.getText());
            objPersona.setApellido_Materno(jtfApellidoMaterno.getText());
            objPersona.setDni(jtfDni.getText());
            Usuario objUsuario=new Usuario();
            objUsuario.setRol((Rol)jcbRol.getSelectedItem());
            objUsuario.setContraseña(jtfDni.getText());
            try{
                jpa.getTransaction().begin();
                jpa.persist(objPersona);
                jpa.refresh(objPersona);
                objUsuario.setPersona(objPersona);
                objUsuario.setNickname("Farmacia"+objPersona.getId_Persona());
                jpa.persist(objUsuario);
                jpa.refresh(objUsuario);
                //poner un thread de mensaje
                new Proceso(objUsuario,true).start();
                //jlblMensaje.setText("El nickname es: "+objUsuario.getNickname()+" y su contraseña es su DNI");
                limpiar();                
                jpa.getTransaction().commit();}
            catch (PersistenceException e) {
                jlblMensaje.setText("el DNI ya está en uso");
                new Proceso(false).start();
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
        jtfDni.setText("");
        jtfNombres.setText("");
        jlblAsteriscoApellidoMaterno.setText("*");
        jlblAsteriscoApellidosPaterno.setText("*");
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

    private void jtfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyReleased
        if(jtfDni.getText().length()>=8){
            jlblAsteriscoDNI.setText("");
        }
        else{
            jlblAsteriscoDNI.setText("*");            
        }
    }//GEN-LAST:event_jtfDniKeyReleased

    private void jtfApellidoMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoMaternoKeyReleased
        if(!jtfApellidoMaterno.getText().isEmpty()){
            jlblAsteriscoApellidoMaterno.setText("");
        }
        else{
            jlblAsteriscoApellidoMaterno.setText("*");            
        }
    }//GEN-LAST:event_jtfApellidoMaternoKeyReleased

    private void jtfNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresKeyTyped
        if (jtfNombres.getText().length()>=20){
            evt.consume(); 
            }
        char validar=evt.getKeyChar();
        if(!Character.isLetter(validar)){
            evt.consume();
            }
        if(!Character.isLowerCase(validar)){
            evt.setKeyChar(Character.toLowerCase(validar));
        }
        
    }//GEN-LAST:event_jtfNombresKeyTyped

    private void jtfDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyTyped
        if (jtfDni.getText().length()>=8){             
         evt.consume(); 
         }     
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
        if(' '==validar){
            evt.consume();
            }        
    }//GEN-LAST:event_jtfDniKeyTyped

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

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             GuardarUsuario();
             }
    }//GEN-LAST:event_jButton3KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyCard;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel head;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JComboBox<Rol> jcbRol;
    private javax.swing.JLabel jlblAsteriscoApellidoMaterno;
    private javax.swing.JLabel jlblAsteriscoApellidosPaterno;
    private javax.swing.JLabel jlblAsteriscoDNI;
    private javax.swing.JLabel jlblAsteriscoNombres;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JTextField jtfApellidoMaterno;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfNombres;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
