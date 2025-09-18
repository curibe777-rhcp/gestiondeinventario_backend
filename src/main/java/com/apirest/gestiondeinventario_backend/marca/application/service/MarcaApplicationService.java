package com.apirest.gestiondeinventario_backend.marca.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EditarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.EliminarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.request.InsertarMarcaRequestDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EditarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.EliminarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.InsertarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.dto.response.ListarMarcaResponseDto;
import com.apirest.gestiondeinventario_backend.marca.application.mapper.EditarMarcaMapper;
import com.apirest.gestiondeinventario_backend.marca.application.mapper.EliminarMarcaMapper;
import com.apirest.gestiondeinventario_backend.marca.application.mapper.InsertarMarcaMapper;
import com.apirest.gestiondeinventario_backend.marca.application.mapper.ListarMarcaMapper;
import com.apirest.gestiondeinventario_backend.marca.domain.entities.Marca;
import com.apirest.gestiondeinventario_backend.marca.domain.services.MarcaDomainService;

@Service
public class MarcaApplicationService {
    
    @Autowired
    private MarcaDomainService marcaDomainService;

    @Autowired
    private InsertarMarcaMapper insertarMarcaMapper;

    @Autowired
    private EditarMarcaMapper editarMarcaMapper;

    @Autowired
    private EliminarMarcaMapper eliminarMarcaMapper;

    @Autowired
    private ListarMarcaMapper listarMarcaMapper;

    public InsertarMarcaResponseDto insertarMarca(InsertarMarcaRequestDto requestDto){
        Marca marca = marcaDomainService.insertarMarca(insertarMarcaMapper.requestToEntity(requestDto));
        return insertarMarcaMapper.entityToResponse(marca);
    }

    public EditarMarcaResponseDto editarMarca(EditarMarcaRequestDto requestDto){
        Marca marca = marcaDomainService.editarMarca(requestDto.getIdMarca(), requestDto.getNombre());
        return editarMarcaMapper.entityToResponse(marca);
    }

    public EliminarMarcaResponseDto eliminarMarca(EliminarMarcaRequestDto requestDto){
        Marca marca = eliminarMarcaMapper.requestToEntity(requestDto);
        Marca eliminada = marcaDomainService.eliminarMarca(marca.getIdMarca());
        return eliminarMarcaMapper.entityToResponse(eliminada);
    }

    public List<ListarMarcaResponseDto> listarMarcas(){
        return marcaDomainService.listarMarcas(1).stream()
                .map(listarMarcaMapper::entityToResponse)
                .toList();
    }
}
