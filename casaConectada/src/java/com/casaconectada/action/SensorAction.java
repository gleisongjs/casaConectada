
package com.casaconectada.action;

import com.casaconectada.controller.ConexaoHttp;
import com.casaconectada.entity.Sensor;
import com.casaconectada.persistence.SensorDao;
import com.casaconectada.twitter.TwitterCasa;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Session;

/**
 *
 * @author trnsformers
 */
public class SensorAction {
    
    
    TwitterCasa twittando = new TwitterCasa();

    Sensor.SensorStatic sensor = new Sensor.SensorStatic();
    ConexaoHttp conexaoHttp = new ConexaoHttp();
    
    String msg = "";

    String data = "dd/MM/YYYY";
    String hora = "HH:mm:ss";
    String data1, hora1;

    public static String btnLed = "f";
    public static String btnAgua = "f";
    Session s;
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        request.getSession().setAttribute("led", btnLed);
        request.getSession().setAttribute("agua", btnAgua);

        String action = request.getParameter("action");
        
        
        if (action.equals("layla")) {
            
            //recebendo os dados
            if (save(request)) {
                request.setAttribute("msg", "Operação realizada com Sucesso!");
            } else {
                request.setAttribute("msg", "Erro ao realizar a operação!");
            }
           
            
            
            //String carregando dados para devolver a página layla
            msg = "<br/> Distância: " + Sensor.SensorStatic.getDistancia() + " - Centimetros";
            msg += "<hr/><br/> Tempo Atual: " + Sensor.SensorStatic.getTempoAtual() + " - Minutos";
            msg += "<hr/><br/> Quantidade: " + Sensor.SensorStatic.getCont();

            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("layla.jsp").forward(request, response);
            request.setAttribute("objSensor", new Sensor());

            return;
        }
        
        //on/off led
        if (action.equals("led")) {
            if (btnLed == "t") {

                if (conexaoHttp.com("ledoff")) {
                    btnLed = "f";
                }
            } else {

                if (conexaoHttp.com("ledon")) {
                    btnLed = "t";

                }
            }

            msg = "<br/> Distância: " + Sensor.SensorStatic.getDistancia() + " - Centimetros";
            msg += "<hr/><br/> Tempo Atual: " + Sensor.SensorStatic.getTempoAtual() + " - Minutos";
            msg += "<hr/><br/> Quantidade: " + Sensor.SensorStatic.getCont();

            request.getSession().setAttribute("led", btnLed);
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("layla.jsp").forward(request, response);

        }

        
        //on/off água
        if (action.equals("agua")) {
            if (btnAgua == "t") {

                if (conexaoHttp.com("aguaoff")) {
                    btnAgua = "f";
                }
            } else {

                if (conexaoHttp.com("aguaon")) {
                    btnAgua = "t";
                }
            }

            msg = "<br/> Distância: " + Sensor.SensorStatic.getDistancia() + " - Centimetros";
            msg += "<hr/><br/> Tempo Atual: " + Sensor.SensorStatic.getTempoAtual() + " - Minutos";
            msg += "<hr/><br/> Quantidade: " + Sensor.SensorStatic.getCont();

            request.getSession().setAttribute("agua", btnAgua);
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("layla.jsp").forward(request, response);

        }

        request.getSession().setAttribute("led", btnLed);

        request.getSession().setAttribute("agua", btnAgua);
 
        
    }

    //request dos dados de entrada
    private boolean save(HttpServletRequest request) {

       DateHora();

        if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {
            Sensor.SensorStatic.setDistancia(request.getParameter("distancia"));
            Sensor.SensorStatic.setTempoAtual(request.getParameter("tempoAtual"));
            Sensor.SensorStatic.setCont(request.getParameter("cont"));
            Sensor.SensorStatic.setData(data1);
            Sensor.SensorStatic.setHora(hora1);
        }
        
        //condição para twittar
            if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {

                float centimetro;

                centimetro = (float) Float.parseFloat((String) request.getParameter("distancia"));

                if (centimetro != 0 && centimetro < 75) {

                    twittando.tw("@GleisonJSilva O Sistema layla liberou 0,5 L de água. Distância da layla ao sensor: " + centimetro + " Centimetros.");
                }
            }
        
            return new SensorDao().incluir(sensor);
        
    }
    
    // request da data e hora atual
    public void DateHora() {

        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);

    }
    
}
