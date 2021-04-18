package co.com.sucursal.usecase.sucursal;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @docs implementa los casos de uso del sistema, define lógica de aplicación
 * y reacciona a las invocaciones desde el módulo de entry points,
 * orquestando los flujos hacia el módulo de entities
 */


@RequiredArgsConstructor
public class SucursalUseCaseAll {

    private final SucursalGateway sucursalGateway;

    public List<Sucursal> getAllSucursal() {
        return sucursalGateway.findAll();
    }

}
