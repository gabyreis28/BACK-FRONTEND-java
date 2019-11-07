/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alunocmc
 */
public class ProdutoDAO {
    public void cadastrar (Produto produto){
         
        try {
            Connection conexao = FabricaConexao.getConexao();
            
            String sql = "INSERT INTO service (descricao, preco, quantidade) VALUES (?,?,?)";
            PreparedStatement psmt = conexao.prepareStatement(sql);
            psmt.setString(1, produto.getDescricao());
            psmt.setDouble(2, produto.getPreco());
            psmt.setInt(3, produto.getQuantidade());
            psmt.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public List<Produto> listar(){
        
        List<Produto> produtos = new ArrayList<>();
        
        try{
            
            Connection conexao = FabricaConexao.getConexao();
            
            String sql="SELECT * FROM service";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                
                
                produtos.add(p);
            }
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return produtos;
    }
     public Produto consultar(int id) throws SQLException, Exception {
 
        String sql = "select * from service where id = ? ;";
 
        Produto p = null;
 
        Connection con = FabricaConexao.getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
         
        try {                            
            if(rs.next()){
                p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            rs.close();
            ps.close();    
        }
        return p;
    }
     
      public void editar(Produto produto) throws SQLException, Exception {

        String sql = "update service set descricao = ? , preco = ? , quantidade = ? "
                      + "where id = ? ;";
        
        Connection con = FabricaConexao.getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        
        try {            
            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade());
            ps.setInt(4, produto.getId());
            
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ps.close();
        }

        
    }
    

        public void excluir (Produto produto){
         try {
             
              Connection conexao = FabricaConexao.getConexao();
              
            String sql = "DELETE FROM service WHERE id=?"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getId());
            ps.execute();
            
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
  
}
