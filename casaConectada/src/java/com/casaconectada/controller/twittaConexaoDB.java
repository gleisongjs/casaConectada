
package com.casaconectada.controller;

import com.casaconectada.connection.ConnectionFactory;
import com.casaconectada.entity.Dispositivo;
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
 * @author trnsformers
 */
public class twittaConexaoDB extends HttpServlet {

       
@Override    
protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        String msg = "";
                     
        //Incluindo dispositivo
        if (action.equals ("incluidispositivo")){
        
            if (!(msg.equals(request.getParameter("nome")) || request.getParameter("nome") == null)) {
            Dispositivo.DispositivoStatic.setNome(request.getParameter("nome"));
            Dispositivo.DispositivoStatic.setMac(request.getParameter("mac"));            
        }
        
                                   
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO mac (nome, mac) VALUES(?,?);";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, Dispositivo.DispositivoStatic.getNome());
            ps.setString(2, Dispositivo.DispositivoStatic.getMac());
            ps.executeUpdate();
            //testdb = "Dispositivo Cadastrado com Sucesso";

        } catch (SQLException ex) {
            Logger.getLogger(casaConectadaSV.class.getName()).log(Level.SEVERE, null, ex);
            //testdb = "Ops! deu ruim";
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
        
        //request.setAttribute("resultado", res);
        request.getRequestDispatcher("twittaConexaoDB.jsp").forward(request, response);
            
        }
        
                
        //listando a tabela mac
        if (action.equals ("twittaconexaodb")){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String res="";
        
        String sql = "SELECT * FROM mac ORDER BY id DESC LIMIT 200;";
        
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
               res += "<div class=\"col-md-5\">";
               res += "<br/>Nome: "+rs.getString("nome");
               res += "</div>";
               res += "<div class=\"col-md-5\">";
               res += "<br/>Mac: "+rs.getString("mac");
               res += "</div>";
               
               res += "</div>\n" +
"              </div>";
               res += "<hr/>";
           }
           
           
           
       } catch (SQLException ex) {
           Logger.getLogger(sistemaLaylaDB.class.getName()).log(Level.SEVERE, null, ex);
           res = "Erro ao listar a tabela de mac!";
       }finally{
           ConnectionFactory.closeConnection(conn, ps, rs);
       }
       
       request.setAttribute("resultado", res);
       request.getRequestDispatcher("twittaConexaoDB.jsp").forward(request, response);
        
    }
}

}
