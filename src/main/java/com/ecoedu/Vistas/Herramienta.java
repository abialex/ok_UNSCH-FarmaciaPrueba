/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoedu.Vistas;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;

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
    
}
