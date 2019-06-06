package com.algos;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSelectionSort {
	
	public static AtomicInteger[] arr;

	public static void sort(){
		Thread currentThread = Thread.currentThread();
		int mid =0;
		int min =0;
		for(int i=0; i<arr.length; i++){
			mid = arr.length;
			min = i;
			for (int j=i+1; j<arr.length; j++){
				if(arr[min].intValue()>arr[j].intValue()){
					min = j;
				}
			}
			swap(i,min);
		}
	}
	
	public static void swap(int first, int second){
		AtomicInteger temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	public static void main(String[] args){
		arr = new AtomicInteger[10];
		for (int i=0; i<arr.length; i++){
			arr[i] = new AtomicInteger(ThreadLocalRandom.current().nextInt(0, 5000));
		}
		sort();
		for (int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	
	class SortingThread implements Runnable{
		
		private int startPoint;
		private int endPoint;
		
		public SortingThread(int startPoint, int endPoint){
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		}
		
		@Override
		public void run() {
			
		}
		
	}
}
