package co.com.sucursal.config;

import co.com.sucursal.model.sucursal.gateways.SucursalGateway;
import co.com.sucursal.usecase.sucursal.SucursalUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SucursalUseCaseConfig {

    @Bean
    public SucursalUseCase getSucursalUseCaseAll(SucursalGateway sucursalGateway) {
        return new SucursalUseCase(sucursalGateway);
    }

}
