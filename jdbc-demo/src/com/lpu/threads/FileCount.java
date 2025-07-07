package com.lpu.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileCount {
	public static void main(String[] args) throws FileNotFoundException {
		File dirInfo = new File("."); // . means current folder
		System.out.println(dirInfo.getAbsolutePath());
		System.out.println(dirInfo.isDirectory());
		System.out.println(dirInfo.isFile());
		System.out.println(dirInfo.exists());
		String[] files = dirInfo.list();
		for(String file : files)
			System.out.println(file);
		System.out.println();
		
		File fileInfo = new File("a1.txt");
		System.out.println(fileInfo.getAbsolutePath());
		System.out.println(fileInfo.exists());
		System.out.println(fileInfo.length());
		System.out.println();
		
		Scanner sc =new Scanner(System.in);
		sc =new Scanner("some string");
		sc = new Scanner(fileInfo);
		sc = new Scanner (new FileReader(fileInfo));
		
		// find all files whose name start with "a" and endswith ".txt" : 3 files  
		// create 3 threads , each thread counts the number of words in each file
		// get the sum of all the word count in main and print it
		
		
		
		
	}

}
