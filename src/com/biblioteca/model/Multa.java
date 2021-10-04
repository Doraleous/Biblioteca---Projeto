package com.biblioteca.model;

import java.sql.Date;
import java.util.ArrayList;



public class Multa {
	
	public double valor;
	public Cliente cliente;
	public Transferencia transferencia;
	public Date dataVencimento;
	public ArrayList<Transferencia> transferencias;

}
