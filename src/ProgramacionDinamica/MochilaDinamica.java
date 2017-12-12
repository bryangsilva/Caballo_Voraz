/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionDinamica;

import java.util.ArrayList;

/**
 *
 * @author yohov
 */
public class MochilaDinamica {
	private final int[][] matrizBeneficios;
	private final int w;
	private int n;
	private String combinaciones;
	
	public MochilaDinamica(int i,int w) {
		this.matrizBeneficios = new int[i+1][w+1];
		this.w = w;
		combinaciones="";
	}
	
	public void constrirMatriz(ArrayList<int[]> n){
		this.n=n.size();
		for(int w=0;w<this.w;w++)
			this.matrizBeneficios[0][w]=0;
		for(int i=1;i<n.size();i++)
			this.matrizBeneficios[i][0]=0;
		
		for(int i=1,j=0;i<=n.size();i++,j++){
			for(int w=0;w<=this.w;w++){
				if(n.get(j)[0] <= w){
					if(n.get(j)[1] + this.matrizBeneficios[i-1][w-n.get(j)[0]] > this.matrizBeneficios[i-1][w]){
						this.matrizBeneficios[i][w] = n.get(j)[1] + this.matrizBeneficios[i-1][w-n.get(j)[0]];
					}else{
						this.matrizBeneficios[i][w] = this.matrizBeneficios[i-1][w];
					}
				}else{
					this.matrizBeneficios[i][w] = this.matrizBeneficios[i-1][w];
				}
			}
		}
	}
	
	public void encontrarCombinaciones(ArrayList<int[]> n){
		int i=n.size(),k=this.w;
		while(this.matrizBeneficios[i][k] > 0){
			if(this.matrizBeneficios[i][k] != this.matrizBeneficios[i-1][k]){
				this.combinaciones+=i+" ";
				i--;k-=n.get(i)[0];
			}else{
//				this.combinaciones+="0 ";
				i--;
			}
		}
	}

	public int[][] getMatrizBeneficios() {
		return matrizBeneficios;
	}

	public int getW() {
		return w;
	}

	public String getCombinaciones() {
		return combinaciones;
	}
	
	public void imprimirMatriz(){
		for(int i=0;i<=this.n;i++){
			for(int j=0;j<=this.w;j++){
				System.out.print(this.matrizBeneficios[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

	public MochilaDinamica(int[][] matrizBeneficios, int w) {
		this.matrizBeneficios = matrizBeneficios;
		this.w = w;
	}
	
	public static void main(String[] args){
		ArrayList<int[]> n = new ArrayList();
		n.add(new int[]{2,3});
		n.add(new int[]{3,4});
		n.add(new int[]{4,5});
		n.add(new int[]{5,6});
//				n.add(new int[]{7,8});
//		n.add(new int[]{9,10});
//		n.add(new int[]{11,12});
//		n.add(new int[]{13,14});
		for(int i=0;i<n.size();i++){
			System.out.println(n.get(i)[0]+","+n.get(i)[1]);
		}
	
		MochilaDinamica m = new MochilaDinamica(n.size(),5);
		m.constrirMatriz(n);
		m.encontrarCombinaciones(n);
		System.out.println("Combinación Valida\n"+m.getCombinaciones()+"\nMatriz de beneficios\n");
		m.imprimirMatriz();
	}
}