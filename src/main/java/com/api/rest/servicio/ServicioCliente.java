/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Cliente;
import com.api.rest.repositorio.RepositorioCliente;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioCliente")
public class ServicioCliente {

    @Resource
    private RepositorioCliente repositorioCliente;

    public List<Cliente> mostrarCliente() {
        return this.repositorioCliente.findAll();
    }

    public Cliente buscarPorId(Integer id) {
        return this.repositorioCliente.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }
}