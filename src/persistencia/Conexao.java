/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavo.hamester
 */
class Conexao {
    public static Connection getConexao(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost3306/projeto","root","123qwe@");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
