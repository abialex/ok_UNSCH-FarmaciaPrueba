/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas;

import com.ecoedu.app.JPAUtil;
import com.ecoedu.model.Diagnostico;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.PlainDocument;
/**
 *
 * @author yrma
 */
public class Herramienta { 
    
  
    public static String dosDecimales(float a){
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#0.00", separador);
        System.out.println(formato1.format(a));
        return formato1.format(a);        
    }
    public static String unDecimales(float a){
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#0.0", separador);
        return formato1.format(a);        
    }
    public static String formatoFecha(Date fecha){
        return (1900+fecha.getYear())+"-"+conOsin0(fecha.getMonth())+"-"+conOsin0(fecha.getDate());
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
    public static <T> List<T> findbyWhere(Class<T> generico,String Columna,int idFK,EntityManager jpa){
        List<T> listGenericos;
        //System.out.println("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna +"LIKE "+"'"+palabra+"%"+"'");
        Query query=jpa.createQuery             
        ("SELECT p FROM "+generico.getSimpleName()+" p where "+Columna+" = "+idFK);
        listGenericos=query.getResultList(); 
         
        return listGenericos; 
    }
    
            
    
}
