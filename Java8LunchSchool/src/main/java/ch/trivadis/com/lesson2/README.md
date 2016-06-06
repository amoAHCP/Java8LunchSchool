# Lesson 2: lambda expressions

## Types of lambdas (step 1):
1.) Lambdas with no input and no output: like Runnable
2.) Lambdas with no output but input: like Consumer
3.) Lambdas with no input but output: like Supplier
4.) Lambdas with input and output: like Function
5.) Lambdas with many parameters: Consumer & Function can have more than one input


## functional interfaces and "custom" lambdas (step 2)
- Consumers and Functions can have as many parameters as you want (but each method signature needs a separate Interface)  -> BiConcumers, TriFunctions....
- @FunctionalInterface is a simple marker annotation for the javac compiler and your IDE to ensure, that only one abstract method is present... otherwise someone can add an other method and your code (lambda) will break
- Interfaces with @FunctionalInterface can have only one abstract method, BUT as many default methods you like
  
  
## structural equality problem (step 3)
- since all lambdas are mapped to one of the five (see step 1) method types, your lambdas can have the same structure although the are (semantically) different
 
## creating builder for you Objects by the help of lambdas (category: nice to know)  (step 4)
- Builders using lambdas, are a nice and short way to create immutable classes
- Background: when working in functional sytle you should avoid mutable classes, when you parallelize your code you simply avoid side effects
- Disadvantage: you can build only linear, you can't have choices in any step when dealing with plain lambda builder   