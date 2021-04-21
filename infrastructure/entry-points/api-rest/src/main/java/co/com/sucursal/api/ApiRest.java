package co.com.sucursal.api;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.model.sucursal.SucursalCercana;
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

//    @Autowired
//    private Environment env;


    private final SucursalUseCase sucursalUseCase;


//    @GetMapping(path = "envdetails")
//    public String envdetails() {
//        return env.toString();
//    }

    @GetMapping(path = "health")
    public String health() {
        return "La aplicacion funciona correctamente...";
    }

    @GetMapping("/sucursales")
    public ResponseEntity<List<Sucursal>> getAllSubsidiary() {
        logger.info("Find All Sucursal : {}-{}");
        return ResponseEntity.ok(sucursalUseCase.getAllSucursal());
    }

    @GetMapping("/sucursalCercana")
    public ResponseEntity<SucursalCercana> getsucursalCercana(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitud") double longitud
    ) {
        logger.info("Find sucursalCercana origen : {}", latitude, longitud);
        return sucursalUseCase.getSucursalCercana(latitude, longitud);
    }

    @PostMapping("/sucursales")
    public Sucursal addSucursal(@RequestBody Sucursal sucursal) {
        logger.info("Create sucursal");
        return sucursalUseCase.createSucursal(sucursal);
    }

    @DeleteMapping("/sucursal/{id}")
    public void deleteSucursal(@PathVariable int id) {
        sucursalUseCase.deleteSucursal(id);
    }

}
