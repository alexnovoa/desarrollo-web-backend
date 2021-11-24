package ec.mil.issffa.demo.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.mil.issffa.demo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    Cliente findByCedula(String cedula);

    List<Cliente> findByNombre(String nombre);
     
}
