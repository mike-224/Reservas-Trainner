package com.gymapp.appReservas.negocio.services;

import com.gymapp.appReservas.modelo.Cliente;
import com.gymapp.appReservas.negocio.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase para definir los servicios de la clase cliente
 */
@Service
@Transactional(readOnly = true)
public class ClienteService {
    private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Método para realizar la operación de guardar un cliente
     * @param cliente
     * @return
     */
    @Transactional
    public Cliente create(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    /**
     * Método para realizar la operación de actualizar un cliente
     * @param cliente
     * @return
     */
    @Transactional
    public Cliente update(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    /**
     * Método para realizar la operación de borrar un cliente
     * @param cliente
     * @return
     */
    @Transactional
    public void delete(Cliente cliente) {
        this.clienteRepository.delete(cliente);
    }

    /**
     * Metodo para buscar un cliente según su ID
     * @param idCli
     * @return
     */
    public Cliente findByIdentificacion(String idCli) {
        return this.clienteRepository.findByIdentificacion(idCli);
    }

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }
}
