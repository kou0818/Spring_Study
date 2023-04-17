package com.jutjoy.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jutjoy.domain.profile.form.profile.ProfileCreateForm;
import com.jutjoy.domain.profile.service.profile.ProfileCreateService;

@Controller
public class ProfileController {

	@GetMapping("/profile/create")
	public String create(@ModelAttribute("form") ProfileCreateForm ProfileCreateForm) {
		return "profile/create";
	}
	
	@Autowired
	private ProfileCreateService ProfileCreateService;
	
	@PostMapping("/profile/create")
    public String create(@Validated @ModelAttribute("form") ProfileCreateForm ProfileCreateForm,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "profile/create";
        }

        ProfileCreateService.create(ProfileCreateForm);

        return "redirect:/profile/create/complete";
    }
	
    @GetMapping("/profile/create/complete")
    public String complete() {
        return "profile/complete";
    }
}
