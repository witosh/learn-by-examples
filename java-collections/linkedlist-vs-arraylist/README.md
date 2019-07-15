# LinkedList vs ArrayList


##ArrayList
- based on an Array data structure
- a resizable-array implementation of the List interface
- permits all elements, including **null**, 

##LinkedList
-  represent a singly linked list,
-  each element of the LinkedList has the reference to the next element of the LinkedList,


###Search
ArrayList search operation is faster compared to LinkedList. 
 
ArrayList maintains index based system for its element. On the other side LinkedList implements doubly linked list which requires the traversal through all the elements for searching an element


###Deletion and Insertion
LinkedList remove and insertion operation has better performance (faster compared to ArrayList) while ArrayList is worst in this case.

LinkedList’s each element maintains two pointers (addresses) which points to the both neighbor elements in the list. Removal only requires change in the pointer location in the two neighbor nodes (elements) of the node which is going to be removed. While In ArrayList all the elements need to be shifted to fill out the space created by removed element. The same reson for insertion Linked list only plug in new elemnt to list by change pointers and ArrayList in case when we add element in specific index need to shifft all eleemnt and the insert eleement in this index.

###Memory
ArrayList has less consumption compared to LinkedList.

ArrayList maintanins only element data when LinkedList maintain element data and two pointers.

###Similarities
- Both implements *List* interface,
- Both maintain element insertion order (display the same order in which got inserted)
- Both are non-synchronized (can be synchronized by Collection.synchronizedList)
- Iterators for both are fail-fast. Throw  ConcurrentModificationException.
*********************************************************

ArrayList:
 - provide constant-time positional access to the element **O(1)** in contrast to linear time in LinkedList O(n),
 - not need to allocate node object for each element of `List`.

LinkedList
 - provide constatnt-time for add or delete elements from list **O(1)** in contrast to linear time in ArrayList O(n),
 - extra memory is need allocate previous and next reference,

So ArrayList it's better choose for situation when we frequently access elements. For operation sucha as add or remove elements from list better choose is **LinekedList**.

LinkedList implements:
- List,
- Deque,
interfaces

ArrayList implements:
 - List,
interface.

Source: 
 - https://books.google.pl/books?id=nS2tBQAAQBAJ&pg=PT494&lpg=PT494&dq=LinkedList+docs&source=bl&ots=3o-Sz8UXVZ&sig=ACfU3U2Mjch8UVkMduDj6UdH5yACYBL80A&hl=pl&sa=X&ved=2ahUKEwiU2ZTR_pPiAhUvxIsKHc4XDfEQ6AEwCHoECAkQAQ#v=onepage&q=LinkedList%20docs&f=false [EN]
 - https://www.geeksforgeeks.org/doubly-linked-list/ [EN]
 - https://www.geeksforgeeks.org/linked-list-set-1-introduction/ [EN]

 LinkedList:
  - https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html#get(int) [EN]

 ArrayList:
 - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html [EN]