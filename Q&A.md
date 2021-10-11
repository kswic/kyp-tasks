Please answer the following questions. We would like to know your opinion in each so please avoid any copy & paste.

1) SOLID Rules - how you understand the ‘S’ (SRP) - please describe in your words, what is important to you, where the rule applies, what is your experience with this rule, is there any drawbacks of it?

It's about applying one responsibility to a unit of code at any level, variable, method, class, package, module, system. Drawback can be too many small modules that can be expensive to implement but then easier to maintain. Part of code with one responsibility is much easier to reuse.

3) What in your opinion is the most important and why in any project: Clean Code, Tests, Technology stack, Methodology.

I would say tests because they say how the system/application works and assure that it works correctly and consistently. I guess it's the most important goal of the software development. Clean code is also important, but it's much easier to refactor code and make it clean when we have great tests that confirm that code is still work as expected.   

3) Kanban vs Scrum - which you prefer and why?

I haven't worked in Kanban yet but seems to be good solution as it does not complicate things like Scrum. I worked in great waterfall which no one likes, it's so unpopular. Scrum is overcomplicated in my opinion with all those meeting consuming time of everyone when not everyone is interested. It may be good for small teams. Especially I don't like the retrospective and constantly talking about some often meaningless problems or other ones that can be solved easily between the team members without waiting for the meeting. Besides, planning tasks and showing results make sense. Also, I'm fine with daily stand-up meetings, but they don't have much sense when team has 20 members. Scrum is sometimes too much team centric, I think that it's better to leave some decisions to architect, experienced team lead. Sometimes there is no lead, just a team leading by democracy, a lot of talking, explaining. I just don't like Scrum in big teams. It may work fine to 5 people. I experienced situation when there was no stories for everyone because of the amount of team members and calculated capacity. Then pair programming may be a solution, but it doesn't always work. So, maybe Kanban is the answer, it solves most important issues: what should be done and what is the status of the work.        

4) How do you test your code - do you use specific methodology, what kind of tools do you use, what kind of tests do you implement and what should be the distribution of particular test types, how you understand  ‘contract tests’ approach?

I'm trying all possible ways to test the functionality to be sure it meets the requirements. From unit test, integration tests, performance tests to executing in the target environment (usually UAT or local machine if it's possible) with manual tests. I'm also use debugging a lot and create regression tests for new edge cases. There is a pyramid of tests that defines the distribution of them with the unit tests at the bottom in the greatest amount, through integration test, performance, etc. and end to end and acceptance tests at the top. Contract tests test the contracts defined at the joint of modules, systems like client-server or producer-consumer. We want to be sure that the communication will work and use the correct up-to-date contract in the right way.  

5) What do you think - how code should be organized - by layer, by type, by feature?

What do you mean by "by type"? If it's a type like a class then I would say yes - by type. Like in DDD approach, when type may represent domain object. 

6) Builder vs Factory – what’s the difference, which should be used when. 

The Factory is used to build entire object in a single method call. It constructs object of a specified type, usually by using its constructor and setting up all its dependencies. Factory can create objects of different classes implementing the same interface. Builder is another manufacturing pattern used when object can't be created in one single step or needs a lot of setup work that can produce different behavior of the created object depends on requirements. It prevents from creation of different constructors. It can also prepare some default setup that can be customized later on.

7) “TDD is a way to design” - true or not (and why)?

True, it may be a way of design. Because we usually design a feature that is used by some client. With TDD approach we can start from the client perspective and define some given conditions and expected results of code reaction on those conditions. So, starting from the requirements we can first design the client view which is represented by interfaces, method signatures and so on. It's pure design without implementing those things. It lets you think about the design without going into details of implementation and notice some dependencies earlier than after spending hours on implementation that may not match the expectations or requirements. 

8) What is the last programming book you have read?

I guess there may be not many books I've read from start to the end. I usually read fragments that I currently need, or I read from the beginning to almost the end. Currently, I'm trying to prepare myself to OCP exams for Java 11 and reading study guide when I have some free time. I'm also looking for some things I need for my current work. So, I've been reading a bit about RxJava from "Learning RxJava" book and some XSLT book to find some solutions there.

9) What do you think about refactoring, please share your experience and approach?

Refactoring is a constant process for me. I often try to make something better every time I come back to some old code. I always try to improve the code even it's not mine. Sometimes there are simple things like formatting, removing unused imports, variables or methods. I don't like to leave unused or commented code in the code base. I'm also trying to make some improvements when it's possible. Like recently, when I had to improve performance of the code for processing data set that had to be increased a lot. And old code couldn't work with such amount of data. Sometimes I make changes that makes code easier to read or make it more concise, but when the changes are more serious I'm adding new test cases to assure that nothing will go wrong after that.

10) Generalization vs Composition - what should be preferred and why?

It depends, but composition is more safe because makes code less dependent, which in result is easier to maintain and expand. Sometimes we want to have share some common properties by a set of objects that are highly related, then we can use generalization and inheritance. But it may get complicated when inheritance hierarchy gets bigger, and we want to add some new property or functionality that we want to be inherited but some classes but not the other that can make troubles. Like requirement of implementing not needed methods or the need to handle some side effects. That's why composition is recommended.    

11) Please estimate man-hours/days for the following task:
“Build an application in Java which will read file logs from a specific directory (set by parameter) then send the content of all logs to REST endpoint. After sending archive already sent logs - move them to ‘archived’ directory.

It depends. I would have first few questions about the details. Especially about the REST endpoint and its contract, can I send whole file or only one log entry. I also don't know the amount of logs, the amount, size and frequency of creating those logs to send. They may be produced faster than it's possible to send, so there may be required some buffer. I'm also wondering how this app will be used. Will it be executed once a day to send the logs from the previous day, or it will be constantly running and monitoring files content and sending every new entry right away when it appears. When it's just sending data from files without bothering about such details it can be even from few hours to 1 man day assuming that we just read files present in the directory, then send, archive and exit to be started another time to do the same thing. Without details, I can see some risks that can increase the implementation time to days or maybe even weeks. It's really hard to say.   

