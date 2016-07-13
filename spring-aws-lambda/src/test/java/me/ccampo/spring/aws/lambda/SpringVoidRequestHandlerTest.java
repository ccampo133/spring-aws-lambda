package me.ccampo.spring.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.*;

/**
 * @author Chris Campo
 */
public class SpringVoidRequestHandlerTest {

    ApplicationContext mockApplicationContext = mock(ApplicationContext.class);

    private class TestSpringVoidRequestHandler extends SpringVoidRequestHandler<String> {
        @Override
        public ApplicationContext getApplicationContext() {
            return mockApplicationContext;
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void handle() {
        final RequestHandler handler = mock(RequestHandler.class);
        when(mockApplicationContext.getBean(RequestHandler.class)).thenReturn(handler);
        final TestSpringVoidRequestHandler testHandler = new TestSpringVoidRequestHandler();
        final Context mockContext = mock(Context.class);
        final String input = "foo";
        testHandler.handleRequest(input, mockContext);
        verify(mockApplicationContext).getBean(RequestHandler.class);
        verify(handler).handleRequest(input, mockContext);
    }
}
