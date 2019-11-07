/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import DAO.ProdutoDAO;
import Modelo.Produto;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author alunocmc
 */
@Path("produtos")
public class ProdutoServico {

    

    /**
     * Creates a new instance of ProdutoServico
     */
    public ProdutoServico() {
    }

    /**
     * Retrieves representation of an instance of servico.ProdutoServico
     * @return an instance of java.lang.String
     */
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarTodos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listar();
        return new Gson().toJson(lista);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String consultar(@PathParam("id") int id) throws Exception {
        Produto produto = new Produto();
        produto.setId(id);
        ProdutoDAO dao = new ProdutoDAO();
        produto = dao.consultar(id);
        return new Gson().toJson(produto);
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrar(String produtoJson) {
        
        Produto produto = new Gson().fromJson(produtoJson, Produto.class);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrar(produto);
        
        //return new Gson().toJson(produto);
        
            
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
     public void editar(@PathParam("id") int id,String produtoJson) throws Exception {
        
        Produto produto = new Gson().fromJson(produtoJson, Produto.class);
        produto.setId(id);
        ProdutoDAO dao = new ProdutoDAO();
        dao.editar(produto);
   //public void editar(@PathParam("id") int id)  throws Exception{
        //Produto produto = new Produto();
        //ProdutoDAO dao = new ProdutoDAO();
        //ao.editar(produto);
        
        
        
    }
    
    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") int id)  throws Exception{
        Produto produto = new Produto();
        produto.setId(id);
        ProdutoDAO dao = new ProdutoDAO();
        dao.excluir(produto);
            
    }
}
