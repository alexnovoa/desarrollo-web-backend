package ec.mil.issffa.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.mil.issffa.demo.dtos.DetallePedidoDto;
import ec.mil.issffa.demo.dtos.PedidoDto;
import ec.mil.issffa.demo.models.Cliente;
import ec.mil.issffa.demo.models.DetallePedido;
import ec.mil.issffa.demo.models.Pedido;
import ec.mil.issffa.demo.models.Producto;
import ec.mil.issffa.demo.services.PedidoService;
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
        
        /*Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());
        pedido.setSubtotal(pedidoDto.getSubtotal());
        Cliente cliente = new Cliente();
        cliente.setId(pedidoDto.getCliente());
        pedido.setCliente(cliente);

        List<DetallePedido> detallesEntidades = new ArrayList<>();
        for(DetallePedidoDto tmp : pedidoDto.getDetalles()){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPrecio(tmp.getPrecio());
            detallePedido.setCantidad(tmp.getCantidad());
            Producto producto = new Producto();
            producto.setId(tmp.getProducto());
            detallePedido.setProducto(producto);
            detallesEntidades.add(detallePedido);
        }

        Pedido pedidoAlmacenado = pedidoService.guardar(pedido, detallesEntidades);*/

        Pedido pedidoAlmacenado = pedidoService.guardarDto(pedidoDto);
        return ResponseEntity.ok(pedidoAlmacenado);
    }


}
