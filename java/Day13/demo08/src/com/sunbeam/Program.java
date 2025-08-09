package com.sunbeam;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Program {
	private static Scanner sc = new Scanner(System.in);

	public static void writeRecord(String path) throws Exception {
		try (FileWriter writer = new FileWriter(path)) {
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				writer.write(ch);
			}
		}
	}

	public static void readRecord(String path) throws Exception {
		int data;
		try (FileReader reader = new FileReader(path)) {
			while ((data = reader.read()) != -1) {
				System.out.print((char) data);
			}
		}
		System.out.println();
	}

	public static int menuList() {
		System.out.println("0.Exit");
		System.out.println("1.WriteRecord : ");
		System.out.println("2.ReadRecord : ");
		System.out.println("Enter the choice : ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		int choice;
		String path = "File1.txt";
		while ((choice = menuList()) != 0) {
			try {
				switch (choice) {
				case 1:
					Program.writeRecord(path);
					break;
				case 2:
					Program.readRecord(path);
					break;
				default:
					System.out.println("Invalid choice : ");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
