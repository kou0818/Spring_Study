package com.jutjoy.domain.profile.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jutjoy.domain.profile.entity.profile.Profile;
import com.jutjoy.domain.profile.form.profile.ProfileCreateForm;
import com.jutjoy.domain.profile.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileCreateService {

	@Autowired
	private ProfileRepository profileRepository;
	
	public void create(ProfileCreateForm form) {

		Profile entity = new Profile();
        entity.setName(form.getName());
        entity.setGender(form.getGender());
        entity.setHobby(form.getHobby());
        entity.setIntroduction(form.getIntroduction());
        
        profileRepository.save(entity);
    }
}
