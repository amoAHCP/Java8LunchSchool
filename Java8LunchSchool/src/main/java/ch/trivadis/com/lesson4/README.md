# Lesson 4: Working with Streams

##  Streams are no Collections!!! --> the are (lazy) representations (views) of a stream
- Example: List[a,b,ca,d,ae,f,ag] --> filtered stream -> [a,ca,ae,ag]
- When dealing with Streams you never change the underlying collection
 
## be aware of parallel Streams
- can lead to non-deterministic results (Example: find first element with certain conditions while the result set of you condition is >1) 
- outer members must be effectively final (also appears to sequential streams)... if you try to bypass this restriction by using constructs like "ResultObject[] r = new ResultObject[1];" you should be aware of typical concurrency and visibility issues
- using parallel streams in parallel streams (nested stream) is a really bad idea... why? because there is only one underlying fork-join pool 