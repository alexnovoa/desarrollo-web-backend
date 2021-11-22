package ec.mil.issffa.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}
