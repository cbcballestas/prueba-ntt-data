package com.nttdata.apirest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AfiliadoDTO {
    @JsonProperty("afiliado_id")
    private Long id;

    @JsonProperty("tipo_identificacion")
    @Size(max = 3, message = "Tipo de identificación DEBE ser máximo de 3 caracteres")
    @NotEmpty(message = "Tipo de identificación es obligatorio")
    private String tipoIdentificacion;

    @JsonProperty("numero_identificacion")
    @Size(max = 20, message = "Número de identificación DEBE ser máximo de 20 caracteres")
    @NotEmpty(message = "Número de identificación es obligatorio")
    private String numeroIdentificacion;

    @JsonProperty("primer_nombre")
    @Size(max = 20, message = "Primer nombre DEBE ser máximo de 20 caracteres")
    @NotEmpty(message = "Primer nombre es obligatorio")
    private String primerNombre;

    @JsonProperty("segundo_nombre")
    private String segundoNombre;

    @JsonProperty("primer_apellido")
    @Size(max = 20, message = "Primer apellido DEBE ser máximo de 20 caracteres")
    @NotEmpty(message = "Primer apellido es obligatorio")
    private String primerApellido;

    @JsonProperty("segundo_apellido")
    private String segundoApellido;

    @JsonProperty("riesgo_cat")
    private String riesgoCat;

    @JsonProperty("activo")
    private String activo;

    @JsonProperty("usuario_creacion")
    private String usuarioCreacion;

    @JsonProperty("usuario_ultima_modificacion")
    private String usuarioUltimaModificacion;

    @JsonProperty("numero_cuenta")
    private Integer numeroCuenta;

    @JsonProperty("estado_cuenta")
    private String estadoCuenta;
}
