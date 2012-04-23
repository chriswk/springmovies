package com.chriswk.movies.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    public String welcome() {
        return "welcome";
    }
}
