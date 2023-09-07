package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
    @GetMapping("/list")
    public String list(Model model) {
        return "item/list"; // templates¥item¥list.html を指している
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "item/create"; // templates¥item¥create.html を指している
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        return "item/edit"; // templates¥item¥edit.html を指している
    }
}
