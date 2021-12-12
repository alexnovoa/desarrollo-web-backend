package ec.mil.issffa.demo.security.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {
    private String token;
    private long idUsuario;
    private String nombre;
    private String rol;
}
