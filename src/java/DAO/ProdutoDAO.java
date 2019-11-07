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
     public void editar (Produto produto){
         try {
             
              Connection conexao = FabricaConexao.getConexao();
              
            String sql = "UPDATE service SET descricao=?, preco=?, quantidade=? WHERE id=?"; 
            PreparedStatement psmt = conexao.prepareStatement(sql);
            psmt.setString(1, produto.getDescricao());
            psmt.setDouble(2, produto.getPreco());
            psmt.setInt(3, produto.getQuantidade());
            psmt.setInt(4, produto.getId());
            psmt.execute();
            
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
      public void excluir (Produto produto){
         try {
             
              Connection conexao = FabricaConexao.getConexao();
              
            String sql = "DELETE FROM service WHERE id=?"; 
            PreparedStatement psmt = conexao.prepareStatement(sql);
            psmt.setInt(1, produto.getId());
            psmt.execute();
            
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
      
      public Produto listarId(Produto produto){
    
        try{
            
            Connection conexao = FabricaConexao.getConexao();
            
            String sql="SELECT id, descricao, preco, quantidade FROM service WHERE id=?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, produto.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }    
        } catch(Exception e){
            e.printStackTrace();
        }
        return produto;
    }
}

