package ec.mil.issffa.demo.clientes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mil.issffa.demo.clientes.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Cliente findByCedula(String cedula);

    List<Cliente> findByNombre(String nombre);

}
