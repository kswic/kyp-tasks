Below you can find few notes about the implementation details. 

#### Implementation details

I've been using JDK12 implementing those tasks. 

#### Task 1.

Solution has been located in ai.kyp.islands package which contains:
- MapGenerator - generating maps for tests.
- IslandsAreaService - main implementation of count algorithm.
- SolveMapRunner - console app that accepts text file with a map and return message with number of islands.

It can handle maps up to 10,000x10,000 currently, it's limited to this size which is checked by `IslandsAreaService`. 

It can be also set to 100,000x100,000. It needs 10g of RAM in that case which should be set in VM arguments `-Xmx10100m` when run from IDE. Or by adding below fragment to Maven's pom file. Extra 100m is for test case checking size validation. Ensure that you have that much free RAM before running it with increased size limit otherwise JVM will crash.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.2</version>                 
    <configuration>
        <argLine>-Xmx10100m</argLine>
    </configuration>
</plugin>
```
#### Task 2.

Solution has been located in ai.kyp.taskqueue package which contains:
- ExpressionGenerator with default implementation - generates basic arithmetical expressions. 
- Two implementations of ExpressionSolver - solve generated expressions, Nashorn implementation has been marked as deprecated as the Nashorn engine has be removed in JDK 15.
- TaskConsumer and TaskProducer - thread classes for producing and consuming tasks which are simple strings with expressions to compute
- TaskQueueRunner - application running task queue, tasks are put in 'BlockingQueue' by two producers and consumed by four consumers. Default size of the queue is 10.

---

#### Tasks to implement
#### Task 1. At the beginning of this task, you are given a two-dimensional array that visualizes a map. Each element of this array will take one of the following values:
0 (which represents water), 1 (which represents land).

These values will form islands on water. For example:
```text
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 1 0 0 0 1 0 0
1 1 0 0 0 1 1 1 0
0 0 0 0 0 1 1 0 0
0 0 1 0 0 0 0 0 0
1 1 0 0 0 0 0 0 0
0 0 0 0 0 1 1 0 0
```

(This example illustrates 4 islands. Counting from left upper corner: First Island is made of six land elements, Second Island is also made of six land elements. Third island consists of 3 elements, and the last one is made of two elements).

Write a short program, which will count the number of islands. The following data structure could be varying in size. Take into assumption, that data structure given to you could be very large in size, so beware of implementation that could result in stack overflow or out-of-memory exception.

#### Task 2. Build an application that will consist of two components:

TaskProducer
TaskConsumer

Both start to run on application startup and share the global queue (based on the list, queue, the exact structure is your decision). TaskProducer generates random tasks and adds them to this queue (Task object, which is the task explained below) until the queue is full (ie, it reaches a configurable maximum limit defined by a constant, a parameter configurable in the application, etc.). Once the queue is full TaskProducer stops producing tasks and waits (periodically polling the queue) until its size drops to half of the maximum size and starts producing tasks again.

During this time, TaskConsumer retrieves a task from the job queue (if exists) and executes it.

What is the task? The task is a randomly generated character string in the range of "0-9 + / * -" (eg. 5 + 4, 323/65323 * 24323/2343 + 2234-2233), which analyzes this string, calculates its value according to the formula and writes the result to the console.

Please create at least 2 TaskProducers working in separate threads and min. 4 TaskConsumers, also working in separate threads.