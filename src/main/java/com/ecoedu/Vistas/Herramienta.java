/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author yrma
 */
public class Herramienta { 
    public  static void main(String asdasd[]){
        String encriptado=DigestUtils.md5Hex("123456");
        String encriptado2=DigestUtils.md5Hex("alexcito");
        System.out.println(encriptado.equals(encriptado2));
        System.out.println(DigestUtils.md5Hex(encriptado));
        System.out.println(DigestUtils.md5Hex(encriptado2));
        
    }
    public static float redondeo(float a){
       int b=(int)a*100;
       int uy=b/100;
       float u =(a*100)%10;
       int d=(int)((a*10)%10);
        System.out.println(d+" "+u);
       if(u>=5){
           d++;
       }
       
       return Float.parseFloat(uy+"."+d+"0");
    }
    
  
    
    public static String dosDecimales(float a){
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#0.00", separador);
        return formato1.format(a);        
    }
    public static String unDecimales(float a){
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#0.0", separador);
        return formato1.format(a);        
    }
    public static String formatoFecha(Date fecha){
        return (1900+fecha.getYear())+"-"+conOsin0(fecha.getMonth()+1)+"-"+conOsin0(fecha.getDate());
    }
    public static String formatoFechaHora(Date fecha){
        return (1900+fecha.getYear())+"-"+conOsin0(fecha.getMonth())+"-"+conOsin0(fecha.getDate())
                +" "+conOsin0(fecha.getHours())+":"+conOsin0(fecha.getMinutes())+":"+conOsin0(fecha.getSeconds());
    }
    public static String formatoFechaHoraMas1(Date fecha){
        return (1900+fecha.getYear())+"-"+conOsin0(fecha.getMonth()+1)+"-"+conOsin0(fecha.getDate())
                +" "+conOsin0(fecha.getHours())+":"+conOsin0(fecha.getMinutes())+":"+conOsin0(fecha.getSeconds());
    }
    public static boolean fechaMenor(Date fechamenor,Date fechaMayor){
        return fechamenor.getTime()<=fechaMayor.getTime();
        
    }
    
    public static String getNombreMes(int a){
        switch(a){
            case 0:
                return "diciembre";
            case 1:
                return "ENERO";                
            case 2:
                return "FEBRERO";
            case 3:
                return "MARZO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAYO";
            case 6:
                return "JUNIO";
            case 7:
                return "JULIO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SETIEMBRE";
            case 10:
                return "OCTUBRE";
            case 11:
                return "NOVIEMBRE";
            case 12:
                return "DICIEMBRE";
                }
        return a+"";
        }
     
    
    
    public static String formatoFechaMas1(Date fecha){
        return (1900+fecha.getYear())+"-"+conOsin0(fecha.getMonth()+1)+"-"+conOsin0(fecha.getDate());
    }
    public static String conOsin0(int numero){
        if(numero<10){
            return "0"+numero;
        }
        else{
            return numero+"";
        }                    
    }
    public static String Mayusculas(String cadenita){//solo identifica espaciios
        String cadenota=""+(char)(cadenita.charAt(0)-32);
        for (int i = 1; i < cadenita.length(); i++) {    
            if(cadenita.charAt(i)==' '){
                cadenota=cadenota+" "+(char)(cadenita.charAt(i+1)-32);
                i++;                
            }
            else{
                cadenota=cadenota+cadenita.charAt(i);
            }
        }
        return cadenota;
    }
    public static <T> List<T> findbyLike(Class<T> generico,String Columna,String palabra,EntityManager jpa){
        List<T> listGenericos = new ArrayList<T>();
        //System.out.println("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna +"LIKE "+"'"+palabra+"%"+"'");
        Query query=jpa.createQuery
        ("SELECT p FROM "+generico.getSimpleName()+" p where id_DiagnosticoCodigo LIKE "+"'"+palabra+"%'");
        listGenericos=query.getResultList(); 
        return listGenericos; 
    }
    public static int getAñosFrom(Date fechaNac){
        int dias=(int)(((new Date()).getTime()-fechaNac.getTime())/86400000);         
        return (int)(dias/365);
    }
    
    /*
    public static T findByPropiedad(T generico,String Column,int idFk,EntityManager jpa){
        return null;
        
    }*/
    public static void Prueba(){
        String fechaInicio="2019-08-29";
        String año="";
        String mes="";
        String dia="";
        for (int i = 0; i < fechaInicio.length(); i++){
            if(i<=3){
                año=año+fechaInicio.charAt(i);                
            }
            if(i==5||i==6){
                mes=mes+fechaInicio.charAt(i);                
            }
            if(i==8||i==9){
                dia=dia+fechaInicio.charAt(i);                
            }           
        }
        System.out.println("select ¨*from Cologiado where fecheInscripcion between"+"'"+año+"-"+mes+"-"+dia+"'"+
                "and"+"'"+año+"-"+mes+"-"+dia+"'");
    }
    public static <T> List<T> findbyBeetWeen(Class<T> generico,String Columna,Date FechaInicio,Date FechaFin,EntityManager jpa){
        List<T> listGenericos=new ArrayList<>();
        try {
            Query query=jpa.createQuery("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna+" BETWEEN "+"'"+
            (FechaInicio.getYear()+1900)+(Herramienta.conOsin0(FechaInicio.getMonth()+1))+(Herramienta.conOsin0(FechaInicio.getDate())+" 00:00:00 ")+"'"
            +" and "+"'"+
            (FechaFin.getYear()+1900)+(Herramienta.conOsin0(FechaFin.getMonth()+1))+(Herramienta.conOsin0(FechaFin.getDate()))+" 23:59:59 "+"'");
        listGenericos=query.getResultList();  
            
        } catch (Exception e) {
            System.out.println(e.toString()+" HUBO ERROR DE CONSULTA");
        }               
        return listGenericos; 
    }
    //
    public static <T> List<T> findbyBeetWeen(Class<T> generico,String Columna,Date FechaInicio,Date FechaFin,EntityManager jpa,int id_Lote_Detalle){
        List<T> listGenericos=new ArrayList<>();
        try {
            Query query=jpa.createQuery("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna+" BETWEEN "+"'"+
            (FechaInicio.getYear()+1900)+(Herramienta.conOsin0(FechaInicio.getMonth()+1))+(Herramienta.conOsin0(FechaInicio.getDate())+" 00:00:00 ")+"'"
            +" and "+"'"+
            (FechaFin.getYear()+1900)+(Herramienta.conOsin0(FechaFin.getMonth()+1))+(Herramienta.conOsin0(FechaFin.getDate()))+" 23:59:59 "+"'"
            +"and id_Lote_detalle="+id_Lote_Detalle);
        listGenericos=query.getResultList();  
            
        } catch (Exception e) {
            System.out.println(e.toString()+" HUBO ERROR DE CONSULTA");
        }               
        return listGenericos; 
    }
    
    public static <T> List<T> findbyBeetWeen(Class<T> generico,String Columna,Date FechaInicio,Date FechaFin,int idControl,EntityManager jpa){
        List<T> listGenericos=new ArrayList<>();
        try {
            Query query=jpa.createQuery("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna+" BETWEEN "+"'"+
            (FechaInicio.getYear()+1900)+(Herramienta.conOsin0(FechaInicio.getMonth()+1))+(Herramienta.conOsin0(FechaInicio.getDate())+" 00:00:00 ")+"'"
            +" and "+"'"+
            (FechaFin.getYear()+1900)+(Herramienta.conOsin0(FechaFin.getMonth()+1))+(Herramienta.conOsin0(FechaFin.getDate()))+" 23:59:59 "+"'"
            +" and id_Control_paciente = "+idControl);
        listGenericos=query.getResultList();  
            
        } catch (Exception e) {
            System.out.println(e.toString()+" HUBO ERROR DE CONSULTA");
        }               
        return listGenericos; 
    }
    public static <T> List<T> findbyWhere(Class<T> generico,String Columna,int idFK,EntityManager jpa){
        List<T> listGenericos=new ArrayList<>();
        try {
            System.out.println("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna+" = "+idFK);
            Query query=jpa.createQuery             
        ("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna+" = "+idFK);
        listGenericos=query.getResultList(); 
            
        } catch (Exception e) {
            System.out.println(e.toString()+" rrr");
        }               
        return listGenericos; 
    }
    public static boolean BettwenFechas(Date fechaDesde,Date fechaConsulta,Date fechaHasta){
                   if(fechaDesde.getTime()<=fechaConsulta.getTime() && fechaConsulta.getTime()<=fechaHasta.getTime()+86399999){
                       return true;
                   }                  
        return false;
    }
    
    public static boolean iSigualFechas(Date fecha1,Date fecha2){        
        if(fecha1.getYear()==fecha2.getYear()){
            if(fecha1.getMonth()==fecha2.getMonth()){
                if(fecha1.getDate()==fecha2.getDate()){
                    return true;
                }
            }
        }        
        return false;
    }
    
            
    
}
