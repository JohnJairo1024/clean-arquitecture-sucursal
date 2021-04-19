package co.com.sucursal.sucursalservice.exception;

import co.com.sucursal.sucursalservice.util.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<Object> handleServerException(ServerException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(Constantes.CODE, Constantes.ERROR_500);
        body.put(Constantes.DESCRIPTION, e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
