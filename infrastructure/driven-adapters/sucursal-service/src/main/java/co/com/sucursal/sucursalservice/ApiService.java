package co.com.sucursal.sucursalservice;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import co.com.sucursal.sucursalservice.entity.SucursalEntity;
import co.com.sucursal.sucursalservice.repository.SucurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService implements SucursalGateway {

    private final SucurRepository sucurRepository;

    public ApiService(SucurRepository sucurRepository) {
        this.sucurRepository = sucurRepository;
    }

    @Override
    public List<Sucursal> findAll() {
        List<SucursalEntity> all = sucurRepository.findAll();
        List<Sucursal> findAll = new ArrayList<>();
        for (SucursalEntity entity : all) {
            Sucursal build = Sucursal.builder().build();
            build.setId(entity.getId());
            build.setDescripcion(entity.getDescripcion());
            build.setLatitude(entity.getLatitude());
            build.setLongitude(entity.getLongitude());
            findAll.add(build);
        }
        return findAll;
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return null;
    }
}
