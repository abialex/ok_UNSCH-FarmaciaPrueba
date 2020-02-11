package com.ecoedu.Vistas;


import com.ecoedu.Vistas.vista_base.CuadroLogin;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.app.JPAUtil;
import com.ecoedu.app.TextPrompt;
import com.ecoedu.model.Usuario;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class Login extends javax.swing.JPanel {
    EntityManager jpa;
    Usuario usuario;
    CuadroLogin loginframe;
    //private Timer tiempo;
    //int cont;
    //public final static int TWO_SECOND=3;
    boolean auxOpera=true;
     
    public class Proceso extends Thread{
        @Override
        public void run(){
            conectarBD();
        }        
    }
    
    public Login(CuadroLogin loginFrame){     
        initComponents(); 
        jbtnIngresar.setEnabled(false);
        jlblMensaje.setText("Conectado a la Base de Datos....");
        new Proceso().start();
        this.loginframe=loginFrame;
        TextPrompt txr=new TextPrompt("Nombre de usuario",jtfUsuario);
         txr=new TextPrompt("Contraseña",jtfContraseña);
         }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlblSalida = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        cuerpito = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfContraseña = new javax.swing.JPasswordField();
        jlblMensaje = new javax.swing.JLabel();
        jbtnIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pie = new javax.swing.JPanel();
        jlblOlvideContra = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CambiarContraseña = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jlblMinimizar2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jlblSalida2 = new javax.swing.JLabel();
        Body2 = new javax.swing.JPanel();
        cuerpito2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblDatos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlblRol = new javax.swing.JLabel();
        jlblMensaje1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfNuevaContraseña = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jtfConfirmarContraseña = new javax.swing.JPasswordField();
        jlblMensajeCambiarContra = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        pie2 = new javax.swing.JPanel();
        jlblOlvideContra2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 255));
        setMaximumSize(new java.awt.Dimension(100, 176));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.CardLayout());

        Login.setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(57, 23, 71));
        head.setPreferredSize(new java.awt.Dimension(191, 65));
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Iniciar Sesión");
        head.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 200, 30));

        jPanel2.setBackground(new java.awt.Color(57, 23, 71));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new java.awt.BorderLayout());

        jlblMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar.png"))); // NOI18N
        jPanel2.add(jlblMinimizar, java.awt.BorderLayout.LINE_START);

        head.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 7, -1, -1));

        jPanel3.setBackground(new java.awt.Color(57, 23, 71));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new java.awt.BorderLayout());

        jlblSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-salida.png"))); // NOI18N
        jPanel3.add(jlblSalida, java.awt.BorderLayout.LINE_START);

        head.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 7, -1, -1));

        Login.add(head, java.awt.BorderLayout.PAGE_START);

        Body.setLayout(new java.awt.CardLayout());

        cuerpito.setBackground(new java.awt.Color(73, 25, 119));
        cuerpito.setPreferredSize(new java.awt.Dimension(350, 300));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconUsuario.png"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(125, 125));
        cuerpito.add(jLabel8);

        jLabel5.setPreferredSize(new java.awt.Dimension(300, 10));
        cuerpito.add(jLabel5);

        jtfUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfUsuario.setPreferredSize(new java.awt.Dimension(300, 30));
        cuerpito.add(jtfUsuario);

        jLabel3.setPreferredSize(new java.awt.Dimension(300, 10));
        cuerpito.add(jLabel3);

        jtfContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfContraseña.setPreferredSize(new java.awt.Dimension(300, 30));
        jtfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfContraseñaKeyPressed(evt);
            }
        });
        cuerpito.add(jtfContraseña);

        jlblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jlblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensaje.setPreferredSize(new java.awt.Dimension(300, 10));
        cuerpito.add(jlblMensaje);

        jbtnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        jbtnIngresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnIngresar.setText("Ingresar");
        jbtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresarActionPerformed(evt);
            }
        });
        cuerpito.add(jbtnIngresar);

        jLabel6.setPreferredSize(new java.awt.Dimension(300, 35));
        cuerpito.add(jLabel6);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELABORADO POR :");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 10));
        cuerpito.add(jLabel1);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ALEXIS YALLE ");
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 10));
        cuerpito.add(jLabel4);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Q.F. ROCÌO TUEROS");
        jLabel11.setPreferredSize(new java.awt.Dimension(105, 10));
        cuerpito.add(jLabel11);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("                                                  Febrero del 2020");
        jLabel12.setPreferredSize(new java.awt.Dimension(300, 10));
        cuerpito.add(jLabel12);

        Body.add(cuerpito, "card2");

        Login.add(Body, java.awt.BorderLayout.LINE_END);

        jlblOlvideContra.setForeground(new java.awt.Color(0, 51, 255));
        jlblOlvideContra.setText("Olvidé mi contraseña");
        jlblOlvideContra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlblOlvideContraMouseMoved(evt);
            }
        });
        jlblOlvideContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlblOlvideContraMouseExited(evt);
            }
        });
        pie.add(jlblOlvideContra);

        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("| Soporte Técnico: 492939284");
        pie.add(jLabel9);

        Login.add(pie, java.awt.BorderLayout.PAGE_END);

        add(Login, "card2");

        CambiarContraseña.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(57, 23, 71));
        head2.setPreferredSize(new java.awt.Dimension(191, 65));
        head2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cambiar Contraseña");
        head2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 30));

        jPanel8.setBackground(new java.awt.Color(57, 23, 71));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel8MouseMoved(evt);
            }
        });
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new java.awt.BorderLayout());

        jlblMinimizar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar.png"))); // NOI18N
        jPanel8.add(jlblMinimizar2, java.awt.BorderLayout.LINE_START);

        head2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 7, -1, -1));

        jPanel9.setBackground(new java.awt.Color(57, 23, 71));
        jPanel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel9MouseMoved(evt);
            }
        });
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new java.awt.BorderLayout());

        jlblSalida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSalida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-salida.png"))); // NOI18N
        jPanel9.add(jlblSalida2, java.awt.BorderLayout.LINE_START);

        head2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 7, -1, -1));

        CambiarContraseña.add(head2, java.awt.BorderLayout.PAGE_START);

        Body2.setLayout(new java.awt.CardLayout());

        cuerpito2.setBackground(new java.awt.Color(73, 25, 119));
        cuerpito2.setPreferredSize(new java.awt.Dimension(350, 300));

        jLabel14.setPreferredSize(new java.awt.Dimension(300, 15));
        cuerpito2.add(jLabel14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Datos:");
        jLabel7.setPreferredSize(new java.awt.Dimension(59, 25));
        cuerpito2.add(jLabel7);

        jlblDatos.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblDatos.setForeground(new java.awt.Color(204, 204, 255));
        jlblDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblDatos.setPreferredSize(new java.awt.Dimension(250, 25));
        cuerpito2.add(jlblDatos);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Rol:");
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 25));
        cuerpito2.add(jLabel10);

        jlblRol.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblRol.setForeground(new java.awt.Color(204, 204, 255));
        jlblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblRol.setPreferredSize(new java.awt.Dimension(250, 25));
        cuerpito2.add(jlblRol);

        jlblMensaje1.setForeground(new java.awt.Color(255, 255, 255));
        jlblMensaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensaje1.setPreferredSize(new java.awt.Dimension(300, 25));
        cuerpito2.add(jlblMensaje1);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nueva Contraseña:");
        jLabel15.setPreferredSize(new java.awt.Dimension(300, 25));
        cuerpito2.add(jLabel15);

        jtfNuevaContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNuevaContraseña.setPreferredSize(new java.awt.Dimension(300, 30));
        jtfNuevaContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNuevaContraseñaKeyPressed(evt);
            }
        });
        cuerpito2.add(jtfNuevaContraseña);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Confirmar Contraseña:");
        jLabel16.setPreferredSize(new java.awt.Dimension(300, 25));
        cuerpito2.add(jLabel16);

        jtfConfirmarContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfConfirmarContraseña.setPreferredSize(new java.awt.Dimension(300, 30));
        jtfConfirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfConfirmarContraseñaKeyPressed(evt);
            }
        });
        cuerpito2.add(jtfConfirmarContraseña);

        jlblMensajeCambiarContra.setForeground(new java.awt.Color(255, 0, 0));
        jlblMensajeCambiarContra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensajeCambiarContra.setPreferredSize(new java.awt.Dimension(300, 15));
        cuerpito2.add(jlblMensajeCambiarContra);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        cuerpito2.add(jButton3);

        Body2.add(cuerpito2, "card2");

        CambiarContraseña.add(Body2, java.awt.BorderLayout.LINE_END);

        jlblOlvideContra2.setForeground(new java.awt.Color(0, 51, 255));
        jlblOlvideContra2.setText("Olvidé mi contraseña");
        jlblOlvideContra2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlblOlvideContra2MouseMoved(evt);
            }
        });
        jlblOlvideContra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlblOlvideContra2MouseExited(evt);
            }
        });
        pie2.add(jlblOlvideContra2);

        jLabel17.setForeground(new java.awt.Color(51, 51, 255));
        jLabel17.setText("| Soporte Técnico: 492939284");
        pie2.add(jLabel17);

        CambiarContraseña.add(pie2, java.awt.BorderLayout.PAGE_END);

        add(CambiarContraseña, "card3");
    }// </editor-fold>//GEN-END:initComponents

    
    private void conectarBD(){
        try {
            
            this.jpa=JPAUtil.getEntityManagerFactory().createEntityManager();
            jlblMensaje.setText("Conexión exitosa");
            jbtnIngresar.setEnabled(true);
            }
        catch(Exception e) {
            jlblMensaje.setText("Falló la conexión");
            auxOpera=false; 
            }        
    }
    public void abrirPantallaPrincipal(){
        Principal objPrincipal=new Principal(jpa,usuario);   
        loginframe.setVisible(false);
        objPrincipal.setVisible(true);
    }
    private void iniciarSesion(){
        jbtnIngresar.setEnabled(false);
        if(auxOpera){
            try{
                Query query=jpa.createQuery("SELECT e FROM Usuario e where nickname="+"'"+jtfUsuario.getText()+"'"+" and "+
                "contraseña="+"'"+ DigestUtils.md5Hex(jtfContraseña.getText())+"'");
                List<Usuario> listaUsuario=query.getResultList();
                if(!listaUsuario.isEmpty()){
                    usuario = listaUsuario.get(0);
                    if(usuario.isCambio()){
                        abrirPantallaPrincipal();
                        }
                    else{
                        Login.setVisible(false);
                        CambiarContraseña.setVisible(true);
                        jlblDatos.setText(usuario.getPersona().getInfoPersona());
                        jlblRol.setText(usuario.getRol().getNombre_rol());
                    }
                    }
                else{
                    jlblMensaje.setText("los datos no coinciden");
                    jbtnIngresar.setEnabled(true);
                    }
                }
            catch(HeadlessException e){
                jbtnIngresar.setEnabled(true);
                }
            }
        else{
            JOptionPane.showMessageDialog(jlblDatos, "la base de datos no está disponible");
            }
    }
    private void jlblOlvideContraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOlvideContraMouseExited
        jlblOlvideContra.setForeground((new java.awt.Color(0,51,255)));
    }//GEN-LAST:event_jlblOlvideContraMouseExited

    private void jlblOlvideContraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOlvideContraMouseMoved
        jlblOlvideContra.setForeground(Color.red);
    }//GEN-LAST:event_jlblOlvideContraMouseMoved

    private void jbtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresarActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_jbtnIngresarActionPerformed

    private void jtfContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContraseñaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER && (("Conexión exitosa").equals(jlblMensaje.getText()) || ("los datos no coinciden").equals(jlblMensaje.getText()) )){
            iniciarSesion();

        }
    }//GEN-LAST:event_jtfContraseñaKeyPressed

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-salida.png")));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-Salida-1.png")));

    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar.png")));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar-1.png")));
    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseMoved
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar-1.png")));
    }//GEN-LAST:event_jPanel8MouseMoved

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar.png")));
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseMoved
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-Salida-1.png")));

    }//GEN-LAST:event_jPanel9MouseMoved

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-salida.png")));
    }//GEN-LAST:event_jPanel9MouseExited

    private void jtfConfirmarContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConfirmarContraseñaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER && (("Conexión exitosa").equals(jlblMensaje.getText()) || ("Datos Incorrectos").equals(jlblMensaje.getText()) )){
            iniciarSesion();

        }
    }//GEN-LAST:event_jtfConfirmarContraseñaKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!jtfNuevaContraseña.getText().isEmpty() && !jtfConfirmarContraseña.getText().isEmpty() ){
            if(jtfConfirmarContraseña.getText().equals(jtfNuevaContraseña.getText())){
                jpa.getTransaction().begin();
                usuario.setCambio(true);
                usuario.setContraseña(DigestUtils.md5Hex(jtfConfirmarContraseña.getText()));
                jpa.persist(usuario);                
                JOptionPane.showMessageDialog(jlblMensaje1, "se cambió con exito");
                abrirPantallaPrincipal();
                jpa.getTransaction().commit();
                
            }
            else{
                jlblMensajeCambiarContra.setText("las contraseñas deben coincidir");
            }
        }
        else{
            jlblMensajeCambiarContra.setText("llene  los campos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jlblOlvideContra2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOlvideContra2MouseMoved
        jlblOlvideContra.setForeground(Color.red);
    }//GEN-LAST:event_jlblOlvideContra2MouseMoved

    private void jlblOlvideContra2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOlvideContra2MouseExited
        jlblOlvideContra.setForeground((new java.awt.Color(0,51,255)));
    }//GEN-LAST:event_jlblOlvideContra2MouseExited

    private void jtfNuevaContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNuevaContraseñaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNuevaContraseñaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Body2;
    private javax.swing.JPanel CambiarContraseña;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel cuerpito;
    private javax.swing.JPanel cuerpito2;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbtnIngresar;
    private javax.swing.JLabel jlblDatos;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JLabel jlblMensaje1;
    private javax.swing.JLabel jlblMensajeCambiarContra;
    private javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblMinimizar2;
    private javax.swing.JLabel jlblOlvideContra;
    private javax.swing.JLabel jlblOlvideContra2;
    private javax.swing.JLabel jlblRol;
    private javax.swing.JLabel jlblSalida;
    private javax.swing.JLabel jlblSalida2;
    private javax.swing.JPasswordField jtfConfirmarContraseña;
    private javax.swing.JPasswordField jtfContraseña;
    private javax.swing.JPasswordField jtfNuevaContraseña;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JPanel pie;
    private javax.swing.JPanel pie2;
    // End of variables declaration//GEN-END:variables
}
