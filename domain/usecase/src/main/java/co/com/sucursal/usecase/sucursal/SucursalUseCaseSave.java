package co.com.sucursal.usecase.sucursal;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @docs implementa los casos de uso del sistema, define lógica de aplicación
 * y reacciona a las invocaciones desde el módulo de entry points,
 * orquestando los flujos hacia el módulo de entities
 */

@Service
@Transactional
@RequiredArgsConstructor
public class SucursalUseCaseSave {

    private final SucursalRepository sucursalRepository;

    public Sucursal createSucursal(Sucursal dummy) {
        return sucursalRepository.save(dummy);
    }

}
