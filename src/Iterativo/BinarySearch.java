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
public class BinarySearch {
	// Returns index of x if it is present in arr[], else
    // return -1
    public int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;//	3
        while (l <= r)//	---------->n
        {
            int m = l + (r-l)/2;//		--------->4n
 
            // Check if x is present at mid
            if (arr[m] == x)//		--------->2n
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)//		---------->2n
                l = m + 1;//		---------->2n
 
            // If x is smaller, ignore right half
            else
                r = m - 1;//		-------->2n
        }
 
        // if we reach here, then element was not present
        return -1;
		//Total de Operaciones Elementales = 13n + 3
    }
 
    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 403, 32, 41, 100, 4002, 37, 48, 190, 4502, 36, 45, 110, 4102, 13, 14, 110, 240,1};
        int n = arr.length;
        int x = 1;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);
    }
}
