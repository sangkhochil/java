# java
All java tutorials

## Default capacity
* ArrayList-10
* Vector-10
* HashSet-16
* HashMap-16
* HashTable-11
* HashSet-16


## HashMap
* HashMap implements Map an interface that maps a key to value.
* It is not synchronized and is not thread-safe.
* Duplicate keys are not allowed
* One null key and multiple null values are allowed
* t is the unordered collection and does not give a guarantee for any specific order of elements.

## LinkedHashMap
* LinkedHashMap implements Map interface and extends HashMap class.
* LinkedHashMap maintains insertion order, so when you will be able to access elements in the order they were inserted like ArrayList.
* LinkedHashMap maintains doubly Linked list to maintain insertion order.
* It is not synchronized and is not thread-safe.
* Duplicate keys are not allowed
* One null key and multiple null values are allowed

## HashMap Vs LinkedHashMap
  LinkedHashMap ordered list and maintains doubly Linked list to maintain insertion order
  
## TreeMap
* TreeMap implements Map interface and extends HashMap class.
* TreeMap is implemented using Red black tree based NavigableMap.
* TreeMap is ordered collection and store its elements in natural ordering of keys.
* Key which you would like to put in TreeMap must implement Comaparable interface or you can use Comparator for custom sorting

## HashSet
* It can contain only unique element.
* It is not synchronized and is not thread-safe.
* Not allowed dublicate entity, Definition of duplicate can be quite tricky (custom defined objects)

## TreeSet
* It can contain only unique element.
* It stores objects in ascending order by default,
* It implements NavigableSet interface which extends SortedSet.
* When you put objects in TreeSet, it must implement Comparable interface.

## LinkedHashSet
* LinkedHashSet implements Set interface and extends HashSet class.
* LinkedHashSet maintains insertion order, so when you will be able to access elements in the order they were inserted like ArrayList.

## ArrayList

### Why to choose ArrayList vs Array:
* Array is fixed length data structure If array is full , you can not add element to it, where as ArrayList in java can dynamically grow and shrink as per our need.
* You can use generics with ArrayList but not with Array
* ArrayList have predefined methods which can be used to perform operations.

### Some important points about ArrayList in java are:
* ArrayList is implementation of list interface.
* ArrayList is not synchonized(so not thread safe)
* ArrayList is implemented using array as internal data structure.It can be dynamically resized .
* ArrayList increases half of its size when its size is increased.

***ArrayList default size.

When you create an object of ArrayList in Java without specifying a capacity, it is created with a default capacity which is 10. 
Since ArrayList is a growable array, it automatically resizes when the size (number of elements in array list) grows beyond a threshold.

Technically, it's 10, not zero, if you admit for a lazy initialisation of the backing array. See:

```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);
    elementData[size++] = e;
    return true;
}
```

```java
private void ensureCapacityInternal(int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    ensureExplicitCapacity(minCapacity);
}
```

## Hashtable Vs HashMap

Parameter | Hashtable | HashMap
--------- | --------- | --------
ThreadSafe | Yes | No
Synchronized | Yes | No
Performance | Due to theadSafe and Synchronized,it is often slower than HashMap | In single threaded environment, it is much faster than Hashtable.So if you do not work in multi thread environment ,then hashMap is recommended
Null key | Do not allow | Allows null key as well as values
Fail fast | enumeration in hashtable is not fail fast | Iterator in hashMap is fail fast
Extends | It extends Dictionary class which is quite old | It extends AbstractMap class
Alternative | No alternative | You can use ConcurrentHashMap for multi thread environment

### Some important points need to be discussed.

Synchronized means only one thread can modify one table at one point of time. When any thread performs update operation on hashtable then it acquires lock on it and other threads have to wait for lock to be released.
Fail-fast iterator means if one thread is iterating over hashmap and other thread trying to modify hashmap structurally it will throw ConcurrentModification Exception and fail immediately. Structurally modification means inserting or deleting elements that can change the structure of map.

### Can we synchronize HashMap?
Yes, We can synchronized a HashMap also with the help of Collections.synchonizedMap(hashmap) so HashMap can be synchronized by
```java
 Map map=Collections.synchonizedMap(hashmap)
```



