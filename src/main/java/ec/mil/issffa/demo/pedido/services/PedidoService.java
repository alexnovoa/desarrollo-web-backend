package ec.mil.issffa.demo.pedido.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.pedido.dtos.DetallePedidoDto;
import ec.mil.issffa.demo.pedido.dtos.PedidoDto;
import ec.mil.issffa.demo.clientes.models.Cliente;
import ec.mil.issffa.demo.pedido.models.DetallePedido;
import ec.mil.issffa.demo.pedido.models.Pedido;
import ec.mil.issffa.demo.productos.models.Producto;
import ec.mil.issffa.demo.pedido.repositories.DetallePedidoRepository;
import ec.mil.issffa.demo.pedido.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public Page<Pedido> getAllPageable(boolean facturado, Pageable pageable){
        return pedidoRepository.findByFacturado(facturado, pageable);
    }

    @Transactional
    public Pedido guardar(Pedido pedido, List<DetallePedido> detalles) {
         Pedido pedidoAlmacenado = pedidoRepository.save(pedido);

         for(DetallePedido tmp : detalles){
             tmp.setPedido(pedidoAlmacenado);
             detallePedidoRepository.save(tmp);
         }
         return pedidoAlmacenado;
    }

    @Transactional
    public Pedido guardarDto(PedidoDto pedidoDto) {

        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());
        pedido.setSubtotal(pedidoDto.getSubtotal());
        Cliente cliente = new Cliente();
        cliente.setId(pedidoDto.getCliente());
        pedido.setCliente(cliente);
        pedido.setFacturado(false);

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
        return guardar(pedido, detallesEntidades);
    }
}
