# Core Java Interview Prep

This is a Java 17 Maven project with small, runnable console examples for core Java interview preparation. The examples favor plain English comments, realistic sample data, and practical patterns over clever one-liners.

## Requirements

- Java 17
- Maven 3.8+

## Build

```bash
mvn clean package
```

## Test

```bash
mvn test
```

The test suite uses JUnit 5. It verifies that every runnable example class starts successfully and that `DemoRunner` handles topic selection, help, and unknown topics.

## Generate JavaDocs

```bash
mvn javadoc:javadoc
```

Generated documentation is written to `target/site/apidocs/index.html`.

## Run

Run every demo:

```bash
mvn exec:java
```

Run one topic group:

```bash
mvn exec:java -Dexec.args="collections"
mvn exec:java -Dexec.args="algorithms"
```

Show available topics:

```bash
mvn exec:java -Dexec.args="help"
```

Run an individual class directly after compiling:

```bash
mvn compile
java -cp target/classes com.examples.corejava.algorithms.TwoSumExample
```

Run the e-commerce real-life examples:

```bash
mvn compile
java -cp target/classes com.examples.reallife.runner.RealLifeDemoRunner all
java -cp target/classes com.examples.reallife.runner.RealLifeDemoRunner algorithms
```

The `com.examples.reallife` package mirrors the core topics with backend e-commerce
examples such as multi-warehouse fulfillment, cart pricing, inventory counters,
delivery windows, catalog lookup, promotion validation, and payment abstraction.

## Topic Index

| Topic | Package | What it teaches |
| --- | --- | --- |
| Complexity | `complexity` | Big O time and space complexity with small examples: O(1), O(n), O(n^2), O(log n), O(n log n), O(2^n), O(n!), O(1) space, and O(n) space. |
| Algorithms | `algorithms` | Interview patterns such as two-sum, sliding window, stack validation, BFS, top-k with a heap, and interval merging. |
| Collections | `collections` | List, Set, Map, queues, ordering, safe removal, grouping, conversions, duplicate handling, and common collection comparisons. |
| Sorting | `sorting` | Array and list sorting, primitives vs objects, Comparable vs Comparator, multi-field sorting, and safe integer comparison. |
| Hashing | `hashing` | HashMap basics, average O(1) lookup, equals/hashCode, custom keys, frequency counting, complement lookup, and multi-step update risks. |
| Strings | `strings` | String immutability, why concatenation creates new objects, and when StringBuilder is more appropriate. |
| OOP | `oop` | Encapsulation, inheritance, polymorphism, abstraction, interfaces, abstract classes, composition, overloading, overriding, coupling, and cohesion. |
| Exceptions | `exceptions` | `final`, `finally`, obsolete `finalize`, checked exceptions, and unchecked exceptions. |
| Streams | `streams` | Loops vs streams, lambdas, and functional-style collection processing. |
| Optional | `optional` | Optional creation, fallback values, mapping, filtering, and avoiding direct null checks. |
| Concurrency | `concurrency` | Threads, Runnable, `start()` vs `run()`, synchronization, shared state, HashMap risks, ConcurrentHashMap, and atomic map methods. |
| GC | `gc` | Reachability, eligibility for garbage collection, `System.gc()` as a request, and avoiding unnecessary objects. |

## DemoRunner Topics

`DemoRunner` accepts these arguments:

- `all`
- `complexity`
- `algorithms`
- `collections`
- `sorting`
- `hashing`
- `strings`
- `oop`
- `exceptions`
- `streams`
- `optional`
- `concurrency`
- `gc`
- `help`

Examples are intentionally short. Read the source files alongside the console output; many classes include comments with expected output and complexity notes.
