/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

/**
 *
 * @author yohov
 */
public class QuiickSort {
	int[] matrix;
	
	public void _Quicksort(int matrix[], int a, int b){
		System.out.println();
		this.matrix = new int[matrix.length];
		int buf;
		int from = a;
		int to =b;
		int pivot = matrix[(from+to)/2];
		do{
			while(matrix[from] < pivot){
				from++;
			}while(matrix[to] > pivot){
				to--;
			}
			if(from <=to){
				System.out.println();
				buf = matrix[from];
				matrix[from] = matrix[to];
				matrix[to] = buf;
				from++;to--;
				System.out.println();
			}
		}while(from <= b);
		System.out.println();
		if(a < to){
			_Quicksort(matrix,a,to);
		}
		System.out.println();
		if(from < b){
			_Quicksort(matrix,from,b);
		}
		this.matrix=matrix;
	}
	
	public static void main(String Arg[]){
		QuiickSort q = new QuiickSort();
		int[] arreglo = new int[]{5,2,7,3,1,8,2,6,9};
		System.out.println();
		q._Quicksort(arreglo, 0, arreglo.length-1);
	}
}
