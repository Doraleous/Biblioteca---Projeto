package com.biblioteca.model;

import java.util.ArrayList;

public class Cliente extends Usuario {
	private ArrayList<Livro> inventario;
	private boolean bloqueado;
	private ArrayList<Livro> inventarioReserva;
	private ArrayList<Livro> livrosFavoritos;

	public Cliente(String login, String senha, String nome, String telefone) {
		super(login, senha, nome, telefone);

	}
	
	
	

	public void adicionaLivroTransferencia(Livro l) {
		if (this.inventario.size() < 6) {
			this.inventario.add(l);
		}
	}

	public Livro procurarLivro(Livro livro) {
		// A FAZER
		return livro;
	}

	public void reservarLivro() {
		// A FAZER
	}

	public void estenderData() {
		// A FAZER
	}

	public void favoritarLivro() {
		// A FAZER
	}

	public void desfavoritarLivro() {
		// A FAZER
	}

	public ArrayList<Livro> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Livro> inventario) {
		this.inventario = inventario;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public ArrayList<Livro> getInventarioReserva() {
		return inventarioReserva;
	}

	public void setInventarioReserva(ArrayList<Livro> inventarioReserva) {
		this.inventarioReserva = inventarioReserva;
	}

	public ArrayList<Livro> getLivrosFavoritos() {
		return livrosFavoritos;
	}

	public void setLivrosFavoritos(ArrayList<Livro> livrosFavoritos) {
		this.livrosFavoritos = livrosFavoritos;
	}

}