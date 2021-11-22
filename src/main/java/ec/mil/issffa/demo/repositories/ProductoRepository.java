package ec.mil.issffa.demo.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
    List<Producto> findByDescripcionContains(String descripcion);
}
