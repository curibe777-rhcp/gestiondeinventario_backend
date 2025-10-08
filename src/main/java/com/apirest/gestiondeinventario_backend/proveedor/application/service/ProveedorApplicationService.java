package com.apirest.gestiondeinventario_backend.proveedor.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.EditarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.EliminarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.request.InsertarProveedorRequestDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.EditarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.EliminarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.InsertarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.dto.response.ListarProveedorResponseDto;
import com.apirest.gestiondeinventario_backend.proveedor.application.mapper.EditarProveedorMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.mapper.EliminarProveedorMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.mapper.InsertarProveedorMapper;
import com.apirest.gestiondeinventario_backend.proveedor.application.mapper.ListarProveedorMapper;
import com.apirest.gestiondeinventario_backend.proveedor.domain.entities.Proveedor;
import com.apirest.gestiondeinventario_backend.proveedor.domain.service.*;;;

@Service
public class ProveedorApplicationService {

    @Autowired
    private ProveedorDomainService proveedorDomainService;

    @Autowired
    private InsertarProveedorMapper insertarProveedorMapper;

    @Autowired
    private EditarProveedorMapper editarProveedorMapper;

    @Autowired
    private EliminarProveedorMapper eliminarProveedorMapper;

    @Autowired
    private ListarProveedorMapper listarProveedorMapper;

    public InsertarProveedorResponseDto insertarProveedor(InsertarProveedorRequestDto requestDto) {
        Proveedor proveedor = proveedorDomainService.insertarProveedor(insertarProveedorMapper.requestToEntity(requestDto));
        return insertarProveedorMapper.entityToResponse(proveedor);
    }

    public EditarProveedorResponseDto editarProveedor(EditarProveedorRequestDto requestDto) {
        Proveedor proveedor = editarProveedorMapper.requestToEntity(requestDto);
        Proveedor proveedorEditado = proveedorDomainService.editarProveedor(proveedor);
        return editarProveedorMapper.entityToResponse(proveedorEditado);
    }

    public EliminarProveedorResponseDto eliminarProveedor(EliminarProveedorRequestDto requestDto) {
        Proveedor proveedor = eliminarProveedorMapper.requestToEntity(requestDto);
        Proveedor eliminado = proveedorDomainService.eliminarProveedor(proveedor.getIdProveedor());
        return eliminarProveedorMapper.entityToResponse(eliminado);
    }

    public List<ListarProveedorResponseDto> listarProveedores() {
        return proveedorDomainService.listarProveedores(1).stream().map(listarProveedorMapper::entityToResponse).toList();
    }
}
