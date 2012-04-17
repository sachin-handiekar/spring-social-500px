package org.springframework.social.fivepx.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.fivepx.api.FivepxProfile;
import org.springframework.social.fivepx.api.impl.FivepxProfileMixin.FivepxProfileDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = FivepxProfileDeserializer.class)
class FivepxProfileMixin {

	static class FivepxProfileDeserializer extends JsonDeserializer<FivepxProfile> {

		@Override
		public FivepxProfile deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
				JsonProcessingException {
			FivepxProfile profile = null;
			String sex = null;
			JsonNode tree = jp.readValueAsTree();

			JsonNode profileNode = tree.get("user");
			long id = profileNode.get("id").asLong();
			String fullName = profileNode.get("fullname").asText();
			String userName = profileNode.get("username").asText();
			String city = profileNode.get("city").asText();
			String country = profileNode.get("country").asText();
			String userPicUrl = getUserProfilePicValue(profileNode, "userpic_url");
			String domain = profileNode.get("domain").asText();
			String about = profileNode.get("about").asText();
			int followersCount = profileNode.get("followers_count").getIntValue();
			int friendsCount = profileNode.get("friends_count").getIntValue();
			int sexVal = profileNode.get("sex").getIntValue();

			if (sexVal == 0) {
				sex = "Undefined";
			}
			else if (sexVal == 1) {
				sex = "Male";
			}
			else if (sexVal == 2) {
				sex = "Female";
			}
			
 
			profile = new FivepxProfile(id, userName, fullName, userPicUrl);
			profile.setSex(sex);
			profile.setAbout(about);
			profile.setDomain(domain);
			profile.setFollowersCount(followersCount);
			profile.setFriendsCount(friendsCount);
			profile.setCity(city);
			profile.setCountry(country);

			return profile;
		}

		private String getUserProfilePicValue(JsonNode node, String nodeName) {
			return "http://500px.com" + node.get(nodeName).asText();
		}
	}

}