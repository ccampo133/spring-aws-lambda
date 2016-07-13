This is an example AWS Lambda function using the `spring-aws-lambda`
library. You can build a jar by using the root gradle wrapper:

    ../gradlew example:build

You can then test on AWS Lambda itself if you want to. Upload the jar
and set your main handler path to `me.ccampo.example.MainHandler`.

Using AWS Lambda's built-in test tool, configure a test event with the
following structure:

    {
        "message": "Hello world!"
    }

Run the test, and you should see the following response:

    {
        "message": "Request message: Hello world!, Service A message: A, Service B message: B"
        "status": "OK"
    }
