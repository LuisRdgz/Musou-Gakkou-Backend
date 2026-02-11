package com.example.MusouDB.service;

import com.example.MusouDB.exceptions.UsuarioNotFoundException;
import com.example.MusouDB.model.Usuario;
import com.example.MusouDB.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    // Inyectar la dependencia
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    // Metodo para recuperar a todos los usuarios
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    // Metodo para crear nuevas instancias
    public Usuario crearUsuario(Usuario nuevoUsuario){
        return usuarioRepository.save(nuevoUsuario);
    }


    //findByNombre
    public Usuario findByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    /*
    //findByApellido
    public Usuario findByApellido(String apellido_usuario){
        return usuarioRepository.findByApellido(apellido_usuario);
    }
*/

    // findByEmail
    public Usuario findByCorreoUsuario(String correoUsuario){
        return usuarioRepository.findByCorreoUsuario(correoUsuario);
    }

    //findById
    public Usuario findById(Long idUsuario){
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException(idUsuario));
    }

    //delete Usuario por Id
    public void deleteUsuario(Long idUsuario){
        if(usuarioRepository.existsById(idUsuario)){
            usuarioRepository.deleteById(idUsuario);
        }else{
            throw new UsuarioNotFoundException(idUsuario);
        }
    }

    //updateUser by Id
    public Usuario updateUsuario(Usuario usuario, Long idUsuario){
        return usuarioRepository.findById(idUsuario)
                .map(usuarioData -> {
                    usuarioData.setNombreUsuario(usuario.getNombreUsuario());
                    usuarioData.setApellidoUsuario(usuario.getApellidoUsuario());
                    usuarioData.setCorreoUsuario(usuario.getCorreoUsuario());
                    usuarioData.setContrasenaUsuario(usuario.getContrasenaUsuario());
                    usuarioData.setTelefonoUsuario(usuario.getTelefonoUsuario());
                    return usuarioRepository.save(usuarioData);
                })
                .orElseThrow(()->new UsuarioNotFoundException(idUsuario));
    }
}
