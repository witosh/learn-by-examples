# Types of references in java

They are **strong** and **weak** references. For weak references we can distinguish **soft** and **phantom**.

## Strong references
Most ubiquitous form of references is strong reference. To create such reference we need to use keyword * *new* * e.g:
 - Student student = new Student()

In this way we create **strong reference**. A strong reference is very important in the theme of Java Garbage collector. Any object with an active such reference to it, will never be garbage collected except situation just when one object have references to themself (cyclical references). This object will be eligible for garbage collector if * *student* * reference will be pointed to null e.g:
 - student = null

## Soft references

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
 
## Weak references
The schema of craete weak reference is the same as above in soft references with one small exception that we use new class called **WeakReference**:
- Student student = new Student()
- WeakReference<Student> weakReference = new WeakReference<Student>(student);

Weak reachability means that an object has neither strong nor soft references pointing to it. The object can be reached only by traversing a weak reference.
First off, the Garbage Collector clears a weak reference, so the referent is no longer accessible. Then the reference is placed in a reference queue (if any associated exists) where we can obtain it from.
At the same time, formerly weakly-reachable objects are going to be finalized.


## Phantom references
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