# What's difference between static and dynamic class loading

### Static loading
We can say that class is static loading when we use * *new* * operator just like in exmaple below:
- Car car = new Car();
Class is avaliable at compile time.

### Dynami loading
Dynamic Java Class loading is mainly using the reflection.
It's sitaution when we want to get class which is not konow in compile time and we do that in runtime e.g
Class.forName("com.githubproject.model.Student")

Source:
 - https://examples.javacodegeeks.com/core-java/dynamic-class-loading-example/
