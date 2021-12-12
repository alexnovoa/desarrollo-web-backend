package ec.mil.issffa.demo.security.controllers;

import ec.mil.issffa.demo.commons.response.Response;
import ec.mil.issffa.demo.security.JwtTokenUtil;
import ec.mil.issffa.demo.security.dtos.TokenDto;
import ec.mil.issffa.demo.security.JwtUserDetailsServiceImpl;
import ec.mil.issffa.demo.security.models.Usuario;
import ec.mil.issffa.demo.security.repositories.UsuarioRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;
    @Autowired
    private UsuarioRepo usuarioService;


    @PostMapping("/v1/login")
    public ResponseEntity<?> login(@RequestBody ec.mil.issffa.demo.security.models.dtos.LoginDto dto) {
        log.info("Autenticando usuario " + dto.toString());
        Response<TokenDto> response = new Response<TokenDto>();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getUsuario().trim(), dto.getClave().trim()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsuario().trim());
        Usuario localUser = usuarioService.findByUsuario(userDetails.getUsername());
        String token = jwtTokenUtil.obterToken(userDetails);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setIdUsuario(localUser.getId());
        tokenDto.setRol(localUser.getRol());

        response.setResult(tokenDto);
        return ResponseEntity.ok(response);
    }
}
