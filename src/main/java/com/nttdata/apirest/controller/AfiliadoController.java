package com.nttdata.apirest.controller;

import com.nttdata.apirest.dto.AfiliadoDTO;
import com.nttdata.apirest.service.AfiliadoService;
import com.nttdata.apirest.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping
    public ResponseEntity<JsonResponse<List<AfiliadoDTO>>> obtenerAfiliados() {
        return afiliadoService.obtenerAfiliados();
    }

    @GetMapping(params = {"identificacion"})
    public ResponseEntity<JsonResponse<AfiliadoDTO>> obtenerAfiliadoPorNumeroIdentificacion(
            @RequestParam(name = "identificacion") String numeroIdentificacion) {
        return afiliadoService.obtenerAfiliadoPorNumeroIdentificacion(numeroIdentificacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse<AfiliadoDTO>> obtenerPorId(@PathVariable("id") Long idAfiliado) {
        return afiliadoService.obtenerAfiliadoPorId(idAfiliado);
    }

    @PostMapping
    public ResponseEntity<JsonResponse<AfiliadoDTO>> registrar(@RequestBody @Valid AfiliadoDTO afiliadoDTO) {
        return afiliadoService.registrarAfiliado(afiliadoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JsonResponse<AfiliadoDTO>> actualizar(
            @PathVariable("id") Long idAfiliado,
            @RequestBody @Valid AfiliadoDTO afiliadoDTO
    ) {
        return afiliadoService.actualizarAfiliado(idAfiliado, afiliadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAfiliado(@PathVariable("id") Long idAfiliado) {
        return afiliadoService.eliminarAfiliado(idAfiliado);
    }

}
