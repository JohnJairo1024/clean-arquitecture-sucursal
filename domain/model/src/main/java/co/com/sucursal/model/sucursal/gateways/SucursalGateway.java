package co.com.sucursal.model.sucursal.gateways;


import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.SucursalCercana;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SucursalGateway {

    List<Sucursal> findAll();

    ResponseEntity<SucursalCercana> getSucursalCercana(double latitude, double longitud);

    Sucursal saveSucursal(Sucursal sucursal);

    void deleteSucursal(int id);
}
