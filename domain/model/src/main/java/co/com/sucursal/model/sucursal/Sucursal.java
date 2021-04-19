package co.com.sucursal.model.sucursal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Sucursal extends MensajeOut {

    private int id;
    private String direccion;
    private String horarioAtencion;
    private String latitud;
    private String longitud;
    private String distancia;

}

