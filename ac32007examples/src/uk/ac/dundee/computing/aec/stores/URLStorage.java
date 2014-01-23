package uk.ac.dundee.computing.aec.stores;

public class URLStorage {
	private String url;

	public URLStorage(){
	}

	public String getUrl(){
		System.out.println("URLStorage.get: "+url);
		return url;
	}


	public void  setUrl(String url){
		this.url=url;
	}
}
