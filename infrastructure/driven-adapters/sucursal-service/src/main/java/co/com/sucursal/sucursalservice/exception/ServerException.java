package co.com.sucursal.sucursalservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RuntimeException {
    public ServerException(String param) {
        super(param);
    }
}
