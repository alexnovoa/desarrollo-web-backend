package ec.mil.issffa.demo.security;


import ec.mil.issffa.demo.security.models.Usuario;
import ec.mil.issffa.demo.security.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepo userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario user = userService.findByUsuario(usuario);
        if (user != null) {
            return JwtUserFactory.createUser(user);
        }
        throw new UsernameNotFoundException("Usuario no encontrado");
    }

}
