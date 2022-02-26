package com.thesis.vaccines.controller;

import com.thesis.vaccines.model.*;
import com.thesis.vaccines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/registration")
    public String addNewUser(User user,
                             Map<String,Object> model){
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(!isValidEmail(user.getEmail())){
            model.put("message","Podaj adres email.");
            return "registration";
        }
        if(userFromDB != null){
            model.put("message","Użytkownik już został zarejestrowany. Proszę się zalogować.");
            return "registration";
        }

        User userByEmail = userRepository.findByEmail(user.getEmail());
        if(userByEmail != null){
            model.put("message","Użytkownik z takim adresem email już został zarejestrowany. Proszę się zalogować.");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}
