package com.core;


interface I1{
	default void m1(){
		
	}
	void impl();
}

interface I2{
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
	void impl();
}

interface I3 extends I1, I2{
	
}

public class MultiInterfaceImpl implements I1, I2{
	public void impl(){
		
	}
	
	
	public static void main(String[] args){
		I2.isNull("");		
	}
}


