# Lexical Specification for Scat Language


## Grammar
NUMBER         → DIGIT+ ( "." DIGIT+ )? ;
STRING         → "\"" <any char except "\"">* "\"" ;
IDENTIFIER     → ALPHA ( ALPHA | DIGIT )* ;
ALPHA          → "a" ... "z" | "A" ... "Z" | "_" ;
DIGIT          → "0" ... "9" ;

## Keywords
Scat(replaces Print) 
While
If
For
Var
Zip
Or
And

## Symbolic Operators
==, >=, <=, !=, <, >, !, =
