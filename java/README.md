# Java questions & answers 

## Table of Contents

| No.        | Topics           | 
| ------------- |:-------------:|
| 1. | [*Interfaces in Java 8*](#interfaces-in-java-8) |
| 2. | [*Dimond problem*](#diamond-problem)    |
| 3. | [*Why String is immutable in Java?*](#why-string-is-immutable-in-java)   |
| 4. | [*String Pool in Java*](#string-pool-in-java)   |
| 5. | [*How many Strings are getting created?*](#How-many-strings-are-getting-created)   |
| 6. | [*Difference between Abstract Class and Interface in Java*](#difference-between-abstract-class-and-interface-in-java)   |
| 7. | [*How to create immutable object?*](#how-to-create-immutable-object) |


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