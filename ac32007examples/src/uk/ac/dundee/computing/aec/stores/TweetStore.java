package uk.ac.dundee.computing.aec.stores;

public class TweetStore {
     String Tweet;
     String User;
     
     public String getTweet(){
    	 return Tweet;
     }
     public String getUser(){
    	 return User;
     }
     
     public void setTweet(String Tweet){
    	 this.Tweet=Tweet;
     }
     public void setUser(String User){
    	 this.User=User;
     }
     
}
