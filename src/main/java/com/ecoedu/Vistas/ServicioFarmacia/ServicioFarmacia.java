package com.ecoedu.Vistas.ServicioFarmacia;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.soloMayusculas;
import com.ecoedu.Vistas.vista_base.CuadroCarritoMedicinas;
import com.ecoedu.Vistas.vista_base.Principal;
import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Detalle_Servicio_Social;
import com.ecoedu.model.Diagnostico;
import com.ecoedu.model.Estudiante;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.Receta;
import com.ecoedu.model.RegistroMensualLotes;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Semestre;
import com.ecoedu.model.Servicio_social;
import com.ecoedu.model.Usuario;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.dom4j.DocumentException;


public class ServicioFarmacia extends javax.swing.JPanel {
    private Principal objPrincipal;
    private Diagnostico objDiagnostico_Final;
    private float Monto_totalControlEstudiante;
    private float saldo_totalControlEstudiante;
    private List<Diagnostico> Lista_diagnostico;
    private Control_paciente objControl_paciente_Final;
    private Usuario objUsuario;
    private EntityManager jpa;   
    private List<Rol> Lista_Procedencia;    
    private List<Rol> Lista_Condicion;
    private List<Lote_detalle> Lista_lote_detalle;
    private List<Detalle_Medicamentos> Lista_carrito_medicamentos=new ArrayList<>();//
    //datos q se desglozan de la BD               
    private List<Control_paciente> Lista_control_paciente= new ArrayList<Control_paciente>();;//
    private List<Detalle_Medicamentos> Lista_detalle_medicamento;//
    private List<Receta> Lista_Recetas=new ArrayList<>();//
    private List<Servicio_social> Lista_Servicio;
    private TextAutoCompleter TextAutoCOmpleterCodigoDiagnostico;
    private int limite_seguro;
    
    public class Proceso extends Thread{
        public Proceso( ){
        
        }
        @Override
        public void run(){                 
            jtfLookCodigo.requestFocus();
        }        
    }
    
    public void llenar_Detalle_de_Recetas(List<Detalle_Medicamentos> listaDetallesMedicamentos){
        //updateSaldoDisponible();
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
                String [] lista={"Cantidad","Nombre","P.U.","P.T.","Fecha","Lote","Qu�mica(o)"}; 
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
                 fila_actividad[4]=Herramienta.formatoFechaHoraMas1(listaDetallesMedicamentos.get(i).getFecha()); 
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
            jtblMedicinasEntregada.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtblMedicinasEntregada.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtblMedicinasEntregada.getColumnModel().getColumn(2).setPreferredWidth(40);
            jtblMedicinasEntregada.getColumnModel().getColumn(3).setPreferredWidth(40);
            jtblMedicinasEntregada.getColumnModel().getColumn(4).setPreferredWidth(180);
            jtblMedicinasEntregada.getColumnModel().getColumn(5).setPreferredWidth(80);
            jtblMedicinasEntregada.getColumnModel().getColumn(6).setPreferredWidth(220);                     
            //880
            ((DefaultTableCellRenderer)jtblMedicinasEntregada.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);            
    }    
    public ServicioFarmacia(EntityManager jpa2,Principal OBJPrincipal,Usuario OBJUsuario){
        initComponents();        
        this.jpa=jpa2;
        this.objPrincipal=OBJPrincipal;
        this.objUsuario=OBJUsuario;        
    }
    
    private Semestre objSemestre;
     public void ConsultaBD(){               
         List<RegistroMensualLotes> listaRegistro=jpa.createQuery("SELECT p FROM RegistroMensualLotes p where fecha_cierre is null").getResultList();         
         if(listaRegistro.isEmpty()){         
             jbtnCrearReceta.setVisible(false);
             jbtnAgregarMedicamentoExtemporaneo.setVisible(false);
             jlblMensajito.setText("El inventario est� cerrado");
             jlblMensajito.setForeground(Color.red);
         }
         else{
             if(jpa.createQuery("select p from RegistroMensualLotes p where MONTH(fecha_apertura)="+(new Date().getMonth()+1)).getResultList().isEmpty()){
                 jbtnCrearReceta.setVisible(false);
                 jbtnAgregarMedicamentoExtemporaneo.setVisible(false);
                 jlblMensajito.setText("Cierre el inventario de "+Herramienta.getNombreMes(listaRegistro.get(0).getFecha_apertura().getMonth()+1));
                 jlblMensajito.setForeground(Color.red);                  
             }
             else{                 
                 jbtnCrearReceta.setVisible(true);
                 jbtnAgregarMedicamentoExtemporaneo.setVisible(true);
                 jlblMensajito.setText("LISTA DE RECETAS DEL ESTUDIANTE");
                 jlblMensajito.setForeground(Color.black); 
                 List<Semestre> lis=jpa.createQuery("SELECT p from Semestre p where fecha_fin_Real is null").getResultList();  
                 if(!lis.isEmpty()){
                     objSemestre=lis.get(0);
                     Lista_control_paciente=jpa.createQuery("SELECT p FROM Control_paciente p where iSactivo=1 and id_Semestre="+objSemestre.getId_Semestre()).getResultList();
                     jbtnCrearReceta.setVisible(true);
                     jbtnAgregarMedicamentoExtemporaneo.setVisible(true);
                     jlblMensajito.setText("");
                     }
                 else{
                     jbtnCrearReceta.setVisible(false);
                     jbtnAgregarMedicamentoExtemporaneo.setVisible(false);
                     jlblMensajito.setText("No hay un semestre vigente");
                     }
                 }                     
         }
        
         
         Lista_Procedencia =jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=5").getResultList();
         Lista_Condicion=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles=8").getResultList();
     }
     public void principalEjecucion(){         
         jtfLookCodigo.setText("");
         cuerpo1ListaRecetas.setVisible(true);
         cuerp2CrearRecetas.setVisible(false);     
         limpiarVista1();
         Limpiarcuerp2CrearRecetas();
         jtfLookCodigo.setEditable(true);
         if(!objUsuario.getRol().getNombre_rol().equals("ADMINISTRADOR.QF")){
             jbtnImprimir.setVisible(false);
         }         
         jbtnImprimir.setEnabled(false);
         jtfCodigoDiagnostico.setDocument(new soloMayusculas()); 
         this.TextAutoCOmpleterCodigoDiagnostico=new TextAutoCompleter(jtfCodigoDiagnostico, new AutoCompleterCallback(){
         @Override
         public void callback(Object o){
                }});      
         jbtnCrearReceta.setEnabled(false);
         llenar_Tabla_de_Recetas(Lista_Recetas);
         llenar_Tabla_de_carrito_medicina(Lista_carrito_medicamentos);
        
         jcbProcedencia.removeAllItems();
        for (Rol procedencia : Lista_Procedencia){
            jcbProcedencia.addItem(procedencia);
            }   
        new Proceso().start();
     }  
     public float getPrecio_delControlEstudiante(){
         return Monto_totalControlEstudiante;
     }
     public void addPrecio_delControlEstudiante(float a){
         Monto_totalControlEstudiante=Monto_totalControlEstudiante+a;
         saldo_totalControlEstudiante=saldo_totalControlEstudiante-a;
     }
     public void getListaCarritos(Detalle_Medicamentos objDetalleMedicamento){
         Lista_carrito_medicamentos.add(objDetalleMedicamento);
         for (Lote_detalle lote_detalle : Lista_lote_detalle){
             if(lote_detalle==objDetalleMedicamento.getLote_detalle()){
                 lote_detalle.setCantidad(lote_detalle.getCantidad()-objDetalleMedicamento.getCantidad());
                 lote_detalle.getInventario().setCantidad(lote_detalle.getInventario().getCantidad()-objDetalleMedicamento.getCantidad());
                 break;
                 }                          
         }         
         llenar_Tabla_de_carrito_medicina(Lista_carrito_medicamentos);
         jlblTotalCarrito.setText("S/"+Herramienta.dosDecimales(Monto_totalControlEstudiante-objControl_paciente_Final.getMonto_Total()));
         jlblSaldo.setText(Herramienta.dosDecimales(saldo_totalControlEstudiante));
                 
     }
     public void devolverDelCarrito(Detalle_Medicamentos objDetalleMedicamento){
         for (Lote_detalle lote_detalle : Lista_lote_detalle){
             if(lote_detalle==objDetalleMedicamento.getLote_detalle()){
                 lote_detalle.setCantidad(lote_detalle.getCantidad()+objDetalleMedicamento.getCantidad());
                 lote_detalle.getInventario().setCantidad(lote_detalle.getInventario().getCantidad()+objDetalleMedicamento.getCantidad());
                 break;
                 }                          
         } 
         
     }
     public List<Lote_detalle> getListaInventario(){
         List<Lote_detalle> lista_Lote=new ArrayList<>();
         for (Lote_detalle lote_detalle : Lista_lote_detalle) {
             if(lote_detalle.getInventario().getMedicamento().getRolorigen().getNombre_rol().equals("Med. Farmacia")){
                 lista_Lote.add(lote_detalle);
             }
         }
         return lista_Lote;
     } 
     public Principal getPrincipal(){
         return objPrincipal;
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
        jLabel9 = new javax.swing.JLabel();
        jlblCondicion = new javax.swing.JLabel();
        jlblespacio1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblEscuela = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblSerie = new javax.swing.JLabel();
        jlblespacio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfLookCodigo = new javax.swing.JTextField();
        jlblespacio2 = new javax.swing.JLabel();
        body2 = new javax.swing.JPanel();
        cuerpo1ListaRecetas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRecetas = new javax.swing.JTable();
        jlblMensajito = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jlblMontoTotal = new javax.swing.JLabel();
        jbtnImprimir = new javax.swing.JButton();
        jbtnCrearReceta = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jlblAdvertencia = new javax.swing.JLabel();
        cuerp2CrearRecetas = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jtfCodigoDiagnostico = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jlblDescripcion = new javax.swing.JLabel();
        jcbProcedencia = new javax.swing.JComboBox<>();
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
        jLabel16 = new javax.swing.JLabel();
        jlblMontoTotalCrearReceta = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jlblTotalCarrito = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jlblSaldo = new javax.swing.JLabel();
        jbtnCancelarCrearDiagnostico = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        cuerpo4VerDetallesDeLaReceta = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jlblDescripcionDia = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jlblProcedencia = new javax.swing.JLabel();
        jlblCodigoDiagnostico = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblMedicinasEntregada = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jbtnVolver3 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jbtnVolver2 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jbtnAgregarMedicamentoExtemporaneo = new javax.swing.JButton();

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

        jlblNombres.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jlblNombres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblNombres.setPreferredSize(new java.awt.Dimension(370, 30));
        jPanel5.add(jlblNombres);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel9.setText("Condici�n:");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 30));
        jPanel5.add(jLabel9);

        jlblCondicion.setBackground(new java.awt.Color(0, 0, 0));
        jlblCondicion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jlblCondicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCondicion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlblCondicion.setPreferredSize(new java.awt.Dimension(135, 30));
        jPanel5.add(jlblCondicion);

        jlblespacio1.setBackground(new java.awt.Color(0, 0, 0));
        jlblespacio1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblespacio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblespacio1.setPreferredSize(new java.awt.Dimension(25, 30));
        jPanel5.add(jlblespacio1);

        jPanel7.add(jPanel5);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel7.setText("ESCUELA :");
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel7.add(jLabel7);

        jlblEscuela.setBackground(new java.awt.Color(0, 0, 0));
        jlblEscuela.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jlblEscuela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEscuela.setToolTipText("");
        jlblEscuela.setPreferredSize(new java.awt.Dimension(360, 30));
        jPanel7.add(jlblEscuela);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel5.setText("Serie :");
        jLabel5.setPreferredSize(new java.awt.Dimension(58, 30));
        jPanel7.add(jLabel5);

        jlblSerie.setBackground(new java.awt.Color(0, 0, 0));
        jlblSerie.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSerie.setPreferredSize(new java.awt.Dimension(39, 30));
        jPanel7.add(jlblSerie);

        jlblespacio.setBackground(new java.awt.Color(0, 0, 0));
        jlblespacio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblespacio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblespacio.setPreferredSize(new java.awt.Dimension(35, 30));
        jPanel7.add(jlblespacio);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel8.setText("C�digo:");
        jLabel8.setPreferredSize(new java.awt.Dimension(68, 30));
        jPanel7.add(jLabel8);

        jtfLookCodigo.setBackground(new java.awt.Color(240, 200, 20));
        jtfLookCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtfLookCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLookCodigo.setPreferredSize(new java.awt.Dimension(85, 30));
        jtfLookCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfLookCodigoKeyTyped(evt);
            }
        });
        jPanel7.add(jtfLookCodigo);

        jlblespacio2.setBackground(new java.awt.Color(0, 0, 0));
        jlblespacio2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblespacio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblespacio2.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel7.add(jlblespacio2);

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
        jPanel9.setPreferredSize(new java.awt.Dimension(900, 305));
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
                "C�digo", "Fecha", "Total Costo", "Procedencia", "Diagnostico"
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

        jlblMensajito.setBackground(new java.awt.Color(255, 255, 255));
        jlblMensajito.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jlblMensajito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensajito.setText("LISTA DE RECETAS DEL ESTUDIANTE");
        jlblMensajito.setPreferredSize(new java.awt.Dimension(178, 30));
        jPanel9.add(jlblMensajito, java.awt.BorderLayout.PAGE_START);

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
        jLabel13.setPreferredSize(new java.awt.Dimension(130, 26));
        jPanel10.add(jLabel13);

        jlblMontoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblMontoTotal.setPreferredSize(new java.awt.Dimension(280, 29));
        jPanel10.add(jlblMontoTotal);

        jbtnImprimir.setBackground(new java.awt.Color(0, 0, 0));
        jbtnImprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        jbtnImprimir.setText("IMPRIMIR");
        jbtnImprimir.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnImprimir);

        jbtnCrearReceta.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCrearReceta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrearReceta.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCrearReceta.setText("CREAR RECETA");
        jbtnCrearReceta.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnCrearReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearRecetaActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnCrearReceta);

        cuerpo1ListaRecetas.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(900, 40));

        jlblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblAdvertencia.setForeground(new java.awt.Color(255, 0, 0));
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setMaximumSize(new java.awt.Dimension(500, 0));
        jlblAdvertencia.setMinimumSize(new java.awt.Dimension(100, 0));
        jlblAdvertencia.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel11.add(jlblAdvertencia);

        cuerpo1ListaRecetas.add(jPanel11);

        body2.add(cuerpo1ListaRecetas, "card2");

        cuerp2CrearRecetas.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMinimumSize(new java.awt.Dimension(860, 20));
        jPanel14.setPreferredSize(new java.awt.Dimension(900, 100));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMinimumSize(new java.awt.Dimension(860, 10));
        jPanel16.setPreferredSize(new java.awt.Dimension(1000, 30));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfCodigoDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfCodigoDiagnostico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCodigoDiagnostico.setMinimumSize(new java.awt.Dimension(6, 30));
        jtfCodigoDiagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoDiagnosticoKeyReleased(evt);
            }
        });
        jPanel16.add(jtfCodigoDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 130, 25));

        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("C�DIGO DIAGN�STICO");
        jPanel16.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("PROCEDENCIA:");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jlblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel16.add(jlblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 720, 25));

        jcbProcedencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel16.add(jcbProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 150, 25));

        jPanel14.add(jPanel16, java.awt.BorderLayout.CENTER);

        cuerp2CrearRecetas.add(jPanel14);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(900, 200));
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

        jbtnADDmedicamentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                "C�digo", "Producto Farmac�utico", "Cantidad Disponible", "Precio Unitario", "Codigo Lote"
            }
        ));
        jtbCarritoLista.setGridColor(new java.awt.Color(0, 0, 0));
        jtbCarritoLista.setPreferredSize(new java.awt.Dimension(300, 210));
        jScrollPane6.setViewportView(jtbCarritoLista);

        jPanel17.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        cuerp2CrearRecetas.add(jPanel17);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(900, 40));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Monto Total :");
        jLabel16.setPreferredSize(new java.awt.Dimension(130, 26));
        jPanel19.add(jLabel16);

        jlblMontoTotalCrearReceta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblMontoTotalCrearReceta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblMontoTotalCrearReceta.setPreferredSize(new java.awt.Dimension(100, 29));
        jPanel19.add(jlblMontoTotalCrearReceta);

        jLabel30.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Total:");
        jLabel30.setPreferredSize(new java.awt.Dimension(60, 26));
        jPanel19.add(jLabel30);

        jlblTotalCarrito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblTotalCarrito.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblTotalCarrito.setText("S/0.00");
        jlblTotalCarrito.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel19.add(jlblTotalCarrito);

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Saldo:");
        jLabel31.setPreferredSize(new java.awt.Dimension(60, 26));
        jPanel19.add(jLabel31);

        jlblSaldo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblSaldo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblSaldo.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel19.add(jlblSaldo);

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
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel19.add(jbtnGuardar);

        cuerp2CrearRecetas.add(jPanel19);

        body2.add(cuerp2CrearRecetas, "card3");

        cuerpo4VerDetallesDeLaReceta.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(900, 100));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel20.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 10, -1, -1));

        jLabel36.setPreferredSize(new java.awt.Dimension(10, 15));
        jPanel20.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 10, -1, -1));

        jlblDescripcionDia.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jlblDescripcionDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel20.add(jlblDescripcionDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 680, 30));

        jLabel40.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel40.setText("C�DIGO DIAGN�STICO:");
        jPanel20.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 210, 30));

        jLabel43.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel43.setText("DIAGN�STICO:");
        jPanel20.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        jLabel44.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel44.setText("PROCEDENCIA:");
        jPanel20.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        jlblProcedencia.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jlblProcedencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel20.add(jlblProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 160, 30));

        jlblCodigoDiagnostico.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jlblCodigoDiagnostico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel20.add(jlblCodigoDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 150, 30));

        cuerpo4VerDetallesDeLaReceta.add(jPanel20);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(900, 200));
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
                "Producto Farmac�utico", "Cantidad ", "Precio Unitario", "Qu�mico Farmaceutico", "Lote"
            }
        ));
        jtblMedicinasEntregada.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(jtblMedicinasEntregada);

        jPanel22.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        cuerpo4VerDetallesDeLaReceta.add(jPanel22);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(900, 40));

        jbtnVolver3.setBackground(new java.awt.Color(0, 0, 0));
        jbtnVolver3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnVolver3.setForeground(new java.awt.Color(255, 255, 255));
        jbtnVolver3.setText("IMPRIMIR RECETA");
        jbtnVolver3.setPreferredSize(new java.awt.Dimension(180, 25));
        jbtnVolver3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolver3ActionPerformed(evt);
            }
        });
        jPanel24.add(jbtnVolver3);

        jLabel41.setPreferredSize(new java.awt.Dimension(320, 30));
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

        jbtnAgregarMedicamentoExtemporaneo.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregarMedicamentoExtemporaneo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAgregarMedicamentoExtemporaneo.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarMedicamentoExtemporaneo.setText("AGREGAR MEDICAMENTOS");
        jbtnAgregarMedicamentoExtemporaneo.setPreferredSize(new java.awt.Dimension(200, 25));
        jbtnAgregarMedicamentoExtemporaneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarMedicamentoExtemporaneoActionPerformed(evt);
            }
        });
        jPanel24.add(jbtnAgregarMedicamentoExtemporaneo);

        cuerpo4VerDetallesDeLaReceta.add(jPanel24);

        body2.add(cuerpo4VerDetallesDeLaReceta, "card3");

        body.add(body2, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
   
    
    public void llenarControlAlumno(){//usando acceso BD  
        boolean aux=true;
        for (int i = 0; i < Lista_control_paciente.size(); i++){
            if (Lista_control_paciente.get(i).getEstudiante().getCodigo().equals(jtfLookCodigo.getText())){ 
                aux=false;                
                objControl_paciente_Final=Lista_control_paciente.get(i);
                limite_seguro=objControl_paciente_Final.getLimite_control();
                jlblCondicion.setText(objControl_paciente_Final.getEstudiante().getRolCondicion().getNombre_rol());
                Monto_totalControlEstudiante=objControl_paciente_Final.getMonto_Total();
                saldo_totalControlEstudiante=limite_seguro-objControl_paciente_Final.getMonto_Total();
                jlblNombres.setText(Lista_control_paciente.get(i).getEstudiante().getPersona().getInfoPersona());
                jlblSerie.setText(Lista_control_paciente.get(i).getEstudiante().getSerie());
                jlblEscuela.setText(Lista_control_paciente.get(i).getEstudiante().getRolescuela().getNombre_rol());
                jlblMontoTotal.setText("S/"+Herramienta.dosDecimales(Lista_control_paciente.get(i).getMonto_Total()));              
                Lista_Recetas=Herramienta.findbyWhere(Receta.class,"id_Control_paciente",objControl_paciente_Final.getId_Control_paciente(), jpa);
                Lista_Servicio=Herramienta.findbyWhere(Servicio_social.class,"id_Control_paciente",objControl_paciente_Final.getId_Control_paciente(), jpa);
                jbtnCrearReceta.setEnabled(true);
                jbtnImprimir.setEnabled(true);
                if(Lista_Recetas.isEmpty()){
                    jlblAdvertencia.setText("NO CONTIENE NI UNA RECETA");
                    jbtnImprimir.setEnabled(false);
                }
                else{
                    jlblAdvertencia.setText("");
                }
                break;
            }
            jbtnCrearReceta.setEnabled(false);
            jbtnImprimir.setEnabled(false);
            jlblAdvertencia.setText("");
        }
        if(aux){            
            List<Estudiante> Lista_Estudiante=jpa.createQuery("SELECT p FROM Estudiante p where codigo='"+jtfLookCodigo.getText()+"'").getResultList();
            if(Lista_Estudiante.isEmpty()){
                jlblAdvertencia.setText("NO SE ENCONTR� ALUMNO CON EL C�DIGO: "+jtfLookCodigo.getText());
                limpiarVista1();
                }
            else{
                if(objSemestre!=null){
                CuadroCarritoMedicinas objCuadroCarrito=new CuadroCarritoMedicinas(jpa, Lista_Estudiante.get(0), this,objSemestre);
                objCuadroCarrito.setVisible(true);
                objPrincipal.setEnabled(false);}
                }
            }
       llenar_Tabla_de_Recetas(Lista_Recetas);        
    }
    private void jbtnCrearRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearRecetaActionPerformed
        Query query1=jpa.createQuery("SELECT p FROM Lote_detalle p where isVencido=0");
        Lista_lote_detalle=query1.getResultList();
        cuerpo1ListaRecetas.setVisible(false);
        cuerp2CrearRecetas.setVisible(true);      
        jtfLookCodigo.setEditable(false);
        jlblSaldo.setText("S/"+Herramienta.dosDecimales(limite_seguro-objControl_paciente_Final.getMonto_Total()));
        jlblMontoTotalCrearReceta.setText("S/"+Herramienta.dosDecimales(objControl_paciente_Final.getMonto_Total()));
    }//GEN-LAST:event_jbtnCrearRecetaActionPerformed

    private void jtblRecetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRecetasMouseClicked
        Receta objReceta=(Receta)jtblRecetas.getValueAt(jtblRecetas.getSelectedRow(),0);
        //for (int i = 0; i < Lista_Recetas.size(); i++){
            //if(Lista_Recetas.get(i)==objReceta){ 
                Lista_detalle_medicamento=Herramienta.findbyWhere(Detalle_Medicamentos.class,"id_Receta", objReceta.getId_Receta(), jpa);
                llenar_Detalle_de_Recetas(Lista_detalle_medicamento);
                cuerpo1ListaRecetas.setVisible(false);
                cuerpo4VerDetallesDeLaReceta.setVisible(true);
                
                jlblCodigoDiagnostico.setText(objReceta.getDiagnosito().getId_DiagnosticoCodigo());
                jlblDescripcionDia.setText(objReceta.getDiagnosito().getDescripcion_Diagnostico());
                jlblProcedencia.setText(objReceta.getRolProcedencia().getNombre_rol());
                jtfLookCodigo.setEditable(false);
              //  break;
            //}        
        //}
    }//GEN-LAST:event_jtblRecetasMouseClicked

    private void jbtnVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolver2ActionPerformed
        cuerpo4VerDetallesDeLaReceta.setVisible(false);
        cuerpo1ListaRecetas.setVisible(true);
        jtfLookCodigo.setEditable(true);
        Monto_totalControlEstudiante=objControl_paciente_Final.getMonto_Total();
    }//GEN-LAST:event_jbtnVolver2ActionPerformed

    private void jbtnADDmedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnADDmedicamentosActionPerformed
       CuadroCarritoMedicinas objCuadroCarritoMedicinas=new CuadroCarritoMedicinas(jpa,this,limite_seguro);
       objCuadroCarritoMedicinas.setVisible(true);
       objPrincipal.setEnabled(false);
       
    }//GEN-LAST:event_jbtnADDmedicamentosActionPerformed

    private void jbtnCancelarCrearDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarCrearDiagnosticoActionPerformed
        cuerp2CrearRecetas.setVisible(false);
        cuerpo1ListaRecetas.setVisible(true);
        jtfLookCodigo.setEditable(true);
        jlblDescripcion.setText("");
        jlblTotalCarrito.setText("0.00");
        jlblCodigoDiagnostico.setText("");
        Monto_totalControlEstudiante=objControl_paciente_Final.getMonto_Total();
        saldo_totalControlEstudiante=limite_seguro-Monto_totalControlEstudiante;
        for (Detalle_Medicamentos Lista_carrito_medicamento : Lista_carrito_medicamentos){
            devolverDelCarrito(Lista_carrito_medicamento);            
        }
        Limpiarcuerp2CrearRecetas();
        
    }//GEN-LAST:event_jbtnCancelarCrearDiagnosticoActionPerformed

    private void jtfLookCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){  
            llenarControlAlumno();            
        }
    }//GEN-LAST:event_jtfLookCodigoKeyPressed

    public Receta fechadeUltimaReceta(List<Receta> listaRecetas){
        Receta LDprimero=listaRecetas.get(0);
        for(int i = 1; i < listaRecetas.size(); i++){
            if(LDprimero.getFecha_creada().getTime()<listaRecetas.get(i).getFecha_creada().getTime()){
                LDprimero=listaRecetas.get(i);
                }
            }
        return LDprimero;
    }
    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        //Lista_Recetas
        Estudiante objEstudiante=objControl_paciente_Final.getEstudiante();
        Receta objReceta;        
        Receta objReceta_Final=new Receta();
        objReceta_Final.setRolProcedencia((Rol)jcbProcedencia.getSelectedItem()); 
        try {            
            if(jlblDescripcion.getText().length()!=0){
                if(!Lista_carrito_medicamentos.isEmpty()){
                    objReceta_Final.setDiagnostico(objDiagnostico_Final);
            objReceta_Final.setFecha_creada(new Date());
            float precio_total_receta=0;
            for (int i = 0; i < Lista_carrito_medicamentos.size(); i++) {
                precio_total_receta=precio_total_receta+Lista_carrito_medicamentos.get(i).getPrecio_Total();
            }
            objReceta_Final.setTotal_costo_medicinas(precio_total_receta);
            objReceta_Final.setControl_Paciente(objControl_paciente_Final);
            jpa.getTransaction().begin();
            jpa.persist(objReceta_Final);
            jpa.refresh(objReceta_Final);  
            jpa.persist(objControl_paciente_Final.agregarPrecioTotal(precio_total_receta));
            for (int i = 0; i < Lista_carrito_medicamentos.size(); i++){
                Lista_carrito_medicamentos.get(i).setUsuario(objUsuario);
                Lista_carrito_medicamentos.get(i).setReceta(objReceta_Final); 
                jpa.persist(Lista_carrito_medicamentos.get(i));       
                jpa.persist(Lista_carrito_medicamentos.get(i).getLote_detalle());//agrgando Lote_Detalle
                jpa.persist(Lista_carrito_medicamentos.get(i).getLote_detalle().getInventario());//agregando Inventario
            //Lista_Detalle_Llenado_final.get(i).setLote_detalle(Lista_Lote_detalle_final.get(i));
            //Lista_Lote_detalle_final.get(i).getInventario().agregarCantidad(Lista_Detalle_Llenado_final.get(i).getCantidad());
            //jpa.persist(Lista_Lote_detalle_final.get(i).getInventario());
            }
            jlblSaldo.setText("S/0.00");
            jlblTotalCarrito.setText("S/0.00");
            jlblAdvertencia.setText("");           
            if(!Lista_Recetas.isEmpty()){
                objReceta=fechadeUltimaReceta(Lista_Recetas);
                if((-objReceta.getFecha_creada().getTime()+new Date().getTime())/86400000<179){//menor de 6 meses
                    objEstudiante.setRolCondicion(Lista_Condicion.get(1));
                    JOptionPane.showMessageDialog(jlblNombres, "CONCURRENTE"+(objReceta.getFecha_creada().getTime()-new Date().getTime())/86400000);
                    jpa.createNativeQuery("update Estudiante set id_RolCondicion="+5+" where id_Estudiante="+objEstudiante.getId_Estudiante()).executeUpdate();
                    jpa.persist(objEstudiante);}
                else{
                    JOptionPane.showMessageDialog(jlblNombres, "REINGRESANTE");
                    objEstudiante.setRolCondicion(Lista_Condicion.get(2));
                    jpa.createNativeQuery("update Estudiante set id_RolCondicion="+6+" where id_Estudiante="+objEstudiante.getId_Estudiante()).executeUpdate();
                    jpa.persist(objEstudiante);//Reingresante
                    }
                }            
            int confirmado = JOptionPane.showConfirmDialog(jlblNombres,"�Desea Imprimir la Receta?");
            if (JOptionPane.OK_OPTION == confirmado){
                try {                
                    imprimirReceta(Lista_carrito_medicamentos);
                    String url="Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+"receta.pdf";
                    ProcessBuilder p=new ProcessBuilder();
                    p.command("cmd.exe","/c",url);
                    p.start();            
                    } catch (IOException ex) {
                        Logger.getLogger(ServicioFarmacia.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            else{
                System.out.println("vale... no borro nada...");}
             Limpiarcuerp2CrearRecetas();            
            jtfLookCodigo.setEditable(true);
            jpa.getTransaction().commit();//finnnnnnnnnnnnnnnnnnnnnnnnn transact
            ConsultaBD();
            llenarControlAlumno();                
                }
                else{
                    JOptionPane.showMessageDialog(jlblNombres, "NO SE ENCONTR� NING�N MEDICAMENTO");
                    }
                }
            else{
                JOptionPane.showMessageDialog(jlblNombres, "INGRESE UN C�DIGO DE DIAGN�STICO V�LIDO");
            }
            
            } 
        catch (HeadlessException e) {
            JOptionPane.showMessageDialog(jlblNombres, e.toString());
        }
        
       
        
        
        
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    public void Limpiarcuerp2CrearRecetas(){
        jtfCodigoDiagnostico.setText("");
        Lista_carrito_medicamentos.clear();
        llenar_Tabla_de_carrito_medicina(Lista_carrito_medicamentos);
        cuerp2CrearRecetas.setVisible(false);
        cuerpo1ListaRecetas.setVisible(true);
    }
    private void jtfCodigoDiagnosticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoDiagnosticoKeyReleased
        boolean auxDiag=false;
        if(!jtfCodigoDiagnostico.getText().equals("")){
            TextAutoCOmpleterCodigoDiagnostico.removeAllItems();        
            Lista_diagnostico=Herramienta.findbyLike(Diagnostico.class, "id_CondicionCodigo",jtfCodigoDiagnostico.getText(),jpa);
            for (Diagnostico diagnostico : Lista_diagnostico){
                      TextAutoCOmpleterCodigoDiagnostico.addItem(diagnostico.getId_DiagnosticoCodigo()); 
                      if(jtfCodigoDiagnostico.getText().equals(diagnostico.getId_DiagnosticoCodigo())){
                          jlblDescripcion.setText(diagnostico.getDescripcion_Diagnostico());
                          objDiagnostico_Final=diagnostico;
                          auxDiag=true;
                          break;
                      }
            }
            if(!auxDiag){
                jlblDescripcion.setText("");
            }
          
            }
        
        
    }//GEN-LAST:event_jtfCodigoDiagnosticoKeyReleased

    private void jbtnAgregarMedicamentoExtemporaneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarMedicamentoExtemporaneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregarMedicamentoExtemporaneoActionPerformed

    private void jtfLookCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyTyped
        if (jtfLookCodigo.getText().length()>=8){             
         evt.consume(); 
         }     
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jtfLookCodigoKeyTyped

    private void jtfLookCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLookCodigoKeyReleased
        if(jtfLookCodigo.getText().length()>=8){
                llenarControlAlumno();
            }
        else{
            limpiarVista1();
        }
    }//GEN-LAST:event_jtfLookCodigoKeyReleased

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed

        try {
            imprimirEstudiante();
            String url="Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
            }
        catch (IOException ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(jLabel12,"El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso");        
        } 
        catch (DocumentException ex) {
            JOptionPane.showMessageDialog(jLabel12,ex.toString());

        }
    }//GEN-LAST:event_jbtnImprimirActionPerformed

    private void jbtnVolver3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolver3ActionPerformed
        try {
            imprimirReceta(Lista_detalle_medicamento);
            String url="Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+"receta.pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
            }
        catch (IOException ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(jLabel12,"El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso");        
        } 
    }//GEN-LAST:event_jbtnVolver3ActionPerformed
    public void imprimirReceta(List<Detalle_Medicamentos> ListaMedicamentosDetalle) throws MalformedURLException, IOException{
        //String ol="images\\unsch.png";
        //Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTama�o=8;
        int fontHeadTama�o=10;
        
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+"receta.pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso");
        } 
        
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{50,10,10,10,20});
        table.setWidthPercent(31);
        
        //Paragraph paragIma=new Paragraph("").add(unsch);  
        //document.add(paragIma);
        
        Paragraph paraTitle=new Paragraph("").add(new Text("               RECETA �NICA ESTANDARIZADA").setFontSize(fontHeadTama�o).setFont(bold));
        document.add(paraTitle);
        Paragraph parag=new Paragraph(new Text(" PACIENTE: ").setFontSize(fontTama�o).setFont(bold)).add(new Text(objControl_paciente_Final.getEstudiante().getPersona().getInfoPersona()).setFontSize(fontTama�o)).setTextAlignment(TextAlignment.LEFT)
                .add(new Text("       SEXO: ").setFont(bold)).setFontSize(fontTama�o).add(new Text(objControl_paciente_Final.getEstudiante().getRolSexo().getNombre_rol()).setFontSize(fontTama�o));
        document.add(parag);      
        Paragraph paraEscCodSerie=new Paragraph(new Text("E.P: ").setFontSize(fontTama�o).setFont(bold)).add(new Text(objControl_paciente_Final.getEstudiante().getRolescuela().getNombre_rol()).setFontSize(fontTama�o))
                .add(new Text(" SERIE: ").setFontSize(fontTama�o).setFont(bold)).add(new Text(objControl_paciente_Final.getEstudiante().getSerie()).setFontSize(fontTama�o)).setTextAlignment(TextAlignment.LEFT)
                .add(new Text(" C�DIGO: ").setFontSize(fontTama�o).setFont(bold)).add(new Text(objControl_paciente_Final.getEstudiante().getCodigo()).setFontSize(fontTama�o));
        document.add(paraEscCodSerie);
        Paragraph paraEdadEspecialidad=new Paragraph(new Text(" EDAD: ").setFontSize(fontTama�o).setFont(bold)).add(new Text(Herramienta.getA�osFrom(objControl_paciente_Final.getEstudiante().getFecha_nacimiento())+"").setFontSize(fontTama�o))
                .add(new Text( "                                   ESPECIALIDAD: ").setFontSize(fontTama�o).setFont(bold)).add(new Text(ListaMedicamentosDetalle.get(0).getReceta().getRolProcedencia().getNombre_rol()).setFontSize(fontTama�o));
        document.add(paraEdadEspecialidad);
        Paragraph parag2=new Paragraph("").add(new Text("                            MEDICAMENTOS ENTREGADOS").setFontSize(fontTama�o).setFont(bold));         
        document.add(parag2);
        document.add(new Paragraph(" "));    
        table.addHeaderCell(new Cell().add(new Paragraph("P.F").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("Cant").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("P.U").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));        
        table.addHeaderCell(new Cell().add(new Paragraph("P.T").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Fecha").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o)); 
                 
      Collections.sort(ListaMedicamentosDetalle);//ordenando A-Z (m�todo como Override)
        for(Detalle_Medicamentos detalleMedi : ListaMedicamentosDetalle){                    
            table.addCell(new Paragraph(detalleMedi.getId_Medicamento().getNombre()).setFontSize(fontTama�o).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(detalleMedi.getCantidad()+"").setFontSize(fontTama�o).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(detalleMedi.getPrecio_Unitario()+"").setFontSize(fontTama�o).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(detalleMedi.getPrecio_Total()+"").setFontSize(fontTama�o).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Herramienta.formatoFecha(detalleMedi.getFecha())).setFontSize(fontTama�o).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            }
        document.add(table);        
        document.close();   
        
    }
    public void imprimirEstudiante() throws FileNotFoundException, DocumentException, IOException{
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTama�o=9;
        int fontHeadTama�o=11;
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\Control_Estudiante"+objControl_paciente_Final.getEstudiante().getCodigo()+".pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque est� siendo utilizado por otro proceso");
        } 
        
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4);        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{8,15,5,4,18});
        table.setWidthPercent(100);
        
        Paragraph paragIma=new Paragraph("").add(unsch);         
        Paragraph paraTitle=new Paragraph("CONTROL ECON�MICO DE ATENCIONES").setFontSize(16).setFont(bold).setTextAlignment(TextAlignment.CENTER);        
        Paragraph parag=new Paragraph(new Text("APELLIDOS Y NOMBRES: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getPersona().getInfoPersona()).setTextAlignment(TextAlignment.LEFT);
        Paragraph paraEscCodSerie=new Paragraph(new Text("ESCUELA: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getRolescuela().getNombre_rol())
                .add(new Text("         SERIE: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getSerie()).setTextAlignment(TextAlignment.LEFT)
                .add(new Text("         C�DIGO: ").setFont(bold)).add(objControl_paciente_Final.getEstudiante().getCodigo());
        Paragraph paraTitulo=new Paragraph("ATENCIONES-SERVICIO DE FARMACIA").setFont(bold).setTextAlignment(TextAlignment.CENTER);         
        table.addHeaderCell(new Cell().add(new Paragraph("Fecha").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("Producto Farmac�utico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        table.addHeaderCell(new Cell().add(new Paragraph("Cantidad").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));        
        table.addHeaderCell(new Cell().add(new Paragraph("Monto").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o)); 
        table.addHeaderCell(new Cell().add(new Paragraph("Qu�mico").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o)); 
                 
      Collections.sort(Lista_Recetas);//ordenando A-Z (m�todo como Override)
      Collections.sort(Lista_Servicio);
        for(Receta receta : Lista_Recetas){
            List<Detalle_Medicamentos> listMedi=Herramienta.findbyWhere(Detalle_Medicamentos.class,"id_Receta", receta.getId_Receta(), jpa);
            Collections.sort(listMedi);//ordenando A-Z (m�todo como Override)
            Paragraph p = new Paragraph("Receta N�").setFont(bold).setFontSize(10)
                    .add(new Text(""+receta.getId_Receta()).setFont(bold).setFontSize(10))
                    .add(new Text("   Procedencia: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getRolProcedencia().getNombre_rol()).setFont(font).setFontSize(10))
                    .add(new Text("   Diagn�stico: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getDiagnosito().getId_DiagnosticoCodigo()).setFontSize(10));
            
            table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o)
                    .add(Herramienta.formatoFecha(receta.getFecha_creada())).setFont(bold) );
            
            table.addCell(new Cell(1, 4).add(p).setTextAlignment(TextAlignment.LEFT));
            for (Detalle_Medicamentos Detalle_Medicamento : listMedi) {           
            table.addCell(new Paragraph(Herramienta.formatoFecha(Detalle_Medicamento.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Detalle_Medicamento.getId_Medicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Integer.toString(Detalle_Medicamento.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Float.toString(Detalle_Medicamento.getPrecio_Total())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
            }
        }
        Paragraph paraTituloSocial=new Paragraph("ATENCIONES-SERVICIO SOCIAL").setFont(bold).setTextAlignment(TextAlignment.CENTER);         
        Table tableSocial = new Table(new float[]{5,12,3});
        tableSocial.addHeaderCell(new Cell().add(new Paragraph("Fecha").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        tableSocial.addHeaderCell(new Cell().add(new Paragraph("Servicio").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));         
        tableSocial.addHeaderCell(new Cell().add(new Paragraph("Precio").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTama�o));        
        for (Servicio_social servicio_social : Lista_Servicio){
            List<Detalle_Servicio_Social> lista_Detalle_ServicioSocial=Herramienta.findbyWhere(Detalle_Servicio_Social.class,"id_Servicio_social", servicio_social.getId_Detalle_servicio_social(), jpa);
            for (Detalle_Servicio_Social detalle_Servicio_Social : lista_Detalle_ServicioSocial) {
                tableSocial.addCell(new Paragraph(Herramienta.formatoFecha(servicio_social.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
                tableSocial.addCell(new Paragraph(detalle_Servicio_Social.getTarifario().getDescripcion()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
                tableSocial.addCell(new Paragraph(detalle_Servicio_Social.getPrecio_Total()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTama�o));
                }
            }        
        document.add(paragIma);
        document.add(paraTitle);
        document.add(parag);      
        document.add(paraEscCodSerie);
        document.add(paraTitulo);
        document.add(new Paragraph(" "));    
        document.add(table);   
        if(!Lista_Servicio.isEmpty()){
        document.add(paraTituloSocial);
        document.add(tableSocial);}
        document.close();       
    }
    public void limpiarVista1(){
        jlblCondicion.setText("");
        jlblNombres.setText("");
        jlblEscuela.setText("");
        jlblSerie.setText("");
        jlblMontoTotal.setText("");
        //jlblAdvertencia.setText("");
        Lista_Recetas.clear();
        llenar_Tabla_de_Recetas(Lista_Recetas);
     }

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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jbtnADDmedicamentos;
    private javax.swing.JButton jbtnAgregarMedicamentoExtemporaneo;
    private javax.swing.JButton jbtnCancelarCrearDiagnostico;
    private javax.swing.JButton jbtnCrearReceta;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JButton jbtnVolver2;
    private javax.swing.JButton jbtnVolver3;
    private javax.swing.JComboBox<Rol> jcbProcedencia;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblCodigoDiagnostico;
    private javax.swing.JLabel jlblCondicion;
    private javax.swing.JLabel jlblDescripcion;
    private javax.swing.JLabel jlblDescripcionDia;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblMensajito;
    private javax.swing.JLabel jlblMontoTotal;
    private javax.swing.JLabel jlblMontoTotalCrearReceta;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblProcedencia;
    private javax.swing.JLabel jlblSaldo;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JLabel jlblTotalCarrito;
    private javax.swing.JLabel jlblespacio;
    private javax.swing.JLabel jlblespacio1;
    private javax.swing.JLabel jlblespacio2;
    private javax.swing.JTable jtbCarritoLista;
    private javax.swing.JTable jtblMedicinasEntregada;
    private javax.swing.JTable jtblRecetas;
    private javax.swing.JTextField jtfCodigoDiagnostico;
    private javax.swing.JTextField jtfLookCodigo;
    // End of variables declaration//GEN-END:variables
public void llenar_Tabla_de_Recetas(List<Receta> lista_de_recetas){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Fecha","Total costo","Procedencia","Diagnostico"}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                       false, false, false, false
                         };
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................           
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = lista_de_recetas.size()-1; i>=0 ; i--){
                 fila_actividad[0]=lista_de_recetas.get(i);             
                 fila_actividad[1]=lista_de_recetas.get(i).getTotal_costo_medicinas();  
                 fila_actividad[2]=lista_de_recetas.get(i).getRolProcedencia().getNombre_rol();   
                 fila_actividad[3]=lista_de_recetas.get(i).getDiagnosito().getId_DiagnosticoCodigo();  
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

     
            
            jtblRecetas.setFont(new java.awt.Font("Tahoma", 0, 15));
            jtblRecetas.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20));
            jtblRecetas.getTableHeader().setBackground(Color.BLUE);
            jtblRecetas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblRecetas.getColumnModel().getColumn(0).setPreferredWidth(250);
            jtblRecetas.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblRecetas.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtblRecetas.getColumnModel().getColumn(3).setPreferredWidth(150);     
            ((DefaultTableCellRenderer)jtblRecetas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64  
    }   
    
    

}
