package com.sunbeam;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the Path : ");
		String path = sc.next(); 
		File file = new File(path); 
		
		if(!file.exists()) {
			System.out.println("File not exists");
			System.exit(0);
		}
		if(file.isDirectory()) {
			String[] listing = file.list(); 
			for (String string : listing) {
				System.out.println(string);
			}
		}
		else if(file.isFile()) {
			System.out.println("Name : "+file.getName());
			System.out.println("Parent : "+file.getParent());
			System.out.println("Permissions : ");
			if(file.canRead())
				System.out.print("Read permission , ");
			if(file.canWrite())
				System.out.print("Write permission , ");
			if(file.canExecute())
				System.out.println("Execute permission");
			long lastModified = file.lastModified(); 
			System.out.println("Last modified : "+new Date(lastModified));
		}
		else {
			System.out.println("Niether a file nor a directory");
		}

		
	}

}
