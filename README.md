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
