
package com.casaconectada.persistence;

import com.casaconectada.connection.ConnectionFactory;
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
        
        sql = "INSERT INTO TabelaSensor(distancia,tempoatual,cont) VALUES(?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sensor.getDistancia());
            ps.setString(2, sensor.getTempoAtual());
            ps.setString(3, sensor.getCont());
            ps.executeUpdate();
            isOk = true;
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
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
        
        sql = "UPDATE TabelaSensor SET distancia=?,tempoatual=?,cont=?  WHERE id=?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sensor.getDistancia());
            ps.setString(2, sensor.getTempoAtual());
            ps.setString(3, sensor.getCont());
            ps.executeUpdate();
            isOk = true;
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
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
        
        sql = "DELETE FROM TabelaSensor WHERE id=?;";
        
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
        
        sql = "SELECT * FROM TabelaSensor WHERE id=?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
           if(rs.next()){
                sensor = new Sensor.SensorStatic();
                sensor.setId(rs.getInt("id"));
                sensor.setDistancia(rs.getString("distancia"));
                sensor.setTempoAtual(rs.getString("tempoatual"));
                sensor.setCont(rs.getString("cont"));
                               
                     
            }
                 
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        
        return sensor;
    }
    
    
    public List<Sensor.SensorStatic> getSensor(){
        
        List<Sensor.SensorStatic> lstCadastro = null;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (conn == null){
            return lstCadastro;
        }
        
        sql = "SELECT * FROM TabelaSensor ORDER BY nome;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lstCadastro = new ArrayList<Sensor.SensorStatic>();
            while(rs.next()){
                
                Sensor.SensorStatic sensor = new Sensor.SensorStatic();
                sensor.setId(rs.getInt("id"));
                sensor.setDistancia(rs.getString("distancia"));
                sensor.setTempoAtual(rs.getString("tempoatual"));
                sensor.setCont(rs.getString("cont"));
                lstCadastro.add(sensor);
                     
            }
                 
            
        } catch (SQLException ex) {
            Logger.getLogger(SensorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        
        return lstCadastro;
    }
    
}
