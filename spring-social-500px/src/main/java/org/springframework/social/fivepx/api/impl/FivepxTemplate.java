package org.springframework.social.fivepx.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.fivepx.api.Fivepx;
import org.springframework.social.fivepx.api.UserOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

public class FivepxTemplate extends AbstractOAuth1ApiBinding implements Fivepx {

	private UserOperations userOperations;

	public FivepxTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initSubApis();
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new FivepxModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	private void initSubApis() {
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}

}
