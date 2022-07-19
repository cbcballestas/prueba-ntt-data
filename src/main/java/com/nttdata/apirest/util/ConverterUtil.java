package com.nttdata.apirest.util;

import com.nttdata.apirest.dto.AfiliadoDTO;
import com.nttdata.apirest.model.Afiliado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConverterUtil {
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Método que se encarga de realizar mapeo a objeto Afiliado (Entidad)
     *
     * @param afiliadoDTO
     * @return Objeto Afiliado
     */
    public Afiliado mapToAfiliado(AfiliadoDTO afiliadoDTO) {
        return modelMapper.map(afiliadoDTO, Afiliado.class);
    }

    /**
     * Método que se encarga de realizar mapeo a objeto AfiliadoDTO (Entidad)
     *
     * @param afiliado
     * @return Objeto AfiliadoDTO
     */
    public AfiliadoDTO mapToAfiliadoDTO(Afiliado afiliado) {
        return modelMapper.map(afiliado, AfiliadoDTO.class);
    }
}
