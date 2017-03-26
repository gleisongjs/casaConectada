/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casaconectada.entity;

/**
 *
 * @author Gleisongjs
 */
public class ConectaDrone {
    
    public static class drone{
        
        private static int id;
        private static String nome;
        private static String altura;
        private static String velocidade;
        private static String distancia;
        private static String bateria;
        private static String temperatura;
        private static String umidade;
        private static String posicao;
        private static String tempo;

        public static int getId() {
            return id;
        }

        public static void setId(int aId) {
            id = aId;
        }

        public static String getNome() {
            return nome;
        }

        public static void setNome(String aNome) {
            nome = aNome;
        }

        public static String getAltura() {
            return altura;
        }

        public static void setAltura(String aAltura) {
            altura = aAltura;
        }

        public static String getVelocidade() {
            return velocidade;
        }

        public static void setVelocidade(String aVelocidade) {
            velocidade = aVelocidade;
        }

        public static String getDistancia() {
            return distancia;
        }

        public static void setDistancia(String aDistancia) {
            distancia = aDistancia;
        }

        public static String getBateria() {
            return bateria;
        }

        public static void setBateria(String aBateria) {
            bateria = aBateria;
        }

        public static String getTemperatura() {
            return temperatura;
        }

        public static void setTemperatura(String aTemperatura) {
            temperatura = aTemperatura;
        }

        public static String getUmidade() {
            return umidade;
        }

        public static void setUmidade(String aUmidade) {
            umidade = aUmidade;
        }

        public static String getPosicao() {
            return posicao;
        }

        public static void setPosicao(String aPosicao) {
            posicao = aPosicao;
        }

        public static String getTempo() {
            return tempo;
        }

        public static void setTempo(String aTempo) {
            tempo = aTempo;
        }
        
        
        
    }
    
}
