package co.com.sucursal.config;

import co.com.sucursal.model.sucursal.gateways.SucursalRepository;
import co.com.sucursal.usecase.sucursal.SucursalUseCaseAll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SucursalUseCaseConfig {

    @Bean
    public SucursalUseCaseAll getSucursalUseCaseAll(SucursalRepository sucursalRepository) {
        return new SucursalUseCaseAll(sucursalRepository);
    }

}
