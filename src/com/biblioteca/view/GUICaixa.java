package com.biblioteca.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.biblioteca.controller.ControladorCaixa;
import com.biblioteca.controller.ControladorCliente;
import com.biblioteca.model.Cliente;
import com.biblioteca.model.Livro;

public class GUICaixa implements ActionListener {

	private JFrame frameCaixa;

	private JPanel panelCaixa;

	private JLabel loginCliente;
	private JTextField loginClienteTxt;

	private JLabel isbn;
	private JTextField isbnTxt;
	private JButton transferir;

	public GUICaixa() {
		frameCaixa = new JFrame();
		frameCaixa.setTitle("Caixa");
		frameCaixa.setSize(800, 360);
		frameCaixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCaixa = new JPanel();
		frameCaixa.add(panelCaixa);

		loginCliente = new JLabel("Login do Cliente");
		loginCliente.setBounds(10, -5, 165, 25);
		panelCaixa.add(loginCliente);

		loginClienteTxt = new JTextField(20);
		loginClienteTxt.setBounds(320, 35, 165, 25);
		frameCaixa.add(loginClienteTxt);

		isbn = new JLabel("ISBN");
		isbn.setBounds(375, 75, 165, 25);
		frameCaixa.add(isbn);

		isbnTxt = new JTextField();
		isbnTxt.setBounds(320, 110, 165, 25);
		frameCaixa.add(isbnTxt);

		transferir = new JButton("Transferir");
		transferir.setBounds(600, 600, 165, 25);
		transferir.addActionListener(this);
		panelCaixa.add(transferir);

		frameCaixa.add(panelCaixa);

		frameCaixa.setVisible(true);
	}

	public static void main(String[] args) {
		new GUICaixa();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String login = loginClienteTxt.getText();
		String isbnProc = isbnTxt.getText();
		ControladorCliente cCli = new ControladorCliente();
		Cliente c = cCli.procuraCliente(login);
		Livro l = new Livro();
		l.setISBN(Integer.parseInt(isbnProc));
		ArrayList<Livro> inv = new ArrayList<Livro>();
		c.setInventario(inv);
		c.adicionaLivroTransferencia(l);
		ControladorCaixa cCx = new ControladorCaixa();
		try {
			cCx.controlaTransferenciaIn(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		transferir.setText("Livro transferido");

	}

}
