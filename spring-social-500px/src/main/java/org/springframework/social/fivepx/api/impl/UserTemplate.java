package org.springframework.social.fivepx.api.impl;

import org.springframework.social.fivepx.api.FivepxProfile;
import org.springframework.social.fivepx.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractFivepxOperations implements UserOperations {
	private final RestTemplate restTemplate;

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public long getProfileId() {
		requireAuthorization();
		return getUserProfile().getId();
	}

	@Override
	public String getScreenName() {
		requireAuthorization();
		return getUserProfile().getName();
	}

	@Override
	public FivepxProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildUri("users"), FivepxProfile.class);
	}

	@Override
	public FivepxProfile getUserProfileWithEmail(String email) {
		return restTemplate.getForObject(buildUri("users/show", "email", email), FivepxProfile.class);

	}

	@Override
	public FivepxProfile getUserProfileWithUsername(String userName) {
		return restTemplate.getForObject(buildUri("users/show", "username", userName), FivepxProfile.class);

	}

	@Override
	public FivepxProfile getUserProfileWithId(long userId) {
		return restTemplate.getForObject(buildUri("users/show", "id", String.valueOf(userId)), FivepxProfile.class);
	}
}
