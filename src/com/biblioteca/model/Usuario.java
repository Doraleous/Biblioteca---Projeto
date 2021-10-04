package com.biblioteca.model;

public class Usuario {
	private String login;
	private String senha;
	private String nome;
	private String telefone;
	
	public Usuario (String login, String senha, String nome, String telefone) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}