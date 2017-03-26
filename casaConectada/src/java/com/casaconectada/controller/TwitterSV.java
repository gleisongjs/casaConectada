
package com.casaconectada.controller;

import com.casaconectada.entity.Sensor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author RuWindows
 */
public class TwitterSV extends HttpServlet   {
   String msg = "";
   
   
protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
            
            request.setAttribute("resultado", msg);
            request.getRequestDispatcher("layla.jsp").forward(request, response);
        
        ConfigurationBuilder builder = new ConfigurationBuilder();
			
			builder.setOAuthConsumerKey("9yVXdpHRetwN643Qux2TE2C14");
			builder.setOAuthConsumerSecret( "sBmujbqdIwnKD8ucd96p3bsam3MguiSThFXbMzzJLgQI4M4rl6");
			
			Configuration configuration = builder.build();
 
			TwitterFactory factory = new TwitterFactory(configuration);
			Twitter twitter = factory.getInstance();      
 
			AccessToken accessToken = loadAccessToken();
 
			twitter.setOAuthAccessToken(accessToken);
                        
			Status status = null;
    try {
        status = twitter.updateStatus("Arduino Twittando novamente @Gleisonjsilva");
    } catch (TwitterException ex) {
        Logger.getLogger(TwitterSV.class.getName()).log(Level.SEVERE, null, ex);
    }
			//System.out.println("Tweet postado com sucesso! " + status.getText() + "");
    
    
    
		
    }

private static AccessToken loadAccessToken(){
		String token = "832896102366068736-V2zAYhuAA8D6n0GvFjPyqitSZo1jvsX"; 
		String tokenSecret = "31ORvOjvpxU3bRYVVAgSG2vt8lxTlNbBYOCESiFeWODiZ"; 
		return new AccessToken(token, tokenSecret);
        }
}
