# Daily Java Practice

A collection of small Java exercises for exploring language behavior and concurrency. Each example focuses on a specific concept and can be run from its own `main` method where available.

## What’s inside

- `org.example` contains exercises on classes and object state, Java’s pass-by-value behavior, `try`/`finally`, and timed waiting.
- `org.example.concurrency.waitnotify` demonstrates a producer handing a message to a consumer through a shared `MessageBox`. The consumer waits for a message, and the producer signals waiting threads after publishing it.

## Run the examples

From the project root, use JDK 25 and Maven to compile and run either example.

```sh
mvn compile
java -cp target/classes org.example.Main
java -cp target/classes org.example.concurrency.waitnotify.Main
```
