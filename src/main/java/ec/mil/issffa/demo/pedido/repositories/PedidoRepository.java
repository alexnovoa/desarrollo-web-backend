package ec.mil.issffa.demo.pedido.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.pedido.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    Page<Pedido> findByFacturado(boolean facturado, Pageable pageable);
}
