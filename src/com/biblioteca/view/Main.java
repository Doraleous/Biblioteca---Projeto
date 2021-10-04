package com.biblioteca.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.biblioteca.controller.ControladorADM;
import com.biblioteca.controller.ControladorCaixa;
import com.biblioteca.controller.ControladorCliente;
import com.biblioteca.model.Administrador;
import com.biblioteca.model.Caixa;
import com.biblioteca.model.Cliente;
import com.biblioteca.model.Conexao;
import com.biblioteca.model.Livro;

public class Main {
	private static Conexao c;

	public static Conexao getInstance() {
		if (c == null) {
			c = new Conexao();
		}
		return c;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "eUççouUmÇ4fadã0");
	}

	public static void main(String args[]) {
		Administrador a = new Administrador("aa", "bb", "Joao", "9999");
		Livro l = new Livro("historia", 14, "denis", 4.80, 1, 0, 0, false);
		ControladorADM cADM = new ControladorADM();
		ControladorCaixa cAIXA = new ControladorCaixa();
		ControladorCliente cCL = new ControladorCliente();
		Cliente c = new Cliente("pepeu123", "abc123", "pedro gomes", "9898");
		Caixa cx = new Caixa("pepita321", "12ba", "penelope machado", "8989");
		ArrayList<Livro> inv = new ArrayList<Livro>();
		inv.add(l);
		c.setInventario(inv);
		
		// cCL.renovarData("pepeu1", 12);

		// System.out.println(cCL.controlaProcuraTitulo("belaefera"));
		  cADM.controlaDelecao(l, a);
		 // cADM.controlaInsercao(l, a);

		/* try {
			cAIXA.controlaTransferenciaIn(c, cx);
		} catch (Exception e) {
			e.printStackTrace();
		} */
		// cAIXA.controlaTransferenciaIn(c, cx);

	}

}
