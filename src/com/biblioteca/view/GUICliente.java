package com.biblioteca.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.biblioteca.controller.ControladorCliente;
import com.biblioteca.model.Conexao;
import com.biblioteca.model.Livro;

public class GUICliente implements ActionListener {
	
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
	
	private JFrame frameCliente;

	private JPanel panelCliente;

	private JLabel livroProcura;
	private JTextField procuraTitulo;
	private JLabel labelProcuraTitulo;

	private JLabel autorProcura;
	private JTextField procuraAutor;
	private JLabel labelProcuraAutor;

	private JLabel resultado;
	private JTextField achaTitulo;
	private JLabel labelAchaTitulo;

	private JLabel autorTituloAcha;
	private JTextField achaAutor;
	private JLabel labelAchaAutor;

	private JLabel isbnTituloAchado;
	private JTextField isbnAchado;
	private JLabel labelISBNAchado;

	private JLabel tituloRenovacaoReserva;

	private JLabel labelLogin;
	private JTextField login;

	private JTextField senha;
	private JLabel labelSenha;

	private JLabel labelISBNR;
	private JTextField ISBNR;

	private JButton procuraButton;
	private JButton renovaButton;
	private JButton reservaButton;

	public GUICliente() {
		frameCliente = new JFrame();
		frameCliente.setTitle("Tela cliente");
		frameCliente.setSize(800, 700);
		frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCliente = new JPanel();
		panelCliente.setLayout(null);
		frameCliente.add(panelCliente);

		livroProcura = new JLabel("Procurar livro");
		livroProcura.setBounds(10, -5, 165, 25);
		panelCliente.add(livroProcura);

		resultado = new JLabel("Resultado:");
		resultado.setBounds(210, 10, 165, 25);
		panelCliente.add(resultado);

		procuraTitulo = new JTextField("Título a pesquisar");
		procuraTitulo.setBounds(10, 35, 165, 25);
		labelProcuraTitulo = new JLabel("Título");
		labelProcuraTitulo.setBounds(10, 10, 165, 25);
		panelCliente.add(labelProcuraTitulo);
		panelCliente.add(procuraTitulo);

		procuraAutor = new JTextField("Autor a pesquisar");
		procuraAutor.setBounds(10, 85, 165, 25);
		labelProcuraAutor = new JLabel("Autor");
		labelProcuraAutor.setBounds(10, 65, 165, 25);
		panelCliente.add(labelProcuraAutor);
		panelCliente.add(procuraAutor);

		procuraButton = new JButton("Procurar");
		procuraButton.setBounds(10, 125, 165, 25);
		procuraButton.addActionListener(this);
		panelCliente.add(procuraButton);

		achaTitulo = new JTextField("Resultado de título");
		achaTitulo.setBounds(210, 50, 165, 25);
		labelAchaTitulo = new JLabel("Título");
		labelAchaTitulo.setBounds(210, 25, 165, 25);
		panelCliente.add(labelAchaTitulo);
		panelCliente.add(achaTitulo);

		achaAutor = new JTextField("Resultado de autor");
		achaAutor.setBounds(210, 100, 165, 25);
		labelAchaAutor = new JLabel("Autor");
		labelAchaAutor.setBounds(210, 80, 165, 25);
		panelCliente.add(labelAchaAutor);
		panelCliente.add(achaAutor);

		isbnTituloAchado = new JLabel("ISBN");
		isbnTituloAchado.setBounds(210, 125, 165, 25);
		panelCliente.add(isbnTituloAchado);
		isbnAchado = new JTextField("ISBN resultado");
		isbnAchado.setBounds(210, 155, 165, 25);
		panelCliente.add(isbnAchado);

		tituloRenovacaoReserva = new JLabel("RenovaReserva");
		tituloRenovacaoReserva.setBounds(15, 220, 165, 25);
		panelCliente.add(tituloRenovacaoReserva);

		labelLogin = new JLabel("Login");
		labelLogin.setBounds(15, 250, 165, 25);
		panelCliente.add(labelLogin);
		login = new JTextField("Digite login");
		login.setBounds(15, 275, 165, 25);
		panelCliente.add(login);

		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(225, 250, 165, 25);
		panelCliente.add(labelSenha);
		senha = new JTextField("Digite senha");
		senha.setBounds(225, 280, 165, 25);
		panelCliente.add(senha);

		renovaButton = new JButton("Renovar");
		renovaButton.setBounds(15, 425, 165, 25);
		renovaButton.addActionListener(this);
		panelCliente.add(renovaButton);

		reservaButton = new JButton("Reservar");
		reservaButton.setBounds(225, 425, 165, 25);
		reservaButton.addActionListener(this);
		panelCliente.add(reservaButton);

		labelISBNR = new JLabel("ISBN");
		labelISBNR.setBounds(15, 320, 165, 25);
		panelCliente.add(labelISBNR);
		ISBNR = new JTextField("Resultado ISBN");
		ISBNR.setBounds(15, 355, 165, 25);
		panelCliente.add(ISBNR);

		frameCliente.setVisible(true);
	}

	public static void main(String[] args) {
		new GUICliente();
	}

	@Override
	public void actionPerformed(ActionEvent clique) {
		String tituloProc = this.procuraTitulo.getText();
		String autorProc = this.procuraAutor.getText();
		String loginProc = this.login.getText();
		String senhaProc = this.senha.getText();
		String isbnPROC = this.ISBNR.getText();
		int isbnPROCC = Integer.parseInt(isbnPROC);

		if (clique.getSource() == procuraButton) {
			ControladorCliente c = new ControladorCliente();
			if (tituloProc != null) {
				tituloProc = this.procuraTitulo.getText();

				Livro l = c.controlaProcuraTitulo(tituloProc);
				achaTitulo.setText(l.getTitulo());
				achaAutor.setText(l.getAutor());
				System.out.println(l.getTitulo());
				System.out.println("foi gui!");
				isbnAchado.setText(Integer.toString(l.getISBN()));
			} else if (autorProc != null) {

				Livro l = c.controlaProcuraAutor(autorProc);
				achaTitulo.setText(l.getTitulo());
				achaAutor.setText(l.getAutor());
				isbnAchado.setText(Integer.toString(l.getISBN()));

			} else {
				System.out.println("Dados não inseridos");
			}

		} else if (clique.getSource() == renovaButton) {
			 ControladorCliente conCli = new ControladorCliente();
			 boolean verificado = conCli.verificaCliente(loginProc, senhaProc);
			 if(verificado) {
				 conCli.renovarData(loginProc, isbnPROCC);
			 }
			

		}
		else if(clique.getSource() == reservaButton) {
			ControladorCliente cCli = new ControladorCliente();
			cCli.fazReserva(isbnPROCC);
		}

	}

}
