package co.com.sucursal.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("co.com.sucursal"))
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/.*"))
                .build()
                .apiInfo(swaggerStaticApiInfo())
                .consumes(Sets.newHashSet("application/json"))
                .produces(Sets.newHashSet("application/json"));
    }

    private ApiInfo swaggerStaticApiInfo() {

        return new ApiInfoBuilder()
                .title(" Services ")
                .description(" Pega Application, to get products. ")
                .build();
    }
}

//Documentation http://localhost:8080/swagger-ui.html
//JSON generated (using SwaggerEditor) http://localhost:8080/v2/api-docs