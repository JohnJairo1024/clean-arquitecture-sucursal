package co.com.sucursal.usecase.sucursal;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @docs implementa los casos de uso del sistema, define lógica de aplicación
 * y reacciona a las invocaciones desde el módulo de entry points,
 * orquestando los flujos hacia el módulo de entities
 */

@Service
@Transactional
@RequiredArgsConstructor
public class SucursalUseCaseAll {

    private final SucursalRepository sucursalRepository;

    public List<Sucursal> getAllSucursal() {
        return sucursalRepository.findAll();
    }

}
