package com.ecoedu.Vistas.Estudiante;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Escuela;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Persona;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.List;
import javax.persistence.EntityManager;
/*
1-agregar registrar un medicamento nuevo,cantidad,precio;
2-agregar cantidad a un medicamento ya existente;
3-Modificar precio Unitario de un Medicamento ya existente;
*/
public class Modificar_Estudiante extends javax.swing.JPanel {   
    EntityManager jpa;
    Principal objPrincipal;
    TextAutoCompleter TextAutoCompleterEscuela;
    TextAutoCompleter TextAutoCompleterCodigoEstudiante;
    List<Escuela> Lista_Escuela;
    List<Estudiante> Lista_Estudiantes;
    public Modificar_Estudiante(EntityManager objJPA,Principal OBJPrincipal) {
        initComponents();
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;
        this.TextAutoCompleterEscuela=new TextAutoCompleter(jtfEscuela, new AutoCompleterCallback(){
            @Override
            public void callback(Object o){
                }});
        this.TextAutoCompleterCodigoEstudiante=new TextAutoCompleter(jtfCodigo, new AutoCompleterCallback(){
            @Override
            public void callback(Object o){
                }});          
    }
    public void ConsultaBD(){
        Lista_Escuela=jpa.createQuery("SELECT p FROM Escuela p").getResultList();
        Lista_Estudiantes=jpa.createQuery("Select p FROM Estudiante p").getResultList(); 
    }   
    public void principalEjecucion(){
        TextAutoCompleterCodigoEstudiante.removeAllItems();
        TextAutoCompleterEscuela.removeAllItems();
        for (Escuela Escuela : Lista_Escuela) {
            TextAutoCompleterEscuela.addItem(Escuela.getNombre());
        }    
        for (Estudiante Estudiante : Lista_Estudiantes) {
            TextAutoCompleterCodigoEstudiante.addItem(Estudiante.getCodigo());
        }
    }
    public void encontrarEstudiante(String codigo){
        for (Estudiante Estudiante : Lista_Estudiantes){
            if(Estudiante.getCodigo().equals(codigo)){
                jtfNombres.setText(Estudiante.getPersona().getNombres());
                jtfApellidoPaterno.setText(Estudiante.getPersona().getApellido_Paterno());
                jtfApellidoMaterno1.setText(Estudiante.getPersona().getApellido_Materno());
                jtfCodigo.setText(Estudiante.getCodigo());
                jtfDNI.setText(Estudiante.getPersona().getDni());
                jtfEscuela.setText(Estudiante.getEscuela().getNombre());
                jcbSerie.setSelectedItem((String) Estudiante.getSerie());
                break;
            }
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
        jtfEscuela = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jcbSerie = new javax.swing.JComboBox<>();
        jtfApellidoMaterno1 = new javax.swing.JTextField();

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
        jLabel12.setText("MODIFICAR ESTUDIANTE");
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
        jPanel7.add(jtfApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 500, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apellido Paterno:");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nombres:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, -1));

        jLabel28.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel28.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 900, 10));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Guardar Cambios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("DNI:");
        jLabel20.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 130, 25));

        jtfNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 500, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Apellido Materno:");
        jLabel21.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 130, 25));

        jtfDNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 160, 25));

        jLabel29.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel29.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 900, 10));

        jLabel30.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel30.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 900, 10));

        jLabel31.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel31.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 900, 10));

        jtfEscuela.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfEscuela.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 500, 25));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Ingrese Código:");
        jLabel23.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 120, 25));

        jtfCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
        });
        jPanel7.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 160, 25));

        jLabel32.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel32.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 900, 10));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Serie:");
        jLabel24.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 50, 25));

        jLabel25.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Escuela:");
        jLabel25.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 80, 25));

        jcbSerie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "200", "300", "400", "500", "600", "700" }));
        jPanel7.add(jcbSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 160, 25));

        jtfApellidoMaterno1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfApellidoMaterno1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfApellidoMaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 500, 25));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("de nuevo");
        Escuela objEscuela;
        Persona objPersona=new Persona();
        Estudiante objEstudiante=new Estudiante();
        Control_paciente objControl_paciente=new Control_paciente();
        objControl_paciente.setMonto_Total(0);  
        objControl_paciente.setiSactivo(true);
        objPersona.setNombres(jtfNombres.getText());
        objPersona.setApellido_Paterno(jtfApellidoPaterno.getText());
        objPersona.setApellido_Materno(jtfEscuela.getText());
        objPersona.setDni(jtfDNI.getText());
        objEstudiante.setCodigo(jtfCodigo.getText());
        //objEstudiante.setSerie(jtfSerie.getText());
        for (Escuela Escuela : Lista_Escuela) {
            if(Escuela.getNombre().equals(jtfEscuela.getText())){
                objEstudiante.setEscuela(Escuela);
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
            System.out.println(e.toString()+"ERROR");             
            jpa.getTransaction().rollback();   
            ConsultaBD();//volviendo a cargar los datos manejados por el JPA;
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
    public void limpiar(){
        jtfEscuela.setText("");
        jtfApellidoPaterno.setText("");
        jtfNombres.setText("");
        jtfDNI.setText("");
        jtfCodigo.setText("");
        jcbSerie.setSelectedItem((String)"100");
        jtfEscuela.setText("");
    }
    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
         encontrarEstudiante(jtfCodigo.getText());
    }//GEN-LAST:event_jtfCodigoKeyReleased


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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JComboBox<String> jcbSerie;
    private javax.swing.JTextField jtfApellidoMaterno1;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfEscuela;
    private javax.swing.JTextField jtfNombres;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
