package com.sunbeam;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Program {
	
	/* 
	public static void main(String[] args) {
		int b; 
		try(FileReader rd = new FileReader("File1.txt")){
			while(( b = rd.read())!=-1) {
				System.out.print((char)b);
			}
		}//rd.close(); 
		catch (Exception e) {
			e.printStackTrace();
		}

	}*/  
	public static void main(String[] args) {
		int b; 
		try(FileInputStream fin = new FileInputStream("File1.txt")){
			try(InputStreamReader in = new InputStreamReader(fin)){
				while(( b = in.read())!=-1) {
					System.out.print((char)b);
				}
			}
		}//fin.close(); 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
