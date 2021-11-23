package ec.mil.issffa.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
