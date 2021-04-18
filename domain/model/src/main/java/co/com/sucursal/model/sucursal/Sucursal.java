package co.com.sucursal.model.sucursal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class Sucursal {

    private int id;
    private String descripcion;
    private double latitude;
    private double longitude;

}

