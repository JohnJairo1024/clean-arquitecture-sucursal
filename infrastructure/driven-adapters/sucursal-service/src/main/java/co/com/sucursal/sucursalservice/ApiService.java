package co.com.sucursal.sucursalservice;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService implements SucursalRepository {
    @Override
    public List<Sucursal> findAll() {
        return null;
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return null;
    }
}
