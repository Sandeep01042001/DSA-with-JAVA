import java.util.*;
import java.lang.*;
import java.io.*;

// input 5
// 0 -1 2 -3 1
// output 
// 0 -3 1
// -1 2 -3
 
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int [] arr = new int [n];
		for(int i=0; i<n; i++){
			arr[i] = scr.nextInt();
		}
		sumArray(arr , n ,-2);
	}
	public static void sumArray(int arr[], int n, int sum){
		for(int i=0; i<n-2; i++){
			for(int j=i+1; j<n-1; j++){
				for(int k=j+1; k<n; k++){
					if(arr[i]+arr[j]+arr[k]==sum){
						System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					}
				}
			}
		}
	}

}
