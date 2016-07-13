# spring-aws-lambda

A Java library to enable core Spring Framework dependency injection support
and eliminate some boilerplate around AWS Lambda.

## Usage

When using Java with AWS Lambda, AWS requires you to either implement one of
their base interfaces (`RequestHandler` or `RequestStreamHandler`), or provide
a class with a single method `handle(T input, Context context)`. This library
leverages the interface-based approach. When deploying the function, you need
to point Lambda to your "main handler" class, which serves as the entry point
to your application.

The main usage is simple: import this library as a dependency and extend one of
the main abstract classes in `me.ccampo.spring.aws.lambda` as your main handler
class. You will be forced to implement the `getApplicationContext` method, which
is where you will provide the instance to your Spring application context class,
which will be used throughout the rest of the application.

Once you have provided an `ApplicationContext`, you can use Spring's dependency
injection features anywhere besides in your `MainHandler` class. This means you
can take the annotation driven approach, use autowiring, etc.

The abstract handler classes in this library actually use the provided
`ApplicationContext` instance to find a bean of type `RequestHandler` (Lambda's
main interface) and call it's `handleRequest` method, so most of your
application logic _should not_ be in your `MainHandler` class, but rather in a
separate bean of type `RequestHandler`.

The main pattern I recommend is creating a fairly empty `MainHandler` class that
implements one of this library's interfaces, supplies an `ApplicationContext`,
and then does nothing else. Additionally, you create another implementation of
`RequestHandler` and register it as a bean (either manually in your Spring
configuration or using annotations such as `@Component`). This custom
`RequestHandler` can then take advantage of all of Spring's dependency
injection tools. You are free to implement your application logic in there, or
split it out over several, loosely coupled classes, using Spring dependency
injection to wire it all together.

See the `example` directory for some a simple example of this pattern.

If you have any questions/comments/issues, please feel free to use the GitHub
issue tracker to report them.

Best,
/cc

[www.ccampo.me](https://www.ccampo.me)


## Development

### To Build:

For -nix and OSX:

    ./gradlew build

For Windows:

    gradlew.bat build

Requires Java 1.8
