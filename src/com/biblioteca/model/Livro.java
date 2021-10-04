package com.biblioteca.model;

public class Livro {
	private String titulo;
	private int ISBN;
	private String autor;
	private double preco;
	private int qtdAcervo;
	private int qtdAlugada;
	private int qtdReservas;
	private boolean alugado;
	
	

	public Livro(String titulo, int ISBN, String autor, double preco, int qtdAcervo, int qtdAlugada, int qtdReservas, boolean alugado) {
		
		this.titulo = titulo;
		
		
		this.autor = autor;
		
		this.preco = preco;
		this.alugado = alugado;
		this.qtdAcervo = qtdAcervo;
		this.qtdAlugada = qtdAlugada;
		
		this.qtdReservas = qtdReservas;
	    this.ISBN = ISBN;
	}
	
	public Livro() {};

	/* public int gerarISBN(int paisLingua, int editora, int idISBN, int anoPublicacao) {
		int[] ISBN = new int[] { this.paisLingua, this.editora, this.idISBN, this.anoPublicacao };
		int ISBNgerado;
		String tempISBN = ""; int i;
		for(i = 0; i < ISBN.length; i++) {
			tempISBN = tempISBN + String.valueOf(ISBN[i]);
		}
		ISBNgerado = Integer.parseInt(tempISBN);
		return ISBNgerado;

	} */

	public void aumentaQuantidade() {

	}

	public void exibirInfo() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	

	

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public int getQtdAcervo() {
		return qtdAcervo;
	}

	public void setQtdAcervo(int qtdAcervo) {
		this.qtdAcervo = qtdAcervo;
	}

	public int getQtdAlugada() {
		return qtdAlugada;
	}

	public void setQtdAlugada(int qtdAlugada) {
		this.qtdAlugada = qtdAlugada;
	}

	

	

	public int getQtdReservas() {
		return qtdReservas;
	}

	public void setQtdReservas(int qtdReservas) {
		this.qtdReservas = qtdReservas;
	}
	
	public String toString() {
		return "Título: "+ this.titulo+" Autor: "+this.autor;
	}

}