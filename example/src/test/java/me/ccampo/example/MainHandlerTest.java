package me.ccampo.example;

import me.ccampo.example.model.Request;
import me.ccampo.example.model.Response;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Chris Campo
 */
public class MainHandlerTest {

    @Test
    public void testHandle() {
        final MainHandler mainHandler = new MainHandler();
        final Request request = new Request();
        request.setMessage("Hello world!");
        final Response response = mainHandler.handleRequest(request, null);
        assertThat(response).isNotNull();
    }
}
