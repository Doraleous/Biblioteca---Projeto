package com.biblioteca.controller;

import java.sql.SQLException;

import com.biblioteca.model.Caixa;
import com.biblioteca.model.CaixaDAO;
import com.biblioteca.model.Cliente;
import com.biblioteca.model.ClienteDAO;
import com.biblioteca.model.Usuario;
import com.biblioteca.model.operacoesCaixa;

public class ControladorCaixa {

	public void controlaTransferenciaIn(Cliente c) throws ClassNotFoundException, SQLException {
		
			operacoesCaixa opCX = new operacoesCaixa();
			opCX.transfereIn(c);
			

		
		

	}
	
	public void controlaCadastro(String login, String senha, String nome, String telefone) {
		Caixa cx = new Caixa(login, senha, nome, telefone);
		CaixaDAO cxDAO = new CaixaDAO();
		if (!cxDAO.verificaRepetido(cx)) {
			cxDAO.inserirCaixa(cx);
		}
	}
}
