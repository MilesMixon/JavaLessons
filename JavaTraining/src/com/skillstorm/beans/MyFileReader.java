package com.skillstorm.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.UnmappableCharacterException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

	private final static String testFile1 = "C:\\Skillstorm\\JavaLessons\\JavaTraining\\TestFile1.txt";
	private final static String testFile2 = "C:\\Skillstorm\\JavaLessons\\JavaTraining\\TestFile2.txt";
	private final static String csvFile = "C:\\Skillstorm\\JavaLessons\\JavaTraining\\CsvFile.csv";
	
	public static void readFile() {
//		BufferedReader br = null;
//		
//		//the long way
//		try {
//			//opens the file
//			br = new BufferedReader(new FileReader(testFile1)); //will throw an exception if the file does not exist
//			
//			String line;
//			while ((line = br.readLine()) != null) { //null marks the end of the file
//				System.out.println(line);
//			}
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//			
//		} finally {
//			//we must manually close the file or else it stays open
//			try {
//				br.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		//this is a shorter loop
		//can use a BufferedReader
		//this is a try with resources statement. It will close any connections for the resources i define
		System.out.println("Every Line:");
		try (BufferedReader br = new BufferedReader(new FileReader(testFile1))) {
			String line;
			while ((line = br.readLine()) != null) { //null marks the end of the file
				System.out.println(line);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void writeLines() {
		File file = new File(testFile2);
		// file will be null if i never created it
		
		if (file.exists()) {
			System.out.println("The file exists");
		} else {
			System.out.println("The file does not exist");
		}
		
		//buffer writer overwrites, but if you specify true it will append
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
			out.write("Lines added to the file\n");
			out.write("More lines added to the file\n");
			out.write("---------------------\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<CSVData> parseCSV() {
		//there might be a header at the top of the csv file, but in our case there isnt
		//CSVs are just excel files
		List<CSVData> retList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String line;
			//if there was a header, you would just read that in and then read the rest of the lines as normal
			while((line = br.readLine()) != null) {
				String[] vals = line.split(","); //this does not change the line
				
				retList.add(new CSVData(vals[0].trim(), Integer.parseInt(vals[1]), vals[2].trim()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return retList;
	}
}
