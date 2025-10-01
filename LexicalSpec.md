# Lexical Specification for Scat Language


## Lexical Grammar
NUMBER         → DIGIT+ ( "." DIGIT+ )? ;  
STRING         → "\"" <any char except "\"">* "\"" ;  
IDENTIFIER     → ALPHA ( ALPHA | DIGIT )* ;  
ALPHA          → "a" ... "z" | "A" ... "Z" | "_" ;  
DIGIT          → "0" ... "9" ;  
BOOLEAN        → "true" | "false" ;  

## Keywords
Scat(replaces Print)  
While  
If  
For  
Var  
Zip  
OR  
AND  
function  
class 
true
false

## Symbolic Operators
==, >=, <=, !=, <, >, !, =  

## Example Programs
```
Var X = 23;  
Scat(X);  
```
```
For(Var z = 0; z <= 3; z+=1) {  
    Scat("Mumble");  
}  
```
```
Var Dance = false;
fun dance(Var text) {  
    Scat("Dance: " + text);  
    Dance = true;  
}  
```
```
class Holder {  
    init() {  
        Var x = 10;  
        Scat(x);  
    }  
}  
```
```
Var questionmark = zip;  
If (queeestionmark == zip OR (questionmark > 1 AND questionmark < 1)) {  
    Scat("What is the question?");  
}  
```
