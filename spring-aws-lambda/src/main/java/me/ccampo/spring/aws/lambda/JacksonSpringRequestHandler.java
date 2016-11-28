package me.ccampo.spring.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Lambda does JSON parsing behind the scenes, but it can be a little
 * restrictive. This class allows you to provide a custom configured
 * {@link ObjectMapper} which can handle any special JSON parsing behavior.
 * <p>
 * To make use of this class, implement the
 * {@link SpringRequestStreamHandler#getApplicationContext()} method to provide
 * a Spring {@link org.springframework.context.ApplicationContext}, and then
 * register a bean of type {@link RequestHandler} with the same type
 * parameters.
 *
 * @param <I> the input type parameter
 * @param <O> the output type parameter
 * @author Chris Campo
 */
public abstract class JacksonSpringRequestHandler<I, O> extends SpringRequestStreamHandler {

    private final Class<I> inputClass;

    private final RequestHandler handler;

    /**
     * To work around type erasure, pass the input type class here. AWS Lambda
     * requires a no-arg constructor for their handler classes however, so be
     * sure to provide one while calling this constructor in it.
     *
     * @param inputClass the class of this class's input type parameter, I.
     */
    protected JacksonSpringRequestHandler(@NotNull final Class<I> inputClass) {
        this.inputClass = inputClass;
        this.handler = getApplicationContext().getBean(RequestHandler.class);
    }

    /**
     * Must be implemented to return the {@link ObjectMapper} to be used in
     * serialization/deserialization.
     */
    protected abstract ObjectMapper getObjectMapper();

    @Override
    public void handleRequest(@NotNull final InputStream input, @NotNull final OutputStream output,
            @NotNull final Context context) throws IOException {
        final I inObject = getObjectMapper().readValue(input, inputClass);
        @SuppressWarnings("unchecked")
        final O outObject = (O) handler.handleRequest(inObject, context);
        getObjectMapper().writeValue(output, outObject);
    }
}
