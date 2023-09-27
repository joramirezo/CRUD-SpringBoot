package com.semillero.apitienda.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${swaggerapi.openapi.dev-url}")
    private String devUrl;
    @Value("${swaggerapi.openapi.prod-url}")
    private String prodUrl;
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");
        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");
        Contact contact = new Contact();
        contact.setEmail("joseramirezolaya@gmail.com");
        contact.setName("Jose Ramirez");
        contact.setUrl("https://632b7d81115e000008ffcfcb--joseramirez-cv.netlify.app/");
        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
        Info info = new Info()
                .title("APITienda")
                .version("1.0")
                .contact(contact)
                .description("Bienvenidos a la APITienda donde podrás comprar lo que quieras.")
                .termsOfService("https://www.joseramirez.com/terms")
                .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}