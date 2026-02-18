package com.example.MusouDB.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {
    // Inyección de JwtUtil
    private final JwtUtil jwtUtil;

    @Autowired
    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Sobreescribir el metodo doFilterInternal
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        // 1. Obtener el Header "Authorization" de la solicitud
        String authHeader = request.getHeader("Authorization");
        // 2. Evaluar si el Header existe y tiene el formato necesario (Bearer <JWT>)
        if (authHeader != null && authHeader.startsWith("Bearer ")){
            // 3. Extrar el token
            String token = authHeader.substring(7);
            // 4. Verificar el token, extraer el subject (username), y crear un
            // objeto de Authentication sin credenciales ni rol específico de Auth
            if(jwtUtil.isValidToken(token)){
                String username = jwtUtil.extractUsername(token);

                // 5. Objeto de Authentication sin credenciales
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                Collections.emptyList()
                        );
                // 6. Asociar el objeto de Authentication al parámetro `request`
                // del metodo doFilterInternal
                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                // 7. Asignar la fuente de Authentication en el SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        // 8. Agregar como FilterChain
        filterChain.doFilter(request, response);
    }

}
