package com.ecoedu.Vistas.Inventario;


import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Descarga;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.RegistroMensualLotes;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Usuario;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class Descargo extends javax.swing.JPanel{  
   // List<Detalle_control_paciente> lista_Detalles_control_paciente;
    EntityManager jpa;
    Usuario objUsuario;
    List<Rol> Lista_RolDescargo;
    List<Usuario> Lista_Usuario;
    List<Lote_detalle> Lista_LotesVencidos;
    TextAutoCompleter TextAutoCompleterLotes;
    List<Lote_detalle> listaLotes;
    List<Lote_detalle> Lista_CarritosDeVencidos=new ArrayList<>();
    List<Detalle_Medicamentos> Lista_Medicamentos_Campaña=new ArrayList<>();
    Principal objPrincipal;
    Lote_detalle objLote;
    TextAutoCompleter autoCompleterDNI;
    float montoTotal=0;
    public Descargo(EntityManager objJPA, Usuario obj,Principal objPrinc) {
        initComponents();
        jtfDNIPERSONAL.setVisible(false);
        this.autoCompleterDNI=new TextAutoCompleter(jtfDNIPERSONAL,new AutoCompleterCallback() {
            @Override
            public void callback(Object o) {    }});
        llenarTabla(new ArrayList<Lote_detalle>());
        this.objPrincipal=objPrinc;
        this.jpa=objJPA;
        this.objUsuario=obj;
        this.TextAutoCompleterLotes=new TextAutoCompleter(jtfCodigoLotePerdida, new AutoCompleterCallback(){
            @Override
            public void callback(Object o){
                }}); 
        
       // llenarTabla(lista_Detalles_control_paciente);
        llenarTablaDetalleMedicmentos(new ArrayList<Detalle_Medicamentos>());
   
    }
    public Principal getPrincipal(){
         return objPrincipal;
     }    
    
    public void setMontoTotal(float a){
        montoTotal=montoTotal+a;
        jlblMontotañ.setText(montoTotal+"");
    }
    public void getLista_CarritoCampaña(Detalle_Medicamentos objDetalle){
         Lista_Medicamentos_Campaña.add(objDetalle);
         for (Lote_detalle lote_detalle : listaLotes){
             if(lote_detalle==objDetalle.getLote_detalle()){
                 lote_detalle.setCantidad(lote_detalle.getCantidad()-objDetalle.getCantidad());
                 lote_detalle.getInventario().setCantidad(lote_detalle.getInventario().getCantidad()-objDetalle.getCantidad());
                 break;
                 }                          
         }
         llenarTablaDetalleMedicmentos(Lista_Medicamentos_Campaña);
         
    }
     
    
    public void ConsultaBD(){
        Lista_RolDescargo=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=11").getResultList();
        listaLotes=jpa.createQuery("SELECT p FROM Lote_detalle p where isVencido=0").getResultList();
        jcbTipoDescargo.removeAllItems();
        for (Rol rol : Lista_RolDescargo){
            jcbTipoDescargo.addItem(rol);}
        new Proceso().start();
        
//lista_Detalles_control_paciente=query1.getResultList();  
    }
    public class Proceso extends Thread{
        Usuario objUsuario;
        boolean hola;
        public Proceso(){
          
        }
        @Override
        public void run(){    
        Lista_LotesVencidos=jpa.createQuery("SELECT p FROM Lote_detalle p where fecha_vencimiento <= GETDATE() and isVencido=0").getResultList();  
        Lista_Usuario=jpa.createQuery("Select p from Usuario p ").getResultList();
        principalEjecucion();
            
        }        
    }
    public void principalEjecucion(){
        
        List<RegistroMensualLotes> listaRegistro=jpa.createQuery("SELECT p FROM RegistroMensualLotes p where fecha_cierre_real is null").getResultList();         
        if(Lista_LotesVencidos.isEmpty()){
            jbtnGuardarVencidos.setEnabled(false);
            jlblMensaje.setVisible(true);            
        }
        else{
            jbtnGuardarVencidos.setEnabled(true);
            jlblMensaje.setVisible(false);    
            }   
        autoCompleterDNI.removeAllItems();
        for (Usuario usuario : Lista_Usuario) {
            autoCompleterDNI.addItem(usuario.getPersona().getDni());
        }
        //autoCompleterDNI.addItem(ui);
        if(listaRegistro.isEmpty()){       
             jlblAdvertencia.setText("El inventario está cerrado");
             jbtnGuardarCampeInsumos.setEnabled(false);
             jbtnGuardarFaltantes.setEnabled(false);
             jbtnGuardarFaltantes2.setEnabled(false);
             jbtnGuardarVencidos.setEnabled(false);
             }
         else{
             jlblAdvertencia.setText("");
             jbtnGuardarCampeInsumos.setEnabled(true);
             jbtnGuardarFaltantes.setEnabled(true);
             jbtnGuardarFaltantes2.setEnabled(true);
             jbtnGuardarVencidos.setEnabled(true);
         }
        
        
        jcbLotesVencidos.removeAllItems();
        
        for (Lote_detalle lotesVenc : Lista_LotesVencidos){
            jcbLotesVencidos.addItem(lotesVenc);
        }
        
    }
    public void iniciar_conVencidos(){
        for (Rol rol : Lista_RolDescargo){
            if(rol.getNombre_rol().equals("VENCIDO")){
                jcbTipoDescargo.setSelectedItem(rol);
                break;
            }            
        }
    }
    public List<Lote_detalle> getListaLote(){
        return listaLotes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlblCodigoDocumentoHead = new javax.swing.JLabel();
        jcbTipoDescargo = new javax.swing.JComboBox<>();
        jtfCodigoDocumento = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jlblCodigoDocumento = new javax.swing.JLabel();
        jlblAdvertencia = new javax.swing.JLabel();
        jtfDNIPERSONAL = new javax.swing.JTextField();
        jlblInformacionPersonal = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo4Campaña = new javax.swing.JPanel();
        jlblPacienteNom = new javax.swing.JLabel();
        jlblMontotañ = new javax.swing.JLabel();
        jbtnAgregarMedicamentos = new javax.swing.JButton();
        jtfNombresPersona = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblDonacion = new javax.swing.JTable();
        jbtnGuardarCampeInsumos = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jlblNombresCampaña = new javax.swing.JLabel();
        cuerpo3Donacion = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jbtnGuardarFaltantes2 = new javax.swing.JButton();
        jtfCodigoLote4 = new javax.swing.JTextField();
        jtfCodigoLote5 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cuerpo1Vencido = new javax.swing.JPanel();
        jlblPF = new javax.swing.JLabel();
        jcbLotesVencidos = new javax.swing.JComboBox<>();
        jbtnAgregarLoteVencido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblLotesSeleccionados = new javax.swing.JTable();
        jlblMensaje = new javax.swing.JLabel();
        jbtnGuardarVencidos = new javax.swing.JButton();
        jlblConc = new javax.swing.JLabel();
        jlblLotesVencidos1 = new javax.swing.JLabel();
        jlblLoteSelecionado2 = new javax.swing.JLabel();
        jlblFF = new javax.swing.JLabel();
        jlblTpf = new javax.swing.JLabel();
        jlblTff = new javax.swing.JLabel();
        jlblTConc = new javax.swing.JLabel();
        jtfMotivoVencido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jlblMotivoVencido = new javax.swing.JLabel();
        cuerpo2Faltante = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfCodigoLotePerdida = new javax.swing.JTextField();
        jtfCantidadPerdida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbtnGuardarFaltantes = new javax.swing.JButton();
        jlblAsteriscoCantidadPerdida = new javax.swing.JLabel();
        jlblAsteriscoCodigoLotePerdida = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtfMotivoPerdida = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jlblProductoFarmaceuticoName = new javax.swing.JLabel();
        jlblFFname = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jlblCantidadName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jlblConcName = new javax.swing.JLabel();
        jlblMotivoPerdida = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(990, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(207, 48, 72));
        head.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DESCARGO");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(255, 255, 255));
        head2.setMinimumSize(new java.awt.Dimension(900, 100));
        head2.setPreferredSize(new java.awt.Dimension(890, 130));
        head2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(890, 60));
        jPanel7.setRequestFocusEnabled(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TIPO :");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 25));

        jlblCodigoDocumentoHead.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblCodigoDocumentoHead.setText("NRO DOCUMENTO:");
        jPanel7.add(jlblCodigoDocumentoHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, 25));

        jcbTipoDescargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbTipoDescargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoDescargoItemStateChanged(evt);
            }
        });
        jPanel7.add(jcbTipoDescargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 240, 25));

        jtfCodigoDocumento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfCodigoDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoDocumentoActionPerformed(evt);
            }
        });
        jtfCodigoDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoDocumentoKeyReleased(evt);
            }
        });
        jPanel7.add(jtfCodigoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 230, 25));

        jLabel31.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel31.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 900, 10));

        jlblCodigoDocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblCodigoDocumento.setForeground(new java.awt.Color(255, 0, 0));
        jlblCodigoDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCodigoDocumento.setText("*");
        jlblCodigoDocumento.setPreferredSize(new java.awt.Dimension(10, 50));
        jPanel7.add(jlblCodigoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 15, 25));

        jlblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jlblAdvertencia.setForeground(new java.awt.Color(255, 0, 0));
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jlblAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 25));

        jtfDNIPERSONAL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfDNIPERSONAL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDNIPERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDNIPERSONALActionPerformed(evt);
            }
        });
        jtfDNIPERSONAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDNIPERSONALKeyReleased(evt);
            }
        });
        jPanel7.add(jtfDNIPERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 170, 25));

        jlblInformacionPersonal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblInformacionPersonal.setForeground(new java.awt.Color(0, 0, 255));
        jlblInformacionPersonal.setPreferredSize(new java.awt.Dimension(34, 25));
        jPanel7.add(jlblInformacionPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 95, 710, -1));

        head2.add(jPanel7, java.awt.BorderLayout.CENTER);

        body.add(head2, java.awt.BorderLayout.PAGE_START);

        body2.setBackground(new java.awt.Color(255, 255, 255));
        body2.setMaximumSize(new java.awt.Dimension(1990, 650));
        body2.setMinimumSize(new java.awt.Dimension(200, 200));
        body2.setPreferredSize(new java.awt.Dimension(9900, 520));
        body2.setLayout(new java.awt.CardLayout());

        cuerpo4Campaña.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo4Campaña.setPreferredSize(new java.awt.Dimension(900, 350));
        cuerpo4Campaña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblPacienteNom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblPacienteNom.setText("PACIENTE:");
        cuerpo4Campaña.add(jlblPacienteNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 25));

        jlblMontotañ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblMontotañ.setForeground(new java.awt.Color(0, 0, 255));
        cuerpo4Campaña.add(jlblMontotañ, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 90, 25));

        jbtnAgregarMedicamentos.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregarMedicamentos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnAgregarMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarMedicamentos.setText("Agregar Medicamentos");
        jbtnAgregarMedicamentos.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnAgregarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarMedicamentosActionPerformed(evt);
            }
        });
        cuerpo4Campaña.add(jbtnAgregarMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 210, 25));

        jtfNombresPersona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfNombresPersona.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNombresPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombresPersonaActionPerformed(evt);
            }
        });
        jtfNombresPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombresPersonaKeyReleased(evt);
            }
        });
        cuerpo4Campaña.add(jtfNombresPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 450, 25));

        jtblDonacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtblDonacion);

        cuerpo4Campaña.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 810, 190));

        jbtnGuardarCampeInsumos.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarCampeInsumos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGuardarCampeInsumos.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarCampeInsumos.setText("Guardar");
        jbtnGuardarCampeInsumos.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnGuardarCampeInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarCampeInsumosActionPerformed(evt);
            }
        });
        cuerpo4Campaña.add(jbtnGuardarCampeInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Total:");
        cuerpo4Campaña.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, -1, 25));

        jlblNombresCampaña.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblNombresCampaña.setForeground(new java.awt.Color(255, 0, 0));
        jlblNombresCampaña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblNombresCampaña.setText("*");
        jlblNombresCampaña.setPreferredSize(new java.awt.Dimension(10, 50));
        cuerpo4Campaña.add(jlblNombresCampaña, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 15, 25));

        body2.add(cuerpo4Campaña, "card2");

        cuerpo3Donacion.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo3Donacion.setPreferredSize(new java.awt.Dimension(900, 350));
        cuerpo3Donacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nombre:");
        cuerpo3Donacion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CANTIDAD :");
        cuerpo3Donacion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, 25));

        jbtnGuardarFaltantes2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGuardarFaltantes2.setText("Guardar");
        jbtnGuardarFaltantes2.setPreferredSize(new java.awt.Dimension(100, 25));
        cuerpo3Donacion.add(jbtnGuardarFaltantes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, 25));

        jtfCodigoLote4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfCodigoLote4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoLote4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoLote4ActionPerformed(evt);
            }
        });
        cuerpo3Donacion.add(jtfCodigoLote4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 230, 25));

        jtfCodigoLote5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfCodigoLote5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoLote5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoLote5ActionPerformed(evt);
            }
        });
        cuerpo3Donacion.add(jtfCodigoLote5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 180, 25));

        jLabel30.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel30.setPreferredSize(new java.awt.Dimension(700, 14));
        cuerpo3Donacion.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 10));

        body2.add(cuerpo3Donacion, "card2");

        cuerpo1Vencido.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo1Vencido.setPreferredSize(new java.awt.Dimension(900, 350));
        cuerpo1Vencido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblPF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblPF.setForeground(new java.awt.Color(0, 0, 255));
        jlblPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuerpo1Vencido.add(jlblPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 540, 25));

        jcbLotesVencidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbLotesVencidos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbLotesVencidosItemStateChanged(evt);
            }
        });
        cuerpo1Vencido.add(jcbLotesVencidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 170, 25));

        jbtnAgregarLoteVencido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnAgregarLoteVencido.setText("+");
        jbtnAgregarLoteVencido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarLoteVencidoActionPerformed(evt);
            }
        });
        cuerpo1Vencido.add(jbtnAgregarLoteVencido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 50, 25));

        jtblLotesSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jtblLotesSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblLotesSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblLotesSeleccionados);

        cuerpo1Vencido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 230, 110));

        jlblMensaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        jlblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensaje.setText("NO HAY NINGÚN LOTE VENCIDO");
        cuerpo1Vencido.add(jlblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 900, 25));

        jbtnGuardarVencidos.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarVencidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGuardarVencidos.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarVencidos.setText("Guardar");
        jbtnGuardarVencidos.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnGuardarVencidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarVencidosActionPerformed(evt);
            }
        });
        cuerpo1Vencido.add(jbtnGuardarVencidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, 25));

        jlblConc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblConc.setForeground(new java.awt.Color(0, 0, 255));
        cuerpo1Vencido.add(jlblConc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 110, 25));

        jlblLotesVencidos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblLotesVencidos1.setText("LOTES VENCIDOS :");
        cuerpo1Vencido.add(jlblLotesVencidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 25));

        jlblLoteSelecionado2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblLoteSelecionado2.setText("LOTES SELECCIONADOS :");
        cuerpo1Vencido.add(jlblLoteSelecionado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, 25));

        jlblFF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblFF.setForeground(new java.awt.Color(0, 0, 255));
        cuerpo1Vencido.add(jlblFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 80, 25));

        jlblTpf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTpf.setText("P.F:");
        cuerpo1Vencido.add(jlblTpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 25));

        jlblTff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTff.setText("F.F :");
        cuerpo1Vencido.add(jlblTff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 25));

        jlblTConc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTConc.setText("Conc :");
        cuerpo1Vencido.add(jlblTConc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, 25));

        jtfMotivoVencido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfMotivoVencido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMotivoVencido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMotivoVencidoKeyReleased(evt);
            }
        });
        cuerpo1Vencido.add(jtfMotivoVencido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 710, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("MOTIVO :");
        cuerpo1Vencido.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 25));

        jLabel32.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel32.setPreferredSize(new java.awt.Dimension(700, 14));
        cuerpo1Vencido.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 900, 10));

        jlblMotivoVencido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblMotivoVencido.setForeground(new java.awt.Color(255, 0, 0));
        jlblMotivoVencido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMotivoVencido.setText("*");
        cuerpo1Vencido.add(jlblMotivoVencido, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 15, 25));

        body2.add(cuerpo1Vencido, "card2");

        cuerpo2Faltante.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo2Faltante.setPreferredSize(new java.awt.Dimension(900, 350));
        cuerpo2Faltante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cuerpo2FaltanteKeyReleased(evt);
            }
        });
        cuerpo2Faltante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CANTIDAD :");
        cuerpo2Faltante.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, 25));

        jtfCodigoLotePerdida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfCodigoLotePerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoLotePerdida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoLotePerdidaActionPerformed(evt);
            }
        });
        jtfCodigoLotePerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoLotePerdidaKeyReleased(evt);
            }
        });
        cuerpo2Faltante.add(jtfCodigoLotePerdida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 230, 25));

        jtfCantidadPerdida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfCantidadPerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCantidadPerdida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCantidadPerdidaActionPerformed(evt);
            }
        });
        jtfCantidadPerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadPerdidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadPerdidaKeyTyped(evt);
            }
        });
        cuerpo2Faltante.add(jtfCantidadPerdida, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 180, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Conc:");
        cuerpo2Faltante.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, 25));

        jbtnGuardarFaltantes.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarFaltantes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGuardarFaltantes.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarFaltantes.setText("Guardar");
        jbtnGuardarFaltantes.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnGuardarFaltantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarFaltantesActionPerformed(evt);
            }
        });
        cuerpo2Faltante.add(jbtnGuardarFaltantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, 25));

        jlblAsteriscoCantidadPerdida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblAsteriscoCantidadPerdida.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoCantidadPerdida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoCantidadPerdida.setText("*");
        cuerpo2Faltante.add(jlblAsteriscoCantidadPerdida, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 15, 25));

        jlblAsteriscoCodigoLotePerdida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblAsteriscoCodigoLotePerdida.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteriscoCodigoLotePerdida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteriscoCodigoLotePerdida.setText("*");
        cuerpo2Faltante.add(jlblAsteriscoCodigoLotePerdida, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 15, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("MOTIVO :");
        cuerpo2Faltante.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 25));

        jtfMotivoPerdida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfMotivoPerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMotivoPerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMotivoPerdidaKeyReleased(evt);
            }
        });
        cuerpo2Faltante.add(jtfMotivoPerdida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 710, 25));

        jLabel33.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel33.setPreferredSize(new java.awt.Dimension(700, 14));
        cuerpo2Faltante.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 900, 10));

        jlblProductoFarmaceuticoName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblProductoFarmaceuticoName.setForeground(new java.awt.Color(0, 0, 255));
        jlblProductoFarmaceuticoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuerpo2Faltante.add(jlblProductoFarmaceuticoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 320, 25));

        jlblFFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblFFname.setForeground(new java.awt.Color(0, 0, 255));
        cuerpo2Faltante.add(jlblFFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 110, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("CANTIDAD DISPONIBLE:");
        cuerpo2Faltante.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, -1, 25));

        jlblCantidadName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblCantidadName.setForeground(new java.awt.Color(0, 0, 255));
        cuerpo2Faltante.add(jlblCantidadName, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 100, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("F.F:");
        cuerpo2Faltante.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("P.F:");
        cuerpo2Faltante.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 25));

        jlblConcName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblConcName.setForeground(new java.awt.Color(0, 0, 255));
        cuerpo2Faltante.add(jlblConcName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 100, 25));

        jlblMotivoPerdida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblMotivoPerdida.setForeground(new java.awt.Color(255, 0, 0));
        jlblMotivoPerdida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMotivoPerdida.setText("*");
        cuerpo2Faltante.add(jlblMotivoPerdida, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 15, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("CÓDIGO LOTE :");
        cuerpo2Faltante.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 25));

        body2.add(cuerpo2Faltante, "card2");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoDocumentoActionPerformed

    private void jtfCodigoLotePerdidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoLotePerdidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoLotePerdidaActionPerformed

    private void jtfCantidadPerdidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCantidadPerdidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadPerdidaActionPerformed

    private void jcbTipoDescargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoDescargoItemStateChanged
           if(((Rol)jcbTipoDescargo.getSelectedItem())!=null){
               switch(((Rol)jcbTipoDescargo.getSelectedItem()).getNombre_rol()){
                   case "PÉRDIDA":       
                       jlblInformacionPersonal.setVisible(false);
                       cuerpo2Faltante.setVisible(true);
                       cuerpo4Campaña.setVisible(false);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo3Donacion.setVisible(false);                       
                       TextAutoCompleterLotes.removeAllItems();
                     //listaLotes=jpa.createQuery("SELECT p FROM Lote_detalle p where isVencido=0").getResultList();
                       for (Lote_detalle listaLote : listaLotes){
                           TextAutoCompleterLotes.addItem(listaLote);}                       
                       break;
                   case "DONACIÓN":
                       jlblInformacionPersonal.setVisible(false);
                       jtfCodigoDocumento.setVisible(true);
                       jlblCodigoDocumentoHead.setVisible(true);
                       jlblCodigoDocumento.setVisible(true);
                       jlblCodigoDocumentoHead.setText("NRO. DOCUMENTO");
                       jtfDNIPERSONAL.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo2Faltante.setVisible(true);
                       cuerpo4Campaña.setVisible(false);
                       break;
                   case "VENCIDO":
                       jlblInformacionPersonal.setVisible(false);
                       jtfCodigoDocumento.setVisible(true);
                       jlblCodigoDocumentoHead.setVisible(true);
                       jlblCodigoDocumento.setVisible(true);
                       jlblCodigoDocumentoHead.setText("NRO. DOCUMENTO");
                       jtfDNIPERSONAL.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo4Campaña.setVisible(false);
                       cuerpo1Vencido.setVisible(true);
                       cuerpo2Faltante.setVisible(false);
                       break;
                   case "CAMPAÑA": 
                       jlblPacienteNom.setVisible(true);
                       jtfNombresPersona.setVisible(true);
                       jlblNombresCampaña.setVisible(true);
                       jlblInformacionPersonal.setVisible(false);
                       jtfCodigoDocumento.setVisible(false);
                       jlblCodigoDocumentoHead.setVisible(false);
                       jlblCodigoDocumento.setVisible(false);
                       jlblCodigoDocumentoHead.setText("NRO. DOCUMENTO");
                       jtfDNIPERSONAL.setVisible(false);
                       cuerpo4Campaña.setVisible(true);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo2Faltante.setVisible(false);
                       break;  
                    
                   case "ODONTOLOGÍA":  
                       jlblPacienteNom.setVisible(false);
                       jtfNombresPersona.setVisible(false);
                       jlblNombresCampaña.setVisible(false);
                       jlblInformacionPersonal.setVisible(true);
                       jlblCodigoDocumentoHead.setVisible(true);
                       jtfCodigoDocumento.setVisible(false);
                       jlblCodigoDocumento.setVisible(false);
                       jtfDNIPERSONAL.setVisible(true);
                       jlblCodigoDocumentoHead.setText("NRO DNI");
                       cuerpo4Campaña.setVisible(true);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo2Faltante.setVisible(false);
                       break;
                    
                   case "ENFERMERÍA": 
                       jlblPacienteNom.setVisible(false);
                       jtfNombresPersona.setVisible(false);
                       jlblNombresCampaña.setVisible(false);
                       jlblInformacionPersonal.setVisible(true);
                       jlblCodigoDocumentoHead.setVisible(true);
                       jtfCodigoDocumento.setVisible(false);
                       jlblCodigoDocumento.setVisible(false);
                       jtfDNIPERSONAL.setVisible(true);
                       jlblCodigoDocumentoHead.setText("NRO DNI");
                       cuerpo4Campaña.setVisible(true);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo2Faltante.setVisible(false);
                       break;     
                    
                   case "LABORATORIO": 
                       jlblPacienteNom.setVisible(false);
                       jtfNombresPersona.setVisible(false);
                       jlblNombresCampaña.setVisible(false);
                       jlblInformacionPersonal.setVisible(true);
                       jtfCodigoDocumento.setVisible(false);
                       jlblCodigoDocumentoHead.setVisible(true);
                       jlblCodigoDocumento.setVisible(false);
                       jtfDNIPERSONAL.setVisible(true);
                       jlblCodigoDocumentoHead.setText("NRO DNI");
                       cuerpo4Campaña.setVisible(true);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo2Faltante.setVisible(false);
                       break;  
                    case "OBSTETRICIA": 
                       jlblPacienteNom.setVisible(false);
                       jtfNombresPersona.setVisible(false);
                       jlblNombresCampaña.setVisible(false);
                       jlblInformacionPersonal.setVisible(true);
                       jtfCodigoDocumento.setVisible(false);
                       jlblCodigoDocumentoHead.setVisible(true);
                       jlblCodigoDocumento.setVisible(false);
                       jtfDNIPERSONAL.setVisible(true);
                       jlblCodigoDocumentoHead.setText("NRO DNI");
                       cuerpo4Campaña.setVisible(true);
                       cuerpo1Vencido.setVisible(false);
                       cuerpo3Donacion.setVisible(false);
                       cuerpo2Faltante.setVisible(false);
                       break;     
                          
                       
                       
                   default:
                       System.out.println("no reconoce ninguno");
                       }
               
               }
    }//GEN-LAST:event_jcbTipoDescargoItemStateChanged

    private void jcbLotesVencidosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbLotesVencidosItemStateChanged
        if(((Lote_detalle)jcbLotesVencidos.getSelectedItem())!=null){
            Lote_detalle obj=(Lote_detalle)jcbLotesVencidos.getSelectedItem();
            jlblConc.setVisible(true);
            jlblFF.setVisible(true);
            jlblPF.setVisible(true);
            jlblTConc.setVisible(true);
            jlblTff.setVisible(true);
            jlblTpf.setVisible(true);
            jlblConc.setText(obj.getInventario().getMedicamento().getConcentracion());
            jlblFF.setText(obj.getInventario().getMedicamento().getForma_farmaceutica());
            jlblPF.setText(obj.getInventario().getMedicamento().getNombre());
        }
        else{
            jlblConc.setVisible(false);
            jlblFF.setVisible(false);
            jlblPF.setVisible(false);
            jlblTConc.setVisible(false);
            jlblTff.setVisible(false);
            jlblTpf.setVisible(false);
        }
    }//GEN-LAST:event_jcbLotesVencidosItemStateChanged

    private void jbtnAgregarLoteVencidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarLoteVencidoActionPerformed
        if(jcbLotesVencidos.getSelectedItem()!=null){
            Lote_detalle objLotes=(Lote_detalle)jcbLotesVencidos.getSelectedItem();
            jcbLotesVencidos.removeItem(objLotes);
            Lista_CarritosDeVencidos.add(objLotes);
            llenarTabla(Lista_CarritosDeVencidos);            
        }
        
    }//GEN-LAST:event_jbtnAgregarLoteVencidoActionPerformed

    private void jtblLotesSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLotesSeleccionadosMouseClicked
         
        Lote_detalle objLote_Detalle =(Lote_detalle)jtblLotesSeleccionados.getValueAt(jtblLotesSeleccionados.getSelectedRow(),0);
        jcbLotesVencidos.addItem(objLote_Detalle);
        Lista_CarritosDeVencidos.remove(objLote_Detalle);
        llenarTabla(Lista_CarritosDeVencidos);
        
        

    }//GEN-LAST:event_jtblLotesSeleccionadosMouseClicked

    private void jtfNombresPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombresPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombresPersonaActionPerformed

    private void jtfCodigoLotePerdidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoLotePerdidaKeyReleased
           for (Lote_detalle listaLote : listaLotes){
               if(listaLote.getCodigo().equals(jtfCodigoLotePerdida.getText())){
                   objLote=listaLote;
                   jlblCantidadName.setText(listaLote.getCantidad()+"");
                   jlblConcName.setText(listaLote.getInventario().getMedicamento().getConcentracion());
                   jlblFFname.setText(listaLote.getInventario().getMedicamento().getForma_farmaceutica());
                   jlblProductoFarmaceuticoName.setText(listaLote.getInventario().getMedicamento().getNombre());
                   jlblAsteriscoCodigoLotePerdida.setText("");
                   break;
               }
               jtfCantidadPerdida.setText("");
               jlblAsteriscoCodigoLotePerdida.setText("*");
               jlblCantidadName.setText("");
               jlblConcName.setText("");
               jlblFFname.setText("");
               jlblProductoFarmaceuticoName.setText("");
               }
        
    }//GEN-LAST:event_jtfCodigoLotePerdidaKeyReleased

    private void cuerpo2FaltanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuerpo2FaltanteKeyReleased
              
            
    }//GEN-LAST:event_cuerpo2FaltanteKeyReleased

    private void jtfCantidadPerdidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadPerdidaKeyReleased
        if(jtfCantidadPerdida.getText().isEmpty()){
            jlblAsteriscoCantidadPerdida.setText("*");
        }else{
            jlblAsteriscoCantidadPerdida.setText("");
            if(Integer.parseInt(jtfCantidadPerdida.getText())>objLote.getCantidad()){
                jbtnGuardarFaltantes.setEnabled(false);
                }
            else{
                jbtnGuardarFaltantes.setEnabled(true);
                }
        }
        
    }//GEN-LAST:event_jtfCantidadPerdidaKeyReleased

    private void jtfCantidadPerdidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadPerdidaKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
          
                evt.consume();  
                
            }     
        
        if (jtfCantidadPerdida.getText().length()>=3){ 
         evt.consume(); 
         }
        if(' '==evt.getKeyChar()){
            evt.consume();
        }
        
    }//GEN-LAST:event_jtfCantidadPerdidaKeyTyped

    private void jtfCodigoLote5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoLote5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoLote5ActionPerformed

    private void jtfCodigoLote4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoLote4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoLote4ActionPerformed

    private void jbtnAgregarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarMedicamentosActionPerformed
 
       CuadroCarritoMedicinas objCuadroCarritoMedicinas=new CuadroCarritoMedicinas(jpa,this);
       objCuadroCarritoMedicinas.setVisible(true);
       objPrincipal.setEnabled(false);        
    }//GEN-LAST:event_jbtnAgregarMedicamentosActionPerformed

    private void jtfCodigoDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoDocumentoKeyReleased
        if(jtfCodigoDocumento.getText().isEmpty()){
            jlblCodigoDocumento.setText("*");
        }
        else{
            jlblCodigoDocumento.setText("");
        }
    }//GEN-LAST:event_jtfCodigoDocumentoKeyReleased

    private void jtfMotivoPerdidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMotivoPerdidaKeyReleased
        
        if(jtfMotivoPerdida.getText().isEmpty()){
            jlblMotivoPerdida.setText("*");
        }
        else{
            jlblMotivoPerdida.setText("");
        }
    }//GEN-LAST:event_jtfMotivoPerdidaKeyReleased

    private void jtfMotivoVencidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMotivoVencidoKeyReleased
        if(jtfMotivoVencido.getText().isEmpty()){
            jlblMotivoVencido.setText("*");
        }
        else{
            jlblMotivoVencido.setText("");
        }
    }//GEN-LAST:event_jtfMotivoVencidoKeyReleased

    public void GuardarPerdidos(){
        if(jlblCodigoDocumento.getText().isEmpty() && jlblMotivoPerdida.getText().isEmpty()
           && jlblAsteriscoCodigoLotePerdida.getText().isEmpty() && jlblAsteriscoCantidadPerdida.getText().isEmpty()){
            Descarga objDescargoFaltante=new Descarga();
        objDescargoFaltante.setCantidad(Integer.parseInt(jtfCantidadPerdida.getText()));
      //objDescargoFaltante.setDestino_persona(TOOL_TIP_TEXT_KEY);
        objDescargoFaltante.setFecha(new Date());
        objDescargoFaltante.setLote_detalle(objLote);
        objDescargoFaltante.setMotivo(jtfMotivoPerdida.getText());
        objDescargoFaltante.setUsuario(objUsuario);
        objDescargoFaltante.setCodigo_documento(jtfCodigoDocumento.getText());
        objDescargoFaltante.setRolTipo((Rol)jcbTipoDescargo.getSelectedItem());
        objLote.setCantidad(objLote.getCantidad()-objDescargoFaltante.getCantidad());
        objLote.getInventario().setCantidad(objLote.getInventario().getCantidad()-objDescargoFaltante.getCantidad());
        jpa.getTransaction().begin();
        jpa.persist(objDescargoFaltante);
        JOptionPane.showMessageDialog(jPanel7, "Guardado con exito");
        limpiarPerdidos();
        ConsultaBD();
        principalEjecucion();
        jpa.getTransaction().commit();
        }
        else{
            JOptionPane.showMessageDialog(jPanel7, "llene los espacios con *");
        }
    }
    public void GuardarVencidos(){        
        if(jlblMotivoVencido.getText().isEmpty() && jlblCodigoDocumento.getText().isEmpty()){
            if(!Lista_CarritosDeVencidos.isEmpty()){
                //
                jpa.getTransaction().begin();
                
                for (Lote_detalle lote : Lista_CarritosDeVencidos){
                    Descarga objDescargoVencido=new Descarga();
                    objDescargoVencido.setCantidad(lote.getCantidad());
                    //objDescargoFaltante.setDestino_persona(TOOL_TIP_TEXT_KEY);
                    objDescargoVencido.setFecha(new Date());
                    objDescargoVencido.setLote_detalle(lote);
                    objDescargoVencido.setMotivo(jtfMotivoVencido.getText());
                    objDescargoVencido.setUsuario(objUsuario);
                    objDescargoVencido.setCodigo_documento(jtfCodigoDocumento.getText());
                    objDescargoVencido.setRolTipo((Rol)jcbTipoDescargo.getSelectedItem());
                    lote.getInventario().setCantidad(lote.getInventario().getCantidad()-objDescargoVencido.getCantidad());
                    lote.setIsVencido(true);
                    jpa.persist(objDescargoVencido);
                }
                JOptionPane.showMessageDialog(jPanel7, "Guardado con Exito");
                limpiarVencidos();
                ConsultaBD();
                principalEjecucion();
                jpa.getTransaction().commit();
                
            }
            else{
                JOptionPane.showMessageDialog(jPanel7,"no seleccionó un lote!");
            }
            
            
        }
        else{
            JOptionPane.showMessageDialog(jPanel7,"llene los espacios con *");                        
        }
    }
    public void limpiarPerdidos(){
        jtfCantidadPerdida.setText("");
        jtfCodigoDocumento.setText("");
        jtfMotivoPerdida.setText("");
        jtfCodigoLotePerdida.setText("");
        
        jlblCodigoDocumento.setText("*");
        jlblMotivoPerdida.setText("*");
        jlblAsteriscoCodigoLotePerdida.setText("*");
        jlblAsteriscoCantidadPerdida.setText("*");
    }
    public void limpiarVencidos(){
        Lista_CarritosDeVencidos.clear();
        llenarTabla(Lista_CarritosDeVencidos);
        jtfCodigoDocumento.setText("");
        jtfMotivoVencido.setText("");        
        jlblCodigoDocumento.setText("*");
        jlblMotivoVencido.setText("*");
    }
    
    private void jbtnGuardarFaltantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarFaltantesActionPerformed
           GuardarPerdidos();
           
        
        
    }//GEN-LAST:event_jbtnGuardarFaltantesActionPerformed

    private void jbtnGuardarVencidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarVencidosActionPerformed
          GuardarVencidos();
          
    }//GEN-LAST:event_jbtnGuardarVencidosActionPerformed

    private void jbtnGuardarCampeInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarCampeInsumosActionPerformed
        GuardarCampaña();
        
    }//GEN-LAST:event_jbtnGuardarCampeInsumosActionPerformed

    private void jtfNombresPersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombresPersonaKeyReleased
        if(jtfNombresPersona.getText().isEmpty()){
            jlblNombresCampaña.setText("*");
        }
        else{
            jlblNombresCampaña.setText("");
        }
    }//GEN-LAST:event_jtfNombresPersonaKeyReleased

    private void jtfDNIPERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDNIPERSONALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDNIPERSONALActionPerformed
    Usuario objPersonaReceptor;
    private void jtfDNIPERSONALKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDNIPERSONALKeyReleased
        for (Usuario usuario : Lista_Usuario){
            if(jtfDNIPERSONAL.getText().equals(usuario.getPersona().getDni())){
                jlblInformacionPersonal.setText(usuario.getRol().getAbre_rol()+" : "+usuario.getPersona().getInfoPersona());
                objPersonaReceptor=usuario;
                break;
            }         
            jlblInformacionPersonal.setText("");
        }
    }//GEN-LAST:event_jtfDNIPERSONALKeyReleased

    public void GuardarCampaña(){
        if(!jtfDNIPERSONAL.getText().isEmpty() || (jlblCodigoDocumento.getText().isEmpty()&& jlblNombresCampaña.getText().isEmpty())){
            if(!Lista_Medicamentos_Campaña.isEmpty()){
                jpa.getTransaction().begin();
                for (Detalle_Medicamentos objDetalleMedicamento : Lista_Medicamentos_Campaña) {
                    Descarga objDescargaCampaña=new Descarga();
                    objDescargaCampaña.setCantidad(objDetalleMedicamento.getCantidad());
                    objDescargaCampaña.setCodigo_documento(jtfCodigoDocumento.getText());
                    objDescargaCampaña.setDestino_persona(jtfNombresPersona.getText());
                    objDescargaCampaña.setFecha(new Date());
                    objDescargaCampaña.setLote_detalle(objDetalleMedicamento.getLote_detalle());
                    objDescargaCampaña.setRolTipo((Rol)jcbTipoDescargo.getSelectedItem());
                    objDescargaCampaña.setUsuario(objUsuario);  
                    objDescargaCampaña.setUsuarioRecibe(objPersonaReceptor);
                    jpa.persist(objDescargaCampaña);
                    }
                JOptionPane.showMessageDialog(jPanel7, "Guardado con Exito");
                Lista_Medicamentos_Campaña.clear();
                llenarTablaDetalleMedicmentos(Lista_Medicamentos_Campaña);
                jtfCodigoDocumento.setText("");
                jtfNombresPersona.setText("");
                jlblMontotañ.setText("0.00");
                ConsultaBD();
                principalEjecucion();
                jpa.getTransaction().commit();                
            }
            else{
                JOptionPane.showMessageDialog(jPanel7, "Agregue un Medicamento");
            }
        }
        else{
            JOptionPane.showMessageDialog(jPanel7, "llene los espacios con *");            
        }
    }
    public void llenarTabla(List<Lote_detalle> Lista_CarritoLote){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Código","Cantidad"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false, false, false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (Lote_detalle objLote: Lista_CarritoLote){
                 fila_actividad[0]=objLote;
                 fila_actividad[1]=objLote.getCantidad();  
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblLotesSeleccionados.setModel(modelo); 
            jtblLotesSeleccionados.setGridColor(Color.BLACK);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblLotesSeleccionados.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblLotesSeleccionados.getColumnModel().getColumn(1).setCellRenderer(tcr);           
            jtblLotesSeleccionados.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblLotesSeleccionados.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblLotesSeleccionados.getTableHeader().setBackground(Color.BLUE);
            jtblLotesSeleccionados.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblLotesSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtblLotesSeleccionados.getColumnModel().getColumn(1).setPreferredWidth(200);          
            ((DefaultTableCellRenderer)jtblLotesSeleccionados.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64       
    }   
    //
    public void llenarTablaDetalleMedicmentos(List<Detalle_Medicamentos> Lista_CarritoLote){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Medicamento","Cantidad","Precio Unitario","Precio Total","Lote"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false, false, false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (Detalle_Medicamentos objMedicamento: Lista_CarritoLote){
                 fila_actividad[0]=objMedicamento.getId_Medicamento().getNombre();
                 fila_actividad[1]=objMedicamento.getCantidad();
                 fila_actividad[2]=objMedicamento.getPrecio_Unitario();
                 fila_actividad[3]=objMedicamento.getPrecio_Total();
                 fila_actividad[4]=objMedicamento.getLote_detalle().getCodigo();
                   
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblDonacion.setModel(modelo); 
            jtblDonacion.setGridColor(Color.BLACK);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblDonacion.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblDonacion.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblDonacion.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblDonacion.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtblDonacion.getColumnModel().getColumn(4).setCellRenderer(tcr);       
            jtblDonacion.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblDonacion.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblDonacion.getTableHeader().setBackground(Color.BLUE);
            jtblDonacion.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblDonacion.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtblDonacion.getColumnModel().getColumn(1).setPreferredWidth(175);
            jtblDonacion.getColumnModel().getColumn(2).setPreferredWidth(175);
            jtblDonacion.getColumnModel().getColumn(3).setPreferredWidth(175);  
            jtblDonacion.getColumnModel().getColumn(4).setPreferredWidth(175); 
            ((DefaultTableCellRenderer)jtblDonacion.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
            
            
    }
    //

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cuerpo1Vencido;
    private javax.swing.JPanel cuerpo2Faltante;
    private javax.swing.JPanel cuerpo3Donacion;
    private javax.swing.JPanel cuerpo4Campaña;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAgregarLoteVencido;
    private javax.swing.JButton jbtnAgregarMedicamentos;
    private javax.swing.JButton jbtnGuardarCampeInsumos;
    private javax.swing.JButton jbtnGuardarFaltantes;
    private javax.swing.JButton jbtnGuardarFaltantes2;
    private javax.swing.JButton jbtnGuardarVencidos;
    private javax.swing.JComboBox<Lote_detalle> jcbLotesVencidos;
    private javax.swing.JComboBox<Rol> jcbTipoDescargo;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblAsteriscoCantidadPerdida;
    private javax.swing.JLabel jlblAsteriscoCodigoLotePerdida;
    private javax.swing.JLabel jlblCantidadName;
    private javax.swing.JLabel jlblCodigoDocumento;
    private javax.swing.JLabel jlblCodigoDocumentoHead;
    private javax.swing.JLabel jlblConc;
    private javax.swing.JLabel jlblConcName;
    private javax.swing.JLabel jlblFF;
    private javax.swing.JLabel jlblFFname;
    private javax.swing.JLabel jlblInformacionPersonal;
    private javax.swing.JLabel jlblLoteSelecionado2;
    private javax.swing.JLabel jlblLotesVencidos1;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JLabel jlblMontotañ;
    private javax.swing.JLabel jlblMotivoPerdida;
    private javax.swing.JLabel jlblMotivoVencido;
    private javax.swing.JLabel jlblNombresCampaña;
    private javax.swing.JLabel jlblPF;
    private javax.swing.JLabel jlblPacienteNom;
    private javax.swing.JLabel jlblProductoFarmaceuticoName;
    private javax.swing.JLabel jlblTConc;
    private javax.swing.JLabel jlblTff;
    private javax.swing.JLabel jlblTpf;
    private javax.swing.JTable jtblDonacion;
    private javax.swing.JTable jtblLotesSeleccionados;
    private javax.swing.JTextField jtfCantidadPerdida;
    private javax.swing.JTextField jtfCodigoDocumento;
    private javax.swing.JTextField jtfCodigoLote4;
    private javax.swing.JTextField jtfCodigoLote5;
    private javax.swing.JTextField jtfCodigoLotePerdida;
    private javax.swing.JTextField jtfDNIPERSONAL;
    private javax.swing.JTextField jtfMotivoPerdida;
    private javax.swing.JTextField jtfMotivoVencido;
    private javax.swing.JTextField jtfNombresPersona;
    // End of variables declaration//GEN-END:variables

    
    
    
    

}
