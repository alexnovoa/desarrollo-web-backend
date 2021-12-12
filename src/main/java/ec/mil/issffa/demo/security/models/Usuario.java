package ec.mil.issffa.demo.security.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String clave;
    private String rol;
    private String usuario;




}
