package com.ecoedu.Vistas.Inventario;


import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.soloMayusculas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.app.TextPrompt;
import com.ecoedu.model.Detalle_llenado;
import com.ecoedu.model.Factura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.ecoedu.model.Inventario;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.RegistroMensualLotes;
import com.ecoedu.model.Rol;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
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
public class LlenarInventario extends javax.swing.JPanel {   
    String MensajeProductoFarmaceutico="";
    String MensajeFabricante="";
    List<Inventario> Lista_Inventario;    
    List<Lote_detalle> Lista_Lote_detalle_final=new ArrayList<>();
    List<Detalle_llenado> Lista_Detalle_Llenado_final=new ArrayList<>();    
    List<Rol> Lista_Proveedor;
    List<Rol> Lista_Fabricante;//lo uso mucho 
    EntityManager jpa;
    Principal objPrincipal;
    TextAutoCompleter autoCompleterProductoFarmaceutico;
    TextAutoCompleter autoCompleterFabricante;
    TextAutoCompleter autoCompleterProveedor;
    Inventario objInventario_final=new Inventario();        
    public LlenarInventario(EntityManager objJPA,Principal OBJPrincipal) {
        initComponents();
        jtfProductoFarmaceutico.setDocument(new soloMayusculas());
        this.autoCompleterProductoFarmaceutico=new TextAutoCompleter(jtfProductoFarmaceutico, new AutoCompleterCallback(){
            @Override
            public void callback(Object o){
                encontrarMedicamento((String)o);}});
        this.autoCompleterFabricante=new TextAutoCompleter(jtfLaboratorio,new AutoCompleterCallback(){
            @Override
            public void callback(Object o) { /*  */}});
        this.autoCompleterProveedor=new TextAutoCompleter(jtfProveedor,new AutoCompleterCallback() {
            @Override
            public void callback(Object o) {    }});
        this.jpa=objJPA;
        this.objPrincipal=OBJPrincipal;     
    }
              
    public void ConsultaBD(){
        List<RegistroMensualLotes> lista_registro=jpa.createQuery("SELECT p FROM RegistroMensualLotes p where fecha_cierre_real is null").getResultList();
        if(lista_registro.isEmpty()){
            Query query2=jpa.createQuery("SELECT p FROM Inventario p");
            Lista_Inventario=query2.getResultList();
            Query query3=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=3");
            Lista_Fabricante=query3.getResultList();        
            Query query4=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=2");
            Lista_Proveedor=query4.getResultList();
            principalEjecucion();
            }
        else{
            jlblHeadMensaje.setText("No puede llenar hasta que el inventario de "+Herramienta.getNombreMes(lista_registro.get(0).getFecha_apertura().getMonth()+1)+" se cierre");
            jlblHeadMensaje.setForeground(Color.RED);
            jtfProductoFarmaceutico.setEnabled(false);
            jtfCodigoLote.setEnabled(false);
            jtfCantidad.setEnabled(false);
            jtfPrecioUnitarioCompra.setEnabled(false);
            jtfA�ovencimiento.setEnabled(false);
            jtfMesVen.setEnabled(false);
            jtfDiaVenc.setEnabled(false);
            jtfLaboratorio.setEnabled(false);
            jbtnAgregarLotes.setEnabled(false);
            jbtnGuardarLotes.setEnabled(false);
            jtfCodigoFactura.setEnabled(false);
            jtfProveedor.setEnabled(false);
            }
        }   
    public void principalEjecucion(){
        llenar_tabla_LoteDetalle(Lista_Lote_detalle_final, Lista_Detalle_Llenado_final);
        autoCompleterFabricante.removeAllItems();
        autoCompleterProductoFarmaceutico.removeAllItems();
        autoCompleterProveedor.removeAllItems();
        for (int i = 0; i < Lista_Inventario.size(); i++) {
            autoCompleterProductoFarmaceutico.addItem(Lista_Inventario.get(i).getMedicamento().getNombre());
        }   
        for (int i = 0; i < Lista_Fabricante.size(); i++) {
            autoCompleterFabricante.addItem(Lista_Fabricante.get(i).getNombre_rol());
        }  
        for (int i = 0; i < Lista_Proveedor.size(); i++) {
            autoCompleterProveedor.addItem(Lista_Proveedor.get(i).getNombre_rol());
        }  
        jlblFechaHoy.setText(Herramienta.formatoFechaMas1(new Date()));
        TextPrompt txr=new TextPrompt("AA",jtfA�ovencimiento);
         txr=new TextPrompt("MM",jtfMesVen);
         txr=new TextPrompt("DD",jtfDiaVenc);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bodyCard = new javax.swing.JPanel();
        vistaLlenar = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlblHeadMensaje = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlblConcentracion = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfPrecioUnitarioCompra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfProductoFarmaceutico = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfDiaVenc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jlblFechaHoy = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jlblFormaFarmaceutica = new javax.swing.JLabel();
        jlblMensaje = new javax.swing.JLabel();
        jtfLaboratorio = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblLoteDetalle = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jbtnGuardarLotes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtnGuardarLotes1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jlblPVR = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtfCodigoLote = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jtfA�ovencimiento = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtfMesVen = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jlblAstePF = new javax.swing.JLabel();
        jlblAsteCodigoLote = new javax.swing.JLabel();
        jlblAsteCantidad = new javax.swing.JLabel();
        jlblAstePUC = new javax.swing.JLabel();
        jlblAsteFechaVenc = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jbtnAgregarLotes = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jtfCodigoFactura = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtfProveedor = new javax.swing.JTextField();
        jlblAsteFactura = new javax.swing.JLabel();
        jlblAsteProveedor = new javax.swing.JLabel();
        jlblAsteFabricante = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jlblFormaOrigen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(900, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(0, 102, 102));
        head.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("LLENAR INVENTARIO");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        bodyCard.setLayout(new java.awt.CardLayout());

        vistaLlenar.setBackground(new java.awt.Color(255, 255, 255));
        vistaLlenar.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jlblHeadMensaje.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblHeadMensaje.setText("Ingrese los datos correspondientes");
        jPanel6.add(jlblHeadMensaje);

        jPanel13.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblConcentracion.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblConcentracion.setForeground(new java.awt.Color(0, 102, 204));
        jlblConcentracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConcentracion.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jlblConcentracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 150, -1));

        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("C�digo del Lote:");
        jLabel18.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 25));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Fecha Registro:");
        jLabel11.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 110, 25));

        jtfPrecioUnitarioCompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfPrecioUnitarioCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfPrecioUnitarioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPrecioUnitarioCompraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPrecioUnitarioCompraKeyTyped(evt);
            }
        });
        jPanel7.add(jtfPrecioUnitarioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 70, 25));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Precio Venta Redondeado");
        jLabel16.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 190, 25));

        jtfProductoFarmaceutico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfProductoFarmaceutico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfProductoFarmaceutico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfProductoFarmaceuticoKeyReleased(evt);
            }
        });
        jPanel7.add(jtfProductoFarmaceutico, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 640, 25));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Origen");
        jLabel19.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 60, 25));

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
        jPanel7.add(jtfDiaVenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 40, 25));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Producto Farmaceutico:");
        jLabel6.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, -1));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Concentraci�n");
        jLabel23.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 110, 25));

        jlblFechaHoy.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblFechaHoy.setForeground(new java.awt.Color(0, 102, 204));
        jlblFechaHoy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFechaHoy.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jlblFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 100, 25));

        jLabel14.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel14.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 900, 10));

        jLabel25.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel25.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 10));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Precio Unitario de Compra");
        jLabel26.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 190, 25));

        jlblFormaFarmaceutica.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblFormaFarmaceutica.setForeground(new java.awt.Color(0, 102, 204));
        jlblFormaFarmaceutica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFormaFarmaceutica.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jlblFormaFarmaceutica, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 140, -1));

        jlblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        jlblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensaje.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jlblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 440, 20));

        jtfLaboratorio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfLaboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfLaboratorioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfLaboratorioKeyTyped(evt);
            }
        });
        jPanel7.add(jtfLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 130, 25));

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 100));

        jtblLoteDetalle.setBorder(new javax.swing.border.MatteBorder(null));
        jtblLoteDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Producto Farmaceutico", "Cantidad", "Monto"
            }
        ));
        jtblLoteDetalle.setFocusable(false);
        jtblLoteDetalle.setGridColor(new java.awt.Color(0, 0, 0));
        jtblLoteDetalle.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblLoteDetalle.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(jtblLoteDetalle);

        jPanel10.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jLabel29.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel10.add(jLabel29, java.awt.BorderLayout.LINE_START);

        jLabel30.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel10.add(jLabel30, java.awt.BorderLayout.LINE_END);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setPreferredSize(new java.awt.Dimension(250, 15));
        jPanel11.add(jLabel1);

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Lista de Lotes Registrados");
        jLabel31.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel11.add(jLabel31);

        jbtnGuardarLotes.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarLotes.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarLotes.setText("GUARDAR LOTES");
        jbtnGuardarLotes.setFocusable(false);
        jbtnGuardarLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarLotesActionPerformed(evt);
            }
        });
        jPanel11.add(jbtnGuardarLotes);

        jLabel2.setPreferredSize(new java.awt.Dimension(60, 15));
        jPanel11.add(jLabel2);

        jbtnGuardarLotes1.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardarLotes1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardarLotes1.setText("Limpiar");
        jbtnGuardarLotes1.setFocusable(false);
        jbtnGuardarLotes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarLotes1ActionPerformed(evt);
            }
        });
        jPanel11.add(jbtnGuardarLotes1);

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 900, 170));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Laboratorio:");
        jLabel15.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, 25));

        jlblPVR.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblPVR.setForeground(new java.awt.Color(0, 102, 204));
        jlblPVR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPVR.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jlblPVR, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 50, 25));

        jLabel17.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel17.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 900, 10));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("/");
        jLabel22.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 10, 25));

        jtfCodigoLote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigoLote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoLoteKeyReleased(evt);
            }
        });
        jPanel7.add(jtfCodigoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 140, 25));

        jLabel32.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel32.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 900, 10));

        jtfCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });
        jPanel7.add(jtfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 60, 25));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Cantidad:");
        jLabel24.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 70, 25));

        jtfA�ovencimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfA�ovencimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfA�ovencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfA�ovencimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfA�ovencimientoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfA�ovencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 40, 25));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("20");
        jLabel27.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 20, 25));

        jLabel28.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("/");
        jLabel28.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 10, 25));

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
        jPanel7.add(jtfMesVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 40, 25));

        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Fecha Vencimiento:");
        jLabel33.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 140, 25));

        jlblAstePF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAstePF.setForeground(new java.awt.Color(255, 0, 0));
        jlblAstePF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAstePF.setText("*");
        jPanel7.add(jlblAstePF, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 10, 25));

        jlblAsteCodigoLote.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteCodigoLote.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteCodigoLote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteCodigoLote.setText("*");
        jPanel7.add(jlblAsteCodigoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 10, 25));

        jlblAsteCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteCantidad.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteCantidad.setText("*");
        jPanel7.add(jlblAsteCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 10, 25));

        jlblAstePUC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAstePUC.setForeground(new java.awt.Color(255, 0, 0));
        jlblAstePUC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAstePUC.setText("*");
        jPanel7.add(jlblAstePUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 10, 25));

        jlblAsteFechaVenc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteFechaVenc.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteFechaVenc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteFechaVenc.setText("*");
        jPanel7.add(jlblAsteFechaVenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 10, 25));

        jLabel34.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel34.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 900, 10));

        jbtnAgregarLotes.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregarLotes.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarLotes.setText("AGREGAR A LA LISTA DE LOTES");
        jbtnAgregarLotes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbtnAgregarLotesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jbtnAgregarLotesFocusLost(evt);
            }
        });
        jbtnAgregarLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarLotesActionPerformed(evt);
            }
        });
        jbtnAgregarLotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnAgregarLotesKeyPressed(evt);
            }
        });
        jPanel7.add(jbtnAgregarLotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, 25));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("C�digo Factura:");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jtfCodigoFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigoFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoFactura.setPreferredSize(new java.awt.Dimension(120, 21));
        jtfCodigoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoFacturaKeyReleased(evt);
            }
        });
        jPanel7.add(jtfCodigoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 130, 25));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Proveedor");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        jtfProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfProveedor.setMinimumSize(new java.awt.Dimension(100, 21));
        jtfProveedor.setPreferredSize(new java.awt.Dimension(150, 21));
        jtfProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfProveedorKeyTyped(evt);
            }
        });
        jPanel7.add(jtfProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 160, 25));

        jlblAsteFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteFactura.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteFactura.setText("*");
        jPanel7.add(jlblAsteFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 10, 25));

        jlblAsteProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteProveedor.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteProveedor.setText("*");
        jPanel7.add(jlblAsteProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 10, 25));

        jlblAsteFabricante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAsteFabricante.setForeground(new java.awt.Color(255, 0, 0));
        jlblAsteFabricante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAsteFabricante.setText("*");
        jPanel7.add(jlblAsteFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, 25));

        jLabel35.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Forma Farmaceutica");
        jLabel35.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 140, 25));

        jlblFormaOrigen.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblFormaOrigen.setForeground(new java.awt.Color(0, 102, 204));
        jlblFormaOrigen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFormaOrigen.setPreferredSize(new java.awt.Dimension(330, 25));
        jPanel7.add(jlblFormaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 160, -1));

        jPanel13.add(jPanel7, java.awt.BorderLayout.CENTER);

        vistaLlenar.add(jPanel13, java.awt.BorderLayout.CENTER);

        bodyCard.add(vistaLlenar, "card3");

        add(bodyCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    public void encontrarMedicamento(String objeto){        
         for (int i = 0; i < Lista_Inventario.size(); i++){
            if(jtfProductoFarmaceutico.getText().equals(Lista_Inventario.get(i).getMedicamento().getNombre())|| objeto.equals(Lista_Inventario.get(i).getMedicamento().getNombre())){                
                jlblFormaFarmaceutica.setText(Lista_Inventario.get(i).getMedicamento().getForma_farmaceutica());
                jlblConcentracion.setText(Lista_Inventario.get(i).getMedicamento().getConcentracion());
                objInventario_final=Lista_Inventario.get(i);
                jlblFormaOrigen.setText(Lista_Inventario.get(i).getMedicamento().getRolorigen().getNombre_rol());
                MensajeProductoFarmaceutico="";                               
            break;
            }
            MensajeProductoFarmaceutico="Ingrese un Medicamento Existente";
            jlblFormaFarmaceutica.setText("");
            jlblConcentracion.setText("");  
            jlblFormaOrigen.setText("");
        }        
    }      
    private void jtfProductoFarmaceuticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfProductoFarmaceuticoKeyReleased
        encontrarMedicamento("");  
        for (Inventario inventarito : Lista_Inventario){
            if(inventarito.getMedicamento().getNombre().equals(jtfProductoFarmaceutico.getText())){
                jlblAstePF.setText("");
                break;
            }
            jlblAstePF.setText("*");            
        }
    }//GEN-LAST:event_jtfProductoFarmaceuticoKeyReleased

    private void jtfPrecioUnitarioCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioUnitarioCompraKeyReleased
        jlblPVR.setText(Herramienta.redondeo(Float.parseFloat(jtfPrecioUnitarioCompra.getText()))+"");
        if(jtfPrecioUnitarioCompra.getText().isEmpty()){
            jlblAstePUC.setText("*");
        }
        else{
            jlblAstePUC.setText("");
        }
    }//GEN-LAST:event_jtfPrecioUnitarioCompraKeyReleased

    private void jbtnAgregarLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarLotesActionPerformed
              
        guardarLote();
        
    }//GEN-LAST:event_jbtnAgregarLotesActionPerformed

    public void guardarLote(){
        if(jlblAsteCantidad.getText().isEmpty()&&jlblAsteCodigoLote.getText().isEmpty()
                &&jlblAsteFabricante.getText().isEmpty()&&jlblAsteFechaVenc.getText().isEmpty()
                &&jlblAstePF.getText().isEmpty()&&jlblAstePUC.getText().isEmpty()&&jlblAsteFactura.getText().isEmpty()
                &&jlblAsteProveedor.getText().isEmpty()){
            Detalle_llenado objDetalle_llenado=new Detalle_llenado();
         Lote_detalle objLote_Detalle=new Lote_detalle();
         Date objFechaVencimiento=new Date();
         objFechaVencimiento.setYear(Integer.parseInt(jtfA�ovencimiento.getText())+100);
         objFechaVencimiento.setMonth(Integer.parseInt(jtfMesVen.getText())-1);
         objFechaVencimiento.setDate(Integer.parseInt(jtfDiaVenc.getText()));
         objFechaVencimiento.setHours(0);
         objFechaVencimiento.setMinutes(0);
         objFechaVencimiento.setSeconds(0);
         //Lote_detalle
         //cantidad,codigo,fecha_Vencimiento,id_inventario,id_fabricante,id_factura,PVR----id_factura
         objLote_Detalle.setCantidad(Integer.parseInt(jtfCantidad.getText()));
         objLote_Detalle.setCodigo(jtfCodigoLote.getText());
         objLote_Detalle.setFecha_vencimiento(objFechaVencimiento);
         objLote_Detalle.setInventario(objInventario_final);
         MensajeFabricante="Ingrese un laboratorio Existente";
         for (int i = 0; i < Lista_Fabricante.size(); i++){
             if(Lista_Fabricante.get(i).getNombre_rol().equals(jtfLaboratorio.getText())){
                 objLote_Detalle.setRolFabricante(Lista_Fabricante.get(i));
                 MensajeFabricante="";
             break;
             }             
        }      
        objLote_Detalle.setPrecio_Venta_Redondeado(Float.parseFloat(jlblPVR.getText()));
        //fin Lote_detalle         
        //Detalle_Llenado
        //P.u,id_medicamento,user,fecha_registro----id_lote_detalle
        objDetalle_llenado.setPrecio_unitario(Float.parseFloat(jtfPrecioUnitarioCompra.getText()));
        objDetalle_llenado.setMedicamento(objInventario_final.getMedicamento());
        objDetalle_llenado.setUsuario(objPrincipal.getUsuario());
        objDetalle_llenado.setFecha_de_registro(new Date());
        objDetalle_llenado.setCantidad(Integer.parseInt(jtfCantidad.getText()));
        //objDetalle_llenado.setLote_detalle(objLote_Detalle);     
        //objInventario_final.setCantidad(objInventario_final.getCantidad()+Integer.parseInt(jtfCantidad.getText()));
        Factura objFactura=new Factura();
         //factura
         Rol objProveedor = new Rol();
         //codigo_factura
         objFactura.setCodigo_factura(jtfCodigoFactura.getText());
         for (int i = 0; i < Lista_Proveedor.size(); i++){
             if(Lista_Proveedor.get(i).getNombre_rol().equals(jtfProveedor.getText())){
                 objProveedor=Lista_Proveedor.get(i);
             }
        }
        //maybe
        objFactura.setRolProveedor(objProveedor);
        objLote_Detalle.setFactura(objFactura);
        Lista_Detalle_Llenado_final.add(objDetalle_llenado);
        Lista_Lote_detalle_final.add(objLote_Detalle);        
        llenar_tabla_LoteDetalle(Lista_Lote_detalle_final, Lista_Detalle_Llenado_final);
        limpiar();        
        jtfProductoFarmaceutico.requestFocus();
        }
        else{
            JOptionPane.showMessageDialog(jtfCantidad, "llene los espacios con *");
        }
    }
    public void limpiar(){
        jlblMensaje.setText("");
        jtfProductoFarmaceutico.setText("");
        jlblFormaFarmaceutica.setText("");
        jlblConcentracion.setText("");
        jtfCodigoLote.setText("");
        jtfDiaVenc.setText("");
        jtfMesVen.setText("");
        jtfA�ovencimiento.setText("");
        jtfCantidad.setText("");
        jtfPrecioUnitarioCompra.setText("");
        jlblPVR.setText("");
        
        jtfCodigoFactura.setText("");
        jtfProveedor.setText("");
        jtfLaboratorio.setText("");
        jlblAsteFactura.setText("*");
        jlblAsteProveedor.setText("*");
        jlblAsteCantidad.setText("*");
        jlblAsteCodigoLote.setText("*");
        jlblAsteFabricante.setText("*");
        jlblAsteFechaVenc.setText("*");
        jlblAstePF.setText("*");
        jlblAstePUC.setText("*");
    }
    public void llenar_tabla_LoteDetalle(List<Lote_detalle> listaLote,List<Detalle_llenado> listaLlenado){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cantidad","P.U","P.V.R","Fecha Venc.","Laboratorio","Proveedor","Factura"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false,false, false,false,false,false,false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             if(listaLote.size()==listaLlenado.size()){//objListaLlenado tostring=precio_unitario
             for (int i = 0; i < listaLote.size(); i++){
                 fila_actividad[0]=listaLote.get(i).getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=listaLote.get(i);
                 fila_actividad[2]=listaLote.get(i).getCantidad();             
                 fila_actividad[3]=listaLlenado.get(i);
                 fila_actividad[4]=listaLote.get(i).getPrecio_Venta_Redondeado();
                 fila_actividad[5]=Herramienta.formatoFecha(listaLote.get(i).getFecha_vencimiento());
                 fila_actividad[6]=listaLote.get(i).getRolFabricante().getNombre_rol();
                 fila_actividad[7]=listaLote.get(i).getFactura().getRolProveedor().getNombre_rol();
                 fila_actividad[7]=listaLote.get(i).getFactura().getRolProveedor().getNombre_rol();
                 fila_actividad[8]=listaLote.get(i).getFactura().getCodigo_factura();             
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
             }else{
                 System.out.println("error line 549 Lote:"+listaLote.size()+" Llenado"+listaLlenado.size());
             }
             
            jtblLoteDetalle.setModel(modelo); 
            jtblLoteDetalle.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblLoteDetalle.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(4).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(5).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(6).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(7).setCellRenderer(tcr);
            jtblLoteDetalle.getColumnModel().getColumn(8).setCellRenderer(tcr);
            jtblLoteDetalle.setFont(new java.awt.Font("Tahoma", 0, 12));
            jtblLoteDetalle.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15));
            jtblLoteDetalle.getTableHeader().setBackground(Color.BLUE);
            jtblLoteDetalle.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblLoteDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtblLoteDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtblLoteDetalle.getColumnModel().getColumn(2).setPreferredWidth(90);    
            jtblLoteDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtblLoteDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtblLoteDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtblLoteDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
            jtblLoteDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtblLoteDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
            ((DefaultTableCellRenderer)jtblLoteDetalle.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    
    private void jbtnGuardarLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarLotesActionPerformed
                 
        if(!Lista_Detalle_Llenado_final.isEmpty()&& !Lista_Lote_detalle_final.isEmpty()){
            jpa.getTransaction().begin();
            for (int i = 0; i < Lista_Lote_detalle_final.size(); i++){           
            jpa.persist(Lista_Lote_detalle_final.get(i));            
            jpa.refresh(Lista_Lote_detalle_final.get(i));
            Lista_Detalle_Llenado_final.get(i).setLote_detalle(Lista_Lote_detalle_final.get(i));
            Lista_Lote_detalle_final.get(i).getInventario().agregarCantidad(Lista_Detalle_Llenado_final.get(i).getCantidad());
            jpa.persist(Lista_Detalle_Llenado_final.get(i));
            jpa.flush();//sincronizando en la BD con el programa            
            }      
        Lista_Lote_detalle_final.clear();Lista_Detalle_Llenado_final.clear();
        llenar_tabla_LoteDetalle(Lista_Lote_detalle_final, Lista_Detalle_Llenado_final);
        JOptionPane.showMessageDialog(jtfMesVen, "Guardado con �xito");
        jpa.getTransaction().commit();
        }
        else{
            JOptionPane.showMessageDialog(jtfMesVen, "lotes vac�os, agregue!");
        }

            
        
        //nunca poner un 2persist antes de 1 refresh
    }//GEN-LAST:event_jbtnGuardarLotesActionPerformed

    private void jtfPrecioUnitarioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioUnitarioCompraKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            if(validar!='.'){
                getToolkit().beep();
                evt.consume();  
                }
            }     
        
        if (jtfPrecioUnitarioCompra.getText().length()>=6){ 
         evt.consume(); 
         }
    }//GEN-LAST:event_jtfPrecioUnitarioCompraKeyTyped

    private void jtfDiaVencKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaVencKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();  
            }    
        else{     
            String mes=jtfMesVen.getText();
            if(mes.equals("02")){
                if(Integer.parseInt(jtfA�ovencimiento.getText())%4!=0){                    
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

    private void jtfLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLaboratorioKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jtfLaboratorioKeyTyped

    private void jtfProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfProveedorKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isLetter(validar)){
            evt.consume();
        }
        
    }//GEN-LAST:event_jtfProveedorKeyTyped

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            if(validar!='.'){
                evt.consume();  
                }
            }     
        
        if (jtfCantidad.getText().length()>=6){ 
         evt.consume(); 
         }
        if(' '==evt.getKeyChar()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void jtfA�ovencimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfA�ovencimientoKeyTyped
        char validar=evt.getKeyChar();
        if(!Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();  
            }      
        
        if (jtfA�ovencimiento.getText().length()>=2){ 
         evt.consume(); 
         }
    }//GEN-LAST:event_jtfA�ovencimientoKeyTyped

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

    private void jtfMesVenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMesVenKeyPressed

    private void jbtnAgregarLotesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnAgregarLotesFocusGained
         jbtnAgregarLotes.setBackground(new java.awt.Color(50, 50, 50));
    }//GEN-LAST:event_jbtnAgregarLotesFocusGained

    private void jbtnAgregarLotesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnAgregarLotesFocusLost
         jbtnAgregarLotes.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jbtnAgregarLotesFocusLost

    private void jtfCodigoLoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoLoteKeyReleased
        if(jtfCodigoLote.getText().isEmpty()){
            jlblAsteCodigoLote.setText("*");
        }
        else{
            jlblAsteCodigoLote.setText("");
            }
    }//GEN-LAST:event_jtfCodigoLoteKeyReleased

    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        if(jtfCantidad.getText().isEmpty()){
            jlblAsteCantidad.setText("*");
        }
        else{
            jlblAsteCantidad.setText("");
            }
    }//GEN-LAST:event_jtfCantidadKeyReleased

    private void jtfLaboratorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLaboratorioKeyReleased
        for (Rol RolEscuela : Lista_Fabricante){
            if(RolEscuela.getNombre_rol().equals(jtfLaboratorio.getText())){
                jlblAsteFabricante.setText("");
                break;
            }
            jlblAsteFabricante.setText("*");            
        }
    }//GEN-LAST:event_jtfLaboratorioKeyReleased

    private void jtfA�ovencimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfA�ovencimientoKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfA�ovencimiento.getText().isEmpty()){
            jlblAsteFechaVenc.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfA�ovencimiento.getText().equals("0")){
                jlblAsteFechaVenc.setText("*");
            }
            else{
                jlblAsteFechaVenc.setText("");
            }
        }
    }//GEN-LAST:event_jtfA�ovencimientoKeyReleased

    private void jtfMesVenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesVenKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfA�ovencimiento.getText().isEmpty()){
            jlblAsteFechaVenc.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfA�ovencimiento.getText().equals("0")){
                jlblAsteFechaVenc.setText("*");
            }
            else{
                jlblAsteFechaVenc.setText("");
            }
        }
    }//GEN-LAST:event_jtfMesVenKeyReleased

    private void jtfDiaVencKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaVencKeyReleased
        if(jtfDiaVenc.getText().isEmpty()||jtfMesVen.getText().isEmpty()||jtfA�ovencimiento.getText().isEmpty()){
            jlblAsteFechaVenc.setText("*");
        }
        else{
            if(jtfDiaVenc.getText().equals("0") || jtfMesVen.getText().equals("0") || jtfA�ovencimiento.getText().equals("0")){
                jlblAsteFechaVenc.setText("*");
            }
            else{
                jlblAsteFechaVenc.setText("");
            }
        }
    }//GEN-LAST:event_jtfDiaVencKeyReleased

    private void jbtnAgregarLotesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnAgregarLotesKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            guardarLote();
        }
    }//GEN-LAST:event_jbtnAgregarLotesKeyPressed

    private void jtfProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfProveedorKeyReleased
        for (Rol RolEscuela : Lista_Proveedor){
            if(RolEscuela.getNombre_rol().equals(jtfProveedor.getText())){
                jlblAsteProveedor.setText("");
                break;
            }
            jlblAsteProveedor.setText("*");            
        }
    }//GEN-LAST:event_jtfProveedorKeyReleased

    private void jtfCodigoFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoFacturaKeyReleased
        if(jtfCodigoLote.getText().isEmpty()){
            jlblAsteFactura.setText("*");
        }
        else{
            jlblAsteFactura.setText("");
            }
    }//GEN-LAST:event_jtfCodigoFacturaKeyReleased

    private void jbtnGuardarLotes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarLotes1ActionPerformed
       //Lista_Lote_detalle_final.clear();Lista_Detalle_Llenado_final.clear();
       //llenar_tabla_LoteDetalle(Lista_Lote_detalle_final, Lista_Detalle_Llenado_final);
       
       if(!Lista_Lote_detalle_final.isEmpty()){          
           try{
           Lote_detalle objLote_detalle=(Lote_detalle)jtblLoteDetalle.getValueAt(jtblLoteDetalle.getSelectedRow(),1);
           Detalle_llenado objDetalle_llenado=(Detalle_llenado)jtblLoteDetalle.getValueAt(jtblLoteDetalle.getSelectedRow(),3);
           Lista_Lote_detalle_final.remove(objLote_detalle);
           Lista_Detalle_Llenado_final.remove(objDetalle_llenado);
           llenar_tabla_LoteDetalle(Lista_Lote_detalle_final, Lista_Detalle_Llenado_final);}
           catch(ArrayIndexOutOfBoundsException e){
               JOptionPane.showMessageDialog(jtfMesVen, "Seleccione un item");
               }}
       else{
           JOptionPane.showMessageDialog(jtfMesVen, "No hay un item que limpiar");
       }

        
    }//GEN-LAST:event_jbtnGuardarLotes1ActionPerformed
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyCard;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnAgregarLotes;
    private javax.swing.JButton jbtnGuardarLotes;
    private javax.swing.JButton jbtnGuardarLotes1;
    private javax.swing.JLabel jlblAsteCantidad;
    private javax.swing.JLabel jlblAsteCodigoLote;
    private javax.swing.JLabel jlblAsteFabricante;
    private javax.swing.JLabel jlblAsteFactura;
    private javax.swing.JLabel jlblAsteFechaVenc;
    private javax.swing.JLabel jlblAstePF;
    private javax.swing.JLabel jlblAstePUC;
    private javax.swing.JLabel jlblAsteProveedor;
    private javax.swing.JLabel jlblConcentracion;
    private javax.swing.JLabel jlblFechaHoy;
    private javax.swing.JLabel jlblFormaFarmaceutica;
    private javax.swing.JLabel jlblFormaOrigen;
    private javax.swing.JLabel jlblHeadMensaje;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JLabel jlblPVR;
    private javax.swing.JTable jtblLoteDetalle;
    private javax.swing.JTextField jtfA�ovencimiento;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfCodigoFactura;
    private javax.swing.JTextField jtfCodigoLote;
    private javax.swing.JTextField jtfDiaVenc;
    private javax.swing.JTextField jtfLaboratorio;
    private javax.swing.JTextField jtfMesVen;
    private javax.swing.JTextField jtfPrecioUnitarioCompra;
    private javax.swing.JTextField jtfProductoFarmaceutico;
    private javax.swing.JTextField jtfProveedor;
    private javax.swing.JPanel vistaLlenar;
    // End of variables declaration//GEN-END:variables

    
    
    

}
