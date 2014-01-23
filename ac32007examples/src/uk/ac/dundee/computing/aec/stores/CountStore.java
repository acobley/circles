package uk.ac.dundee.computing.aec.stores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CountStore {
	private int Counter=0;

	public CountStore(){
	}

	public int getCounter(){
			int Counter;
		File Name=new File("\\tmp\\count.tmp");
		Counter=ReadCounter(Name);
		return Counter;
	}

	public void incrementCounter(){
		int Count;
		File Name=new File("\\tmp\\count.tmp");
		Count=ReadCounter(Name);
		Count++;
		WriteCounter(Name,Count);


	}
	
	int ReadCounter(File Name){
    FileInputStream Filestream=null;
	DataInputStream Inputstream=null;
	int Count=0;
	try{
		Filestream= new FileInputStream(Name);
	}catch(FileNotFoundException et){
		Count=0;
		return(Count);
	}catch(SecurityException et){
		System.out.println("No access to counter for reading");
		Count=0;
	}
	Inputstream= new DataInputStream(Filestream);
	try{
		Count=Inputstream.readInt();
	}catch(Exception et){
		Count=0;
	}
	try{
        	Filestream.close();
	}catch(IOException et){
		System.out.println("Can not close file after reading "+et);
	}
	return(Count);
}

void WriteCounter(File Name,int Count){
        FileOutputStream Filestream=null;
	DataOutputStream Outputstream=null;
	try{
		Filestream= new FileOutputStream(Name);
	}catch(FileNotFoundException et){
		System.out.println("Counter not Found");
		System.exit(-1);
	}catch(SecurityException et){
		System.out.println("No access to counter");
		System.exit(-1);
	}catch(Exception et){
		System.out.println("Can not access file for writing");
	}
	Outputstream= new DataOutputStream(Filestream);
	try{
		Outputstream.writeInt(Count);
	}catch(IOException et){
		System.out.println("Can not write file");
	}
	try{
		Filestream.close();
	}catch(IOException et){
		System.out.println("Can not close file"+et);
	}

 


}



	public void  setCounter(int Counter){
		File Name=new File("\\tmp\\count.tmp");
		WriteCounter(Name,Counter);
	}
}

