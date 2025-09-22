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
