package AmazonOA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/jiaqichen/Desktop/total_ars.txt");
		BufferedReader br = null;;
		try {
			try{
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine())!=null){
				System.out.println(br.readLine());
			}
			}catch(FileNotFoundException e2){
				System.out.println("File can not be found");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("IOException happens");
		}
	}

}
