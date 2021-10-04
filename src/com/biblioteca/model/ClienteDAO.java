package com.biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	public int qtdInventario(String login, String senha) {

		int qtd = 0;
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT if(livroISBN1 is null,0,1)+ " + "if(livroISBN2 is null,0,1)+ "
					+ "if(livroISBN3 is null,0,1)+ " + "if(livroISBN4 is null,0,1)+ " + "if(livroISBN5 is null,0,1)+ "
					+ "if(livroISBN6 is null,0,1)AS total from livroscliente where login = '" + login + "';";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery("SELECT if(livroISBN1 is null,0,1)+ " + "if(livroISBN2 is null,0,1)+ "
					+ "if(livroISBN3 is null,0,1)+ " + "if(livroISBN4 is null,0,1)+ " + "if(livroISBN5 is null,0,1)+ "
					+ "if(livroISBN6 is null,0,1)AS total from livroscliente where login = '" + login + "';");

			while (rs.next()) {
				qtd = rs.getInt("total");
			}

			connection.close();
			return qtd;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return qtd;

	}

	public void transfereLivros(int indiceInserido, int ISBN, String login) {

		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "UPDATE livrosCliente\r\n" + "SET livroISBN" + indiceInserido + " = " + ISBN + "\r\n"
					+ "WHERE login = '" + login + "';";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.execute();
			connection.close();
			System.out.println("Livros transferidos com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verificaCliente(String login, String senha) {
		boolean verificado = false;
		String verificar;

		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT senha FROM cliente WHERE login = '" + login + "'";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery("SELECT senha AS senhaV FROM cliente WHERE login = '" + login + "'");
			while (rs.next()) {
				verificar = rs.getString("senhaV");
				if (senha.equals(verificar)) {
					verificado = true;
					return verificado;
				}
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return verificado;
	}

	public void dadosTransferencia(String login, int ISBN) throws ClassNotFoundException, SQLException {

		Connection connection = Conexao.getInstance().getConnection();

		String sql = "INSERT INTO locacao VALUES (DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY), CURRENT_DATE, NULL, " + "'"
				+ ISBN + "','" + login + "' )";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.close();

	}

	public void inserirCliente(Cliente c) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "INSERT INTO cliente(login, senha, nome, telefone) VALUES(?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, c.getLogin());
			statement.setString(2, c.getSenha());
			statement.setString(3, c.getNome());
			statement.setString(4, c.getTelefone());

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void reservarLivro(String ISBN) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "UPDATE livro SET qtdReservas = qtdReservas + 1 WHERE login = '" + ISBN + "';";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verificaRepetido(Cliente c) {
		boolean repetido = false;
		try {

			String login;

			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT login FROM cliente";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery("SELECT login FROM cliente");
			while (rs.next()) {

				login = (rs.getString("login"));
				if (login.equals(c.getLogin())) {
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

	public void renovarData(String login, int livroISBN) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "UPDATE locacao SET dataEntrega = (DATE_ADD(CURRENT_DATE, INTERVAL 20 DAY)) "
					+ "WHERE login = '" + login + "' AND livroisbn = '" + livroISBN + "'";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Cliente procuraCliente(String login) {
		boolean repetido = false;
		Cliente c = new Cliente(login, login, login, login);
		try {

			

			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT * FROM cliente where login = '"+login+"'";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery("SELECT * FROM cliente where login = '"+login+"'");
			while (rs.next()) {

				
				c.setLogin(rs.getString(1));
				c.setSenha(rs.getString(2));
				c.setNome(rs.getString(3));
				c.setTelefone(rs.getString(4));
				return c;

			}
			

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		

	}
	
}
