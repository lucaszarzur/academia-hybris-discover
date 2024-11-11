package br.com.discover.academia.hybris.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo! Esta é a página pública.";
    }

    @GetMapping("/user")
    public String user() {
        return "Bem-vindo, usuário!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Bem-vindo, administrador!";
    }
}
