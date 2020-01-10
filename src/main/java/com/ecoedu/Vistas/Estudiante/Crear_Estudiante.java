package com.ecoedu.Vistas.Estudiante;





import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Persona;
import com.ecoedu.model.Rol;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.Date;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;





/*
1-agregar registrar un medicamento nuevo,cantidad,precio;
2-agregar cantidad a un medicamento ya existente;
3-Modificar precio Unitario de un Medicamento ya existente;
*/
public class Crear_Estudiante extends javax.swing.JPanel {   
    EntityManager jpa;
    Principal objPrincipal;
    TextAutoCompleter TextAutoCompleterEscuela;
    List<Rol> Lista_Sexo;
    List<Rol> Lista_Escuela;
    public Crear_Estudiante(EntityManager objJPA,Principal OBJPrincipal) {
        initComponents();
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;
        this.TextAutoCompleterEscuela=new TextAutoCompleter(jtfEscuela, new AutoCompleterCallback(){
            @Override
            public void callback(Object o){
                }});           
    }
    public void ConsultaBD(){
        Query query1=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=1");
        Lista_Escuela=query1.getResultList();
        
        Query query2=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=4");
        Lista_Sexo=query2.getResultList();
        
      
    }   
    public void principalEjecucion(){
        TextAutoCompleterEscuela.removeAllItems();
        for (Rol RolEscuela : Lista_Escuela) {
            TextAutoCompleterEscuela.addItem(RolEscuela);
            
            
        } 
        jcbSexo.removeAllItems();
        for (Rol Rolsexo : Lista_Sexo) {
            jcbSexo.addItem(Rolsexo);
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
        jLabel20 = new javax.swing.JLabel();
        jtfNombres = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jtfApellidoMaterno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jtfEscuela = new javax.swing.JTextField();
        jcbSerie = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcbSexo = new javax.swing.JComboBox<>();
        jtfAño = new javax.swing.JTextField();
        jtfMesVen = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jtfDiaVenc = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jlblAsteriscoCodigo = new javax.swing.JLabel();
        jlblAsteriscoNombress = new javax.swing.JLabel();
        jlblAsteriscoApelloPaterno = new javax.swing.JLabel();
        jlblAsteriscoApellidoMaterno = new javax.swing.JLabel();
        jlblAsteriscoFecha = new javax.swing.JLabel();
        jlblAsteriscoDNI = new javax.swing.JLabel();
        jlblAsteriscoEscuela = new javax.swing.JLabel();

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
        jLabel12.setText("CREAR ESTUDIANTE");
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
        jPanel7.add(jtfApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 500, 25));

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
        jButton3.setText("Agregar Estudiante");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Sexo:");
        jLabel20.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 130, 25));

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
        jPanel7.add(jtfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 500, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Apellido Materno:");
        jLabel21.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 130, 25));

        jtfDNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDNIActionPerformed(evt);
            }
        });
        jtfDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDNIKeyTyped(evt);
            }
        });
        jPanel7.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 190, 25));

        jLabel29.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel29.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 10));

        jLabel30.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel30.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 900, 10));

        jLabel31.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel31.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 900, 10));

        jtfApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfApellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfApellidoMaternoActionPerformed(evt);
            }
        });
        jtfApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoMaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoMaternoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 500, 25));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Fecha Nacimiento:");
        jLabel23.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 130, 25));

        jtfCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });
        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 160, 25));

        jLabel32.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel32.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 900, 10));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Serie:");
        jLabel24.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 90, 25));

        jLabel25.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Escuela:");
        jLabel25.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 80, 25));

        jtfEscuela.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfEscuela.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfEscuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEscuelaActionPerformed(evt);
            }
        });
        jtfEscuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEscuelaKeyReleased(evt);
            }
        });
        jPanel7.add(jtfEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 190, 25));

        jcbSerie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "200", "300", "400", "500", "600", "700" }));
        jPanel7.add(jcbSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 160, 25));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Còdigo:");
        jLabel26.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 80, 25));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("DNI:");
        jLabel22.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 80, 25));

        jcbSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel7.add(jcbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 160, 25));

        jtfAño.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfAñoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAñoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 60, 25));

        jtfMesVen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMesVen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMesVen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMesVenKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMesVenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesVenKeyTyped(evt);
            }
        });
        jPanel7.add(jtfMesVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 40, 25));

        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("/");
        jLabel33.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 10, 25));

        jtfDiaVenc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDiaVenc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDiaVenc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDiaVencKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaVencKeyTyped(evt);
            }
        });
        jPanel7.add(jtfDiaVenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 40, 25));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("/");
        jLabel27.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 10, 25));

        jlblAsteriscoCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoCodigo.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoCodigo.setText("*");
        jPanel7.add(jlblAsteriscoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 10, 25));

        jlblAsteriscoNombress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoNombress.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoNombress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoNombress.setText("*");
        jPanel7.add(jlblAsteriscoNombress, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 10, 25));

        jlblAsteriscoApelloPaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApelloPaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApelloPaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApelloPaterno.setText("*");
        jPanel7.add(jlblAsteriscoApelloPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 10, 25));

        jlblAsteriscoApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidoMaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidoMaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidoMaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 10, 25));

        jlblAsteriscoFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoFecha.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoFecha.setText("*");
        jPanel7.add(jlblAsteriscoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 10, 25));

        jlblAsteriscoDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoDNI.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoDNI.setText("*");
        jPanel7.add(jlblAsteriscoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 10, 25));

        jlblAsteriscoEscuela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoEscuela.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoEscuela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoEscuela.setText("*");
        jPanel7.add(jlblAsteriscoEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 10, 25));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfApellidoPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoPaternoKeyReleased
       
        if(jtfApellidoPaterno.getText().isEmpty()){
            jlblAsteriscoApelloPaterno.setText("*");
        }
        else{
            jlblAsteriscoApelloPaterno.setText("");            
        }
        
    }//GEN-LAST:event_jtfApellidoPaternoKeyReleased
 
    public void guardarEstudiante(){
        if(jlblAsteriscoDNI.getText().isEmpty() && jlblAsteriscoApellidoMaterno.getText().isEmpty() &&
                jlblAsteriscoApelloPaterno.getText().isEmpty() && jlblAsteriscoCodigo.getText().isEmpty()
                && jlblAsteriscoEscuela.getText().isEmpty() && jlblAsteriscoFecha.getText().isEmpty()
                && jlblAsteriscoNombress.getText().isEmpty()){
            Rol objCondicion=(Rol)jpa.createQuery("select p from Rol p where id_Rol=1003").getResultList().get(0);//condicion en nuevo
        Persona objPersona=new Persona();
        Date FechaNacimiento=new Date();
        FechaNacimiento.setYear(Integer.parseInt(jtfAño.getText())-1900);
        FechaNacimiento.setMonth(Integer.parseInt(jtfMesVen.getText())-1);
        FechaNacimiento.setDate(Integer.parseInt(jtfDiaVenc.getText()));
        FechaNacimiento.setHours(0);
        FechaNacimiento.setMinutes(0);
        FechaNacimiento.setSeconds(0);
        Estudiante objEstudiante=new Estudiante();
        Control_paciente objControl_paciente=new Control_paciente();
        objControl_paciente.setMonto_Total(0); 
        objControl_paciente.setLimite_control(110);
        objControl_paciente.setiSactivo(true);
        objPersona.setNombres(jtfNombres.getText());
        objPersona.setApellido_Paterno(jtfApellidoPaterno.getText());
        objPersona.setApellido_Materno(jtfApellidoMaterno.getText());
        objPersona.setDni(jtfDNI.getText());
        objEstudiante.setFecha_nacimiento(FechaNacimiento);
        
        objEstudiante.setRolSexo((Rol)jcbSexo.getSelectedItem());
        objEstudiante.setCodigo(jtfCodigo.getText());
        objEstudiante.setSerie((String)jcbSerie.getSelectedItem());
        objEstudiante.setRolCondicion(objCondicion);
        objEstudiante.setEscuela((Rol)TextAutoCompleterEscuela.getItemSelected());
        for (Rol RolEscuela : Lista_Escuela){
            if(RolEscuela.getNombre_rol().equals(jtfEscuela.getText())){
                objEstudiante.setEscuela(RolEscuela);
            }
        }                      
        try {
            jpa.getTransaction().begin();
            jpa.persist(objPersona);
            jpa.refresh(objPersona);
            objEstudiante.setPersona(objPersona);
            jpa.persist(objEstudiante);
            jpa.refresh(objEstudiante);
            objControl_paciente.setEstudiante(objEstudiante);    
            jpa.persist(objControl_paciente);
            limpiar();
            jpa.getTransaction().commit();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(jcbSexo, e.toString());
            jpa.getTransaction().rollback();   
            ConsultaBD();//volviendo a cargar los datos manejados por el JPA;
            principalEjecucion();
            
        }
            
        }
        else{
            JOptionPane.showMessageDialog(jtfMesVen, "llene los espacios con *");
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
guardarEstudiante();
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
    public void limpiar(){
        jtfAño.setText("");
        jtfMesVen.setText("");
        jtfDiaVenc.setText("");
        jtfApellidoMaterno.setText("");
        jtfApellidoPaterno.setText("");
        jtfNombres.setText("");
        jtfDNI.setText("");
        jtfCodigo.setText("");
        jtfEscuela.setText("");
        jlblAsteriscoApellidoMaterno.setText("*");
        jlblAsteriscoApelloPaterno.setText("*");
        jlblAsteriscoCodigo.setText("*");
        jlblAsteriscoDNI.setText("*");
        jlblAsteriscoEscuela.setText("*");
        jlblAsteriscoFecha.setText("*");
        jlblAsteriscoNombress.setText("*");
    }
    private void jtfNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresKeyReleased
        if(jtfNombres.getText().isEmpty()){
            jlblAsteriscoNombress.setText("*");
        }
        else{
            jlblAsteriscoNombress.setText("");
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

    private void jtfDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDNIActionPerformed

    private void jtfApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfApellidoMaternoActionPerformed

    private void jtfApellidoMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoMaternoKeyReleased
        if(jtfApellidoMaterno.getText().isEmpty()){
            jlblAsteriscoApellidoMaterno.setText("*");
        }
        else{
            jlblAsteriscoApellidoMaterno.setText("");            
        }
    }//GEN-LAST:event_jtfApellidoMaternoKeyReleased

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
        if(jtfCodigo.getText().length()>=8){
            jlblAsteriscoCodigo.setText("");
        }
        else{
            jlblAsteriscoCodigo.setText("*");            
        }
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jtfEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEscuelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEscuelaActionPerformed

    private void jtfEscuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEscuelaKeyReleased
        for (Rol RolEscuela : Lista_Escuela){
            if(RolEscuela.getNombre_rol().equals(jtfEscuela.getText())){
                jlblAsteriscoEscuela.setText("");
                break;
            }
            jlblAsteriscoEscuela.setText("*");            
        }
    }//GEN-LAST:event_jtfEscuelaKeyReleased

    private void jtfCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyTyped
        if (jtfCodigo.getText().length()>=8){             
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
    }//GEN-LAST:event_jtfCodigoKeyTyped

    private void jtfDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyTyped
        if (jtfDNI.getText().length()>=8){
            evt.consume(); 
            }
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
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

    private void jtfAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAñoKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            evt.consume();
        }

        if (jtfAño.getText().length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_jtfAñoKeyTyped

    private void jtfMesVenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMesVenKeyPressed

    private void jtfMesVenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            evt.consume();
        }
        else{
            if(jtfMesVen.getText().length()==1){
                if(jtfMesVen.getText().charAt(0)!='0'){
                    if(!(validar=='1' || validar =='2' || validar=='0')){
                        evt.consume();
                    }
                }
                else{
                    if(validar=='0'){
                        evt.consume();
                    }
                }
            }
            else{
                if(!(validar =='0' || validar =='1')){
                    evt.consume();
                }
            }//fin else
        }

        if (jtfMesVen.getText().length()>=2){
            evt.consume();
        }
    }//GEN-LAST:event_jtfMesVenKeyTyped

    private void jtfDiaVencKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaVencKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            evt.consume();
        }
        else{
            String mes=jtfMesVen.getText();
            if(mes.equals("02")){
                if(Integer.parseInt(jtfAño.getText())%4!=0){
                    if(jtfDiaVenc.getText().length()==1){
                        if(jtfDiaVenc.getText().charAt(0)!='0'){
                            if(validar=='9'){
                                evt.consume();
                            }
                        }
                        else{
                            if(validar=='0'){
                                evt.consume();
                            }
                        }
                    }
                    else{
                        if(!(validar =='0'||validar =='2' || validar =='1')){
                            evt.consume();
                        }
                    }//fin else
                }
                else{
                    if(jtfDiaVenc.getText().length()==1){
                        if(jtfDiaVenc.getText().charAt(0)=='0'){
                            if(validar=='0'){
                                evt.consume();
                            }
                        }
                    }
                    else{
                        if(!(validar =='0'||validar =='2' || validar =='1')){
                            evt.consume();
                        }
                    }//fin else
                }

            }
            else{
                if(mes.equals("04")||mes.equals("06")||mes.equals("09")||mes.equals("11")){
                    if(jtfDiaVenc.getText().length()==1){
                        if(jtfDiaVenc.getText().charAt(0)!='0'){
                            if(jtfDiaVenc.getText().charAt(0)=='3'){
                                jtfDiaVenc.setText("30");
                            }
                        }
                        else{
                            if(validar=='0'){
                                evt.consume();
                            }
                        }
                    }
                    else{
                        if(!(validar =='0'||validar =='3'||validar =='2' || validar =='1')){
                            evt.consume();
                        }
                    }//fin else
                }
                else{
                    if(jtfDiaVenc.getText().length()==1){
                        if(jtfDiaVenc.getText().charAt(0)!='0'){
                            if(jtfDiaVenc.getText().charAt(0)=='3'){
                                if(!(validar=='1' || validar=='0')){
                                    evt.consume();
                                }
                            }
                        }
                        else{
                            if(validar=='0'){
                                evt.consume();
                            }
                        }
                    }
                    else{
                        if(!(validar =='0'||validar =='3'||validar =='2' || validar =='1')){
                            evt.consume();
                        }
                    }//fin else
                }
            }
        }
        if (jtfDiaVenc.getText().length()>=2){
            evt.consume();
        }
    }//GEN-LAST:event_jtfDiaVencKeyTyped

    private void jtfDiaVencKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaVencKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfAño.getText().isEmpty()){
            jlblAsteriscoFecha.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfAño.getText().equals("0")){
               jlblAsteriscoFecha.setText("*");
           }
           else{
               jlblAsteriscoFecha.setText("");
           }
        }
    }//GEN-LAST:event_jtfDiaVencKeyReleased

    private void jtfMesVenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfAño.getText().isEmpty()){
            jlblAsteriscoFecha.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfAño.getText().equals("0")){
                jlblAsteriscoFecha.setText("*");
            }
            else{
                jlblAsteriscoFecha.setText("");                
            }
        }
    }//GEN-LAST:event_jtfMesVenKeyReleased

    private void jtfAñoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAñoKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfAño.getText().isEmpty()){
            jlblAsteriscoFecha.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfAño.getText().equals("0")){
                jlblAsteriscoFecha.setText("*");
            }
            else{
                jlblAsteriscoFecha.setText("");
            }
        }
    }//GEN-LAST:event_jtfAñoKeyReleased


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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JComboBox<String> jcbSerie;
    private javax.swing.JComboBox<Rol> jcbSexo;
    private javax.swing.JLabel jlblAsteriscoApellidoMaterno;
    private javax.swing.JLabel jlblAsteriscoApelloPaterno;
    private javax.swing.JLabel jlblAsteriscoCodigo;
    private javax.swing.JLabel jlblAsteriscoDNI;
    private javax.swing.JLabel jlblAsteriscoEscuela;
    private javax.swing.JLabel jlblAsteriscoFecha;
    private javax.swing.JLabel jlblAsteriscoNombress;
    private javax.swing.JTextField jtfApellidoMaterno;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfAño;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfDiaVenc;
    private javax.swing.JTextField jtfEscuela;
    private javax.swing.JTextField jtfMesVen;
    private javax.swing.JTextField jtfNombres;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
