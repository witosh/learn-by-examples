# LinkedList vs ArrayList


There asre two purpose of implementation of `List` interface.

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