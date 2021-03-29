# Project which helps to understand basic topics occurred in learning programming.

## Table of Contents

| No.        | Topics           | 
| ------------- |:-------------|
| 1. | [*Race condition*](#race-condition)|
| 2. | [*Data race condition*](#data-race-condition)|
| 3. | [*Programming paradigms*](#programming-paradigms)|

### Race condition

##### A race condition is a property of an algorithm

A race condition occurs when two or more threads can access shared data and they try to change it at the same time. Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the threads will attempt to access the shared data.

Therefore, the result of the change in data is dependent on the thread scheduling algorithm, i.e. both threads are "racing" to access/change the data. 

Problems often occur when one thread does a "check-then-act" (e.g. "check" if the value is X, then "act" to do something that depends on the value being X) and another thread does something to the value in between the "check" and the "act"

Sources: 
- [1](https://stackoverflow.com/a/34550)

**[⬆ Back to Top](#table-of-contents)**

### Data race condition

##### A data race is the property of an execution of a program.

Data race occurs when 2 instructions from different threads access the same memory location, at least one of these accesses is a write and there is no synchronization 

Sources: 
- [1](https://stackoverflow.com/a/18049303)

**[⬆ Back to Top](#table-of-contents)**

### Programming paradigms

Common programming paradigms includ:
- imperative in which the programmer instructs the machine how to change its state, 
--  procedural which groups instructions into procedures,
--  object-oriented which groups instructions with the part of the state they operate on,

- declarative in which the programmer merely declares properties of the desired result, but not how to compute it
-- functional in which the desired result is declared as the value of a series of function applications,
-- reactive in which the desired result is declared with data streams and the propagation of change

**[⬆ Back to Top](#table-of-contents)**