package com.ecoedu.Vistas.Estudiante;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Persona;
import com.ecoedu.model.Rol;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
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
    List<Rol> Lista_Escuela;
    List<Estudiante> Lista_Estudiantes;
    List<Rol> Lista_sexo;
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
        Lista_Escuela=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=1").getResultList();        
        Lista_sexo=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=4").getResultList();
        Lista_Estudiantes=jpa.createQuery("Select p FROM Estudiante p").getResultList(); 
    }   
    public void principalEjecucion(){
        TextAutoCompleterCodigoEstudiante.removeAllItems();
        TextAutoCompleterEscuela.removeAllItems();
        for (Rol RolEscuela : Lista_Escuela) {
            TextAutoCompleterEscuela.addItem(RolEscuela);
        }    
        for (Estudiante Estudiante : Lista_Estudiantes) {
            TextAutoCompleterCodigoEstudiante.addItem(Estudiante.getCodigo());
        }
        jcbSexo.removeAllItems();
        for (Rol Rolsexo : Lista_sexo) {
            jcbSexo.addItem(Rolsexo);
        }
    }
    public void encontrarEstudiante(String codigo){
        for (Estudiante Estudiante : Lista_Estudiantes){
            if(Estudiante.getCodigo().equals(codigo)){
                objEstudianteM=Estudiante;
                jtfNombres.setText(Estudiante.getPersona().getNombres());
                jtfApellidoPaterno.setText(Estudiante.getPersona().getApellido_Paterno());
                jtfApellidoMaterno.setText(Estudiante.getPersona().getApellido_Materno());
                jtfCodigoModificar.setText(Estudiante.getCodigo());
                jtfDNI.setText(Estudiante.getPersona().getDni());
                jcbSerie.setSelectedItem(Estudiante.getSerie());
                jtfEscuela.setFocusable(false);
                jtfEscuela.setText(Estudiante.getEscuela().getNombre_rol());
                jtfEscuela.setFocusable(true);
                jcbSexo.setSelectedItem((String) Estudiante.getSerie());
                jtfCodigoModificar.setText(Estudiante.getCodigo());
                jtfAño.setText(Estudiante.getFecha_nacimiento().getYear()+1900+"");
                jtfMesVen.setText(Estudiante.getFecha_nacimiento().getMonth()+1+"");
                jtfDiaVenc.setText(Estudiante.getFecha_nacimiento().getDate()+"");
                jcbSexo.setSelectedItem((Rol) Estudiante.getRolSexo());
                jlblAsteriscoApellidoMaterno.setText("");
                jlblAsteriscoApellidoPaterno.setText("");
                jlblAsteriscoDNI.setText("");
                jlblAsteriscoEscuela.setText("");
                jlblAsteriscoNombres.setText("");
                jlblAsteriscoFechaNacimiento.setText("");
                jlblAsteriscoCodigo.setText("");
                break;
            }
            limpiarsincodigoXD();
            
            
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
        jtfCodigoModificar = new javax.swing.JTextField();
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
        jlblAsteriscoEscuela = new javax.swing.JLabel();
        jlblAsteriscoCodigo = new javax.swing.JLabel();
        jlblAsteriscoApellidoPaterno = new javax.swing.JLabel();
        jlblAsteriscoDNI = new javax.swing.JLabel();
        jlblAsteriscoFechaNacimiento = new javax.swing.JLabel();
        jlblAsteriscoApellidoMaterno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jlblAsteriscoNombres = new javax.swing.JLabel();

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
        jtfApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoPaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoPaternoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 500, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apellido Paterno:");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 130, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Código:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 60, -1));

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
        jtfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombresKeyTyped(evt);
            }
        });
        jPanel7.add(jtfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 220, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Apellido Materno:");
        jLabel21.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 130, 25));

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
        jtfEscuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEscuelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEscuelaKeyTyped(evt);
            }
        });
        jPanel7.add(jtfEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 500, 25));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Ingrese Código:");
        jLabel23.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 120, 25));

        jtfCodigoModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigoModificar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoModificar.setHighlighter(null);
        jtfCodigoModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoModificarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodigoModificarKeyTyped(evt);
            }
        });
        jPanel7.add(jtfCodigoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 150, 25));

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
        jtfApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidoMaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoMaternoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 500, 25));

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
        jPanel7.add(jtfAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 60, 25));

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
        jPanel7.add(jtfDiaVenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 40, 25));

        jtfMesVen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMesVen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMesVen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMesVenKeyReleased(evt);
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

        jlblAsteriscoEscuela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoEscuela.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoEscuela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoEscuela.setText("*");
        jPanel7.add(jlblAsteriscoEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 10, 25));

        jlblAsteriscoCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoCodigo.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoCodigo.setText("*");
        jPanel7.add(jlblAsteriscoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 10, 25));

        jlblAsteriscoApellidoPaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidoPaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidoPaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidoPaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 10, 25));

        jlblAsteriscoDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoDNI.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoDNI.setText("*");
        jPanel7.add(jlblAsteriscoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 10, 25));

        jlblAsteriscoFechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoFechaNacimiento.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoFechaNacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoFechaNacimiento.setText("*");
        jPanel7.add(jlblAsteriscoFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 10, 25));

        jlblAsteriscoApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoApellidoMaterno.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoApellidoMaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoApellidoMaterno.setText("*");
        jPanel7.add(jlblAsteriscoApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 10, 25));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Nombres:");
        jLabel7.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 70, -1));

        jtfCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigo.setHighlighter(null);
        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 160, 25));

        jlblAsteriscoNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteriscoNombres.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoNombres.setText("*");
        jPanel7.add(jlblAsteriscoNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 10, 25));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
guardarModificacionEstudiante();
    
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
    public void guardarModificacionEstudiante(){
        if( jlblAsteriscoCodigo.getText().isEmpty()&&jlblAsteriscoDNI.getText().isEmpty() && jlblAsteriscoApellidoMaterno.getText().isEmpty() &&
                jlblAsteriscoApellidoPaterno.getText().isEmpty() &&  jlblAsteriscoEscuela.getText().isEmpty() && jlblAsteriscoFechaNacimiento.getText().isEmpty()
                && jlblAsteriscoNombres.getText().isEmpty()){
                Persona objPersona=objEstudianteM.getPersona();        
        //Control_paciente objControl_paciente=new Control_paciente();
        //objControl_paciente.setMonto_Total(0);  
        //objControl_paciente.setiSactivo(true);
        objPersona.setNombres(jtfNombres.getText());
        objPersona.setApellido_Paterno(jtfApellidoPaterno.getText());
        objPersona.setApellido_Materno(jtfApellidoMaterno.getText());
        objPersona.setDni(jtfDNI.getText());
        objEstudianteM.setCodigo(jtfCodigoModificar.getText());
        objEstudianteM.setSerie((String)jcbSerie.getSelectedItem());
        objEstudianteM.getFecha_nacimiento().setYear(Integer.parseInt(jtfAño.getText())-1900);
        objEstudianteM.getFecha_nacimiento().setMonth(Integer.parseInt(jtfMesVen.getText())-1);
        objEstudianteM.getFecha_nacimiento().setDate(Integer.parseInt(jtfDiaVenc.getText()));  
        objEstudianteM.setRolSexo((Rol)jcbSexo.getSelectedItem());
        objEstudianteM.setCodigo(jtfCodigoModificar.getText());
        
        //objEstudiante.setSerie(jtfSerie.getText());
        for (Rol RolEscuela : Lista_Escuela) {
            if(RolEscuela.getNombre_rol().equals(jtfEscuela.getText())){
                objEstudianteM.setEscuela(RolEscuela);
            }
        }                      
        try {
            jpa.getTransaction().begin();
            jpa.persist(objPersona);
            objEstudianteM.setPersona(objPersona);
            jpa.persist(objEstudianteM);
            jpa.createNativeQuery("update Estudiante set id_Rolescuela="+objEstudianteM.getEscuela().getId_Rol()+" ,id_RolSexo="+objEstudianteM.getRolSexo().getId_Rol()+" where id_Estudiante="+objEstudianteM.getId_Estudiante()).executeUpdate();
            jpa.flush();
            jpa.getTransaction().commit();
            ConsultaBD();
            principalEjecucion();
            limpiar();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(jtfMesVen, "error"+e.toString());
            jpa.getTransaction().rollback();   
            ConsultaBD();//volviendo a cargar los datos manejados por el JPA;
            principalEjecucion();
            encontrarEstudiante(jtfCodigo.getText());
        }
            
        }
        else{
            JOptionPane.showMessageDialog(jtfMesVen, "llene los espacios con *");
        }
    }
    public void limpiar(){
        jtfDiaVenc.setText("");
        jtfMesVen.setText("");
        jtfAño.setText("");
        jtfEscuela.setText("");
        jtfApellidoPaterno.setText("");
        jtfApellidoMaterno.setText("");
        jtfNombres.setText("");
        jtfDNI.setText("");
        jtfCodigo.setText("");  
        jtfCodigoModificar.setText("");
        jcbSerie.setSelectedItem((String)"100");
        jtfEscuela.setText("");
        jlblAsteriscoApellidoMaterno.setText("*");
        jlblAsteriscoApellidoPaterno.setText("*");
        jlblAsteriscoNombres.setText("*");
        jlblAsteriscoDNI.setText("*");
        jlblAsteriscoEscuela.setText("*");
        jlblAsteriscoFechaNacimiento.setText("*");
        jlblAsteriscoCodigo.setText("*");
    }
    public void limpiarsincodigoXD(){
        jlblAsteriscoNombres.setText("*");
        jtfDiaVenc.setText("");
        jtfMesVen.setText("");
        jtfAño.setText("");
        jtfApellidoPaterno.setText("");
        jtfApellidoMaterno.setText("");
        jtfNombres.setText("");
        jtfDNI.setText("");        
        jcbSexo.setSelectedItem((String)"100");
        jtfEscuela.setFocusable(false);
        jtfEscuela.setText("");
        jtfEscuela.setFocusable(true);
        jlblAsteriscoApellidoMaterno.setText("*");
        jlblAsteriscoApellidoPaterno.setText("*");
        jlblAsteriscoDNI.setText("*");
        jlblAsteriscoEscuela.setText("*");
        jlblAsteriscoFechaNacimiento.setText("*");
        jlblAsteriscoCodigo.setText("*");
    }
    private void jtfCodigoModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoModificarKeyReleased
         
        if(jtfCodigoModificar.getText().length()>=8){
            jlblAsteriscoCodigo.setText("");
        }
        else{
            jlblAsteriscoCodigo.setText("*");            
        }
            
    }//GEN-LAST:event_jtfCodigoModificarKeyReleased

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

    private void jtfCodigoModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoModificarKeyTyped
        if (jtfCodigoModificar.getText().length()>=8){
            evt.consume(); 
            }
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
            }
        if(' '==validar){
            evt.consume();
            } 
    }//GEN-LAST:event_jtfCodigoModificarKeyTyped

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

    private void jtfEscuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEscuelaKeyReleased
        for (Rol RolEscuela : Lista_Escuela){
            if(RolEscuela.getNombre_rol().equals(jtfEscuela.getText())){
                jlblAsteriscoEscuela.setText("");
                break;
            }
            jlblAsteriscoEscuela.setText("*");            
        }
    }//GEN-LAST:event_jtfEscuelaKeyReleased

    private void jtfEscuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEscuelaKeyTyped
        char validar=evt.getKeyChar();
        if (jtfEscuela.getText().length()>=35){             
         evt.consume(); 
         }     
        
        if(!Character.isLetter(validar)){
            evt.consume();
        }
        
    }//GEN-LAST:event_jtfEscuelaKeyTyped

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

    private void jtfAñoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAñoKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfAño.getText().isEmpty()){
            jlblAsteriscoFechaNacimiento.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfAño.getText().equals("0")){
                jlblAsteriscoFechaNacimiento.setText("*");
            }
            else{
                jlblAsteriscoFechaNacimiento.setText("");
            }
        }
    }//GEN-LAST:event_jtfAñoKeyReleased

    private void jtfMesVenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfAño.getText().isEmpty()){
            jlblAsteriscoFechaNacimiento.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfAño.getText().equals("0")){
                jlblAsteriscoFechaNacimiento.setText("*");
            }
            else{
                jlblAsteriscoFechaNacimiento.setText("");                
            }
        }
    }//GEN-LAST:event_jtfMesVenKeyReleased

    private void jtfDiaVencKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaVencKeyReleased
       if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfAño.getText().isEmpty()){
            jlblAsteriscoFechaNacimiento.setText("*");
        }
        else{
           if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfAño.getText().equals("0")){
               jlblAsteriscoFechaNacimiento.setText("*");
           }
           else{
               jlblAsteriscoFechaNacimiento.setText("");
           }
      
        }
    }//GEN-LAST:event_jtfDiaVencKeyReleased

    private void jtfNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresKeyReleased
        if(jtfNombres.getText().isEmpty()){
            jlblAsteriscoNombres.setText("*");
        }
        else{
            jlblAsteriscoNombres.setText("");
        }
    }//GEN-LAST:event_jtfNombresKeyReleased

    private void jtfApellidoPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoPaternoKeyReleased
        if(jtfApellidoPaterno.getText().isEmpty()){
            jlblAsteriscoApellidoPaterno.setText("*");
        }
        else{
            jlblAsteriscoApellidoPaterno.setText("");            
        }
    }//GEN-LAST:event_jtfApellidoPaternoKeyReleased

    private void jtfApellidoMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoMaternoKeyReleased
        if(jtfApellidoMaterno.getText().isEmpty()){
            jlblAsteriscoApellidoMaterno.setText("*");
        }
        else{
            jlblAsteriscoApellidoMaterno.setText("");            
        }
    }//GEN-LAST:event_jtfApellidoMaternoKeyReleased

    private void jtfDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIKeyReleased
        if(jtfDNI.getText().length()>=8){
            jlblAsteriscoDNI.setText("");
        }
        else{
            jlblAsteriscoDNI.setText("*");            
        }
    }//GEN-LAST:event_jtfDNIKeyReleased

    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
        encontrarEstudiante(jtfCodigo.getText());
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jtfCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyTyped
        if (jtfCodigo.getText().length()>=8){
            evt.consume(); 
            }
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
            }
        if(' '==validar){
            evt.consume();
            } 
    }//GEN-LAST:event_jtfCodigoKeyTyped


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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JComboBox<String> jcbSerie;
    private javax.swing.JComboBox<Rol> jcbSexo;
    private javax.swing.JLabel jlblAsteriscoApellidoMaterno;
    private javax.swing.JLabel jlblAsteriscoApellidoPaterno;
    private javax.swing.JLabel jlblAsteriscoCodigo;
    private javax.swing.JLabel jlblAsteriscoDNI;
    private javax.swing.JLabel jlblAsteriscoEscuela;
    private javax.swing.JLabel jlblAsteriscoFechaNacimiento;
    private javax.swing.JLabel jlblAsteriscoNombres;
    private javax.swing.JTextField jtfApellidoMaterno;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfAño;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCodigoModificar;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfDiaVenc;
    private javax.swing.JTextField jtfEscuela;
    private javax.swing.JTextField jtfMesVen;
    private javax.swing.JTextField jtfNombres;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
