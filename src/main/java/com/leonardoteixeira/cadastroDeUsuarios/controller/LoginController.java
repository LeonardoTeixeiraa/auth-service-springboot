package com.leonardoteixeira.cadastroDeUsuarios.controller;

import com.leonardoteixeira.cadastroDeUsuarios.model.User;
import com.leonardoteixeira.cadastroDeUsuarios.repository.UserRepository;
import com.leonardoteixeira.cadastroDeUsuarios.service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.UnsupportedEncodingException;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository ur;

    @GetMapping("/login")
    public  String login(){
        return "login";
    }

    @GetMapping("/")
    public String dashboard(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("name", CookieService.getCookie(request,"username"));
        return "index";
    }

    @PostMapping("/logar")
    public String loginUsuario(User user, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        User usuarioLogado = this.ur.login(user.getEmail(), user.getPassword());
        if (usuarioLogado != null){
            CookieService.setCookie(response, "usuarioId", String.valueOf(usuarioLogado.getId()), 10000);
            CookieService.setCookie(response, "username", String.valueOf(usuarioLogado.getName()), 10000);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário Inválido!");
        return "login";
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
