package com.algos;

public class InsertionSort{
	public static int[] arr={2,9,4,14,6,7};
	
	
	public static void sort(){
		
		for (int i=1; i<arr.length; i++){
			int temp = arr[i];
			int j = i;
			while(j>0 && temp<arr[j-1]){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] =temp;
		}
		
	}
	
	public static void sortAgain(){
		for (int i=1; i<arr.length; i++){
			int temp = arr[i];
			int j= i;
			while (j>0 && arr[j-1]>temp){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	public static void main(String[] args){
		for (int i=1; i<arr.length; i++){
		System.out.println(arr[i]);
		}
		sort();
		for (int i=1; i<arr.length; i++){
		System.out.println(arr[i]);
		}
	}
}