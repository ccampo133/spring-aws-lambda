package me.ccampo.spring.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Similar functionality to {@link SpringRequestHandler}, except instead of
 * using Java objects as parameters and letting Lambda handle the
 * deserialization, this class exposes the raw byte streams for manipulation.
 *
 * @author Chris Campo
 */
public abstract class SpringRequestStreamHandler implements RequestStreamHandler, ApplicationContextProvider {

    private final RequestStreamHandler handler;

    public SpringRequestStreamHandler() {
        this.handler = getApplicationContext().getBean(RequestStreamHandler.class);
    }

    @Override
    public void handleRequest(final InputStream input, final OutputStream output, final Context context)
            throws IOException {
        handler.handleRequest(input, output, context);
    }
}
