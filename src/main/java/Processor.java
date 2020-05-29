package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Processor {

	Reader reader= new Reader();
	
	public void process(String path) {
		
		List<PersonDto> list = reader.read(path);
		
		for(PersonDto tem: list) {
			if(!tem.getEmail().contains("@"))
				list.remove(tem);
			if(!tem.getEmail().contains(".com"))
			list.remove(tem);
			
			
			if(!tem.getAddress().contains("India"))
				list.remove(tem);
			if(tem.getAddress()==""||tem.getAddress()==null)
				list.remove(tem);
			if(tem.getAge()==0)
				list.remove(tem);
			
		}
		File fo = new File("src/main/resource/"+"Output.csv");
		try {
			FileWriter fw = new FileWriter(fo);
			BufferedWriter wr = new BufferedWriter(fw);
			
			for(PersonDto tem: list) {
				if(tem.getAge()<18)
					wr.append(tem.getName()+","+"KID");
				else
					wr.append(tem.getName()+","+"ADULT");
				wr.append("\n");
				
			}
			wr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
