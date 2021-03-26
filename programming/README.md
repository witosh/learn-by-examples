# Project which helps to understand basic topics occurred in learning programming.

## Table of Contents

| No.        | Topics           | 
| ------------- |:-------------|
| 1. | [*Race condition*](#race-condition)|
| 2. | [*Data race condition*](#data-race-condition)|
| 3. | [*Programming paradigms*](#programming-paradigms)|

### Race condition

#####A race condition is a property of an algorithm

A race condition occurs when two or more threads can access shared data and they try to change it at the same time. Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the threads will attempt to access the shared data.

Therefore, the result of the change in data is dependent on the thread scheduling algorithm, i.e. both threads are "racing" to access/change the data. 

Problems often occur when one thread does a "check-then-act" (e.g. "check" if the value is X, then "act" to do something that depends on the value being X) and another thread does something to the value in between the "check" and the "act"

Source: https://stackoverflow.com/a/34550

### Data race condition

#####A data race is the property of an execution of a program.

Data race occurs when 2 instructions from different threads access the same memory location, at least one of these accesses is a write and there is no synchronization 

Source: https://stackoverflow.com/a/18049303


###Programming paradigms

Common programming paradigms includ