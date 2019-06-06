package com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Construct {

	public static int a;
	public static int b;
	
	public Construct(int a){
		this.a = a;
	}
	
	public static void addNumbers(Object ...args){
		 int sum = 0;
		 for (Object object : args) {
		 sum += (Integer)object;
		 }
		 System.out.println("sum is " + sum);
		 } 
	
	static{
			if (a==1){
				b= 5;
			}
		}
	
	public void testM(){
		addNumbers(1,2);
	}
	
	public static void main(String[] args){
		Construct c = new Construct(1);
		Set a = new HashSet();
		a.add(1);
		a.add("1");
		a.add(null);
		a.add("null");
		String[] sArray = {};
		Object obj = new Object();
		Arrays.sort(sArray);
		System.out.println(a);
		System.out.println(c.b);
		addNumbers(1,2);
		c.testM();
	}
	
}
