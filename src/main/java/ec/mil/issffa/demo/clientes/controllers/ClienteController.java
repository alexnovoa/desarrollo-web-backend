package ec.mil.issffa.demo.clientes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.mil.issffa.demo.clientes.models.Cliente;
import ec.mil.issffa.demo.clientes.services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/v1/clientes")
    @CrossOrigin
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(clienteService.getAll());
    }

    @PostMapping("/v1/clientes")
    @CrossOrigin
    public ResponseEntity<?> post(@RequestBody Cliente cliente){
        Cliente clienteAlmacenado =  clienteService.guardar(cliente);
        return ResponseEntity.ok(clienteAlmacenado);
    }

    @PutMapping("/v1/clientes/{idCliente}")
    @CrossOrigin
    public ResponseEntity<?> put(@PathVariable long idCliente, @RequestBody Cliente clienteActualizado){
        Cliente clienteAlmacenado =  clienteService.actualizar(idCliente, clienteActualizado);
        return ResponseEntity.ok(clienteAlmacenado);
    }

    @DeleteMapping("/v1/clientes/{idCliente}")
    @CrossOrigin
    public ResponseEntity<?> delete(@PathVariable long idCliente){
       Optional<Cliente> clienteOptional =  clienteService.getById(idCliente);
       if(clienteOptional.isPresent()){
            clienteService.eliminar(clienteOptional.get());
            return ResponseEntity.ok("Registro eliminado");
       }else{
           return ResponseEntity.badRequest().body("No existe cliuente");
       }
    }
}
