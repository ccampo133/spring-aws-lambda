package me.ccampo.example.model;

/**
 * @author Chris Campo
 */
public class Response {

    public enum Status {
        OK, ERROR;
    }

    private String message;
    private Status status;

    public String getMessage() {
        return message;
    }

    public Response setMessage(final String message) {
        this.message = message;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Response setStatus(final Status status) {
        this.status = status;
        return this;
    }
}
