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

import br.com.voffice.contatos.dao.UsuarioDAO;
import br.com.voffice.contatos.entity.Usuario;

/**
 *
 * @author avila
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario/*"})
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        UsuarioDAO repository = new UsuarioDAO();
        String destino;
        
        if (pathInfo == null) {
            
            List<Usuario> usuarios = repository.findAll();
            request.setAttribute("usuarios", usuarios);
            destino = "/Usuario/ListaUsuario.jsp";
            
        } else {
            
            Usuario usuario;
            if (pathInfo.endsWith("new")) {
                usuario = new Usuario();
            } else {
                pathInfo = pathInfo.replace("/", "");
                usuario = repository.findById(new Long(pathInfo));
            }
            request.setAttribute("usuario", usuario);
            destino = "/Usuario/FormUsuario.jsp";
            
        }
        
        request.getRequestDispatcher(destino).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario usuario = new Usuario();
        if (id != null && !id.isEmpty()) {
            usuario.setId(new Long(id));
        }
        usuario.setNome(nome);
        usuario.setUsername(username);
        usuario.setPassword(password);
        
        UsuarioDAO repository = new UsuarioDAO();
        repository.save(usuario);
        response.sendRedirect(request.getContextPath() + "/usuario");
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
