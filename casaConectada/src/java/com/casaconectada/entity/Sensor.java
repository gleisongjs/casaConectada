
package com.casaconectada.entity;

/**
 *
 * @author Gleisongjs
 */
public  class  Sensor {
    
    public  static class  SensorStatic {
    
    private  static int id;
    private static String cont;
    private static String tempoAtual;
    private static String Distancia;

        public static int getId() {
            return id;
        }

        public static void setId(int aId) {
            id = aId;
        }

        public static String getCont() {
            return cont;
        }

        public static void setCont(String aCont) {
            cont = aCont;
        }

        public static String getTempoAtual() {
            return tempoAtual;
        }

        public static void setTempoAtual(String aTempoAtual) {
            tempoAtual = aTempoAtual;
        }

        public static String getDistancia() {
            return Distancia;
        }

        public static void setDistancia(String aDistancia) {
            Distancia = aDistancia;
        }

        
    }
    
}
