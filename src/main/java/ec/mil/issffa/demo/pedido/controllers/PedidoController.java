package ec.mil.issffa.demo.pedido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.mil.issffa.demo.pedido.dtos.PedidoDto;
import ec.mil.issffa.demo.pedido.models.Pedido;
import ec.mil.issffa.demo.pedido.services.PedidoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/v1/pedidos")
    public ResponseEntity<?> post(@RequestBody PedidoDto pedidoDto){
        log.info("Almacenando pedido "+pedidoDto);
        Pedido pedidoAlmacenado = pedidoService.guardarDto(pedidoDto);
        return ResponseEntity.ok(pedidoAlmacenado);
    }

    @GetMapping("/v1/pedidos/{pagina}/pagina")
    public ResponseEntity<?> getPageable(@PathVariable int pagina){
        Pageable pageable = PageRequest.of(pagina - 1, 10);
        Page<Pedido> pedidos = pedidoService.getAllPageable(false,pageable);
        if (!pedidos.getContent().isEmpty()){
            return ResponseEntity.ok(pedidos.getContent());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
