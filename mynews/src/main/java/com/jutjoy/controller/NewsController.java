package com.jutjoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
	
	@GetMapping("/news/create")
    public String index() {
        return "news/create";
    }

}
