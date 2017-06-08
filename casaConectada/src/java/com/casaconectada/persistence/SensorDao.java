
package com.casaconectada.persistence;

import com.casaconectada.connection.ConnectionFactory;
import com.casaconectada.controller.sistemaLaylaDB;
import com.casaconectada.entity.Sensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gleisongjs
 */
public class SensorDao {
    
    String sql;
    
    public boolean incluir(Sensor.SensorStatic sensor){
        
        boolean isOk = false;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        
        if (conn == null){
            return isOk;
        }
        
        String sql = "INSERT INTO  sensor(distancia,tempoatual,cont,data,hora) VALUES(?,?,?,?,?);";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, Sensor.SensorStatic.getDistancia());
            ps.setString(2, Sensor.SensorStatic.getTempoAtual());
            ps.setString(3, Sensor.SensorStatic.getCont());
            ps.setString(4, Sensor.SensorStatic.getData());
            ps.setString(5, Sensor.SensorStatic.getHora());
            ps.executeUpdate();
            //testdb = "Sensor Cadastrado com Sucesso";
            isOk = true;
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
            //testdb = "Ops! deu ruim";
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
        
        return isOk;
    }

    
    public boolean alterar(Sensor.SensorStatic sensor){
        
        boolean isOk = false;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        
        if (conn == null){
            return isOk;
        }
                        
        return isOk;
    }

    
    public boolean Excluir(int id){
        
        boolean isOk = false;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        
        if (conn == null){
            return isOk;
        }
        
        sql = "DELETE FROM sensor WHERE id=?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            isOk = true;
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
        
        return isOk;
    }

    
    
    public Sensor.SensorStatic getSensor(int id){
        
        Sensor.SensorStatic sensor = null;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (conn == null){
            return sensor;
        }
        
        sql = "SELECT * FROM sensor WHERE id=?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
           if(rs.next()){
                
                Sensor.SensorStatic.setId(rs.getInt("id"));
                Sensor.SensorStatic.setDistancia(rs.getString("distancia"));
                Sensor.SensorStatic.setTempoAtual(rs.getString("tempoatual"));
                Sensor.SensorStatic.setCont(rs.getString("cont"));
                Sensor.SensorStatic.setData(rs.getString("data"));
                Sensor.SensorStatic.setHora(rs.getString("hora"));
                               
                     
            }
                 
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        
        return sensor;
    }
    
    
    public List<Sensor.SensorStatic> getSensor(){
        
        List<Sensor.SensorStatic> lstSensor = null;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String res="";
        
        if (conn == null){
            return lstSensor;
        }
        
         String sql = "SELECT * FROM sensor ORDER BY id DESC LIMIT 200;";
        
       try {
           ps = conn.prepareStatement(sql);
           
           rs = ps.executeQuery();
           while(rs.next()){
               
               Sensor.SensorStatic sensor = new Sensor.SensorStatic();
               
             
               sensor.setId(rs.getInt("id"));
               sensor.setDistancia(rs.getString("distancia"));
               sensor.setTempoAtual(rs.getString("tempoatual"));
               sensor.setCont(rs.getString("cont"));
               sensor.setData(rs.getString("data"));
               sensor.setHora(rs.getString("hora"));
               
               
               lstSensor.add(sensor);
           }
           
           
           
       } catch (SQLException ex) {
           Logger.getLogger(sistemaLaylaDB.class.getName()).log(Level.SEVERE, null, ex);
           res = "Erro ao listar o sensor!";
       }finally{
           ConnectionFactory.closeConnection(conn, ps, rs);
       }
       
       return lstSensor;
    
    }
    
}
