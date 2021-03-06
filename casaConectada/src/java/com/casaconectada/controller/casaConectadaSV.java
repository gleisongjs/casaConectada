package com.casaconectada.controller;

import com.casaconectada.connection.ConnectionFactory;
import com.casaconectada.twitter.TwitterCasa;

import com.casaconectada.entity.Sensor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

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

    String data = "dd/MM/YYYY";
    String hora = "HH:mm:ss";
    String data1, hora1;

    public static String btnLed = "f";
    public static String btnAgua = "f";
    Session s;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String testdb = "";

        response.setContentType("text/html;charset=UTF-8");

        DateHora();

        if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {
            Sensor.SensorStatic.setDistancia(request.getParameter("distancia"));
            Sensor.SensorStatic.setTempoAtual(request.getParameter("tempoAtual"));
            Sensor.SensorStatic.setCont(request.getParameter("cont"));
            Sensor.SensorStatic.setData(data1);
            Sensor.SensorStatic.setHora(hora1);
        }

        request.getSession().setAttribute("led", btnLed);
        request.getSession().setAttribute("agua", btnAgua);

        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement ps = null;

        String sql = "INSERT INTO  sensor(distancia,tempoatual,cont,data, hora) VALUES(?,?,?,?,?);";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, Sensor.SensorStatic.getDistancia());
            ps.setString(2, Sensor.SensorStatic.getTempoAtual());
            ps.setString(3, Sensor.SensorStatic.getCont());
            ps.setString(4, Sensor.SensorStatic.getData());
            ps.setString(5, Sensor.SensorStatic.getHora());
            ps.executeUpdate();
            //testdb = "Sensor Cadastrado com Sucesso";

        } catch (SQLException ex) {
            Logger.getLogger(casaConectadaSV.class.getName()).log(Level.SEVERE, null, ex);
            //testdb = "Ops! deu ruim";
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        String action = request.getParameter("action");

        if (action.equals("layla")) {
            if (!(msg.equals(request.getParameter("distancia")) || request.getParameter("distancia") == null)) {

                float centimetro;

                centimetro = (float) Float.parseFloat((String) request.getParameter("distancia"));

                if (centimetro != 0 && centimetro < 75) {

                    twittando.tw("@GleisonJSilva O Sistema layla liberou 0,5 L de água. Distância da layla ao sensor: " + centimetro + " Centimetros.");
                }
            }

            msg = "<br/> Distância: " + Sensor.SensorStatic.getDistancia() + " - Centimetros";
            msg += "<hr/><br/> Tempo Atual: " + Sensor.SensorStatic.getTempoAtual() + " - Minutos";
            msg += "<hr/><br/> Quantidade: " + Sensor.SensorStatic.getCont();

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

// Metodo que faz o request da data e hora atual
    public void DateHora() {

        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);

    }
}
