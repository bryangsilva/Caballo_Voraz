/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterativo;

/**
 *
 * @author yohov
 */
public class BusquedaSecuencial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] arreglo = {78,9,6,4,8,2,3,5,7,45,10.2};
        int x = Busqueda(arreglo,7.0);
        System.out.println();
    }
    
    public static int Busqueda(double[] arreglo,double x){
        for(int i=0;i<arreglo.length-1;i++){
            if(arreglo[i] == x){
                return i;
            }
        }
        return -1;
    }
    
}
