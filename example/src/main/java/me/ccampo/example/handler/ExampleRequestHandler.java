package me.ccampo.example.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import me.ccampo.example.model.Request;
import me.ccampo.example.model.Response;
import me.ccampo.example.service.ExampleServiceA;
import me.ccampo.example.service.ExampleServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Our Lambda function's main logic takes place here, while we
 * leverage Spring's dependency injection features to inject the
 * services we need at construction time.
 *
 * This class is declared as a bean using the {@link Component}
 * annotation. You could also just as easily register it in the
 * {@link me.ccampo.example.ApplicationConfiguration} class, or
 * in a Spring application configuration XML file.
 *
 * @author Chris Campo
 */
@Component
public class ExampleRequestHandler implements RequestHandler<Request, Response> {

    private final ExampleServiceA exampleServiceA;
    private final ExampleServiceB exampleServiceB;

    /**
     * Dependency injection is handled via autowiring!
     */
    @Autowired
    public ExampleRequestHandler(final ExampleServiceA exampleServiceA, final ExampleServiceB exampleServiceB) {
        this.exampleServiceA = Objects.requireNonNull(exampleServiceA, "exampleServiceA");
        this.exampleServiceB = Objects.requireNonNull(exampleServiceB, "exampleServiceB");
    }

    @Override
    public Response handleRequest(final Request input, final Context context) {
        final String responseMessage = "Request message: " + input.getMessage()
                + ", Service A message: " + exampleServiceA.getMessage()
                + ", Service B message: " + exampleServiceB.getMessage();
        final Response response = new Response();
        response.setMessage(responseMessage);
        response.setStatus(Response.Status.OK);
        return response;
    }
}
