package uk.ac.dundee.computing.stores;

public class Town {
   private String name;
   private float lat;
   private float lng;
   private int population;
	public Town(){
		
	}
	
	public boolean setTown(String Name, float lat, float lng,int Population){
		name=Name;
		this.lat=lat;
		this.lng=lng;
		this.population=Population;
		return false;
	}
	
	public String getTown(){
		return name;
	}
	
	public float getlat(){
		return lat;
	}
	
	public float getlng(){
		return lng;
	}
	
	public int getPopulation(){
		return population;
	}
}

