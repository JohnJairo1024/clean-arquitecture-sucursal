package co.com.sucursal.api;

import co.com.sucursal.model.sucursal.Sucursal;
import co.com.sucursal.usecase.sucursal.SucursalUseCaseAll;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final Logger logger = LoggerFactory.getLogger(ApiRest.class);

    private final SucursalUseCaseAll sucursalUseCaseAll;

    @GetMapping(path = "/hello")
    public String health() {
        return "La aplicacion funciona correctamente...";
    }

    @GetMapping("/sucursales")
    public ResponseEntity<List<Sucursal>> getAllSubsidiary() {
        logger.info("Find All Sucursal : {}-{}");
        return ResponseEntity.ok(sucursalUseCaseAll.getAllSucursal());
    }


}
