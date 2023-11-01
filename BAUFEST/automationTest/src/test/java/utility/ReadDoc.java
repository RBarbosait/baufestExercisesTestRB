package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDoc {
	public static String readDocumentInfo(String filePath) throws Throwable
    {
		StringBuilder builder = new StringBuilder();
		String str;
		BufferedReader buffer = new BufferedReader(
        new FileReader(filePath));
		while ((str = buffer.readLine()) != null) {
            builder.append(str).append("\n");
        }
		return builder.toString();
		
    }
}
