package com.convertic.springboot.backend.springbootbackend.servicio;

import com.convertic.springboot.backend.springbootbackend.modelo.Usuario;
import com.convertic.springboot.backend.springbootbackend.repositorio.IUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements CrudServicio<Usuario>{

    private IUsuarioRepositorio iUsuarioRepositorio;

    public UsuarioServicio(IUsuarioRepositorio iUsuarioRepositorio) {
        this.iUsuarioRepositorio = iUsuarioRepositorio;
    }

    @Override
    @Transactional
    public List<Usuario> findAll() throws Exception {
        try {
            List<Usuario> usuarios=iUsuarioRepositorio.findAll();
            return usuarios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario findById(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioOptional=iUsuarioRepositorio.findById(id);
            return usuarioOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) throws Exception {
        try {
            usuario=iUsuarioRepositorio.save(usuario);
            return usuario;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario update(Integer id, Usuario usuario) throws Exception {
        return null;
    }
}
