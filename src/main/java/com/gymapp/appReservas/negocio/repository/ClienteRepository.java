package com.gymapp.appReservas.negocio.repository;

import com.gymapp.appReservas.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface para definir las operaciones de base de datos relacionadas con la clase cliente
 * @author MIKE224
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    /**
     * Aquí definimos el método para buscar clientes según su apellido
     * @param apellidoCli
     * @return
     */
    public List<Cliente> findByApellidoCli(String apellidoCli);

    /**
     * Aquí definimos el método para buscar clientes según su ID
     * @param idCli
     * @return
     */
    public Cliente findByIdentificacion(String idCli);

    /**
     * Aquí definimos el método para buscar clientes según su email
     * @param email
     * @return
     */
    public Cliente findByEmailCli(@Param("email") String email);

}
