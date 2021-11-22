package ec.mil.issffa.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.models.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{
    
}
