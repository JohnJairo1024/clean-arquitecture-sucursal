package co.com.sucursal.model.sucursal.gateways;


import co.com.sucursal.model.sucursal.Sucursal;

import java.util.List;


public interface SucursalRepository {

    List<Sucursal> findAll();

    Sucursal save(Sucursal sucursal);

}
