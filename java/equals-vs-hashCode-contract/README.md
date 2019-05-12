# hashCode vs equals contarct

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

 Sources: 
 - [1] https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode() [EN]
 - [2] https://www.baeldung.com/java-equals-hashcode-contracts [EN]
