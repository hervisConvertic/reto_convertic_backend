package com.convertic.springboot.backend.springbootbackend.servicio;

import java.util.List;

public interface CrudServicio <T>{
    public List<T> findAll() throws Exception;
    public T findById(Integer id) throws Exception;
    public T save(T t) throws Exception;
    public T update(Integer id,T t) throws Exception;
}
