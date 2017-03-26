package com.casaconectada.controller;

import com.casaconectada.entity.ConectaDrone;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gleisongjs
 */
public class DroneSV extends HttpServlet {

    ConectaDrone.drone drone = new ConectaDrone.drone();
    String msg = "";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action.equals("drone")) {
            drone.setAltura(request.getParameter("nome"));
            drone.setAltura(request.getParameter("altura"));
            drone.setAltura(request.getParameter("velocidade"));
            drone.setAltura(request.getParameter("distancia"));
            drone.setAltura(request.getParameter("bateria"));
            drone.setAltura(request.getParameter("temperatura"));
            drone.setAltura(request.getParameter("umidade"));
            drone.setAltura(request.getParameter("posicao"));
            drone.setAltura(request.getParameter("tempo"));

            msg = "<br/> Nome: " + drone.getNome();
            msg += "</><t/> Altura: " + drone.getAltura();
            msg += "<hr/><br/> Velocidade: " + drone.getVelocidade();
            msg += "<hr/><br/> Distância: " + drone.getDistancia();
            msg += "<hr/><br/> Bateria: " + drone.getBateria();
            msg += "<hr/><br/> Temperatura: " + drone.getTemperatura();
            msg += "<hr/><br/> Umidade: " + drone.getUmidade();
            msg += "<hr/><br/> Posição: " + drone.getPosicao();
            msg += "<hr/><br/> Tempo em Execução: " + drone.getTempo();

            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("drone.jsp").forward(request, response);

            return;

        }

        if (action.equals("armar")) {
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("drone.jsp").forward(request, response);
        }

        if (action.equals("decolar")) {
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("drone.jsp").forward(request, response);
        }

        if (action.equals("retornar")) {
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("drone.jsp").forward(request, response);
        }

        if (action.equals("desarmar")) {
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("drone.jsp").forward(request, response);
        }

    }
}
