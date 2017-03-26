
package com.casaconectada.entity;

/**
 *
 * @author Gleisongjs
 */
public   class  teste {
    
    public  static class  Sensor {
    
    private  static int id;
    private static int cont=0;
    private static String tempoAtual;
    private static String Distancia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(String tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String Distancia) {
        this.Distancia = Distancia;
    }
    
    
}

    
}
