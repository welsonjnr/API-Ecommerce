
package com.eCommerce.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Teste {
 
    @GetMapping(value="/teste")
    @ResponseBody
    public String RetornarTeste(){
        String a = "Retornando algo";
        return a;
    }
}
