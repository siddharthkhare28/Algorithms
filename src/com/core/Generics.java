package com.core;

import java.util.ArrayList;
import java.util.List;

public class Generics<T, U> {

	List<T> list = new ArrayList<T>();
	
	Object[] keys = new Object[10];
	Object[] values = new Object[10];
	
	String[] arr = new String[6];
	public U getU(T t){
		list.add(t);
		return null;
	}
	
}
