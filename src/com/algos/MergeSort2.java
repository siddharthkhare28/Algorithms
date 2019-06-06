package com.algos;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MergeSort {
	
	public static void mergeSort(int[] a, int[] b, int l, int u){
		
		
		if(l==u){
			return;
		}else {
			int m = (l+u)/2;
			mergeSort(a, b, l, m);
			mergeSort(a, b, m+1, u);
			merge(a,b,l,m,u);
		}
		
	}
	
	public static void multiThreadedMergeSort(){
		
	}
	
	public static void merge(int[] a, int[] b, int l, int m, int u){
		int j = 0;
		int n = u-l+1;
		int low = l;
		int mid = m;
		int h = m+1;
		while(l<=m && h<=u){
			if (a[l]<a[h])
				b[j++] = a[l++];
			else
				b[j++] = a[h++];
		}
		while (l<=mid){
			b[j++] = a[l++]; 
		}
		while (h<=u){
			b[j++] = a[h++];
		}
		for (j=0; j<n; j++){
			a[low+j] = b[j]; 
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,21,5,16,9,2,8};
		int[] b = new int[arr.length];
		Arrays.parallelSort(arr);
		mergeSort(arr, b, 0, arr.length-1);
		for (int j=0; j<arr.length; j++){
			System.out.println(arr[j]);
		}
	}

}
