package com.example.MusouDB.config;

import com.example.MusouDB.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration // Define una clase como Config
@EnableWebSecurity // Define una Security Config
public class SecurityConfig {/*
    // Inyectar JwtFilter
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                // Deshabilitar la seguridad básica
                .csrf(csrf -> csrf.disable())
                // Definir reglas de acceso para poder interactuar con las APIs
                // a partir de un username y un JWT
                // Definir un punto de acceso para la autenticación (/auth)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/cursos/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/recursos/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/resenas/**").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                // Implementar JwtFilter para que se ejecute antes del
                // BasicFilter (UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // Metodo para encriptar el password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/

    /* Clase 2*/
// -------- JwtFilter
@Configuration //Define una clase como config
@EnableWebSecurity //Define una Security Config
public class SecurityConfig2 {
    //Método para permitir cualquier petición (deshabilitar SecurityFilterChaom)

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                //Deshabilitar la seguridad básica
                .cors(Customizer.withDefaults()) //
            .csrf(csrf -> csrf.disable())
                // Cualquier petición se autoriza
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .permitAll()
                )
                // COnfig basica que pudiera recibir credencial
                .httpBasic(Customizer.withDefaults());
        //Construir el nuevo http
        return http.build();

    }

    //Metodo para encriptar el password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            // Allow your frontend origin
            configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500", "http://localhost:5500"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
            configuration.setAllowCredentials(true);

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }
}
}