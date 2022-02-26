package com.thesis.vaccines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String redirectMainPage(){
        return "redirect:/home-en";
    }

    @RequestMapping(value = "/home-en", method = RequestMethod.GET)
    public String openMainPageEN(){
        return "home";
    }

    @RequestMapping(value = "/home-pl", method = RequestMethod.GET)
    public String openMainPagePL(){
        return "oaplikacji";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectLoginPage(){
        return "redirect:/login-en";
    }

    @RequestMapping(value = "/login-en", method = RequestMethod.GET)
    public String openLoginPageEN(){
        return "login";
    }

    @RequestMapping(value = "/login-pl", method = RequestMethod.GET)
    public String openLoginPagePL(){
        return "logowanie";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String redirectRegistrationPage(){
        return "redirect:/registration-en";
    }

    @RequestMapping(value = "/registration-en", method = RequestMethod.GET)
    public String openRegistrationPageEN(){
        return "registration";
    }

    @RequestMapping(value = "/registration-pl", method = RequestMethod.GET)
    public String openRegistrationPagePL(){
        return "rejestracja";
    }

    @RequestMapping(value = "/adddata", method = RequestMethod.GET)
    public String redirectAddDataPage(){
        return "redirect:/adddata-en";
    }

    @RequestMapping(value = "/adddata-en", method = RequestMethod.GET)
    public String openAddDataPageEN(){
        return "adddata";
    }

    @RequestMapping(value = "/adddata-pl", method = RequestMethod.GET)
    public String openAddDataPagePL(){
        return "dodaniedanych";
    }

}
