package ec.mil.issffa.demo.security;


import ec.mil.issffa.demo.security.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser createUser(Usuario user) {
        return new JwtUser(user.getId(), user.getUsuario(), user.getClave(),
                mapToGrantedAuthorities(user.getRol()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String rol) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(rol));
        return authorities;
    }

}
