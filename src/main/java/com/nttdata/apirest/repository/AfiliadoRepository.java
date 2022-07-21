package com.nttdata.apirest.repository;

import com.nttdata.apirest.model.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {

    @Query(
            value = "SELECT\n" +
                    "* \n" +
                    "FROM\n" +
                    "GCCOBRANZAS.COB_AFILIADO \n" +
                    "WHERE\n" +
                    "CONVERT ( DATE, FECHA_CREACION, 23 ) = :fecha\n" +
                    "AND ACTIVO = 'S'\n" +
                    "ORDER BY PRIMER_APELLIDO ASC",
            nativeQuery = true
    )
    List<Afiliado> getAfiliadosByFechaCreacion(@Param("fecha") String fecha);

    Optional<Afiliado> findByNumeroIdentificacion(String numeroIdentificacion);
}
