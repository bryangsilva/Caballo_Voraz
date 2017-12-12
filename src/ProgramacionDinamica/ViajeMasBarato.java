/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionDinamica;

/**
 *
 * @author yohovani
 */
public class ViajeMasBarato {
	private int MaxEmbarcaderos;
	private double[][] Matriz;
	private double[][] T;

	public ViajeMasBarato() {
	}

	public ViajeMasBarato(int MaxEmbarcaderos, double[][] Matriz, double[][] T) {
		this.MaxEmbarcaderos = MaxEmbarcaderos;
		this.Matriz = Matriz;
		this.T = T;
	}

	public ViajeMasBarato(int MaxEmbarcaderos, double[][] T) {
		this.MaxEmbarcaderos = MaxEmbarcaderos;
		this.T = T;
		this.Matriz = T;
	}
	
		///Primer Process del PDF
	public void costes(double[][] c,int origen,int n){
		this.Matriz = c;
		
		for(int i=0;i<n;i++)
			c[i][i]=0;
		for(int d=origen;d<=n-1;d++){
			for(int i=origen;i<=n-d;i++){
				c[i][i+d]=min(c,i,i+d);
			}
			System.out.println("");
		}
	}
	//Segundo For del Process
	public double min(double[][] c, int i, int j) {
		//max(i,j) nos regresa el mayor de dos numeros
		double min = Math.max(i, j);//max(i,j);
		for(int k=i+1;k<=j;k++)
			//min2(i,c[][]+c[][]) nos regresa el menor de dos numeros
			min=Math.min(min, (T[i][k]+c[k][j]));//min2(min,(c[i][k]+c[k][j]));
		
			//		System.out.println("");
		return min;
	}

	public double min2(double min, double d) {
		if(min < d)
			return min;
		else
			return d;
	}

	public double max(int i, int j) {
		if(i > j)
			return i;
		else
			return j;
	}
	
	public void imprimir(){
		for(int i=0;i<this.MaxEmbarcaderos;i++){
			for(int j=0;j<this.MaxEmbarcaderos;j++){
				System.out.print(Matriz[i][j]+"| ");
			}
			System.out.println();
		}
	}

	public int getMaxEmbarcaderos() {
		return MaxEmbarcaderos;
	}

	public double[][] getMatriz() {
		return Matriz;
	}

	public double[][] getT() {
		return T;
	}

	
	
	public static void main(String[] args){
		int n = 4;

		double[][] T = new double[n][n];
		T[0][1]=1;
		T[0][2]=1;
		T[0][3]=4;
		T[1][2]=1;
		T[1][3]=6;
		T[2][3]=1;
		ViajeMasBarato v = new ViajeMasBarato(n,T);
		v.costes(T,1,3);
		v.getMatriz();
		v.imprimir();
		System.out.println();
	}
}
