package uk.ac.dundee.computing.stores;

public class Town {
   private String name;
   private double lat;
   private double lng;
   private int population;
   private String county;
	public Town(){
		
	}
	
	public boolean setTown(String Name, double lat, double lng,int Population){
		name=Name;
		this.lat=lat;
		this.lng=lng;
		this.population=Population;
		return false;
	}
        
        public boolean setTown(String Name, double lat, double lng,int Population,String County){
		name=Name;
		this.lat=lat;
		this.lng=lng;
		this.population=Population;
                this.county=County;
		return false;
	}
	
	public String getTown(){
		return name;
	}
	
	public double getlat(){
		return lat;
	}
	
	public double getlng(){
		return lng;
	}
	
	public int getPopulation(){
		return population;
	}
        public String getCounty(){
            return county;
        }
        
        
}

