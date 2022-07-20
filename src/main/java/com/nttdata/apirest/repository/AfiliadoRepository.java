package com.nttdata.apirest.repository;

import com.nttdata.apirest.model.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {
    Optional<Afiliado> findByNumeroIdentificacion(String numeroIdentificacion);
}
