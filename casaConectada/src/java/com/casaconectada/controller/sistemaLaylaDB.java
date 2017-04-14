
package com.casaconectada.controller;

import com.casaconectada.connection.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RuWindows
 */
public class sistemaLaylaDB extends HttpServlet {
   
   
@Override    
protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        
        if (action.equals ("layladb")){
        Connection conn = ConnectionFactory.getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        String res="";
        
        String sql = "SELECT * FROM sensor ORDER BY id DESC;";
        
       try {
           ps = conn.prepareStatement(sql);
           
           rs = ps.executeQuery();
           while(rs.next()){
               res += " <div class=\"panel-body\">\n" +
"                                <div class=\"form-group\">";
               res += "<hr/>";
               res += "<div class=\"col-md-2\">";
               res += "<br/>ID: " + rs.getInt("id");
               res += "</div>";
               res += "<div class=\"col-md-2\">";
               res += "<br/>Distância: "+rs.getString("distancia");
               res += "</div>";
               res += "<div class=\"col-md-2\">";
               res += "<br/>Tempo Atual: "+rs.getString("tempoatual");
               res += "</div>";
               res += "<div class=\"col-md-2\">";
               res += "<br/>Quantidade: "+rs.getString("cont");
               res += "</div>";               
               res += "<div class=\"col-md-2\">";
               res += "<br/>Data: "+rs.getString("data");
               res += "</div>";               
               res += "<div class=\"col-md-2\">";
               res += "<br/>Hora: "+rs.getString("hora");
               res += "</div>";               
               res += "</div>\n" +
"                        </div>";
               res += "<hr/>";
           }
           
           
           
       } catch (SQLException ex) {
           Logger.getLogger(sistemaLaylaDB.class.getName()).log(Level.SEVERE, null, ex);
           res = "Erro ao listar o sensor!";
       }finally{
           ConnectionFactory.closeConnection(conn, ps, rs);
       }
       
       request.setAttribute("resultado", res);
       request.getRequestDispatcher("laylaDb.jsp").forward(request, response);
        
    }
}

        }
    
