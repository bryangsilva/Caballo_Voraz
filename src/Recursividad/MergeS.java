/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

/**
 *
 * @author yohovani
 */
public class MergeS {
	public static void main(String arg[]){
		int arr[] = {7,8,9,6,3,25};
		imprimir(arr);
		MergeS m = new MergeS();
		m.sort(arr, 0, arr.length-1);
		imprimir(arr);
	}
	
	public void merge(int arr[],int l,int m,int r){
		int n1 = m-l+1;
		int n2 = r-m;

		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for (int i=0;i<n1;i++)
			L[i]=arr[l+1];
		for (int j=0;j<n2;j++)
			R[j]=arr[m+j+1];
		
		int i=0, j=0, k=l;

		while (i < n1 && j < n2){
			if(L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			}else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2){
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	public void sort(int arr[],int l,int r){
		if (l < r){
			int m = (l+r)/2;
			
			sort(arr,l,m);
			sort(arr,m+1,r);
			
			merge(arr,l,m,r);
		}
	}
	
	public static void imprimir(int arr[]){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
