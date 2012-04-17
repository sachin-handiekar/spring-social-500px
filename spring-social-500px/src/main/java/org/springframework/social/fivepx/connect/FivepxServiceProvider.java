package org.springframework.social.fivepx.connect;

import org.springframework.social.fivepx.api.Fivepx;
import org.springframework.social.fivepx.api.impl.FivepxTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;

public class FivepxServiceProvider extends AbstractOAuth1ServiceProvider<Fivepx> {
	public FivepxServiceProvider(String consumerKey, String consumerSecret) {
		super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
				"https://api.500px.com/v1/oauth/request_token", 
				"https://api.500px.com/v1/oauth/authorize",
				"https://api.500px.com/v1/oauth/authorize", 
				"https://api.500px.com/v1/oauth/access_token"));
	}

	public Fivepx getApi(String accessToken, String secret) {
		return new FivepxTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}
}
