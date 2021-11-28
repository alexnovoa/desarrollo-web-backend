package ec.mil.issffa.demo.proveedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.proveedores.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

}
