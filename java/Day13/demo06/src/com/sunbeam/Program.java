package com.sunbeam;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class Program {
	
	
	/* 
	public static void main(String[] args) {
		int b; 
		try(FileWriter fw = new FileWriter("File1.txt")){
			fw.write("Sunbeam Karad");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/ 
	public static void main(String[] args) {
		try(FileOutputStream fout = new FileOutputStream("File1.txt")){
			try(OutputStreamWriter ow = new OutputStreamWriter(fout)){
				ow.write("Sunbeam Karad");
			}
		}//fout.close(); 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
