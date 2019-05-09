# Types of references in java

## Strong references
When we create class Student and we want to create instance of this class by key word * *new* * e.g:
 - Student student = new Student()

In this way we create **strong reference**. Any object with an active strong reference to it, will never be garbage collected except situation just when one object have references to themself (cyclical references). This object will be eligible for garbage collector if student reference will be pointed to null.

## Soft references

## Weak references

## Phantom references

