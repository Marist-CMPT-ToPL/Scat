# Lexical Specification for Scat Language


## Grammar
NUMBER         → DIGIT+ ( "." DIGIT+ )? ;  
STRING         → "\"" <any char except "\"">* "\"" ;  
IDENTIFIER     → ALPHA ( ALPHA | DIGIT )* ;  
ALPHA          → "a" ... "z" | "A" ... "Z" | "_" ;  
DIGIT          → "0" ... "9" ;  
BOOLEAN        → "true" | "false" ;  

## Expression and Statement  
function       → IDENTIFIER "(" parameters? ")" block ;  
parameters     → IDENTIFIER ( "," IDENTIFIER )* ;  
arguments      → expression ( "," expression )* ;    

statement      → exprStmt  
               | forStmt  
               | ifStmt  
               | printStmt  
               | returnStmt  
               | whileStmt  
               | block ;  

exprStmt       → expression ";" ;  
forStmt        → "for" "(" ( varDecl | exprStmt | ";" )  
                           expression? ";"  
                           expression? ")" statement ;  
ifStmt         → "if" "(" expression ")" statement  
                 ( "else" statement )? ;  
printStmt      → "print" expression ";" ;  
returnStmt     → "return" expression? ";" ;  
whileStmt      → "while" "(" expression ")" statement ;  
block          → "{" declaration* "}" ;  
  
## Keywords
Scat(replaces Print)  
While  
If  
For  
Var  
Zip  
Or  
And  
function  
class   

## Symbolic Operators
==, >=, <=, !=, <, >, !, =  
