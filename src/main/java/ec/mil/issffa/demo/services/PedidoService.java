package ec.mil.issffa.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.models.DetallePedido;
import ec.mil.issffa.demo.models.Pedido;
import ec.mil.issffa.demo.repositories.DetallePedidoRepository;
import ec.mil.issffa.demo.repositories.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Transactional
    public Pedido guardar(Pedido pedido, List<DetallePedido> detalles) {
         Pedido pedidoAlmacenado = pedidoRepository.save(pedido); 
         
         for(DetallePedido tmp : detalles){
             tmp.setPedido(pedidoAlmacenado);
             detallePedidoRepository.save(tmp);
         }  
         return pedidoAlmacenado;
    }
}
