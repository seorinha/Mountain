package com.project.kakao;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Generated("jsonschema2pojo")
public class KakaoProfile {

	public Long id;
	public String connected_at;
	public Properties properties;
	public KakaoAccount kakao_account;

	@Data
	class Properties {

		public String nickname;
		public String profile_image;
		public String thumbnail_image;

	}

	@Data
	class KakaoAccount {

		public Boolean profile_nickname_needs_agreement;
		public Boolean profile_image_needs_agreement;
		public Profile profile;

		@Data
		class Profile {

			public String nickname;
			public String thumbnail_image_url;
			public String profile_image_url;
			public Boolean is_default_image;

		}
	}
}
