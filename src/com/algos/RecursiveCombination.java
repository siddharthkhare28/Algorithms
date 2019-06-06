package com.algos;

public class RecursiveCombination {
	
	public static int recComb(int x, int y){
		if(x == y || y==0){
			return 1;
		}
		return recComb(x-1, y-1) + recComb(x-1, y);
	}
	
	public static int pow(int x,int y){
		if(y==0){
			return 1;
		}
		return x*pow(x, y-1);
	}
	
	public static int factorial(int x){
		if(x==1){
			return 1;
		}
		return x*factorial(x-1);
	}
	
	public static void main(String[] args){
		System.out.println(recComb(5,3));
		System.out.println(pow(2,5));
		System.out.println(factorial(5));
	}

}
