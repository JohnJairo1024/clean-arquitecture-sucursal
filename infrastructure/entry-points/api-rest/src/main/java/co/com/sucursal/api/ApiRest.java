package co.com.sucursal.api;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.usecase.sucursal.SucursalUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final Logger logger = LoggerFactory.getLogger(ApiRest.class);

    private final SucursalUseCase sucursalUseCase;

    @GetMapping(path = "/hello")
    public String health() {
        return "La aplicacion funciona correctamente...";
    }

    @GetMapping("/sucursales")
    public ResponseEntity<List<Sucursal>> getAllSubsidiary() {
        logger.info("Find All Sucursal : {}-{}");
        return ResponseEntity.ok(sucursalUseCase.getAllSucursal());
    }

    @GetMapping("/sucursalCercana")
    public ResponseEntity<Sucursal> getsucursalCercana(
            @RequestParam("origins") String origenLatylong,
            @RequestParam("destinations") String destinoLatylong
    ) {
        logger.info("Find sucursalCercana origen : {}", origenLatylong, destinoLatylong);
        return sucursalUseCase.getSucursalCercana(origenLatylong, destinoLatylong);
    }

    @PostMapping("/sucursales")
    public Sucursal addSucursal(@RequestBody Sucursal sucursal) {
        logger.info("Create sucursal");
        return sucursalUseCase.createSucursal(sucursal);
    }

}
