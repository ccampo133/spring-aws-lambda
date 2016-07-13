package me.ccampo.spring.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * Exactly the same as {@link SpringRequestHandler}, except with no output (void).
 */
public abstract class SpringVoidRequestHandler<I> extends SpringRequestHandler<I, Void> {

    @Override
    public Void handleRequest(final I input, final Context context) {
        super.handleRequest(input, context);
        return null;
    }
}
