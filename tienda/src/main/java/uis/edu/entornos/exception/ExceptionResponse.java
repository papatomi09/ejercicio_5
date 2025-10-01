package uis.edu.entornos.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ExceptionResponse {

    private LocalDateTime timestamp;
    private String message;
    private String detalles;
    private Map<String, String> erroresValidacion;

    // Contructor vacio
    public ExceptionResponse() {
    }

    // Constructores con parametros
    public ExceptionResponse(LocalDateTime timestamp, String message, String detalles) {
        this.timestamp = timestamp;
        this.message = message;
        this.detalles = detalles;
    }

    public ExceptionResponse(LocalDateTime timestamp, String message, String detalles,
            Map<String, String> erroresValidacion) {
        this.timestamp = timestamp;
        this.message = message;
        this.detalles = detalles;
        this.erroresValidacion = erroresValidacion;
    }

    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return message;
    }

    public void setMensaje(String message) {
        this.message = message;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Map<String, String> getErroresValidacion() {
        return erroresValidacion;
    }

    public void setErroresValidacion(Map<String, String> erroresValidacion) {
        this.erroresValidacion = erroresValidacion;
    }

}
