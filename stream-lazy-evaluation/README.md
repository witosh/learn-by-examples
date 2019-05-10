# What's means that java streams are lazy evaluation

Lazy evaluation is an evaluation strategy which delays the evaluation of an expression until its value is needed.

 To  perform computation, stream operations are composed into a stream pipeline. A stream pipeline consists of:
  - a source e.g. some kind of collection (**ArrayList**),
  - intermediate operations (transform a stream into another stream, such as filter(Predicate)),
  - terminal operation (produces a result or side-effect, such as forEach(Consumer)).

Intermediate Operations:
 - map,
 - filter,
 - sorted.
 
 Terminal Operations:
 - collect,
 - forEach,
 - reduce.
  
According to documentation java streams are lazy it means that computations are performed only if the source data are needed (computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed).

Source:
 - https://www.geeksforgeeks.org/stream-in-java/
 - https://www.geeksforgeeks.org/stream-in-java/
