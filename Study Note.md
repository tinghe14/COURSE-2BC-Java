**Block A**
```diff
+1. Fundamental programming concepts and constructs in the Java language 
```
* erros: syntax error and logic error (catached by complier or not)
```diff
+2. Java data types and their operations, selected APT usage, and program development in jGRASP
```
* data types:
  * numeric data type:
    * integer 
      * byte myVar: 8 bits
      * short myVar: 16 bits
      * int myVar: 32 bits
      * long myVar: 64 bits
    * floating point
      * float myVar: 32 bits
      * double myVar: 64 bits
    * binary: a processor stores a number using base 2
    * operations: 
      * Math class: sqrt(x), pow(x,y),abs(x)
      * type conversions: (int),(double)
    * errors:
      * store a variable greater than 2 billion into an int variable
      * floating-point comparision: shouldn't use ==, some floating-point number can't be exactly represented in the limited avaiable memory bits like 64 bits. using math.abs(x-y) <0.0001 or small epsilon
  * non-numeric data type：
    * char
      * single quote
    * strings
      * double quote
    * errors:
      * to use double quotes around a character literal
    * others:
      * common escape sequences: \n, \t, \' single auote, \'' double quote, \\ backslash; string id consided immutable
      * getting strings from input:
        * whitespace character defines as a character used to represent horizontal and vertical spaces in text, including spaces, tabs and newline character
        * without whitespaces: automatically skips initial whitespace then gets characters until the next whitespace is seen, userString = scnr.next()
        * with whitespaces: getting an entire line into string, userString = nextLine()
      * operations:
        * s1.length()
        * + operator, the same as, s1.concat(s2)
        * s1.indexOf(item): get the index of the first item occurence in a string, else -1
        * s1.indexOf(item, indx): starts at index indx
        * s1.lastIndexOf(item): find the last occurance of the itetm in a string, else -1
        * s1.substring(startindex) returns substring starting at startinex
        * s1.substring(startindex, endindex)
        * s1.replace(findstr, replacestr)
        * comparing two strings using the notation str1.equals(str2)/str1.compareTo(str2). [str1==str2 compares the strings' addresses, rather than the strings' contents]
  * constant variables: final datatype UPPER_CASE_LETTER (seperated by underscore)
  * Oracel's Java API: (class documentation):
    * one page of API contains:
      * all java modules: a module is a group of related packages, a packages is grould of related classes
      * contructor summary: provide a list of the constructors that can be used to create objects of the class
      * method summary: provides a list pf methods that can be called on objects of the class
```diff
+3. Simple control flow constructs for decision and repetition, including boolean expressions
```
* logical operators: &&, ||, !
```diff
+4. Nested control flow and altenative construct for selection (switch) and repetition (for, do/while) in Java
```
* loops:
  * while loop: loop body is the loopshould iterature
    * common error: to create a infinite loop, often by forgetting to update a variable in the body, or by creating a loop expression whose evaluation to false isn't always reachable
  * switch statements:
    * multi-branch: switch (a) {case 0: dosomething; break; case 1: dosomething; break; default: dosomething; break;}
      * common error: omit the break statement. without it it will cause the statements withint hte next case to be executed
    * multi-branch if else: if (){} else if (){} else {}
    * for loop: for (i=0; i<n, ++i) {}
    * break and continue:
      * break in a loop causes an immediate exit of the loop
      * continue in a loop causes an immediate jump to the loop condition check
    * do while loop: do {} while ();    

**Block B**
```diff
+1. Decomposition and design; defining and excuting subroutines. Variable scoping rules and passing mechanisms will also be covered
```
* primitive and reference types
  * wrapper class:
    * primitive type: directly stores the data for that variables type
    * reference type: refer to an instance of a class, aslo known as an object
      * many of java's built-in class, such as java's collection library only work with objects, for example 
        * a programmer can create an arraylist containing integer elements, ArrayList<Integer> frameScores but not an ArrayList of int elements 
  * memory allocation:
    * a wrapper class object is immutable. we cannot change the object via methods or variable assignment after object creation
    * everytime a new value is assigned to an integer variable, memory for a new integer object with the value is allocated, and the reference (or address) of this new object is assigned to the reference variable
  * wrapper class allows the program to create objects that store a single primivate type value, also provide methods for converting between primitive types (int to double), between number system (decimal to binary)
    * wrapper class conversions:
      * autoboxing: automatic conversion of primitive types to the corresponding wrapper class
      * unboxing: automatic conversion of wrapper class objects to the corresponfing primitive types
        * num.IntValue(), num.doubleValue(), num.longValue()
      * converting reference type to and from strings:
        * serveral of these methods are static methods, meanings they can be called by a program without creating an object. To call a staitic methods, the name of the class and a '.' must precede the static method name, such as Integer.toString(16);
        * someInteger.toString = Integer.toString(someInteger), Integer.paseInt(someInteger), Integer.valueOf(someInteger), Integer.toBinaryString(someInteger)
  * common error:
    * logic error using == != to compare reference variables of wrapper classes, and should use equals() and compareTo() method
* character operations: isLetter(), isDigit(), isWhitespace()
* Random numbers:
  * Random randGen = new Random(); // new random number generateor
  * randGen.nextInt(2); // yield 2 possible values 0 and 1;
  * Random randGen = new Random(15); // using the same seed for each program run
* user-defined method basics
  * methods: program reduendancy can be reduced by creating a grouping of predefinded statements for repeatedly used operations, known as method
    * method definition: consist of new method's name and a block of statments: public static double calcPizzaArea() {/* block of statement */}
      * a method call is an invocation of a method's name; a method must be defined within a class
      * access modifier: public static
        * public indicates the method may be called from any class in the program
        * static indicates the methods only uses values that passed to the method
      * returning a value of a method
        * a method can only return one time
        * a return type of void indicates that a method does not return any value
      * parameters:
        * a parameter is a method input specified in a method definition
        * an arugument is a value provided to a method's parameter during a method call
          * a parameter is like a variable declaration. upon a call, the parameter's memory location is allocated, and the parameter is assigned with the argument's value. upon returning to the original call location, the parameter is deleted from the memory
        * a method definition with no parameter must still have the paretheses
      * void method: the void keyword indicates a method does not return a value
      * reasons for defining methods:
        * modular and incremental program development
          * modular development is the process of dividing a program into separate modules that can be developed and tested separately and then integrated into a single program
          * incremental development is a process in which a programmer writes, compile, and tests a small amount of code, then writes, complies and tests a small amount more, and so on
    * memory allocation:
      * each method call creates a new set of local variables, each return causess those local variables to be discarded.
    * method name overloading or method overloading:
      * a program has two methods with the same name but differing in the number of types of parameters
    * common error: the name of a defined variable or method item is only visible to part of a program, know as the item's scope. a variable declared in a method has scope limited to inside that method. in fact, because a compiler scans a program line-by-line from top-to-bottom, the scope starts after the declaration until the method's end.
* unit testing
  * good practice is to test small parts of the program individually, before testing the entire program, typically a method
  * a unit tset is typically conducted by creating a testbench, aka test harness 
  * manually examining a program's printed output is cumbersome and error prone. A better test harness would only print a message for incorrect output. eg: assert is an operator that prints an error message and exits the program if the provided test expression evaluates to false. having the form:
    * assert testExpression: "detailedMessage";
    * note that assertions are not enabled by default. a programmer must execute java programs with additional command-line options in order to enable assertions, such as java -ea class name
    * a good test vectors also include border cases that represent fringe scenario. for example. border cases for the above method might include inputs 0 and 9999999 (huge number). the programmer tries to think of any extreme (or weird) inputs that might cause the method to fail.
* using scanner in method:
  * a program should only use one Scanner per input stream. Internally, a Scanner object may read more input than needed to make subsequent reads faster. Thus, using multiple Scanner for the same input stream may lead to unexpected result.
* Java documentation for methods
  * Javadoc is a tool that parses specially formatted multi-line comments to generate program documentatin in HTML format. The program documentation is also known as an API (application programming interface). This doc comment begins with /** and end with */. Two asterisks distinguish doc comments from regular comments.
```diff
+2. Fudamental concepts and applications of one dimensional arrays and file I/O in Java
```
* simple arrays
* Scanner method
* file I/O
```diff
+3. Two dimensional arrays (matrices) and common usage patterns for arrays
```
* Advanced arrays
 
**Block C**
```diff
+1. Defiing and using simple classes in Java
```
* simple class
* unit testing
```diff
+2. Classes with arrays, arrays of objects, advanced class implementation and usage
```
* advanced class
* arraylist
```diff
+3. recursion
```
* recursive subroutines
 
**Block D**
```diff
+1. polymorphism to include inheritance, overloading, overriding, use of super
```
 * Derived classes
   * Derived class concept: one class is similar to another class but with some additions or variations
   * Inheritance:
     * base class (superclass)
     * derived class (subclass)
     * derived class is a class that is derived from another class
     * inhertiance: the derived class inherit the properties of the base class
     * an object declared of a derived class type has access to all the public members of the derived class as well as the public members of the base class
     * a derived class is declared by placing the keyword extends after the derived class name, followed by the base class name.
       * Eg: class DerivedClass extends BaseClass {...}
   * inheritance scenarios:
     * a derived class can serve as a base class for another class
     * a class can serve as a base class for multiple derived classes
     * a class can only be derived from one base class directly (otherwise, compiler error)
 * access by members of derived class
   * member access
     * the members of a derived class have access to the public memebers of the base class, but not to the private members of the base class
   * protected member access
     * recall that members of a class may have their access specificed as public or private. a third access specifier is protected
     * protected: provides access to derived classed and all classes in the same package but not by anyone else
       * no specifier access specifier: accessible by self and other classes in the same package
 * Overriding memeber methods
   * overriding
     * when a derived class defines a memeber method that has the same name and parameters as a base class's method, the member method is said to override the base class's method
     * @override annotation is placed above this method so the compiler verifies that an identical base class method exists (optional)
       * the @override annotation causes the compiler to produce an error when a programmer mistakenly specifies parameters that are different from the parameters of the method that should be overridden or misnames the overriding method
     * overriding vs overloading
       * overloading: methods with the same name must have different parameter types
       * overriding: a derived class member method take precedence over a base class memeber method with the same name and parameter types
   * calling a base class method
 * Polymorphism
   * polymorphism: refers to determining which program behavior to execute depending on data types
     * compile-time polymorphism: method overloading is a form of compile-time polymorphism wherein the compiler determines which of several identically-named methods to call based on the method's arguments
     * runtime polymorphism: wherein the compiler can't make determination but instrad the determination is made while the program is running 
       * it dynamically determines the correct method to call based on the actual object type to which the variable (or element) refers.
 * ArrayLists of Objects
   * because all classes are derived from the Object class, programmers can take advantage of runtime polymorphism in order to create a collerction (e.g., ArrayList) of objects of various class types and perform operations on the elements
   * ArrayList<Object> objList = new ArrayList<Object>();
 * Is-a versus has-a relationships
   * The concept of inheritance is commonly confused with the idea of composiution. composition is the idea that one object may be made up of other objects, such as a MotherInfo class being made up of objects like firstName (which may be a String object), childrenData (which may be an ArrayList of ChildInfo objects), etc. Defining that MotherInfo class doesn't involve inheritance, but rather just composing the sub-objects in the class.
     * composition contains the 'has-a' relationship
     * inheritance contains the 'is-a' relationship. A MotherInfo object 'is a' kind of PersonInfo. The MotherInfo class thus inherits from the PersonInfo class.
   * UML diagrams: programmers commonly draw class inheritance relationships using UML notation
```diff
+2. exception handling in java
```
* exception basics: error-checking code is code a programmer writes to detect and handle errors that occur during program execution. An exception is a circumstance that a program was not designed to handle, such as if the user enters a negative heigt
  * exception-handling constructs: the language has special constructs, try, throw and catch to keep error-checking code separate and to reduce redundant checks. 
    * try { ... throw objectOfExceptionType; ...} catch (exceptionType excptObj) {//handle exception, eg print message}
      * try: a try block surrounds normal code, which is exited immediately if a throwe statement executes
      * throw: a throw statement appears within a try block; if reached, execution jumps immediately to the end of the try block. the code is wrriten so only error suitations lead to reaching a throw. the throw statement provides an object of type Throwable, such as an object of type Exception or its subclasses. the statement is said to throw an exception of the particular type. A throw statement's syntax is similar to a return statement
      * catch: a catch clause immediately follows a try block; if the catch was reached due to an exception thrown of the catch clause's parameter type, the clause executes. the clause is said to catch the thrown exception. A catch blockj is called handler because it handles an exception
      * the object thrown and caught must be of the Throwable class type, or a class inheriting from Throwable. As discussed elsewhere, Java offers several built-in Throwable types like Error, Exception, and classes derived from these. The Exception class (and other Throwable types) has a constructor that can be passed a String, as in throw new Exception("Invalid weight."); which allocates a new Exception object and sets an internal String value that can later be retireved using the getMessage() method, as in System.out.println(excpt.getMessage())
  * common exception types:
    * EOFException: end of file or end of stream has been reached unexpectedly during input
    * InputMismatchException: Received input doesn't match excepted type or input is out of range for the expected type (thrown by Scanner)
    * ArrayIndexOutOfBoundsException: an array has been accessed with an illegal index
    * FileNotFoundException: attempt to open a file denoted by a filename failed
    * ArithmeticException: Arithmetic condition fialed
* exceptions with methods
  * the power of exceptions becomes clearer when used within a method. if an exception is thrown within a method and not caught within that method, then the method is immediately exited and calling method is checked for a handler, and so on up the method call hierarchy.
    * suppose getWeight() throws an exception of type InputMismatchException. GetWeight() immediately exits, up to main() where the call was in a try block, so the catch block catches the exception
    * if a method throws an exception not handled within the method, a programmer must include a throws clause within the method declaration, by appending throws Exception before the opening curly brace. Java requires that a programmer either provides an exception handler or specifies that a method may throw an exception by appending a throws clause to all methods that may throw checked exceptions
* multiple handlers
  * different throwsa in a try block may throw different exceptions types. Multiple handlers may exist, each handling a different typoe. the first matching handler executes; remaining handlers are skipped
    * catch (Throwable thrwObj) is a catch-all handler that catches any error or exception as both are derived from the Throwable class this handler is useful when listed as the last handler
  * common error: is to place a catch block intended to handle exceptions of a base class before catch blocks intended to handle exceptions of a derived class, resulting in a compiler error with a message such as "exception has already been caught"
* exception handling in file input/output
  * Most FileReader methods and constructors throw exceptions of type IOException (eg, input/output exception), a built-in checked exception ionheriting from the Exception class. Specifically, read() may throw an IOException if an error is encountered while reading the file, and close() may throw an IOException if an error occurs while attempting to close the file. FileReader's constructors may throw a FileNotFoundException, which itself inherits from IOException, if the specified file can't be opened for reading
  * a good practice is to use finally blocks for coide that should be executed both when the program executes normally and when the program throws an exception, such as closing files that are opened and accessed within a try block
  * the following is a good version, using a finally block to ensure that the input stream and file are always closed. The code within the try block opens a file and reads characters from that file. if an error occurs while reading from the file, an IOException will be thrown, and the catch block will report the exception. The finally block executes after the try and catch blocks have finished execution calling closeFileReader(), which will close the file. As an exception may be thrown while closing a file, the closeFileReader() method also includes try and catch blocks.
 ![image](https://github.com/tinghe14/COURSE-2BC-Java/blob/main/Picture/finally.png)
  * writing to a file with exception handling
 ![image](https://github.com/tinghe14/COURSE-2BC-Java/blob/main/Picture/writing%20a%20file.png)
```diff
+3. sorting and searching algorithms, alhorithmic time complexitiy
```
