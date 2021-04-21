package co.com.sucursal.sucursalservice;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.SucursalCercana;
import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import co.com.sucursal.sucursalservice.client.CalcularDistancia;
import co.com.sucursal.sucursalservice.entity.SucursalEntity;
import co.com.sucursal.sucursalservice.exception.ServerException;
import co.com.sucursal.sucursalservice.repository.SucurRepository;
import co.com.sucursal.sucursalservice.util.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        try {
            List<SucursalEntity> all = sucurRepository.findAll();
            List<Sucursal> listSucursal = new ArrayList<>();
            for (SucursalEntity entity : all) {
                Sucursal build = new Sucursal();
                build.setId(entity.getId());
                build.setDireccion(entity.getDireccion());
                build.setHorarioAtencion(entity.getHorarioAtencion());
                build.setLatitud(String.valueOf(entity.getLatitud()));
                build.setLongitud(String.valueOf(entity.getLongitud()));
                listSucursal.add(build);
            }
            return listSucursal;

        } catch (Exception e) {
            throw new ServerException(Constantes.RESPUESTA_FALLIDA);
        }
    }

    @Override
    public ResponseEntity<SucursalCercana> getSucursalCercana(double latitude, double longitud) {
        try {
            List<SucursalEntity> listSucursal = sucurRepository.findAll();
            SucursalCercana sucursalCercana = CalcularDistancia.calcularDistancia(latitude, longitud, listSucursal);
            SucursalCercana sucursal = new SucursalCercana();
            sucursal.setInfoSucursal(sucursalCercana.getInfoSucursal());
            sucursal.setDistancia(sucursalCercana.getDistancia());
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (Exception e) {
            throw new ServerException(Constantes.RESPUESTA_FALLIDA);
        }
    }


    @Override
    public Sucursal saveSucursal(Sucursal sucursal) {
        try {
            if (sucursal == null) {
                throw new ServerException(Constantes.RESPUESTA_FALLIDA);
            }

            Sucursal sucur = new Sucursal();
            sucurRepository.addSucursalData(
                    sucursal.getId(),
                    sucursal.getDireccion(),
                    sucursal.getHorarioAtencion(),
                    sucursal.getLatitud(),
                    sucursal.getLongitud()
            );
            sucur.setCode(String.valueOf(Constantes.CODE_OK));
            sucur.setDescription("Se guarda con exito la sucursal");
            return sucur;
        } catch (Exception e) {
            throw new ServerException(Constantes.RESPUESTA_FALLIDA);
        }
    }

    @Override
    public void deleteSucursal(int id) {
        try {
            Sucursal sucur = new Sucursal();
            sucurRepository.deleteSucursal(id);
            sucur.setCode(String.valueOf(Constantes.CODE_OK));
            sucur.setDescription("Se elimina con exito la sucursal");
        } catch (Exception e) {
            throw new ServerException(Constantes.RESPUESTA_FALLIDA);
        }
    }
}
