package com.leonardoteixeira.cadastroDeUsuarios.controller;

import com.leonardoteixeira.cadastroDeUsuarios.model.User;
import com.leonardoteixeira.cadastroDeUsuarios.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository ur;

    @GetMapping("/login")
    public  String login(){
        return "index";
    }

    @GetMapping("/cadastroUsuario")
    public String cadastro(){
        return "cadastro";
    }

    @RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
    public String cadastroUsuario(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/cadastroUsuario";
        }
        ur.save(user);
        return "redirect:/login";
    }

}
