package ec.mil.issffa.demo.proveedores.controllers;

import ec.mil.issffa.demo.clientes.models.Cliente;
import ec.mil.issffa.demo.proveedores.models.Proveedor;
import ec.mil.issffa.demo.proveedores.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public final class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/v1/proveedores")
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(proveedorService.getAll());
    }

    @PostMapping("/v1/proveedores")
    public ResponseEntity<?> post(@RequestBody Proveedor proveedor){
        Proveedor proveedorAlmcenado =  proveedorService.guardar(proveedor);
        return ResponseEntity.ok(proveedorAlmcenado);
    }

    @PutMapping("/v1/proveedores/{idProveedor}")
    public ResponseEntity<?> put(@PathVariable long idProveedor, @RequestBody Proveedor proveedorActualizado){
        Proveedor clienteAlmacenado =  proveedorService.actualizar(idProveedor, proveedorActualizado);
        return ResponseEntity.ok(clienteAlmacenado);
    }

    @DeleteMapping("/v1/proveedores/{idProveedor}")
    public ResponseEntity<?> delete(@PathVariable long idProveedor){
        Optional<Proveedor> clienteOptional =  proveedorService.getById(idProveedor);
        if(clienteOptional.isPresent()){
            proveedorService.eliminar(clienteOptional.get());
            return ResponseEntity.ok("Registro eliminado");
        }else{
            return ResponseEntity.badRequest().body("No existe cliuente");
        }
    }
}
