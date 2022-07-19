package com.nttdata.apirest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AfiliadoDTO {
    @JsonProperty("afiliado_id")
    private Long id;

    @JsonProperty("tipo_identificacion")
    private String tipoIdentificacion;

    @JsonProperty("numero_identificacion")
    private String numeroIdentificacion;

    @JsonProperty("primer_nombre")
    private String primerNombre;

    @JsonProperty("segundo_nombre")
    private String segundoNombre;

    @JsonProperty("primer_apellido")
    private String primerApellido;

    @JsonProperty("segundo_apellido")
    private String segundoApellido;

    @JsonProperty("riesgo_cat")
    private String riesgoCat;

    @JsonProperty("activo")
    private String activo;

    @JsonProperty("usuario_creacion")
    private String usuarioCreacion;

    @JsonProperty("fecha_creacion")
    private String fechaCreacion;

    @JsonProperty("USUARIO_ULTIMA_MODIFICACION")
    private String usuarioUltimaModificacion;

    @JsonProperty("fecha_ultima_modificacion")
    private String fechaUltimaModificacion;

    @JsonProperty("numero_cuenta")
    private Integer numeroCuenta;

    @JsonProperty("estado_cuenta")
    private Date estadoCuenta;
}
