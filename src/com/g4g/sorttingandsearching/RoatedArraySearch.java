package com.g4g.sorttingandsearching;

public class RoatedArraySearch {

	public static int search(int[] a){
		return rotSearch(a, 0, a.length-1);
	}
	
	public static int rotSearch(int[] a, int initial, int end){
		if(end<=initial){
			return -1;
		}
		int mid = initial+ (end -initial)/2;
		if(a[mid]>a[mid+1]){
			return mid;
		}
		if(a[0]<a[mid]){
			return rotSearch(a, mid+1, end);
		}else {
			return rotSearch(a, 0, mid);
		}
	}
	public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void main(String[] args){
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int arr2[] = { 3, 2, 1};
		System.out.println(search(arr2));
	}
	
}
