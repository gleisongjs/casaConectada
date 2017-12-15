/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casaconectada.entity;

/**
 *
 * @author gleisongjs
 * em 08/12/2017
 */
public class Dispositivo {
    
    public static class DispositivoStatic{
        
        private static int id;
    private static String nome;
    private static String mac;

    /**
     * @return the id
     */
    public static int getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id = aId;
    }

    /**
     * @return the nome
     */
    public static String getNome() {
        return nome;
    }

    /**
     * @param aNome the nome to set
     */
    public static void setNome(String aNome) {
        nome = aNome;
    }

    /**
     * @return the mac
     */
    public static String getMac() {
        return mac;
    }

    /**
     * @param aMac the mac to set
     */
    public static void setMac(String aMac) {
        mac = aMac;
    }
        
    }
    
    
    
}
