# HashMap vs TreeMap

#### Ordering 
 - **_HashMap_** doesn't provide any guarantee over the way the elements are stored in the map,
 - **_TreeMap_** items are sorted according to their natural order, [1]

#### **_NUll_** values
- **_HashMap_** allows to store at most one null key and many null values,
- **_TreeMap_** don' allow a null key but may contain manynull values,

#### Performance
	###### Operation add(), remove(), contains()
	- **_HashMap_** provides constatnt time performance O(1), to search for an element is O(1),
	**_TreeMap_** provides a performance of O(lon(n))

	###### Memory
	- **_TreeMap_** save memory becouse it only uses the amount needed to hold it;s items,
	- **_HashMap_** requires more memmory than is needed to  hold it's data,

HashTable performance depends on two parameters:
 - Initial Capacity,
 - Load Factor, 

 The capacity is the number of bucket or underlying array length.

 The load factor is a measure of how full the HasMap should be after adding some values.   

#### Unique elements
- **_HashMap_** and **_TreeMap_** dont' support dupliacted keys.

[1] If we don't want stored items according to natural order we may use of a * * Comparator* * or * * Comparable* * to define the order. 


Sources:
 - https://www.baeldung.com/java-treemap-vs-hashmap [EN]
 - https://www.baeldung.com/java-hashmap [EN]
 - https://www.baeldung.com/java-treemap [EN]


HashMap 
-the implementation is based on the the principles of a hashtable,
- key-value pairs stored in a bucket which togethe make up what is called a table (internall array),
- accept * *null* * values and keys,

