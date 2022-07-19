package com.nttdata.apirest.service;

import com.nttdata.apirest.dto.AfiliadoDTO;
import com.nttdata.apirest.util.JsonResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AfiliadoService {
    ResponseEntity<JsonResponse<List<AfiliadoDTO>>> obtenerAfiliados();

    ResponseEntity<JsonResponse<AfiliadoDTO>> obtenerAfiliadoPorId(Long afiliadoId);

    ResponseEntity<JsonResponse<AfiliadoDTO>> registrarAfiliado(AfiliadoDTO afiliadoDTO);

    ResponseEntity<JsonResponse<AfiliadoDTO>> actualizarAfiliado(Long afiliadoId, AfiliadoDTO afiliadoDTO);

    ResponseEntity<Void> eliminarAfiliado(Long afiliadoId);

}
