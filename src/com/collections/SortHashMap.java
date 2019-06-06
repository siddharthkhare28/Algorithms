package com.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMap {
	
	static HashMap<Integer, String> h1= new HashMap<Integer, String>();
	
	public static void main(String[] args){
		
		h1.put(2, "d");
		h1.put(3, "a");
		Set<Entry<Integer, String>> e1 = h1.entrySet();
		Iterator<Entry<Integer, String>> i1 =  e1.iterator();
		while(i1.hasNext()){
			System.out.println(i1.next());
		}
	}

}


	
