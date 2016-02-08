/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voffice.contatos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.voffice.contatos.dao.ClienteDAO;
import br.com.voffice.contatos.entity.Cliente;

/**
 *
 * @author avila
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/cliente/*"})
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        ClienteDAO repository = new ClienteDAO();
        String destino;
        
        if (pathInfo == null) {
            
            List<Cliente> clientes = repository.findAll();
            request.setAttribute("clientes", clientes);
            destino = "/Cliente/ListaCliente.jsp";
            
        } else {
            
        	pathInfo = pathInfo.substring(pathInfo.lastIndexOf("/") + 1);
        	
            Cliente cliente;
            if (pathInfo.endsWith("new")) {
                cliente = new Cliente();
            } else {
                cliente = repository.findById(new Long(pathInfo));
            }
            request.setAttribute("cliente", cliente);
            destino = "/Cliente/FormCliente.jsp";
            
        }
        
        request.getRequestDispatcher(destino).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        Cliente cliente = new Cliente();
        if (id != null && !id.isEmpty()) {
            cliente.setId(new Long(id));
        }
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        
        ClienteDAO repository = new ClienteDAO();
        repository.save(cliente);
        response.sendRedirect(request.getContextPath() + "/cliente");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
