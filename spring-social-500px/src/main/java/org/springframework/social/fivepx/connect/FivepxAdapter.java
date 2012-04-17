package org.springframework.social.fivepx.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.fivepx.api.Fivepx;
import org.springframework.social.fivepx.api.FivepxProfile;

public class FivepxAdapter implements ApiAdapter<Fivepx> {

	@Override
	public UserProfile fetchUserProfile(Fivepx fivepx) {
		FivepxProfile profile = fivepx.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getName()).setUsername(profile.getName()).build();
	}

	@Override
	public void setConnectionValues(Fivepx fivepx, ConnectionValues values) {
		FivepxProfile profile = fivepx.userOperations().getUserProfile();
		values.setProviderUserId(Long.toString(profile.getId()));
		values.setDisplayName(profile.getName());
		values.setProfileUrl(profile.getDomain());
		values.setImageUrl(profile.getUserpicUrl());
	}

	@Override
	public boolean test(Fivepx fivepx) {
		try {
			fivepx.userOperations().getUserProfile();
			return true;
		}
		catch (ApiException e) {
			return false;
		}
	}

	@Override
	public void updateStatus(Fivepx fivepx, String status) {
		throw new UnsupportedOperationException("updateStatus() method is not supported!!!");
	}

}
