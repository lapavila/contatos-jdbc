package br.com.voffice.contatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionManager {

	// Informacoes para conexao com banco de dados. Verificar antes de conectar
	// com outro banco.
	private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String STR_CON = "jdbc:mysql://localhost:3306/contatos";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConexao() {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			System.out.println("[ConnectionManager]: Obtendo conexao");
		} catch (ClassNotFoundException e) {
			System.out.println("[ERRO] Driver nao encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("[ERRO] Erro ao obter a conexao");
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null || stmt != null) {
				closeAll(conn, stmt);
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
