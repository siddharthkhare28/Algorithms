package com.g4g.sorttingandsearching;

public class BubbleSort {
	
	public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void main(String args[])
    {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
	
	public static void bubbleSort(int[] a){
		int j =a.length;
		while(j>0){
			for(int i=0; i<j-1; i++){
				if(a[i]>a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			j--;
		}
	}
	
	public static void insertionSort(int[] a){
		int n = a.length;
		for(int i=1; i<n-1; i++){
			int temp = a[i];
			for(int j =i; j>=0; j--){
				if(j>0){
					if(a[j-1]>temp){
						a[j]=a[j-1];
					}else{
						a[j] = temp;
						break;
					}
				}else{
					a[j] = temp;
					break;
				}
			}
			
		}
	}

}
