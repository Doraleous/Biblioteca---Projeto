package com.biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class admDAO {
	public void inserirADM(Administrador adm) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "INSERT INTO administrador(login, senha, nome, telefone) VALUES(?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, adm.getLogin());
			statement.setString(2, adm.getSenha());
			statement.setString(3, adm.getNome());
			statement.setString(4, adm.getTelefone());
			

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean verificaRepetido(Administrador adm) {
		boolean repetido = false;
		try {
			
			String login;

			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT login FROM administrador";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery("SELECT login FROM administrador");
			while (rs.next()) {

				login = (rs.getString("login"));
				if (login.equals(adm.getLogin())) {
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
