# Lesson 4: Working with Streams

##  Streams are no Collections!!! --> the are (lazy) representations (views) of a stream
- Example: List[a,b,ca,d,ae,f,ag] --> filtered stream -> [a,ca,ae,ag,[a,b,ca,d,ae,f,ag]]
- When dealing with Streams you never change the underlying collection
- since streams are lazy, any no-terminal operation will be started, when a terminal operation is initiated  

## Streams distinguish between terminal and non-terminal operations (step 1)
- terminal operations: return either void or a non-stream result (like forEach)
- non-terminal: return a stream to proceed the work

## findFirst vs. findAny   (step 2)
- findAny is to give a more flexible alternative to findFirst(). If you are not interested in getting a specific element, this gives the implementing stream more flexibility in case it is a parallel stream.

## Collectors (step 3)
- Collectors can convert (collect) all elements of a stream to Collections, Map,.... 
- there are many static default collectors provided by Java, writing own collectors can be tricky 
 
## be aware of parallel Streams
- can lead to non-deterministic results (Example: find first element with certain conditions while the result set of you condition is >1) 
- outer members must be effectively final (also appears to sequential streams)... if you try to bypass this restriction by using constructs like "ResultObject[] r = new ResultObject[1];" you should be aware of typical concurrency and visibility issues
- using parallel streams in parallel streams (nested stream) is a really bad idea... why? because there is only one underlying fork-join pool 
- you can switch between parallel and sequential execution at any time