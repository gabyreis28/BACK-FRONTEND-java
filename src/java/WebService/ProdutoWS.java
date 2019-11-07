/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import DAO.ProdutoDAO;
import Modelo.Produto;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author alunocmc
 */
@WebService(serviceName = "produtows")
public class ProdutoWS {
    public List<Produto> listarTodos(){
        ProdutoDAO dao = new ProdutoDAO();
        return dao.listar();
    }
    public void cadastrar (Produto produto){
        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrar(produto);  
    }
    public Produto listarId (Produto produto){
        ProdutoDAO dao = new ProdutoDAO();
        return dao.listarId(produto);
    }
      public void editar(Produto produto){
        ProdutoDAO dao = new ProdutoDAO();
        dao.editar(produto);
    }
      public void excluir(Produto produto){
        ProdutoDAO dao = new ProdutoDAO();
        dao.excluir(produto);
    }   
        
}
