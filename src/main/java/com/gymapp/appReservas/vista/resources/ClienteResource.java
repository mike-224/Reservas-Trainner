package com.gymapp.appReservas.vista.resources;

import com.gymapp.appReservas.modelo.Cliente;
import com.gymapp.appReservas.negocio.services.ClienteService;
import com.gymapp.appReservas.vista.resources.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

/**
 * Clase para activar la API Rest de la clase cliente
 * @author MIKE224
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/api/cliente")
@Api(tags= "cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
    @ApiResponses(value = { @ApiResponse(code = 201, message ="Cliente creado correctamente"),
    @ApiResponse(code= 400, message = "Solicitud Inválida") })
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {
        Cliente cliente = new Cliente();
        cliente.setNombreCli(clienteVo.getNombreCli());
        cliente.setApellidoCli(clienteVo.getApellidoCli());
        cliente.setDireccionCli(clienteVo.getDireccionCli());
        cliente.setTelefonoCli(clienteVo.getTelefonoCli());
        cliente.setEmailCli(clienteVo.getEmailCli());
        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);

    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un nuevo cliente")
    @ApiResponses(value = { @ApiResponse(code = 201, message ="Cliente actualizado correctamente"),
            @ApiResponse(code= 400, message = "Este cliente no existe :_(") })
    public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion, ClienteVO clienteVo) {

        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
        if(cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }else {
            cliente.setNombreCli(clienteVo.getNombreCli());
            cliente.setApellidoCli(clienteVo.getApellidoCli());
            cliente.setDireccionCli(clienteVo.getDireccionCli());
            cliente.setTelefonoCli(clienteVo.getTelefonoCli());
            cliente.setEmailCli(clienteVo.getEmailCli());
        }

        return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar a un cliente")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
    @ApiResponse(code=404, message = "Cliente no encontrdo") })
    public void removeCliente(@PathVariable("identificacion") String identificacion) {
        System.out.println("Id"+identificacion);
        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
        if (cliente != null) {
            this.clienteService.delete(cliente);
        }

    }

    @GetMapping
    @ApiOperation(value = "Listar clientes", notes = "Servicio para listar clientes")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Listado de clientes"),
            @ApiResponse(code=400, message = "No hay clientes registrados") })
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}
