package com.biblioteca.controller;

import com.biblioteca.model.Cliente;
import com.biblioteca.model.ClienteDAO;
import com.biblioteca.model.Livro;
import com.biblioteca.model.operacoesCliente;
import com.biblioteca.view.GUICadastro;

public class ControladorCliente {
	public Livro controlaProcuraTitulo(String titulo) {
		operacoesCliente op = new operacoesCliente();
		
		return op.procuraLivroTitulo(titulo);
	}

	public Livro controlaProcuraAutor(String autor) {
		operacoesCliente op = new operacoesCliente();
		return op.procuraLivroAutor(autor);
	}

	public boolean verificaCliente(String login, String senha) {
		operacoesCliente opCli = new operacoesCliente();
		return opCli.verificaCliente(login, senha);
	}

	public void controlaCadastro(String login, String senha, String nome, String telefone) {
		Cliente c = new Cliente(login, senha, nome, telefone);
		ClienteDAO cDAO = new ClienteDAO();
		if (!cDAO.verificaRepetido(c)) {
			cDAO.inserirCliente(c);
		}
	}

	public void renovarData(String login, int ISBN) {
		operacoesCliente opCli = new operacoesCliente();
		opCli.renovarData(login, ISBN);
	}

	public void fazReserva(int ISBN) {
		operacoesCliente opCli = new operacoesCliente();
		opCli.fazReserva(ISBN);

	}
	
	public Cliente procuraCliente(String login) {
		operacoesCliente opCli = new operacoesCliente();
		return opCli.procuraCliente(login);
	}

}
