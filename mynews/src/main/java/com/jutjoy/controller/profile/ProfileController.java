package com.jutjoy.controller.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jutjoy.domain.entity.profile.Profile;
import com.jutjoy.domain.form.profile.ProfileCreateForm;
import com.jutjoy.domain.form.profile.ProfileEditForm;
import com.jutjoy.domain.service.profile.ProfileCreateService;
import com.jutjoy.domain.service.profile.ProfileDeleteService;
import com.jutjoy.domain.service.profile.ProfileEditService;
import com.jutjoy.domain.service.profile.ProfileListService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileCreateService ProfileCreateService;

	// 2-4課題
	@Autowired
	private ProfileListService profileListService;
	
	// 2-5課題
	@Autowired
	private ProfileEditService profileEditService;
	
	// 2-5課題
	@Autowired
	private ProfileDeleteService profiledeleteService;

	@GetMapping("/profile/create")
	public String create(@ModelAttribute("form") ProfileCreateForm ProfileCreateForm) {
		return "profile/create";
	}

	@PostMapping("/profile/create")
	public String create(@Validated @ModelAttribute("form") ProfileCreateForm ProfileCreateForm,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "profile/create";
		}

		ProfileCreateService.create(ProfileCreateForm);

		return "redirect:/profile/create/complete";
	}

	// 2-5課題で編集
	@GetMapping("/profile/{action}/complete")
	public String complete(@PathVariable(name = "action") String action, Model model) {
		return "profile/complete";
	}

	// 2-4課題
	@GetMapping("/profile/list")
	public String list(@RequestParam(name = "name", required = false) String name, Model model) {

		List<Profile> profileList = profileListService.list(name);
		model.addAttribute("profileList", profileList);
		model.addAttribute("name", name);

		return "profile/list";
	}
	
	// 2-5課題
	@GetMapping("/profile/edit/{id}")
	public String edit(@ModelAttribute("form") ProfileEditForm profileEditForm,
			@PathVariable(name = "id") int id, Model model) {
		
		Profile profile = profileEditService.findProfile(id);
		model.addAttribute("profile", profile);
		
		return "profile/edit";
	}
	
	@PostMapping("/profile/edit/{id}")
	public String edit(@PathVariable(name = "id") int id,
			@Validated @ModelAttribute("form") ProfileEditForm profileEditForm, BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			return edit(profileEditForm, id, model);
		}
		profileEditService.edit(id, profileEditForm);
		
		return "redirect:/profile/edit/complete";
	}
	
	// 2-5課題
	@PostMapping("/profile/delete")
	public String delte(@RequestParam(name = "id", required = true) int id, Model model) {
		profiledeleteService.delete(id);
		return "redirect:/profile/list";
	}
}
