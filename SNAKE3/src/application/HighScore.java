package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScore {
	public static int readFileByLine(String file) {
		String line;
		int i = 0;
		BufferedReader br=null;
		try {
			FileReader fr=new FileReader(file);
			br=new BufferedReader(fr);
			
			while((line=br.readLine())!=null) {
				
				i=Integer.parseInt(line);	
				
			}
		 
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} finally{
			try {
				if(br !=null) {
				br.close();}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return i;
		
	}
		
		
	
	public static void writeFile(int text) {
		BufferedWriter bw=null;
		try {
			FileWriter fw=new FileWriter("highscore.txt");
			bw=new BufferedWriter(fw);
			bw.write(text+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			System.exit(1);
		} finally {
			try {
				if(bw !=null) {
				bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.exit(1);
			}
}
}}