package com.nttdata.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COB_AFILIADO")
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AFILIADO_ID")
    private Long id;

    @Column(name = "TIPO_IDENTIFICACION", length = 3)
    private String tipoIdentificacion;

    @Column(name = "NUMERO_IDENTIFICACION", length = 20)
    private String numeroIdentificacion;

    @Column(name = "PRIMER_NOMBRE", length = 20)
    private String primerNombre;

    @Column(name = "SEGUNDO_NOMBRE", length = 20)
    private String segundoNombre;

    @Column(name = "PRIMER_APELLIDO", length = 20)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO", length = 20)
    private String segundoApellido;

    @Column(name = "RIESGO_CAT", length = 40)
    private String riesgoCat;

    @Column(name = "ACTIVO", length = 1)
    private String activo;

    @Column(name = "USUARIO_CREACION", length = 30)
    private String usuarioCreacion;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 30)
    private String usuarioUltimaModificacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;

    @Column(name = "NUMERO_CUENTA", length = 20)
    private Integer numeroCuenta;

    @Column(name = "ESTADO_CUENTA", length = 20)
    private Date estadoCuenta;


    @PrePersist
    public void prePersist(){
        fechaCreacion = new Date();
    }

}
