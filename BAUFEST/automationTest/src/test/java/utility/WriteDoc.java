package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDoc {
	public static String writeDocumentInfo(String username,String filePath) throws Throwable
    {
		FileWriter filewrite; 
		 try
		 { 
		filewrite = new FileWriter(filePath); 
		 
		 // Initialing BufferedWriter 
		 BufferedWriter bufferwrite = new BufferedWriter(filewrite); 
		 System.out.println("Buffered Writer start writing :)"); 
		 
		 // Use of write() method to write the value in 'ABC' file 
		 bufferwrite.write(username); 
		 //bufferwrite.write(49); 
		 
		 // Closing BufferWriter to end operation 
		 bufferwrite.close(); 
		 return "Written successfully"; 
		 } 
		 catch (IOException excpt) 
		 { 
		 excpt.printStackTrace(); 
		 }
		return "Written successfully"; 
		 
		 } 
		
    }


