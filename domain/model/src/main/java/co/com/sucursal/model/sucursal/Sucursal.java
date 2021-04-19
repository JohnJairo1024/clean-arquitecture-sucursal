package co.com.sucursal.model.sucursal;

import lombok.Data;

@Data
public class Sucursal extends MensajeOut {

    private int id;
    private String direccion;
    private String horarioAtencion;
    private String latitud;
    private String longitud;
    private int distancia;

}

