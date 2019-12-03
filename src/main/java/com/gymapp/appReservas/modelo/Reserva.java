package com.gymapp.appReservas.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase que representa la tabla reserva
 * @author MIKE224
 */
@Data
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String idRes;
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    private Date cantidadPersonasRes;
    private String descripcionRes;
    @ManyToOne
    @JoinColumn(name = "idCli")
    private Cliente cliente;

}
