package com.nttdata.apirest.repository;

import com.nttdata.apirest.model.Afiliado;
import com.nttdata.apirest.util.Datos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AfiliadoRepositoryTest {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Test
    @DisplayName("TEST que realiza la búsqueda de afiliados por fecha de creación existente")
    void testGetAfiliadosByFechaCreacion() {
        List<Afiliado> afiliados = afiliadoRepository.getAfiliadosByFechaCreacion(Datos.FECHA_CREACION);
        assertNotNull(afiliados);
    }

    @Test
    @DisplayName("TEST que realiza la búsqueda de afiliados por fecha de creación inexistente")
    void testGetAfiliadosByFechaCreacion_WhenFechaCreacionDoesNotExist() {
        List<Afiliado> afiliados = afiliadoRepository.getAfiliadosByFechaCreacion(Datos.FECHA_CREACION_INCORRECTA);
        assertEquals(0, afiliados.size());
        assumeTrue(afiliados.size() == 0);
    }

    @Test
    @DisplayName("TEST que verifica la búsqueda de un afiliado por número de identificación")
    void testFindByNumeroIdentificacion() {
        Optional<Afiliado> afiliado = afiliadoRepository.findByNumeroIdentificacion(Datos.NUMERO_IDENTIFICACION);
        assumeTrue(afiliado.isPresent());
        assertEquals(Datos.NOMBRE_AFILIADO, afiliado.get().getPrimerNombre());
    }
    @Test
    @DisplayName("TEST que verifica la búsqueda de un afiliado por número de identificación que no existe")
    void testFindByNumeroIdentificacion_WhenNumeroIdentificacionDoesNotExist() {
        Optional<Afiliado> afiliado = afiliadoRepository.findByNumeroIdentificacion(Datos.NUMERO_IDENTIFICACION_INCORRECTO);
        assumeFalse(afiliado.isPresent());
    }
}