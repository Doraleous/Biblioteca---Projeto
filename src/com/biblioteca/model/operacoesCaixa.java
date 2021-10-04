package com.biblioteca.model;

import java.sql.SQLException;

public class operacoesCaixa {

	public void transfereIn(Cliente c) throws ClassNotFoundException, SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		int indice = 0; 
		int indiceInserido = cDAO.qtdInventario(c.getLogin(), c.getSenha()) + 1;
		if (c.getInventario().size() + cDAO.qtdInventario(c.getLogin(), c.getSenha()) <= 6 && indiceInserido < 7) {
			for (Livro l : c.getInventario()) {
				cDAO.transfereLivros(indiceInserido, l.getISBN(), c.getLogin());
				indiceInserido++;
				cDAO.dadosTransferencia(c.getLogin(), l.getISBN());
			}
			
			
		}
		else {
			System.out.println("Inventário cheio.");
		}
	}

}
