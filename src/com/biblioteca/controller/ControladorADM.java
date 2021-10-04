package com.biblioteca.controller;

import com.biblioteca.model.Administrador;
import com.biblioteca.model.Cliente;
import com.biblioteca.model.ClienteDAO;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import com.biblioteca.model.admDAO;
import com.biblioteca.model.operacoesAdministracao;



public class ControladorADM {
	
	public void controlaInsercao(Livro l, Usuario u) {
		if(u instanceof Administrador) {
			operacoesAdministracao op = new operacoesAdministracao();			
			op.inserirLivro(l);
			
		}
	}
	
	public void controlaDelecao(Livro l, Usuario u) {
		if(u instanceof Administrador) {
			operacoesAdministracao op = new operacoesAdministracao();
			op.deletarLivro(l);
		}
	}
	
	public void controlaCadastro(String login, String senha, String nome, String telefone) {
		Administrador adm = new Administrador(login, senha, nome, telefone);
		admDAO adminDAO = new admDAO();
		if (!adminDAO.verificaRepetido(adm)) {
			adminDAO.inserirADM(adm);
		}
	}

}
