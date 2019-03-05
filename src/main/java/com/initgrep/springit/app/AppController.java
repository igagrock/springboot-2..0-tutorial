package com.initgrep.springit.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	  
	
		@GetMapping("/home")
		public String home(Model model) {
			model.addAttribute("title", "Hellow thymeleaf");
			return "home";
		}
		
		@GetMapping(path="/foo")
		public String getFoo(Model model) {
			model.addAttribute("pageTitle", "This is page FOO!!");
			return "foo";
		}
}
 