/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */

package br.com.voffice.contatos.dao.exception;

public class DAOException extends Exception {

	public DAOException(String mensagem, Exception e) {
		super(mensagem, e);
	}

	public DAOException(String mensagem) {
		super(mensagem);
	}
}
