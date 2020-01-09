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
        jButton1.setEnabled(false);
        jlblMensaje.setText("Conectado a la Base de Datos....");
        new Proceso().start();
        this.loginframe=loginFrame;
        TextPrompt txr=new TextPrompt("Nombre de usuario",jtfUsuario);
         txr=new TextPrompt("Contraseña",jtfContraseña);
         }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlblSalida = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        cuerpito = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfContraseña = new javax.swing.JPasswordField();
        jlblMensaje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        barraProgreso = new javax.swing.JProgressBar();
        pie = new javax.swing.JPanel();
        jlblOlvideContra = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 251, 255));
        setMaximumSize(new java.awt.Dimension(100, 176));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(57, 23, 71));
        head.setPreferredSize(new java.awt.Dimension(191, 65));
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Iniciar Sesión");
        head.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 200, 30));

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

        add(head, java.awt.BorderLayout.PAGE_START);

        Body.setLayout(new java.awt.CardLayout());

        cuerpito.setBackground(new java.awt.Color(73, 25, 119));
        cuerpito.setPreferredSize(new java.awt.Dimension(350, 300));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconUsuario.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(130, 125));
        cuerpito.add(jLabel1);

        jLabel5.setPreferredSize(new java.awt.Dimension(300, 15));
        cuerpito.add(jLabel5);

        jtfUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfUsuario.setPreferredSize(new java.awt.Dimension(300, 30));
        cuerpito.add(jtfUsuario);

        jLabel3.setPreferredSize(new java.awt.Dimension(300, 15));
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
        jlblMensaje.setText("cargando");
        jlblMensaje.setPreferredSize(new java.awt.Dimension(300, 15));
        cuerpito.add(jlblMensaje);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        cuerpito.add(jButton1);

        jLabel6.setPreferredSize(new java.awt.Dimension(300, 15));
        cuerpito.add(jLabel6);

        barraProgreso.setPreferredSize(new java.awt.Dimension(300, 20));
        cuerpito.add(barraProgreso);

        Body.add(cuerpito, "card2");

        add(Body, java.awt.BorderLayout.LINE_END);

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

        add(pie, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    
    private void conectarBD(){
        try {
            
            this.jpa=JPAUtil.getEntityManagerFactory().createEntityManager();
            jlblMensaje.setText("Conexión exitosa");
            jButton1.setEnabled(true);
            }
        catch(Exception e) {
            jlblMensaje.setText("Falló la conexión");
            auxOpera=false; 
            }        
    }
    private void iniciarSesion(){
        barraProgreso.setValue(20);        
        if(auxOpera){
            try{
                barraProgreso.setValue(40);
                Query query=jpa.createQuery("SELECT e FROM Usuario e where nickname="+"'"+jtfUsuario.getText()+"'"+" and "+
                "contraseña="+"'"+ jtfContraseña.getText()+"'");
                barraProgreso.setValue(60);
                List<Usuario> listaUsuario=query.getResultList();
                if(!listaUsuario.isEmpty()){
                    usuario = listaUsuario.get(0);
                    barraProgreso.setValue(80);
                    Principal objPrincipal=new Principal(jpa,usuario);
                    barraProgreso.setValue(100);
                    loginframe.setVisible(false);
                    objPrincipal.setVisible(true);
                    }
                else{
                    jlblMensaje.setText("Datos Incorrectos");
                    barraProgreso.setValue(0);
                    }
                }
            catch(HeadlessException e){
                JOptionPane.showMessageDialog(barraProgreso, "error logueo"+e.toString());
                barraProgreso.setValue(WIDTH);
                }
            }
        else{
            JOptionPane.showMessageDialog(barraProgreso, "la base de datos no está disponible");
            }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       iniciarSesion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jlblOlvideContraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOlvideContraMouseMoved
      jlblOlvideContra.setForeground(Color.red);
    }//GEN-LAST:event_jlblOlvideContraMouseMoved

    private void jlblOlvideContraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblOlvideContraMouseExited
        jlblOlvideContra.setForeground((new java.awt.Color(0,51,255)));
    }//GEN-LAST:event_jlblOlvideContraMouseExited

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar-1.png")));
    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-minimizar.png")));

    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-Salida-1.png")));

                
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jlblSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-salida.png")));

    }//GEN-LAST:event_jPanel3MouseExited

    private void jtfContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContraseñaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER && (("Conexión exitosa").equals(jlblMensaje.getText()) || ("Datos Incorrectos").equals(jlblMensaje.getText()) )){
            iniciarSesion();            
            
        }
    }//GEN-LAST:event_jtfContraseñaKeyPressed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JPanel cuerpito;
    private javax.swing.JPanel head;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblOlvideContra;
    private javax.swing.JLabel jlblSalida;
    private javax.swing.JPasswordField jtfContraseña;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JPanel pie;
    // End of variables declaration//GEN-END:variables
}
