package com.nttdata.apirest.impl;

import com.nttdata.apirest.dto.AfiliadoDTO;
import com.nttdata.apirest.exception.ResourceNotFoundException;
import com.nttdata.apirest.model.Afiliado;
import com.nttdata.apirest.repository.AfiliadoRepository;
import com.nttdata.apirest.service.AfiliadoService;
import com.nttdata.apirest.util.ConstantsUtil;
import com.nttdata.apirest.util.ConverterUtil;
import com.nttdata.apirest.util.JsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AfiliadoServiceImpl implements AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;
    private final ConstantsUtil utilKeys;
    private final ConverterUtil utilConverter;

    /**
     * Método que se encarga de obtener el listado de afiliados registrados
     *
     * @return Lista de afiliados
     */
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<JsonResponse<List<AfiliadoDTO>>> obtenerAfiliados() {

        List<AfiliadoDTO> afiliados = afiliadoRepository.findAll().stream()
                .map(utilConverter::mapToAfiliadoDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new JsonResponse<List<AfiliadoDTO>>(
                utilKeys.SUCCESS_STATUS,
                utilKeys.SUCCESS_MESSAGE,
                afiliados
        ), HttpStatus.OK);
    }

    /**
     * Método que se encarga de buscar un afiliado por ID
     *
     * @param afiliadoId ID registro
     * @return Afiliado encontrado
     */
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<JsonResponse<AfiliadoDTO>> obtenerAfiliadoPorId(Long afiliadoId) {

        Afiliado afiliado = afiliadoRepository.findById(afiliadoId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Registro con ID %d NO ha sido encontrado", afiliadoId)));

        return new ResponseEntity<>(new JsonResponse<AfiliadoDTO>(
                utilKeys.SUCCESS_STATUS,
                utilKeys.SUCCESS_MESSAGE,
                utilConverter.mapToAfiliadoDTO(afiliado)
        ), HttpStatus.OK);
    }

    /**
     * Método que se encarga de realizar la búsqueda de un afiliado por número identificación
     *
     * @param numeroIdentificacion Número identificación
     * @return Afiliado
     */
    @Override
    public ResponseEntity<JsonResponse<AfiliadoDTO>> obtenerAfiliadoPorNumeroIdentificacion(String numeroIdentificacion) {
        Afiliado afiliado = afiliadoRepository.findByNumeroIdentificacion(numeroIdentificacion)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("NO se ha encontrado afiliado con identificación: %s.", numeroIdentificacion)));

        return new ResponseEntity<>(new JsonResponse<AfiliadoDTO>(
                utilKeys.SUCCESS_STATUS,
                utilKeys.SUCCESS_MESSAGE,
                utilConverter.mapToAfiliadoDTO(afiliado)
        ), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<JsonResponse<AfiliadoDTO>> registrarAfiliado(AfiliadoDTO afiliadoDTO) {

        Afiliado afiliado = utilConverter.mapToAfiliado(afiliadoDTO);
        afiliado.setUsuarioCreacion(afiliadoDTO.getUsuarioCreacion());
        afiliado.setFechaCreacion(utilConverter.dateFormat(new Date()));

        Afiliado nuevoAfiliado = afiliadoRepository.save(afiliado);

        return new ResponseEntity<>(new JsonResponse<AfiliadoDTO>(
                utilKeys.SUCCESS_STATUS,
                utilKeys.SUCCESS_MESSAGE,
                utilConverter.mapToAfiliadoDTO(nuevoAfiliado)
        ), HttpStatus.CREATED);
    }

    /**
     * Método que se encarga de actualizar los datos de un afiliado
     *
     * @param afiliadoId  ID afiliado
     * @param afiliadoDTO Datos del afiliado a actualizar
     * @return Afiliado actualizado
     */
    @Override
    @Transactional
    public ResponseEntity<JsonResponse<AfiliadoDTO>> actualizarAfiliado(Long afiliadoId, AfiliadoDTO afiliadoDTO) {

        Afiliado afiliado = afiliadoRepository.findById(afiliadoId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Registro con ID %d NO ha sido encontrado", afiliadoId)));

        // Se actualizan los campos
        afiliado.setTipoIdentificacion(afiliadoDTO.getTipoIdentificacion());
        afiliado.setNumeroIdentificacion(afiliadoDTO.getNumeroIdentificacion());
        afiliado.setPrimerNombre(afiliadoDTO.getPrimerNombre());
        afiliado.setSegundoNombre(afiliadoDTO.getSegundoNombre());
        afiliado.setPrimerApellido(afiliadoDTO.getPrimerApellido());
        afiliado.setSegundoApellido(afiliadoDTO.getSegundoApellido());
        afiliado.setRiesgoCat(afiliadoDTO.getRiesgoCat());
        afiliado.setActivo(afiliadoDTO.getActivo());
        afiliado.setUsuarioUltimaModificacion(afiliadoDTO.getUsuarioUltimaModificacion());
        afiliado.setFechaUltimaModificacion(utilConverter.dateFormat(new Date()));
        afiliado.setNumeroCuenta(afiliadoDTO.getNumeroCuenta());
        afiliado.setEstadoCuenta(afiliadoDTO.getEstadoCuenta());

        Afiliado afiliadoModificado = afiliadoRepository.save(afiliado);

        return new ResponseEntity<>(new JsonResponse<AfiliadoDTO>(
                utilKeys.SUCCESS_STATUS,
                utilKeys.SUCCESS_MESSAGE,
                utilConverter.mapToAfiliadoDTO(afiliadoModificado)
        ), HttpStatus.OK);
    }

    /**
     * Método que se encarga de eliminar un afiliado
     *
     * @param afiliadoId ID registro a eliminar
     */
    @Override
    @Transactional
    public ResponseEntity<Void> eliminarAfiliado(Long afiliadoId) {
        Afiliado afiliado = afiliadoRepository.findById(afiliadoId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Registro con ID %d NO ha sido encontrado", afiliadoId)));

        // Se elimina registro
        afiliadoRepository.delete(afiliado);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
