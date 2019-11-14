package com.ecoedu.Vistas.ServicioFarmacia;

import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Detalle_servicio_social;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Receta;
import com.ecoedu.model.Usuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ServicioFarmacia extends javax.swing.JPanel {
    private Principal objPrincipal;
    private Receta objReceta;
    private Usuario objUsuario;
    private EntityManager jpa;   
    private List<Detalle_servicio_social> Lista_detalle_servicio_social=new ArrayList<>();   
    private List<Detalle_Medicamentos> Lista_carrito_medicamentos=new ArrayList<>();//
    //datos q se desglozan de la BD               
    private List<Control_paciente> Lista_control_paciente=new ArrayList<>();//
    private List<Estudiante> Lista_Estudiantes=new ArrayList<>();//
    private List<Detalle_Medicamentos> Lista_detalle_medicamento=new ArrayList<>();//
    private List<Receta> Lista_Recetas=new ArrayList<>();//
  

    public void llenar_Detalle_de_Recetas(List<Detalle_Medicamentos> listaDetallesMedicamentos){
        //updateSaldoDisponible();
        System.out.println("ejecutandod");
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
                String [] lista={"Cantidad","Nombre","Precio Unitario","Precio Total","Fecha","Lote","Química(o)"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };           
             //.....................................TABLA...........Fin......................            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i <listaDetallesMedicamentos.size(); i++){
                 fila_actividad[0]=listaDetallesMedicamentos.get(i).getCantidad();
                 fila_actividad[1]=listaDetallesMedicamentos.get(i).getId_Medicamento().getNombre();              
                 fila_actividad[2]= listaDetallesMedicamentos.get(i).getPrecio_Unitario();
                 fila_actividad[3]=listaDetallesMedicamentos.get(i).getPrecio_Total();    
                 fila_actividad[4]=listaDetallesMedicamentos.get(i).getFecha(); 
                 fila_actividad[5]=listaDetallesMedicamentos.get(i).getLote_detalle().getCodigo();  
                 fila_actividad[6]=listaDetallesMedicamentos.get(i).getUsuario().getPersona().getInfoPersona();
                 modelo.addRow(fila_actividad);//agregando filas                 
             }
            jtblMedicinasEntregada.setModel(modelo);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblMedicinasEntregada.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblMedicinasEntregada.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblMedicinasEntregada.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblMedicinasEntregada.getColumnModel().getColumn(3).setCellRenderer(tcr);  
            jtblMedicinasEntregada.getColumnModel().getColumn(4).setCellRenderer(tcr);  
            jtblMedicinasEntregada.getColumnModel().getColumn(5).setCellRenderer(tcr); 
            jtblMedicinasEntregada.getColumnModel().getColumn(6).setCellRenderer(tcr); 
         
            jtblMedicinasEntregada.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblMedicinasEntregada.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblMedicinasEntregada.getTableHeader().setBackground(Color.BLUE);
            jtblMedicinasEntregada.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblMedicinasEntregada.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtblMedicinasEntregada.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtblMedicinasEntregada.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtblMedicinasEntregada.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtblMedicinasEntregada.getColumnModel().getColumn(4).setPreferredWidth(180);
            jtblMedicinasEntregada.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtblMedicinasEntregada.getColumnModel().getColumn(6).setPreferredWidth(200);                     
            //880
            ((DefaultTableCellRenderer)jtblMedicinasEntregada.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            
    }    
    public ServicioFarmacia(EntityManager jpa2,Principal OBJPrincipal,Usuario OBJUsuario){
        initComponents();
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;
        this.objUsuario=OBJUsuario;
        ConsultaBD();  
        principalEjecucion();              
    }
     public void ConsultaBD(){
         Query query1=jpa.createQuery("SELECT p FROM Detalle_Medicamentos p");
         Lista_detalle_medicamento=query1.getResultList();          
         
         //depender el código
         Query query3=jpa.createQuery("SELECT p FROM Detalle_servicio_social p");
         Lista_detalle_servicio_social=query3.getResultList();  
     }
     public void desglozarDatos(){
         //lista_Estudiantes
         //lista_control_paciente
         //lista_recetas
         for (int i = 1; i < Lista_detalle_medicamento.size(); i++){
            boolean auxEstudiante=true;
            boolean auxControl_paciente=true;
            boolean auxReceta=true;
            for (int j = 0; j < Lista_Estudiantes.size(); j++){
                if(Lista_Estudiantes.get(j)==Lista_detalle_medicamento.get(i).getReceta().getControl_Paciente().getEstudiante()){
                    auxEstudiante=false;		
                    break;
                    }
                }
            for (int j = 0; j < Lista_control_paciente.size(); j++){
                if(Lista_control_paciente.get(j)==Lista_detalle_medicamento.get(i).getReceta().getControl_Paciente()){
                    auxControl_paciente=false;	
                    break;
                    }
                }
            for (int j = 0; j < Lista_Recetas.size(); j++){
                if(Lista_Recetas.get(j)==Lista_detalle_medicamento.get(i).getReceta()){
                    auxReceta=false;	
                    break;
                    }
                }
            if(auxEstudiante){
                Lista_Estudiantes.add(Lista_detalle_medicamento.get(i).getReceta().getControl_Paciente().getEstudiante());
                }
            if(auxControl_paciente){
                Lista_control_paciente.add(Lista_detalle_medicamento.get(i).getReceta().getControl_Paciente());
                }
            if(auxReceta){
                Lista_Recetas.add(Lista_detalle_medicamento.get(i).getReceta());
                }
            }      
}
    
     public void principalEjecucion(){
         llenar_Tabla_de_Recetas(Lista_Recetas);
         llenar_Tabla_de_carrito_medicina(Lista_carrito_medicamentos);
         jtaDiagnostico.setEditable(false);
         desglozarDatos();
     }  
     public void getListaCarritos(Detalle_Medicamentos objDetalleMedicamento){
         Lista_carrito_medicamentos.add(objDetalleMedicamento);
         llenar_Tabla_de_carrito_medicina(Lista_carrito_medicamentos);
     }
 
    public void llenar_Tabla_de_carrito_medicina(List<Detalle_Medicamentos> lista_carrito_medi){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
                String [] lista={"Medicamento","Cantidad","Precio Unitario","Precio Total","Lote"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false, false, false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];}
                 };                        
             //.....................................TABLA...........Fin......................            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i < lista_carrito_medi.size(); i++){
                 fila_actividad[0]=lista_carrito_medi.get(i).getId_Medicamento().getNombre();
                 fila_actividad[1]=lista_carrito_medi.get(i).getCantidad();             
                 fila_actividad[2]=lista_carrito_medi.get(i).getPrecio_Unitario()+"0";  
                 fila_actividad[3]=lista_carrito_medi.get(i).getPrecio_Total()+"0";  
                 fila_actividad[4]=lista_carrito_medi.get(i).getLote_detalle().getCodigo();       
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtbCarritoLista.setModel(modelo); 
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtbCarritoLista.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtbCarritoLista.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtbCarritoLista.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtbCarritoLista.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtbCarritoLista.getColumnModel().getColumn(4).setCellRenderer(tcr);
       
            jtbCarritoLista.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtbCarritoLista.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtbCarritoLista.getTableHeader().setBackground(Color.BLUE);
            jtbCarritoLista.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtbCarritoLista.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtbCarritoLista.getColumnModel().getColumn(1).setPreferredWidth(175);
            jtbCarritoLista.getColumnModel().getColumn(2).setPreferredWidth(175);
            jtbCarritoLista.getColumnModel().getColumn(3).setPreferredWidth(175);  
            jtbCarritoLista.getColumnModel().getColumn(4).setPreferredWidth(175); 
            ((DefaultTableCellRenderer)jtbCarritoLista.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            
    } 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlblNombres = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblEscuela = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblSerie = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfLookCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jlblMontoTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtEntregarMedicamentos = new javax.swing.JButton();
        cuerp2CrearRecetas = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtxtDiagnosticoNuevo = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        cabeza = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jbtnADDmedicamentos = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbCarritoLista = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jlblSaldoDisponible1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jbtnCancelarCrearDiagnostico = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        cuerpo4VerDetallesDeLaReceta = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtaDiagnostico = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblMedicinasEntregada = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jbtnVolver2 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jbtnFinalizar2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setMaximumSize(new java.awt.Dimension(990, 650));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(240, 200, 20));
        head.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(" SERVICIO DE FARMACIA");
        jLabel12.setPreferredSize(new java.awt.Dimension(351, 70));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        head2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(890, 100));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setEnabled(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(880, 40));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APELLIDOS Y NOMBRES :");
        jLabel3.setPreferredSize(new java.awt.Dimension(225, 30));
        jPanel5.add(jLabel3);

        jlblNombres.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblNombres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblNombres.setPreferredSize(new java.awt.Dimension(640, 30));
        jPanel5.add(jlblNombres);

        jPanel7.add(jPanel5);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel7.setText("ESCUELA :");
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel7.add(jLabel7);

        jlblEscuela.setBackground(new java.awt.Color(0, 0, 0));
        jlblEscuela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblEscuela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEscuela.setToolTipText("");
        jlblEscuela.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel7.add(jlblEscuela);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel5.setText("Serie :");
        jLabel5.setPreferredSize(new java.awt.Dimension(58, 30));
        jPanel7.add(jLabel5);

        jlblSerie.setBackground(new java.awt.Color(0, 0, 0));
        jlblSerie.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSerie.setPreferredSize(new java.awt.Dimension(39, 30));
        jPanel7.add(jlblSerie);

        jLabel15.setPreferredSize(new java.awt.Dimension(155, 30));
        jPanel7.add(jLabel15);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel8.setText("Código:");
        jLabel8.setPreferredSize(new java.awt.Dimension(68, 30));
        jPanel7.add(jLabel8);

        jtfLookCodigo.setBackground(new java.awt.Color(240, 200, 20));
        jtfLookCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtfLookCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLookCodigo.setText("27150506");
        jtfLookCodigo.setPreferredSize(new java.awt.Dimension(85, 30));
        jtfLookCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyPressed(evt);
            }
        });
        jPanel7.add(jtfLookCodigo);

        jLabel6.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel7.add(jLabel6);

        head2.add(jPanel7);

        body.add(head2, java.awt.BorderLayout.PAGE_START);

        body2.setBackground(new java.awt.Color(255, 255, 255));
        body2.setMaximumSize(new java.awt.Dimension(1990, 650));
        body2.setMinimumSize(new java.awt.Dimension(200, 200));
        body2.setPreferredSize(new java.awt.Dimension(9900, 520));
        body2.setLayout(new java.awt.CardLayout());

        cuerpo1ListaRecetas.setBackground(new java.awt.Color(255, 255, 255));
        cuerpo1ListaRecetas.setPreferredSize(new java.awt.Dimension(900, 350));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 290));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jtblRecetas.setBorder(new javax.swing.border.MatteBorder(null));
        jtblRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Fecha", "Total Costo", "Procedencia", "Diagnostico"
            }
        ));
        jtblRecetas.setGridColor(new java.awt.Color(0, 0, 0));
        jtblRecetas.setMinimumSize(new java.awt.Dimension(500, 100));
        jtblRecetas.setPreferredSize(new java.awt.Dimension(200, 260));
        jtblRecetas.setRequestFocusEnabled(false);
        jtblRecetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRecetasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRecetas);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("LISTA DE RECETAS DEL ESTUDIANTE");
        jLabel11.setPreferredSize(new java.awt.Dimension(178, 30));
        jPanel9.add(jLabel11, java.awt.BorderLayout.PAGE_START);

        jLabel14.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel14, java.awt.BorderLayout.LINE_END);

        jLabel18.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel9.add(jLabel18, java.awt.BorderLayout.LINE_START);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Click en la tabla para ver Detalles de la Receta");
        jPanel9.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        cuerpo1ListaRecetas.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Monto Total :");
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 26));
        jPanel10.add(jLabel13);

        jlblMontoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblMontoTotal.setPreferredSize(new java.awt.Dimension(280, 29));
        jPanel10.add(jlblMontoTotal);

        jLabel4.setMaximumSize(new java.awt.Dimension(500, 0));
        jLabel4.setMinimumSize(new java.awt.Dimension(100, 0));
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel10.add(jLabel4);

        jbtEntregarMedicamentos.setBackground(new java.awt.Color(0, 0, 0));
        jbtEntregarMedicamentos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtEntregarMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        jbtEntregarMedicamentos.setText("CREAR RECETA");
        jbtEntregarMedicamentos.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtEntregarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEntregarMedicamentosActionPerformed(evt);
            }
        });
        jPanel10.add(jbtEntregarMedicamentos);

        cuerpo1ListaRecetas.add(jPanel10);

        body2.add(cuerpo1ListaRecetas, "card2");

        cuerp2CrearRecetas.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMinimumSize(new java.awt.Dimension(860, 20));
        jPanel14.setPreferredSize(new java.awt.Dimension(900, 130));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMinimumSize(new java.awt.Dimension(860, 10));
        jPanel16.setPreferredSize(new java.awt.Dimension(1000, 30));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel23.setText("DIAGNÓSTICO :");
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtxtDiagnosticoNuevo.setColumns(20);
        jtxtDiagnosticoNuevo.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jtxtDiagnosticoNuevo.setRows(5);
        jScrollPane4.setViewportView(jtxtDiagnosticoNuevo);

        jPanel16.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 700, 110));

        jPanel14.add(jPanel16, java.awt.BorderLayout.CENTER);

        cuerp2CrearRecetas.add(jPanel14);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(900, 160));
        jPanel17.setLayout(new java.awt.BorderLayout());

        cabeza.setBackground(new java.awt.Color(255, 255, 255));
        cabeza.setPreferredSize(new java.awt.Dimension(900, 35));

        jLabel26.setPreferredSize(new java.awt.Dimension(270, 14));
        cabeza.add(jLabel26);

        jLabel27.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("MEDICAMENTOS");
        cabeza.add(jLabel27);

        jLabel25.setPreferredSize(new java.awt.Dimension(180, 14));
        cabeza.add(jLabel25);

        jbtnADDmedicamentos.setText("AGREGAR MEDICAMENTOS");
        jbtnADDmedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnADDmedicamentosActionPerformed(evt);
            }
        });
        cabeza.add(jbtnADDmedicamentos);

        jPanel17.add(cabeza, java.awt.BorderLayout.PAGE_START);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel17.add(jLabel28, java.awt.BorderLayout.LINE_START);

        jLabel29.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel17.add(jLabel29, java.awt.BorderLayout.LINE_END);

        jScrollPane6.setPreferredSize(new java.awt.Dimension(452, 260));

        jtbCarritoLista.setBorder(new javax.swing.border.MatteBorder(null));
        jtbCarritoLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto Farmacèutico", "Cantidad Disponible", "Precio Unitario", "Codigo Lote"
            }
        ));
        jtbCarritoLista.setGridColor(new java.awt.Color(0, 0, 0));
        jtbCarritoLista.setPreferredSize(new java.awt.Dimension(300, 210));
        jScrollPane6.setViewportView(jtbCarritoLista);

        jPanel17.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        cuerp2CrearRecetas.add(jPanel17);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel30.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Saldo Disponible :");
        jLabel30.setPreferredSize(new java.awt.Dimension(170, 26));
        jPanel19.add(jLabel30);

        jlblSaldoDisponible1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblSaldoDisponible1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblSaldoDisponible1.setText("85.30");
        jPanel19.add(jlblSaldoDisponible1);

        jLabel31.setPreferredSize(new java.awt.Dimension(380, 30));
        jPanel19.add(jLabel31);

        jbtnCancelarCrearDiagnostico.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCancelarCrearDiagnostico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCancelarCrearDiagnostico.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCancelarCrearDiagnostico.setText("CANCELAR");
        jbtnCancelarCrearDiagnostico.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnCancelarCrearDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarCrearDiagnosticoActionPerformed(evt);
            }
        });
        jPanel19.add(jbtnCancelarCrearDiagnostico);

        jLabel32.setPreferredSize(new java.awt.Dimension(15, 30));
        jPanel19.add(jLabel32);

        jbtnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardar.setText("GUARDAR");
        jbtnGuardar.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel19.add(jbtnGuardar);

        cuerp2CrearRecetas.add(jPanel19);

        body2.add(cuerp2CrearRecetas, "card3");

        cuerpo4VerDetallesDeLaReceta.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(900, 140));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel20.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 10, -1, -1));

        jLabel36.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel20.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 10, -1, -1));

        jtaDiagnostico.setBackground(new java.awt.Color(255, 255, 0));
        jtaDiagnostico.setColumns(20);
        jtaDiagnostico.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jtaDiagnostico.setRows(5);
        jScrollPane7.setViewportView(jtaDiagnostico);

        jPanel20.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 700, 110));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel24.setText("DIAGNÓSTICO :");
        jPanel20.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cuerpo4VerDetallesDeLaReceta.add(jPanel20);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(900, 140));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel37.setText("Medicamentos");
        jPanel23.add(jLabel37);

        jPanel22.add(jPanel23, java.awt.BorderLayout.PAGE_START);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel22.add(jLabel38, java.awt.BorderLayout.LINE_START);

        jLabel39.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel22.add(jLabel39, java.awt.BorderLayout.LINE_END);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(452, 250));

        jtblMedicinasEntregada.setBorder(new javax.swing.border.MatteBorder(null));
        jtblMedicinasEntregada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto Farmacèutico", "Cantidad ", "Precio Unitario", "Químico Farmaceutico", "Lote"
            }
        ));
        jtblMedicinasEntregada.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(jtblMedicinasEntregada);

        jPanel22.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        cuerpo4VerDetallesDeLaReceta.add(jPanel22);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel41.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel24.add(jLabel41);

        jbtnVolver2.setBackground(new java.awt.Color(0, 0, 0));
        jbtnVolver2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolver2.setText("VOLVER");
        jbtnVolver2.setPreferredSize(new java.awt.Dimension(100, 25));
        jbtnVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolver2ActionPerformed(evt);
            }
        });
        jPanel24.add(jbtnVolver2);

        jLabel42.setPreferredSize(new java.awt.Dimension(15, 30));
        jPanel24.add(jLabel42);

        jbtnFinalizar2.setBackground(new java.awt.Color(0, 0, 0));
        jbtnFinalizar2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnFinalizar2.setForeground(new java.awt.Color(255, 255, 255));
        jbtnFinalizar2.setText("AGREGAR MEDICAMENTOS");
        jbtnFinalizar2.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel24.add(jbtnFinalizar2);

        cuerpo4VerDetallesDeLaReceta.add(jPanel24);

        body2.add(cuerpo4VerDetallesDeLaReceta, "card3");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
   
    
    public void llenarControlAlumno(){
        List<Receta> listaDetalles=new ArrayList<>();    
        for (int i = 0; i < Lista_control_paciente.size(); i++){
            if (Lista_control_paciente.get(i).getEstudiante().getCodigo().equals(jtfLookCodigo.getText())){
                jlblNombres.setText(Lista_control_paciente.get(i).getEstudiante().getPersona().getInfoPersona());
                jlblSerie.setText(Lista_control_paciente.get(i).getEstudiante().getSerie());
                jlblEscuela.setText(Lista_control_paciente.get(i).getEstudiante().getEscuela().getNombre());
                jlblMontoTotal.setText(Float.toString(Lista_control_paciente.get(i).getMonto_Total()));       
                for (int j = 0; j <Lista_Recetas.size(); j++){   
                    if (Lista_Recetas.get(j).getControl_Paciente()==Lista_control_paciente.get(i)){
                        listaDetalles.add(Lista_Recetas.get(j));                        
                    }                   
                }
            }
        }
       llenar_Tabla_de_Recetas(listaDetalles);
        
    }
    private void jbtEntregarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEntregarMedicamentosActionPerformed
        cuerpo1ListaRecetas.setVisible(false);
        cuerp2CrearRecetas.setVisible(true);
        //jtfLookCodigo.setEditable(false);
        //jlblSaldoDisponible.setText(Herramienta.dosDecimales(140-Total));

    }//GEN-LAST:event_jbtEntregarMedicamentosActionPerformed

    private void jtblRecetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRecetasMouseClicked
        int valor =Integer.parseInt(jtblRecetas.getValueAt(jtblRecetas.getSelectedRow(),0).toString());
        for (int i = 0; i < Lista_Recetas.size(); i++){
            if(Lista_Recetas.get(i).getId_Diagnostico()==valor){ 
                List<Detalle_Medicamentos> auxListaDetalleMedicamentos=new ArrayList<>();
                for (int j = 0; j < Lista_detalle_medicamento.size(); j++){
                    if(Lista_Recetas.get(i)==Lista_detalle_medicamento.get(j).getReceta()){
                        auxListaDetalleMedicamentos.add(Lista_detalle_medicamento.get(j));
                    }                    
                }
                llenar_Detalle_de_Recetas(auxListaDetalleMedicamentos);
                cuerpo1ListaRecetas.setVisible(false);
                cuerpo4VerDetallesDeLaReceta.setVisible(true);
                jtaDiagnostico.setText(Lista_Recetas.get(i).getDiagnostico());
                break;
            }        
        }
    }//GEN-LAST:event_jtblRecetasMouseClicked

    private void jbtnVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolver2ActionPerformed
        cuerpo4VerDetallesDeLaReceta.setVisible(false);
        cuerpo1ListaRecetas.setVisible(true);
    }//GEN-LAST:event_jbtnVolver2ActionPerformed

    private void jbtnADDmedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnADDmedicamentosActionPerformed
       CuadroCarritoMedicinas objCuadroCarritoMedicinas=new CuadroCarritoMedicinas(jpa,this);
       objCuadroCarritoMedicinas.setVisible(true);
       
    }//GEN-LAST:event_jbtnADDmedicamentosActionPerformed

    private void jbtnCancelarCrearDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarCrearDiagnosticoActionPerformed
        cuerp2CrearRecetas.setVisible(false);
        cuerpo1ListaRecetas.setVisible(true);
    }//GEN-LAST:event_jbtnCancelarCrearDiagnosticoActionPerformed

    private void jtfLookCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            llenarControlAlumno();            
        }
    }//GEN-LAST:event_jtfLookCodigoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body2;
    private javax.swing.JPanel cabeza;
    private javax.swing.JPanel cuerp2CrearRecetas;
    private javax.swing.JPanel cuerpo1ListaRecetas;
    private javax.swing.JPanel cuerpo4VerDetallesDeLaReceta;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jbtEntregarMedicamentos;
    private javax.swing.JButton jbtnADDmedicamentos;
    private javax.swing.JButton jbtnCancelarCrearDiagnostico;
    private javax.swing.JButton jbtnFinalizar2;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnVolver2;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblMontoTotal;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblSaldoDisponible1;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JTextArea jtaDiagnostico;
    private javax.swing.JTable jtbCarritoLista;
    private javax.swing.JTable jtblMedicinasEntregada;
    private javax.swing.JTable jtblRecetas;
    private javax.swing.JTextField jtfLookCodigo;
    private javax.swing.JTextArea jtxtDiagnosticoNuevo;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Recetas(List<Receta> lista_de_recetas){
    
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Código","Fecha","Total costo","Procedencia","Diagnostico"}; 
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
             for (int i = 0; i < lista_de_recetas.size(); i++){
                 fila_actividad[0]=lista_de_recetas.get(i).getId_Diagnostico();
                 fila_actividad[1]=lista_de_recetas.get(i).getFecha_creada();             
                 fila_actividad[2]=lista_de_recetas.get(i).getTotal_costo_medicinas();  
                 fila_actividad[3]=lista_de_recetas.get(i).getProcedencia().getNombre();   
                 fila_actividad[4]=lista_de_recetas.get(i).getDiagnostico();  
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblRecetas.setModel(modelo); 
            jtblRecetas.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblRecetas.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jtblRecetas.getColumnModel().getColumn(4).setCellRenderer(tcr);
     
            
            jtblRecetas.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(85);
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtblRecetas.getColumnModel().getColumn(2).setPreferredWidth(90);
            jtblRecetas.getColumnModel().getColumn(3).setPreferredWidth(125);
            jtblRecetas.getColumnModel().getColumn(4).setPreferredWidth(365);
            
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
    
    

}
