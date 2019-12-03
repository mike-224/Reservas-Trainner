package com.gymapp.appReservas.vista.resources.vo;

import lombok.Data;

/**
 * Clase en la que creamos una clase cliente simple para usarla en la clase ClienteResource
 * @author MIKE224
 */
@Data
public class ClienteVO {
    private String nombreCli;
    private String apellidoCli;
    private String identificacionCli;
    private String direccionCli;
    private String telefonoCli;
    private String emailCli;

}
