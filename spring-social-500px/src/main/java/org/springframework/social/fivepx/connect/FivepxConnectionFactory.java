package org.springframework.social.fivepx.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.fivepx.api.Fivepx;

public class FivepxConnectionFactory extends OAuth1ConnectionFactory<Fivepx> {
	public FivepxConnectionFactory(String consumerKey, String consumerSecret) {
		super("500px", new FivepxServiceProvider(consumerKey, consumerSecret), new FivepxAdapter());
	}
}
