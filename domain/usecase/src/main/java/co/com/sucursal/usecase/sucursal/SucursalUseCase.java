package co.com.sucursal.usecase.sucursal;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.SucursalCercana;
import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @docs implementa los casos de uso del sistema, define lógica de aplicación
 * y reacciona a las invocaciones desde el módulo de entry points,
 * orquestando los flujos hacia el módulo de entities
 */


@RequiredArgsConstructor
public class SucursalUseCase {

    private final SucursalGateway sucursalGateway;

    public List<Sucursal> getAllSucursal() {
        return sucursalGateway.findAll();
    }

    public ResponseEntity<SucursalCercana> getSucursalCercana(double latitude, double longitud) {
        return sucursalGateway.getSucursalCercana(latitude, longitud);
    }

    public Sucursal createSucursal(Sucursal sucursal) {
        return sucursalGateway.saveSucursal(sucursal);
    }

    public void deleteSucursal(int id) {
        sucursalGateway.deleteSucursal(id);
    }
}
