package com.apirest.gestiondeinventario_backend.empleado.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.empleado.domain.entities.Empleado;
import com.apirest.gestiondeinventario_backend.empleado.domain.repository.EmpleadoRepository;

@Service
public class EmpleadoDomainService {
    

    @Autowired
    EmpleadoRepository empleadoRepository;

    public Empleado insertarEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Empleado editarEmpleado(Empleado empleado){
        Empleado existente = empleadoRepository.findById(empleado.getIdEmpleado()).orElse(null);
        if (existente != null) {
            existente.setNombre(empleado.getNombre());
            existente.setApellidoPaterno(empleado.getApellidoPaterno());
            existente.setApellidoMaterno(empleado.getApellidoMaterno());
            existente.setFechaNacimiento(empleado.getFechaNacimiento());
            existente.setTipoDocumento(empleado.getTipoDocumento());
            existente.setNumeroDocumento(empleado.getNumeroDocumento());
            existente.setGenero(empleado.getGenero());
            existente.setEstadoCivil(empleado.getEstadoCivil());
            existente.setDireccion(empleado.getDireccion());
            existente.setDistrito(empleado.getDistrito());
            existente.setFechaModificacion(LocalDateTime.now());
            return empleadoRepository.save(existente);
        }
        return null;
    }

    public Empleado eliminarEmpleado(Integer idEmpleado){
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);
        if (empleado != null) {
            empleado.setEsDesactivado(0);
            return empleadoRepository.save(empleado);
        }
        return null;
    }

    public List<Empleado> listarEmpleados(Integer esDesactivado){
        return empleadoRepository.findByEsDesactivado(1);
    }
}
