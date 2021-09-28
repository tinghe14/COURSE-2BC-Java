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
```
**Block B**
```diff
+1. Decomposition and design; defining and excuting subroutines. Variable scoping rules and passing mechanisms will also be covered
```
```diff
+2. Fudamental concepts and applications of one dimensional arrays and file I/O in Java
```
```diff
+3. Two dimensional arrays (matrices) and common usage patterns for arrays
```
**Block C**
```diff
+1. Defiing and using simple classes in Java
```
```diff
+2. Classes with arrays, arrays of objects, advanced class implementation and usage
```
```diff
+3. recursion
```
**Block D**
```diff
+1. polumorphism to include inheritance, overloading, overriding, use of super
```
```diff
+2. exception handling in java
```
```diff
+3. sorting and searching algorithms, alhorithmic time complexitiy
```
