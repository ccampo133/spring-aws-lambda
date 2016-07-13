package me.ccampo.spring.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Convenience class which represents a {@link RequestHandler} that returns nothing.
 */
public abstract class VoidRequestHandler<T> implements RequestHandler<T, Void> {

    @Override
    @Contract("_,_ -> null")
    @Nullable
    public final Void handleRequest(final T input, final Context context) {
        handle(input, context);
        return null;
    }

    public abstract void handle(final T input, final Context context);
}
