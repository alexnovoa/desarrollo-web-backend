package ec.mil.issffa.demo.productos.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.productos.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    List<Producto> findByDescripcionContains(String descripcion);
}
