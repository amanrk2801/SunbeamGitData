package com.sunbeam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the srcFile : ");
		String srcPath = sc.next(); 
		Path path = Paths.get(srcPath); 
		
		if(!Files.exists(path)) {
			System.out.println("Invalid path");
		}
		if(Files.isDirectory(path)) {
			Files.list(path) 
			.forEach(e -> System.out.println(e));
		}
		else if(Files.isRegularFile(path)) {
			System.out.println("Name : "+path.getFileName());
			System.out.println("Parent : "+path.getParent());
			System.out.println("Permissions : ");
			if(Files.isReadable(path))
				System.out.print("Readable,");
			if(Files.isWritable(path)){
				System.out.print("Writable,");
			}
			if(Files.isExecutable(path))
				System.out.print("Executable");
		}
		else {
			System.out.println("Niether a file nor Directory");
		}
	}
}
