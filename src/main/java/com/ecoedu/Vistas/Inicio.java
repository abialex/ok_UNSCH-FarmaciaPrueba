package com.ecoedu.Vistas;




import com.ecoedu.model.Control_paciente;
import com.ecoedu.model.Detalle_Medicamentos;
import com.ecoedu.model.Detalle_Servicio_Social;
import com.ecoedu.model.Lote_detalle;
import com.ecoedu.model.Receta;
import com.ecoedu.model.Rol;
import com.ecoedu.model.Semestre;
import com.ecoedu.model.Servicio_social;
import com.ecoedu.model.Usuario;
import com.ecoedu.model.ZObjetoProDiag;
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
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.dom4j.DocumentException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yrma
 */
public class Inicio extends javax.swing.JPanel {  
   // List<Detalle_control_paciente> lista_Detalles_control_paciente;
    EntityManager jpa;
    Usuario objUsuario;
    Semestre objSemestre;
    List<Lote_detalle> lotes_por_agotamiento;
    List<Detalle_Medicamentos> Lista_Detalle_Medicamento;
    List<Rol> Lista_RolUsuarios;
    List<Usuario> Lista_Usuario;
    List<Control_paciente> Lista_ControlPacienteSemestreActual;
    List<Rol> Lista_Escuelas;
    List<Receta> Lista_Recetas;
    List<Lote_detalle> Lotes_vencidos;
    List<Lote_detalle> Lotes_por_vencer;
    List<Integer> Lista_meses;
    List<Semestre> Lista_Semestres;
    public Inicio(EntityManager objJPA,Usuario objUsuario,Semestre objSemestre) {
        initComponents();
        this.jpa=objJPA;
        this.objUsuario=objUsuario;
        this.objSemestre=objSemestre;
   
       // llenarTabla_MedicamentosPorAgotamiento(lista_Detalles_control_paciente);
    }
    public void ConsultaBD(){
        lotes_por_agotamiento=jpa.createQuery("select p from Lote_detalle p where isVencido=0 and cantidad< 30 ORDER BY cantidad ").getResultList();
        Lista_Detalle_Medicamento=jpa.createQuery("SELECT p FROM Detalle_Medicamentos p").getResultList();
        Lista_RolUsuarios=jpa.createQuery("SELECT p FROM Rol p where id_tipo_Roles="+objUsuario.getRol().getTipo_Roles().getId_tipo_Roles()).getResultList();  
        Lista_Usuario=jpa.createQuery("SELECT p FROM Usuario p").getResultList();
        Lista_Recetas=jpa.createQuery("select p from Receta p").getResultList();
        Lista_ControlPacienteSemestreActual=jpa.createQuery("select p from Control_paciente p where id_Semestre="+objSemestre.getId_Semestre()).getResultList();
        Lista_Escuelas=jpa.createQuery("select p from Rol p where id_tipo_Roles=1").getResultList();      
        //
        Lotes_vencidos=jpa.createQuery("select p from Lote_detalle p where  DATEDIFF(day,  GETDATE(),fecha_vencimiento)<=0 and isVencido=0").getResultList();
        Lotes_por_vencer=jpa.createQuery("select p from Lote_detalle p where  DATEDIFF(day,  GETDATE(),fecha_vencimiento)<60 and DATEDIFF(day,  GETDATE(),fecha_vencimiento)>0  and isVencido=0").getResultList();
        Lista_meses=jpa.createQuery("select MONTH(fecha_apertura) from RegistroMensualInventario where fecha_cierre is not null GROUP BY fecha_apertura").getResultList();
        Lista_Semestres=jpa.createQuery("SELECT p from Semestre p ").getResultList();
        
        
        //jLabel13.setText(lotes_por_agotamiento.size()+"a");
        
        //lista_Detalles_control_paciente=query1.getResultList();
        
    }
    public void principalEjecucion(){
        
        llenarTabla_EntregasDehoy(getEntregadoHoy(Lista_Detalle_Medicamento));
        llenarTabla_MedicamentosPorAgotamiento(lotes_por_agotamiento);
        llenar_UsuariosLista(getListUsuario(Lista_RolUsuarios));
        llenarTabla_EstudiantesCaceritos(getListaEstudiantesCaceritos(Lista_ControlPacienteSemestreActual));
        try {
            llenarTabla_Cuadro(getCuadro(Lista_Recetas, Lista_Escuelas));
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenar_tabla_LoteDetalleVencidos(Lotes_vencidos);
        llenar_tabla_LoteDetalle(Lotes_por_vencer);
        for (Integer mes : Lista_meses) {
            jcbPorMeses.addItem(new ZObjetoProDiag(Herramienta.getNombreMes(mes),mes));
        }
        for (Semestre objeSemestre : Lista_Semestres){
            jcbSemestres.addItem(objeSemestre);
        }
    }
    public List<ZObjetoProDiag> getListUsuario(List<Rol> listaRolUsuario){
        List<ZObjetoProDiag> lista_RolesUsuarioa=new ArrayList<>();
        for(Rol objCondicion : listaRolUsuario){
                int cant=0;
                for(Usuario objUsuarios : Lista_Usuario){
                    if(objUsuarios.getRol()==objCondicion){
                        cant++;          
                        }
                    }//fin for allreceta
                lista_RolesUsuarioa.add(new ZObjetoProDiag(objCondicion,cant));
                }//fin for receta
        
        
        
        return lista_RolesUsuarioa;
    }
     public void imprimirEstudiante() throws FileNotFoundException, DocumentException, IOException{
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTamaño=9;
        int fontHeadTamaño=9;
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\cuadro.pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");
        }         
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{36,8,8,8,8 ,8,8,8,8,8, 8,8,8,8});
        table.setWidthPercent(100);
        Paragraph paragIma=new Paragraph("").add(unsch).add("                                                                                     SERVICIO DE FARMACIA").setFont(bold);         
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Escuela").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(1,4).add(new Paragraph("Procedencia Receta").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Total").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(1,3).add(new Paragraph("Condición").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Total").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(1,2).add(new Paragraph("Sexo").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Total").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("%").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("ME.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));        
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("OB.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("OD.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("OTROS").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));          
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("N").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("C").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("R").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("M").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("F").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
      Collections.sort(Lista_Recetas);//ordenando A-Z (método como Override)

        /*for(Receta receta : Lista_Recetas){
            List<Detalle_Medicamentos> listMedi=Herramienta.findbyWhere(Detalle_Medicamentos.class,"id_Receta", receta.getId_Receta(), jpa);
            Collections.sort(listMedi);//ordenando A-Z (método como Override)
            Paragraph p = new Paragraph("Receta N°").setFont(bold).setFontSize(10)
                    .add(new Text(""+receta.getId_Receta()).setFont(bold).setFontSize(10))
                    .add(new Text("   Procedencia: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getRolProcedencia().getNombre_rol()).setFont(font).setFontSize(10))
                    .add(new Text("   Diagnóstico: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getDiagnosito().getId_DiagnosticoCodigo()).setFontSize(10));
            
            table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño)
                    .add(Herramienta.formatoFecha(receta.getFecha_creada())).setFont(bold) );
            
            table.addCell(new Cell(1, 4).add(p).setTextAlignment(TextAlignment.LEFT));
            for (Detalle_Medicamentos Detalle_Medicamento : listMedi) {           
            table.addCell(new Paragraph(Herramienta.formatoFecha(Detalle_Medicamento.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Detalle_Medicamento.getId_Medicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Integer.toString(Detalle_Medicamento.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Float.toString(Detalle_Medicamento.getPrecio_Total())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            }
        }*/
         
        document.add(paragIma);
        document.add(new Paragraph(" "));    
        document.add(table);   
        document.close();       
    }
    
    
    
    public List<Detalle_Medicamentos> getEntregadoHoy(List<Detalle_Medicamentos> lista){
        List<Detalle_Medicamentos> listaDetalleMedicamentos=new ArrayList<>();
        for (Detalle_Medicamentos Detalle_Medicamento : lista) {
            if(Herramienta.iSigualFechas(new Date(), Detalle_Medicamento.getFecha())){
                listaDetalleMedicamentos.add(Detalle_Medicamento);
            }
        }
        if(listaDetalleMedicamentos.isEmpty()){
            jlblTitleEntregasdelDia.setText("Entregas : Nada");  
        }
        else{
            jlblTitleEntregasdelDia.setText("Entregas de Hoy");
        }
        return listaDetalleMedicamentos;
    }
    public List<ZObjetoProDiag> getListaEstudiantesCaceritos(List<Control_paciente> lista){
        List<ZObjetoProDiag> lista_EstudiantesCaceritos=new ArrayList<>();
        for (Control_paciente control_paciente : lista) {
            lista_EstudiantesCaceritos.add(new ZObjetoProDiag(control_paciente.getEstudiante(),Herramienta.findbyWhere(Receta.class, "id_Control_Paciente", control_paciente.getId_Control_paciente(), jpa).size()));
        }
        Collections.sort(lista_EstudiantesCaceritos);
        return lista_EstudiantesCaceritos;
        
    }
    public List<List<Receta>> getCuadro(List<Receta> lista_receta,List<Rol> lista_escuelas){
        boolean auxSave=false;
        List<List<Receta>> Lista_Escuelas_Ordenados_porAlumno=new ArrayList<>();
        for (Rol escuela : lista_escuelas){
            auxSave=false;
            List<Receta> Lista_alumnos_escuela=new ArrayList<>();
            for (Receta receta : lista_receta){
                if(receta.getControl_Paciente().getEstudiante().getEscuela()==escuela){
                    Lista_alumnos_escuela.add(receta);
                    auxSave=true;
                }                                
            }
            if(auxSave){Lista_Escuelas_Ordenados_porAlumno.add(Lista_alumnos_escuela);}           
        }  
        return Lista_Escuelas_Ordenados_porAlumno;
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
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblCuadro = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Personal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jbtlUsuariosLista = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Top5Estudiantes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblEstudiantesCaceritos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        EntregasDelDia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblEntregasDelDia = new javax.swing.JTable();
        jlblTitleEntregasdelDia = new javax.swing.JLabel();
        Medicamentosporacabar = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblMedicamentos_porAgotarse = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblPorVencer = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jbtlVencidos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jcbPorMeses = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jcbSemestres = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 204));
        setInheritsPopupMenu(true);
        setMaximumSize(new java.awt.Dimension(6666, 6504));
        setMinimumSize(new java.awt.Dimension(5555, 6502));
        setPreferredSize(new java.awt.Dimension(990, 650));
        setLayout(new java.awt.BorderLayout());

        head.setBackground(new java.awt.Color(207, 48, 72));
        head.setPreferredSize(new java.awt.Dimension(10, 50));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("INICIO");
        jLabel12.setPreferredSize(new java.awt.Dimension(900, 50));
        head.add(jLabel12);

        add(head, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblCuadro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CARRERAS PROFESIONALES", "ME", "OB", "OD", "OTROS", "---", "N", "C", "R", "----", "M", "F", "Total"
            }
        ));
        jScrollPane6.setViewportView(jtblCuadro);

        body.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 880, 170));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Vencidos");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 70, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Personal.setBackground(new java.awt.Color(255, 255, 255));
        Personal.setMinimumSize(new java.awt.Dimension(50, 50));
        Personal.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 100));
        jScrollPane2.setRequestFocusEnabled(false);

        jbtlUsuariosLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jbtlUsuariosLista);

        Personal.add(jScrollPane2, java.awt.BorderLayout.PAGE_END);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Personal");
        Personal.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(Personal);

        Top5Estudiantes.setBackground(new java.awt.Color(255, 255, 255));
        Top5Estudiantes.setMinimumSize(new java.awt.Dimension(50, 50));
        Top5Estudiantes.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setPreferredSize(new java.awt.Dimension(150, 100));
        jScrollPane3.setRequestFocusEnabled(false);

        jtblEstudiantesCaceritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(jtblEstudiantesCaceritos);

        Top5Estudiantes.add(jScrollPane3, java.awt.BorderLayout.PAGE_END);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Top 5 Estudiantes");
        Top5Estudiantes.add(jLabel10, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(Top5Estudiantes);

        EntregasDelDia.setBackground(new java.awt.Color(255, 255, 255));
        EntregasDelDia.setMinimumSize(new java.awt.Dimension(50, 50));
        EntregasDelDia.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 100));
        jScrollPane4.setRequestFocusEnabled(false);

        jtblEntregasDelDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane4.setViewportView(jtblEntregasDelDia);

        EntregasDelDia.add(jScrollPane4, java.awt.BorderLayout.PAGE_END);

        jlblTitleEntregasdelDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTitleEntregasdelDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitleEntregasdelDia.setText("Entregas del Día");
        EntregasDelDia.add(jlblTitleEntregasdelDia, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(EntregasDelDia);

        Medicamentosporacabar.setBackground(new java.awt.Color(255, 255, 255));
        Medicamentosporacabar.setMinimumSize(new java.awt.Dimension(50, 50));
        Medicamentosporacabar.setLayout(new java.awt.BorderLayout());

        jScrollPane5.setPreferredSize(new java.awt.Dimension(350, 100));
        jScrollPane5.setRequestFocusEnabled(false);

        jtblMedicamentos_porAgotarse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane5.setViewportView(jtblMedicamentos_porAgotarse);

        Medicamentosporacabar.add(jScrollPane5, java.awt.BorderLayout.PAGE_END);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Medicamentos por Agotarse");
        Medicamentosporacabar.add(jLabel13, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(Medicamentosporacabar);

        body.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 140));

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
        jScrollPane7.setViewportView(jtblPorVencer);

        body.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 410, 110));

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
        jScrollPane8.setViewportView(jbtlVencidos);

        body.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 410, 110));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cuadro Mensual");
        body.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 120, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Próximos a Vencer");
        body.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 130, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Imprimir");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        body.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 90, -1));

        jcbPorMeses.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbPorMeses.setPreferredSize(new java.awt.Dimension(56, 25));
        body.add(jcbPorMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 120, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MES:");
        jLabel1.setPreferredSize(new java.awt.Dimension(34, 25));
        body.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        jcbSemestres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbSemestres.setPreferredSize(new java.awt.Dimension(56, 25));
        body.add(jcbSemestres, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 110, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("SEMESTRE:");
        jLabel2.setPreferredSize(new java.awt.Dimension(34, 25));
        body.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 80, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Imprimir");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        body.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 90, -1));

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Receta> lista_RecetaxMes=new ArrayList<>();
        for (Receta objReceta : Lista_Recetas){
            if(((ZObjetoProDiag)jcbPorMeses.getSelectedItem()).getMes_ind()==(objReceta.getFecha_creada().getMonth()+1)){
                lista_RecetaxMes.add(objReceta);
                }            
        }
        try {
            llenarTabla_Cuadro(getCuadro(lista_RecetaxMes, Lista_Escuelas));
            String url="Carpeta_de_Archivos\\cuadro.pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           List<Receta> lista_RecetaxSemestre=new ArrayList<>();
        for (Receta objReceta : Lista_Recetas){
            if(((Semestre)jcbSemestres.getSelectedItem())==objReceta.getControl_Paciente().getSemestre()){
                lista_RecetaxSemestre.add(objReceta);
                }            
        }
        try {
            llenarTabla_Cuadro(getCuadro(lista_RecetaxSemestre, Lista_Escuelas));
            String url="Carpeta_de_Archivos\\cuadro.pdf";
            ProcessBuilder p=new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();            
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    public void llenarTabla_MedicamentosPorAgotamiento(List<Lote_detalle> lista_lote_detalle){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"P.F","Código","Cant."};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (Lote_detalle lote_detalle : lista_lote_detalle){
                 fila_actividad[0]=lote_detalle.getInventario().getMedicamento().getNombre();
                 fila_actividad[1]=lote_detalle.getCodigo();
                 fila_actividad[2]=lote_detalle.getCantidad();
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblMedicamentos_porAgotarse.setModel(modelo); 
            jtblMedicamentos_porAgotarse.setGridColor(Color.black);
            //jTable1.setBackground(Color.red);
            //jTable1.setForeground(Color.blue);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblMedicamentos_porAgotarse.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblMedicamentos_porAgotarse.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setCellRenderer(tcr);
 
            jtblMedicamentos_porAgotarse.setFont(new java.awt.Font("Tahoma", 0, 9));
            jtblMedicamentos_porAgotarse.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
            jtblMedicamentos_porAgotarse.getTableHeader().setBackground(Color.BLUE);
            jtblMedicamentos_porAgotarse.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblMedicamentos_porAgotarse.getColumnModel().getColumn(0).setPreferredWidth(120);
            jtblMedicamentos_porAgotarse.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setPreferredWidth(20);

            
            ((DefaultTableCellRenderer)jtblMedicamentos_porAgotarse.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);   
    }   
    
    //
    public void llenarTabla_Cuadro(List<List<Receta>> lista_escuelas_por_recetas) throws MalformedURLException, IOException{ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
        String ol="images\\unsch.png";
        Image unsch=new Image(ImageDataFactory.create(ol));
        int fontTamaño=9;
        int fontHeadTamaño=9;
        PdfWriter writer=null;
        try {
             writer=new PdfWriter("Carpeta_de_Archivos\\cuadro.pdf");           
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(jLabel12, "El proceso no tiene acceso al archivo porque está siendo utilizado por otro proceso");
        }         
        PdfDocument pdf = new PdfDocument(writer);
        Document document=new Document(pdf,PageSize.A4.rotate());        
        PdfFont font=PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold=PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);     
        Table table = new Table(new float[]{36,8,8,8,8,8 ,8,8,8,8,8, 8,8,8,8});
        table.setWidthPercent(100);
        Paragraph paragIma=new Paragraph("").add(unsch).add("                                                                                       SERVICIO DE FARMACIA").setFont(bold);         
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Escuela").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(1,5).add(new Paragraph("Procedencia Receta").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Total").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(1,3).add(new Paragraph("Condición").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Total").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));         
        table.addHeaderCell(new Cell(1,2).add(new Paragraph("Sexo").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("Total").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(2,1).add(new Paragraph("%").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("ME.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));                
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("OB.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("OD.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("PSI.").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("OTROS").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño));          
        
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("N").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("C").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("R").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("M").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
        table.addHeaderCell(new Cell(1,1).add(new Paragraph("F").setFont(bold)).setTextAlignment(TextAlignment.CENTER).setFontSize(fontHeadTamaño)); 
      Collections.sort(Lista_Recetas);//ordenando A-Z (método como Override)
        /*for(Receta receta : Lista_Recetas){
            List<Detalle_Medicamentos> listMedi=Herramienta.findbyWhere(Detalle_Medicamentos.class,"id_Receta", receta.getId_Receta(), jpa);
            Collections.sort(listMedi);//ordenando A-Z (método como Override)
            Paragraph p = new Paragraph("Receta N°").setFont(bold).setFontSize(10)
                    .add(new Text(""+receta.getId_Receta()).setFont(bold).setFontSize(10))
                    .add(new Text("   Procedencia: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getRolProcedencia().getNombre_rol()).setFont(font).setFontSize(10))
                    .add(new Text("   Diagnóstico: ").setFont(bold).setFontSize(10))
                    .add(new Text(receta.getDiagnosito().getId_DiagnosticoCodigo()).setFontSize(10));
            
            table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño)
                    .add(Herramienta.formatoFecha(receta.getFecha_creada())).setFont(bold) );
            
            table.addCell(new Cell(1, 4).add(p).setTextAlignment(TextAlignment.LEFT));
            for (Detalle_Medicamentos Detalle_Medicamento : listMedi) {           
            table.addCell(new Paragraph(Herramienta.formatoFecha(Detalle_Medicamento.getFecha())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Detalle_Medicamento.getId_Medicamento().getNombre()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Integer.toString(Detalle_Medicamento.getCantidad())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Float.toString(Detalle_Medicamento.getPrecio_Total())).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(Detalle_Medicamento.getUsuario().getPersona().getInfoPersona()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            }
        }*/
         //.....................................TABLA......................................
             String [] lista={"Escuela","ME","OB","OD","PSI","OTROS"," ","N","C","R"," ","M","F","Total","%"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................        
        fila_actividad=new Object[modelo.getColumnCount()];  
        int cantAcum=0;
        for (List<Receta> objlista_escuelas_por_receta : lista_escuelas_por_recetas){
            cantAcum=cantAcum+objlista_escuelas_por_receta.size();
        }
        for (List<Receta> objlista_escuelas_por_receta : lista_escuelas_por_recetas){
            int cant_Procedencia_odontologia=0,cant_Procedencia_obstetricia=0,cant_Procedencia_medicina=0,cant_Procedencia_psicología=0;
            int cant_Procedencia_otros=0;
            int cant_nuevo=0,cant_concurrente=0,cant_reingresante=0;
            int cant_masculino=0,cant_femenino=0;
            for (Receta receta : objlista_escuelas_por_receta){
                switch(receta.getRolProcedencia().getNombre_rol()){
                    case "ODONTOLOGÍA":
                        cant_Procedencia_odontologia++;
                        break;
                    case "OBSTETRICIA":
                        cant_Procedencia_obstetricia++;
                        break;
                    case "MEDICINA":
                        cant_Procedencia_medicina++;
                        break;
                    case "PSICOLOGÍA":
                        cant_Procedencia_psicología++;
                        break;
                    case "OTROS":
                        cant_Procedencia_otros++;
                        break;   
                        }
                switch(receta.getControl_Paciente().getEstudiante().getRolCondicion().getNombre_rol()){
                    case "Nuevo":
                        cant_nuevo++;
                        break;                        
                    case "Concurrente":
                        cant_concurrente++;
                        break;
                    case "Reingresante":
                        cant_reingresante++;
                        break;
                        }
                switch(receta.getControl_Paciente().getEstudiante().getRolSexo().getNombre_rol()){
                    case "Masculino":
                        cant_masculino++;
                        break;
                    case "Feminenino":
                        cant_femenino++;
                        break;                    
                }                                
            }
            fila_actividad[0]=objlista_escuelas_por_receta.get(0).getControl_Paciente().getEstudiante().getEscuela().getNombre_rol();
            fila_actividad[1]=cant_Procedencia_medicina;
            fila_actividad[2]=cant_Procedencia_obstetricia;
            fila_actividad[3]=cant_Procedencia_odontologia;
            fila_actividad[4]=cant_Procedencia_psicología;
            fila_actividad[5]=cant_Procedencia_otros;
            fila_actividad[6]="";
            fila_actividad[7]=cant_nuevo;
            fila_actividad[8]=cant_concurrente;
            fila_actividad[9]=cant_reingresante;
            fila_actividad[10]="";
            fila_actividad[11]=cant_masculino;
            fila_actividad[12]=cant_femenino;
            fila_actividad[13]=objlista_escuelas_por_receta.size(); 
            fila_actividad[14]=Herramienta.dosDecimales((float)objlista_escuelas_por_receta.size()/cantAcum)+"%";
            modelo.addRow(fila_actividad);//agregando filas
            
            table.addCell(new Paragraph(objlista_escuelas_por_receta.get(0).getControl_Paciente().getEstudiante().getEscuela().getNombre_rol()).setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_Procedencia_medicina+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_Procedencia_obstetricia+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_Procedencia_odontologia+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_Procedencia_psicología+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_Procedencia_otros+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            
            table.addCell(new Paragraph(objlista_escuelas_por_receta.size()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            
            table.addCell(new Paragraph(cant_nuevo+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_concurrente+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_reingresante+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            
            table.addCell(new Paragraph(objlista_escuelas_por_receta.size()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            
            table.addCell(new Paragraph(cant_masculino+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
            table.addCell(new Paragraph(cant_femenino+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
 
            table.addCell(new Paragraph(objlista_escuelas_por_receta.size()+"").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
    
            table.addCell(new Paragraph(Herramienta.dosDecimales((float)objlista_escuelas_por_receta.size()/cantAcum)+"%").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(fontTamaño));
           
            
        }              
        jtblCuadro.setModel(modelo); 
        jtblCuadro.setGridColor(Color.black);
        //jTable1.setBackground(Color.red);
        //jTable1.setForeground(Color.blue);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtblCuadro.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(5).setCellRenderer(tcr);
           
        jtblCuadro.getColumnModel().getColumn(6).setCellRenderer(tcr);
            
        jtblCuadro.getColumnModel().getColumn(7).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(8).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(9).setCellRenderer(tcr);
            
        jtblCuadro.getColumnModel().getColumn(10).setCellRenderer(tcr);
          
        jtblCuadro.getColumnModel().getColumn(11).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(12).setCellRenderer(tcr);
            
        jtblCuadro.getColumnModel().getColumn(13).setCellRenderer(tcr);
        jtblCuadro.getColumnModel().getColumn(14).setCellRenderer(tcr);

        jtblCuadro.setFont(new java.awt.Font("Tahoma", 0, 9));
        jtblCuadro.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
        jtblCuadro.getTableHeader().setBackground(Color.BLUE);
        jtblCuadro.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
        jtblCuadro.getColumnModel().getColumn(0).setPreferredWidth(140);
        jtblCuadro.getColumnModel().getColumn(1).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(2).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(3).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(4).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(5).setPreferredWidth(10);
            
        jtblCuadro.getColumnModel().getColumn(6).setPreferredWidth(1);
            
        jtblCuadro.getColumnModel().getColumn(7).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(8).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(9).setPreferredWidth(10);
            
        jtblCuadro.getColumnModel().getColumn(10).setPreferredWidth(1);
            
        jtblCuadro.getColumnModel().getColumn(11).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(12).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(13).setPreferredWidth(10);
        jtblCuadro.getColumnModel().getColumn(14).setPreferredWidth(5);
    
        ((DefaultTableCellRenderer)jtblCuadro.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);   
        document.add(paragIma);
        document.add(new Paragraph(" "));    
        document.add(table);   
        document.close(); 
    }   
     public void llenar_tabla_LoteDetalleVencidos(List<Lote_detalle> listaLote){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cant","Fecha Venc."}; 
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
           
            jbtlVencidos.setFont(new java.awt.Font("Tahoma", 0, 10));
            jbtlVencidos.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
            jbtlVencidos.getTableHeader().setBackground(Color.BLUE);
            jbtlVencidos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jbtlVencidos.getColumnModel().getColumn(0).setPreferredWidth(230);
            jbtlVencidos.getColumnModel().getColumn(1).setPreferredWidth(80);
            jbtlVencidos.getColumnModel().getColumn(2).setPreferredWidth(60);    
            jbtlVencidos.getColumnModel().getColumn(3).setPreferredWidth(90);
           
            ((DefaultTableCellRenderer)jbtlVencidos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    
    public void llenar_tabla_LoteDetalle(List<Lote_detalle> listaLote){
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Producto Farmaceutico","Lote","Cant","Fecha Venc."}; 
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
           
            jtblPorVencer.setFont(new java.awt.Font("Tahoma", 0, 10));
            jtblPorVencer.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
            jtblPorVencer.getTableHeader().setBackground(Color.BLUE);
            jtblPorVencer.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblPorVencer.getColumnModel().getColumn(0).setPreferredWidth(230);
            jtblPorVencer.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtblPorVencer.getColumnModel().getColumn(2).setPreferredWidth(60);    
            jtblPorVencer.getColumnModel().getColumn(3).setPreferredWidth(90);
           
            ((DefaultTableCellRenderer)jtblPorVencer.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            //864-550=64                  
    }
    
    public void llenarTabla_EntregasDehoy(List<Detalle_Medicamentos> lista_DetalleMedicamento){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"P.F","Cant"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (Detalle_Medicamentos detalleMedicamento : lista_DetalleMedicamento){
                 fila_actividad[0]=detalleMedicamento.getId_Medicamento().getNombre();
                 fila_actividad[1]=detalleMedicamento.getCantidad();
                 //fila_actividad[2]=detalleMedicamento.getCantidad();
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblEntregasDelDia.setModel(modelo); 
            jtblEntregasDelDia.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblEntregasDelDia.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblEntregasDelDia.getColumnModel().getColumn(1).setCellRenderer(tcr);
            //jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setCellRenderer(tcr);
 
            jtblEntregasDelDia.setFont(new java.awt.Font("Tahoma", 0, 9));
            jtblEntregasDelDia.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
            jtblEntregasDelDia.getTableHeader().setBackground(Color.BLUE);
            jtblEntregasDelDia.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblEntregasDelDia.getColumnModel().getColumn(0).setPreferredWidth(160);
            jtblEntregasDelDia.getColumnModel().getColumn(1).setPreferredWidth(40);
            //jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setPreferredWidth(20);

            ((DefaultTableCellRenderer)jtblEntregasDelDia.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);   
    }
    
    
    public void llenarTabla_EstudiantesCaceritos(List<ZObjetoProDiag> lista_Estudiantes){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Estudiante","Cant"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (int i=lista_Estudiantes.size()-1;i>=0;i--){
                 fila_actividad[0]=lista_Estudiantes.get(i).getObjEstudiante().getPersona().getInfoPersona();
                 fila_actividad[1]=lista_Estudiantes.get(i).getCantidad();
                 //fila_actividad[2]=detalleMedicamento.getCantidad();
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jtblEstudiantesCaceritos.setModel(modelo); 
            jtblEstudiantesCaceritos.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jtblEstudiantesCaceritos.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jtblEstudiantesCaceritos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            //jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setCellRenderer(tcr);
 
            jtblEstudiantesCaceritos.setFont(new java.awt.Font("Tahoma", 0, 9));
            jtblEstudiantesCaceritos.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
            jtblEstudiantesCaceritos.getTableHeader().setBackground(Color.BLUE);
            jtblEstudiantesCaceritos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jtblEstudiantesCaceritos.getColumnModel().getColumn(0).setPreferredWidth(152);
            jtblEstudiantesCaceritos.getColumnModel().getColumn(1).setPreferredWidth(48);
            //jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setPreferredWidth(20);

            
            ((DefaultTableCellRenderer)jtblEstudiantesCaceritos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);   
    }
    public void llenar_UsuariosLista(List<ZObjetoProDiag> lista_UsuariosCant){ 
        DefaultTableModel modelo;
        Object[] fila_actividad;
             //.....................................TABLA......................................
             String [] lista={"Usuarios","Cant"};
             modelo=new DefaultTableModel(null,lista){
                 boolean[] canEdit = new boolean [] {
                     false, false};
                 @Override
                 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     return canEdit [columnIndex];
                     }
                 };
             //.....................................TABLA...........Fin......................
            
             fila_actividad=new Object[modelo.getColumnCount()];  
             for (ZObjetoProDiag ZobjetoProl : lista_UsuariosCant){
                 fila_actividad[0]=ZobjetoProl.getObjRolesMuchos().getNombre_rol();
                 fila_actividad[1]=ZobjetoProl.getCantidad();
                 //fila_actividad[2]=detalleMedicamento.getCantidad();
                 modelo.addRow(fila_actividad);//agregando filas
                 }
            jbtlUsuariosLista.setModel(modelo); 
            jbtlUsuariosLista.setGridColor(Color.black);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jbtlUsuariosLista.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jbtlUsuariosLista.getColumnModel().getColumn(1).setCellRenderer(tcr);
            //jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setCellRenderer(tcr); 
            jbtlUsuariosLista.setFont(new java.awt.Font("Tahoma", 0, 9));
            jbtlUsuariosLista.getTableHeader().setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14));
            jbtlUsuariosLista.getTableHeader().setBackground(Color.BLUE);
            jbtlUsuariosLista.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
            jbtlUsuariosLista.getColumnModel().getColumn(0).setPreferredWidth(151);
            jbtlUsuariosLista.getColumnModel().getColumn(1).setPreferredWidth(49);
            //jtblMedicamentos_porAgotarse.getColumnModel().getColumn(2).setPreferredWidth(20);

            ((DefaultTableCellRenderer)jbtlUsuariosLista.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);   
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EntregasDelDia;
    private javax.swing.JPanel Medicamentosporacabar;
    private javax.swing.JPanel Personal;
    private javax.swing.JPanel Top5Estudiantes;
    private javax.swing.JPanel body;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel head;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jbtlUsuariosLista;
    private javax.swing.JTable jbtlVencidos;
    private javax.swing.JComboBox<ZObjetoProDiag> jcbPorMeses;
    private javax.swing.JComboBox<Semestre> jcbSemestres;
    private javax.swing.JLabel jlblTitleEntregasdelDia;
    private javax.swing.JTable jtblCuadro;
    private javax.swing.JTable jtblEntregasDelDia;
    private javax.swing.JTable jtblEstudiantesCaceritos;
    private javax.swing.JTable jtblMedicamentos_porAgotarse;
    private javax.swing.JTable jtblPorVencer;
    // End of variables declaration//GEN-END:variables

    
    
    
    

}
