package co.com.sucursal.model.sucursal.gateways;


import co.com.sucursal.model.sucursal.Sucursal;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SucursalGateway {

    List<Sucursal> findAll();

    ResponseEntity<Sucursal> getSucursalCercana(String origenLatylong, String destinoLatylong);

    Sucursal saveSucursal(Sucursal sucursal);

    void deleteSucursal(int id);
}
