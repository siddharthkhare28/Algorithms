package com.sorting;

public class MergeSort {
	
	public static void mergeSort(int[] array){
		int[] workspace = new int[array.length];
		recSort(array, workspace, 0, array.length-1);
	}
	
	public static void recSort(int[] array, int[] workspace, int lowBound, int upperBound){
		if(lowBound == upperBound){
			return;
		}else{
		int mid = (lowBound+upperBound)/2;
		
		recSort(array, workspace, lowBound, mid);
		recSort(array, workspace, mid+1, upperBound);
		
		merge(array, workspace, lowBound, mid+1, upperBound);
		}
	}
	
	public static void merge(int[] array, int[] workspace, int lowBound, int mid, int upperBound){
		int j =0;
		int lowVal = lowBound;
		int midVal = mid-1;
		int n = upperBound - lowBound + 1;
		
		while(lowBound<=midVal && mid<=upperBound){
			if(array[lowBound]<=array[mid]){
				workspace[j++] = array[lowBound++];
			}
			if(array[mid]<array[lowBound]){
				workspace[j++] = array[mid++];
			}
		}
		
		while(lowBound<=midVal){
			workspace[j++] = array[lowBound++];
		}
		
		while(mid<=upperBound){
			workspace[j++] = array[mid++];
		}
		
		for(int i=0; i<n; i++){
			array[lowVal+i] = workspace[i];
		}
	}
	
	public static void main(String[] args){
		int[] a = {4,2,6,7,4};
		mergeSort(a);
		for(int i:a){
			System.out.println(i);
		}
	}

}
