package com.biblioteca.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.Conexao;

public class LivroDAO {

	public void inserirLivro(Livro l) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "INSERT INTO livro(TITULO, ISBN, autor, preco,\r\n"
					+ "qtdAcervo, qtdAlugada, qtdReservas, alugado) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, l.getTitulo());
			statement.setInt(2, l.getISBN());
			statement.setString(3, l.getAutor());
			statement.setDouble(4, l.getPreco());
			statement.setInt(5, l.getQtdAcervo());
			statement.setInt(6, l.getQtdAlugada());
			statement.setInt(7, l.getQtdReservas());
			statement.setInt(8, 0);

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removerLivro(Livro l) {
		try {
			Connection connection = Conexao.getInstance().getConnection();
			String sql = "DELETE FROM livro WHERE ISBN = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, l.getISBN());

			statement.execute();
			connection.close();
			System.out.println("Livro removido com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validarLivro(int idISBN) {

		boolean pertence = false;
		List<Integer> listaidISBN = new ArrayList<Integer>();
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT * FROM LIVRO";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				int idISBNprocura = (resultset.getInt("ISBN"));
				listaidISBN.add(idISBNprocura);

			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		for (Integer inteiro : listaidISBN) {
			if (inteiro == idISBN) {
				pertence = true;
				return pertence;
			}
		}
		return pertence;

	}

	public Livro procuraLivroTitulo(String titulo) {
		Livro l = new Livro();
		try {

			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT * FROM livro WHERE titulo = '" + titulo + "'";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			
			

			while (rs.next()) {
				l.setTitulo(rs.getString(1));
				l.setISBN(rs.getInt(2));
				l.setAutor(rs.getString(3));
				l.setPreco(rs.getDouble(4));
				l.setQtdAcervo(rs.getInt(5));
				l.setQtdAlugada(rs.getInt(6));
				l.setQtdReservas(rs.getInt(7));
				
				if (rs.getInt(8) == 0) {
					l.setAlugado(false);
				} else {
					l.setAlugado(true);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return l;
	}
	
	public Livro procuraLivroAutor(String autor) {
		Livro l = new Livro();
		try {

			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT * FROM livro WHERE titulo = '" + autor + "'";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				l.setTitulo(rs.getString(1));
				l.setISBN(rs.getInt(2));
				l.setAutor(rs.getString(3));
				l.setPreco(rs.getDouble(4));
				l.setQtdAcervo(rs.getInt(5));
				l.setQtdAlugada(rs.getInt(6));
				l.setQtdReservas(rs.getInt(7));
				
				if (rs.getInt(8) == 0) {
					l.setAlugado(false);
				} else {
					l.setAlugado(true);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return l;
	}
	
	public int qtdReservada(String ISBN) {
		int reservas = 0;
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT qtdReservas AS reservas FROM livro WHERE ISBN = '" + ISBN + "';";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement
					.executeQuery("SELECT qtdReservas AS reservas FROM livro WHERE ISBN = '" + ISBN + "';");

			while (rs.next()) {
				reservas = rs.getInt("reservas");
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservas;

	}
	
	public int qtdAlugada(String ISBN) {
		int locacoes = 0;
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "SELECT qtdAlugada AS locacoes FROM livro WHERE ISBN = '" + ISBN + "';";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement
					.executeQuery("SELECT qtdAlugada AS locacoes FROM livro WHERE ISBN = '" + ISBN + "';");

			while (rs.next()) {
				locacoes = rs.getInt("locacoes");
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return locacoes;

	}
	
	public void reservarLivro(int livroISBN) {
		try {
			Connection connection = Conexao.getInstance().getConnection();

			String sql = "UPDATE livro SET qtdReservas = qtdReservas + 1 WHERE isbn = '"+livroISBN+"'";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
