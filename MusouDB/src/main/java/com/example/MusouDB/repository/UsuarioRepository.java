package com.example.MusouDB.repository;

import com.example.MusouDB.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // JPQL --- username, email
    //@Query("SELECT u FROM u WHERE u.username =? 1")
    Usuario findByNombreUsuario(String nombreUsuario);
    //Usuario findByEmail(String correo_usuario);
    Usuario findByCorreoUsuario(String correoUsuario);

}
