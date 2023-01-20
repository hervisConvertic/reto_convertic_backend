package com.convertic.springboot.backend.springbootbackend.repositorio;

import com.convertic.springboot.backend.springbootbackend.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    Usuario findByCorreoelectronicoAndContrasena(String correo_electronico, String contrasena);
}
