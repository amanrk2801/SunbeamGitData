package com.sunbeam;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class Program {
	
	/*
	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets(); 	
		//System.out.println("Size : "+map.size());
		map.forEach((k,v) -> System.out.println(k + '-' + v));
	}*/ 
	public static void main(String[] args) {
		int b; 
		try(FileReader rd = new FileReader("File1.txt") ){
			while(( b = rd.read())!=-1) {
				System.out.print((char)b);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
