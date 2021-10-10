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
 * ArrayLists of Objects
 * Is-a versus has-a relationships
```diff
+2. exception handling in java
```
```diff
+3. sorting and searching algorithms, alhorithmic time complexitiy
```
