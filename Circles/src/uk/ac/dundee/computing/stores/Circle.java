package uk.ac.dundee.computing.stores;

public class Circle {
    private int x;
    private int y;
    private int r;
	public Circle(){
		
	}
	public void create(int x, int y, int r){
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}public int getr(){
		return r;
	}
}
