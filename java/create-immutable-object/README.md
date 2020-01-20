# How to create immutable object
Here we have principles to create such object:
- declare class as a final to prevent override methods by subclasses,(another approach constructor private and construct instances in factory methods)
- make * *private* * and * *final* * fields of class,
- don't provide any methods that modify fields of class like **setters**,
- if instance contains * *mutable* * object provide mechanism to don't allow this object changed e.g. create copies of this mutable object. 

Sources:
- https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html [EN]
