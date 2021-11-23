package ec.mil.issffa.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.mil.issffa.demo.models.Cliente;
import ec.mil.issffa.demo.services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
    
    /*@GetMapping("/v1/demo/{nombre}")
    public String prueba(@PathVariable String nombre){
        return "Hola "+nombre;
    }

    @GetMapping("/v2/demo/{nombre}/{apellido}")
    public String pruebaActualizado(@PathVariable String nombre, @PathVariable String apellido){
        return "Hola "+nombre+" "+apellido;
    }*/

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/v1/clientes")
    public ResponseEntity<?> post(@RequestBody Cliente cliente){
        Cliente clienteAlmacenado =  clienteService.guardar(cliente);
        return ResponseEntity.ok(clienteAlmacenado);
    }
}
