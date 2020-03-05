/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas.vista_base;
import com.ecoedu.Vistas.Consultas.Entrega_del_dia;
import com.ecoedu.Vistas.Consultas.Reporte_Condicion;
import com.ecoedu.Vistas.Consultas.Reporte_Diagnostico;
import com.ecoedu.Vistas.Estudiante.Crear_Estudiante;
import com.ecoedu.Vistas.Estudiante.Modificar_Estudiante;
import com.ecoedu.Vistas.Consultas.Reporte_Por_Escuela;
import com.ecoedu.Vistas.Consultas.Reporte_Por_Escuela_AtendidosBotica;
import com.ecoedu.Vistas.Consultas.Reporte_de_insumos;
import com.ecoedu.Vistas.Herramienta;
import com.ecoedu.Vistas.Inicio;
import com.ecoedu.Vistas.Inventario.Abrir_Inventario;
import com.ecoedu.Vistas.Inventario.Cerrar_Inventario;
import com.ecoedu.Vistas.Inventario.Descargo;
import com.ecoedu.Vistas.Inventario.Detalle_Inventario;
import com.ecoedu.Vistas.Inventario.LlenarInventario;
import com.ecoedu.Vistas.Inventario.Ver_inventario;
import com.ecoedu.Vistas.Medicamento.CrearMedicamento;
import com.ecoedu.Vistas.Medicamento.ModificarMedicamento;
import com.ecoedu.Vistas.ProveedorFabricante.ProveedorLaboratorio;
import com.ecoedu.Vistas.ServicioAsistencial.Servicio_Asistencial;
import com.ecoedu.Vistas.ServicioFarmacia.ServicioFarmacia;
import com.ecoedu.Vistas.Tarifario.Crear_Tarifario;
import com.ecoedu.Vistas.Tarifario.Modificar_Tarifario;
import com.ecoedu.Vistas.Usuario.CrearUsuario;
import com.ecoedu.Vistas.Usuario.ModificarUsuario;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.Semestre;
import com.ecoedu.model.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.dom4j.DocumentException;


/**
 *
 * @author yrma
 */
public class Principal extends javax.swing.JFrame{
    
    private boolean auxFarmacia=false;
    List<Lote_detalle> lotes_por_vencer;
    List<Lote_detalle> lotes_por_vencidos;
    Semestre objSemestreF;

    
    public class Proceso extends Thread{
        @Override
        public void run(){    
            jListaMedicamentosVencidos.setSize(700,350);
            jListaMedicamentosVencidos.setLocationRelativeTo(null);
            lotes_por_vencidos=jpa.createQuery("select p from Lote_detalle p where  DATEDIFF(day,  GETDATE(),fecha_vencimiento)<=0 and isVencido=0").getResultList();
            lotes_por_vencer=jpa.createQuery("select p from Lote_detalle p where  DATEDIFF(day,  GETDATE(),fecha_vencimiento)<60 and DATEDIFF(day,  GETDATE(),fecha_vencimiento)>0  and isVencido=0").getResultList();
            objInicio.ConsultaBD();
            objInicio.principalEjecucion();
            llenar_tabla_LoteDetalleVencidos(lotes_por_vencidos);
            llenar_tabla_LoteDetalle(lotes_por_vencer);
            jlblPorvencer.setText("POR VENCER: "+lotes_por_vencer.size());
            jlblVencidos.setText("VENCIDOS: "+lotes_por_vencidos.size());
            jListaMedicamentosVencidos.setVisible(true);           
            
            }
        }
    public class ProcesoCarga extends Thread{
        @Override
        public void run(){          
            jdialogCarga.setLocationRelativeTo(null);
            jdialogCarga.setSize(350,250);
            jdialogCarga.setVisible(true);
            }
        }
    public void llenar_tabla_LoteDetalle(List<Lote_detalle> listaLote){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cantidad","Fecha Venc."}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false,false,false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i < listaLote.size(); i++){
                 fila_actividad[0]=listaLote.get(i).getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=listaLote.get(i);
                 fila_actividad[2]=listaLote.get(i).getCantidad();             
                 fila_actividad[3]=Herramienta.formatoFechaMas1(listaLote.get(i).getFecha_vencimiento());
                             
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
             
             
            jtblPorVencer.setModel(modelo); 
            jtblPorVencer.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblPorVencer.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblPorVencer.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblPorVencer.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jtblPorVencer.getColumnModel().getColumn(3).setCellRenderer(tcr);
           
            jtblPorVencer.setFont(new java.awt.Font("Tahoma", 0, 12));
            jtblPorVencer.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15));
            jtblPorVencer.getTableHeader().setBackground(Color.BLUE);
            jtblPorVencer.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblPorVencer.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtblPorVencer.getColumnModel().getColumn(1).setPreferredWidth(115);
            jtblPorVencer.getColumnModel().getColumn(2).setPreferredWidth(85);    
            jtblPorVencer.getColumnModel().getColumn(3).setPreferredWidth(60);
           
            ((DefaultTableCellRenderer)jtblPorVencer.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    public void llenar_tabla_LoteDetalleVencidos(List<Lote_detalle> listaLote){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cantidad","Fecha Venc."}; 
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {false,false,false,false};
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................          
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i = 0; i < listaLote.size(); i++){
                 fila_actividad[0]=listaLote.get(i).getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=listaLote.get(i);
                 fila_actividad[2]=listaLote.get(i).getCantidad();             
                 fila_actividad[3]=Herramienta.formatoFechaMas1(listaLote.get(i).getFecha_vencimiento());
                             
                 modelo.addRow(fila_actividad);//agregando filas
                 }             
             
             
            jbtlVencidos.setModel(modelo); 
            jbtlVencidos.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jbtlVencidos.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jbtlVencidos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jbtlVencidos.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jbtlVencidos.getColumnModel().getColumn(3).setCellRenderer(tcr);
           
            jbtlVencidos.setFont(new java.awt.Font("Tahoma", 0, 12));
            jbtlVencidos.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15));
            jbtlVencidos.getTableHeader().setBackground(Color.BLUE);
            jbtlVencidos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jbtlVencidos.getColumnModel().getColumn(0).setPreferredWidth(200);
            jbtlVencidos.getColumnModel().getColumn(1).setPreferredWidth(115);
            jbtlVencidos.getColumnModel().getColumn(2).setPreferredWidth(85);    
            jbtlVencidos.getColumnModel().getColumn(3).setPreferredWidth(60);
           
            ((DefaultTableCellRenderer)jbtlVencidos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
   public void actulizarPeriodo(){
       List<Semestre> lis=jpa.createQuery("SELECT p from Semestre p where fecha_fin_Real is null").getResultList();  
        if(!lis.isEmpty()){
            objSemestre=lis.get(0);
            if(objSemestre.isSemestre_periodo()){
                jlblSemestre.setText("Semestre: "+(objSemestre.getFecha_Fin().getYear()+1900)+"-II"
                        + "   Fecha Inicio : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Inicio())
                        + "   Fecha Fin : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Fin()));
            }
            else{
                jlblSemestre.setText("Semestre: "+(objSemestre.getFecha_Fin().getYear()+1900)+"-I"
                        + "   Fecha Inicio : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Inicio())
                        + "   Fecha Fin : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Fin()));              
            }
            
        }else{
            jlblSemestre.setText("NO HAY UN SEMESTRE ACTIVO");
        }
   }    
   public void actulizarPeriodoClick(){
       List<Semestre> lis=jpa.createQuery("SELECT p from Semestre p where fecha_fin_Real is null").getResultList();  
        if(!lis.isEmpty()){
            objSemestre=lis.get(0);
            if(objSemestre.isSemestre_periodo()){
                jlblSemestre.setText("Semestre: "+(objSemestre.getFecha_Fin().getYear()+1900)+"-II"
                        + "   Fecha Inicio : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Inicio())
                        + "   Fecha Fin : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Fin()));
            }
            else{
                jlblSemestre.setText("Semestre: "+(objSemestre.getFecha_Fin().getYear()+1900)+"-I"
                        + "   Fecha Inicio : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Inicio())
                        + "   Fecha Fin : "+Herramienta.formatoFechaMas1(objSemestre.getFecha_Fin()));              
            }
            objServicioFarmacia.ConsultaBD();
            objServicioFarmacia.principalEjecucion();
            objCrear_Estudiante.ConsultaBD();
            objCrear_Estudiante.principalEjecucion();
        }else{
            jlblSemestre.setText("NO HAY UN SEMESTRE ACTIVO");
            objServicioFarmacia.ConsultaBD();
            objServicioFarmacia.principalEjecucion();
            objCrear_Estudiante.ConsultaBD();
            objCrear_Estudiante.principalEjecucion();
        }
   }
   private Semestre objSemestre;
   EntityManager jpa;
   private Usuario user;
   private ServicioFarmacia objServicioFarmacia;
   private Entrega_del_dia objBusquedaVentas;
   private Detalle_Inventario objDetalle_Inventario;
   private LlenarInventario objLlenarInventario;
   private Ver_inventario objVer_inventario;
   private CrearMedicamento objCrearMedicamento;
   private CrearUsuario objCrearUsuario;
   private ModificarUsuario objModificarUsuario;
   private Crear_Estudiante objCrear_Estudiante;
   private Entrega_del_dia objEntragEntrega_del_dia;
   private Modificar_Estudiante objModificar_Estudiante;
   private Reporte_Por_Escuela objReporte_Por_Escuela;
   private Reporte_Diagnostico objReporte_Diagnostico;
   private ProveedorLaboratorio objProveedorLaboratorio;
   private ModificarMedicamento objModificarMedicamento;
   private Reporte_Condicion objReporte_Condicion;
   private Servicio_Asistencial objServicio_Asistencial;
   private Abrir_Inventario objAbrir_Inventario;
   private Cerrar_Inventario objCerrar_Inventario;
   private Reporte_Por_Escuela_AtendidosBotica objReporte_Por_Escuela_AtendidosBotica;
   private Crear_Tarifario objCrear_Tarifario;
   private Modificar_Tarifario objModificar_Tarifario;
   private Descargo objDescargo;
   private Reporte_de_insumos objReporte_de_insumos;
   private Inicio objInicio;
   
   
   private Color colorMoved=new Color(4,20,25);
   private Color colorExitSub=new Color(73,20,100);
   private Color colorExit=new Color(73,25,119);
   public Principal(EntityManager OBJjpa,Usuario OBJuser){
       initComponents();
       
       File objFile=new File("Carpeta_de_Archivos");
        if (!objFile.exists()){
            if (objFile.mkdirs()) {
                JOptionPane.showMessageDialog(jLabel12, "Parece que borraron la Carpeta, Volviendo a Crear, Pero no se Recuperará los Archivos");
            } else {
                JOptionPane.showMessageDialog(jLabel12, "Error al crear Directorio");
            }
        }
       this.jpa=OBJjpa;
       actulizarPeriodo();
       List<Semestre> lis=jpa.createQuery("SELECT p from Semestre p where fecha_fin_Real is null").getResultList();  
        if(!lis.isEmpty()){
            jbtnCerrarSemestre.setEnabled(true);
            jlblAdvertencia.setText("Semestre Vigente");
            objSemestreF=lis.get(0);  
            jcbDateInicio.setDatoFecha(objSemestreF.getFecha_Inicio());
            jcbDateFin.setDatoFecha(objSemestreF.getFecha_Fin());
            jbtnGuardar.setText("GUARDAR CAMBIOS");
            if(objSemestreF.isSemestre_periodo()){
                jcbPeriodoSemestre.setSelectedItem("II");
            }
            else{
                jcbPeriodoSemestre.setSelectedItem("I");                
            }
        }
        else{
            jbtnCerrarSemestre.setEnabled(false);
            jlblAdvertencia.setText("");
            objSemestreF=new Semestre();
        }
       
       this.user=OBJuser;
       this.objReporte_de_insumos=new Reporte_de_insumos(OBJjpa, this);
       this.objServicio_Asistencial=new Servicio_Asistencial(OBJjpa, this, OBJuser);
       this.objProveedorLaboratorio=new ProveedorLaboratorio(OBJjpa, this);
       this.objReporte_Diagnostico=new Reporte_Diagnostico(OBJjpa, this);
       this.objEntragEntrega_del_dia=new Entrega_del_dia(OBJjpa);
       this.objCrearMedicamento=new CrearMedicamento(OBJjpa, this);
       this.objServicioFarmacia=new ServicioFarmacia(OBJjpa,this, OBJuser);
       this.objBusquedaVentas=new Entrega_del_dia(OBJjpa);
       this.objLlenarInventario=new LlenarInventario(OBJjpa, this);
       this.objDetalle_Inventario=new Detalle_Inventario(OBJjpa,this);
       this.objVer_inventario=new Ver_inventario(OBJjpa, this);
       this.objCrearUsuario=new CrearUsuario(OBJjpa, this,OBJuser);
       this.objModificarUsuario=new ModificarUsuario(OBJjpa, this,OBJuser);
       this.objCrear_Estudiante=new Crear_Estudiante(OBJjpa, this);
       this.objModificar_Estudiante=new Modificar_Estudiante(OBJjpa, this);
       this.objReporte_Por_Escuela=new Reporte_Por_Escuela(OBJjpa, this);
       this.objModificarMedicamento=new ModificarMedicamento(OBJjpa, this);
       this.objReporte_Condicion=new Reporte_Condicion(OBJjpa, this);
       this.objAbrir_Inventario=new Abrir_Inventario(OBJjpa, this, OBJuser);
       this.objCerrar_Inventario=new Cerrar_Inventario(OBJjpa, this, OBJuser);
       this.objReporte_Por_Escuela_AtendidosBotica=new Reporte_Por_Escuela_AtendidosBotica(OBJjpa, this);
       this.objCrear_Tarifario=new Crear_Tarifario(OBJjpa);
       this.objModificar_Tarifario=new Modificar_Tarifario(OBJjpa);
       this.objDescargo=new Descargo(OBJjpa,user,this);
       this.objInicio=new Inicio(OBJjpa,OBJuser,objSemestreF);
       
       this.setLocationRelativeTo(null);
       jlblUsuario.setText(user.getPersona().getInfoPersona());
       bodyContenedor.add(objBusquedaVentas);//1  
       bodyContenedor.validate();
       bodyContenedor.add(objServicioFarmacia);//2  
       bodyContenedor.validate();
       bodyContenedor.add(objCrear_Estudiante);//3
       bodyContenedor.validate();
       bodyContenedor.add(objDetalle_Inventario);//4
       bodyContenedor.validate();
       bodyContenedor.add(objLlenarInventario);//5
       bodyContenedor.validate();
       bodyContenedor.add(objVer_inventario);//6
       bodyContenedor.validate();
       bodyContenedor.add(objCrearMedicamento);//7
       bodyContenedor.validate();
       bodyContenedor.add(objCrearUsuario);//8
       bodyContenedor.validate();
       bodyContenedor.add(objModificarUsuario);//9
       bodyContenedor.validate();
       bodyContenedor.add(objEntragEntrega_del_dia);//10
       bodyContenedor.validate();
       bodyContenedor.add(objModificar_Estudiante);//11
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Por_Escuela);//12
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Diagnostico);//13
       bodyContenedor.validate();
       bodyContenedor.add(objProveedorLaboratorio);//14
       bodyContenedor.validate();
       bodyContenedor.add(objModificarMedicamento);//15
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Condicion);//16
       bodyContenedor.validate();
       bodyContenedor.add(objServicio_Asistencial);//17
       bodyContenedor.validate();
       bodyContenedor.add(objAbrir_Inventario);//18
       bodyContenedor.validate();
       bodyContenedor.add(objCerrar_Inventario);//19
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_Por_Escuela_AtendidosBotica);//20
       bodyContenedor.validate();
       bodyContenedor.add(objCrear_Tarifario);//21
       bodyContenedor.validate();
       bodyContenedor.add(objModificar_Tarifario);//22
       bodyContenedor.validate();
       bodyContenedor.add(objDescargo);//23
       bodyContenedor.validate();
       bodyContenedor.add(objReporte_de_insumos);//24
       bodyContenedor.validate();
       bodyContenedor.add(objInicio);//25
       bodyContenedor.validate();
       
       
       setIconImage(new ImageIcon(getClass().getResource("/images/014-pharmacy.png")).getImage());
       if(OBJuser.getRol().getNombre_rol().equals("ADMINISTRADOR.QF")){   
           auxFarmacia=true;
           jleftTarifario.setVisible(false);
           jleftServicioAsistencial.setVisible(false);
           new Proceso().start();
           }
       
       if(OBJuser.getRol().getNombre_rol().equals("TÉCNICO")){
           jleftServicioAsistencial.setVisible(false);
           jleftTarifario.setVisible(false);
           jleftMedicamento.setVisible(false);
           jleftConsultas.setVisible(false);
           jleftUsuario.setVisible(false);
           jleftInventario_AbrirInventario.setVisible(false);
           jleftInventario_CerrarInventario.setVisible(false);
           jleftProveedorYfabricante.setVisible(false);
           jleftInventario_llenarInventario.setVisible(false);
           jleftInventario_detalleInventario.setVisible(false);   
           jtfsub_inventario.setPreferredSize(new Dimension(300, 81)); 
           new Proceso().start();
       }
       
       if(OBJuser.getRol().getNombre_rol().equals("ASISTENCIAL")){
           setIconImage(new ImageIcon(getClass().getResource("/images/informacion.png")).getImage());
           jlblRolcito.setText("Trabajadora Social:");
           jleftServicioFarmacia.setVisible(false);
           jleftMedicamento.setVisible(false);
           //jleftEstudiante.setVisible(true);
           jleftConsultas.setVisible(false);
           //jleftUsuario.setVisible(true);
           jleftInventario.setVisible(false);
           jleftProveedorYfabricante.setVisible(false);
           jleftInventario_llenarInventario.setVisible(false);
           jleftInventario_detalleInventario.setVisible(false);   
       }
       else{           
           
       }
       //bodyContenedor.setVisible(true);  
       jtfsub_Usuario.setVisible(false);
       objModificarMedicamento.setVisible(false);//15
       objProveedorLaboratorio.setVisible(false);//14
       objVer_inventario.setVisible(false);
       objDetalle_Inventario.setVisible(false);
       objCrear_Estudiante.setVisible(false);        
       objBusquedaVentas.setVisible(false);
       objServicioFarmacia.setVisible(false);
       objCrearMedicamento.setVisible(false);
       objCrearUsuario.setVisible(false);
       objModificarUsuario.setVisible(false);
       objEntragEntrega_del_dia.setVisible(false);
       objModificar_Estudiante.setVisible(false);
       objReporte_Por_Escuela.setVisible(false);
       objReporte_Diagnostico.setVisible(false);
       objDescargo.setVisible(false);//23
       objServicio_Asistencial.setVisible(false);//17
       objReporte_Condicion.setVisible(false);//16
       objAbrir_Inventario.setVisible(false);//18
       objCrear_Tarifario.setVisible(false);//19
       objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
       objCerrar_Inventario.setVisible(false);
       objModificar_Tarifario.setVisible(false);
       objReporte_de_insumos.setVisible(false);
       objLlenarInventario.setVisible(false);
       //objInicio.ConsultaBD();
       //objInicio.principalEjecucion();
       objInicio.setVisible(true);
       
       jtfsub_inventario.setVisible(false);
       jtfsub_Consultas.setVisible(false);    
       jtfsub_Medicina.setVisible(false);
       jtfsub_Estudiante.setVisible(false);
       jtfsub_Tarifario.setVisible(false);
       
       }
   @SuppressWarnings("unchecked")
   public void actualizar_Usuario(Usuario objUser){
       if(user==objUser){
           jlblUsuario.setText(objUser.getPersona().getInfoPersona());
           }
       }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdialogCarga = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        carga = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jlblHead1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlblMensaje3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jListaMedicamentosVencidos = new javax.swing.JDialog();
        contenedor = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jbtnAgregar = new javax.swing.JButton();
        head1 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jbtlVencidos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblPorVencer = new javax.swing.JTable();
        jlblVencidos = new javax.swing.JLabel();
        jlblPorvencer = new javax.swing.JLabel();
        jdialogSemestreAtecion = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        contenedor1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jlblSerie = new javax.swing.JLabel();
        jbtnCerrarSemestre = new javax.swing.JButton();
        jlblEscuela = new javax.swing.JLabel();
        head2 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jlblNombre1 = new javax.swing.JLabel();
        jlblEstCodigo = new javax.swing.JLabel();
        jlblCondicion1 = new javax.swing.JLabel();
        jcbPeriodoSemestre = new javax.swing.JComboBox<>();
        jcbDateFin = new rojeru_san.componentes.RSDateChooser();
        jcbDateInicio = new rojeru_san.componentes.RSDateChooser();
        jbtnSalir = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jlblAdvertencia = new javax.swing.JLabel();
        contenedorPrincipal = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlblRolcito = new javax.swing.JLabel();
        jlblUsuario = new javax.swing.JLabel();
        jlblSemestre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlblSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jlblAlertaMedicamentosVencidos = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        jleftInicio = new javax.swing.JPanel();
        INICIO = new javax.swing.JLabel();
        ImagInicio = new javax.swing.JLabel();
        jleftServicioFarmacia = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jleftServicioAsistencial = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jleftTarifario = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jlblTarifarioFlecha = new javax.swing.JLabel();
        jtfsub_Tarifario = new javax.swing.JPanel();
        jleftTarifario_Crear = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jleftTarifario_Modificar = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jleftInventario = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblInventarioFlecha = new javax.swing.JLabel();
        jtfsub_inventario = new javax.swing.JPanel();
        jleftInventario_verInventario = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jleftInventario_llenarInventario = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jleftInventario_AbrirInventario = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jleftInventario_CerrarInventario = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jleftInventario_Descargo = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jleftInventario_detalleInventario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jleftMedicamento = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlblConsultasFlecha1 = new javax.swing.JLabel();
        jtfsub_Medicina = new javax.swing.JPanel();
        jleftMedicina_CrearMedicamento = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jleftMedicina_ModificarMedicamento = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jleftConsultas_MedicamentoUsado = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jleftEstudiante = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblEstudianteFlecha1 = new javax.swing.JLabel();
        jtfsub_Estudiante = new javax.swing.JPanel();
        jleftEstudiante_CrearModificarEstudiante = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jleftEstudiante_Modificar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jleftConsultas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblConsultasFlecha = new javax.swing.JLabel();
        jtfsub_Consultas = new javax.swing.JPanel();
        jleftConsultas_Entregadeldia = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jleftConsultas_ReportePorEscuela = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jleftConsultas_ReportedelMes = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jleftConsultas_Reporte_Condicion = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jleftConsultas_ReportePorEscuelaxAlumno = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jleftConsultas_Reporte_Insumo = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jleftUsuario = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblUsuarioFlecha = new javax.swing.JLabel();
        jtfsub_Usuario = new javax.swing.JPanel();
        jleftUsuario_CrearModificarUser = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jleftUsuario_AdministrarRol = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jleftProveedorYfabricante = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        bodyContenedor = new javax.swing.JPanel();

        jdialogCarga.setMinimumSize(new java.awt.Dimension(350, 250));
        jdialogCarga.setModal(true);
        jdialogCarga.setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(255, 251, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setMaximumSize(new java.awt.Dimension(100, 176));
        jPanel6.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel6.setLayout(new java.awt.CardLayout());

        carga.setBackground(new java.awt.Color(255, 255, 255));
        carga.setMaximumSize(new java.awt.Dimension(700, 300));
        carga.setMinimumSize(new java.awt.Dimension(700, 300));
        carga.setName(""); // NOI18N
        carga.setPreferredSize(new java.awt.Dimension(700, 300));
        carga.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(0, 193, 151));
        jPanel10.setForeground(new java.awt.Color(0, 193, 151));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 40));

        jlblHead1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblHead1.setText("Espere porfavor...");
        jPanel10.add(jlblHead1);

        carga.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jlblMensaje3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblMensaje3.setText("cerrando el inventario");
        jPanel11.add(jlblMensaje3);

        carga.add(jPanel11, java.awt.BorderLayout.PAGE_END);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cargando2.gif"))); // NOI18N
        jPanel12.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 5, 320, 160));

        carga.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel6.add(carga, "card3");

        jdialogCarga.getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jListaMedicamentosVencidos.setMinimumSize(new java.awt.Dimension(350, 250));
        jListaMedicamentosVencidos.setModal(true);
        jListaMedicamentosVencidos.setUndecorated(true);

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedor.setMaximumSize(new java.awt.Dimension(700, 300));
        contenedor.setMinimumSize(new java.awt.Dimension(700, 300));
        contenedor.setName(""); // NOI18N
        contenedor.setPreferredSize(new java.awt.Dimension(700, 300));
        contenedor.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(700, 345));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar.setText("OK");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 316, 210, -1));

        head1.setBackground(new java.awt.Color(204, 0, 0));
        head1.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel42.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("LISTA DE MEDICAMENTOS VENCIDOS Y POR VENCER");
        jLabel42.setPreferredSize(new java.awt.Dimension(900, 30));
        head1.add(jLabel42);

        jPanel8.add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 40));

        jbtlVencidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jbtlVencidos);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 660, 100));

        jtblPorVencer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtblPorVencer);

        jPanel8.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 660, 100));

        jlblVencidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblVencidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblVencidos.setText("VENCIDOS:");
        jPanel8.add(jlblVencidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 180, 700, 25));

        jlblPorvencer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblPorvencer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPorvencer.setText("POR VENCER:");
        jPanel8.add(jlblPorvencer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 700, 25));

        contenedor.add(jPanel8, java.awt.BorderLayout.CENTER);

        jListaMedicamentosVencidos.getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        jdialogSemestreAtecion.setMinimumSize(new java.awt.Dimension(350, 250));
        jdialogSemestreAtecion.setModal(true);
        jdialogSemestreAtecion.setUndecorated(true);

        jPanel7.setBackground(new java.awt.Color(255, 251, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setMaximumSize(new java.awt.Dimension(100, 176));
        jPanel7.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel7.setLayout(new java.awt.BorderLayout());

        contenedor1.setBackground(new java.awt.Color(255, 255, 255));
        contenedor1.setMaximumSize(new java.awt.Dimension(700, 300));
        contenedor1.setMinimumSize(new java.awt.Dimension(700, 300));
        contenedor1.setName(""); // NOI18N
        contenedor1.setPreferredSize(new java.awt.Dimension(700, 300));
        contenedor1.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(700, 345));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setText("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        jLabel43.setPreferredSize(new java.awt.Dimension(700, 14));
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 680, 10));

        jlblSerie.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblSerie.setText("SEMESTRE:");
        jlblSerie.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel9.add(jlblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 80, 25));

        jbtnCerrarSemestre.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCerrarSemestre.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCerrarSemestre.setText("FINALIZAR SEMESTRE REAL");
        jbtnCerrarSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarSemestreActionPerformed(evt);
            }
        });
        jPanel9.add(jbtnCerrarSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 230, -1));

        jlblEscuela.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblEscuela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEscuela.setText("FECHA FIN:");
        jlblEscuela.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel9.add(jlblEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, 25));

        head2.setBackground(new java.awt.Color(0, 153, 102));
        head2.setPreferredSize(new java.awt.Dimension(900, 70));

        jLabel44.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText(" Semestre de Atención");
        jLabel44.setPreferredSize(new java.awt.Dimension(900, 70));
        head2.add(jLabel44);

        jPanel9.add(head2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jlblNombre1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblNombre1.setText("FECHA INICIO:");
        jlblNombre1.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel9.add(jlblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 25));

        jlblEstCodigo.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 20)); // NOI18N
        jlblEstCodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblEstCodigo.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel9.add(jlblEstCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 150, 25));

        jlblCondicion1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jlblCondicion1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblCondicion1.setText("2020");
        jlblCondicion1.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel9.add(jlblCondicion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 40, 25));

        jcbPeriodoSemestre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbPeriodoSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I", "II" }));
        jcbPeriodoSemestre.setPreferredSize(new java.awt.Dimension(56, 25));
        jPanel9.add(jcbPeriodoSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 50, -1));

        jcbDateFin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel9.add(jcbDateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 160, 25));
        jPanel9.add(jcbDateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, 25));

        jbtnSalir.setBackground(new java.awt.Color(0, 0, 0));
        jbtnSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSalir.setText("SALIR");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel9.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 160, -1));

        jbtnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardar.setText("GUARDAR");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel9.add(jbtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 160, -1));

        jlblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAdvertencia.setText("Semestre vigente");
        jPanel9.add(jlblAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 700, 20));

        contenedor1.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel7.add(contenedor1, java.awt.BorderLayout.CENTER);

        jdialogSemestreAtecion.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setUndecorated(true);
        setResizable(false);

        contenedorPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenedorPrincipal.setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(240, 0, 0));
        head.setPreferredSize(new java.awt.Dimension(694, 80));
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(57, 23, 71));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(57, 23, 71));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FARMACIA-UNSCH");
        jLabel4.setPreferredSize(new java.awt.Dimension(196, 50));
        jPanel3.add(jLabel4, java.awt.BorderLayout.CENTER);

        head.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jPanel4.setBackground(new java.awt.Color(236, 230, 230));
        jPanel4.setPreferredSize(new java.awt.Dimension(669, 1000));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblRolcito.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jlblRolcito.setText("Química(o) Farmacéutica(o):");
        jlblRolcito.setMaximumSize(new java.awt.Dimension(990, 14));
        jlblRolcito.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel4.add(jlblRolcito, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, -1, -1));

        jlblUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlblUsuario.setPreferredSize(new java.awt.Dimension(640, 50));
        jPanel4.add(jlblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 5, 430, -1));

        jlblSemestre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSemestre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblSemestre.setText("Semestre 2020-I                   inicio: 2020 Febrero 02                     fin: ??");
        jlblSemestre.setPreferredSize(new java.awt.Dimension(900, 19));
        jlblSemestre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlblSemestreMouseMoved(evt);
            }
        });
        jlblSemestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSemestreMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlblSemestreMouseExited(evt);
            }
        });
        jPanel4.add(jlblSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 500, -1));

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new java.awt.BorderLayout());

        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0002-salida.png"))); // NOI18N
        jlblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSalirMouseClicked(evt);
            }
        });
        jPanel1.add(jlblSalir, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 7, 32, 32));

        jPanel2.setBackground(new java.awt.Color(230, 230, 230));
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

        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0001-minimizar.png"))); // NOI18N
        jlblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizarMouseClicked(evt);
            }
        });
        jPanel2.add(jlblMinimizar, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 7, 32, 32));

        jPanel5.setBackground(new java.awt.Color(230, 230, 230));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jlblAlertaMedicamentosVencidos.setForeground(new java.awt.Color(230, 230, 230));
        jlblAlertaMedicamentosVencidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAlertaMedicamentosVencidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/015-warning.png"))); // NOI18N
        jlblAlertaMedicamentosVencidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblAlertaMedicamentosVencidosMouseClicked(evt);
            }
        });
        jPanel5.add(jlblAlertaMedicamentosVencidos, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 7, 32, 32));

        head.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 900, 80));

        contenedorPrincipal.add(head, java.awt.BorderLayout.PAGE_START);

        left.setBackground(new java.awt.Color(73, 25, 119));
        left.setPreferredSize(new java.awt.Dimension(300, 485));

        jleftInicio.setBackground(new java.awt.Color(73, 20, 119));
        jleftInicio.setPreferredSize(new java.awt.Dimension(300, 33));
        jleftInicio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInicioMouseMoved(evt);
            }
        });
        jleftInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInicioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInicioMouseExited(evt);
            }
        });
        jleftInicio.setLayout(new java.awt.BorderLayout());

        INICIO.setBackground(new java.awt.Color(153, 0, 153));
        INICIO.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        INICIO.setForeground(new java.awt.Color(255, 255, 255));
        INICIO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        INICIO.setText("     INICIO");
        INICIO.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftInicio.add(INICIO, java.awt.BorderLayout.CENTER);

        ImagInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/017-real-estate.png"))); // NOI18N
        ImagInicio.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftInicio.add(ImagInicio, java.awt.BorderLayout.LINE_START);

        left.add(jleftInicio);

        jleftServicioFarmacia.setBackground(new java.awt.Color(73, 20, 119));
        jleftServicioFarmacia.setPreferredSize(new java.awt.Dimension(300, 33));
        jleftServicioFarmacia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftServicioFarmaciaMouseMoved(evt);
            }
        });
        jleftServicioFarmacia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftServicioFarmaciaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftServicioFarmaciaMouseExited(evt);
            }
        });
        jleftServicioFarmacia.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(153, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Servicio Farmacia");
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftServicioFarmacia.add(jLabel6, java.awt.BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/009-drug.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftServicioFarmacia.add(jLabel2, java.awt.BorderLayout.LINE_START);

        left.add(jleftServicioFarmacia);

        jleftServicioAsistencial.setBackground(new java.awt.Color(73, 20, 119));
        jleftServicioAsistencial.setPreferredSize(new java.awt.Dimension(300, 33));
        jleftServicioAsistencial.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftServicioAsistencialMouseMoved(evt);
            }
        });
        jleftServicioAsistencial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftServicioAsistencialMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftServicioAsistencialMouseExited(evt);
            }
        });
        jleftServicioAsistencial.setLayout(new java.awt.BorderLayout());

        jLabel29.setBackground(new java.awt.Color(153, 0, 153));
        jLabel29.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Servicio Social (110)");
        jLabel29.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftServicioAsistencial.add(jLabel29, java.awt.BorderLayout.CENTER);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/009-drug.png"))); // NOI18N
        jLabel32.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftServicioAsistencial.add(jLabel32, java.awt.BorderLayout.LINE_START);

        left.add(jleftServicioAsistencial);

        jleftTarifario.setBackground(new java.awt.Color(73, 20, 119));
        jleftTarifario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftTarifario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftTarifarioMouseMoved(evt);
            }
        });
        jleftTarifario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftTarifarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftTarifarioMouseExited(evt);
            }
        });
        jleftTarifario.setLayout(new java.awt.BorderLayout());

        jLabel36.setBackground(new java.awt.Color(153, 0, 153));
        jLabel36.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Tarifario");
        jLabel36.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftTarifario.add(jLabel36, java.awt.BorderLayout.CENTER);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jefe.png"))); // NOI18N
        jLabel37.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftTarifario.add(jLabel37, java.awt.BorderLayout.LINE_START);

        jlblTarifarioFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTarifarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblTarifarioFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblTarifarioFlecha.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftTarifario.add(jlblTarifarioFlecha, java.awt.BorderLayout.LINE_END);

        left.add(jleftTarifario);

        jtfsub_Tarifario.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Tarifario.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftTarifario_Crear.setBackground(new java.awt.Color(73, 20, 100));
        jleftTarifario_Crear.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftTarifario_Crear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftTarifario_CrearMouseMoved(evt);
            }
        });
        jleftTarifario_Crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftTarifario_CrearMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftTarifario_CrearMouseExited(evt);
            }
        });
        jleftTarifario_Crear.setLayout(new java.awt.BorderLayout());

        jLabel38.setBackground(new java.awt.Color(153, 0, 153));
        jLabel38.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Crear");
        jLabel38.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftTarifario_Crear.add(jLabel38, java.awt.BorderLayout.CENTER);

        jtfsub_Tarifario.add(jleftTarifario_Crear);

        jleftTarifario_Modificar.setBackground(new java.awt.Color(73, 20, 100));
        jleftTarifario_Modificar.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftTarifario_Modificar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftTarifario_ModificarMouseMoved(evt);
            }
        });
        jleftTarifario_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftTarifario_ModificarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftTarifario_ModificarMouseExited(evt);
            }
        });
        jleftTarifario_Modificar.setLayout(new java.awt.BorderLayout());

        jLabel39.setBackground(new java.awt.Color(153, 0, 153));
        jLabel39.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Modificar");
        jLabel39.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftTarifario_Modificar.add(jLabel39, java.awt.BorderLayout.CENTER);

        jtfsub_Tarifario.add(jleftTarifario_Modificar);

        left.add(jtfsub_Tarifario);

        jleftInventario.setBackground(new java.awt.Color(73, 20, 119));
        jleftInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventarioMouseMoved(evt);
            }
        });
        jleftInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventarioMouseExited(evt);
            }
        });
        jleftInventario.setLayout(new java.awt.BorderLayout());

        jLabel10.setBackground(new java.awt.Color(153, 0, 153));
        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Inventario");
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 50));
        jleftInventario.add(jLabel10, java.awt.BorderLayout.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001-inventory.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftInventario.add(jLabel1, java.awt.BorderLayout.LINE_START);

        jlblInventarioFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblInventarioFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblInventarioFlecha.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftInventario.add(jlblInventarioFlecha, java.awt.BorderLayout.LINE_END);

        left.add(jleftInventario);

        jtfsub_inventario.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_inventario.setPreferredSize(new java.awt.Dimension(300, 240));

        jleftInventario_verInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_verInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_verInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_verInventarioMouseMoved(evt);
            }
        });
        jleftInventario_verInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_verInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_verInventarioMouseExited(evt);
            }
        });
        jleftInventario_verInventario.setLayout(new java.awt.BorderLayout());

        jLabel22.setBackground(new java.awt.Color(153, 0, 153));
        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Consulta");
        jLabel22.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_verInventario.add(jLabel22, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_verInventario);

        jleftInventario_llenarInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_llenarInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_llenarInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseMoved(evt);
            }
        });
        jleftInventario_llenarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_llenarInventarioMouseExited(evt);
            }
        });
        jleftInventario_llenarInventario.setLayout(new java.awt.BorderLayout());

        jLabel13.setBackground(new java.awt.Color(153, 0, 153));
        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Ingresar Producto");
        jLabel13.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_llenarInventario.add(jLabel13, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_llenarInventario);

        jleftInventario_AbrirInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_AbrirInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_AbrirInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_AbrirInventarioMouseMoved(evt);
            }
        });
        jleftInventario_AbrirInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_AbrirInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_AbrirInventarioMouseExited(evt);
            }
        });
        jleftInventario_AbrirInventario.setLayout(new java.awt.BorderLayout());

        jLabel33.setBackground(new java.awt.Color(153, 0, 153));
        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Abrir Inventario");
        jLabel33.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_AbrirInventario.add(jLabel33, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_AbrirInventario);

        jleftInventario_CerrarInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_CerrarInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_CerrarInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_CerrarInventarioMouseMoved(evt);
            }
        });
        jleftInventario_CerrarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_CerrarInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_CerrarInventarioMouseExited(evt);
            }
        });
        jleftInventario_CerrarInventario.setLayout(new java.awt.BorderLayout());

        jLabel34.setBackground(new java.awt.Color(153, 0, 153));
        jLabel34.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Cerrar Inventario");
        jLabel34.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_CerrarInventario.add(jLabel34, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_CerrarInventario);

        jleftInventario_Descargo.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_Descargo.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_Descargo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_DescargoMouseMoved(evt);
            }
        });
        jleftInventario_Descargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_DescargoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_DescargoMouseExited(evt);
            }
        });
        jleftInventario_Descargo.setLayout(new java.awt.BorderLayout());

        jLabel40.setBackground(new java.awt.Color(153, 0, 153));
        jLabel40.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Descargo");
        jLabel40.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_Descargo.add(jLabel40, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_Descargo);

        jleftInventario_detalleInventario.setBackground(new java.awt.Color(73, 20, 100));
        jleftInventario_detalleInventario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftInventario_detalleInventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseMoved(evt);
            }
        });
        jleftInventario_detalleInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftInventario_detalleInventarioMouseExited(evt);
            }
        });
        jleftInventario_detalleInventario.setLayout(new java.awt.BorderLayout());

        jLabel14.setBackground(new java.awt.Color(153, 0, 153));
        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Llenado Detallado(prueba)");
        jLabel14.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftInventario_detalleInventario.add(jLabel14, java.awt.BorderLayout.CENTER);

        jtfsub_inventario.add(jleftInventario_detalleInventario);

        left.add(jtfsub_inventario);

        jleftMedicamento.setBackground(new java.awt.Color(73, 20, 119));
        jleftMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicamentoMouseExited(evt);
            }
        });
        jleftMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel15.setBackground(new java.awt.Color(153, 0, 153));
        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Medicamento");
        jLabel15.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftMedicamento.add(jLabel15, java.awt.BorderLayout.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/002-medicine.png"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftMedicamento.add(jLabel8, java.awt.BorderLayout.LINE_START);

        jlblConsultasFlecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblConsultasFlecha1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha1.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftMedicamento.add(jlblConsultasFlecha1, java.awt.BorderLayout.LINE_END);

        left.add(jleftMedicamento);

        jtfsub_Medicina.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Medicina.setPreferredSize(new java.awt.Dimension(300, 120));
        jtfsub_Medicina.setRequestFocusEnabled(false);

        jleftMedicina_CrearMedicamento.setBackground(new java.awt.Color(73, 20, 100));
        jleftMedicina_CrearMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicina_CrearMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicina_CrearMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicina_CrearMedicamentoMouseExited(evt);
            }
        });
        jleftMedicina_CrearMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel20.setBackground(new java.awt.Color(153, 0, 153));
        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Crear Medicamento");
        jLabel20.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftMedicina_CrearMedicamento.add(jLabel20, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftMedicina_CrearMedicamento);

        jleftMedicina_ModificarMedicamento.setBackground(new java.awt.Color(73, 20, 100));
        jleftMedicina_ModificarMedicamento.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftMedicina_ModificarMedicamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftMedicina_ModificarMedicamentoMouseMoved(evt);
            }
        });
        jleftMedicina_ModificarMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftMedicina_ModificarMedicamentoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftMedicina_ModificarMedicamentoMouseExited(evt);
            }
        });
        jleftMedicina_ModificarMedicamento.setLayout(new java.awt.BorderLayout());

        jLabel28.setBackground(new java.awt.Color(153, 0, 153));
        jLabel28.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Modificar Medicamento");
        jLabel28.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftMedicina_ModificarMedicamento.add(jLabel28, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftMedicina_ModificarMedicamento);

        jleftConsultas_MedicamentoUsado.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_MedicamentoUsado.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_MedicamentoUsado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_MedicamentoUsadoMouseMoved(evt);
            }
        });
        jleftConsultas_MedicamentoUsado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_MedicamentoUsadoMouseExited(evt);
            }
        });
        jleftConsultas_MedicamentoUsado.setLayout(new java.awt.BorderLayout());

        jLabel21.setBackground(new java.awt.Color(153, 0, 153));
        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Medicamento Mas Usado(Prueba)");
        jLabel21.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_MedicamentoUsado.add(jLabel21, java.awt.BorderLayout.CENTER);

        jtfsub_Medicina.add(jleftConsultas_MedicamentoUsado);

        left.add(jtfsub_Medicina);

        jleftEstudiante.setBackground(new java.awt.Color(73, 20, 119));
        jleftEstudiante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudianteMouseMoved(evt);
            }
        });
        jleftEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEstudianteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudianteMouseExited(evt);
            }
        });
        jleftEstudiante.setLayout(new java.awt.BorderLayout());

        jLabel12.setBackground(new java.awt.Color(153, 0, 153));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Estudiante");
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftEstudiante.add(jLabel12, java.awt.BorderLayout.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/004-student.png"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftEstudiante.add(jLabel7, java.awt.BorderLayout.LINE_START);

        jlblEstudianteFlecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblEstudianteFlecha1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblEstudianteFlecha1.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftEstudiante.add(jlblEstudianteFlecha1, java.awt.BorderLayout.LINE_END);

        left.add(jleftEstudiante);

        jtfsub_Estudiante.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Estudiante.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftEstudiante_CrearModificarEstudiante.setBackground(new java.awt.Color(73, 20, 100));
        jleftEstudiante_CrearModificarEstudiante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante_CrearModificarEstudiante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseMoved(evt);
            }
        });
        jleftEstudiante_CrearModificarEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudiante_CrearModificarEstudianteMouseExited(evt);
            }
        });
        jleftEstudiante_CrearModificarEstudiante.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(153, 0, 153));
        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Crear Estudiante");
        jLabel18.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEstudiante_CrearModificarEstudiante.add(jLabel18, java.awt.BorderLayout.CENTER);

        jtfsub_Estudiante.add(jleftEstudiante_CrearModificarEstudiante);

        jleftEstudiante_Modificar.setBackground(new java.awt.Color(73, 20, 100));
        jleftEstudiante_Modificar.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftEstudiante_Modificar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftEstudiante_ModificarMouseMoved(evt);
            }
        });
        jleftEstudiante_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftEstudiante_ModificarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftEstudiante_ModificarMouseExited(evt);
            }
        });
        jleftEstudiante_Modificar.setLayout(new java.awt.BorderLayout());

        jLabel19.setBackground(new java.awt.Color(153, 0, 153));
        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Modificar Estudiante");
        jLabel19.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftEstudiante_Modificar.add(jLabel19, java.awt.BorderLayout.CENTER);

        jtfsub_Estudiante.add(jleftEstudiante_Modificar);

        left.add(jtfsub_Estudiante);

        jleftConsultas.setBackground(new java.awt.Color(73, 20, 119));
        jleftConsultas.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultasMouseMoved(evt);
            }
        });
        jleftConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultasMouseExited(evt);
            }
        });
        jleftConsultas.setLayout(new java.awt.BorderLayout());

        jLabel11.setBackground(new java.awt.Color(153, 0, 153));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Consultas ");
        jLabel11.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftConsultas.add(jLabel11, java.awt.BorderLayout.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/003-pros-and-cons.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftConsultas.add(jLabel3, java.awt.BorderLayout.LINE_START);

        jlblConsultasFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblConsultasFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblConsultasFlecha.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftConsultas.add(jlblConsultasFlecha, java.awt.BorderLayout.LINE_END);

        left.add(jleftConsultas);

        jtfsub_Consultas.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Consultas.setPreferredSize(new java.awt.Dimension(300, 240));

        jleftConsultas_Entregadeldia.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Entregadeldia.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_Entregadeldia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseMoved(evt);
            }
        });
        jleftConsultas_Entregadeldia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_EntregadeldiaMouseExited(evt);
            }
        });
        jleftConsultas_Entregadeldia.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(153, 0, 153));
        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Entrega del Día");
        jLabel16.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_Entregadeldia.add(jLabel16, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_Entregadeldia);

        jleftConsultas_ReportePorEscuela.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_ReportePorEscuela.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_ReportePorEscuela.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaMouseMoved(evt);
            }
        });
        jleftConsultas_ReportePorEscuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaMouseExited(evt);
            }
        });
        jleftConsultas_ReportePorEscuela.setLayout(new java.awt.BorderLayout());

        jLabel30.setBackground(new java.awt.Color(153, 0, 153));
        jLabel30.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Reporte por Escuela");
        jLabel30.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_ReportePorEscuela.add(jLabel30, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_ReportePorEscuela);

        jleftConsultas_ReportedelMes.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_ReportedelMes.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_ReportedelMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseMoved(evt);
            }
        });
        jleftConsultas_ReportedelMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportedelMesMouseExited(evt);
            }
        });
        jleftConsultas_ReportedelMes.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(153, 0, 153));
        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Reportes_Diagnostico/Procedencia");
        jLabel17.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_ReportedelMes.add(jLabel17, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_ReportedelMes);

        jleftConsultas_Reporte_Condicion.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Reporte_Condicion.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_Reporte_Condicion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_CondicionMouseMoved(evt);
            }
        });
        jleftConsultas_Reporte_Condicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_CondicionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_CondicionMouseExited(evt);
            }
        });
        jleftConsultas_Reporte_Condicion.setLayout(new java.awt.BorderLayout());

        jLabel31.setBackground(new java.awt.Color(153, 0, 153));
        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Reporte por Condicion");
        jLabel31.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_Reporte_Condicion.add(jLabel31, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_Reporte_Condicion);

        jleftConsultas_ReportePorEscuelaxAlumno.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_ReportePorEscuelaxAlumno.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_ReportePorEscuelaxAlumno.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaxAlumnoMouseMoved(evt);
            }
        });
        jleftConsultas_ReportePorEscuelaxAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaxAlumnoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_ReportePorEscuelaxAlumnoMouseExited(evt);
            }
        });
        jleftConsultas_ReportePorEscuelaxAlumno.setLayout(new java.awt.BorderLayout());

        jLabel35.setBackground(new java.awt.Color(153, 0, 153));
        jLabel35.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Reporte por Escuela por Atendidos");
        jLabel35.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_ReportePorEscuelaxAlumno.add(jLabel35, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_ReportePorEscuelaxAlumno);

        jleftConsultas_Reporte_Insumo.setBackground(new java.awt.Color(73, 20, 100));
        jleftConsultas_Reporte_Insumo.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftConsultas_Reporte_Insumo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_InsumoMouseMoved(evt);
            }
        });
        jleftConsultas_Reporte_Insumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_InsumoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftConsultas_Reporte_InsumoMouseExited(evt);
            }
        });
        jleftConsultas_Reporte_Insumo.setLayout(new java.awt.BorderLayout());

        jLabel41.setBackground(new java.awt.Color(153, 0, 153));
        jLabel41.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Reporte de Insumos");
        jLabel41.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftConsultas_Reporte_Insumo.add(jLabel41, java.awt.BorderLayout.CENTER);

        jtfsub_Consultas.add(jleftConsultas_Reporte_Insumo);

        left.add(jtfsub_Consultas);

        jleftUsuario.setBackground(new java.awt.Color(73, 20, 119));
        jleftUsuario.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuarioMouseMoved(evt);
            }
        });
        jleftUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftUsuarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuarioMouseExited(evt);
            }
        });
        jleftUsuario.setLayout(new java.awt.BorderLayout());

        jLabel23.setBackground(new java.awt.Color(153, 0, 153));
        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Usuario");
        jLabel23.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftUsuario.add(jLabel23, java.awt.BorderLayout.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jefe.png"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftUsuario.add(jLabel9, java.awt.BorderLayout.LINE_START);

        jlblUsuarioFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblUsuarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png"))); // NOI18N
        jlblUsuarioFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlblUsuarioFlecha.setPreferredSize(new java.awt.Dimension(50, 32));
        jleftUsuario.add(jlblUsuarioFlecha, java.awt.BorderLayout.LINE_END);

        left.add(jleftUsuario);

        jtfsub_Usuario.setBackground(new java.awt.Color(73, 20, 100));
        jtfsub_Usuario.setPreferredSize(new java.awt.Dimension(300, 80));

        jleftUsuario_CrearModificarUser.setBackground(new java.awt.Color(73, 20, 100));
        jleftUsuario_CrearModificarUser.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario_CrearModificarUser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUserMouseMoved(evt);
            }
        });
        jleftUsuario_CrearModificarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUserMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuario_CrearModificarUserMouseExited(evt);
            }
        });
        jleftUsuario_CrearModificarUser.setLayout(new java.awt.BorderLayout());

        jLabel24.setBackground(new java.awt.Color(153, 0, 153));
        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Crear Usuario");
        jLabel24.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftUsuario_CrearModificarUser.add(jLabel24, java.awt.BorderLayout.CENTER);

        jtfsub_Usuario.add(jleftUsuario_CrearModificarUser);

        jleftUsuario_AdministrarRol.setBackground(new java.awt.Color(73, 20, 100));
        jleftUsuario_AdministrarRol.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftUsuario_AdministrarRol.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRolMouseMoved(evt);
            }
        });
        jleftUsuario_AdministrarRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRolMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftUsuario_AdministrarRolMouseExited(evt);
            }
        });
        jleftUsuario_AdministrarRol.setLayout(new java.awt.BorderLayout());

        jLabel25.setBackground(new java.awt.Color(153, 0, 153));
        jLabel25.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Modificar Usuario");
        jLabel25.setPreferredSize(new java.awt.Dimension(300, 50));
        jleftUsuario_AdministrarRol.add(jLabel25, java.awt.BorderLayout.CENTER);

        jtfsub_Usuario.add(jleftUsuario_AdministrarRol);

        left.add(jtfsub_Usuario);

        jleftProveedorYfabricante.setBackground(new java.awt.Color(73, 20, 119));
        jleftProveedorYfabricante.setPreferredSize(new java.awt.Dimension(300, 32));
        jleftProveedorYfabricante.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jleftProveedorYfabricanteMouseMoved(evt);
            }
        });
        jleftProveedorYfabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jleftProveedorYfabricanteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jleftProveedorYfabricanteMouseExited(evt);
            }
        });
        jleftProveedorYfabricante.setLayout(new java.awt.BorderLayout());

        jLabel26.setBackground(new java.awt.Color(153, 0, 153));
        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Proveedor y Laboratorio");
        jLabel26.setPreferredSize(new java.awt.Dimension(200, 50));
        jleftProveedorYfabricante.add(jLabel26, java.awt.BorderLayout.CENTER);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jefe.png"))); // NOI18N
        jLabel27.setPreferredSize(new java.awt.Dimension(100, 14));
        jleftProveedorYfabricante.add(jLabel27, java.awt.BorderLayout.LINE_START);

        left.add(jleftProveedorYfabricante);

        contenedorPrincipal.add(left, java.awt.BorderLayout.LINE_START);

        bodyContenedor.setBackground(new java.awt.Color(255, 0, 255));
        bodyContenedor.setPreferredSize(new java.awt.Dimension(0, 0));
        bodyContenedor.setLayout(new java.awt.BorderLayout());
        contenedorPrincipal.add(bodyContenedor, java.awt.BorderLayout.CENTER);

        getContentPane().add(contenedorPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jleftServicioFarmaciaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseMoved
        jleftServicioFarmacia.setBackground(colorMoved);
        
    }//GEN-LAST:event_jleftServicioFarmaciaMouseMoved

    private void jleftServicioFarmaciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseExited
        jleftServicioFarmacia.setBackground(colorExit);
        

    }//GEN-LAST:event_jleftServicioFarmaciaMouseExited

    private void jleftInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseMoved
        jleftInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventarioMouseMoved

    private void jleftInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseExited
        jleftInventario.setBackground(colorExit);
    }//GEN-LAST:event_jleftInventarioMouseExited

    private void jleftEstudianteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseMoved
        jleftEstudiante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudianteMouseMoved

    private void jleftEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseExited
        jleftEstudiante.setBackground(colorExit);
    }//GEN-LAST:event_jleftEstudianteMouseExited

    private void jleftInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventarioMouseClicked
       
      
      if(jtfsub_inventario.isShowing()){
      jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_inventario.setVisible(false);
      }
      else{
          jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_inventario.setVisible(true);
      }
      jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
    
       
        
    }//GEN-LAST:event_jleftInventarioMouseClicked

    private void jleftServicioFarmaciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioFarmaciaMouseClicked
        bodyContenedor.setVisible(true);
        
        objVer_inventario.setVisible(false);//1
        objDetalle_Inventario.setVisible(false);//2
        objCrear_Estudiante.setVisible(false);//3   
        objBusquedaVentas.setVisible(false);//4
        objLlenarInventario.setVisible(false);//5
        objCrearUsuario.setVisible(false);//6
        objModificarUsuario.setVisible(false);//7           
        objCrearMedicamento.setVisible(false);//8        
        objEntragEntrega_del_dia.setVisible(false);//10
        objModificar_Estudiante.setVisible(false);//11
        objReporte_Por_Escuela.setVisible(false);//12
        objReporte_Diagnostico.setVisible(false);//13 
        objProveedorLaboratorio.setVisible(false);//14
        objModificarMedicamento.setVisible(false);//15
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Condicion.setVisible(false);//16
        objCrear_Tarifario.setVisible(false);//19
        objInicio.setVisible(false);
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objDescargo.setVisible(false);//23
        objCerrar_Inventario.setVisible(false);
        objModificar_Tarifario.setVisible(false);
        
        
        objServicioFarmacia.ConsultaBD();
        objServicioFarmacia.principalEjecucion();
        objServicioFarmacia.setVisible(true);//9 
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        objReporte_de_insumos.setVisible(false);
        jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblUsuarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblConsultasFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        
                
    }//GEN-LAST:event_jleftServicioFarmaciaMouseClicked

    private void jleftEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudianteMouseClicked
        
        if(jtfsub_Estudiante.isShowing()){
            jtfsub_Estudiante.setVisible(false);
            jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        }  
        else{
            jtfsub_Estudiante.setVisible(true);
          jlblEstudianteFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));

        }
        jtfsub_Consultas.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblUsuarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblConsultasFlecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
        jlblInventarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
    }//GEN-LAST:event_jleftEstudianteMouseClicked

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0002-Salida-1.png")));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0002-salida.png")));
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0001-minimizar-1.png")));

    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0001-minimizar.png")));

    }//GEN-LAST:event_jPanel2MouseExited

    private void jleftConsultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseExited
        jleftConsultas.setBackground(colorExit);
    }//GEN-LAST:event_jleftConsultasMouseExited

    private void jleftConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseClicked
        
        if(jtfsub_Consultas.isShowing()){
      jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
      jtfsub_Consultas.setVisible(false);
      }
      else{
          jlblConsultasFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
          jtfsub_Consultas.setVisible(true);}
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
        
    }//GEN-LAST:event_jleftConsultasMouseClicked

    private void jleftConsultasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultasMouseMoved
        jleftConsultas.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultasMouseMoved

    private void jleftInventario_llenarInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseMoved
        jleftInventario_llenarInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseMoved

    private void jleftInventario_llenarInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseExited
        jleftInventario_llenarInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseExited

    private void jleftInventario_detalleInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseMoved
        jleftInventario_detalleInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseMoved

    private void jleftInventario_detalleInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseExited
        jleftInventario_detalleInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseExited

    private void jleftConsultas_EntregadeldiaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseMoved
        jleftConsultas_Entregadeldia.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseMoved

    private void jleftConsultas_EntregadeldiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseExited
        jleftConsultas_Entregadeldia.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseExited

    private void jleftConsultas_ReportedelMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseMoved
        jleftConsultas_ReportedelMes.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseMoved

    private void jleftConsultas_ReportedelMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseExited
        jleftConsultas_ReportedelMes.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseExited

    private void jleftMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseMoved
        jleftMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicamentoMouseMoved

    private void jleftMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseClicked
        if(jtfsub_Medicina.isShowing()){
            jtfsub_Medicina.setVisible(false);
            }        
        else{
            jtfsub_Medicina.setVisible(true);
        }
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        jtfsub_inventario.setVisible(false);
    }//GEN-LAST:event_jleftMedicamentoMouseClicked

    private void jleftMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicamentoMouseExited
        jleftMedicamento.setBackground(colorExit);
    }//GEN-LAST:event_jleftMedicamentoMouseExited

    private void jleftInventario_llenarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_llenarInventarioMouseClicked
      bodyContenedor.setVisible(true);   
      objModificarMedicamento.setVisible(false);//15
      objProveedorLaboratorio.setVisible(false);//14
      objVer_inventario.setVisible(false);
      objDetalle_Inventario.setVisible(false);
      objCrear_Estudiante.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false);
      objCrearMedicamento.setVisible(false);
      objCrearUsuario.setVisible(false);
      objModificarUsuario.setVisible(false);
      objEntragEntrega_del_dia.setVisible(false);
      objModificar_Estudiante.setVisible(false);
      objReporte_Por_Escuela.setVisible(false);
      objReporte_Diagnostico.setVisible(false);
      objDescargo.setVisible(false);//23
      objServicio_Asistencial.setVisible(false);//17
      objReporte_Condicion.setVisible(false);//16
      objAbrir_Inventario.setVisible(false);//18
      objCrear_Tarifario.setVisible(false);//19
      objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
      objCerrar_Inventario.setVisible(false);
      objModificar_Tarifario.setVisible(false);
      objReporte_de_insumos.setVisible(false);
      objInicio.setVisible(false);
      objLlenarInventario.ConsultaBD();
      //objLlenarInventario.principalEjecucion();(acondicionado con apertura/cierre inventario
      objLlenarInventario.setVisible(true);
      
    }//GEN-LAST:event_jleftInventario_llenarInventarioMouseClicked

    private void jleftInventario_detalleInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_detalleInventarioMouseClicked
      bodyContenedor.setVisible(true);
      
      objReporte_Condicion.setVisible(false);//16
      objModificarMedicamento.setVisible(false);//15
      objProveedorLaboratorio.setVisible(false);//14
      objVer_inventario.setVisible(false);
      objLlenarInventario.setVisible(false);
      objCrearUsuario.setVisible(false);
      objServicio_Asistencial.setVisible(false);//17
      objAbrir_Inventario.setVisible(false);//18
      objCrear_Tarifario.setVisible(false);//19
      objCerrar_Inventario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
      objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
      objInicio.setVisible(false);
      objDetalle_Inventario.setVisible(true);
      objCrear_Estudiante.setVisible(false);        
      objBusquedaVentas.setVisible(false);
      objServicioFarmacia.setVisible(false);
      objCrearMedicamento.setVisible(false);
      objModificarUsuario.setVisible(false);
      objEntragEntrega_del_dia.setVisible(false);
      objModificar_Estudiante.setVisible(false);
      objReporte_Por_Escuela.setVisible(false);      
      objReporte_Diagnostico.setVisible(false);
      objReporte_de_insumos.setVisible(false);
      
    }//GEN-LAST:event_jleftInventario_detalleInventarioMouseClicked

    private void jleftEstudiante_CrearModificarEstudianteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseMoved
        jleftEstudiante_CrearModificarEstudiante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseMoved

    private void jleftEstudiante_CrearModificarEstudianteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseExited
        jleftEstudiante_CrearModificarEstudiante.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseExited

    private void jleftEstudiante_ModificarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_ModificarMouseMoved
        jleftEstudiante_Modificar.setBackground(colorMoved);
    }//GEN-LAST:event_jleftEstudiante_ModificarMouseMoved

    private void jleftEstudiante_ModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_ModificarMouseExited
        jleftEstudiante_Modificar.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftEstudiante_ModificarMouseExited

    private void jleftMedicina_CrearMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearMedicamentoMouseMoved
        jleftMedicina_CrearMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicina_CrearMedicamentoMouseMoved

    private void jleftMedicina_CrearMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearMedicamentoMouseExited
        jleftMedicina_CrearMedicamento.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftMedicina_CrearMedicamentoMouseExited

    private void jleftConsultas_MedicamentoUsadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_MedicamentoUsadoMouseMoved
        jleftConsultas_MedicamentoUsado.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_MedicamentoUsadoMouseMoved

    private void jleftConsultas_MedicamentoUsadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_MedicamentoUsadoMouseExited
        jleftConsultas_MedicamentoUsado.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_MedicamentoUsadoMouseExited

    private void jleftInventario_verInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_verInventarioMouseMoved
        jleftInventario_verInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_verInventarioMouseMoved

    private void jleftInventario_verInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_verInventarioMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14        
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false); 
        objCrearMedicamento.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objCerrar_Inventario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCrear_Tarifario.setVisible(false);//19
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);
        objVer_inventario.ConsultaBD();
        objVer_inventario.principalEjecucion();        
        objVer_inventario.setVisible(true);
        
    }//GEN-LAST:event_jleftInventario_verInventarioMouseClicked

    private void jleftInventario_verInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_verInventarioMouseExited

        jleftInventario_verInventario.setBackground(colorExitSub);        
    }//GEN-LAST:event_jleftInventario_verInventarioMouseExited

    private void jleftUsuarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuarioMouseMoved
        jleftUsuario.setBackground((new java.awt.Color(4,20,25)));
    }//GEN-LAST:event_jleftUsuarioMouseMoved

    private void jleftUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuarioMouseClicked
        
        if(jtfsub_Usuario.isShowing()){
            jtfsub_Usuario.setVisible(false);
            jlblUsuarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
            
        }
        else{
            jlblUsuarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
            jtfsub_Usuario.setVisible(true);
        }
        jtfsub_Tarifario.setVisible(false);
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_inventario.setVisible(false);
    }//GEN-LAST:event_jleftUsuarioMouseClicked

    private void jleftUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuarioMouseExited
        jleftUsuario.setBackground(colorExit);
        
    }//GEN-LAST:event_jleftUsuarioMouseExited

    private void jleftUsuario_CrearModificarUserMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUserMouseMoved
        jleftUsuario_CrearModificarUser.setBackground(colorMoved);
    }//GEN-LAST:event_jleftUsuario_CrearModificarUserMouseMoved

    private void jleftUsuario_CrearModificarUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUserMouseExited
        jleftUsuario_CrearModificarUser.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftUsuario_CrearModificarUserMouseExited

    private void jleftUsuario_AdministrarRolMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRolMouseMoved
        jleftUsuario_AdministrarRol.setBackground(colorMoved);
    }//GEN-LAST:event_jleftUsuario_AdministrarRolMouseMoved

    private void jleftUsuario_AdministrarRolMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRolMouseExited
        jleftUsuario_AdministrarRol.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftUsuario_AdministrarRolMouseExited

    private void jleftProveedorYfabricanteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftProveedorYfabricanteMouseMoved
        jleftProveedorYfabricante.setBackground(colorMoved);
    }//GEN-LAST:event_jleftProveedorYfabricanteMouseMoved

    private void jleftProveedorYfabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftProveedorYfabricanteMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objVer_inventario.setVisible(false);//1
        objDetalle_Inventario.setVisible(false);//2
        objCrear_Estudiante.setVisible(false);//3   
        objBusquedaVentas.setVisible(false);//4
        objLlenarInventario.setVisible(false);//5
        objCrearUsuario.setVisible(false);//6
        objModificarUsuario.setVisible(false);//7           
        objCrearMedicamento.setVisible(false);//8        
        objEntragEntrega_del_dia.setVisible(false);//10
        objModificar_Estudiante.setVisible(false);//11
        objReporte_Por_Escuela.setVisible(false);//12
        objReporte_Diagnostico.setVisible(false);//13 
        objServicioFarmacia.setVisible(false);//9
        objProveedorLaboratorio.setVisible(true);//14
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objProveedorLaboratorio.ConsultaBD();
        objProveedorLaboratorio.principalEjecucion();
        jtfsub_Consultas.setVisible(false);
        jtfsub_Estudiante.setVisible(false);
        jtfsub_Medicina.setVisible(false);
        jtfsub_Usuario.setVisible(false);
        objReporte_de_insumos.setVisible(false);
        jtfsub_inventario.setVisible(false);
        
    }//GEN-LAST:event_jleftProveedorYfabricanteMouseClicked

    private void jleftProveedorYfabricanteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftProveedorYfabricanteMouseExited
        jleftProveedorYfabricante.setBackground(colorExit);
    }//GEN-LAST:event_jleftProveedorYfabricanteMouseExited

    private void jleftMedicina_CrearMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_CrearMedicamentoMouseClicked
        bodyContenedor.setVisible(true);  
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objCrearMedicamento.setVisible(true);
        objCrearMedicamento.ConsultaBD();
        objCrearMedicamento.principalEjecucion();
        
        
    }//GEN-LAST:event_jleftMedicina_CrearMedicamentoMouseClicked

    private void jleftUsuario_CrearModificarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_CrearModificarUserMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);       
        objCrearMedicamento.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objCrearUsuario.ConsultaBD();
        objCrearUsuario.principalEjecucion();
        objCrearUsuario.setVisible(true);
        
    }//GEN-LAST:event_jleftUsuario_CrearModificarUserMouseClicked

    private void jleftUsuario_AdministrarRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftUsuario_AdministrarRolMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objServicioFarmacia.setVisible(false);       
        objCrearMedicamento.setVisible(false);
        objModificarUsuario.setVisible(true);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objModificarUsuario.ConsultaBD();
        objModificarUsuario.principalEjecucion();
        
        
    }//GEN-LAST:event_jleftUsuario_AdministrarRolMouseClicked

    private void jleftEstudiante_CrearModificarEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_CrearModificarEstudianteMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);             
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objServicioFarmacia.setVisible(false);       
        objCrearMedicamento.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objCrear_Estudiante.setVisible(true); 
        objCrear_Estudiante.ConsultaBD();
        objCrear_Estudiante.principalEjecucion();
        
    }//GEN-LAST:event_jleftEstudiante_CrearModificarEstudianteMouseClicked

    private void jleftConsultas_EntregadeldiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_EntregadeldiaMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objModificar_Estudiante.setVisible(false);
        objEntragEntrega_del_dia.ConsultaBD();
        objEntragEntrega_del_dia.principalEjecucion();
        objEntragEntrega_del_dia.setVisible(true);
       
    }//GEN-LAST:event_jleftConsultas_EntregadeldiaMouseClicked

    private void jleftEstudiante_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftEstudiante_ModificarMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objEntragEntrega_del_dia.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objModificar_Estudiante.ConsultaBD();
        objModificar_Estudiante.principalEjecucion();
        objModificar_Estudiante.setVisible(true);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
    }//GEN-LAST:event_jleftEstudiante_ModificarMouseClicked

    private void jleftConsultas_ReportePorEscuelaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaMouseMoved
        jleftConsultas_ReportePorEscuela.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaMouseMoved

    private void jleftConsultas_ReportePorEscuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaMouseClicked
        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objReporte_Por_Escuela.ConsultaBD();
       try {
           objReporte_Por_Escuela.principalEjecucion();
       } catch (DocumentException | IOException ex) {
           Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       }
       objReporte_Diagnostico.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(true);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaMouseClicked

    private void jleftConsultas_ReportePorEscuelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaMouseExited
       
        jleftConsultas_ReportePorEscuela.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaMouseExited

    private void jleftConsultas_ReportedelMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportedelMesMouseClicked

        bodyContenedor.setVisible(true);
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objModificarMedicamento.setVisible(false);//15
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);           
        objCrearMedicamento.setVisible(false);       
        objServicioFarmacia.setVisible(false); 
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_de_insumos.setVisible(false);//24
        objReporte_Diagnostico.ConsultaBD();
        objReporte_Diagnostico.principalEjecucion();
        objReporte_Diagnostico.setVisible(true);
        
 
//Poner por acumulado, Diagnostico y con rango de fechas();
        
        
        
        
    }//GEN-LAST:event_jleftConsultas_ReportedelMesMouseClicked

    private void jlblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jlblMinimizarMouseClicked

    private void jlblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jlblSalirMouseClicked

    private void jleftMedicina_ModificarMedicamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_ModificarMedicamentoMouseMoved
        jleftMedicina_ModificarMedicamento.setBackground(colorMoved);
    }//GEN-LAST:event_jleftMedicina_ModificarMedicamentoMouseMoved

    private void jleftMedicina_ModificarMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_ModificarMedicamentoMouseClicked
        bodyContenedor.setVisible(true);  
        objInicio.setVisible(false);
        objReporte_Condicion.setVisible(false);//16
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);        
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objModificarMedicamento.setVisible(true);//15
        
        objModificarMedicamento.ConsultaBD();
        objModificarMedicamento.principalEjecucion();
    }//GEN-LAST:event_jleftMedicina_ModificarMedicamentoMouseClicked

    private void jleftMedicina_ModificarMedicamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftMedicina_ModificarMedicamentoMouseExited
        jleftMedicina_ModificarMedicamento.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftMedicina_ModificarMedicamentoMouseExited

    private void jleftConsultas_Reporte_CondicionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_CondicionMouseMoved
        jleftConsultas_Reporte_Condicion.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_Reporte_CondicionMouseMoved

    private void jleftConsultas_Reporte_CondicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_CondicionMouseClicked
       try {
           bodyContenedor.setVisible(true);           
           objProveedorLaboratorio.setVisible(false);//14
           objVer_inventario.setVisible(false);
           objDetalle_Inventario.setVisible(false);
           objCrear_Estudiante.setVisible(false);
           objBusquedaVentas.setVisible(false);
           objLlenarInventario.setVisible(false);
           objServicioFarmacia.setVisible(false);
           objCrearUsuario.setVisible(false);
           objInicio.setVisible(false);
           objModificarUsuario.setVisible(false);
           objEntragEntrega_del_dia.setVisible(false);
           objModificar_Estudiante.setVisible(false);
           objReporte_Por_Escuela.setVisible(false);
           objReporte_Diagnostico.setVisible(false);
           objCrearMedicamento.setVisible(false);
           objServicio_Asistencial.setVisible(false);//17
           objAbrir_Inventario.setVisible(false);//18
           objCerrar_Inventario.setVisible(false);//19
           objModificarMedicamento.setVisible(false);//15
           objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
           objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
           objReporte_Condicion.ConsultaBD();
           objReporte_Condicion.principalEjecucion();
           objReporte_Condicion.setVisible(true);//16
       } catch (DocumentException | IOException ex) {
           Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jleftConsultas_Reporte_CondicionMouseClicked

    private void jleftConsultas_Reporte_CondicionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_CondicionMouseExited
        jleftConsultas_Reporte_Condicion.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_Reporte_CondicionMouseExited

    private void jleftServicioAsistencialMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioAsistencialMouseMoved
        jleftServicioAsistencial.setBackground(colorMoved);
    }//GEN-LAST:event_jleftServicioAsistencialMouseMoved

    private void jleftServicioAsistencialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioAsistencialMouseClicked
       
        bodyContenedor.setVisible(true);           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objInicio.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objServicio_Asistencial.ConsultaBD();
        objServicio_Asistencial.principalEjecucion();
        objServicio_Asistencial.setVisible(true);//17           
    }//GEN-LAST:event_jleftServicioAsistencialMouseClicked

    private void jleftServicioAsistencialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftServicioAsistencialMouseExited
        jleftServicioAsistencial.setBackground(colorExit);
    }//GEN-LAST:event_jleftServicioAsistencialMouseExited

    private void jleftInventario_AbrirInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_AbrirInventarioMouseMoved
        jleftInventario_AbrirInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_AbrirInventarioMouseMoved

    private void jleftInventario_AbrirInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_AbrirInventarioMouseClicked
        new ProcesoCarga().start();

        objInicio.setVisible(false);
        bodyContenedor.setVisible(true);           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objCerrar_Inventario.setVisible(false);//19
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objAbrir_Inventario.ConsultaBD();
        objAbrir_Inventario.principalEjecucion();
        objAbrir_Inventario.setVisible(true);//18 
        jdialogCarga.dispose();
    }//GEN-LAST:event_jleftInventario_AbrirInventarioMouseClicked

    private void jleftInventario_AbrirInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_AbrirInventarioMouseExited
        jleftInventario_AbrirInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_AbrirInventarioMouseExited

    private void jleftInventario_CerrarInventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_CerrarInventarioMouseMoved
        jleftInventario_CerrarInventario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_CerrarInventarioMouseMoved

    private void jleftInventario_CerrarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_CerrarInventarioMouseClicked
        bodyContenedor.setVisible(true);   
        objInicio.setVisible(false);        
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objCerrar_Inventario.ConsultaBD();
        objCerrar_Inventario.principalEjecucion();
        objCerrar_Inventario.setVisible(true);//19
         
    }//GEN-LAST:event_jleftInventario_CerrarInventarioMouseClicked

    private void jleftInventario_CerrarInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_CerrarInventarioMouseExited
         jleftInventario_CerrarInventario.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_CerrarInventarioMouseExited

    private void jleftConsultas_ReportePorEscuelaxAlumnoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaxAlumnoMouseMoved
        jleftConsultas_ReportePorEscuelaxAlumno.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaxAlumnoMouseMoved

    private void jleftConsultas_ReportePorEscuelaxAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaxAlumnoMouseClicked
             bodyContenedor.setVisible(true);   
        objInicio.setVisible(false);
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);
        objDetalle_Inventario.setVisible(false);
        objCrear_Estudiante.setVisible(false);
        objBusquedaVentas.setVisible(false);
        objLlenarInventario.setVisible(false);
        objServicioFarmacia.setVisible(false);
        objCrearUsuario.setVisible(false);
        objModificarUsuario.setVisible(false);
        objEntragEntrega_del_dia.setVisible(false);
        objModificar_Estudiante.setVisible(false);
        objReporte_Por_Escuela.setVisible(false);
        objReporte_Diagnostico.setVisible(false);
        objCrearMedicamento.setVisible(false);
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16
        objAbrir_Inventario.setVisible(false);//18
        objCerrar_Inventario.setVisible(false);//19
        objServicio_Asistencial.setVisible(false);//17 
        objCrear_Tarifario.setVisible(false);
        objModificar_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objReporte_Por_Escuela_AtendidosBotica.ConsultaBD();
       try {
           objReporte_Por_Escuela_AtendidosBotica.principalEjecucion();
       } catch (DocumentException | IOException ex) {
           JOptionPane.showMessageDialog(rootPane, "problemas Reporte_por_escuelas");
       }
                objReporte_Por_Escuela_AtendidosBotica.setVisible(true);//20

        
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaxAlumnoMouseClicked

    private void jleftConsultas_ReportePorEscuelaxAlumnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_ReportePorEscuelaxAlumnoMouseExited
       jleftConsultas_ReportePorEscuelaxAlumno.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_ReportePorEscuelaxAlumnoMouseExited

    private void jlblAlertaMedicamentosVencidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblAlertaMedicamentosVencidosMouseClicked
    if(auxFarmacia){
        bodyContenedor.setVisible(true);//1           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);//3
        objDetalle_Inventario.setVisible(false);//4
        objCrear_Estudiante.setVisible(false);//5
        objBusquedaVentas.setVisible(false);//6
        objLlenarInventario.setVisible(false);//7
        objServicioFarmacia.setVisible(false);//8
        objCrearUsuario.setVisible(false);//9
        objModificarUsuario.setVisible(false);//10
        objEntragEntrega_del_dia.setVisible(false);//11
        objModificar_Estudiante.setVisible(false);//12
        objReporte_Por_Escuela.setVisible(false);//13
        objReporte_Diagnostico.setVisible(false);//14
        objCrearMedicamento.setVisible(false);//15
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCerrar_Inventario.setVisible(false);//19        
        objCrear_Tarifario.setVisible(false);//22
        objModificar_Tarifario.setVisible(false);//22  
        objReporte_de_insumos.setVisible(false);//24
        objInicio.setVisible(false);
        objDescargo.ConsultaBD();
        objDescargo.principalEjecucion();
        objDescargo.iniciar_conVencidos();
        objDescargo.setVisible(true);//23   
    }
    }//GEN-LAST:event_jlblAlertaMedicamentosVencidosMouseClicked

    private void jleftTarifarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifarioMouseMoved
        jleftTarifario.setBackground(colorMoved);
    }//GEN-LAST:event_jleftTarifarioMouseMoved

    private void jleftTarifarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifarioMouseClicked
        if(jtfsub_Tarifario.isShowing()){
            jlblTarifarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-left-arrow.png")));
            jtfsub_Tarifario.setVisible(false);
            }
        else{
            jlblTarifarioFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/008-down-arrow.png")));
            jtfsub_Tarifario.setVisible(true);
            }
        jtfsub_Usuario.setVisible(false);

    }//GEN-LAST:event_jleftTarifarioMouseClicked

    private void jleftTarifarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifarioMouseExited
        jleftTarifario.setBackground(colorExit);
    }//GEN-LAST:event_jleftTarifarioMouseExited

    private void jleftTarifario_CrearMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifario_CrearMouseMoved
        jleftTarifario_Crear.setBackground(colorMoved);
    }//GEN-LAST:event_jleftTarifario_CrearMouseMoved

    private void jleftTarifario_CrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifario_CrearMouseClicked

        bodyContenedor.setVisible(true);//1           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);//3
        objDetalle_Inventario.setVisible(false);//4
        objCrear_Estudiante.setVisible(false);//5
        objBusquedaVentas.setVisible(false);//6
        objLlenarInventario.setVisible(false);//7
        objServicioFarmacia.setVisible(false);//8
        objCrearUsuario.setVisible(false);//9
        objModificarUsuario.setVisible(false);//10
        objEntragEntrega_del_dia.setVisible(false);//11
        objModificar_Estudiante.setVisible(false);//12
        objReporte_Por_Escuela.setVisible(false);//13
        objReporte_Diagnostico.setVisible(false);//14
        objCrearMedicamento.setVisible(false);//15
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCerrar_Inventario.setVisible(false);//19        
        objModificar_Tarifario.setVisible(false);//22
        objInicio.setVisible(false);
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objCrear_Tarifario.ConsultaBD();
        objCrear_Tarifario.principalEjecucion();
        objCrear_Tarifario.setVisible(true);//22
        
    }//GEN-LAST:event_jleftTarifario_CrearMouseClicked

    private void jleftTarifario_CrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifario_CrearMouseExited
        jleftTarifario_Crear.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftTarifario_CrearMouseExited

    private void jleftTarifario_ModificarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifario_ModificarMouseMoved
        jleftTarifario_Modificar.setBackground(colorMoved);
    }//GEN-LAST:event_jleftTarifario_ModificarMouseMoved

    private void jleftTarifario_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifario_ModificarMouseClicked
        bodyContenedor.setVisible(true);//1           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);//3
        objDetalle_Inventario.setVisible(false);//4
        objCrear_Estudiante.setVisible(false);//5
        objBusquedaVentas.setVisible(false);//6
        objLlenarInventario.setVisible(false);//7
        objServicioFarmacia.setVisible(false);//8
        objCrearUsuario.setVisible(false);//9
        objModificarUsuario.setVisible(false);//10
        objEntragEntrega_del_dia.setVisible(false);//11
        objModificar_Estudiante.setVisible(false);//12
        objReporte_Por_Escuela.setVisible(false);//13
        objReporte_Diagnostico.setVisible(false);//14
        objCrearMedicamento.setVisible(false);//15
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objInicio.setVisible(false);
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCerrar_Inventario.setVisible(false);//19        
        objCrear_Tarifario.setVisible(false);//22
        objDescargo.setVisible(false);//23
        objReporte_de_insumos.setVisible(false);//24
        objModificar_Tarifario.ConsultaBD();
        objModificar_Tarifario.principalEjecucion();
        objModificar_Tarifario.setVisible(true);//22
    }//GEN-LAST:event_jleftTarifario_ModificarMouseClicked

    private void jleftTarifario_ModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftTarifario_ModificarMouseExited
        jleftTarifario_Modificar.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftTarifario_ModificarMouseExited

    private void jleftInventario_DescargoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_DescargoMouseMoved
        jleftInventario_Descargo.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInventario_DescargoMouseMoved

    private void jleftInventario_DescargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_DescargoMouseClicked
                      
      bodyContenedor.setVisible(true);//1           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);//3
        objDetalle_Inventario.setVisible(false);//4
        objCrear_Estudiante.setVisible(false);//5
        objBusquedaVentas.setVisible(false);//6
        objLlenarInventario.setVisible(false);//7
        objServicioFarmacia.setVisible(false);//8
        objCrearUsuario.setVisible(false);//9
        objModificarUsuario.setVisible(false);//10
        objEntragEntrega_del_dia.setVisible(false);//11
        objModificar_Estudiante.setVisible(false);//12
        objReporte_Por_Escuela.setVisible(false);//13
        objReporte_Diagnostico.setVisible(false);//14
        objCrearMedicamento.setVisible(false);//15
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCerrar_Inventario.setVisible(false);//19        
        objCrear_Tarifario.setVisible(false);//22
        objModificar_Tarifario.setVisible(false);//23  
        objReporte_de_insumos.setVisible(false);//24
        objInicio.setVisible(false);
        objDescargo.ConsultaBD();
        //objDescargo.principalEjecucion(); usando treah para agilizar la carga de vista
        objDescargo.setVisible(true);//23      
    }//GEN-LAST:event_jleftInventario_DescargoMouseClicked

    private void jleftInventario_DescargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInventario_DescargoMouseExited
        jleftInventario_Descargo.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftInventario_DescargoMouseExited

    private void jlblSemestreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSemestreMouseMoved
        jlblSemestre.setForeground(Color.RED);
    }//GEN-LAST:event_jlblSemestreMouseMoved

    private void jlblSemestreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSemestreMouseExited
        jlblSemestre.setForeground(Color.BLACK);
    }//GEN-LAST:event_jlblSemestreMouseExited

    private void jlblSemestreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSemestreMouseClicked
        if(auxFarmacia){
            jdialogSemestreAtecion.setLocationRelativeTo(null);
            jdialogSemestreAtecion.setSize(700,350);
            jdialogSemestreAtecion.setVisible(true);}
    }//GEN-LAST:event_jlblSemestreMouseClicked

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        jListaMedicamentosVencidos.setVisible(false);

    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnCerrarSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarSemestreActionPerformed
        objSemestreF.setFecha_Fin_Real(new Date());
        jpa.getTransaction().begin();
        jpa.persist(objSemestreF);
        actulizarPeriodoClick();
        JOptionPane.showMessageDialog(jLabel12, "Semestre culminado");
        //objCuadrito.setVisible(false);
        jpa.getTransaction().commit();
    }//GEN-LAST:event_jbtnCerrarSemestreActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        jdialogSemestreAtecion.setVisible(false);
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed

        objSemestreF.setFecha_Fin(jcbDateFin.getDatoFecha());
        objSemestreF.setFecha_Inicio(jcbDateInicio.getDatoFecha());
        if(((String)jcbPeriodoSemestre.getSelectedItem()).equals("I")){
            objSemestreF.setSemestre_periodo(false);
        }
        else{
            objSemestreF.setSemestre_periodo(true);
        }
        jpa.getTransaction().begin();
        jpa.persist(objSemestreF);
        actulizarPeriodoClick();
        JOptionPane.showMessageDialog(jLabel12, "Guardado con exito");
        jdialogSemestreAtecion.setVisible(false);
        jpa.getTransaction().commit();
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jleftConsultas_Reporte_InsumoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_InsumoMouseMoved
        jleftConsultas_Reporte_Insumo.setBackground(colorMoved);
    }//GEN-LAST:event_jleftConsultas_Reporte_InsumoMouseMoved

    private void jleftConsultas_Reporte_InsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_InsumoMouseClicked
        bodyContenedor.setVisible(true);//1           
        objProveedorLaboratorio.setVisible(false);//14
        objVer_inventario.setVisible(false);//3
        objDetalle_Inventario.setVisible(false);//4
        objCrear_Estudiante.setVisible(false);//5
        objBusquedaVentas.setVisible(false);//6
        objLlenarInventario.setVisible(false);//7
        objServicioFarmacia.setVisible(false);//8
        objCrearUsuario.setVisible(false);//9
        objModificarUsuario.setVisible(false);//10
        objEntragEntrega_del_dia.setVisible(false);//11
        objModificar_Estudiante.setVisible(false);//12
        objReporte_Por_Escuela.setVisible(false);//13
        objReporte_Diagnostico.setVisible(false);//14
        objCrearMedicamento.setVisible(false);//15
        objModificarMedicamento.setVisible(false);//15
        objReporte_Condicion.setVisible(false);//16        
        objServicio_Asistencial.setVisible(false);//17
        objAbrir_Inventario.setVisible(false);//18
        objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
        objCerrar_Inventario.setVisible(false);//19        
        objCrear_Tarifario.setVisible(false);//22
        objModificar_Tarifario.setVisible(false);//23 
        objDescargo.setVisible(false);//23 
        objInicio.setVisible(false);
        
        objReporte_de_insumos.ConsultaBD();
        objReporte_de_insumos.principalEjecucion();
        objReporte_de_insumos.setVisible(true);//24
    }//GEN-LAST:event_jleftConsultas_Reporte_InsumoMouseClicked

    private void jleftConsultas_Reporte_InsumoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftConsultas_Reporte_InsumoMouseExited
        jleftConsultas_Reporte_Insumo.setBackground(colorExitSub);
    }//GEN-LAST:event_jleftConsultas_Reporte_InsumoMouseExited

    private void jleftInicioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInicioMouseMoved
        jleftInicio.setBackground(colorMoved);
    }//GEN-LAST:event_jleftInicioMouseMoved

    private void jleftInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInicioMouseClicked
        jtfsub_Usuario.setVisible(false);
       objModificarMedicamento.setVisible(false);//15
       objProveedorLaboratorio.setVisible(false);//14
       objVer_inventario.setVisible(false);
       objDetalle_Inventario.setVisible(false);
       objCrear_Estudiante.setVisible(false);        
       objBusquedaVentas.setVisible(false);
       objServicioFarmacia.setVisible(false);
       objCrearMedicamento.setVisible(false);
       objCrearUsuario.setVisible(false);
       objModificarUsuario.setVisible(false);
       objEntragEntrega_del_dia.setVisible(false);
       objModificar_Estudiante.setVisible(false);
       objReporte_Por_Escuela.setVisible(false);
       objReporte_Diagnostico.setVisible(false);
       objDescargo.setVisible(false);//23
       objServicio_Asistencial.setVisible(false);//17
       objReporte_Condicion.setVisible(false);//16
       objAbrir_Inventario.setVisible(false);//18
       objCrear_Tarifario.setVisible(false);//19
       objReporte_Por_Escuela_AtendidosBotica.setVisible(false);//20
       objCerrar_Inventario.setVisible(false);
       objModificar_Tarifario.setVisible(false);
       objReporte_de_insumos.setVisible(false);
       objLlenarInventario.setVisible(false);
       objInicio.ConsultaBD();
       objInicio.principalEjecucion();
       objInicio.setVisible(true);
    }//GEN-LAST:event_jleftInicioMouseClicked

    private void jleftInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jleftInicioMouseExited
        jleftInicio.setBackground(colorExit);
    }//GEN-LAST:event_jleftInicioMouseExited

    public Usuario getUsuario(){
        return user;
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel INICIO;
    private javax.swing.JLabel ImagInicio;
    private javax.swing.JPanel bodyContenedor;
    private javax.swing.JPanel carga;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel contenedor1;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head1;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JDialog jListaMedicamentosVencidos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jbtlVencidos;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCerrarSemestre;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnSalir;
    private rojeru_san.componentes.RSDateChooser jcbDateFin;
    private rojeru_san.componentes.RSDateChooser jcbDateInicio;
    private javax.swing.JComboBox<String> jcbPeriodoSemestre;
    private javax.swing.JDialog jdialogCarga;
    private javax.swing.JDialog jdialogSemestreAtecion;
    private javax.swing.JLabel jlblAdvertencia;
    private javax.swing.JLabel jlblAlertaMedicamentosVencidos;
    private javax.swing.JLabel jlblCondicion1;
    private javax.swing.JLabel jlblConsultasFlecha;
    private javax.swing.JLabel jlblConsultasFlecha1;
    private javax.swing.JLabel jlblEscuela;
    private javax.swing.JLabel jlblEstCodigo;
    private javax.swing.JLabel jlblEstudianteFlecha1;
    private javax.swing.JLabel jlblHead1;
    private javax.swing.JLabel jlblInventarioFlecha;
    private javax.swing.JLabel jlblMensaje3;
    private javax.swing.JLabel jlblMinimizar;
    private javax.swing.JLabel jlblNombre1;
    private javax.swing.JLabel jlblPorvencer;
    private javax.swing.JLabel jlblRolcito;
    private javax.swing.JLabel jlblSalir;
    private javax.swing.JLabel jlblSemestre;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JLabel jlblTarifarioFlecha;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JLabel jlblUsuarioFlecha;
    private javax.swing.JLabel jlblVencidos;
    private javax.swing.JPanel jleftConsultas;
    private javax.swing.JPanel jleftConsultas_Entregadeldia;
    private javax.swing.JPanel jleftConsultas_MedicamentoUsado;
    private javax.swing.JPanel jleftConsultas_ReportePorEscuela;
    private javax.swing.JPanel jleftConsultas_ReportePorEscuelaxAlumno;
    private javax.swing.JPanel jleftConsultas_Reporte_Condicion;
    private javax.swing.JPanel jleftConsultas_Reporte_Insumo;
    private javax.swing.JPanel jleftConsultas_ReportedelMes;
    private javax.swing.JPanel jleftEstudiante;
    private javax.swing.JPanel jleftEstudiante_CrearModificarEstudiante;
    private javax.swing.JPanel jleftEstudiante_Modificar;
    private javax.swing.JPanel jleftInicio;
    private javax.swing.JPanel jleftInventario;
    private javax.swing.JPanel jleftInventario_AbrirInventario;
    private javax.swing.JPanel jleftInventario_CerrarInventario;
    private javax.swing.JPanel jleftInventario_Descargo;
    private javax.swing.JPanel jleftInventario_detalleInventario;
    private javax.swing.JPanel jleftInventario_llenarInventario;
    private javax.swing.JPanel jleftInventario_verInventario;
    private javax.swing.JPanel jleftMedicamento;
    private javax.swing.JPanel jleftMedicina_CrearMedicamento;
    private javax.swing.JPanel jleftMedicina_ModificarMedicamento;
    private javax.swing.JPanel jleftProveedorYfabricante;
    private javax.swing.JPanel jleftServicioAsistencial;
    private javax.swing.JPanel jleftServicioFarmacia;
    private javax.swing.JPanel jleftTarifario;
    private javax.swing.JPanel jleftTarifario_Crear;
    private javax.swing.JPanel jleftTarifario_Modificar;
    private javax.swing.JPanel jleftUsuario;
    private javax.swing.JPanel jleftUsuario_AdministrarRol;
    private javax.swing.JPanel jleftUsuario_CrearModificarUser;
    private javax.swing.JTable jtblPorVencer;
    private javax.swing.JPanel jtfsub_Consultas;
    private javax.swing.JPanel jtfsub_Estudiante;
    private javax.swing.JPanel jtfsub_Medicina;
    private javax.swing.JPanel jtfsub_Tarifario;
    private javax.swing.JPanel jtfsub_Usuario;
    private javax.swing.JPanel jtfsub_inventario;
    private javax.swing.JPanel left;
    // End of variables declaration//GEN-END:variables
}
