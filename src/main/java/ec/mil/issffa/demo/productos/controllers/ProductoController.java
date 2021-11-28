package ec.mil.issffa.demo.productos.controllers;

import ec.mil.issffa.demo.clientes.models.Cliente;
import ec.mil.issffa.demo.productos.dtos.ProductoDto;
import ec.mil.issffa.demo.productos.models.Producto;
import ec.mil.issffa.demo.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public final class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/v1/productos")
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(productoService.getAll());
    }

    @PostMapping("/v1/productos")
    public ResponseEntity<?> post(@RequestBody Producto producto){
        Producto productoAlmacenado =  productoService.guardar(producto);
        return ResponseEntity.ok(productoAlmacenado);
    }

    @PutMapping("/v1/productos/{idProducto}")
    public ResponseEntity<?> put(@PathVariable long idProducto, @RequestBody ProductoDto productoActualizado){
        Producto productoAlmacenado =  productoService.actualizar(idProducto, productoActualizado);
        return ResponseEntity.ok(productoAlmacenado);
    }

    @DeleteMapping("/v1/productos/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable long idProducto){
        Optional<Producto> productoOptional =  productoService.getById(idProducto);
        if(productoOptional.isPresent()){
            productoService.eliminar(productoOptional.get());
            return ResponseEntity.ok("Registro eliminado");
        }else{
            return ResponseEntity.badRequest().body("No existe cliuente");
        }
    }
}
