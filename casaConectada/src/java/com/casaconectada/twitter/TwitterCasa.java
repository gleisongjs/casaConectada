/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casaconectada.twitter;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;


/**
 *
 * @author Gleisongjs
 */
public class TwitterCasa {
    
      /*
     public static void main(String[] args) {
      System.err.println(new TwitterCasa().tw(""));
       }
    */
     public boolean tw(String mensagem){
         try {
			ConfigurationBuilder builder = new ConfigurationBuilder();
			
			builder.setOAuthConsumerKey("9yVXdpHRetwN643Qux2TE2C14");
			builder.setOAuthConsumerSecret( "sBmujbqdIwnKD8ucd96p3bsam3MguiSThFXbMzzJLgQI4M4rl6");
			
			Configuration configuration = builder.build();
 
			TwitterFactory factory = new TwitterFactory(configuration);
			Twitter twitter = factory.getInstance();      
 
			AccessToken accessToken = loadAccessToken();
 
			twitter.setOAuthAccessToken(accessToken);
 
			Status status = twitter.updateStatus(mensagem);
			System.out.println("Tweet postado com sucesso! [" + status.getText() + "].");
                        return true;
                 } catch (Exception e) {
			e.printStackTrace();
                        return false;
		}
                
                 
	}
 
	
    private static AccessToken loadAccessToken(){
		String token = "832896102366068736-V2zAYhuAA8D6n0GvFjPyqitSZo1jvsX"; 
		String tokenSecret = "31ORvOjvpxU3bRYVVAgSG2vt8lxTlNbBYOCESiFeWODiZ"; 
		return new AccessToken(token, tokenSecret);
	}

}
