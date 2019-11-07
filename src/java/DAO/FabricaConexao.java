/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alunocmc
 */
public class FabricaConexao {
    public static Connection getConexao() throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webservice", "postgres", "postgres");
        return conexao;
    }
}
