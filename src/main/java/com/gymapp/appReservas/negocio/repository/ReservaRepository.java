package com.gymapp.appReservas.negocio.repository;

import com.gymapp.appReservas.modelo.Cliente;
import com.gymapp.appReservas.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Interface para definir las operaciones de base de datos relacionadas con la clase reserva
 * @author MIKE224
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

    /**
     * Metodo para consultar reservas por cliente
     * @param cliente
     * @return
     */
    @Query("select r from  Reserva  r where  r.cliente =:cliente")
    public  List<Reserva> findByCliente(Cliente cliente);

    /**
     * Definimos un nuevo método para consultar las reservas por la fecha de ingreso dentro de un rango de fechas
     * @param fechaInicio
     * @param fechaSalida
     * @return
     */
    @Query("select r from Reserva r where  r.fechaEntrada =:fechaInicio and r.fechaSalida =:fechaSalida")
    public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);

}
