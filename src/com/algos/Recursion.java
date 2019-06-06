package com.algos;

public class Recursion {
	
	public static int[] arr = {1,3,5,7,9,10,11};
	
	public static int fac(int n){
		if(n==1){
			return 1;
		}
		return n*(fac(n-1));
	}
	
	public static int search(int n, int l, int u){
		if (l>u){
			return -1;
		}else{
			int temp = (l+u)/2;
			if (arr[temp]==n){
				return temp;
			}else if(arr[temp]>n){
				u = temp -1;
				return search(n, l, u);
			}else {
				l = temp + 1;
				return search(n, l, u);
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println(search(11, 0 , arr.length-1));
	}

}
