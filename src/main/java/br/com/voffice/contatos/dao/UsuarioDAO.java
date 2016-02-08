/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voffice.contatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.voffice.contatos.entity.Usuario;

/**
 *
 * @author avila
 */
public class UsuarioDAO {

	public List<Usuario> findAll() {
		String sql = "SELECT * FROM Usuario";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<>();
		try {
			conn = ConnectionManager.getConexao();
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setPassword(rs.getString("password"));
					usuario.setUsername(rs.getString("username"));
					usuarios.add(usuario);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return usuarios;
	}

	public Usuario findById(Long id) {
		String sql = "SELECT * FROM Usuario WHERE id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		conn = ConnectionManager.getConexao();
		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setLong(1, id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setPassword(rs.getString("password"));
					usuario.setUsername(rs.getString("username"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeAll(conn, stmt, rs);
			}
		}
		return usuario;
	}

	public Usuario save(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConexao();
            if (conn != null) {
	            if (usuario.getId() == null) {
	                stmt = conn.prepareStatement("INSERT INTO Usuario (nome, password, username) VALUES (?, ?, ?)");
	            } else {
	                stmt = conn.prepareStatement("UPDATE Usuario SET nome = ?, password = ?, username = ? WHERE id = ?");
	                stmt.setLong(4, usuario.getId());
	            }
	            stmt.setString(1, usuario.getNome());
	            stmt.setString(2, usuario.getPassword());
	            stmt.setString(3, usuario.getUsername());
	            stmt.executeUpdate();
	            
	            if (usuario.getId() == null) {
	            	//busca o id gerado;
	            	
	            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, stmt);
        }
        return usuario;
	}

	public Usuario findByUsernameName(String username) {
		String sql = "SELECT * FROM Usuario WHERE username = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		conn = ConnectionManager.getConexao();
		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				rs = stmt.executeQuery();
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setPassword(rs.getString("password"));
					usuario.setUsername(rs.getString("username"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeAll(conn, stmt, rs);
			}
		}
		return usuario;
	}
}
