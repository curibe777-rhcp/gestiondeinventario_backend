package com.apirest.gestiondeinventario_backend.empleado.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.EditarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.EliminarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.request.InsertarEmpleadoRequestDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.EditarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.EliminarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.InsertarEmpleadoResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.dto.response.ListarEmpleadosResponseDto;
import com.apirest.gestiondeinventario_backend.empleado.application.mapper.EditarEmpleadoMapper;
import com.apirest.gestiondeinventario_backend.empleado.application.mapper.EliminarEmpleadoMapper;
import com.apirest.gestiondeinventario_backend.empleado.application.mapper.InsertarEmpleadoMapper;
import com.apirest.gestiondeinventario_backend.empleado.application.mapper.ListarEmpleadosMapper;
import com.apirest.gestiondeinventario_backend.empleado.domain.entities.Empleado;
import com.apirest.gestiondeinventario_backend.empleado.domain.service.EmpleadoDomainService;

@Service
public class EmpleadoApplicationService {
    

    @Autowired
    EmpleadoDomainService empleadoDomainService;

    @Autowired
    InsertarEmpleadoMapper insertarEmpleadoMapper;

    @Autowired
    EditarEmpleadoMapper editarEmpleadoMapper;

    @Autowired
    EliminarEmpleadoMapper eliminarEmpleadoMapper;

    @Autowired
    ListarEmpleadosMapper listarEmpleadosMapper;

    public InsertarEmpleadoResponseDto insertarEmpleado(InsertarEmpleadoRequestDto requestDto){
        Empleado empleado = empleadoDomainService.insertarEmpleado(insertarEmpleadoMapper.requestToEntity(requestDto));
        return insertarEmpleadoMapper.entityToResponse(empleado);
    }

    public EditarEmpleadoResponseDto editarEmpleado(EditarEmpleadoRequestDto requestDto){
        Empleado empleado = editarEmpleadoMapper.requestToEntity(requestDto);
        Empleado empleadoEditado = empleadoDomainService.editarEmpleado(empleado);
        return editarEmpleadoMapper.entityToResponse(empleadoEditado);
    }

    public EliminarEmpleadoResponseDto eliminarEmpleado(EliminarEmpleadoRequestDto requestDto){
        Empleado empleado = eliminarEmpleadoMapper.requestToEntity(requestDto);
        Empleado eliminado = empleadoDomainService.eliminarEmpleado(empleado.getIdEmpleado());
        return eliminarEmpleadoMapper.entityToResponse(eliminado);
    }

    public List<ListarEmpleadosResponseDto> listarEmpleados(){
        return empleadoDomainService.listarEmpleados(1).stream().map(listarEmpleadosMapper::entityToResponse).toList();
    }
}
