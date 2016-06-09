# Lesson 5: CompletableFuture 

Next to lambda support, it is one of the most interesting features in Java 8 . BUT ... with it's fifty methods, it's not the easiest one. CompletableFuture is the first (native) step into reactive programming in JDK.

## allows blocking and non-blocking execution
 
## takes a custom Executor on async execution
- if no custom Executor provided, the default ForkJoin Executor is used.... the same Executor as for parallel Streams --> avoid using parallel streams, and (many) async CompletableFutures in parallel on the same Executor.


## be aware in transactional environments like Java EE or Spring
- *async operations run on ForkJoin- or CustomExecutor  -> your transaction runs (mostly) on Request Thread -> your transaction will not work correctly
- non-async operations run on caller thread -> if your caller thread is the Request thread your transaction will work -> if the caller thread is something else you'll fail!
