package ec.mil.issffa.demo.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.pedido.models.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{

}
