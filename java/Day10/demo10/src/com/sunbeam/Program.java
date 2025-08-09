package com.sunbeam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Program {
	public static void getKeys(Map<Integer,String> map) {
		Set<Integer> keys = map.keySet(); 
		for (Integer key : keys) {
			System.out.println(key);
		}
	}
	public static void getValues(Map<Integer,String> map) {
		Collection<String> values = map.values();
		for (String value : values) {
			System.out.println(value);
		}
	}
	public static void getKeyValuePair(Map<Integer,String> map) {
		Set<Entry<Integer, String>> entries = map.entrySet(); 
		for (Entry<Integer, String> en : entries) {
			System.out.println(en.getKey() + "-" + en.getValue());
		}
	}
	public static void getValueByKey(Map<Integer,String> map) {
		Set<Integer> keys = map.keySet();  
		for (Integer key : keys) {
			String values = map.get(key); 
			System.out.println(values);
		}
	}
	public static void removeEntry(Map<Integer, String> map) {
		Integer key = new Integer(2); 
		if(map.containsKey(key)) {
			String value = map.remove(key); 
			System.out.println(value + "is removed");
		}
	}
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer, String>(); 
		map.put(1, "DAC");
		map.put(2, "DMC");
		map.put(3, "DBDA");
		map.put(4, "DESD");
		map.put(5, "DITISS");
		//Program.getKeys(map);
		//Program.getValues(map);
		//Program.getKeyValuePair(map);
		Program.removeEntry(map);
	}
	

}
