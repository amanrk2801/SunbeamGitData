package com.sunbeam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the srcFile : ");
		String srcFile = sc.next(); 
		System.out.println("Enter the destFile : ");
		String destFile = sc.next(); 
		int b; 
		try(FileInputStream fin = new FileInputStream(srcFile)){
			try(FileOutputStream fout = new FileOutputStream(destFile)){
				while((b = fin.read())!=-1) {
					fout.write(b);
				}
			}//fout.close(); 
			System.out.println("File copied");
		}//fin.close(); 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
