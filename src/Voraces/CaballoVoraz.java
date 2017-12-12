/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Voraces;

import javax.swing.JOptionPane;

/**
 *
 * @author yohovani
 */
public final class CaballoVoraz {
	private Caballo corse;
	private final int[][] tablero;
	private int movTotales;

	public CaballoVoraz(int x,int y,int d) {
		corse = new Caballo(x,y);
		tablero = new int[d][d];
		run();
		movTotales();
		mostrarTablero();
	}
	
	public final void run(){

		for(int i=0;i<Math.pow(tablero.length, 2)-1;i++){
			this.movTotales=i+1;
			tablero[corse.getX()][corse.getY()]=i+1;
			int[] menor =  new int[9];
			menor[0]=9;
			int aux=0,m;
			for(int k=1;k<=8;k++){
				Caballo caux = movimientos(this.corse.getX(),this.corse.getY(),k);
				if(comprovacionMov(caux)){
					for(int j=1;j<=8;j++){
						if(comprovacionMov(movimientos(caux.getX(),caux.getY(),j))){
							menor[k]+=1;
						}
					}
				}
				System.out.print("");
				if((menor[k] < menor[k-1] && menor[k] > 0 && menor[k] > 0) || (menor[k] > menor[k-1] && menor[k] > 0 && menor[k] > 0)){
					aux = k;
				}
			}
			if(aux == 0){
				break;
			}else{
				this.corse = movimientos(this.corse.getX(),this.corse.getY(),aux);
			}
		
		}
	}
	
	public Caballo movimientos(int x,int y,int i){
		Caballo aux = new Caballo();
		switch(i){
			case 1:{
				aux.setX(x-1);
				aux.setY(y-2);
				break;
			}
			case 2:{
				aux.setX(x-2);
				aux.setY(y-1);
				break;
			}
			case 3:{
				aux.setX(x-2);
				aux.setY(y+1);
				break;
			}
			case 4:{
				aux.setX(x-1);
				aux.setY(y+2);
				break;
			}
			case 5:{
				aux.setX(x+1);
				aux.setY(y+2);
				break;
			}
			case 6:{
				aux.setX(x+2);
				aux.setY(y+1);
				break;
			}
			case 7:{
				aux.setX(x+2);
				aux.setY(y-1);
				break;
			}
			case 8:{
				aux.setX(x+1);
				aux.setY(y-2);
				break;
			}
		}
		return aux;
	}

	public boolean comprovacionMov(Caballo aux) {
		if(aux.getX() < 0 || aux.getY() < 0 || aux.getX() > tablero.length-1 || aux.getY() > tablero.length-1){
			return false;
		}else{
			if(tablero[aux.getX()][aux.getY()] != 0){
				return false;
			}
		}		
		return true;
	}

	public void movTotales() {
		JOptionPane.showMessageDialog(null,"Número de Movimientos Maximos: "+this.movTotales); 
	}
	
	public final void mostrarTablero(){
        if (this.tablero !=null){
         TableroVisual visual = new TableroVisual(tablero);
         visual.mostrarMatriz();
        }
	}
	
}
