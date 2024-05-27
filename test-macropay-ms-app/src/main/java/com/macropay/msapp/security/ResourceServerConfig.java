package com.macropay.msapp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableMethodSecurity
/*
@DependsOn({"defaultSecurityFilterChain",
    "registeredClientRepository","authorizationServerSettings"})
@ComponentScan(basePackages = {"com.macropay.msapp.security"})
*/
public class ResourceServerConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

/*
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
                .oauth2ResourceServer(oAuth2 -> oAuth2
                        .jwt(it -> it.decoder(JwtDecoders.fromIssuerLocation(issuer))))
                .build();
    }
    */
/*
    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        //.exceptionHandling().authenticationEntryPoint(new AuthException())
        //.and()
        //.requestMatchers()
        //.and()
        .authorizeRequests()                  
        //.antMatchers("/oauth/token/**" ).permitAll()
        //.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .requestMatchers("/api/v1/alumnos/**" ).authenticated()                
        .requestMatchers("/api/v1/alumno-horarios/**" ).authenticated();
    }*/
}
