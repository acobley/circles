package uk.ac.dundee.computing.aec.stores;

public class Counter {
	private int Counter=0;

	public Counter(){
	}

	public int getCounter(){
		return Counter;
	}

	public void incrementcounter(){
		Counter++;
	}


	public void  setCounter(int Counter){
		this.Counter=Counter;
	}
}
