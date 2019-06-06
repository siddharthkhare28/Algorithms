package com.core;

public class Hierarchy {

	int get(int i){
		return i;
	}
	
}

class Hier extends Hierarchy{
	int get(int i){
		return 0;
	}
}