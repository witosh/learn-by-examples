# Java questions & answers 

## Table of Contents

| No.        | Topics           | 
| ------------- |:-------------|
| 1. | [*Interfaces in Java 8*](#interfaces-in-java-8)|
| 2. |[*Dimond problem*](#diamond-problem)|
| 3. |[*Why String is immutable in Java?*](#why-string-is-immutable-in-java)|
| 4. |[*String Pool in Java*](#string-pool-in-java)|
| 5. |[*How many Strings are getting created?*](#How-many-strings-are-getting-created)|
| 6. |[*Difference between Abstract Class and Interface in Java*](#difference-between-abstract-class-and-interface-in-java)   |
| 7. |[*How to create immutable object?*](#how-to-create-immutable-object)|
| 8. |[*What is difference between static and dynamic class loading?*](#what-is-difference-between-static-and-dynamic-class-loading)|
| 9. |[*hashCode vs equals contarct*](#hashCode-vs-equals-contarct)|
| 10. |[*Types of references in java*](#types-of-references-in-java)|
| 11. |[*Overriding in Java*](#overriding-in-java)|
| 12. |[*Internal vs External Iteration*](#internal-vs-external-iteration)|
| 13. |[*What means that java streams are lazy evaluation?*](#what-means-that-java-streams-are-lazy-evaluation)|
| 14. |[*Differences between Intermediate Operations and Terminal Operations*](#differences-between-intermediate-operations-and-terminal-operations)|
| 15. |[*Reasons for default methods in interface*](#reasons-for-default-methods-in-interface)|
| 16. |[*Reasons for static methods in interface*](#reasons-for-static-methods-in-interface)|


### Interfaces in Java 8

General intefrace 
- interface is designed for polymorphism,
- interface can contain constant declarations,
- constant values defined in an interface are implicitly public, static, and final
- methods of an interface are abstract methods (before Java 8),
- introduce default methods and static methods in the interfaces,
- default methods require default implementation,
- it is not mandatory to provide implementation for default methods of interface,
- java interface static method is visible to interface methods only

In Java SE 8, We can provide method implementations in Interfaces by using the following two new concepts:
- Default Methods
- Static Methods

A Static Method is an Utility method or Helper method, which is associated to a class.

#### Java Interface Default Method and diamon problem

By default it is not mandatory to provide implementation for default methods of interface.

The diamond problem is occured if both interfaces have default methods of this same signature like below.  

So to make sure, this problem won’t occur in interfaces, it’s made mandatory to provide implementation for common default methods of interfaces. So if a class is implementing both the above interfaces, it will have to provide implementation for log() method otherwise compiler will throw compile time error
```java
public interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
}

public interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
	}
```

[Java and multiple inheritance](https://www.geeksforgeeks.org/java-and-multiple-inheritance/)

#### Functional interface

 An interface with exactly one abstract method is known as Functional Interface. @FunctionalInterface annotation marks an interface as Functional Interface. Annotation vvoid accidental addition of abstract methods in the functional interfaces (throw compilation error). It enables us to use lambda expressions to instantiate them.

[Source EN ](https://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method)

**[⬆ Back to Top](#table-of-contents)**

### Diamond problem

```java
class GrandParent 
{ 
    void fun() 
    { 
        System.out.println("Grandparent"); 
    } 
} 

class Parent1 extends GrandParent 
{ 
    void fun() 
    { 
        System.out.println("Parent1"); 
    } 
} 

class Parent2 extends GrandParent 
{ 
    void fun() 
    { 
        System.out.println("Parent2"); 
    } 
} 
  
// Error : Test is inheriting from multiple classes 
class Test extends Parent1, Parent2 
{ 
   public static void main(String args[]) 
   { 
       Test t = new Test(); 
       t.fun(); 
   } 
} 
```
Calling the method fun() using Test object will cause complications such as whether to call Parent1’s fun() or Child’s fun() method.

Therefore, in order to avoid such complications Java does not support multiple inheritance of classes.
```
  A
 / \
B   C
 \ /
  D
```

[Java and multiple inheritance](https://www.geeksforgeeks.org/java-and-multiple-inheritance/)

**[⬆ Back to Top](#table-of-contents)**

### Why String is immutable in Java?

- String pool is possible only because String is immutable in Java,
- Since String is immutable, it is safe for multithreading,
- Strings are used in java classloader and immutability provides security that correct class is getting loaded by Classloader,
- Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again,
- If String is not immutable then it would cause a severe security threat 

[Source en](https://www.journaldev.com/802/string-immutable-final-java)

**[⬆ Back to Top](#table-of-contents)**

### String Pool in Java

String Pool in java is a pool of Strings stored in Java Heap Memory. 
String Pool is possible only because String is immutable in Java. 
String pool is also example of Flyweight design pattern.

When we use double quotes to create a String, it first looks for String with the same value in the String pool, if found it just returns the reference else it creates a new String in the pool and then returns the reference.

However using new operator, we force String class to create a new String object in heap space. 

An intern() method it can be used to return string from memory, if it is created by new keyword. It creates exact copy of heap string object in string constant pool.

```java
public class InternExample{  

	public static void main(String args[]){  
		String s1=new String("hello");  
		String s2="hello";  
		String s3=s1.intern();//returns string from pool, now it will be same as s2  
		System.out.println(s1==s2);//false because reference variables are pointing to different instance  
		System.out.println(s2==s3);//true because reference variables are pointing to same instance  
	}
}  
```
[Java string intern](https://www.javatpoint.com/java-string-intern)
[String pool](https://www.journaldev.com/797/what-is-java-string-pool)

**[⬆ Back to Top](#table-of-contents)**

### How many Strings are getting created?

```java
String str = new String("Cat");
```
In the above statement, either 1 or 2 string will be created. If there is already a string literal “Cat” in the pool, then only one string “str” will be created in the pool. If there is no string literal “Cat” in the pool, then it will be first created in the pool and then in the heap space, so a total of 2 string objects will be created.

[Created strings](https://www.journaldev.com/797/what-is-java-string-pool)

**[⬆ Back to Top](#table-of-contents)**

### Difference between Abstract Class and Interface in Java

| **Interface** | **Absract classe** |
| ------------- |:-------------:|
| _interface_ keyword	| _abstract_ keyword|
| subclass _implements_ interface| subclass _extends_ abstract class|
| can have abstract, default, static methods | can have abstract methods or impllemented methods |
| subclass can implements one or more interfaces| subclass can extends only one abstract class|


**[⬆ Back to Top](#table-of-contents)**

### How to create immutable object?

Here we have principles to create such object:
- declare class as a final to prevent override methods by subclasses,(another approach constructor private and construct instances in factory methods)
- make * *private* * and * *final* * fields of class,
- don't provide any methods that modify fields of class like **setters**,
- if instance contains * *mutable* * object provide mechanism to don't allow this object changed e.g. create copies of this mutable object. 

Sources:
- https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html [EN]

**[⬆ Back to Top](#table-of-contents)**

### What is difference between static and dynamic class loading?

#### Static loading
We can say that class is static loading when we use * *new* * operator just like in exmaple below:
- Car car = new Car();
Class is avaliable at compile time.

#### Dynami loading
Dynamic Java Class loading is mainly using the reflection.
It's sitaution when we want to get class which is not konow in compile time and we do that in runtime e.g
Class.forName("com.githubproject.model.Student")

Source:
 - https://examples.javacodegeeks.com/core-java/dynamic-class-loading-example/ [EN]

**[⬆ Back to Top](#table-of-contents)**

### hashCode vs equals contarct

Firstly we should say that there is relationship between this two base methods in Java language this relationship is called **contract**. According to documentation both methods have definitions:
 - **hashCode** - return hash code value for object [1],
 - **equals** - indicates if some object A is 'equal' to object B e.g. A.equals(B) [1].
 
###### hashCode vs equals 
  
If **two objects are equal** then **they should have the same hashcode** and if **two objects are not equal** then **they may or may not have same hash code**.

###### If we don't override methods

In case we don't override equals() e.g
 - call equals on objects A and B it will return * *false* * and hashCode will be different. The answer is in this part of docs (* *The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).* * [1])
 , so in our case it's two different instances thats why we get false. 

###### Override equals method

**If we override equals() method, we must also override hashCode()** method becouse of 2nd criteria of hashCode() method contract (* *If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.* * [1]).
In case when we override only equals() method, hasCode() use default **Object** class method implementation, so in this case when we don't override hashCode() we break 2nd criteria e.g. 
 - object A and B wil be equal but the hashCode() of this objects will be different!!!

Contract between this two methods it's very important when we want to use our objects as a **key** in hash-based collection e.g. **HashMap** [[2] 3.3].

There are many libraries to implements equals and hashCode or verifies class to check if contract is fullfiled.([2] 5, 6) 

equals() method relation:
- It is reflexive: for any non-null reference value x, x.equals(x) should return true.
- It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
- It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
- It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
- For any non-null reference value x, x.equals(null) should return false.

[Let's check code](https://github.com/witosh/learn-by-examples/tree/master/java/equals-vs-hashCode-contract)

 Sources: 
 - [1] https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode() [EN]
 - [2] https://www.baeldung.com/java-equals-hashcode-contracts [EN]

**[⬆ Back to Top](#table-of-contents)**

### Types of references in java

They are **strong** and **weak** references. For weak references we can distinguish **soft** and **phantom**.

#### Strong references
Most ubiquitous form of references is strong reference. To create such reference we need to use keyword * *new* * e.g:
 - Student student = new Student()

In this way we create **strong reference**. A strong reference is very important in the theme of Java Garbage collector. Any object with an active such reference to it, will never be garbage collected except situation just when one object have references to themself (cyclical references). This object will be eligible for garbage collector if * *student* * reference will be pointed to null e.g:
 - student = null

#### Soft references

To create soft reference to an object (Student) you need to first create strong reference to that object and then pass this  strong reference as a argument to the constructor of **SoftReference** object e.g:
 - Student student = new Student()
 - SoftReference<Student> softReference = new SoftReference<Student>(student);
 
So as is shown below we create strong references **student** (Object is created and allocated on heap memory). Then we create strong references **softReference** (Object is created and allocated on heap memory) in both cases strong references exists on heap memory. **softReference** contains internally reference to object passed by a constructor.
 
 In short soft references objects:
 - are cleared by garbage collector in response to memory demand,
 - are used to implement memory-sensitive caches,
 - **are guaranteed to have been cleared before the virtual machine throws an OutOfMemoryError**. 
 
 Usefully of soft reference:
 The garbage collector runs at this point of time and in the same time strong reference **student** start point to null:
 - student = null
 The garbage collector will see that this current object **student** have only soft reference (no strong reference!!!). In this case GC could may demand the memory used by the **student** object but in any point of time if GC has not yet reclaimed the memory of this object we can get strong references this object (* *referent* *):
 - Student resurrectedStudent = softReference.get();
In this situation object **student** is not eligible for garbage collector anymore.
 
#### Weak references
The schema of craete weak reference is the same as above in soft references with one small exception that we use new class called **WeakReference**:
- Student student = new Student()
- WeakReference<Student> weakReference = new WeakReference<Student>(student);

Weak reachability means that an object has neither strong nor soft references pointing to it. The object can be reached only by traversing a weak reference.
First off, the Garbage Collector clears a weak reference, so the referent is no longer accessible. Then the reference is placed in a reference queue (if any associated exists) where we can obtain it from.
At the same time, formerly weakly-reachable objects are going to be finalized.


#### Phantom references
The schema of create phantom reference is the similar as above but in this case we need to create **ReferenceQueue** object:
- Student student = new Student()
- ReferenceQueue<Student> referenceQueue = new ReferenceQueue<Student>(); 
- PhantomReference<Student> phantomRef = new PhantomReference<Student>(student,referenceQueue)

We can't get a referent of a phantom reference. The referent is never accessible directly through the API and this is why we need a reference queue to work with this type of references.

The Garbage Collector adds a phantom reference to a reference queue after the finalize method of its referent is executed. It implies that the instance is still in the memory.

ReferenceQueues are some sort of a queue where the JVM can store objects of type reference once it has decided to take some action on the objects to which they refer.

A phantom reference is directly eligible for garbage collector.When it's garbage collection this type of reference is enqueued in the queue **referenceQueue** after finalize() method has been executed. The get() method of a phantom reference always returns null. An object is phantomly referenced after it has been finalized, but before its allocated memory has been reclaimed.
Used only to know when an object is removed from memory.

They are operationally defined as follows:
- An object is **strongly reachable** if it can be reached by some thread without traversing any reference objects. A newly-created object is strongly reachable by the thread that created it.
- An object is **softly reachable** if it is not strongly reachable but can be reached by traversing a soft reference.
- An object is **weakly reachable** if it is neither strongly nor softly reachable but can be reached by traversing a weak reference. When the weak references to a weakly-reachable object are cleared, the object becomes eligible for finalization.
- An object is **phantom reachable** if it is neither strongly, softly, nor weakly reachable, it has been finalized, and some phantom reference refers to it.
- Finally, an object is unreachable, and therefore eligible for reclamation, when it is not reachable in any of the above ways.

Sources:
 - https://dzone.com/articles/reference-types-java-part-1 [EN]
 - https://docs.oracle.com/javase/7/docs/api/java/lang/ref/PhantomReference.html [EN]
 - https://docs.oracle.com/javase/7/docs/api/java/lang/ref/SoftReference.html [EN]
 - https://docs.oracle.com/javase/7/docs/api/java/lang/ref/WeakReference.html [EN]
 - https://stackoverflow.com/questions/9809074/java-difference-between-strong-soft-weak-phantom-reference [EN]

**[⬆ Back to Top](#table-of-contents)**

### Overriding in Java

#### How Java Overriding Works?
- The method signature must be exactly the same in the superclass and the subclass.
- When the instance is created, subclass constructor must be used.
- At the compile time, the variable refers to the superclass. However, in runtime, it refers to the subclass object.
- When the method is called on the variable, it looks like the superclass method will be called. But the method is present in the subclass object, hence it’s called.

#### Java @Override Annotation

When we want to override a method of Superclass, we should use this annotation to inform compiler that we are overriding a method. So when superclass method is removed or changed, compiler will show error message.

If you uncomment the @Override annotation in subclass, you will get following compile-time error message:
```
The method doSomething(String) of type ChildClass must override or implement a supertype method
```
Java @Override annotation will make sure any superclass changes in method signature will result in a compile-time error and you will have to do necessary changes to make sure the classes work as expected.

It’s better to resolve potential issues at compile time than runtime. There coulde be situation happened when you try to override method on subclass but then for a couple days you change a signature of this method, so it could change behaviour of your subclass.

[Java @Override Annotation](https://www.journaldev.com/817/java-override-method-overriding)

**[⬆ Back to Top](#table-of-contents)**

### Internal vs External Iteration

#### External iteration

The collections framework relied on the concept of external iteration, where a Collection provides, by implementing Iterable, a means to enumerate its elements i.e. Iterator, and clients use this to step sequentially through the elements of a collection. 

```java
public class IterationExamples {
    public static void main(String[] args){
        List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});
         
        for(String letter: alphabets){
            System.out.println(letter.toUpperCase());
        }
    }
}
```
or

```java
public class IterationExamples {
    public static void main(String[] args){
        List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});
         
        Iterator<String> iterator = alphabets.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toUpperCase());
        }
    }
}
```

External iteration is straightforward enough, but it has several problems:

1) Java’s for-each loop/iterator is inherently sequential, and must process the elements in the order specified by the collection.
2) It limits the opportunity to manage the control flow, which might be able to provide better performance by exploiting reordering of the data, parallelism, short-circuiting, or laziness.

The alternative to external iteration is internal iteration, where instead of controlling the iteration, client let it handle by library and only provide the code which must be executed for all/some of data elements.

```java
public class IterationExamples {
    public static void main(String[] args){
        List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});
         
        alphabets.forEach(l -> l.toUpperCase());
    }
}
```

Summary:
- external iteration mixes the “what” (uppercase) and the “how” (for loop/iterator),
- internal iteration lets the client to provide only the “what” but lets the library control the “how”

[Internal vs External Iteration](https://howtodoinjava.com/java8/java-8-tutorial-internal-vs-external-iteration/)

**[⬆ Back to Top](#table-of-contents)**

### What means that java streams are lazy evaluation?

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
 - https://www.geeksforgeeks.org/stream-in-java/ [EN]
 - https://www.geeksforgeeks.org/stream-in-java/ [EN]

**[⬆ Back to Top](#table-of-contents)**

### Differences between Intermediate Operations and Terminal Operations

| **Intermediate Operations ** | **Terminal Operations** |
| ------------- |:-------------:|
|_Stream Intermediate operations are not evaluated until we chain it with Stream Terminal Operation|Stream Terminal Operations are evaluated on it’s own. No need other operations help.|
|The output of Intermediate Operations is another Stream|The output of Intermediate Operations is Not a Stream. Something else other than a Stream|
|The output of Intermediate Operations is Not a Stream. Something else other than a Stream|Terminal Operations are evaluated Eagerly|
|We can use any number of Stream Intermediate Operations per Statement|We can use only one Stream Terminal Operation per Statement|

[Differences between Intermediate Operations and Terminal Operations](https://www.journaldev.com/10081/javase8-interview-questions-part2#java-se-8-interview-questions)

**[⬆ Back to Top](#table-of-contents)**

### Reasons for default methods in interface

We need Default Methods because of the following reasons:

- it allow us to provide method’s implementation in Interfaces,
- to add new Functionality to Interface without breaking the Classes which implement that Interface,
- to provide elegant Backwards Compatibility Feature,
- to ease of extend the existing Functionality,
- to ease of Maintain the existing Functionality,

[Reasons for default methods in interface](https://www.journaldev.com/10081/javase8-interview-questions-part2#java-se-8-interview-questions)

**[⬆ Back to Top](#table-of-contents)**

### Reasons for static methods in interface

We need Static Methods because of the following reasons:
- keep Helper or Utility methods specific to an interface in the same interface rather than in a separate Utility class,
- do not need separate Utility Classes like Collections, Arrays etc to keep Utility methods,
- easy to extend the API,
- easy to Maintain the API,

**[⬆ Back to Top](#table-of-contents)**