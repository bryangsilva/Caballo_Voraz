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
public class Multiplicacion {
    public static void main(String arg[]){
	System.out.println(multiplicacion2(7,8,9));
    }
    
    public static double multiplicacion(double a,double b,double c){
		if(a == 0 || b == 0 || c == 0)
			return 0;
		else{
			if(a*c < b){
				if (a == 1){
					return b;
				}
				else
					return b+multiplicacion((a*c)-1,b,1);
				}
			else{
				if (b == 1){
					return b;
				}
				else
					return a+multiplicacion(a,(b*c)-1,1);
			}
		}
	}

    
    public static double multiplicacion(double a,double b){
		if(a == 0 || b == 0)
		    return 0;
		else{
		    if(a < b){
				if(a > 1)
					return b+multiplicacion(a-1,b);
				else
					return b;
			}
			else{
				if(b > 1)
					return a+multiplicacion(a,b-1);
				else
					return a;
		    }
		}
    }
	
	
	public static double multiplicacion2(double a,double b,double c){
		if(a == 0 || b == 0 || c == 0)
			return 0;
		else{
			if(c == 1){
				if(a < b){
					if (a == 1){
						return b;
					}
					else
						return b+multiplicacion2((a)-1,b,1);
					}
				else{
					if (b == 1){
						return b;
					}
					else
						return a+multiplicacion2(a,(b)-1,1);
				}
			}else{
				if (c > 1){
					return a+multiplicacion2(a,(b),c-1);
				}else{
					return c;
				}
			}
		}
	}
	
}
