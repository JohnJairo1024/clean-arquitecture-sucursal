package co.com.sucursal.sucursalservice;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import co.com.sucursal.sucursalservice.client.CalcularDistancia;
import co.com.sucursal.sucursalservice.entity.SucursalEntity;
import co.com.sucursal.sucursalservice.exception.ServerException;
import co.com.sucursal.sucursalservice.repository.SucurRepository;
import co.com.sucursal.sucursalservice.util.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
        List<Sucursal> listSucursal = new ArrayList<>();
        for (SucursalEntity entity : all) {
            Sucursal build = new Sucursal();
            build.setId(entity.getId());
            build.setDireccion(entity.getDireccion());
            build.setHorarioAtencion(entity.getHorarioAtencion());
            build.setLatitud(entity.getLatitud());
            build.setLongitud(entity.getLongitud());
            listSucursal.add(build);
        }
        return listSucursal;
    }

    @Override
    public ResponseEntity<Sucursal> getSucursalCercana(String origenLatylong, String destinoLatylong) {
        try {
            String string = destinoLatylong;
            String[] parts = string.split("\\,");
            String latitud = parts[0];
            String longitud = parts[1];
            SucursalEntity getSucursalCercana = sucurRepository.getSucursalEntityByLatitudAndLongitud(latitud, longitud);
            String destino = getSucursalCercana.getLatitud().concat(",").concat(getSucursalCercana.getLongitud());
            int distancia = CalcularDistancia.obtenerDistancia(origenLatylong, destino);
            Sucursal sucursal = new Sucursal();
            sucursal.setDistancia(distancia);
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            throw new ServerException(Constantes.RESPUESTA_FALLIDA);
        }
    }


    @Override
    public Sucursal save(Sucursal sucursal) {
        return null;
    }
}
