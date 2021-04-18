package co.com.sucursal.sucursalservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder", toBuilder = true)
@Entity
public class SucursalEntity {

    @Id
    private int id;
    private String descripcion;
    private double latitude;
    private double longitude;

}
