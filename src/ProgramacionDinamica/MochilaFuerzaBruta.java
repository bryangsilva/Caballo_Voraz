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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class MochilaFuerzaBruta {
	DecimalFormat formatea;

	public static void main(String args[]){
		ArrayList<Double[]> valores = new ArrayList<Double[]>();
		Random r = new Random();

		for(int j=0;j<10;j++){
			Double[] i = new Double[2];
			i[0] = r.nextInt(100)+0.0;
			i[1] = r.nextInt(100)+0.0;
			valores.add(i);
			
		}
		System.out.println(valores.size());
		for(int k=0;k<valores.size();k++){
			System.out.println(valores.get(k)[0]+","+valores.get(k)[1]);
		}
		//se envia un arraylist con las convinaciones posibles
		//los elemtos a almacenar en la mochila
		//el tamaño de la mochila
		//La caracteristica a considerar
		ArrayList<String> ar = comprovarConvinaciones(convinaciones(valores.size()),valores,200,1);

		//
		System.out.println("----------------------------------");
		for(int k=0;k<ar.size();k++){
			System.out.println(ar.get(k));
		}
	}
    
	public static ArrayList<String> convinaciones(int x){
		long n = (long) Math.pow(2, x);
		ArrayList<String> convT = new ArrayList();
		//Calculamos todas las convinaciones posibles
		for(int i=0;i<n;i++){
			convT.add(Integer.toBinaryString(i));
		}
		String aux="";
		//Llenamos con ceros a la izquierda las convinaciones que lo requieran
		for(int i=0;i<n;i++){
			if(convT.get(i).length() != convT.get((int) (n-1)).length()){
				for(int j=0;j<convT.get((int) (n-1)).length()-convT.get(i).length();j++){
					aux+="0";
				}
				aux+=convT.get(i);
				convT.set(i, aux);
				aux="";
			}
		}
		return convT;
	}
	
	public static ArrayList<String> comprovarConvinaciones(ArrayList<String> convT,ArrayList<Double[]> art,double size,int consideracion){
		ArrayList<String> conv = new ArrayList();
		double a=0;
		//Filtramos las convinaciones que no sobrepasan la capacidad de la mochila 
		//multiplicando acumulativamente el vector de 0 y 1 con el de los elementos disponibles
		for(int i=0;i<convT.size();i++){
			for(int j=0;j<art.size();j++){
				//Almacenamos el valor de la multiplicacion de vectores 
				a+=Double.parseDouble(""+convT.get(i).charAt(j))*art.get(j)[consideracion];
			}
			if(a <= size)
				conv.add(convT.get(i)+","+a);
				ordenar(conv);
			a=0;
		}
		return conv;
	}
		
	public static void ordenar(ArrayList<String> arreglo) {
        for(int i=1; i <arreglo.size();i++){
           for(int j = i; j > 0;j--){
             // comparaciones
			 String[] x = arreglo.get(j).split(",");
			 double a = Double.parseDouble(x[1]+"");
			 String[] y = arreglo.get(j-1).split(",");
			 double b = Double.parseDouble(y[1]+"");
             if (a > b){
                 String aux = arreglo.get(j);
                 arreglo.set(j, arreglo.get(j-1));
                 arreglo.set(j-1, aux);
             }
            
           }
       
       }

    }
}
