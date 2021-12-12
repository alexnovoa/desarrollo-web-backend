package ec.mil.issffa.demo.security.repositories;

import ec.mil.issffa.demo.security.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

    Usuario findById(long id);



}
