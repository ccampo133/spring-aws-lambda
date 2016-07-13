package me.ccampo.example.model;

/**
 * N.B. that AWS Lambda requires you use the standard JavaBeans
 * convention for your POJO classes if you want to use their
 * built-in JSON serialization. If this annoys you, because
 * you like to use immutable classes (like I do), please consider
 * using extending the
 * {@link me.ccampo.spring.aws.lambda.JacksonSpringRequestHandler}
 * class in your own handlers, and use Jackson to implement your
 * own serialization.
 * <p>
 * For example purposes though, this simple POJO will suffice.
 *
 * @author Chris Campo
 */
public class Request {

    private String message;

    public String getMessage() {
        return message;
    }

    public Request setMessage(final String message) {
        this.message = message;
        return this;
    }
}
