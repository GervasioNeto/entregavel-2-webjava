package com.example.interfaceweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Nome do arquivo HTML na pasta "templates"
    }

    @GetMapping("/contador")
    public String contador() {
        return "contador"; // Nome do arquivo HTML para o algoritmo Contador
    }

    @GetMapping("/fibonacci")
    public String fibonacci() {
        return "fibonacci"; // Nome do arquivo HTML para o algoritmo Fibonacci
    }

    @GetMapping("/mdc")
    public String mdc() {
        return "mdc"; // Nome do arquivo HTML para o MDC
    }

    @GetMapping("/primo")
    public String primo() {
        return "primo"; // Nome do arquivo HTML para Verificação de Número Primo
    }

    @GetMapping("/quicksort")
    public String quicksort() {
        return "quicksort"; // Nome do arquivo HTML para o Quicksort
    }

    @GetMapping("/soma")
    public String soma() {
        return "soma"; // Nome do arquivo HTML para Soma de Números
    }
}