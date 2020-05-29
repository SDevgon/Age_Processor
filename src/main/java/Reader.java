package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader  {
	
	private List<PersonDto> crowd= new CopyOnWriteArrayList<PersonDto>();
	

	public List<PersonDto> read(String path) {
		File f = new File(path);
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader r= new BufferedReader(fr);
			r.readLine();
			String l="";
			while( (l=r.readLine())!=null) {
				
				String[] data=l.split(",",-1);
				PersonDto person=new PersonDto();
				person.setName(data[0]);
				//System.out.println(data[1].hashCode());
				if(data[1].hashCode()!=0)
				person.setAge(Integer.parseInt(data[1].trim()));
				
				int size=data.length;
				person.setEmail(data[size-1]);
				
				String add="";
				for(int i =2;i<size-1;i++) {
					add=add+data[i];
				}
				person.setAddress(add);
				crowd.add(person);
			}
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		
		return crowd;
		
		
	}

}
