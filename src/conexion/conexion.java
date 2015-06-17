/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author enriqueramirezgonzalez
 */
public class conexion {
    Connection myConection;
    Statement stSentencias;
    ResultSet rsDatos;
    PreparedStatement psPrepararSentencias;
    
    public conexion() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:Mysql://localhost/db_electiva";
            myConection  = DriverManager.getConnection(url, "root", "123456789");
            stSentencias = myConection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch(ClassCastException ex){throw ex;}
        catch(SQLException ex1){throw ex1;}
            
    }  
    
    public ResultSet consulta(String sql)throws SQLException{
        try{
            rsDatos = stSentencias.executeQuery(sql);
        }catch(SQLException ex){
            throw ex;
        }
       
        return rsDatos;
    } 
}
