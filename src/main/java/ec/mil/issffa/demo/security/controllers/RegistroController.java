package ec.mil.issffa.demo.security.controllers;

import ec.mil.issffa.demo.commons.response.Response;
import ec.mil.issffa.demo.security.models.Usuario;
import ec.mil.issffa.demo.security.repositories.UsuarioRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistroController {

    private static final Logger log = LoggerFactory.getLogger(RegistroController.class);

    @Autowired
    private UsuarioRepo usuarioRepository;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/v1/registro")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario){
        Response<Usuario> response = new Response<>();
        log.info("Registrando nueva cuenta "+usuario.toString());
        Usuario usuarioExistente = usuarioRepository.findByUsuario(usuario.getUsuario());
        if(usuarioExistente!=null){
            response.getErrors().add("Ya existe una cuenta con el usuario "+usuario.getUsuario());
            return ResponseEntity.badRequest().body(response);
        }
        usuario.setClave(encoder.encode(usuario.getClave()));
        usuario.setRol("ROLE_ADMIN");
        usuarioRepository.save(usuario);
        response.setResult(usuario);
        return ResponseEntity.ok(response);
    }
}
