package com.algos;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedInsertionSort {
	
	public static AtomicInteger[] arr;
	
	public static void sort(){
		for(int i=1; i<arr.length; i++){
			AtomicInteger temp = arr[i];
			int j = i;
			while(j>0 && arr[j-1].intValue()>temp.intValue()){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	public static void main(String[] args){
		arr = new AtomicInteger[10];
		for (int i=0; i<arr.length; i++){
			arr[i] = new AtomicInteger(ThreadLocalRandom.current().nextInt(0, 5000));
		}
		sort();
		for (int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
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
