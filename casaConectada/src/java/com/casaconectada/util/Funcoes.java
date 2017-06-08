
package com.casaconectada.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.GregorianCalendar;

/**
 *
 * @author Gleisongjs
 */
public class Funcoes {
    
    String data = "dd/MM/YYYY";
    String hora = "h:mm - a";
    String data1, hora1;
    
    
    public void DataHora (){
        
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);  
        
        
    }
    
}
