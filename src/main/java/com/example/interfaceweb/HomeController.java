package com.example.interfaceweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/contador")
    public String calcularContador(@RequestParam int n, @RequestParam List<String> numeros, Model model) {
        int count = 0;

        // Conta quantos números são inteiros
        for (String numero : numeros) {
            try {
                double num = Double.parseDouble(numero);
                if (num % 1 == 0) { // Verifica se é um inteiro
                    count++;
                }
            } catch (NumberFormatException e) {
                // Ignora entradas inválidas
            }
        }

        model.addAttribute("count", count);
        return "contador"; // Retorna à mesma página para mostrar o resultado
    }

    @GetMapping("/fibonacci")
    public String fibonacci() {
        return "fibonacci"; // Nome do arquivo HTML para o algoritmo Fibonacci
    }

    @PostMapping("/fibonacci")
    public String calcularFibonacci(@RequestParam int n, Model model) {
        StringBuilder sequencia = new StringBuilder();

        int termo1 = 0;
        int termo2 = 1;
        int termo3;

        if (n >= 1) sequencia.append(termo1);
        if (n >= 2) sequencia.append(", ").append(termo2);

        for (int i = 3; i <= n; i++) {
            termo3 = termo1 + termo2;
            sequencia.append(", ").append(termo3);
            termo1 = termo2;
            termo2 = termo3;
        }

        model.addAttribute("sequencia", sequencia.toString());
        return "fibonacci"; // Retorna à mesma página para mostrar a sequência
    }

    @GetMapping("/mdc")
    public String mdc() {
        return "mdc"; // Nome do arquivo HTML para o MDC
    }

    @PostMapping("/mdc")
    public String calcularMDC(@RequestParam int numero1, @RequestParam int numero2, Model model) {
        int mdc = calcularMDCInterno(numero1, numero2);
        model.addAttribute("mdc", mdc);
        model.addAttribute("numero1", numero1);
        model.addAttribute("numero2", numero2);
        return "mdc"; // Retorna à mesma página para mostrar o resultado
    }

    private int calcularMDCInterno(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @GetMapping("/primo")
    public String primo() {
        return "primo"; // Nome do arquivo HTML para Verificação de Número Primo
    }

    @PostMapping("/primo")
    public String verificarPrimo(@RequestParam int numero, Model model) {
        boolean isPrimo = true;

        if (numero < 2) {
            isPrimo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    isPrimo = false;
                    break;
                }
            }
        }

        model.addAttribute("numero", numero);
        model.addAttribute("isPrimo", isPrimo);
        return "primo"; // Retorna à mesma página para mostrar o resultado
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
