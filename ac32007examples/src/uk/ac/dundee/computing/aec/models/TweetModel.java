package uk.ac.dundee.computing.aec.models;

/*
 * Expects a cassandra columnfamily defined as
 * use keyspace2;
 * CREATE TABLE Tweets (
 * user varchar,
 *  interaction_time timeuuid,
 *  tweet varchar,
 *  PRIMARY KEY (user)
 * ) WITH CLUSTERING ORDER BY (interaction_time DESC);
 * To manually generate a UUID use:
 * http://www.famkruithof.net/uuid/uuidgen
 */


import java.util.LinkedList;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import uk.ac.dundee.computing.aec.lib.*;
import uk.ac.dundee.computing.aec.stores.TweetStore;
public class TweetModel {
	Cluster cluster;
	public TweetModel(){
		
	}

	public void setCluster(Cluster cluster){
		this.cluster=cluster;
	}
	
	public LinkedList<TweetStore> getTweets(){
		LinkedList<TweetStore> tweetList = new LinkedList<TweetStore>();
		Session session = cluster.connect("keyspace2");
		
		PreparedStatement statement = session.prepare("SELECT * from Tweets");
		BoundStatement boundStatement = new BoundStatement(statement);
		ResultSet rs=  session.execute(boundStatement);
		for (Row row : rs) {
		    TweetStore ts = new TweetStore();
		    ts.setTweet(row.getString("tweet"));
		    ts.setUser(row.getString("artist"));
		    tweetList.add(ts);
		}
		session.close();
		return tweetList;
	}
}
