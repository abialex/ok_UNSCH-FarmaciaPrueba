package com.ecoedu.Vistas.Estudiante;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Escuela;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Persona;
import com.ecoedu.model.Sexo;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    List<Sexo> Lista_sexo;
    Estudiante objEstudianteM;
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
        Lista_sexo=jpa.createQuery("SELECT p FROM Sexo p").getResultList();
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
        jcbSexo.removeAllItems();
        for (Sexo sexo : Lista_sexo) {
            jcbSexo.addItem(sexo);
        }
    }
    public void encontrarEstudiante(String codigo){
        for (Estudiante Estudiante : Lista_Estudiantes){
            if(Estudiante.getCodigo().equals(codigo)){
                objEstudianteM=Estudiante;
                jtfNombres.setText(Estudiante.getPersona().getNombres());
                jtfApellidoPaterno.setText(Estudiante.getPersona().getApellido_Paterno());
                jtfApellidoMaterno.setText(Estudiante.getPersona().getApellido_Materno());
                jtfCodigo.setText(Estudiante.getCodigo());
                jtfDNI.setText(Estudiante.getPersona().getDni());
                jcbSerie.setSelectedItem(Estudiante.getSerie());
                jtfEscuela.setText(Estudiante.getEscuela().getNombre());
                jcbSexo.setSelectedItem((String) Estudiante.getSerie());
                jtfAño.setText(Estudiante.getFecha_nacimiento().getYear()+1900+"");
                jtfMesVen.setText(Estudiante.getFecha_nacimiento().getMonth()+1+"");
                jtfDiaVenc.setText(Estudiante.getFecha_nacimiento().getDate()+"");
                jcbSexo.setSelectedItem((Sexo) Estudiante.getSexo());
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
        jcbSexo = new javax.swing.JComboBox<>();
        jtfApellidoMaterno = new javax.swing.JTextField();
        jtfAño = new javax.swing.JTextField();
        jtfDiaVenc = new javax.swing.JTextField();
        jtfMesVen = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jcbSerie = new javax.swing.JComboBox<>();

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
        jPanel7.add(jtfApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 500, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apellido Paterno:");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 130, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nombres:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 70, -1));

        jLabel28.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel28.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 900, 10));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Guardar Cambios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Sexo:");
        jLabel20.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 50, 25));

        jtfNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 500, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Apellido Materno:");
        jLabel21.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 130, 25));

        jtfDNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDNIKeyTyped(evt);
            }
        });
        jPanel7.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 160, 25));

        jLabel29.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel29.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 900, 10));

        jLabel30.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel30.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 900, 10));

        jLabel31.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel31.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 900, 10));

        jtfEscuela.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfEscuela.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 500, 25));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 160, 25));

        jLabel32.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel32.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 900, 10));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Serie:");
        jLabel24.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 50, 25));

        jLabel25.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Escuela:");
        jLabel25.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 80, 25));

        jcbSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel7.add(jcbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 160, 25));

        jtfApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfApellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(jtfApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 500, 25));

        jtfAño.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAñoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 60, 25));

        jtfDiaVenc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfDiaVenc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDiaVenc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaVencKeyTyped(evt);
            }
        });
        jPanel7.add(jtfDiaVenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 40, 25));

        jtfMesVen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMesVen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMesVen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMesVenKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesVenKeyTyped(evt);
            }
        });
        jPanel7.add(jtfMesVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 40, 25));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("/");
        jLabel22.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 10, 25));

        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("/");
        jLabel33.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 10, 25));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("DNI:");
        jLabel26.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 130, 25));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Fecha Nacimiento:");
        jLabel27.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 130, 25));

        jcbSerie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "200", "300", "400", "500", "600", "700" }));
        jPanel7.add(jcbSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 160, 25));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Persona objPersona=objEstudianteM.getPersona();        
        //Control_paciente objControl_paciente=new Control_paciente();
        //objControl_paciente.setMonto_Total(0);  
        //objControl_paciente.setiSactivo(true);
        objPersona.setNombres(jtfNombres.getText());
        objPersona.setApellido_Paterno(jtfApellidoPaterno.getText());
        objPersona.setApellido_Materno(jtfApellidoMaterno.getText());
        objPersona.setDni(jtfDNI.getText());
        objEstudianteM.setCodigo(jtfCodigo.getText());
        objEstudianteM.setSerie((String)jcbSerie.getSelectedItem());
        objEstudianteM.getFecha_nacimiento().setYear(Integer.parseInt(jtfAño.getText())-1900);
        objEstudianteM.getFecha_nacimiento().setMonth(Integer.parseInt(jtfMesVen.getText())-1);
        objEstudianteM.getFecha_nacimiento().setDate(Integer.parseInt(jtfDiaVenc.getText()));            
        
        //objEstudiante.setSerie(jtfSerie.getText());
        for (Escuela Escuela : Lista_Escuela) {
            if(Escuela.getNombre().equals(jtfEscuela.getText())){
                objEstudianteM.setEscuela(Escuela);
            }
        }                      
        try {
            jpa.getTransaction().begin();
            jpa.persist(objPersona);
            objEstudianteM.setPersona(objPersona);
            jpa.persist(objEstudianteM);
            jpa.createNativeQuery("update Estudiante set id_Escuela="+objEstudianteM.getEscuela().getId_Escuela()+" where id_Estudiante="+objEstudianteM.getId_Estudiante()).executeUpdate();
            jpa.flush();
            jpa.getTransaction().commit();
            limpiar();
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
        jtfApellidoMaterno.setText("");
        jtfNombres.setText("");
        jtfDNI.setText("");
        jtfCodigo.setText("");        
        jcbSexo.setSelectedItem((String)"100");
        jtfEscuela.setText("");
    }
    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
         encontrarEstudiante(jtfCodigo.getText());
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jtfDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyTyped
        if (jtfDNI.getText().length()>=8){
            evt.consume(); 
            }
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            }
    }//GEN-LAST:event_jtfDNIKeyTyped

    private void jtfCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyTyped
        if (jtfCodigo.getText().length()>=8){
            evt.consume(); 
            }
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            }
    }//GEN-LAST:event_jtfCodigoKeyTyped

    private void jtfAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAñoKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
        }

        if (jtfAño.getText().length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_jtfAñoKeyTyped

    private void jtfDiaVencKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaVencKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            getToolkit().beep();
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

    private void jtfMesVenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMesVenKeyPressed

    private void jtfMesVenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            getToolkit().beep();
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
    private javax.swing.JComboBox<Sexo> jcbSexo;
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
