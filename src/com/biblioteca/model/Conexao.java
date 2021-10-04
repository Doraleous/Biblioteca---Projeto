package com.biblioteca.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.biblioteca.controller.ControladorADM;



public class Conexao {
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
	
	/* public static void main(String args[]) {
		Administrador a = new Administrador("aa", "bb", "Joao", "9999");
		Livro l = new Livro("historia", 2, 3, 4, 5, "1245-c", "jose", "documento", 2.99, false, 1, 0, false, 0);
		ControladorADM cADM = new ControladorADM();
		
		
		cADM.controlaInsercao(l, a);

	} */

}