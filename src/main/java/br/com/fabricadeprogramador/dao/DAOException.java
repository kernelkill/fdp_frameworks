package br.com.fabricadeprogramador.dao;

public class DAOException extends Exception {

	
	//Construtor recebendo a causa
	public DAOException(IllegalArgumentException e) {
		super(e);
	}

}
