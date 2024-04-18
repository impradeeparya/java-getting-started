# Garbage Collection

Overview of garbage collection in Java, which automatically reclaims unused memory by destroying unused objects.
Contrast with languages like C and C++ where programmers are responsible for both object creation and destruction, leading to potential memory leaks if objects are not properly managed.

## Process of Garbage Collection

Java programs compile into bytecode running on a Java Virtual Machine (JVM), with objects created in the Heap Space.
Differentiating between alive and dead objects, with garbage collection detecting and deleting unused objects to free up memory automatically.

## Phases of Garbage Collection

  ### Marking objects as alive: 
  1. GC identifies alive objects by traversing the object graph, marking them as accessible.
  2. Sweeping dead objects: Memory fragments containing dead objects are released.
  3. Compacting remaining objects: Ensures memory is compact after deletion of dead objects, optimizing memory usage.

## Generational Garbage Collection

Generational garbage collection strategy categorizing objects by age, dividing the heap memory into Young Generation, Old Generation, and Permanent Generation (replaced by MetaSpace in Java 8).
Objects move between generations based on their lifespan, with minor and major garbage collection events.

## Types of Garbage Collectors:

  ### Serial GC: 
  > Simplest implementation for small applications running on single-threaded environments, leading to stop-the-world events during garbage collection.
  ### Parallel GC: 
  > Designed for medium to large applications on multi-threaded hardware, conducting garbage collection with multiple threads.
  ### Concurrent Mark Sweep (CMS) GC: 
  > Runs concurrently alongside application processes to minimize stop-the-world events, suitable for multi-threaded environments.
  ### Garbage First (G1) GC: 
  > Default collector in Java, designed for multi-threaded applications with large heap sizes, utilizing region-based memory management.
  ### Epsilon GC: 
  > A do-nothing garbage collector suitable for applications with known memory footprints or garbage-free applications.
  ### Shenandoah GC: 
  > Concurrent GC that performs garbage collection cycle work concurrently with application threads, reducing pause times.
  ### ZGC: 
  > Intended for applications requiring low latency and large heap sizes, allowing the application to continue running during garbage collection operations.
  > Application continue to perform while it perform all GC opertions.
  > Low pause time

## Advantages of Garbage Collection:
1. Simplifies code by automating memory management, eliminating the need for manual memory assignment and release cycles.
2. Improves memory efficiency by removing unreferenced objects from heap memory, making space for new objects.
3. Despite debates over manual memory management, garbage collection is now a standard component of many popular programming languages.

## Conclusion:
1. Recap of the benefits of garbage collection in Java and its role in simplifying memory management.
2. Acknowledgment of the standardization of garbage collection across various programming languages.
3. Gratitude to the viewers for watching and encouragement to stay tuned for future content.


# Features
## Java 11 Features:
1. **New String Class Methods:** Java 11 introduced several new methods to the String class, including `isBlank`, `lines`, `strip`, `stripLeading`, `stripTrailing`, and `repeat`. These methods facilitate string manipulation and formatting.
2. **Collections API Enhancements:** The `List`, `Map`, and `Set` interfaces gained a new static method called `copyOf`, which returns an unmodifiable copy of the given collection. Additionally, the Stream API received the `toUnmodifiableList` method.
3. **Stream API Improvements:** Java 11 added a `not()` method to the `Predicate` interface for negating predicates, and an `elseThrow` method to the `Optional` interface for throwing exceptions if no value is present.
4. **Try-With-Resources Enhancement:** Developers can now manage resources without declaring a new variable using the try-with-resources statement if the resource is referenced by a final or effectively final variable.
5. **Private Methods in Interfaces:** Java 11 introduced the ability to add private methods to interfaces, allowing developers to split lengthy default methods for better code organization.
6. **NIO Package Enhancements:** New methods `writeString` and `readString` were added to the NIO package for writing and reading strings to and from files.
7. **HTTP Client API:** The HTTP client API now uses the builder pattern, making it easier to create, define, and use HTTP requests.

## Java 17 Features:
1. **String Class Enhancements:** Java 17 introduced the `indent` and `transform` methods to the String class, providing additional functionality for adjusting indentation and applying transformations to strings.
2. **Stream API Additions:** The `Collectors` class in the Stream API gained the `teeing` method, which processes elements in a stream with two downstream collectors and merges their results.
3. **Pattern Matching for `instanceof`:** Java 17 introduced pattern matching for `instanceof`, allowing developers to initialize variables and use them within the `instanceof` check without additional casting.
4. **Improved NullPointerException Messages:** NullPointerException messages in Java 17 provide more detailed information, including the exact location where the exception occurred.
5. **Records:** Records enable the creation of immutable data classes with concise syntax, reducing boilerplate code.
6. **Sealed Classes:** Sealed classes provide more control over which classes can extend a superclass, enhancing encapsulation and security in class hierarchies.
