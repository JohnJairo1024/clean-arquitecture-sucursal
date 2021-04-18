package co.com.sucursal.sucursalservice;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService implements SucursalGateway {

    @Autowired
    private SucurRepository sucurRepository;

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
