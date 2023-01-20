package com.convertic.springboot.backend.springbootbackend.controlador;

import com.convertic.springboot.backend.springbootbackend.modelo.Usuario;
import com.convertic.springboot.backend.springbootbackend.servicio.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioControlador {

    private UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/usuario")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            Usuario objetoUsuario = usuarioServicio.login(usuario.getCorreo_electronico(), usuario.getContrasena());
            System.out.println(objetoUsuario.toString());
            if (Objects.nonNull(objetoUsuario)) {
                System.out.println("usuario existe");
                //return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.login(usuario.getCorreo_electronico(),usuario.getContrasena()));
                return ResponseEntity.status(HttpStatus.OK).body("{\"status\":\"success\"}");
            } else  {
                System.out.println("usuario no existe");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\":\"unsuccess\"}");
            }



            //return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.login(usuario.getCorreo_electronico(),usuario.getContrasena()));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\":\"excepcion\"}");
        }
    }

    @GetMapping("/usuarios")
    public List<Usuario> index() throws Exception {
        return usuarioServicio.findAll();
    }

}
