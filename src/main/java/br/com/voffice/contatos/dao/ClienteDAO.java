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

import br.com.voffice.contatos.entity.Cliente;

/**
 *
 * @author avila
 */
public class ClienteDAO {

    public List<Cliente> findAll() {
		String sql = "SELECT * FROM Cliente";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		try {
			conn = ConnectionManager.getConexao();
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getLong("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setTelefone(rs.getString("telefone"));
					clientes.add(cliente);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return clientes;
    }

    public Cliente findById(Long id) {
		String sql = "SELECT * FROM Cliente WHERE id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente cliente = null;
		conn = ConnectionManager.getConexao();
		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setLong(1, id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					cliente = new Cliente();
					cliente.setId(rs.getLong("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setTelefone(rs.getString("telefone"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.closeAll(conn, stmt, rs);
			}
		}
		return cliente;
    }
    
    public Cliente save(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConexao();
            if (conn != null) {
	            if (cliente.getId() == null) {
	                stmt = conn.prepareStatement("INSERT INTO Cliente (nome, telefone, endereco) VALUES (?, ?, ?)");
	            } else {
	                stmt = conn.prepareStatement("UPDATE Cliente SET nome = ?, telefone = ?, endereco = ? WHERE id = ?");
	                stmt.setLong(4, cliente.getId());
	            }
	            stmt.setString(1, cliente.getNome());
	            stmt.setString(2, cliente.getTelefone());
	            stmt.setString(3, cliente.getEndereco());
	            stmt.executeUpdate();
	            
	            if (cliente.getId() == null) {
	            	//busca o id gerado;
	            	
	            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeAll(conn, stmt);
        }
        return cliente;
    }
}
