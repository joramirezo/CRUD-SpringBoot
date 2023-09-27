package com.semillero.apitienda.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ApiTiendaExceptions extends RuntimeException{
    private String mensaje;
    private HttpStatus httpStatus;

    public ApiTiendaExceptions(String mensaje, HttpStatus httpStatus){
        super(mensaje);
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
    }
}
