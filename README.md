# pl_2022_mabuti
This is a repository for my laboratory activities in Theory of Programming Languages. Most of these activities focus on the first three phases of the compilation process (lexical, syntax, and semantic analyzer).

### Lab Activity 1: Palindrome Checker
A simple string manipulation exercise to test for palindromes or words and sentences that can still be spell the same when reversed. I've used regular expressions to ignore all special characters. 

### Lab Activity 2: Deterministic Finite Automaton (DFA)
Is a short refresher of DFA, and how it can be written in code.
Here is the given automaton as a basic example:
![[Pasted image 20221107175953.png]]

### Lab Activity 3: Lexical Analysis - Tokenizer
A basic lexer that will extract lexemes from a single line input. This program only accounts for the assignment operator, identifier, data type, value, and delimiter ";". A brief explanation of how mine works; A user will input a string, the string will be shredded into individual characters, those individual characters (still as String objects) will be rebuilt back into words, then finally the words will be categorized into tokens.  
![[Pasted image 20221107180754.png]]

### Lab Activity 4: Syntax Analysis - Parser
After the tokenization process or the lexical analysis, each tokens are passed into a syntax analyzer or a parser to determine whether the syntax is valid or invalid. This parser only accounts for two correct syntaxes which are; "data_type identifier delimiter", and "data_type identifier assignment_operator value delimiter". This is checked by running a loop to check if the passed argument (tokens) are in the correct order.

### Lab Activity 5: Semantic Analysis - Semantic Analyzer
After the parser determines if the syntax is valid, the lexemes will be passed into the semantic analyzer. The semantic analyzer makes sure that the declarations and statements have correct meaning or are semantically correct. This semantic analyzer specifically looks at variable assignment in which the assigned values should correctly match the given data_type e.g., int x = 1; is correct, int x = 1.0 is incorrect. I've used a try block to see if the assigned values correspond to their supposed data_type. 

**The flow:** 
> A string is passed into the lexer, the lexer returns lexemes, the lexemes are passed into the tokenizer, the tokenizer returns tokens, the tokens are passed into the parser, the parser determines if the syntax is correct, if it is then the semantic analyzer will accept the lexemes and determine whether it is semantically correct or incorrect.