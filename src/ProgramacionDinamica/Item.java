package ProgramacionDinamica;


import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yohovani
 */
public class Item {
	private double peso;
	private double valor;
	private int id;

	public Item() {
	}

	public Item(double peso, double valor) {
		this.peso = peso;
		this.valor = valor;
	}

	public Item(double peso, double valor, int id) {
		this.peso = peso;
		this.valor = valor;
		this.id = id;
	}

	
	public double getPeso() {
		return peso;
	}

	public double getValor() {
		return valor;
	}

	public int getId() {
		return id;
	}
	
	public ArrayList<Item> random(double p,double v, int n){
		ArrayList<Item> nueva = new ArrayList<>();
		Random r = new Random();
		for(int i=0;i<n;i++){
			nueva.add(new Item(r.nextInt((int)p)+r.nextDouble(),r.nextInt((int)v),i));
		}
		
		return nueva;
	}
	
	
}
