package com.biblioteca.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.biblioteca.controller.ControladorADM;
import com.biblioteca.controller.ControladorCaixa;
import com.biblioteca.controller.ControladorCliente;

public class GUICadastro implements ActionListener {
	private JFrame frameCadastro;
	
	private JPanel panelCadastro;
	
	private JButton admButton;
	private JButton clienteButton;
	private JButton caixaButton;
	
	private JTextField clienteLogin;
	private JPasswordField clienteSenha;
	private JTextField clienteNome;
	private JTextField clienteTelefone;
	
	private JLabel labelLoginCliente;
	private JLabel labelSenhaCliente;
	private JLabel labelNomeCliente;
	private JLabel labelTelefoneCliente;
	private JLabel tituloCliente;
	
	private JTextField caixaLogin;
	private JPasswordField caixaSenha;
	private JTextField caixaNome;
	private JTextField caixaTelefone;
	
	private JLabel labelLoginCaixa;
	private JLabel labelSenhaCaixa;
	private JLabel labelNomeCaixa;
	private JLabel labelTelefoneCaixa;
	private JLabel tituloCaixa;
	
	private JTextField administradorLogin;
	private JPasswordField administradorSenha;
	private JTextField administradorNome;
	private JTextField administradorTelefone;
	
	private JLabel labelLoginAdministrador;
	private JLabel labelSenhaAdministrador;
	private JLabel labelNomeAdministrador;
	private JLabel labelTelefoneAdministrador;
	private JLabel tituloAdministrador;
	
	
	
	public GUICadastro() {
				
		frameCadastro = new JFrame();
		frameCadastro.setTitle("Entrada");
		frameCadastro.setSize(800, 360);
		// frameCadastro.pack();
		frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		/* panelCadastro.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panelCadastro.setLayout(new GridLayout(0, 1));
		frameCadastro.add(panelCadastro); */
		frameCadastro.add(panelCadastro);
		
		tituloCliente = new JLabel("Cliente");
		tituloCliente.setBounds(10, -5, 165, 25);
		panelCadastro.add(tituloCliente);
		
		clienteLogin = new JTextField(20);
		clienteLogin.setBounds(10, 35, 165, 25);
		labelLoginCliente = new JLabel("Login");
		labelLoginCliente.setBounds(10, 10, 165, 25);
		panelCadastro.add(labelLoginCliente);
		panelCadastro.add(clienteLogin);
		
		
		clienteSenha = new JPasswordField(20);
		clienteSenha.setBounds(10, 95, 165, 25);
		labelSenhaCliente = new JLabel("Senha");
		labelSenhaCliente.setBounds(10, 70, 165, 25);
		panelCadastro.add(labelSenhaCliente);
		panelCadastro.add(clienteSenha);
		
		clienteNome = new JTextField(20);
		clienteNome.setBounds(10, 160, 165, 25);
		labelNomeCliente = new JLabel("Nome");
		labelNomeCliente.setBounds(10, 135, 165, 25);
		panelCadastro.add(labelNomeCliente);
		panelCadastro.add(clienteNome);
		
		clienteTelefone = new JTextField(20);
		clienteTelefone.setBounds(10, 215, 165, 25);
		labelTelefoneCliente = new JLabel("Telefone");
		labelTelefoneCliente.setBounds(10, 195, 165, 25);
		panelCadastro.add(labelTelefoneCliente);
		panelCadastro.add(clienteTelefone);
		
		clienteButton = new JButton("Novo cliente");
		clienteButton.setBounds(10, 245, 165, 25);
		clienteButton.addActionListener(this);
		panelCadastro.add(clienteButton);
		
		tituloCaixa = new JLabel("Caixa");
		tituloCaixa.setBounds(260, -5, 165, 25);
		panelCadastro.add(tituloCaixa);
		
		caixaLogin = new JTextField(20);
		caixaLogin.setBounds(260, 35, 165, 25);
		labelLoginCaixa = new JLabel("Login");
		labelLoginCaixa.setBounds(260, 10, 165, 25);
		panelCadastro.add(labelLoginCaixa);
		panelCadastro.add(caixaLogin);
		
		caixaSenha = new JPasswordField(20);
		caixaSenha.setBounds(260, 95, 165, 25);
		labelSenhaCaixa = new JLabel("Senha");
		labelSenhaCaixa.setBounds(260, 70, 165, 25);
		panelCadastro.add(labelSenhaCaixa);
		panelCadastro.add(caixaSenha);
		
		caixaNome = new JTextField(20);
		caixaNome.setBounds(260, 160, 165, 25);
		labelNomeCaixa = new JLabel("Nome");
		labelNomeCaixa.setBounds(260, 135, 165, 25);
		panelCadastro.add(labelNomeCaixa);
		panelCadastro.add(caixaNome);
		
		caixaTelefone = new JTextField(20);
		caixaTelefone.setBounds(260, 215, 165, 25);
		labelTelefoneCaixa = new JLabel("Telefone");
		labelTelefoneCaixa.setBounds(260, 195, 165, 25);
		panelCadastro.add(labelTelefoneCaixa);
		panelCadastro.add(caixaTelefone);
		
		caixaButton = new JButton("Novo caixa");
		caixaButton.setBounds(260, 245, 165, 25);
		caixaButton.addActionListener(this);
		panelCadastro.add(caixaButton);
		
		tituloAdministrador = new JLabel("Administrador");
		tituloAdministrador.setBounds(510, -5, 165, 25);
		panelCadastro.add(tituloAdministrador);
		
		administradorLogin = new JTextField(20);
		administradorLogin.setBounds(510, 35, 165, 25);
		labelLoginAdministrador = new JLabel("Login");
		labelLoginAdministrador.setBounds(510, 10, 165, 25);
		panelCadastro.add(labelLoginAdministrador);
		panelCadastro.add(administradorLogin);
		
		administradorSenha = new JPasswordField(20);
		administradorSenha.setBounds(510, 95, 165, 25);
		labelSenhaAdministrador = new JLabel("Senha");
		labelSenhaAdministrador.setBounds(510, 70, 165, 25);
		panelCadastro.add(labelSenhaAdministrador);
		panelCadastro.add(administradorSenha);
		
		administradorNome = new JTextField(20);
		administradorNome.setBounds(510, 160, 165, 25);
		labelNomeAdministrador = new JLabel("Nome");
		labelNomeAdministrador.setBounds(510, 135, 165, 25);
		panelCadastro.add(labelNomeAdministrador);
		panelCadastro.add(administradorNome);
		
		administradorTelefone = new JTextField(20);
		administradorTelefone.setBounds(510, 215, 165, 25);
		labelTelefoneAdministrador = new JLabel("Telefone");
		labelTelefoneAdministrador.setBounds(510, 195, 165, 25);
		panelCadastro.add(labelTelefoneAdministrador);
		panelCadastro.add(administradorTelefone);
		
		admButton = new JButton("Novo administrador");
		admButton.setBounds(510, 245, 165, 25);
		admButton.addActionListener(this);
		panelCadastro.add(admButton);
		
		
		
		frameCadastro.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUICadastro();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent clique) {
		String loginCliente  = this.clienteLogin.getText();
		String senhaCliente = this.clienteSenha.getText();
		String nomeCliente = this.clienteNome.getText();
		String telefoneCliente = this.clienteTelefone.getText();
		
		String loginCaixa  = this.caixaLogin.getText();
		String senhaCaixa = this.caixaSenha.getText();
		String nomeCaixa = this.caixaNome.getText();
		String telefoneCaixa = this.caixaTelefone.getText();
		
		String loginAdministrador  = this.administradorLogin.getText();
		String senhaAdministrador = this.administradorSenha.getText();
		String nomeAdministrador = this.administradorNome.getText();
		String telefoneAdministrador = this.administradorTelefone.getText();
		
	  CLI:	if(clique.getSource() == clienteButton) {
			String[] dados = new String[]{loginCliente, senhaCliente, nomeCliente, telefoneCliente};
			for(int i = 0; i < dados.length; i++) {
				if(dados[i] == null || dados[i] == "") {
					insiraDados();
					break CLI;					
				}
			}
			ControladorCliente cCliente = new ControladorCliente();
			cCliente.controlaCadastro(loginCliente, senhaCliente, nomeCliente, telefoneCliente);
			clienteButton.setText("Cliente inserido");
			
		}
		
		CXA:	if(clique.getSource() == caixaButton) {
			String[] dados = new String[]{loginCaixa, senhaCaixa, nomeCaixa, telefoneCaixa};
			for(int i = 0; i < dados.length; i++) {
				if(dados[i] == null || dados[i] == "") {
					insiraDados();
					break CXA;					
				}
			}
			ControladorCaixa cCaixa = new ControladorCaixa();
			cCaixa.controlaCadastro(loginCaixa, senhaCaixa, nomeCaixa, telefoneCaixa);
			caixaButton.setText("Caixa inserido");
			
		}
		
		ADM:	if(clique.getSource() == admButton) {
			String[] dados = new String[]{loginAdministrador, senhaAdministrador, nomeAdministrador, telefoneAdministrador};
			for(int i = 0; i < dados.length; i++) {
				if(dados[i] == null || dados[i] == "") {
					insiraDados();
					break ADM;					
				}
			}
			ControladorADM cADM = new ControladorADM();
			cADM.controlaCadastro(loginAdministrador, senhaAdministrador, nomeAdministrador, telefoneAdministrador);
			admButton.setText("Administrador inserido");
			
		}
		
	}
	
	public void insiraDados() {
		System.out.println("Por favor, insira todos os dados.");
	}

}
