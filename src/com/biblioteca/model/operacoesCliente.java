package com.biblioteca.model;

public class operacoesCliente {
	public Livro procuraLivroTitulo(String titulo) {
		LivroDAO lDAO = new LivroDAO();
		
		return lDAO.procuraLivroTitulo(titulo);
	}
	
	public Livro procuraLivroAutor(String autor) {
		LivroDAO lDAO = new LivroDAO();
		return lDAO.procuraLivroAutor(autor);
	}
	
	public boolean verificaCliente(String login, String senha) {
		ClienteDAO cDAO = new ClienteDAO();
		return cDAO.verificaCliente(login, senha);
	}
	
	public void renovarData(String login, int ISBN) {
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.renovarData(login, ISBN);
	}
	
	public void fazReserva(int ISBN) {
		LivroDAO lDAO = new LivroDAO();
		lDAO.reservarLivro(ISBN);;
	}
	
	public Cliente procuraCliente(String login) {
		ClienteDAO cDAO = new ClienteDAO();
		return cDAO.procuraCliente(login);
	}

}
