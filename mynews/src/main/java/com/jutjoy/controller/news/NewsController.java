package com.jutjoy.controller.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jutjoy.domain.news.form.news.NewsCreateForm;
import com.jutjoy.domain.news.service.news.NewsCreateService;

@Controller
public class NewsController {

	//@GetMapping("/news/create")
	//public String index() {
	//	return "news/create";
	//}

	//createメソッド追加
	@GetMapping("/news/create")
	public String create(@ModelAttribute("form") NewsCreateForm newsCreateForm) {
		return "news/create";
	}

	@Autowired
	private NewsCreateService newsCreateService;

	@PostMapping("/news/create")
	public String create(@Validated @ModelAttribute("form") NewsCreateForm newsCreateForm,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "news/create";
		}

		newsCreateService.create(newsCreateForm);

		return "redirect:/news/create/complete";
	}

	@GetMapping("/news/create/complete")
	public String complete() {
		return "news/complete";
	}
}