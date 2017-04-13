package com.casaconectada.controller;

import com.casaconectada.connection.ConnectionFactory;
import com.casaconectada.twitter.TwitterCasa;

import com.casaconectada.entity.Sensor;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Session;


/**
 *
 * @author Gleisongjs
 */
public class casaConectadaSV extends HttpServlet {
    
   
    TwitterCasa twittando = new TwitterCasa();
    
    Sensor.SensorStatic sensor = new Sensor.SensorStatic();
    ConexaoHttp conexaoHttp = new ConexaoHttp();
    String msg = "";
    
    public static String btnLed = "f";
    public static String btnAgua = "f";
    Session s;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String testdb = "";
        response.setContentType("text/html;charset=UTF-8");

                
        
        request.getSession().setAttribute("led", btnLed);
        request.getSession().setAttribute("agua", btnAgua);
        
        Connection conn = ConnectionFactory.getConnection();
        
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO  sensor(distancia,tempoatual,cont) VALUES(?,?,?);";
        
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, request.getParameter("distancia"));
            ps.setString(2, request.getParameter("tempoAtual"));
            ps.setString(3, request.getParameter("cont"));
            ps.executeUpdate();
            //testdb = "Sensor Cadastrado com Sucesso";
            
               
        } catch (SQLException ex) {
            Logger.getLogger(casaConectadaSV.class.getName()).log(Level.SEVERE, null, ex);
            //testdb = "Ops! deu ruim";
            System.out.println(ex);
        } finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
            

        String action = request.getParameter("action");

        if (action.equals("layla")) {
            
                            
        
        
            if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {

                float centimetro;
                
                centimetro = (float) Float.parseFloat((String) request.getParameter("distancia"));
                Sensor.SensorStatic.setDistancia(""+ centimetro);
                
                if (centimetro != 0 && centimetro < 70)
                {
                    twittando.tw("@GleisonJSilva O Sistema layla acabou de liberar 0,5 L de água. Distância da layla ao sensor: "+centimetro+" Centimetros.");
                }
                
                //Sensor.SensorStatic.setDistancia(request.getParameter("distancia"));
                
                Sensor.SensorStatic.setCont(request.getParameter("cont"));
                Integer x;
                x = (Integer) Integer.parseInt((String) request.getParameter("tempoAtual"));
                Sensor.SensorStatic.setTempoAtual("" + (x / 60000));
            }

            msg = "<br/> Distância: " + Sensor.SensorStatic.getDistancia() + " - Centimetros";
            msg += "<hr/><br/> Tempo Atual: " + Sensor.SensorStatic.getTempoAtual() + " - Minutos";
            msg += "<hr/><br/> Quantidade: " + Sensor.SensorStatic.getCont();
            //msg += "<hr/><br/> Teste db: " + testdb;
            
                        
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("layla.jsp").forward(request, response);
            
            

            return;
        }

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

            if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {

                Sensor.SensorStatic.setDistancia(request.getParameter("distancia"));
                Sensor.SensorStatic.setCont(request.getParameter("cont"));
                Integer x;
                x = (Integer) Integer.parseInt((String) request.getParameter("tempoAtual"));
                Sensor.SensorStatic.setTempoAtual("" + (x / 60000));
            }

            msg = "<br/> Distância: " + Sensor.SensorStatic.getDistancia() + " - Centimetros";
            msg += "<hr/><br/> Tempo Atual: " + Sensor.SensorStatic.getTempoAtual() + " - Minutos";
            msg += "<hr/><br/> Quantidade: " + Sensor.SensorStatic.getCont();

            request.getSession().setAttribute("led", btnLed);
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("layla.jsp").forward(request, response);

        }

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

            if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {

                Sensor.SensorStatic.setDistancia(request.getParameter("distancia"));
                Sensor.SensorStatic.setCont(request.getParameter("cont"));
                Integer x;
                x = (Integer) Integer.parseInt((String) request.getParameter("tempoAtual"));
                Sensor.SensorStatic.setTempoAtual("" + (x / 60000));
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
    
//    private boolean save(HttpServletRequest request) {
//        Sensor.SensorStatic sensor = new Sensor.SensorStatic();
//        sensor.setId(Integer.parseInt(request.getParameter("id")));
//        sensor.setDistancia(request.getParameter("distancia"));
//        sensor.setTempoAtual(request.getParameter("tempoAtual"));
//        sensor.setCont(request.getParameter("cont"));
//        
//        if (sensor.getId() == 0) {
//
//            return new SensorDao().incluir(sensor);
//
//        } else {
//            return new SensorDao().alterar(sensor);
//        }
//        
//        
//    }
//    if (save(request)) {
//                request.setAttribute("msg", "Operação realizada com Sucesso");
//            } else {
//                request.setAttribute("msg", "Ops!! Operação não realizada");
//            }
    
}
