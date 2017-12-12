/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Voraces;

/**
 *
 * @author yohovani
 */
public class Caballo {
	private int x,y;
	private int xi,yi;

	public Caballo() {

	}
	
	public Caballo(int x, int y) {
		this.x = x;
		this.y = y;
		this.xi = x;
		this.yi = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXi(int xi) {
		this.xi = xi;
	}

	public void setYi(int yi) {
		this.yi = yi;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXi() {
		return xi;
	}

	public int getYi() {
		return yi;
	}
	
	
}
