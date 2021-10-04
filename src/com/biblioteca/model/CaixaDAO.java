package com.biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CaixaDAO {
	
	public void inserirCaixa(Caixa cx) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "INSERT INTO caixa(login, senha, nome, telefone) VALUES(?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, cx.getLogin());
			statement.setString(2, cx.getSenha());
			statement.setString(3, cx.getNome());
			statement.setString(4, cx.getTelefone());
			

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean verificaRepetido(Caixa cx) {
		boolean repetido = false;
		try {
			
			String login;

			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT login FROM caixa";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery("SELECT login FROM caixa");
			while (rs.next()) {

				login = (rs.getString("login"));
				if (login.equals(cx.getLogin())) {
					repetido = true;
					return repetido;
				}

			}

			connection.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return repetido;

	}

}
