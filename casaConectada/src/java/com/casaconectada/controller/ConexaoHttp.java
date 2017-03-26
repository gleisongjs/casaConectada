/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casaconectada.controller;


import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


/**
 *
 * @author RuWindows
 */
public class ConexaoHttp {
    
    
     private static String url = "http://192.168.0.13/?";

     
    
// add     request     Header
     
     
     public static void  main(String args[]){
     
         System.err.println( new ConexaoHttp().com(""));
         
     }
     
 public boolean com(String action){
 try {
       HttpClient client = HttpClientBuilder.create().build();
     HttpGet request = new HttpGet(url+action); 
     HttpResponse response; 
        
             response = client.execute(request);
                 
                 
     if( response.getStatusLine().getStatusCode()==200){
     
     return true;
     }
     
     
        } catch (IOException ex) {
             
            return false;
         }
  
 
 return false;
 }
      
  
    
}
