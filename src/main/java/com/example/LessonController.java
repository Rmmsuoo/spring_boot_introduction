package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/sample")
//	@ResponseBody
	public String sample(Model model) {
		String text ="Hello Spring Boot!!";
		model.addAttribute("message",text);
		return "index";
	}
	// http://localhost:8080/lesson/ にリクエストするとindex()が実行される
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    // http://localhost:8080/lesson/test にリクエストするとtest()が実行される
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Good Evening!";
    }
}

