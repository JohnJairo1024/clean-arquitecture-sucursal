package co.com.sucursal.sucursalservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SucursalEntity {

    @Id
    private int id;
    private String direccion;
    private String horarioAtencion;
    private String latitud;
    private String longitud;

}
