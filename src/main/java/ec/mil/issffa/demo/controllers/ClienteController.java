package ec.mil.issffa.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @GetMapping("/demo")
    public String prueba(){
        return "Hola";
    }
}
