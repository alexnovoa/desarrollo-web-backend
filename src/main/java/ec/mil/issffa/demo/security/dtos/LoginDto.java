package ec.mil.issffa.demo.security.models.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {

    private String usuario;
    private String clave;
}
