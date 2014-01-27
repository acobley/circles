package uk.ac.dundee.computing.aec.stores;

public class FaultsStore {

	private String Faultid;
	private String FaultSummary;
	public FaultsStore(){
		
	}
	
	public void setFaultid(String id){
		Faultid=id;
	}
	
	public void setFaultSummary(String Summary){
		FaultSummary=Summary;
	}
	
	public String getFaultid(){
		return Faultid;
	}
	
	public String getFaultSummary(){
		return FaultSummary;
	}
}
