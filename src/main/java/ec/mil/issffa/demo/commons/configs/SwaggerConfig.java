package ec.mil.issffa.demo.commons.configs;

import ec.mil.issffa.demo.security.JwtTokenUtil;
import ec.mil.issffa.demo.security.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.security.core.userdetails.UserDetails;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("ec.mil.issffa.demo"))
        .paths(PathSelectors.any()).build();
    }

    @Bean
    public SecurityConfiguration security() {
        String token;
        try {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername("alex");
            token = this.jwtTokenUtil.obterToken(userDetails);

        } catch (Exception e) {
            token = "";
        }
        System.out.println("Token to access swagger: " + token);
        return new SecurityConfiguration(null, null, null, null, "Bearer " + token, ApiKeyVehicle.HEADER,
                "Authorization", ",");
    }
}
